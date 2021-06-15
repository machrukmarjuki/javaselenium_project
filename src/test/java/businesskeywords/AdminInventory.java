package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import pages.*;
import supportLibraries.Utility_Functions;

import java.util.Random;

import static supportLibraries.Utility_Functions.timeWait;
import static supportLibraries.Utility_Functions.xSendKeyBoardkeys;

public class AdminInventory extends ReusableLib {

    public static String skuname;
    public AdminInventory(Helper helper) {
        super(helper);
    }

    public void addInventory () throws InterruptedException {
        Random random = new Random();
        String rn = RandomStringUtils.randomAlphanumeric(4);
        String rn1 = String.format("%04d", random.nextInt(10000));
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminInventoryPage.inventoryLnk, "Clicked on Manage link ");
        click(AdminInventoryPage.addSKU, "Clicked on AddSKU link");
        sendKey(AdminInventoryPage.SKUname,"AutoInventory_"+rn);
        sendKey(AdminInventoryPage.SKUnumber,rn1);
        sendKeys(AdminInventoryPage.SKUdesc,"Automation description for SKU ..");
        xSendKeyBoardkeys(driver, AdminInventoryPage.SKUtag, "barang segar", Keys.ENTER);
        xSendKeyBoardkeys(driver, AdminInventoryPage.SKUassignsite, "1 Site Old", Keys.ENTER);
        xSendKeyBoardkeys(driver, AdminInventoryPage.SKUtype, "Inbound from app", Keys.ENTER);
        xSendKeyBoardkeys(driver, AdminInventoryPage.SKUmeasure, "Kilogram", Keys.ENTER);
        click(AdminInventoryPage.SKUcustom);
        skuname=driver.findElement(AdminInventoryPage.SKUname).getAttribute("value");
        click(AdminInventoryPage.submitbutton);
        Thread.sleep(15000);
    }

    public void editInventory_old () throws InterruptedException {
        Random random = new Random();
        String rn = RandomStringUtils.randomAlphanumeric(4);
        String rn1 = String.format("%04d", random.nextInt(10000));
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminInventoryPage.inventoryLnk, "Clicked on Manage link ");
        skuname="ABC";
        //sendKeys(AdminInventoryPage.searchbox,skuname);
        Thread.sleep(15000);
        click(AdminInventoryPage.editbutton);
        //Thread.sleep(5000);
        sendKeys(AdminInventoryPage.SKUname,skuname+ " Updated");
        skuname=driver.findElement(AdminInventoryPage.SKUname).getAttribute("value");
        click(AdminInventoryPage.submitbutton);
        Thread.sleep(15000);
    }

    public void deleteInventory () throws InterruptedException {
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminInventoryPage.inventoryLnk, "Clicked on Manage link ");
        skuname = "ABC";
        //sendKeys(AdminInventoryPage.searchbox,skuname);
        Thread.sleep(15000);
        click(AdminInventoryPage.deletebutton);
        click(AdminInventoryPage.Yesbutton);
        Thread.sleep(15000);
    }

}
