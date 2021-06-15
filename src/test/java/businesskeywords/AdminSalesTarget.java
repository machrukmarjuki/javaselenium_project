package businesskeywords;

import static supportLibraries.Utility_Functions.xSendKeyBoardkeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;

import commonkeywords.CommonKeys;
import pages.AdminSalesTargetPage;
import pages.AdminSitePage;
import pages.DashboardPage;
import pages.POPage;
import supportLibraries.Utility_Functions;
public class AdminSalesTarget extends ReusableLib{

	CommonKeys ck;
	
	public AdminSalesTarget(Helper helper) {
		super(helper);
		ck = new CommonKeys(helper);
	}

	/*
	 * Function to  navigate to Admin Sales Target page
	 * @author : Sairab
	 */
	
	public void navigationToAdminSalesTargetPage()
	{
		boolean result = false;
		Utility_Functions.xWaitForElementPresentInPage(driver, DashboardPage.lst_crclProgressBar, 90);
		if(Utility_Functions.xWaitForElementPresentInPage(driver, AdminSitePage.adminBtn, globalWait)) {
			click(AdminSitePage.adminBtn);
			
			if(Utility_Functions.xWaitForElementPresent(driver, POPage.lbl_NoAccess_POpage, 2)) {
				refreshPage();
	        }
			
			waitForElementClickable(AdminSitePage.dltBtn, globalWait);
	        click(AdminSalesTargetPage.btn_SalesTargetMenu);
	        if(isElementClickable(AdminSalesTargetPage.lst_btn_viewDetails, globalWait)) {
	        	result = true;
	        }
		}
		
		if(result)
			report.updateTestLog("Verify Sales target page is launched", "Sales target Page is launched", Status.PASS);
		else
			report.updateTestLog("Verify Sales target page is launched", "Sales target Page is not launched", Status.FAIL);
	}
	
		
	/*
	 * Function to  verify UI of Admin Sales Target page
	 * @author : Sairab
	 */
	
	public void verifyUIofAdminSalesTargetPage()
	{
		// Verifying the textbox and buttons
		vrfyElmentExist(AdminSalesTargetPage.tbx_searchSales, "Search Sales textbox is present");
		vrfyElmentExist(AdminSalesTargetPage.hdr_period, "Period - Month and Year is present");
		vrfyElmentExist(AdminSalesTargetPage.btn_editPeriod, "Edit/Save period button is present");
		vrfyElmentExist(AdminSalesTargetPage.btn_UploadSales, "Upload Sales button is present");
		vrfyElmentExist(AdminSalesTargetPage.btn_UploadTarget, "Upload Target button is present");
		
		//Verifying the Sales Target table headers
		vrfyElmentExist(AdminSalesTargetPage.tbl_hdr_Site, "Table header Site is present");
		vrfyElmentExist(AdminSalesTargetPage.tbl_hdr_Department, "Table header Department is present");
		vrfyElmentExist(AdminSalesTargetPage.tbl_hdr_AssignedAuditors, "Table header Assigned Auditors is present");
		vrfyElmentExist(AdminSalesTargetPage.tbl_hdr_TotalSalesMade, "Table header Total Sales Made is present");
		vrfyElmentExist(AdminSalesTargetPage.tbl_hdr_Progress, "Table header Progress is present");
		
		List<WebElement> lst_element = getListElement(AdminSalesTargetPage.lst_btn_viewDetails);
		int count = 0;
		
		for(WebElement e : lst_element) {
			if(isDisplayed(e)) {
				count++;
			}
		}
		if(count==lst_element.size()) 
			report.updateTestLog("Verify [View Details] button is displayed", "[View Details] button is displayed for all rows", Status.PASS);
		else
			report.updateTestLog("Verify [View Details] button is displayed", "[View Details] button is NOT displayed for all rows", Status.FAIL);
	}
	
	/*
	 * Function to select random site name from Sales Target page
	 * @author : Sairab
	 * @return String SiteName
	 */
	
	public String selectRandomSiteName()
	{
		List<String> lst_element = xgetWebelementTextList(AdminSalesTargetPage.lst_Sites);
		int random = Utility_Functions.xgetRandomNumber(0, lst_element.size()-1);
		String site = lst_element.get(random);
		return site;
	}
	
	/*
	 * Function to search Sales Details using Site Name in Sales Target page
	 * @author : Sairab
	 * @return : Boolean
	 */
	
	public boolean searchWithSiteName(String siteName)
	{
		boolean result = false;
		xWaitForElementPresent(driver, AdminSalesTargetPage.tbx_searchSales, globalWait);
		sendKeys(AdminSalesTargetPage.tbx_searchSales, siteName);
		Utility_Functions.xSendKeyBoardkeys(driver, AdminSalesTargetPage.tbx_searchSales, Keys.ENTER);
		Utility_Functions.timeWait(3);
		if(Utility_Functions.xIsDisplayed(driver, AdminSalesTargetPage.lst_Sites)) {
			
			waitForElementClickable(AdminSalesTargetPage.lst_btn_viewDetails, globalWait);
			List<String> lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Sites);
			int count = 0;
			
			for(String text : lst_text) {
				if(text.toLowerCase().contains(siteName.toLowerCase())) {
					count++;
				}
			}
			if(count==lst_text.size())
				result = true;
			else
				result = false;
		}
		//xWaitForElementVisible(AdminSalesTargetPage.lst_Sites, globalWait);
		
		
		return result;
	}
	
	/*
	 * Function to  check Sorting by Site in Sales Target page
	 * @author : Sairab
	 */
	
	public void verifySortingBySitesInSalesTargetPage()
	{
		//Click on Site to perform sort descending
		click(AdminSalesTargetPage.tbl_hdr_Site);
		click(AdminSalesTargetPage.tbl_hdr_Site, "Clicking on Site header to perform Sort Descending");
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_Site, globalWait);
		List<String> lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Sites);
		ck.checkSortingByColumn("desc", lst_text);
		
		//Click on Site to perform sort ascending
		click(AdminSalesTargetPage.tbl_hdr_Site, "Clicking on Site header to perform Sort Ascending");		
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_Site, globalWait);
		lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Sites);
		ck.checkSortingByColumn("asc", lst_text);
	}
	
	
	
	/*
	 * Function to select Period i.e., Month and Year in Sales Target page
	 * @author : Sairab
	 * @param module pass monthOffset and yearOffset e.g.
     *       monthOffset = type int e.g., 1, -1, +1, etc
     *       yearOffset = type int e.g., 1, -1, +1, etc
	 */
	
	public void setPeriodInSalesTargetPage(int monthOffset, int yearOffset)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthOffset);
		calendar.add(Calendar.YEAR, yearOffset);
		Date date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String[] strdate = formatter.format(date).split(" ");
		
		click(AdminSalesTargetPage.btn_editPeriod);
		click(AdminSalesTargetPage.ddn_month);
        xSendKeyBoardkeys(driver, AdminSalesTargetPage.ddn_input_month, strdate[1], Keys.ENTER);
		
        click(AdminSalesTargetPage.ddn_year);
        xSendKeyBoardkeys(driver, AdminSalesTargetPage.ddn_input_year, strdate[2], Keys.ENTER);
		
        click(AdminSalesTargetPage.btn_editPeriod);
        waitForElementClickable(AdminSalesTargetPage.lst_btn_viewDetails, globalWait);
        xAssertEquals(strdate[1]+" "+strdate[2], AdminSalesTargetPage.hdr_period, "Period is successfully set in landing page: ");
	}
	
	/*
	 * Function to randomly select Period i.e., Month and Year in Sales Target page
	 * @author : Sairab
	 */
	
	public void setRndmPeriodInSalesTargetPage()
	{
		int rndm_month = Utility_Functions.xgetRandomNumber(1, 10);
		int rndm_year = Utility_Functions.xgetRandomNumber(1, 4);
		setPeriodInSalesTargetPage(rndm_month, rndm_year);
	}
	
	/*
	 * Function to set Period i.e., Month and Year and verify that the selected period is set for table in Sales Target page
	 * @author : Sairab
	 */
	
	public void selectPeriodAndVerifyPeriodSetForTableRows()
	{
		setPeriodInSalesTargetPage(-1, -1);
		String site = selectRandomSiteName();
		searchWithSiteName(site);
		openEditSalesTargetPopup();
	}
	
	/*
	 * Function to verify pagination in Sales Target page
	 * @author : Sairab
	 */
	
	public void verifyPaginationInSalesTargetPage()
	{
		vrfyElmentExist(AdminSalesTargetPage.btn_leftArrow_pageNavigation, "Left Pagination button is present");
		vrfyElmentExist(AdminSalesTargetPage.btn_rightArrow_pageNavigation, "Right Pagination button is present");

		List<WebElement> lst_element = getListElement(AdminSalesTargetPage.lst_pageNumbers);
		int count = 0;
		for(WebElement e : lst_element) {
			if(isDisplayed(e)) {
				count++;
			}
		}
		if(count==lst_element.size()) 
			report.updateTestLog("Verify pagination numbers are displayed", "Pagination numbers are displayed", Status.PASS);
		else
			report.updateTestLog("Verify pagination numbers are displayed", "Pagination numbers are NOT displayed properly", Status.FAIL);
		
		if(lst_element.size()>1) {
			
			click(lst_element.get(lst_element.size()-2), "Clicked on 2nd last page number");
			waitForElementClickable(AdminSalesTargetPage.lst_btn_viewDetails, globalWait);
			click(AdminSalesTargetPage.btn_rightArrow_pageNavigation);
			waitForElementClickable(AdminSalesTargetPage.lst_btn_viewDetails, globalWait);
			
			WebElement element = driver.findElement(AdminSalesTargetPage.btn_rightArrow_pageNavigation);
			boolean isClickable = element.isEnabled();
			if(isClickable) {
				report.updateTestLog("Verify navigation to last page", "Reached last page, but the left arrow is still clickable!", Status.FAIL);
			}else {
				report.updateTestLog("Verify navigation to last page", "Reached last page!", Status.PASS);
			}
			
			lst_element = getListElement(AdminSalesTargetPage.lst_pageNumbers);
			click(lst_element.get(1), "Clicked on page no 2");
			waitForElementClickable(AdminSalesTargetPage.lst_btn_viewDetails, globalWait);
			click(AdminSalesTargetPage.btn_leftArrow_pageNavigation);
			waitForElementClickable(AdminSalesTargetPage.lst_btn_viewDetails, globalWait);
			
			WebElement element2 = driver.findElement(AdminSalesTargetPage.btn_leftArrow_pageNavigation);
			isClickable = element2.isEnabled();
			if(isClickable) {
				report.updateTestLog("Verify navigation to page 1", "Reached page 1, but the left arrow is still clickable!", Status.FAIL);
			}else {
				report.updateTestLog("Verify navigation to page 1", "Reached first page!", Status.PASS);
			}
			
		}else {
			report.updateTestLog("Verify pagination numbers", "Only one ppage is present", Status.PASS);
		}
	}
	
	/*
	 * Function to open and verify data in edit Sales Target popup in Sales Target page
	 * @author : Sairab
	 */
	
	public void openEditSalesTargetPopup()
	{
		//gathering info from table
		String[] period = getText(AdminSalesTargetPage.hdr_period).split(" ");
		String siteName = getText(AdminSalesTargetPage.lst_Sites);
		String amount_fromTable = Utility_Functions.getText(driver, AdminSalesTargetPage.lst_SalesTarget_text, "value");
		
		//opening Edit Sales popup
		Utility_Functions.xMouseHoverOnElment(AdminSalesTargetPage.lst_SalesTarget, driver);
		click(AdminSalesTargetPage.lst_btn_editSalesTarget, "Opened Sales Target popup");
		waitForElementClickable(AdminSalesTargetPage.tbx_amount, globalWait);
		
		//Verifying data in the popup
		xAssertEquals(period[0], AdminSalesTargetPage.ddn_month_editST, "Month is dispalyed correctly: ");
		xAssertEquals(period[1], AdminSalesTargetPage.ddn_year_editST, "Year is dispalyed correctly: ");
		xAssertEquals(siteName, AdminSalesTargetPage.txt_siteName_ST, "Site Name is dispalyed correctly: ");
		
		String amount_actual = getAttribute(AdminSalesTargetPage.tbx_amount, "value");
		if(amount_actual.contains(",")) {
			amount_actual = amount_actual.replaceAll(",", "");
		}
		if(amount_actual.equalsIgnoreCase(amount_fromTable))
			report.updateTestLog("Verify Sales Target Amount is displayed", "Sales Target Amuont is displayed", Status.PASS);
		else
			report.updateTestLog("Verify Sales Target Amount is displayed", "Sales Target Amuont is NOT displayed", Status.FAIL);
	}
	
	/*
	 * Function to enter Amount in edit Sales Target popup in Sales Target page
	 * @author : Sairab
	 */
	
	public void enterAmountInEditSalesTargetPopup(String amount)
	{
		sendKeys(AdminSalesTargetPage.tbx_amount, amount);
		click(AdminSalesTargetPage.btn_saveSalesTarget);
		xWaitForElementVisible(AdminSalesTargetPage.msg_successEditST, globalWait);
		xAssertEquals("Success create SalesTarget", AdminSalesTargetPage.msg_successEditST, "Sales Target edited message is displayed");
		//xAssertEquals(amount, AdminSalesTargetPage.lst_SalesTarget, "Entered amount is successfully displayed in table");
		String amount_fromTable = Utility_Functions.getText(driver, AdminSalesTargetPage.lst_SalesTarget_text, "value");
		if(amount_fromTable.equalsIgnoreCase(amount))
			report.updateTestLog("Verify Sales Target Amount updated in table", "Sales Target Amuont is updated in table", Status.PASS);
		else
			report.updateTestLog("Verify Sales Target Amount updated in table", "Sales Target Amuont is NOT updated in table", Status.FAIL);
	}
	
	/*
	 * Function to enter Amount in edit Sales Target popup in Sales Target page
	 * @author : Sairab
	 */
	
	public void enterAmountInEditSalesTargetPopup2(String amount)
	{
		sendKeys(AdminSalesTargetPage.tbx_amount, amount);
		click(AdminSalesTargetPage.btn_saveSalesTarget);
		xWaitForElementVisible(AdminSalesTargetPage.msg_successEditST, globalWait);
		xAssertEquals("Success create SalesTarget", AdminSalesTargetPage.msg_successEditST, "Sales Target edited message is displayed");
		waitForElementDisappear(AdminSalesTargetPage.msg_successEditST, globalWait);
	}
	
	/*
	 * Function to edit and verify edit of Sales Target row in Sales Target page
	 * @author : Sairab
	 */
	
	public void verifyEditSalesTarget()
	{
		//String site = selectRandomSiteName();
		//searchWithSiteName(site);
		int random = Utility_Functions.xgetRandomNumber(0, 50000);
		String amount = String.valueOf(random);
		openEditSalesTargetPopup();
		enterAmountInEditSalesTargetPopup(amount);
	}
	
	/*
	 * Function to verify UI of Add Sale Details in Sales Target page
	 * @author : Sairab
	 */
	
	public void verifyUIofAddSaleDetails()
	{
		String period = getText(AdminSalesTargetPage.hdr_period);
		String siteName = getText(AdminSalesTargetPage.lst_Sites);
		String departmentName = getText(AdminSalesTargetPage.lst_Department);
		
		String totalSales = Utility_Functions.getText(driver, AdminSalesTargetPage.lst_TotalSalesMade_text, "value");
		int number = Integer.parseInt(totalSales);
		totalSales = String.format("%,d", number);
		
		String salesTarget = Utility_Functions.getText(driver, AdminSalesTargetPage.lst_SalesTarget_text, "value");
		number = Integer.parseInt(salesTarget);
		salesTarget = String.format("%,d", number);
		
		click(AdminSalesTargetPage.lst_btn_viewDetails, "Open Add Sales Detail popup");
		xWaitForElementPresent(driver, AdminSalesTargetPage.hdr_SalesDetails, globalWait);
		
		xAssertEquals(period, AdminSalesTargetPage.hdr_salesDetail_period, "Sales Period is dispalyed correctly: ");
		xAssertEquals(siteName, AdminSalesTargetPage.lbl_siteName_saleDetail, "Site Name is dispalyed correctly: ");
		xAssertEquals(departmentName, AdminSalesTargetPage.lbl_departmentName_saleDetail, "Department Name is dispalyed correctly: ");
		xAssertEquals(totalSales, AdminSalesTargetPage.lbl_salesMadeMonthly, "Total Sales Made is dispalyed correctly: ");
		xAssertEquals(salesTarget, AdminSalesTargetPage.lbl_salesTargetMonthly, "Sales target is dispalyed correctly: ");
	}
	
	/*
	 * Function to Add Sale Details in Sales Target page
	 * @author : Sairab
	 */
	
	public void AddSaleDetails(String amount)
	{
		List<WebElement> lst_addSalesbox = getListElement(AdminSalesTargetPage.lst_addSales_box);
		List<WebElement> lst_addSalesButton = getListElement(AdminSalesTargetPage.lst_btn_addSales);
		
		if(lst_addSalesButton.isEmpty()) {
			
			dltSaleInSaleDetailPopup();
			lst_addSalesbox = getListElement(AdminSalesTargetPage.lst_addSales_box);
			lst_addSalesButton = getListElement(AdminSalesTargetPage.lst_btn_addSales);
		}
		
		int random = Utility_Functions.xgetRandomNumber(10, 20);
		Utility_Functions.xMouseHoverOnElment(lst_addSalesbox.get(random), driver);
		click(lst_addSalesButton.get(random));
		
		List<WebElement> lst_input_Sales = getListElement(AdminSalesTargetPage.lst_tbx_inputSales);
		for(WebElement element : lst_input_Sales) {
			boolean isenabled = element.isDisplayed();
			if(isenabled) {
				sendKeys(element, amount);
				break;
			}
		}
		
		List<WebElement> lst_btn_Submit = getListElement(AdminSalesTargetPage.lst_btn_inputSalesSubmit);
		for(WebElement element : lst_btn_Submit) {
			boolean isenabled = element.isDisplayed();
			if(isenabled) {
				Utility_Functions.xSendKeyBoardkeys(element, Keys.ENTER, 1);
				break;
			}
		}
		xWaitForElementPresent(driver, AdminSalesTargetPage.msg_successCreateSales, globalWait);
		xAssertEquals("Success create Sales", AdminSalesTargetPage.msg_successCreateSales, "Sales added successfully message is dispalyed: ");
		
		if(vrfySalesMadeCalculatedCorrectly())
			report.updateTestLog("Verify Total Sales Made for month is properly calculated", "Sales Made Monthly is added properly: ", Status.PASS);
		else
			report.updateTestLog("Verify Total Sales Made for month is properly calculated", "Sales Made Monthly is NOT added properly: ", Status.FAIL);
			
	}
	
	/*
	 * Function to verify the Sales Made for the month is calculated correctly  in Sales Detail popup
	 * @author : Sairab
	 */
	
	public boolean vrfySalesMadeCalculatedCorrectly() {
		
		boolean result = true;
		List<String> lst_salesFigure = xgetWebelementTextList(AdminSalesTargetPage.lst_salesFigure);
		int sales = 0;
		for(int i= 0; i<lst_salesFigure.size();i++) {
			String strTmp = lst_salesFigure.get(i);
			if(strTmp.contains(",")) {
				strTmp = strTmp.replaceAll(",", "");
			}
			int tmp = Integer.parseInt(strTmp);
			sales = sales+tmp;
		}
		String strSale = String.valueOf(sales);
		String sales_actual = getText(AdminSalesTargetPage.lbl_salesMadeMonthly);
		if(sales_actual.contains(",")) {
			sales_actual = sales_actual.replaceAll(",", "");
		}

		if(strSale.equals(sales_actual))
			result = true;
		return result;
	}
	
	/*
	 * Function to Add Sale Details for each date in Sales Detail popup
	 * @author : Sairab
	 */

	public void addSalesDetailForEachDate()
	{
		xWaitForElementPresent(driver, AdminSalesTargetPage.hdr_SalesDetails, globalWait);
		String amount = "10";
		List<WebElement> lst_addSalesbox = getListElement(AdminSalesTargetPage.lst_addSales_box);
		List<WebElement> lst_addSalesButton = getListElement(AdminSalesTargetPage.lst_btn_addSales);
		List<WebElement> lst_input_Sales = getListElement(AdminSalesTargetPage.lst_tbx_inputSales);
		List<WebElement> lst_btn_Submit = getListElement(AdminSalesTargetPage.lst_btn_inputSalesSubmit);

		boolean flag = true;

		while (flag) {

			if(lst_addSalesbox.size()>0) {

				Utility_Functions.xMouseHoverOnElment(lst_addSalesbox.get(0), driver);
				boolean displayed = lst_addSalesButton.get(0).isDisplayed();
				if(displayed) {
					click(lst_addSalesButton.get(0));
					Utility_Functions.timeWait(2);
					for(WebElement element : lst_input_Sales) {
						boolean isenabled = element.isDisplayed();
						if(isenabled) {
							sendKeys(element, amount);
						}
					}
					for(WebElement element : lst_btn_Submit) {
						boolean isenabled = element.isDisplayed();
						if(isenabled) {
							Utility_Functions.xSendKeyBoardkeys(element, Keys.ENTER, 1);
							xWaitForElementPresent(driver, AdminSalesTargetPage.msg_successCreateSales, globalWait);
							Utility_Functions.timeWait(2);
						}
					}
					lst_addSalesbox = getListElement(AdminSalesTargetPage.lst_addSales_box);
					lst_addSalesButton = getListElement(AdminSalesTargetPage.lst_btn_addSales);
				}
			}
			else {
				flag = false;
			}
		}
		if(!flag) 
			report.updateTestLog("Verify adding Sales for each date", "Successfully added Sales for each date", Status.PASS);
		
		if(vrfySalesMadeCalculatedCorrectly())
			report.updateTestLog("Verify Total Sales Made for month is properly calculated", "Sales Made Monthly is calculated properly: ", Status.PASS);
		else
			report.updateTestLog("Verify Total Sales Made for month is properly calculated", "Sales Made Monthly is NOT calculated properly: ", Status.FAIL);
	}
	
	/*
	 * Function to add and verify addition of Sales Made in Sales Target page
	 * @author : Sairab
	 */
	
	public void verifyAddSaleDetails()
	{
		int random = Utility_Functions.xgetRandomNumber(0, 50000);
		String amount = String.valueOf(random);
		verifyUIofAddSaleDetails();
		AddSaleDetails(amount);
	}	
	
	/*
	 * Function to add and verify addition of Sales Made in Sales Target page
	 * @author : Sairab
	 */
	
	public void verifySearchSaleDetailsUsingSiteName()
	{
		String site = selectRandomSiteName();
		String partial_siteName = site.substring(0, site.length()/2);
		
		if(searchWithSiteName(partial_siteName))
			report.updateTestLog("Search Sale Details using partial Site Name", "Sale Details displayed based on partial SiteName: "+partial_siteName, Status.PASS);
		else
			report.updateTestLog("Search Sale Details using partial Site Name", "Sale Details NOT displayed based on partial SiteName: "+partial_siteName, Status.FAIL);
		
		if(searchWithSiteName(site))
			report.updateTestLog("Search Sale Details using Site Name", "Sale Details displayed based on SiteName: "+site, Status.PASS);
		else
			report.updateTestLog("Search Sale Details using Site Name", "Sale Details NOT displayed based on SiteName: "+site, Status.FAIL);
	}
	
	
	/*
	 * Function to verify [Cancel] button functionality in Edit Sales Target popup
	 * @author : Sairab
	 */
	
	public void vrfyCnclFcnInEditSalesPopup()
	{
		String site = selectRandomSiteName();
		searchWithSiteName(site);
		openEditSalesTargetPopup();
		String amount_previous = getAttribute(AdminSalesTargetPage.tbx_amount, "value");
		if(amount_previous.contains(",")) {
			amount_previous = amount_previous.replaceAll(",", "");
		}
		sendKeys(AdminSalesTargetPage.tbx_amount, "100");
		click(AdminSalesTargetPage.btn_cancelSalesTarget, "Entered amount and clicked on [Cancel] button");
		Utility_Functions.timeWait(2);
		String amount_fromTable = Utility_Functions.getText(driver, AdminSalesTargetPage.lst_SalesTarget_text, "value");
		if(amount_fromTable.equalsIgnoreCase(amount_previous))
			report.updateTestLog("Verify Sales Target Amount remains unchanges in table", "Sales Target Amuont is not updated in table", Status.PASS);
		else
			report.updateTestLog("Verify Sales Target Amount remains unchanges in table", "Sales Target Amuont is updated in table", Status.FAIL);
	}
	
	/*
	 * Function to randomly search Sale Detail using random Site Name
	 * @author : Sairab
	 */
	
	public void rndmSrchSaleTargetUsngRndmSiteName()
	{
		String site = selectRandomSiteName();
		searchWithSiteName(site);
	}
	
	
	/*
	 * Function to add Sale details for multiple days for a record and verify the sum total
	 * @author : Sairab
	 */
	
	public void vrfyAddSaleDetailsForMultipleDates()
	{
		//setPeriodInSalesTargetPage(1, 1);
		rndmSrchSaleTargetUsngRndmSiteName();
		int random = Utility_Functions.xgetRandomNumber(0, 50000);
		String amount = String.valueOf(random);
		verifyUIofAddSaleDetails();
		AddSaleDetails(amount);
		waitForElementDisappear(AdminSalesTargetPage.msg_successCreateSales, globalWait);
		random = Utility_Functions.xgetRandomNumber(0, 50000);
		amount = String.valueOf(random);
		AddSaleDetails(amount);
	}
	
	/*
	 * Function to add Sale details for multiple days for a record and verify the Progress Bar
	 * @author : Sairab
	 */
	
	public void vrfyProgressBarWhenAddingSaleDetailsForMultipleDates()
	{
		//setRndmPeriodInSalesTargetPage();
		//rndmSrchSaleTargetUsngRndmSiteName();
		openEditSalesTargetPopup();
		enterAmountInEditSalesTargetPopup("100");
		verifyUIofAddSaleDetails();
		
		List<String> lst_salesFigure = xgetWebelementTextList(AdminSalesTargetPage.lst_salesFigure);
		if(!(lst_salesFigure==null)) {
			dltSaleInSaleDetailPopup();
		}
		AddSaleDetails("50");
		waitForElementDisappear(AdminSalesTargetPage.msg_successCreateSales, globalWait);
		
		WebElement element = Utility_Functions.findWebElementByClassName(driver, "progress-fill");
		int height = element.getSize().height;
		int width = element.getSize().width;
		String progress = getText(AdminSalesTargetPage.lbl_progressSales);
		
		if(height==12 && width==72 && progress.equals("50%")) {
			report.updateTestLog("Verify Progress Bar is updated", "Progress Bar is updated successfully: "+progress, Status.PASS);
		}else {
			report.updateTestLog("Verify Progress Bar is updated", "Progress Bar is NOT updated", Status.FAIL);
		}
		
		AddSaleDetails("50");
		waitForElementDisappear(AdminSalesTargetPage.msg_successCreateSales, globalWait);
		element = Utility_Functions.findWebElementByClassName(driver, "progress-fill");
		height = element.getSize().height;
		width = element.getSize().width;
		progress = getText(AdminSalesTargetPage.lbl_progressSales);
		
		if(height==12 && width==144 && progress.equals("100%")) {
			report.updateTestLog("Verify Progress Bar is updated", "Progress Bar is updated successfully: "+progress, Status.PASS);
		}else {
			report.updateTestLog("Verify Progress Bar is updated", "Progress Bar is NOT updated", Status.FAIL);
		}
	}
	
	/*
	 * Function to set month and year in Edit Sales Target popup in Sales Target page
	 * @author : Sairab
	 * @parameters: int month = month offset and int year = year offset e.g., (1,1) or (-1,-1) or (-1,1)
	 */
	
	public void setMonthYearInEditSalesTargetPopup(int month, int year)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, month);
		calendar.add(Calendar.YEAR, year);
		Date date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String[] strdate = formatter.format(date).split(" ");
		
		waitForElementClickable(AdminSalesTargetPage.tbx_amount, globalWait);
		click(AdminSalesTargetPage.ddn_month_editST);
        xSendKeyBoardkeys(driver, AdminSalesTargetPage.input_month_editST, strdate[1], Keys.ENTER);
		
        click(AdminSalesTargetPage.ddn_year_editST);
        xSendKeyBoardkeys(driver, AdminSalesTargetPage.input_year_editST, strdate[2], Keys.ENTER);
	}
	
	/*
	 * Function to edit and verify edit of Sales Target row for various months in Sales Target page
	 * @author : Sairab
	 */
	
	public void verifyEditSalesTargetForVariousMonths()
	{
		
		rndmSrchSaleTargetUsngRndmSiteName();
		Utility_Functions.xMouseHoverOnElment(AdminSalesTargetPage.lst_SalesTarget, driver);
		click(AdminSalesTargetPage.lst_btn_editSalesTarget);
		setMonthYearInEditSalesTargetPopup(1,1);
		enterAmountInEditSalesTargetPopup2("100");
		
		Utility_Functions.xMouseHoverOnElment(AdminSalesTargetPage.lst_SalesTarget, driver);
		click(AdminSalesTargetPage.lst_btn_editSalesTarget);
		setMonthYearInEditSalesTargetPopup(2,2);
		enterAmountInEditSalesTargetPopup2("100");
		
		setPeriodInSalesTargetPage(1, 1);		
		String salesTarget = getText(AdminSalesTargetPage.lst_SalesTarget);
		String period = getText(AdminSalesTargetPage.hdr_period);
		
		if(salesTarget.equals("100")) {
			report.updateTestLog("Verify Sales Target updated", "Sales Target Updated Successfully for period: "+period, Status.PASS);
		}else {
			report.updateTestLog("Verify Sales Target updated", "Sales Target NOT Updated for period: "+period, Status.FAIL);
		}
		
		setPeriodInSalesTargetPage(2, 2);		
		salesTarget = getText(AdminSalesTargetPage.lst_SalesTarget);
		period = getText(AdminSalesTargetPage.hdr_period);
		
		if(salesTarget.equals("100")) {
			report.updateTestLog("Verify Sales Target updated", "Sales Target Updated Successfully for period: "+period, Status.PASS);
		}else {
			report.updateTestLog("Verify Sales Target updated", "Sales Target NOT Updated for period: "+period, Status.FAIL);
		}
	}
	
	/*
	 * Function to open Sale Details popup for a record with non zero Total Sales Made in Sales Target page
	 * @author : Sairab
	 */
	
	public void openSaleDetailPopupHavingSaleData()
	{
		List<WebElement> lst_element = getListElement(AdminSalesTargetPage.lst_TotalSalesMade_text);
		List<WebElement> lst_viewBtn = getListElement(AdminSalesTargetPage.lst_btn_viewDetails);
		int index = 0;
		for(WebElement element : lst_element) {
			String txt_sales = Utility_Functions.getText(element, "value");
			int sales = Integer.parseInt(txt_sales);
			if(sales>0) {
				index = lst_element.indexOf(element);
				break;
			}
		}
		click(lst_viewBtn.get(index));
		xWaitForElementPresent(driver, AdminSalesTargetPage.hdr_SalesDetails, globalWait);
	}
	
	/*
	 * Function to delete Sales in the Sale Details popup
	 * @author : Sairab
	 */
	
	public void dltSaleInSaleDetailPopup()
	{
		xWaitForElementPresent(driver, AdminSalesTargetPage.hdr_SalesDetails, globalWait);
		
		List<WebElement> lst_calenderCell_element = getListElement(AdminSalesTargetPage.lst_calenderCell);
		List<WebElement> lst_dltBtn = getListElement(AdminSalesTargetPage.lst_dlt_trash);
		
		for(int i=0; i<lst_calenderCell_element.size();i++) {
			Utility_Functions.xMouseHoverOnElment(lst_calenderCell_element.get(i), driver);
			boolean displayed = lst_dltBtn.get(i).isDisplayed();
			if(displayed) {
				click(lst_dltBtn.get(i));
				Utility_Functions.timeWait(1);
				
				List<WebElement> lst_yesBtn = getListElement(AdminSalesTargetPage.lst_btn_yes);
				displayed = lst_yesBtn.get(i).isDisplayed();
				if(displayed) {
					click(lst_yesBtn.get(i));
					xWaitForElementPresent(driver, AdminSalesTargetPage.msg_successCreateSales, globalWait);
					waitForElementDisappear(AdminSalesTargetPage.msg_successCreateSales, globalWait);
				}
			}
		}
	}
	
	/*
	 * Function to delete Sales in the Sale Details popup
	 * @author : Sairab
	 */
	
	public void vrfyDltSaleFncInSaleDetailPopup()
	{
		openSaleDetailPopupHavingSaleData();
		if(xWaitForElementPresent(driver, AdminSalesTargetPage.hdr_SalesDetails, globalWait))
			report.updateTestLog("Verify Sales Detail popup is opened", "Sales Detail popup is opened", Status.PASS);
		else
			report.updateTestLog("Verify Sales Detail popup is opened", "Failed to open Sales Detail popup", Status.FAIL);
		
		dltSaleInSaleDetailPopup();
		
		String sale = getText(AdminSalesTargetPage.lbl_salesMadeMonthly);
		if(sale.equals("0"))
			report.updateTestLog("Verify Delete All Sales in Sales Detail popup", "All Sales is deleted in Sales Detail popup", Status.PASS);
		else
			report.updateTestLog("Verify Delete All Sales in Sales Detail popup", "Failed to delete all Sales in Sales Detail popup", Status.FAIL);
	}
	
	/*
	 * Function to verify Progress percentage is properly synced from Sales Details popup to table
	 * @author : Sairab
	 */
	
	public void vrfyProgressSyncedProperlyInTable()
	{
		xWaitForElementPresent(driver, AdminSalesTargetPage.lbl_progressSales, globalWait);
		String progress_popup = getText(AdminSalesTargetPage.lbl_progressSales);
		xAssertEquals(progress_popup, AdminSalesTargetPage.lst_Progress, "Progress percentage in SalesDetails popup and Table are matching!");
		
		progress_popup = progress_popup.replace("%", "");
		String size_progressBar = Utility_Functions.getText(driver, AdminSalesTargetPage.lst_Progress_Bar, "style");
		
		if(size_progressBar.contains(progress_popup))
			report.updateTestLog("Verify Progress Bar in Sales Detail table", "Progress Bar is updated!", Status.PASS);
		else
			report.updateTestLog("Verify Progress Bar in Sales Detail table", "Failed to update Progress Bar", Status.FAIL);
	}
	
	/*
	 * Function to  check Sorting by Department in Sales Target page
	 * @author : Sairab
	 */
	public void verifySortingByDepartmentInSalesTargetPage()
	{
		//Click on Site to perform sort descending
		click(AdminSalesTargetPage.tbl_hdr_Department);
		click(AdminSalesTargetPage.tbl_hdr_Department, "Clicking on Department header to perform Sort Descending");
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_Department, globalWait);
		List<String> lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Department);
		ck.checkSortingByColumn("desc", lst_text);
		
		//Click on Site to perform sort ascending
		click(AdminSalesTargetPage.tbl_hdr_Department, "Clicking on Department header to perform Sort Ascending");		
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_Department, globalWait);
		lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Department);
		ck.checkSortingByColumn("asc", lst_text);
	}
	
	/*
	 * Function to  check Sorting by Assigned Auditors in Sales Target page
	 * @author : Sairab
	 */
	public void verifySortingByAuditorsInSalesTargetPage()
	{
		//Click on Site to perform sort descending
		click(AdminSalesTargetPage.tbl_hdr_AssignedAuditors);
		click(AdminSalesTargetPage.tbl_hdr_AssignedAuditors, "Clicking on Assigned Auditors header to perform Sort Descending");
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_AssignedAuditors, globalWait);
		List<String> lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Auditor);
		
		boolean flag = lst_text.contains("Unknown");
		
		if(flag) {
			while(lst_text.contains("Unknown")) {
				lst_text.remove("Unknown");
			}
		}
		ck.checkSortingByColumn("desc", lst_text);
		
		//Click on Site to perform sort ascending
		click(AdminSalesTargetPage.tbl_hdr_AssignedAuditors, "Clicking on Assigned Auditors header to perform Sort Ascending");		
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_AssignedAuditors, globalWait);
		lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Auditor);
		ck.checkSortingByColumn("asc", lst_text);
	}
	
	/*
	 * Function to  check Sorting by Total Sales Made in Sales Target page
	 * @author : Sairab
	 */
	public void verifySortingByTotalSalesInSalesTargetPage()
	{
		//Click on Site to perform sort descending
		click(AdminSalesTargetPage.tbl_hdr_TotalSalesMade);
		click(AdminSalesTargetPage.tbl_hdr_TotalSalesMade, "Clicking on Total Sales Made header to perform Sort Descending");
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_TotalSalesMade, globalWait);
		List<String> lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_TotalSalesMade);
		
		if(lst_text.contains("-")) {
			lst_text.replaceAll(s-> s.replace("-", "0"));
		}
		List<Integer> newList = lst_text.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		ck.checkSortingByColumn2("asc", newList);
		
		//Click on Site to perform sort ascending
		click(AdminSalesTargetPage.tbl_hdr_TotalSalesMade, "Clicking on Total Sales Made header to perform Sort Ascending");		
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_TotalSalesMade, globalWait);
		lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_TotalSalesMade);
		
		if(lst_text.contains("-")) {
			lst_text.replaceAll(s-> s.replace("-", "0"));
		}
		newList = lst_text.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		ck.checkSortingByColumn2("desc", newList);
	}
	
	/*
	 * Function to  check Sorting by Sales Target in Sales Target page
	 * @author : Sairab
	 */
	public void verifySortingBySalesTargetInSalesTargetPage()
	{
		//Click on Site to perform sort descending
		click(AdminSalesTargetPage.tbl_hdr_SalesTarget);
		click(AdminSalesTargetPage.tbl_hdr_SalesTarget, "Clicking on Sales Target header to perform Sort Descending");
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_SalesTarget, globalWait);
		List<String> lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_SalesTarget);
		
		if(lst_text.contains("-")) {
			lst_text.replaceAll(s-> s.replace("-", "0"));
		}
		List<Integer> newList = lst_text.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		ck.checkSortingByColumn2("asc", newList);
		
		//Click on Site to perform sort ascending
		click(AdminSalesTargetPage.tbl_hdr_SalesTarget, "Clicking on Sales Target header to perform Sort Ascending");		
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_SalesTarget, globalWait);
		lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_SalesTarget);
		
		if(lst_text.contains("-")) {
			lst_text.replaceAll(s-> s.replace("-", "0"));
		}
		newList = lst_text.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		ck.checkSortingByColumn2("desc", newList);
	}
	
	/*
	 * Function to  check Sorting by Progress in Sales Target page
	 * @author : Sairab
	 */
	public void verifySortingByProgressInSalesTargetPage()
	{
		//Click on Site to perform sort descending
		click(AdminSalesTargetPage.tbl_hdr_Progress);
		click(AdminSalesTargetPage.tbl_hdr_Progress, "Clicking on Progress header to perform Sort Descending");
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_Progress, globalWait);
		List<String> lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Progress);
		List<String> lst_text_tmp = new ArrayList<String>();
		for(String element : lst_text) {
			element = element.substring(0, element.length()-1);
			lst_text_tmp.add(element);
		}
		List<Integer> newList = lst_text_tmp.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		ck.checkSortingByColumn2("desc", newList);
		
		//Click on Site to perform sort ascending
		click(AdminSalesTargetPage.tbl_hdr_Progress, "Clicking on Progress header to perform Sort Ascending");		
		waitForElementClickable(AdminSalesTargetPage.tbl_hdr_Progress, globalWait);
		lst_text = xgetWebelementTextList(AdminSalesTargetPage.lst_Progress);
		
		lst_text_tmp = new ArrayList<String>();
		for(String element : lst_text) {
			element = element.substring(0, element.length()-1);
			lst_text_tmp.add(element);
		}
		newList = lst_text_tmp.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		ck.checkSortingByColumn2("asc", newList);
	}
	
}
	
