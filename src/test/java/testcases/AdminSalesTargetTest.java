package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.Browser;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class AdminSalesTargetTest extends TestConfigurations {

	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1123_ToVerifyNavigationToSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("To verify navigation to Sales Target Page");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1124_ToVerifyUIofSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("To verify the UI of Sales Target Page");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1125_ToVerifyWhetherUserCanCreateVariousSalesTargetForDifferentMonthAndYear(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("To Verify whether user can create various Sales Target for different months and Years.");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1126_ToVerifySortingBySiteInSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify sorting functionality for the display up/down icons of Site Field");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1127_ToVerifySortingByDepartmentInSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify sorting functionality for the display up/down icons of Department Field");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1128_ToVerifySortingByAssignedAuditorsInSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify sorting functionality for the display up/down icons of Assigned Auditors Field");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1129_ToVerifySortingByTotalSalesMadeInSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify sorting functionality for the display up/down icons of Total Sales Made Field");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1130_ToVerifySortingBySalesTargetInSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify sorting functionality for the display up/down icons of Sales Target Field");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1131_ToVerifySortingByProgressInSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify sorting functionality for the display up/down icons of Progress Field");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1132_ToVerifyPaginationFunctionalityOfSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the pagination functionality of Sales Target page.");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1133_ToVerifyEditFunctionalityAndEditSalesPopupOfSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the Edit functionality& Edit sales popup window of Sales Target fields.");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1134_ToVerifyViewDetailsButtonAndAddFieldInViewDetailsSection(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the View Details button & Add field in view details section.");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1135_ToVerifyDltSalesInSaleDetailsPopup(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the delete field in updated fields of View details section.");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1136_ToVrfyTotallSalesMadeAndProgressAfterUpdatingSalesDetail(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify Total sales made and Progress fields after updating view details section");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1137_ToVerifySearchFunctionalityUsingSiteNameInSalesTargetPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the Search functionality for site name field.");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1138_ToVerifyCancelFunctionalityEditSalesPopupWindow(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the cancel functionality in Edit sales popup window.");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1140_ToVerifySaleDetailsInSalesDetailsPopup(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the sales details by clicking on View Details button");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1141_ToVerifyUserCanAddSaleDetailsForMultipleDateInSalesDetailsPopup(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify that user is able to update Sales made amount for Single date and Multiple dates by clicking on View Details button");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1142_ToVrfySalesMadeAmountForEachDate(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("To Verify the Sales made amount for each date");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1143_ToVerifyProgressBarUpdatesCorrectlyInSalesDetailsPopup(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the Progress bar Percentage is getting updates correctly when user Update the Sales made");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1144_ToVerifyEditSalesTargetForVariousMonths(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("To Validate that user is able Edit Sales Target for Various months and it is reflecting against the Site");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
}