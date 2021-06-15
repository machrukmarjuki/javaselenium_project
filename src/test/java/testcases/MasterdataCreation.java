package testcases;

import org.testng.annotations.Test;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;

public class MasterdataCreation extends TestConfigurations{
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  AddDepartment(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation to DepartmentPage");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  AddSite(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation to DepartmentPage");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  AddQuestionnaire(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation to DepartmentPage");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}

}
