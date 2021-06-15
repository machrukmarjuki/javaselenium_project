package testcases;

import org.testng.annotations.Test;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;

public class NimblyPromotionTest extends TestConfigurations {
	
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  ToverifynavigationtoPromotionsPage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation to Promotions Page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  ToverifyfieldsinNewPromotionModal(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify all fields are present in new Promotion modal");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  ToVerifyCreationOfpromotionWithAllSites(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify creation of promotion with all sites");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  ToVerifyCreationOfpromotionWithCurrentDate(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify creation of promotion Send Now as date");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}

}
