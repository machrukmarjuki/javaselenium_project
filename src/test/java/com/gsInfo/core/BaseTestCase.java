package com.gsInfo.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.gsInfo.framework.*;
import com.gsInfo.framework.selenium.ResultSummaryManager;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Abstract base class for all the test cases to be automated
 *
 * @author GSInfo
 */
public abstract class BaseTestCase {
    /**
     * The current scenario
     */
    protected String currentScenario;
    /**
     * The current test case
     */

    /**
     * The {@link Properties} object with settings loaded from the framework
     * properties file
     */
    protected Properties properties;
    protected String currentTestcase;

    private ResultSummaryManager resultSummaryManager = ResultSummaryManager.getInstance();

    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentReports extentReport;
    protected static ExtentTest extentTest;

    protected static String TEST_STATUS;

    public static int countReRunFailedTestCase = 1;
    public static boolean rerun = false;
    public static int rerunCounter = 0;
    public static boolean sResponseMessage;

    public static int getCounter() {
        return rerunCounter;
    }

    public static void updateCounter() {
        rerunCounter++;
    }

    public static boolean getRerun() {
        return rerun;
    }

    public static void toggleRerun() {
        rerun = !rerun;
    }

    public static void updateReRun() {
        rerun = true;
    }

    public static long RUN_ID;


    /**
     * Function to do the required framework setup activities before executing the
     * overall test suite
     *
     * @param testContext The TestNG {@link ITestContext} of the current test suite
     */
    @BeforeSuite
    public void setUpTestSuite(ITestContext testContext) {
        resultSummaryManager.setRelativePath();
        resultSummaryManager.initializeTestBatch(testContext.getSuite().getName());

        int nThreads;
        if ("false".equalsIgnoreCase(testContext.getSuite().getParallel())) {
            nThreads = 1;
        } else {
            nThreads = testContext.getCurrentXmlTest().getThreadCount();
        }

        // Note: Separate threads may be spawned through usage of DataProvider
        // testContext.getSuite().getXmlSuite().getDataProviderThreadCount();
        // This will be at test case level (multiple instances on same test case
        // in parallel)
        // This level of threading will not be reflected in the summary report

        resultSummaryManager.initializeSummaryReport(nThreads);
        resultSummaryManager.setupErrorLog();
        generateExtentReports();
        properties = Settings.getInstance();
        String save = properties.getProperty("SaveDataToTestRail");
        if (save.equals("true")) {
            RUN_ID = (long) createTestRun();
        }
    }

    /**
     * Function to do the required framework setup activities before executing each
     * test case
     */
    @BeforeMethod
    public void setUpTestRunner() {
        FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
        if (frameworkParameters.getStopExecution()) {
            tearDownTestSuite();

            // Throwing TestNG SkipException within a configuration method
            // causes all subsequent test methods to be skipped/aborted
            throw new SkipException("Test execution terminated by user! All subsequent tests aborted...");
        }
    }

    /**
     * Function to do the required framework teardown activities after executing
     * each test case
     *
     * @param testParameters The {@link SeleniumTestParameters} object passed from
     * the test case
     * @param driverScript   The {@link CoreScript} object passed from the test
     * case
     */

    public static List<String> failedTestCase = new ArrayList<String>();
    public static String currentPacakage;
    public static String currentTestCase;

    protected synchronized void tearDownTestRunner(SeleniumTestParameters testParameters, CoreScript coreScript) {
        TestCaseBean testCaseBean = coreScript.getTestCaseBean();
        String testReportName = coreScript.getReportName();
        String executionTime = coreScript.getExecutionTime();
        String testStatus = coreScript.getTestStatus();

        TEST_STATUS = testStatus;// Added this code to extract test case status for linking e2e automation

        //    resultSummaryManager.updateResultSummary(testParameters, testReportName, executionTime, testStatus);
        Properties properties = Settings.getInstance();
        String save = properties.getProperty("SaveDataToTestRail");

        if (save.equals("true")) {
            resultSummaryManager.postResultToTestRail(testCaseBean, testStatus, executionTime, testParameters.getCurrentTestcase(), RUN_ID);
        }
        /* DB-Updating reports to database */

        currentPacakage = testParameters.getCurrentScenario();
        currentTestCase = testParameters.getCurrentTestcase();
        if ("Failed".equalsIgnoreCase(testStatus)) {
            failedTestCase.add(
                    "testscripts." + testParameters.getCurrentScenario() + "." + testParameters.getCurrentTestcase());
            Assert.fail(coreScript.getFailureDescription());

        }
    }

    /**
     * Function to do the required framework teardown activities after executing the
     * overall test suite
     */
    @AfterSuite
    public void tearDownTestSuite() {
        resultSummaryManager.wrapUp(true);
        extentReport.flush();
        resultSummaryManager.launchResultSummary();

    }

    /**
     * Function to set Extent Report Path within Framework and initialze extent
     * objects
     */
    private void generateExtentReports() {
        Properties properties = Settings.getInstance();
        htmlReporter = new ExtentHtmlReporter(resultSummaryManager.getReportPath() + Util.getFileSeparator()
                + "Extent Result" + Util.getFileSeparator() + "ExtentReport.html");
        extentReport = new ExtentReports();
        extentReport.attachReporter(htmlReporter);
        extentReport.setSystemInfo("Project Name", properties.getProperty("ProjectName"));
        extentReport.setSystemInfo("Framework", " Maven");
        extentReport.setSystemInfo("Framework Version", "3.2");
        extentReport.setSystemInfo("Author", "Gopesh");

        htmlReporter.config().setDocumentTitle(" Extent Report");
        htmlReporter.config().setReportName("Extent Report for Automation");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

    }


    public long createTestRun() {

        APIClient client = new APIClient("https://hellonimbly.testrail.io");
        client.setUser("gopesh@hellonimbly.com");
        client.setPassword("Nimbly@123");//get_sections/:4&suite_id=:1
        JSONArray sectionList = null;
        try {
            long runId = 0;
            sectionList = (JSONArray) client.sendGet("get_sections/1&1");
            ArrayList casesID = new ArrayList();
            for (Object jobj : sectionList) {
                HashMap<String, Object> jMap = (HashMap<String, Object>) jobj;
                for (String key : jMap.keySet()) {
                    if (key.equals("name")) {
                        String name = (String) jMap.get("name");
                        if (name.equals("Smoke")) {
                            long section_id = (long) jMap.get("id");
                            System.out.println(section_id);
                            JSONArray cases = (JSONArray) client.sendGet("get_cases/1&1&section_id=" + section_id);
                            System.out.println(cases);
                            for (Object obj : cases) {
                                HashMap<String, Object> caseMap = (HashMap<String, Object>) obj;
                                long caseID = (long) caseMap.get("id");
                                int cId = (int) caseID;

                                casesID.add(cId);

                            }
                            break;

                        }

                    }
                }

            }
            Map<String, Object> addRunMap = new HashMap<>();
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String buildInfo = System.getProperty("BuildName");
            if (buildInfo == null) {
                buildInfo = properties.getProperty("BuildName");
            }

            addRunMap.put("suite_id", 1);
            addRunMap.put("name", "Auto_Test_RUN_" + buildInfo + "_" + date);
            addRunMap.put("include_all", false);
            addRunMap.put("case_ids", casesID);


            JSONObject addRun = (JSONObject) client.sendPost("add_run/1", addRunMap);
            return runId = (long) addRun.get("id");
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        } catch (APIException e) {

            e.printStackTrace();
            return 0;

        }
    }


}