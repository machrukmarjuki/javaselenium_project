
package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;

import com.paulhammant.ngwebdriver.NgWebDriver;
import commonkeywords.CommonKeys;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.AdminSitePage;
import pages.AndroidCheckInPage;
import pages.DashboardPage;
import pages.DepartmentPages;
import pages.InventoryPage;
import supportLibraries.Utility_Functions;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import static supportLibraries.Utility_Functions.*;

public class AdminSite extends ReusableLib {

	/**
	 * Constructor to initialize the {@link Helper} object and in turn the
	 * objects wrapped by it
	 *
	 * @param helper The {@link Helper} object
	 */

	CommonKeys ck;
	public AdminSite(Helper helper) {
		super(helper);
		ck = new CommonKeys(helper);

	}

	/**
	 * Key word to add a new site
	 *
	 * @author Gopesh
	 */
	public void addNewSite() {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String sitName = "AutoSite_" + rn + rnNum;

        ck.navToManageLink();
        click(AdminSitePage.siteLnk, "Clicked on Site link ");
        waitForElementDisappear(AdminSitePage.pageLoad,globalWait);
        click(AdminSitePage.addBtn, "Clicked on Add Sites button ");
        xWaitForElementPresent(driver, AdminSitePage.tab_details_site, globalWait);
        sendKeys(AdminSitePage.input_name_site, sitName, "Entered Site Name");
        sendKeys(AdminSitePage.input_address_site, "3320 Cherry St, Vancouver,BC", "Entered Site Name");
        Utility_Functions.xClick(driver, AdminSitePage.select_address_site);
        xSendKeyBoardkeys(driver, AdminSitePage.drpdwn_assign_dept, "testGuestDparment", Keys.ENTER);
        xSendKeyBoardkeys(driver, AdminSitePage.selectSiteDpt, "testGuestDparment", Keys.ENTER);
        xSendKeyBoardkeys(driver, AdminSitePage.selectSupervisor, "gopesh", Keys.ENTER);
        click(AdminSitePage.addTolistSupervisor);

        xSendKeyBoardkeys(driver, AdminSitePage.selectSiteAuditor, "testGuestDparment", Keys.ENTER);
        xSendKeyBoardkeys(driver, AdminSitePage.selectAuditor, "Nimbly", Keys.ENTER);
        click(AdminSitePage.addTolistAuditor);

        xSendKeyBoardkeys(driver, AdminSitePage.selectTimeZon, "Pacific/Palau", Keys.ENTER);

        click(AdminSitePage.btn_save_site, "Clicked on Site Save Button");

        Utility_Functions.xwaitForElmntToDisappr(driver, AdminSitePage.btnUndoChng, globalWait, 1);
        Utility_Functions.xWaitForElementPresent(driver, AdminSitePage.alertSaveMgs, globalWait);
        String toastMsg = (getText(AdminSitePage.alertSaveMgs));
        Utility_Functions.xwaitForElmntToDisappr(driver, AdminSitePage.alertSaveMgs, globalWait, 1);
        Utility_Functions.xUpdateJson("SiteName", sitName);
        if (toastMsg.contains("Error")) {
            report.updateTestLog("Add_Site_SKU", toastMsg, Status.FAIL);
        } else {
            report.updateTestLog("Add_Site_SKU", toastMsg, Status.PASS);
        }

	}

	/**
	 * Keyword to schedule the reporting
	 *
	 * @author Gopesh
	 */
	public void schedule() {
        navigatetoSitepage();
        click(AdminSitePage.RptSchedulTab, "Click on Report Schedule tab");
        xWaitForElementClickable(driver, AdminSitePage.btn_save_schedule, globalWait);
        timeWait(5);
        Utility_Functions.xwaitForElmntToDisappr(driver, AdminSitePage.alertSaveMgs, globalWait, 1);
        xSendKeyBoardkeys(driver, AdminSitePage.drpdwn_quest_report, "KTProgress", Keys.ENTER);
        timeWait(1);

        Utility_Functions.xWaitForElementPresent(driver, AdminSitePage.loadQest, globalWait);

        timeWait(1);
        //   Utility_Functions.xswitchedToFrame(driver,AdminSitePage.btn_save_schedule);
        Utility_Functions.xMouseClick(driver, AdminSitePage.btn_save_schedule);
        // click(AdminSitePage.btn_save_schedule, "clicked on Schedule Button");
        Utility_Functions.xWaitForElementPresent(driver, AdminSitePage.alertSaveMgs, globalWait);
        String textMsg = getText(AdminSitePage.alertSaveMgs);
        xAssertEquals("Updates saved.", AdminSitePage.alertSaveMgs, "Scheduling has done");
        System.out.println(textMsg);
        Utility_Functions.xwaitForElmntToDisappr(driver, AdminSitePage.alertSaveMgs, globalWait, 1);
    }


	/**
	 * Keyword to search the Site
	 *
	 * @Author Gopesh
	 */
	public void searchSite() {

        String siteName = Utility_Functions.xGetJsonAsString("SiteName");
        if (siteName != null) {
            ck.navToManageLink();
            click(AdminSitePage.siteLnk, "Clicked on Site link ");
            waitForElementDisappear(AdminSitePage.pageLoad,globalWait);
            sendKeys(AdminSitePage.srchInput, siteName);
            xSendKeyBoardkeys(driver, AdminSitePage.srchInput, Keys.ENTER);
//
            waitForElementPresent(AdminSitePage.siteLoader);
            waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
            waitForElementClickable(AdminSitePage.addBtn, globalWait);
            String srchSite = "//span[text()='" + siteName + "']";
            WebElement siteElements = Utility_Functions.findElementByXpath(driver, srchSite);
         //   waitForVisible(siteElements);
            if (!Utility_Functions.waitForElementVisible(driver, siteElements, globalWait)) {
                click(AdminSitePage.manageLink, "Clicked on Manage link ");
                addNewSite();
            }

        } else {
            click(AdminSitePage.manageLink, "Clicked on Manage link ");
            addNewSite();
        }

    }

	/**
	 * Method to validate whether Site is available or not
	 *
	 * @param siteName pass the Site Name
	 * @author Gopesh
	 */
	public void vrfySite(String siteName) {

        String srchSite = "//span[text()='" + siteName + "']";

        WebElement siteElements = Utility_Functions.findElementByXpath(driver, srchSite);

        if (Utility_Functions.xIsDisplayed(siteElements)) {
            report.updateTestLog("Validate site", siteName + "is available in system", Status.PASS);
        } else {
            report.updateTestLog("Validate site", siteName + "is not available in system", Status.FAIL);
        }

    }


	/**
	 * Keyword to block the existing Site
	 *
	 * @author Gopesh
	 */
	public void blockSites() {
        waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
        waitForElementClickable(AdminSitePage.addBtn, globalWait);
        click(AdminSitePage.dltBtn);
        waitForElementDisappear(AdminSitePage.loadSpinnr, globalWait);
        waitForElementClickable(AdminSitePage.alrtYesBtn, globalWait);
        click(AdminSitePage.alrtYesBtn);
        waitForElementDisappear(AdminSitePage.loadSpinnr, globalWait);
        vrfyElmentExist(AdminSitePage.dltMsg, "Site successfully deleted");
        waitForElementDisappear(AdminSitePage.alrtYesBtn, globalWait);

    }

	/**
	 * Keyword to Unblock Site
	 *
	 * @author Gopesh
	 */
	public void unBlockSites() {
        waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
        waitForElementClickable(AdminSitePage.addBtn, globalWait);
        click(AdminSitePage.blokedSite, "Clicked on Blocked site");
        waitForElementClickable(AdminSitePage.addBtn, globalWait);
        click(AdminSitePage.reActive);
        waitForElementDisappear(AdminSitePage.loadSpinnr, globalWait);
        waitForElementClickable(AdminSitePage.reActive, globalWait);
        click(AdminSitePage.unBlock);
        waitForElementDisappear(AdminSitePage.loadSpinnr, globalWait);
        vrfyElmentExist(AdminSitePage.dltMsg, "Site successfully deleted");


    }

	/**
	 * Keyword to edit the Site
	 *
	 * @author Gopesh
	 */
	public void editSite() {
        navigatetoSitepage();
        sendKeys(AdminSitePage.input_subsite, "Edit", "Entered Site Name");
        click(AdminSitePage.btn_save_site, "Clicked on Site Save Button");
        waitForVisible(InventoryPage.toastMsg);
        waitForElementDisappear(InventoryPage.toastMsg, globalWait);


    }

	/**
	 * Method to Navigate to Site page
	 *
	 * @author Gopesh
	 */
	public void navigatetoSitepage() {
        String siteName = Utility_Functions.xGetJsonAsString("SiteName");
        String srchSite = "//span[text()='" + siteName + "']";

        WebElement siteElements = Utility_Functions.findElementByXpath(driver, srchSite);

        waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
        if (isDisplayed(siteElements)) {
            click(siteElements, "Clicked on Site Link");
            xWaitForElementPresent(driver, AdminSitePage.input_subsite, globalWait);
        }
    }

	/*
	 * Function to verify that Dashboard Page is Launched
	 * @author: Rudra
	 */
	public void verifyDashboardPage() {
        timeWait(10);
        waitForElementPresent(DashboardPage.txt_sitemapOverview);
        if (isDisplayed(DashboardPage.txt_sitemapOverview)) {
            report.updateTestLog("Verify that dashboard page is launched", "Dashboard Page is launched", Status.PASS);
        } else {
            report.updateTestLog("Verify that dashboard page is launched", "Dashboard Page is not launched", Status.FAIL);

        }
        timeWait(5);
        Utility_Functions.xUpdateMasterJson("UserName", getText(AdminSitePage.span_loggedinuser));
    }

}








