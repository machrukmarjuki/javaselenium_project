package testcases;

import org.testng.annotations.Test;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;

public class DepartmentTest extends TestConfigurations {
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_260_ToverifynavigationtoDepartmentPage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation to DepartmentPage");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_261_ToVerifyElementsOfDepartmentPage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify elements of Department Page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_267_ToVerifyErrorMessageForDepartmentWithDuplicateUniqueKey(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify error message for duplicate unique key ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_268_ToVerifyErrorMessageForDepartmentWithDuplicateDepartmentName(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify error message for duplicate Department Name for New Department ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_276_ToVerifyNavigationToDepartmentGroupPage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation to department group");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_277_ToVerifyAddDepartmentGroup(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify Add Department Group Functionality");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_274_VerifyBlockAndActivationFunctionality(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify Block and Activate department Functionality");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_278_VerifyResetFunctionalityForDepartmentGroup(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify Reset Button Functionality");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_275_ToVerifyNavigationToAddDepartmentGroup(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation flow of Department Group Page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_262_ToVerifyDepartmentSearchFunctionality(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify Department Search Functionality");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_270_ToVerifyEditingExistngDepartmentWithDuplicateName(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify error message for duplicate Department Name for existing Department");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  UpdateMasterData(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Update Master Data");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  TC_279_deactivateDepartmentGroup(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify deactivation of Department Group");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  TC_280_reactivateDepartmentGroup(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify reactivation of Department Group");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
}
