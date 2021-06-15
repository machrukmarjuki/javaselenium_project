package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class DashboardOverview extends TestConfigurations{

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_747_verifyFilterByDepartment(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Department is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_748_verifyFilterBySite(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by site is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterByThisWeek(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by This Week is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterByLastWeek(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Last Week is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterBy7Days(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Last 7 Days is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterBy28Days(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Last 28 Days is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterBy30Days(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Last 30 Days is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterBy90Days(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Last 90 Days is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterBy6Months(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Last 6 Months is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterBy12Months(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Last 12 Months is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterByLastYear(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Last Year is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
    public void  Tc_565_verifyFilterByMonthToDate(SeleniumTestParameters testParameters)
    {
        testParameters.setCurrentTestDescription("Test case to verify filter by Month To Date is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }


}
