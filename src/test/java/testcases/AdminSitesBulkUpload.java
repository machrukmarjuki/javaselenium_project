package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.Browser;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class AdminSitesBulkUpload extends TestConfigurations {

	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_427_VerifyTheFunctionalityOfBulkSiteUploadContainingDupliacteSites(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of Bulk Site Upload containing dupliacte sites");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_428_VerifyTheFunctionalityOfBulkSiteUploadContainingInvalidSupervisorNames(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of Bulk Site Upload containing invalid supervisor names");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_430_VerifyTheFunctionalityOfBulkSiteScheduleContainingDupliacteSchedules(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of Bulk Site Schedule containing dupliacte schedules");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
}