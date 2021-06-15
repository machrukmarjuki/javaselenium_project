package businesskeywords;

import com.google.common.collect.Ordering;
import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;

import commonkeywords.CommonKeys;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import pages.AdminSalesTargetPage;
import pages.AdminSitePage;
import pages.DashboardPage;
import pages.InventoryPage;
import pages.POPage;
import supportLibraries.Utility_Functions;

import static supportLibraries.Utility_Functions.xSendKeyBoardkeys;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PurchaseOrder extends ReusableLib {
	/**
	 * Constructor to initialize the {@link Helper} object and in turn the objects
	 * wrapped by it
	 *
	 * @param helper The {@link Helper} object
	 */

	CommonKeys ck;

	public PurchaseOrder(Helper helper) {
		super(helper);
		ck = new CommonKeys(helper);
	}

	Inventory inventory = new Inventory(helper);

	public void navToPO() {
		click(AdminSitePage.adminBtn);
		click(AdminSitePage.manageLink, "Clicked on Manage link ");
		click(POPage.adminPOlink, "Clicked on Purchase Order  link ");
		waitForElementClickable(POPage.addPOBtn, globalWait);
	}

	public void createPO() {
		String siteName = Utility_Functions.xGetJsonAsString("SiteName");
		click(POPage.addPOBtn);
		click(POPage.destination, "Click on Destination");
		Utility_Functions.timeWait(1);
		xSendKeyBoardkeys(driver, POPage.destinationInput, siteName, Keys.ENTER);
		System.out.println("selected");
		click(POPage.add_sku);
//        click(POPage.add_new_Btn);
		inventory.addSKUCommon("POSKU");
		click(POPage.add_sku);
		String skuName = Utility_Functions.xGetJsonAsString("SKUName");
		sendKey(POPage.input_Sku_srch, skuName);
		Utility_Functions.xMouseOver(driver, POPage.addSKUList);
		click(POPage.addSKUList);
		sendKey(POPage.input_qty_sku, "2");

	}

	/*
	 * Function to verify successfull navigation to Admin - Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void navigationToAdminPurchaseOrderPage() {
		Utility_Functions.xWaitForElementPresentInPage(driver, DashboardPage.lst_crclProgressBar, 90);
		click(AdminSitePage.adminBtn);

		// Refresh page if No Access is displayed
		if (Utility_Functions.xWaitForElementPresent(driver, POPage.lbl_NoAccess_POpage, 1)) {
			refreshPage();
		}
		waitForElementClickable(AdminSitePage.dltBtn, globalWait);
		click(AdminSitePage.manageLink, "Clicked on Manage link ");
		click(POPage.adminPOlink, "Clicked on Purchase Order  link ");

		// wait to disappear message - page is not ready
		if (Utility_Functions.xWaitForElementPresent(driver, POPage.lbl_POPage_NotReady, 2))
			waitForElementDisappear(POPage.lbl_POPage_NotReady, globalWait);

		// Refresh page if No Access is displayed
		if (Utility_Functions.xWaitForElementPresent(driver, POPage.lbl_NoAccess_POpage, 1)) {
			refreshPage();
		}

		waitForElementClickable(POPage.addPOBtn, globalWait);
		if (xWaitForElementVisible(POPage.addPOBtn, globalWait))
			report.updateTestLog("Verify Admin - Purchase Order page is launched", "Admin - Purchase Order Page is launched", Status.PASS);
		else
			report.updateTestLog("Verify Admin - Purchase Order page is launched", "Admin - Purchase Order Page is not launched", Status.FAIL);
	}

	/*
	 * Function to verify successfull navigation to Admin - Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void verifyUIofPurchaseOrderPage() {
		vrfyElmentExist(POPage.addPOBtn, "Add Purchase Order button is present");
		vrfyElmentExist(POPage.tbx_searchPO, "Search Purchase Order textbox is present");
		if (xWaitForElementVisible(POPage.lst_OrderNo_POtable, globalWait))
			report.updateTestLog("Verify UI of PO page", "Purchase Order table is displayed", Status.PASS);
		else
			report.updateTestLog("Verify UI of PO page", "Purchase Order table is NOT displayed", Status.FAIL);
	}

	/*
	 * Function to click on Add Purchase Order button in Admin - Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void clickOnAddPurchaseOrderButton() {
		click(POPage.addPOBtn);
		if (xWaitForElementVisible(POPage.hdr_PurchaseOrderDetails, globalWait))
			report.updateTestLog("Verify Add Purchase Order window is launched",
					"Add Purchase Order window is launched", Status.PASS);
		else
			report.updateTestLog("Verify Add Purchase Order window is launched",
					"Add Purchase Order window is not launched", Status.FAIL);
	}

	/*
	 * Function to verify UI elements in Add Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void verifyUIelementsInAddPOpage() {
		vrfyElmentExist(POPage.hdr_PurchaseOrderDetails, "Purchase Order Details header is present");
		vrfyElmentExist(POPage.inputPO, "Purchase Order Number textbox is present");
		vrfyElmentExist(POPage.ddn_SelectSite, "Select Site dropdown is present");
		vrfyElmentExist(POPage.btn_Status_PO, "Purchase Order Status button is present");
		vrfyElmentExist(POPage.ddn_SelectCompanyVendor, "Company Vendor dropdown is present");
		vrfyElmentExist(POPage.tbx_VendorAddress, "Vendor Address textarea is present");
		vrfyElmentExist(POPage.drpdwn_est_deliv, "Estimated Delivery datepicker is present");
		vrfyElmentExist(POPage.input_notes, "Delivery Notes textarea is present");

		List<String> headers_text_Expected = new ArrayList<>();
		headers_text_Expected.add("");
		headers_text_Expected.add("SKU Name");
		headers_text_Expected.add("SKU No.");
		headers_text_Expected.add("Qty");
		headers_text_Expected.add("Rate");
		headers_text_Expected.add("Batch No.");
		headers_text_Expected.add("Expiry Date");
		headers_text_Expected.add("Amount");
		headers_text_Expected.add("");

		List<String> headers_text = xgetWebelementTextList(POPage.lst_header_SKUtable);
		if (headers_text_Expected.equals(headers_text))
			report.updateTestLog("Verify the SKU table headers", "Successfully verified SKU table headers",
					Status.PASS);
		else
			report.updateTestLog("Verify the SKU table headers", "Failed to verify SKU table headers", Status.FAIL);

		vrfyElmentExist(POPage.add_sku, "Add SKU button is present");
		vrfyElmentExist(POPage.lbl_total_SKUtable, "SKU table TOTAL label is present");
		vrfyElmentExist(POPage.lbl_total_value_SKUtable, "SKU table TOTAL value is present");
	}

	/*
	 * Function to enter PO number and destination in Add Purchase Order window
	 * 
	 * @author : Sairab
	 */
	public void enterPONumberAndDestinationInAddPOWindow() {
		String purchaseOrderNumber = "PO_" + RandomStringUtils.randomAlphanumeric(6);
		Utility_Functions.xUpdateJson("PONumber", purchaseOrderNumber);
		String siteName = Utility_Functions.xGetJsonAsString("SiteName");
		waitForElementPresent(POPage.inputPO);
		click(POPage.inputPO, "Click and enter PO number");
		sendKeys(POPage.inputPO, purchaseOrderNumber);
		click(POPage.ddn_SelectSite, "Click and enter Destination");
		Utility_Functions.timeWait(1);
		xSendKeyBoardkeys(driver, POPage.input_SelectSite, siteName, Keys.ENTER);
	}

	/*
	 * Function to enter Vendor Name and Address in Add Purchase Order window
	 * 
	 * @author : Sairab
	 */
	public void enterNewVendorNameAddressInAddPOWindow() {
		String randomNuber = RandomStringUtils.randomAlphanumeric(6);
		String vendorName = "VendorName_" + randomNuber;
		String vendorAddress = "3320 Cherry St, Vancouver,BC";
		Utility_Functions.xUpdateJson("POVendorName", vendorName);

		waitForElementPresent(POPage.ddn_SelectCompanyVendor);
		Utility_Functions.xScrollIntoView(driver, POPage.ddn_SelectCompanyVendor);
		click(POPage.ddn_SelectCompanyVendor, "Click and enter Company Vendor name");
		xSendKeyBoardkeys(driver, POPage.input_SelectCompanyVendor, vendorName, Keys.ENTER);
		click(POPage.tbx_VendorAddress, "Click and dnter Company Vendor Address");
		xSendKeyBoardkeys(driver, POPage.tbx_VendorAddress, vendorAddress, Keys.ENTER);
	}

	/*
	 * Function to enter Estimated Delivery and Notes in Add Purchase Order window
	 * 
	 * @author : Sairab
	 */
	public void enterEstimatedDeliveryAndNotesInAddPOWindow() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		Date date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String strDate = formatter.format(date);
		waitForElementPresent(POPage.drpdwn_est_deliv);
		Utility_Functions.xScrollIntoView(driver, POPage.drpdwn_est_deliv);
		click(POPage.drpdwn_est_deliv, "Click and enter Estimated Delivery Date");
		sendKeys(POPage.drpdwn_est_deliv, strDate);
		click(POPage.input_notes, "Click and enter Delivery notes");
		sendKeys(POPage.input_notes, "Automation Test Additional Notes");

	}

	/*
	 * Function to add existing SKU randomly from available SKU's in Add/Edit
	 * Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void selectExistingSKUfromAvailableListInAddPOWindow() {
		waitForElementPresent(POPage.add_sku);
		click(POPage.add_sku);
		Utility_Functions.timeWait(2);
		String text = getText(POPage.skuname);

		sendKey(POPage.input_Sku_srch, text);
		Utility_Functions.xMouseHoverOnElment(POPage.skuname, driver);
		click(POPage.skuname);
		if (xWaitForElementVisible(POPage.input_qty_sku, globalWait))
			report.updateTestLog("Verify existing SKU is added", "Added existing SKU", Status.PASS);
		else
			report.updateTestLog("Verify existing SKU is added", "Failed to add existing SKU", Status.FAIL);
	}

	/*
	 * Function to add new SKU Add Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void addNewSKUinAddPOWindow() {
		click(POPage.add_sku);
		inventory.addSKUCommon("POSKU");
		click(POPage.add_sku);
		waitForElementPresent(POPage.input_Sku_srch);
		String skuName = Utility_Functions.xGetJsonAsString("SKUName");
		sendKey(POPage.input_Sku_srch, skuName);
		Utility_Functions.timeWait(1);
		Utility_Functions.xMouseHoverOnElment(POPage.skuname, driver);
		Utility_Functions.timeWait(1);
		click(POPage.skuname_AddToList);
		if (xWaitForElementVisible(POPage.input_qty_sku, globalWait))
			report.updateTestLog("Verify existing SKU is added", "Added New SKU", Status.PASS);
		else
			report.updateTestLog("Verify existing SKU is added", "Failed to add New SKU", Status.FAIL);
	}

	/*
	 * Function to enter SKU details in Add Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void enterSingleSKUDetailsInAddPOWindow() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String strDate = formatter.format(date);

		sendKeys(POPage.input_qty_sku, "10");
		sendKeys(POPage.input_rate_sku, "20");
		sendKeys(POPage.input_batch_no, "30");
		sendKeys(POPage.drpdwn_exp_date, strDate);
	}

	/*
	 * Function to enter details of multiple SKU in Add Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void enterMultipleSKUDetailsInAddPOWindow() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String strDate = formatter.format(date);
		String quantity = "10";
		String rate = "100";
		String batch = "AB2021";

		List<WebElement> lst_quantity = getListElement(POPage.lst_input_qty_sku);
		for (WebElement element : lst_quantity) {
			sendKeys(element, quantity);
		}

		List<WebElement> lst_rate = getListElement(POPage.lst_input_rate_sku);
		for (WebElement element : lst_rate) {
			sendKeys(element, rate);
		}

		List<WebElement> lst_batch = getListElement(POPage.lst_input_batch_no);
		for (WebElement element : lst_batch) {
			sendKeys(element, batch);
		}

		List<WebElement> lst_date = getListElement(POPage.lst_drpdwn_exp_date);
		for (WebElement element : lst_date) {
			sendKeys(element, strDate);
			click(POPage.input_qty_sku);
		}
	}

	/*
	 * Function to submit and confirm changes in Add Purchase Order page
	 * 
	 * @author : Sairab
	 */
	public void submitAndConfirmChagesInAddPOWindow() {
		click(POPage.btn_submitPO);
		click(POPage.btn_submitPO_reviewWindow);
		click(POPage.btn_Close_CnfrmWndw);
		if (xWaitForElementVisible(POPage.addPOBtn, globalWait))
			report.updateTestLog("Verify PO is added", "PO is Added successfully", Status.PASS);
		else
			report.updateTestLog("Verify PO is added", "Failed to Add PO", Status.FAIL);
	}

	/*
	 * Function to submit and confirm changes in Edit Purchase Order page when
	 * reorder
	 * 
	 * @author : Sairab
	 */
	public void submitAndConfirmChagesInEditPOWindow() {
		click(POPage.btn_submitPO);
		click(POPage.btn_submitPO_reviewWindow);
		vrfyElmentExist(POPage.msg_POeditedSuccess, "Your purchase order has been edited - message is displayed");
		click(POPage.btn_Close_CnfrmWndw_POreorder);
		if (xWaitForElementVisible(POPage.addPOBtn, globalWait))
			report.updateTestLog("Verify reorder PO is successfull", "Reorder PO is successful", Status.PASS);
		else
			report.updateTestLog("Verify reorder PO is successfull", "Failed to reorder PO", Status.FAIL);
	}

	/*
	 * Function to search and verify created PO using Order number in Purchase Order
	 * page
	 * 
	 * @author : Sairab
	 */
	public void searchPObyOrderNumber(String orderNo) {

		waitForElementPresent(POPage.tbx_searchPO);
		sendKeys(POPage.tbx_searchPO, orderNo);
		Utility_Functions.xWaitForElementPresentInPage(driver, POPage.lst_OrderNo_POtable, globalWait);
		Utility_Functions.timeWait(4);
		String orderNo_Actual = Utility_Functions.getText(driver, POPage.lst_OrderNo_POtable);
		if (orderNo_Actual.equalsIgnoreCase(orderNo))
			report.updateTestLog("Verify PO is added", "Search for added PO is successfull", Status.PASS);
		else
			report.updateTestLog("Verify PO is added", "Failed to search for the Added PO", Status.FAIL);

	}

	/*
	 * Function to search and verify created PO using Requested By in Purchase Order
	 * page
	 * 
	 * @author : Sairab
	 */
	public void searchPObyRequestedBy(String requestedBy) {

		waitForElementPresent(POPage.tbx_searchPO);
		sendKeys(POPage.tbx_searchPO, requestedBy);
		Utility_Functions.timeWait(4);
		List<String> lst_requestedBy = xgetWebelementTextList(POPage.lst_RequestedBy_POtable);
		int count = 0;
		for (String text : lst_requestedBy) {
			if (text.contains(requestedBy)) {
				count++;
			}
		}
		if (count == lst_requestedBy.size())
			report.updateTestLog("Verify PO table displays records searched with Requested By: " + requestedBy,
					"PO table displays records based on Requested By: " + requestedBy, Status.PASS);
		else
			report.updateTestLog("Verify PO table displays records searched with Requested By: " + requestedBy,
					"PO table does not displays records based on Requested By: " + requestedBy, Status.FAIL);
	}

	/*
	 * Function to search and verify created PO using Vendor Name in Purchase Order
	 * page
	 * 
	 * @author : Sairab
	 */
	public void searchPObyVendorName(String vendorName) {

		waitForElementPresent(POPage.tbx_searchPO);
		sendKeys(POPage.tbx_searchPO, vendorName);
		Utility_Functions.timeWait(4);
		List<String> lst_vendorName = xgetWebelementTextList(POPage.lst_VendorName_POtable);
		int count = 0;
		for (String text : lst_vendorName) {
			if (text.contains(vendorName)) {
				count++;
			}
		}
		if (count == lst_vendorName.size())
			report.updateTestLog("Verify PO table displays records searched with Vendor Name: " + vendorName,
					"PO table displays records based on Vendor Name: " + vendorName, Status.PASS);
		else
			report.updateTestLog("Verify PO table displays records searched with Vendor Name: " + vendorName,
					"PO table does not displays records based on Vendor Name: " + vendorName, Status.FAIL);

	}

	/*
	 * Function to Add a Purchase Order and search for the PO to verify successful
	 * creation
	 * 
	 * @author : Sairab
	 */
	public void addNewPOandVerify() {
		clickOnAddPurchaseOrderButton();
		enterPONumberAndDestinationInAddPOWindow();
		enterNewVendorNameAddressInAddPOWindow();
		enterEstimatedDeliveryAndNotesInAddPOWindow();
		addNewSKUinAddPOWindow();
		enterSingleSKUDetailsInAddPOWindow();
		submitAndConfirmChagesInAddPOWindow();
		String orderNo = Utility_Functions.xGetJsonAsString("PONumber");
		searchPObyOrderNumber(orderNo);
	}

	/*
	 * Function to Add a Purchase Order and search for the PO to verify successful
	 * creation
	 * 
	 * @author : Sairab
	 */
	public void addNewPOwithMultipleSKUandVerify() {
		clickOnAddPurchaseOrderButton();
		enterPONumberAndDestinationInAddPOWindow();
		enterNewVendorNameAddressInAddPOWindow();
		enterEstimatedDeliveryAndNotesInAddPOWindow();
		addNewSKUinAddPOWindow();
		addNewSKUinAddPOWindow();
		enterMultipleSKUDetailsInAddPOWindow();
		submitAndConfirmChagesInAddPOWindow();
		String orderNo = Utility_Functions.xGetJsonAsString("PONumber");
		searchPObyOrderNumber(orderNo);
	}

	/*
	 * Function to verify SKU required error in Add PO window
	 * 
	 * @author : Sairab
	 */
	public void verifySKUrequiredErrorInAddPPOWindow() {
		clickOnAddPurchaseOrderButton();
		enterPONumberAndDestinationInAddPOWindow();
		enterNewVendorNameAddressInAddPOWindow();
		enterEstimatedDeliveryAndNotesInAddPOWindow();
		click(POPage.btn_submitPO);
		click(POPage.btn_submitPO_reviewWindow);
		xAssertEquals("PO item cannot be empty", POPage.error_PO1, "Error message is displayed: ");
	}

	/*
	 * Function to search and verify Purchase Order using - Order Number, Requested
	 * By and Vendor Name
	 * 
	 * @author : Sairab
	 */
	public void verifySearchPOfunctionality() {
		List<String> lst_element = xgetWebelementTextList(POPage.lst_OrderNo_POtable);
		int random = Utility_Functions.xgetRandomNumber(0, lst_element.size() - 1);
		String orderNo = lst_element.get(random);

		lst_element = xgetWebelementTextList(POPage.lst_RequestedBy_POtable);
		String requestedBy = lst_element.get(random);

		lst_element = xgetWebelementTextList(POPage.lst_VendorName_POtable);
		String vendorName = lst_element.get(random);

		searchPObyOrderNumber(orderNo);
		searchPObyRequestedBy(requestedBy);
		searchPObyVendorName(vendorName);
	}

	/*
	 * Function to open an existing PO with the desired status
	 * 
	 * @author : Sairab
	 * 
	 * @param module pass status of PO to open e.g. In Progress = open a PO with In
	 * Progress status Delivered = open a PO with Delivered status
	 */
	public void openExistingPOfromPOtable(String desiredStatus) {
		waitForElementPresent(POPage.lst_OrderNo_POtable);
		String PO_orderNumber = "";
		List<WebElement> orderNo = getListElement(POPage.lst_OrderNo_POtable);
		List<WebElement> status = getListElement(POPage.lst_Status_POtable);

		for (WebElement element : status) {
			String status_text = element.getText();
			if (status_text.equalsIgnoreCase(desiredStatus)) {
				int desiredIndex = status.indexOf(element);
				PO_orderNumber = Utility_Functions.getText(driver, orderNo.get(desiredIndex));
				click(orderNo.get(desiredIndex), "Clicked on PO number with status: " + desiredStatus);
			}
		}
		waitForElementPresent(POPage.inputPO);
		String PO_orderNumber_opened = Utility_Functions.getText(driver, POPage.inputPO);

		if (PO_orderNumber.equalsIgnoreCase(PO_orderNumber_opened))
			report.updateTestLog("Verify existing PO with Status: " + desiredStatus + " is opened",
					"Existing PO with Status: " + desiredStatus + " is opened", Status.PASS);
		else
			report.updateTestLog("Verify existing PO with Status: " + desiredStatus + " is opened",
					"Failed to open existing PO", Status.FAIL);
	}

	/*
	 * Function to change status of an In Progress PO to Delivered
	 * 
	 * @author : Sairab
	 * 
	 */
	public void changeStatusOfPOtoDeliveredFromPOtable() {
		String status = "In Progress";
		String orderNo = "";
		waitForElementPresent(POPage.lst_OrderNo_POtable);

		List<WebElement> lst_status = getListElement(POPage.lst_Status_POtable);
		List<WebElement> lst_btn_statusDelivered = getListElement(POPage.lst_btn_StatusDelivered);
		List<WebElement> lst_orderNo = getListElement(POPage.lst_OrderNo_POtable);

		for (WebElement element : lst_status) {
			String status_text = element.getText();
			if (status_text.equalsIgnoreCase(status)) {
				int desiredIndex = lst_status.indexOf(element);
				orderNo = lst_orderNo.get(desiredIndex).getText();
				click(element, "Clicked on status of a PO with status: " + status);
				Utility_Functions.timeWait(1);
				click(lst_btn_statusDelivered.get(desiredIndex),
						"Clicked on Delivered button to change status of a PO");
				Utility_Functions.timeWait(1);
				break;
			}
		}
		searchPObyOrderNumber(orderNo);
		String status_Actual = Utility_Functions.getText(driver, POPage.btn_status);

		if (status_Actual.equalsIgnoreCase("Delivered"))
			report.updateTestLog("Verify status of PO is cahnged to Delivered",
					"Status of PO is changed to :" + status_Actual, Status.PASS);
		else
			report.updateTestLog("Verify status of PO is cahnged to Delivered",
					"Failed to change status of PO, status is showing as :" + status_Actual, Status.FAIL);
	}

	/*
	 * Function to click on Status of a an In Progress PO
	 * 
	 * @author : Sairab
	 * 
	 * @param module pass status of PO to open e.g. In Progress = open a PO with In
	 * Progress status Delivered = open a PO with Delivered status
	 */
	public void openReorderPOfromPOtable(String desiredStatus) {
		waitForElementPresent(POPage.lst_OrderNo_POtable);
		String orderNo = "";

		switch (desiredStatus) {
		case "In Progress":
			clickOnAddPurchaseOrderButton();
			enterPONumberAndDestinationInAddPOWindow();
			enterNewVendorNameAddressInAddPOWindow();
			enterEstimatedDeliveryAndNotesInAddPOWindow();
			addNewSKUinAddPOWindow();
			enterSingleSKUDetailsInAddPOWindow();
			orderNo = Utility_Functions.getText(driver, POPage.inputPO, "Value");
			submitAndConfirmChagesInAddPOWindow();
			searchPObyOrderNumber(orderNo);
			click(POPage.lst_Edit_POtable);
			click(POPage.lst_btn_reorder_POtable);
			break;
		case "Delivered":
			clickOnAddPurchaseOrderButton();
			enterPONumberAndDestinationInAddPOWindow();
			enterNewVendorNameAddressInAddPOWindow();
			enterEstimatedDeliveryAndNotesInAddPOWindow();
			addNewSKUinAddPOWindow();
			enterSingleSKUDetailsInAddPOWindow();
			orderNo = Utility_Functions.getText(driver, POPage.inputPO, "Value");
			submitAndConfirmChagesInAddPOWindow();
			searchPObyOrderNumber(orderNo);
			click(POPage.lst_Status_POtable);
			click(POPage.lst_btn_StatusDelivered);
			click(POPage.lst_Edit_POtable);
			click(POPage.lst_btn_reorder_POtable);
			break;
		}
		waitForElementPresent(POPage.inputPO);
	}

	/*
	 * Function to create PO if POnumber is null inMiddleLayerDataFile
	 * 
	 * @author : Sairab
	 */
	public void createPOifPOdoesNotExist() {
		String orderNo = Utility_Functions.xGetJsonAsString("PONumber");
		if (orderNo == null) {
			clickOnAddPurchaseOrderButton();
			enterPONumberAndDestinationInAddPOWindow();
			enterNewVendorNameAddressInAddPOWindow();
			enterEstimatedDeliveryAndNotesInAddPOWindow();
			addNewSKUinAddPOWindow();
			enterSingleSKUDetailsInAddPOWindow();
			submitAndConfirmChagesInAddPOWindow();
		}
	}

	/*
	 * Function to reorder from a PO with In Progress state
	 * 
	 * @author : Sairab
	 */
	public void reorderFromExistingPO() {
		openReorderPOfromPOtable("In Progress");
		enterPONumberAndDestinationInAddPOWindow();
		enterNewVendorNameAddressInAddPOWindow();
		enterEstimatedDeliveryAndNotesInAddPOWindow();
		enterMultipleSKUDetailsInAddPOWindow();
		String orderNo = Utility_Functions.getText(driver, POPage.inputPO, "Value");
		submitAndConfirmChagesInEditPOWindow();
		searchPObyOrderNumber(orderNo);
	}

	/*
	 * Function to reorder from a PO with Delivered state
	 * 
	 * @author : Sairab
	 */
	public void reorderFromExistingPOinDelivered() {
		openReorderPOfromPOtable("Delivered");
		enterPONumberAndDestinationInAddPOWindow();
		enterNewVendorNameAddressInAddPOWindow();
		enterEstimatedDeliveryAndNotesInAddPOWindow();
		enterMultipleSKUDetailsInAddPOWindow();
		String orderNo = Utility_Functions.getText(driver, POPage.inputPO, "Value");
		submitAndConfirmChagesInEditPOWindow();
		searchPObyOrderNumber(orderNo);
	}

	/*
	 * Function to verify error displayed when providing past Date in date pickers
	 * 
	 * @author : Sairab
	 */
	public void verifyDateErrorInAddPOpage() {
		clickOnAddPurchaseOrderButton();
		enterPONumberAndDestinationInAddPOWindow();
		enterNewVendorNameAddressInAddPOWindow();

		// Entering past date in Estimated Delivery Date
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		String strDate = formatter.format(date);
		Utility_Functions.xScrollIntoView(driver, POPage.drpdwn_est_deliv);
		click(POPage.drpdwn_est_deliv, "Click and enter past in Estimated Delivery Date: " + strDate);
		sendKeys(POPage.drpdwn_est_deliv, strDate);
		click(POPage.tbx_VendorAddress);
		click(POPage.input_notes, "Click and enter Delivery notes");
		sendKeys(POPage.input_notes, "Automation Test Additional Notes");

		// Adding new SKU
		addNewSKUinAddPOWindow();

		// Entering data in SKU table
		sendKeys(POPage.input_qty_sku, "10");
		sendKeys(POPage.input_rate_sku, "20");
		sendKeys(POPage.input_batch_no, "30");
		sendKeys(POPage.drpdwn_exp_date, strDate);

		// Click [submit] and verify error
		click(POPage.btn_submitPO);
		xAssertEquals("Please fill in all required fields", POPage.error_PO2, "Error message is displayed: ");

	}

	/*
	 * Function to check Sorting by Order No in PO page
	 * 
	 * @author : Sairab
	 */
	public void verifySortingByOrderNoInPOpage() {

		click(POPage.hdr_OrderNo_POTable, "Clicking on Order No to perform Ascending Sorting");
		Utility_Functions.timeWait(3);
		String orderNo_SortingType = Utility_Functions.getText(driver, POPage.hdr_OrderNo_POTable, "id");
		List<String> lst_orderNo = xgetWebelementTextList(POPage.lst_OrderNo_POtable);
		ck.checkSortingByColumn(orderNo_SortingType, lst_orderNo);
		// checkSortingByOrderNoInPOpage();

		click(POPage.hdr_OrderNo_POTable, "Clicking on Order No to perform Sorting");
		Utility_Functions.timeWait(3);
		orderNo_SortingType = Utility_Functions.getText(driver, POPage.hdr_OrderNo_POTable, "id");
		lst_orderNo = xgetWebelementTextList(POPage.lst_OrderNo_POtable);
		ck.checkSortingByColumn("desc", lst_orderNo);
		// checkSortingByOrderNoInPOpage();
	}

	
	/*
	 * Function to check Sorting by Order Date in PO page
	 * 
	 * @author : Sairab
	 */
	public void verifySortingByOrderDateInPOpage() {
		click(POPage.hdr_OrderDate_POTable, "Clicking on Order Date to perform Descending Sorting");
		Utility_Functions.timeWait(3);
		String sortingType = Utility_Functions.getText(driver, POPage.hdr_OrderDate_POTable, "id");
		List<String> lst_text = xgetWebelementTextList(POPage.lst_OrderDate_POtable);
		ck.checkSortingByColumn(sortingType, lst_text);
		// checkSortingByOrderDateInPOpage();

		click(POPage.hdr_OrderDate_POTable, "Clicking on Order Date to perform Ascending Sorting");
		Utility_Functions.timeWait(3);
		sortingType = Utility_Functions.getText(driver, POPage.hdr_OrderDate_POTable, "id");
		lst_text = xgetWebelementTextList(POPage.lst_OrderDate_POtable);
		ck.checkSortingByColumn(sortingType, lst_text);

		// checkSortingByOrderDateInPOpage();
	}

	
	/*
	 * Function to check Sorting by Requested By in PO page
	 * 
	 * @author : Sairab
	 */
	public void verifySortingByRequestedByInPOpage() {
		click(POPage.hdr_RequestedBy_POTable, "Clicking on Requested By to perform Ascending Sorting");
		Utility_Functions.timeWait(3);
		String sortingType = Utility_Functions.getText(driver, POPage.hdr_RequestedBy_POTable, "id");
		List<String> lst_text = xgetWebelementTextList(POPage.lst_RequestedBy_POtable);
		ck.checkSortingByColumn(sortingType, lst_text);
		// checkSortingByRequestedByInPOpage();

		click(POPage.hdr_RequestedBy_POTable, "Clicking on Requested By to perform Sorting");
		Utility_Functions.timeWait(3);
		sortingType = Utility_Functions.getText(driver, POPage.hdr_RequestedBy_POTable, "id");
		lst_text = xgetWebelementTextList(POPage.lst_RequestedBy_POtable);
		ck.checkSortingByColumn(sortingType, lst_text);

		// checkSortingByRequestedByInPOpage();
	}

	
	/*
	 * Function to check Sorting by Vendor in PO page
	 * 
	 * @author : Sairab
	 */
	public void verifySortingByVendorInPOpage() {
		click(POPage.hdr_Vendor_POTable, "Clicking on Vendor to perform Sorting");
		Utility_Functions.timeWait(3);
		String sortingType = Utility_Functions.getText(driver, POPage.hdr_Vendor_POTable, "id");
		List<String> lst_text = xgetWebelementTextList(POPage.lst_VendorName_POtable);
		ck.checkSortingByColumn(sortingType, lst_text);
		// checkSortingByVendorInPOpage();

		click(POPage.hdr_Vendor_POTable, "Clicking on Vendor to perform Sorting");
		Utility_Functions.timeWait(3);
		sortingType = Utility_Functions.getText(driver, POPage.hdr_Vendor_POTable, "id");
		lst_text = xgetWebelementTextList(POPage.lst_VendorName_POtable);
		ck.checkSortingByColumn(sortingType, lst_text);
		// checkSortingByVendorInPOpage();
	}

	
	/*
	 * Function to check Sorting by Vendor in PO page
	 * 
	 * @author : Sairab
	 */
	public void verifySortingByTotalOrderInPOpage() {
		click(POPage.hdr_TotalOrder_POTable, "Clicking on Total Order to perform Sorting");
		Utility_Functions.timeWait(3);
		String sortingType = Utility_Functions.getText(driver, POPage.hdr_TotalOrder_POTable, "id");
		List<String> lst_text = xgetWebelementTextList(POPage.lst_TotalOrder_POtable);
		//List<Integer> newList = lst_text.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		ck.checkSortingByColumn(sortingType, lst_text);
		// checkSortingByTotalOrderInPOpage();

		click(POPage.hdr_TotalOrder_POTable, "Clicking on Total Order to perform Sorting");
		Utility_Functions.timeWait(3);
		sortingType = Utility_Functions.getText(driver, POPage.hdr_TotalOrder_POTable, "id");
		lst_text = xgetWebelementTextList(POPage.lst_TotalOrder_POtable);
		//newList = lst_text.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		ck.checkSortingByColumn(sortingType, lst_text);
		// checkSortingByTotalOrderInPOpage();
	}
}
