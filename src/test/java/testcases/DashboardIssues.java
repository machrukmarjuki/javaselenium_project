package testcases;

import org.testng.annotations.Test;
import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;

public class DashboardIssues extends TestConfigurations{
	
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_861_ToVerifyNavigationToDashboardIssuesPage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation to Dashboard Issues page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_862_ToVerifyUIofDashboardIssuesPage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify the UI of Dashboard Issues page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	
}
