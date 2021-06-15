package testcases;

import org.testng.annotations.Test;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;

public class AdminSiteTest extends TestConfigurations{
	
	
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_415_ToverifynavigationToSitePage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify that user is able to navigate to Site Page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_417_ToverifySearchSiteFunctionality(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify search Site feature");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  TC_419_CreateSite(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify user is able to create site");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  TC_421_BlockCreatedSite(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify user is able to block site");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
	}  
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  TC_422_UnBlockSite(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify user is able to unblock site");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
	} 
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  TC_423_EditACreatedSite(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify user is able to edit data for a created site");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
	} 
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_425_ToverifyitemsunderbulkuploaddropdownInSitePage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify items under Site Page BulkUpload Dropdown");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_426_ToverifyBulkUploadSiteFunctionality(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify Bulk Upload Site feature");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	
}
