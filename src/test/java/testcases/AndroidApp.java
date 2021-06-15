package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class AndroidApp extends TestConfigurations {


    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_Sanity(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to Validate new site in android app");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_CheckIn(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to Validate new site in android app");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_IssueTracker(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to validated reported issue and resolved it");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_CreateAdHocIssue(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to Create a new issue ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_UI(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to Create a new issue ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_Profile(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to Create a new issue ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_CreateAdHocIssueYellowFlag(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to Create a new issue wit Yellow flag ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_FilterIssueBySite(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to verify User is able to filter by By Issue ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_FilterIssueByDepart(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to verify User is able to filter by By Issue ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }


    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_FilterIssueByRedFlag(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to verify User is able to filter issues by Red Flag ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "ANDROID", dataProviderClass = TestConfigurations.class)
    public void tc_Android_App_FilterIssueByYellowFlag(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to verify User is able to filter issues by Yellow Flag ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
}

