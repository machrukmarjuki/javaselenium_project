package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.Browser;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class WebAdmin extends TestConfigurations {

    @Test(groups = {"Smoke","Regression"}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_548_searchSite(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to Demo the login ");
        //testParameters.setBrowser(Browser.FIREFOX);
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_549_AddANewSite(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test case to Add a new Site ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_551_BlockSiteAndUnblock(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test case to block a new Site ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_554_ScheduleSite(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test case to unblock a new Site ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_553_EditSite(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test case to unblock a new Site ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_AddInventorySKU(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test case to Add new SKU to Inventory ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_DeleteInventorySKU(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test case to delete new SKU to Inventory ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_EditInventorySKU(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Test case to edit new SKU to Inventory ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1173_newPromotionsAllSites(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify Add new promotion using all sites successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1174_newPromotionSpecSite(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify Add new promotion using specific site successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1175_newPromotionSpecDept(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify Add new promotion using specific department successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1176_newPromSpecDate(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify Add new promotion with specific date successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1177_editActivePromotion(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify edit active promotion successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1178_editScheduledPromotion(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify edit scheduled promotion successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1179_endActivePromotion(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify end active promotion successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1180_deleteScheduledPromotion(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify delete scheduled promotion successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1181_resendPromotion(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify resend promotion successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_720_AddInventorySKU(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify User is able to add SKU under a site");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_721_EditInventorySKU(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify User is able to edit an existing  SKU under a site");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_722_DeleteInventorySKU(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify User is able to delete the newly added SKU");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void tc_CreatePO(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify User is able to Create PO");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }



    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1182_verifyPromoTitle(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("verify warning message is displayed when promotion title is not filled in");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1183_verifyPromoDesc(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("verify warning message is displayed when promotion description is not filled in");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1184_verifyPromSpecSite(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("verify warning messages is displayed when specific site unsuccessfully selected");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1185_verifyPromSpecDept(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("verify warning messages is displayed when specific department unsuccessfully selected");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1089_addIssue(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify add Issue is successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1091_updateStatusResolved(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify update status to resolved is successfully");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1186_requiredFields(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify warning messages is displayed when Required Fields are skipped");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1094_filterByUser(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify filter by User is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1095_filterByDept(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify filter by Department is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1096_filterBySite(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify filter by Site is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1097_filterByFlag(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify filter by Flag is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1098_filterByStatus(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify filter by Status is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1099_filterByPriority(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify filter by Priority is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1093_filterByQuest(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify filter by Questionnaire is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1100_viewByPeriods(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify view by periods is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class)
    public void Tc_1101_sortByDateCreated(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("Verify sort by date created & due date is working properly");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

}
