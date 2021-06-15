package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.Browser;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class AdminPurchaseOrderTest extends TestConfigurations {

	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_696_ToVerifyNavigationToPOPage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("To verify navigation to PO Page");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_700_ToVerifyTheFunctionalityOfCreatingPO(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of creating a PO");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_702_ToVerifyTheFunctionalityOfCreatingPOwithNoSKUadded(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of creating a PO with no SKU added");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_698_ToVerifySearchFunctionalityOfPOpage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the search functionality of PO Page");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_697_ToVerifyUIOfPOpage(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("To verify UI of PO Page");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_699_ToVerifyTheFunctionalityOfAddPurchaseOrderButton(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of Add Purchase Order button");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_701_ToVerifyFunctionalityOfCreatingPOwithMultipleSKU(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of creating a PO with multiple SKU");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_703_ToVerifyFunctionalityOfEditingPOwithInProgressStatus(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of editing a PO which is in Progress status");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_704_ToVerifyFunctionalityOfEditingPOwithDeliveredStatus(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of editing a PO which is in Delivered status");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1121_ToVerifyFunctionalityOfChangingPOstatusFromInProgressToDelivered(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of changing PO status from \"In Progress\" to \"Delivered\"");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1122_ToVerifyDateFieldsDoesNotAcceptPastDates(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("To verify that the date-picker fields in Add PO page only allows future dates");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	
	@Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
	public void TC_1120_ToVerifyFunctionalityOfSortAscendingDescendingInPOTable(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("Verify the functionality of sort ascending/descending in PO table");
		//testParameters.setBrowser(Browser.FIREFOX);
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
}