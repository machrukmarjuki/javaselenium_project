package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;
import commonkeywords.CommonKeys;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AdminSitePage;
import pages.InventoryPage;
import pages.POPage;
import supportLibraries.Utility_Functions;

import java.util.List;

import static supportLibraries.Utility_Functions.*;

public class Inventory extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    CommonKeys ck;

    public Inventory(Helper helper) {
        super(helper);
        ck = new CommonKeys(helper);
    }

    public void navigateToInventory() {
        ck.navToManageLink();
    click(InventoryPage.inventryLnk, "Clicked on Invntory link ");
        waitForElementDisappear(AdminSitePage.pageLoad, globalWait);
        waitForElementClickable(InventoryPage.addSkuChld, globalWait);
    }

    /**
     * KeyWord to Add SKU
     *
     * @author Gopesh
     */
    public void addSKU() {
        addSKUCommon("SITESKU");
    }

    /**
     * Internal function to add Sku
     *
     * @param module pass module name e.g.
     *               SITESKU= Add sku at Site
     *               POSKU= Add SKU at PO level
     */
    public void addSKUCommon(String module) {
        switch (module.toUpperCase()) {
            case "SITESKU":
                if (isDisplayed(InventoryPage.addSkuBtnPrnt)) {
                    click(InventoryPage.addSkuBtnPrnt, "Click on Add SKU Button");
                }
                if (isDisplayed(InventoryPage.addSkuChld)) {
                    click(InventoryPage.addSkuChld, "Click on Add SKU Button");
                }
                break;
            case "POSKU":
                click(POPage.add_new_Btn, "Click on Add SKU Button");
                break;
        }
        waitForVisible(InventoryPage.skuPopUp);
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        int skunum = Utility_Functions.xRandomFunction(999999);
        String skuName = "AutoSKU_" + rn + rnNum;
        // to update e2e Json file
        Utility_Functions.xUpdateJson("SKUName", skuName);
        sendKeys(InventoryPage.skuName, skuName, "Entered SKU Name " + skuName);
        String skuNo = Integer.toString(skunum);
        Utility_Functions.xUpdateJson("SKUNum", skuNo);


        sendKeys(InventoryPage.skuNO, skuNo, "Entered SKU NO " + skuNo);
        sendKeys(InventoryPage.customNO, "100", "Entered Custom Number");
        Utility_Functions.timeWaitMiliSeconds(300);
        switch (module) {
            case "SITESKU":
                xSendKeyBoardkeys(driver, InventoryPage.skutype, "Inbound from app", Keys.ENTER);
                break;
            case "POSKU":
                xSendKeyBoardkeys(driver, InventoryPage.skutype, "Inbound from Purchase Order", Keys.ENTER);
                break;
        }
        sendKeys(InventoryPage.prodDesc, "Added by Automation");
        Utility_Functions.timeWaitMiliSeconds(300);
        xSendKeyBoardkeys(driver, InventoryPage.uom, "Kilogram", Keys.ENTER);
        sendKeys(InventoryPage.customNO, "100", "Entered Custom Number");
        if (isDisplayed(InventoryPage.sku_site)) {
            xSendKeyBoardkeys(driver, InventoryPage.sku_site, "Auto", Keys.ENTER);
        }
        click(InventoryPage.btnSubmtSku, "Clicked on Submit button");
        waitForVisible(InventoryPage.toastMsg);
        String toastMsg = (getText(InventoryPage.toastMsg));
        waitForElementDisappear(InventoryPage.btnSubmtSku, globalWait);
        waitForElementDisappear(InventoryPage.toastMsg, globalWait);

        if (toastMsg.contains("Error")) {
            report.updateTestLog("Add_Site_SKU", toastMsg, Status.FAIL);
        } else {
            report.updateTestLog("Add_Site_SKU", toastMsg, Status.PASS);
        }
    }

    /**
     * Keyword to Delete the Sku
     *
     * @author Gopesh
     */
    public void deleteSKU() {
        String skuName = Utility_Functions.xGetJsonAsString("SKUName");
        String skuNo = Utility_Functions.xGetJsonAsString("SKUNum");
        WebElement skuDeletBtn = Utility_Functions.findElementByXpath(driver, InventoryPage.skuDel, "sku-Name", skuName);
        click(skuDeletBtn);
        WebElement skuYesBtn = Utility_Functions.findElementByXpath(driver, InventoryPage.delYesBtn, "sku-Name", skuName);
        if (skuYesBtn == null) {
            click(skuDeletBtn);
        }
        waitForVisible(skuYesBtn);
        click(skuYesBtn);
        if (!isDisplayed(InventoryPage.vrySkuName)) {
            report.updateTestLog("DeleteSku", skuName + " SKU Deleted Successfully", Status.PASS);
        } else {
            report.updateTestLog("DeleteSku", skuName + " SKU Deleted Successfully", Status.FAIL);

        }


    }

    /**
     * Method to search the SKU
     *
     * @param skuNo pass the sku No
     * @author Gopesh
     */
    public void searchSKU(String skuNo) {
        sendKey(InventoryPage.skuSrch, skuNo);
        xSendKeyBoardkeys(driver, InventoryPage.skuSrch, Keys.ENTER);
        Utility_Functions.timeWait(1);

        //   Utility_Functions.xAssertEquals(report, skuName, getActl, "New Added SKU ");

    }

    /**
     * Keyword to edit the SKU
     *
     * @author Gopesh
     */
    public void editInventory() {
        String skuName = Utility_Functions.xGetJsonAsString("SKUName");
        By byskuEditBtn = By.xpath(InventoryPage.skuEdit.replace("sku-Name", skuName));
        WebElement skuEditBtn = Utility_Functions.findElementByXpath(driver, byskuEditBtn);
        if (skuEditBtn == null) {
            addSKU();
            Utility_Functions.timeWait(1);
            skuName = Utility_Functions.xGetJsonAsString("SKUName");
            skuEditBtn = Utility_Functions.findElementByXpath(driver, InventoryPage.skuEdit, "sku-Name", skuName);
        }
        click(skuEditBtn, "Click on Sku Edit");
        waitForElementClickable(InventoryPage.btnSubmtSku, globalWait);
        sendKeys(InventoryPage.prodDesc, "Added by Automation");
        sendKeys(InventoryPage.customNO, "150", "Entered Custom Number");
        click(InventoryPage.btnSubmtSku, "Clicked on Submit button");

        String toastMsg = (getText(InventoryPage.toastMsg));
        if (toastMsg.contains("Error")) {
            report.updateTestLog("EditSite", toastMsg, Status.FAIL);
        } else {
            report.updateTestLog("EditSite", toastMsg, Status.PASS);
        }

        waitForElementDisappear(InventoryPage.toastMsg, globalWait);

    }


    /**
     * Key word to  validate newly added Sku
     */
    public void validateNewSKU() {
        String skuName = Utility_Functions.xGetJsonAsString("SKUName");
        String skuNo = Utility_Functions.xGetJsonAsString("SKUNum");

        searchSKU(skuNo);
        String getActl = getText(InventoryPage.vrySkuName);
        Utility_Functions.xAssertEquals(report, skuName, getActl, "New Added SKU ");
    }

    public void inventorySrch() {
        String skuName = Utility_Functions.xGetJsonAsString("SKUName");
        String skuNo = Utility_Functions.xGetJsonAsString("SKUNum");
        ;
        searchSKU(skuNo);
        timeWait(1);
    }
}
