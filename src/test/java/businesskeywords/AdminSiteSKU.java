package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;
import commonkeywords.CommonKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.InventoryPage;
import supportLibraries.Utility_Functions;

public class AdminSiteSKU extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */

    public AdminSiteSKU(Helper helper) {
        super(helper);

    }

    AdminSite adminSite = new AdminSite(helper);
    Inventory inventory = new Inventory(helper);

    public void navToSiteSKU() {
        adminSite.searchSite();
        adminSite.navigatetoSitepage();
        click(InventoryPage.tab_Sku, "Click on Tab");
        waitForElementClickable(InventoryPage.addSkuBtnPrnt, globalWait);
    }

    /**
     * Keyword to Delete the Sku
     *
     * @author Gopesh
     */
    public void deleteSiteSKU() {
        String skuName = Utility_Functions.xGetJsonAsString("SKUName");
        String skuNo = Utility_Functions.xGetJsonAsString("SKUNum");

        By byskudelBtn = By.xpath(InventoryPage.skuDel.replace("sku-Name", skuName));

        WebElement skuDeletBtn = Utility_Functions.findElementByXpath(driver, byskudelBtn);
        if (skuDeletBtn == null) {
            inventory.addSKU();
            skuName = Utility_Functions.xGetJsonAsString("SKUName");
            skuNo = Utility_Functions.xGetJsonAsString("SKUNum");
            skuDeletBtn = Utility_Functions.findElementByXpath(driver, InventoryPage.skuDel, "sku-Name", skuName);
        }
        click(skuDeletBtn);
        WebElement skuYesBtn = Utility_Functions.findElementByXpath(driver, InventoryPage.delYesBtn, "sku-Name", skuName);
        if (skuYesBtn == null) {
            click(skuDeletBtn);
        }
        waitForVisible(skuYesBtn);
        click(skuYesBtn);
        Utility_Functions.timeWait(1);
        if (!isDisplayed(skuDeletBtn)) {
            report.updateTestLog("DeleteSku", skuName + " SKU Deleted Successfully", Status.PASS);
        } else {
            report.updateTestLog("DeleteSku", skuName + " SKU Deleted Successfully", Status.FAIL);

        }


    }
}
