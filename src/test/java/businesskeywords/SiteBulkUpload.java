package businesskeywords;

import static supportLibraries.Utility_Functions.timeWait;
import static supportLibraries.Utility_Functions.timeWaitMiliSeconds;
import static supportLibraries.Utility_Functions.xSendCtrlPlusKey;
import static supportLibraries.Utility_Functions.xSendKeyBoardkeys;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;

import commonkeywords.CommonKeys;
import pages.AdminSitePage;
import pages.DashboardPage;
import supportLibraries.Utility_Functions;

public class SiteBulkUpload extends ReusableLib {
	CommonKeys ck;
	Departments dep;
	public SiteBulkUpload(Helper helper) {
		super(helper);
		ck = new CommonKeys(helper);
		dep=new Departments(helper);
	}
	/*
	 * Function to  click on SiteLink
	 * @author : Rudra
	 */
	public void clickOnSitePage()
	{
		waitForElementClickable(AdminSitePage.siteLnk,15);
		click(AdminSitePage.siteLnk);
		waitForElementClickable(AdminSitePage.addBtn,40);
		if(isDisplayed(AdminSitePage.addBtn))
		{
			report.updateTestLog("Verify that Site page is launched", "Site Page is launched", Status.PASS);
		}else {
			report.updateTestLog("Verify that Site page is launched", "Site Page is not launched", Status.FAIL);
		}

	}
	/*
	 * Function to  click on Bulk Upload Button
	 * @author : Rudra
	 */
	public void clickBulkuploadButton()
	{
		waitForElementClickable(AdminSitePage.btn_bulkUpload,20);
		click(AdminSitePage.btn_bulkUpload);
	}
	/*
	 * Function to  click on Bulk Upload Site Option
	 * @author : Rudra
	 */
	public void clickbulkuploadSite()
	{
		List<WebElement> bulkitems = getListElement(AdminSitePage.span_listofbulkitems);
		click(bulkitems.get(0));
		vrfyElmentExist(AdminSitePage.div_reportingSchdlmsg,"The Do not forget message is being displayd in bulk upload site div");
		vrfyElmentExist(AdminSitePage.div_subtitle,"The report scheduling reminder note s being displayed");

	}
	/*
	 * Function to  verify that all option under bulkupload dropdown is present
	 * @author : Rudra
	 */
	public void verifybulkuploadDropdown()
	{
		List<WebElement> bulkitems = getListElement(AdminSitePage.span_listofbulkitems);
		if((bulkitems.get(0)).getText().equals("Bulk site upload")&&(bulkitems.get(1)).getText().equals("Bulk schedule upload")&&(bulkitems.get(2)).getText().equals("Bulk edit schedule"))
		{
			report.updateTestLog("Verification of Items ", "Verification Of Items under Site Page bulk upload dropdown" , Status.PASS);
		}else {
			report.updateTestLog("Verification of Items ", "Verification Of Items under Site Page bulk upload dropdown" , Status.FAIL);
		}
	}
	/*
	 * Function to  launch Site Page
	 * @author : Rudra
	 */
	public void  navigateToSitePage()
	{
		waitForElementClickable(DashboardPage.lnk_adminpage,15);
		/*click(DashboardPage.lnk_adminpage,"click on Admin link");
		waitForElementClickable(AdminSitePage.manageLink,55);
		click(AdminSitePage.manageLink,"clicked on manage link");
		try {
			waitForElementClickable(AdminSitePage.siteLnk,30);
			click(AdminSitePage.siteLnk,"clicked on Site");
		}catch(Exception e ) {
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.manageLink,55);
			click(AdminSitePage.manageLink,"clicked on manage link");
		}*/
		ck.navToManageLink();
		waitForElementClickable(AdminSitePage.siteLnk,30);
		click(AdminSitePage.siteLnk,"clicked on Site");
		waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
		waitForElementClickable(AdminSitePage.addBtn,40);
		if(isDisplayed(AdminSitePage.btn_bulkUpload))
		{
			report.updateTestLog("Verify that Site page is launched", "Site Page is launched", Status.PASS);
		}else {
			report.updateTestLog("Verify that Site page is launched", "Site Page is not launched", Status.FAIL);
		}

	}
	/*
	 * Function to create a department and add site and questionnaire
	 * @author: Rudra
	 */
	public void createDepartmentIfRequired()
	{

		String deptName = Utility_Functions.xGetMasterJsonData("DepartmentName");
		if(deptName != null)
		{
			navigateToSitePage();

		}else {

			dep.createDepartment();
			clickOnSitePage();
		}
	}
	/*
	 * Function to  upload a bulkfile
	 * @author : Rudra
	 */
	public void uploadFile()
	{
		ck.writeToSiteUploadExcel();
		String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\DataFile\\site-template.xlsx";
		waitForElementClickable(AdminSitePage.lbl_uploadxlsbtn, 15);
		int counter=1;
		boolean flg=true;
		while(counter < 20 && flg==true)
		{	
			click(AdminSitePage.lbl_uploadxlsbtn);
			StringSelection stringSelection = new StringSelection(excelPath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
			timeWait(2);
			Utility_Functions.xSendmultipleKeyBoardkeys(KeyEvent.VK_CONTROL,KeyEvent.VK_V);
			timeWait(2);
			Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			waitForElementClickable(AdminSitePage.btn_upload, 15);
			click(AdminSitePage.btn_upload);
			timeWait(4);
			flg=isDisplayed(AdminSitePage.msg_error);
			counter++;
		}
		if(isDisplayed(AdminSitePage.msg_error))
		{
			report.updateTestLog("Bulk Site Upload Verification", "Bulk Upload not Successfull", Status.FAIL);
		}
		vrfyElmentExist(AdminSitePage.msg_bulkuploadsite,"Bulk Upload Completed Successfully");
		waitForElementDisappear(AdminSitePage.msg_bulkuploadsite,15);
		System.out.println("Message disappeared");
		waitForElementClickable(AdminSitePage.btn_cancelBulkUpload, 15);
		click(AdminSitePage.btn_cancelBulkUpload);
		driver.navigate().refresh();
		waitForElementClickable(AdminSitePage.addBtn,50);
		System.out.println("Bulk Upload Completed Successfully");
		try {
			FileOutputStream outFile =new FileOutputStream(new File(excelPath));
			outFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * Function to  search all site uploaded via bulk upload
	 * @author : Rudra
	 */
	public void searchbulkUploadedSite()
	{
		int sitecount = Integer.parseInt(jsonData.getData("NoOfSites"));
		for (int i = 1; i <=sitecount;i++ )
		{
			String jsonkey="BulkSiteName_"+i;
			String siteName=Utility_Functions.xGetJsonAsString(jsonkey);
			sendKeys(AdminSitePage.srchInput,siteName );
			xSendKeyBoardkeys(driver, AdminSitePage.srchInput, Keys.ENTER);
			waitForElementPresent(AdminSitePage.siteLoader);
			waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
			System.out.println("Searching Site:"+Utility_Functions.xGetJsonData(jsonkey));
			String srchSite = "(//span[text()='" + Utility_Functions.xGetJsonData(jsonkey)+ "'])[1]";
			vrfyElmentExist(By.xpath(srchSite), "The Site "+Utility_Functions.xGetJsonAsString(jsonkey)+" is present");
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.addBtn,50);
		}
	}
	
	/*
	 * Function to  open Bulk Site Upload window
	 * @author : Sairab
	 */
	public void openBulkSiteUploadModalInAdminSitesPage() {

		click(AdminSitePage.btn_BulkUpload, "Clicked bulk upload button");
		xWaitForElementPresent(driver,AdminSitePage.btn_BulkSiteUpload, globalWait);
		click(AdminSitePage.btn_BulkSiteUpload, "Clicked bulk site upload button");

		if(xWaitForElementPresent(driver,AdminSitePage.btn_BulkSiteUpload_SelectFile, globalWait)) {
			report.updateTestLog("Verify navigation to Site Bulk Upload window in Sites ppage is successfull", "Navigation to Site Bulk Upload window in Sites page is successfull", Status.PASS);
		}else {
			report.updateTestLog("Verify navigation to Site Bulk Upload window in Sites ppage is successfull", "Failed to navigation to Site Bulk Upload window in Sites page", Status.FAIL);
		}
	}

	/*
	 * Function to  open Bulk Schedule Upload window
	 * @author : Sairab
	 */
	public void openBulkScheduleUploadModalInAdminSitesPage() {

		click(AdminSitePage.btn_BulkUpload, "Clicked bulk upload button");
		xWaitForElementPresent(driver,AdminSitePage.btn_BulkScheduleUpload, globalWait);
		click(AdminSitePage.btn_BulkScheduleUpload, "Clicked bulk site upload button");

		if(xWaitForElementPresent(driver,AdminSitePage.btn_BulkScheduleUpload_SelectFile, globalWait)) {
			report.updateTestLog("Verify navigation to Site Bulk Upload window in Sites ppage is successfull", "Navigation to Schedule Bulk Upload window in Sites page is successfull", Status.PASS);
		}else {
			report.updateTestLog("Verify navigation to Site Bulk Upload window in Sites ppage is successfull", "Failed to navigation to Schedule Bulk Upload window in Sites page", Status.FAIL);
		}
	}
	
	/*
	 * Function to  verify duplicate site error message using bulk site upload
	 * @author : Sairab
	 */

	public void bulkSiteUploadTemplateWithDuplicateSiteDetailsError() {

		click(AdminSitePage.btn_BulkSiteUpload_SelectFile, "Clicked select file to upload button");

		StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\DataFile\\TC427_site-template.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		timeWaitMiliSeconds(500);
		xSendCtrlPlusKey(KeyEvent.VK_V);
		xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		click(AdminSitePage.btn_UploadConfirm, "Clicked confirm upload button");

		//To verify the site-template is uploaded
		xWaitForElementPresent(driver,AdminSitePage.msg_TemplateUploaded, globalWait);
		String templateUploadedMsg = getText(AdminSitePage.msg_TemplateUploaded);

		if(templateUploadedMsg.equalsIgnoreCase("TC427_site-template.xlsx uploaded")) {
			report.updateTestLog("Verification", "The site-template uploaded message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The site-template uploaded message is not displayed", Status.FAIL);
		}

		//To verify the generic error message
		String templateUploadedMsg2 = getText(AdminSitePage.msg_TemplateUploaded_Error);

		if(templateUploadedMsg2.contains("errors found. Please correct the errors and reselect the file.")) {
			report.updateTestLog("Verification", "The upload failed generic message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The upload failed generic message is not displayed", Status.FAIL);
		}

		//To verify the duplicate site name found error message
		String templateUploadedMsg3 = getText(AdminSitePage.msg_UploadError_DuplicateSiteName);

		if(templateUploadedMsg3.contains("Site exist with the same name. Duplicates not allowed")) {
			report.updateTestLog("Verification", "The duplicate site name error message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The duplicate site name error message is not displayed", Status.FAIL);
		}
	}
	
	/*
	 * Function to  verify invalid supervisor error message using bulk site upload
	 * @author : Sairab
	 */

	public void bulkSiteUploadTemplateWithInvalidSupervisorError() {

		click(AdminSitePage.btn_BulkSiteUpload_SelectFile, "Clicked select file to upload button");

		StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\DataFile\\TC428_site-template.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		timeWaitMiliSeconds(500);
		xSendCtrlPlusKey(KeyEvent.VK_V);
		xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		click(AdminSitePage.btn_UploadConfirm, "Clicked confirm upload button");

		//To verify the site-template is uploaded
		xWaitForElementPresent(driver,AdminSitePage.msg_TemplateUploaded, globalWait);
		String templateUploadedMsg = getText(AdminSitePage.msg_TemplateUploaded);

		if(templateUploadedMsg.equalsIgnoreCase("TC428_site-template.xlsx uploaded")) {
			report.updateTestLog("Verification", "The site-template uploaded message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The site-template uploaded message is not displayed", Status.FAIL);
		}

		//To verify the generic error message
		String templateUploadedMsg2 = getText(AdminSitePage.msg_TemplateUploaded_Error);

		if(templateUploadedMsg2.contains("errors found. Please correct the errors and reselect the file.")) {
			report.updateTestLog("Verification", "The upload failed generic message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The upload failed generic message is not displayed", Status.FAIL);
		}

		//To verify the duplicate site name found error message
		String templateUploadedMsg3 = getText(AdminSitePage.msg_UploadError_DuplicateSiteName);

		if(templateUploadedMsg3.contains("Supervisor:test@testxyz.com doesn't exist in AutomationTestDP&Test")) {
			report.updateTestLog("Verification", "The duplicate site name error message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The duplicate site name error message is not displayed", Status.FAIL);
		}
	}
	
	/*
	 * Function to  verify duplicate schedule error message using bulk site upload
	 * @author : Sairab
	 */

	public void bulkScheduleUploadTemplateWithDuplicateScheduleError() {

		click(AdminSitePage.btn_BulkScheduleUpload_SelectFile, "Clicked select file to upload button");

		StringSelection ss = new StringSelection(System.getProperty("user.dir") + "\\src\\test\\resources\\DataFile\\TC430_site-schedule-template.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		timeWaitMiliSeconds(500);
		xSendCtrlPlusKey(KeyEvent.VK_V);
		xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		click(AdminSitePage.btn_ScheduleUploadConfirm, "Clicked confirm upload button");

		//To verify the site-schedule-template is uploaded
		xWaitForElementPresent(driver,AdminSitePage.msg_ScheduleTemplateUploaded, globalWait);
		String templateUploadedMsg = getText(AdminSitePage.msg_ScheduleTemplateUploaded);

		if(templateUploadedMsg.equalsIgnoreCase("TC430_site-schedule-template.xlsx")) {
			report.updateTestLog("Verification", "The schedule-template uploaded message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The schedule-template uploaded message is not displayed", Status.FAIL);
		}

		//To verify the generic error message
		String templateUploadedMsg2 = getText(AdminSitePage.msg_ScheduleTemplateUploaded_Error);

		if(templateUploadedMsg2.contains("errors found. Please correct the errors and reselect the file.")) {
			report.updateTestLog("Verification", "The upload failed generic message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The upload failed generic message is not displayed", Status.FAIL);
		}

		//To verify the duplicate schedule found error message
		String templateUploadedMsg3 = getText(AdminSitePage.msg_ScheduleUploadError_DuplicateSchedule);

		if(templateUploadedMsg3.contains("There is already a duplicate on this schedule. Please disable it first")) {
			report.updateTestLog("Verification", "The duplicate schedule error message is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The duplicate schedule name error message is not displayed", Status.FAIL);
		}
	}
	
	/*
	 * Function to  verify Search box is present in Site Page
	 * @author : Rudra
	 */
	public void isSearchBoxPresent()
	{
		vrfyElmentExist(AdminSitePage.srchInput, "Verify if the Search site box exists");
		if(isDisplayed(AdminSitePage.srchInput))
		{
			report.updateTestLog("Verification whether search site box is present", "Search Site box is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification whether search site box is present", "Search Site box is not displayed", Status.FAIL);
		}
	}
	/*
	 * Function to  search a site by name
	 * @author : Rudra
	 */
	public void searchSiteByName()
	{
		String searchNAme = Utility_Functions.xGetMasterJsonData("SiteName");
		sendKeys(AdminSitePage.srchInput, searchNAme, "Entered site to be searched");
		waitForElementPresent(AdminSitePage.siteLoader);
        waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
        String xpath = "//div[@class='cell col-name']/span[text()='" +searchNAme+ "']";
        vrfyElmentExist(By.xpath(xpath),"Verify if the searched site is displayed");
	}
	/*
	 * Function to  search a site by Author and Supervisor
	 * @author : Rudra
	 */
	public void searchSiteByAuthor()
	{
		WebElement searchSite = Utility_Functions.findElementByXpath(driver,AdminSitePage.srchInput );
		String author = Utility_Functions.findElementByXpath(driver,AdminSitePage.span_loggedinuser ).getText().trim();
		searchSite.clear();
		sendKeys(AdminSitePage.srchInput,author , "Entered site to be searched");
		waitForElementPresent(AdminSitePage.siteLoader);
        waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
        String xpath = "//div[@class='multiple-cell col-auditor']//span[contains(text(),'"+author+"')]";
        vrfyElmentExist(By.xpath(xpath),"Verify if the searched site is displayed");
        
	}
	/*
	 * Function to  search a site to be blocked
	 * @author : Rudra
	 */
	public void searchSiteJustCreated()
	{
		click(AdminSitePage.siteLnk, "Clicked on Site link ");
		waitForElementPresent(AdminSitePage.siteLoader);
        waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
		String searchNAme = Utility_Functions.xGetJsonAsString("SiteName");
		sendKeys(AdminSitePage.srchInput, searchNAme, "Entered site to be searched");
		//waitForElementPresent(AdminSitePage.siteLoader);
        waitForElementDisappear(AdminSitePage.siteLoader, globalWait);
        String xpath = "//div[@class='cell col-name']/span[text()='" +searchNAme+ "']";
        vrfyElmentExist(By.xpath(xpath),"Verify if the searched site is displayed");
	}
	/*
	 * Function to  move to Blocked Sites tab
	 * @author : Rudra
	 */
	public void clickBlockedSiteTab()
	{
		click(AdminSitePage.blokedSite, "Clicked on Blocked Site label ");
		
	}
	/*
	 * Function to edit name of created site
	 * @author : Rudra
	 */
	public void editSiteName()
	{
		String searchNAme = Utility_Functions.xGetJsonAsString("SiteName");
		String editedName= Utility_Functions.xGetJsonAsString("SiteName")+"_edited";
		String xpath = "//div[@class='cell col-name']/span[text()='" +searchNAme+ "']";
		click(By.xpath(xpath),"Clicked on the created site");
		vrfyElmentExist(AdminSitePage.input_name_site, "The Site Name is displayed");
		sendKeys(AdminSitePage.input_name_site,editedName,"Edited the NAme of site");
		click(AdminSitePage.btn_save_site,"clicked on the Save Button");
		vrfyElmentExist(AdminSitePage.msg_savedmsg,"The changes are saved successfully");
		Utility_Functions.xUpdateJson("EditedSiteName",editedName );
		
	}
}


