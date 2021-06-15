package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import pages.AdminSitePage;
import pages.AndroidCheckInPage;
import pages.PromotionPage;
import supportLibraries.Utility_Functions;

import static supportLibraries.Utility_Functions.*;

public class Promotions extends ReusableLib {

    public Promotions(Helper helper) { super(helper); }


    /**
     * Keyword to add new promotions for All Sites
     *
     * @author machruk
     */
    public void newPromAllSites() {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String promName = "AutoPromo_" + rn + rnNum;

        Utility_Functions.xUpdateJson("PromoName", promName);
        click(AdminSitePage.adminBtn);
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabActPromo, globalWait);
        click(PromotionPage.newPromoBtn, "Click on New Promotion button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);

        sendKeys(PromotionPage.inputTitlePromo, promName,"Entered Promotion Title");
        sendKeys(PromotionPage.inputDescPromo,"Auto Description for Auto Promotion");
        sendKeys(PromotionPage.inputCostPromo, "89000000");

        click(PromotionPage.btnSavePromo);
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertSaveMsg, globalWait);
        timeWait(2);

    }

    /**
     * Keyword to add new promotions for Specific Sites
     *
     * @author machruk
     */
    public void newPromSpecSite() {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String promName = "AutoPromoSpecSite_" + rn + rnNum;

        Utility_Functions.xUpdateJson("PromoName", promName);
        click(AdminSitePage.adminBtn);
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabActPromo, globalWait);
        click(PromotionPage.newPromoBtn, "Click on New Promotion button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);

        sendKeys(PromotionPage.inputTitlePromo, promName,"Entered Promotion Title");
        sendKeys(PromotionPage.inputDescPromo,"Auto Description for Auto Promotion with specific site");
        sendKeys(PromotionPage.inputCostPromo, "56000000");
        click(PromotionPage.radioBtnSpecSite);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnSpecSite, "Pasar Pagi", Keys.ENTER);

        click(PromotionPage.btnSavePromo);
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertSaveMsg, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to add new promotions for Specific Department
     *
     * @author machruk
     */
    public void newPromSpecDept() {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String promName = "AutoPromoSpecDept_" + rn + rnNum;

        Utility_Functions.xUpdateJson("PromoName", promName);
        click(AdminSitePage.adminBtn);
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabActPromo, globalWait);
        click(PromotionPage.newPromoBtn, "Click on New Promotion button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);

        sendKeys(PromotionPage.inputTitlePromo, promName,"Entered Promotion Title");
        sendKeys(PromotionPage.inputDescPromo,"Auto Description for Auto Promotion with specific department");
        sendKeys(PromotionPage.inputCostPromo, "36000000");
        click(PromotionPage.radioBtnSpecDept);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnSpecDept, "Sales", Keys.ENTER);

        click(PromotionPage.btnSavePromo);
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertSaveMsg, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to Add new promotion with specific date
     * @author machruk
     */
    public void newPromSpecDate(){
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String promName = "AutoPromoSpecDate_" + rn + rnNum;

        Utility_Functions.xUpdateJson("PromoName", promName);
        click(AdminSitePage.adminBtn);
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabActPromo, globalWait);
        click(PromotionPage.newPromoBtn, "Click on New Promotion button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);

        sendKeys(PromotionPage.inputTitlePromo, promName,"Entered Promotion Title");
        sendKeys(PromotionPage.inputDescPromo,"Auto Description for Auto Promotion with specific date");
        sendKeys(PromotionPage.inputCostPromo, "39900000");

        //Click Specific Date
        click(PromotionPage.radioBtnSpecDate);
        xWaitForElementToBeClickable(driver, PromotionPage.datePickerStart, globalWait);

        //Select Start Date
        click(PromotionPage.datePickerStart);
        xWaitForElementPresent(driver, PromotionPage.datePickerNextMonth, globalWait);
        click(PromotionPage.datePickerNextMonth);
        xWaitForElementPresent(driver, PromotionPage.selectStartDate, globalWait);
        click(PromotionPage.selectStartDate);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnStartTime, "08:00", Keys.ENTER);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnStartAmPm, "PM", Keys.ENTER);

        //Select End Date
        click(PromotionPage.datePickerEnd);
        xWaitForElementPresent(driver, PromotionPage.datePickerNextMonth, globalWait);
        click(PromotionPage.datePickerNextMonth);
        xWaitForElementPresent(driver, PromotionPage.datePickerNextMonth, globalWait);
        click(PromotionPage.datePickerNextMonth);
        xWaitForElementPresent(driver, PromotionPage.selectEndDate, globalWait);
        click(PromotionPage.selectEndDate);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnEndTime, "12:00", Keys.ENTER);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnEndAmPm, "AM", Keys.ENTER);

        click(PromotionPage.btnSavePromo);
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertSaveMsg, globalWait);
        timeWait(3);
    }

    /**
     * Keyword to Edit Active Promotion
     * @author machruk
     */
    public void editActivePromotion(){
        //Click Admin Menu
        click(AdminSitePage.adminBtn);
        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.btnEditPromo, globalWait);
        //Click Edit button
        click(PromotionPage.btnEditPromo);
        xWaitForElementPresent(driver, PromotionPage.datePickerEnd, globalWait);
        //Click Date Picker
        click(PromotionPage.datePickerEnd);
        xWaitForElementPresent(driver, PromotionPage.datePickerNextMonth, globalWait);
        //Edit End Date
        click(PromotionPage.datePickerNextMonth);
        click(PromotionPage.datePickerNextMonth);
        xWaitForElementPresent(driver, PromotionPage.selectEndDate, globalWait);
        click(PromotionPage.selectEndDate);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnEndTime, "02:00", Keys.ENTER);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnEndAmPm, "PM", Keys.ENTER);
        //Click Save update
        click(PromotionPage.btnSavePromo);
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.updateSaveMsg, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to Edit Scheduled Promotion
     * @author machruk
     */
    public void editScheduledPromotion(){
        //Click Admin Menu
        click(AdminSitePage.adminBtn);
        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabSchedPromo, globalWait);
        //Click Scheduled tab
        click(PromotionPage.tabSchedPromo);
        xWaitForElementPresent(driver, PromotionPage.btnEditPromo, globalWait);
        //Click Edit button
        click(PromotionPage.btnEditPromo);
        xWaitForElementPresent(driver, PromotionPage.datePickerEnd, globalWait);
        //Click Date Picker
        click(PromotionPage.datePickerEnd);
        xWaitForElementPresent(driver, PromotionPage.datePickerNextMonth, globalWait);
        //Edit End Date
        click(PromotionPage.datePickerNextMonth);
        xWaitForElementPresent(driver, PromotionPage.selectEndDate, globalWait);
        click(PromotionPage.selectEndDate);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnEndTime, "02:00", Keys.ENTER);
        xSendKeyBoardkeys(driver, PromotionPage.drpdwnEndAmPm, "PM", Keys.ENTER);
        //Click Save update
        click(PromotionPage.btnSavePromo);
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.updateSaveMsg, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to End Active Promotion
     * @author machruk
     */
    public void endActivePromotion(){

        //Click Admin Menu
        click(AdminSitePage.adminBtn);

        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.iconEndPromo, globalWait);

        //Click End icon
        click(PromotionPage.iconEndPromo, "Click on End icon");
        xWaitForElementPresent(driver, PromotionPage.btnEndPromo, globalWait);

        //Click End button
        click(PromotionPage.btnEndPromo, "Click on End Button");

        //Wait Until success message is displayed
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.updateSaveMsg, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to delete Scheduled Promotion
     * @author machruk
     */
    public void deleteScheduledPromotion(){
        //Click Admin Menu
        click(AdminSitePage.adminBtn);
        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabSchedPromo, globalWait);
        //Click Scheduled tab
        click(PromotionPage.tabSchedPromo);
        xWaitForElementPresent(driver, PromotionPage.btnEditPromo, globalWait);
        //Click delete icon
        click(PromotionPage.iconEndPromo, "Click on End icon");
        xWaitForElementPresent(driver, PromotionPage.btnEndPromo, globalWait);
        //Click End button
        click(PromotionPage.btnEndPromo, "Click on End Button");
        //Wait Until success message is displayed
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.updateSaveMsg, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to resend promotion
     * @author machruk
     */
    public void resendPromotion(){
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String promName = "AutoPromo_" + rn + rnNum;

        Utility_Functions.xUpdateJson("PromoName", promName);

        //Click Admin Menu
        click(AdminSitePage.adminBtn);
        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabSchedPromo, globalWait);
        //Click Archived tab
        click(PromotionPage.tabArchPromo, "Click on Archived tab");
        xWaitForElementPresent(driver, PromotionPage.btnResendPromo, globalWait);
        //Click Resend button
        click(PromotionPage.btnResendPromo, "Click on Resend button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);
        //Input Promotion Title
        sendKeys(PromotionPage.inputTitlePromo, promName,"Entered Promotion Title");
        //Input Promotion Description
        sendKeys(PromotionPage.inputDescPromo,"Auto Description for Resend Promotion");
        //Input Promotion Cost
        sendKeys(PromotionPage.inputCostPromo, "500000000");
        //Click Save button
        click(PromotionPage.btnSavePromo);
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertSaveMsg, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to verify warning message is displayed when promotion title is not filled in
     *
     * @author machruk
     */
    public void verifyPromoTitle() {
        //Click Admin Menu
        click(AdminSitePage.adminBtn);
        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabActPromo, globalWait);
        //Click New Promotion button
        click(PromotionPage.newPromoBtn, "Click on New Promotion button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);

        //Input Promotion Description
        sendKeys(PromotionPage.inputDescPromo,"Auto Description for Auto Promotion with specific date");
        //Input Promotion Cost
        sendKeys(PromotionPage.inputCostPromo, "89000000");
        //Click Save button
        click(PromotionPage.btnSavePromo);
        //Warning message is displayed
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertNoTitle, globalWait);
        timeWait(2);

    }

    /**
     * Keyword to verify warning message is displayed when promotion description is not filled in
     *
     * @author machruk
     */
    public void verifyPromoDesc() {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String promName = "AutoPromo_" + rn + rnNum;

        Utility_Functions.xUpdateJson("PromoName", promName);

        //Click Admin Menu
        click(AdminSitePage.adminBtn);
        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabActPromo, globalWait);
        //Click New Promotion button
        click(PromotionPage.newPromoBtn, "Click on New Promotion button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);

        //Input Promotion Title
        sendKeys(PromotionPage.inputTitlePromo, promName,"Entered Promotion Title");
        //Input Promotion Cost
        sendKeys(PromotionPage.inputCostPromo, "89000000");
        //Click Save button
        click(PromotionPage.btnSavePromo);
        //Warning message is displayed
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertNoDesc, globalWait);
        timeWait(2);

    }

    /**
     * Keyword to verify warning messages is displayed when specific site unsuccessfully selected
     *
     * @author machruk
     */
    public void verifyPromSpecSite() {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String promName = "AutoPromoSpecSite_" + rn + rnNum;

        Utility_Functions.xUpdateJson("PromoName", promName);

        //Click Admin Menu
        click(AdminSitePage.adminBtn);
        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabActPromo, globalWait);
        //Click New Promotion button
        click(PromotionPage.newPromoBtn, "Click on New Promotion button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);

        //Input Promotion title
        sendKeys(PromotionPage.inputTitlePromo, promName,"Entered Promotion Title");
        //Input Promotion Description
        sendKeys(PromotionPage.inputDescPromo,"Auto Description for Auto Promotion with specific site");
        //Input Promotion Cost
        sendKeys(PromotionPage.inputCostPromo, "56000000");
        //Click Specific site radio button
        click(PromotionPage.radioBtnSpecSite);

        //Click Save button
        click(PromotionPage.btnSavePromo);
        //Warning messages is displayed
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertNoSpecSite, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to verify warning messages is displayed when specific department unsuccessfully selected
     *
     * @author machruk
     */
    public void verifyPromSpecDept() {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String promName = "AutoPromoSpecDept_" + rn + rnNum;

        Utility_Functions.xUpdateJson("PromoName", promName);

        //Click Admin Menu
        click(AdminSitePage.adminBtn);
        //Click Promotions Menu
        click(PromotionPage.promoLink, "Click on Promotions link");
        xWaitForElementPresent(driver, PromotionPage.tabActPromo, globalWait);
        //Click New Promotion button
        click(PromotionPage.newPromoBtn, "Click on New Promotion button");
        xWaitForElementPresent(driver, PromotionPage.inputTitlePromo, globalWait);

        sendKeys(PromotionPage.inputTitlePromo, promName,"Entered Promotion Title");
        sendKeys(PromotionPage.inputDescPromo,"Auto Description for Auto Promotion with specific department");
        sendKeys(PromotionPage.inputCostPromo, "36000000");
        click(PromotionPage.radioBtnSpecDept);


        click(PromotionPage.btnSavePromo);
        Utility_Functions.xWaitForElementPresent(driver, PromotionPage.alertNoSpecDept, globalWait);
        timeWait(3);

    }



}
