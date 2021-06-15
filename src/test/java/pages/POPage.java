
package pages;

import org.openqa.selenium.By;

public class POPage {

    public static By adminPOlink = By.id("menu_purchase_order");
    public static By addPOBtn = By.id("btn_add_po");
    public static By inputPO = By.id("input_po_no");
    public static By add_sku = By.id("btn_add_sku");
    public static By add_new_Btn = By.id("btn_add_new_sku");
    public static By input_Sku_srch = By.id("input_search_sku");
    public static By addSKUList = By.xpath("//*[@id='select-sku']//span[text()='Add to List']");
    public static By input_qty_sku = By.id("input_qty_sku");
    public static By input_rate_sku = By.id("input_rate_sku");
    public static By input_batch_no = By.id("input_batch_no");
    public static By drpdwn_exp_date = By.id("drpdwn_exp_date");
    public static By destination = By.xpath("//div[@id='drpdwn_destination']");
    public static By destinationInput = By.xpath("//div[@id='drpdwn_destination']//input");
    public static By btn_submit_po=By.id("btn_submit_po");
    public static By btn_cancel_po=By.id("btn_cancel_po");
    public static By drpdwn_est_deliv=By.id("drpdwn_est_deliv");
    public static By input_notes=By.id("input_notes");
    public static By selectSite=By.id("react-select-11-option-0");
    
    /*Add PO window elements*/
    //public static By name = By.xpath("");
    
    public static By hdr_PurchaseOrderDetails = By.xpath("//div[contains(@class,'POEditor__Column')]/div[text()='Purchase Order Details']");
    public static By ddn_SelectSite = By.xpath("(//div[@id='drpdwn_destination']/div/div/div)[1]");
    public static By input_SelectSite = By.xpath("(//div[@id='drpdwn_destination']//input)[1]");
    public static By btn_Status_PO = By.id("btn_status_po");
    public static By ddn_SelectCompanyVendor = By.xpath("(//div[@id='drpdwn_vendor_nm']/div/div/div)[1]");
    public static By input_SelectCompanyVendor = By.xpath("(//div[@id='drpdwn_vendor_nm']//input)[1]");
    public static By tbx_VendorAddress = By.id("input_vendor_address");
    
    public static By skuname = By.xpath("(//*[@id='select-sku']//li//span[1])[1]");
    public static By skuname_AddToList = By.xpath("(//*[@id='select-sku']//li//span[2])[1]");
    public static By lst_header_SKUtable = By.xpath("//span[text()='All items ordered']/following-sibling::table/thead//th");
    public static By lbl_total_SKUtable = By.xpath("(//span[@class='total'])[1]");
    public static By lbl_total_value_SKUtable = By.xpath("(//span[@class='total'])[2]");
    public static By lst_input_qty_sku = By.id("input_qty_sku");
    public static By lst_input_rate_sku = By.id("input_rate_sku");
    public static By lst_input_batch_no = By.id("input_batch_no");
    public static By lst_drpdwn_exp_date = By.xpath("//input[@id='drpdwn_exp_date']");
    
    
    public static By btn_submitPO = By.xpath("//button[@id='btn_submit_po']");
    public static By btn_submitPO_reviewWindow = By.xpath("//div[@class='button-container']/button[text()='Submit']");
    public static By btn_Close_CnfrmWndw = By.xpath("//div[text()='Your purchase order has been submitted']/following-sibling::div/button[text()='Close']");
    public static By msg_POeditedSuccess = By.xpath("//div[text()='Your purchase order has been edited']");
    public static By btn_Close_CnfrmWndw_POreorder = By.xpath("//div[text()='Your purchase order has been edited']/following-sibling::div/button[text()='Close']");
    
    public static By calendar = By.xpath("(//table[contains(@class,'CalendarMonth_table')])[1]");
    public static By error_PO1 = By.xpath("//div[text()='PO item cannot be empty']");
    public static By error_PO2 = By.xpath("//div[text()='Please fill in all required fields']");
    
    
    public static By lbl_POPage_NotReady = By.xpath("//div[text()='Looks like the departments haven't been set up yet.']");
    public static By lbl_NoAccess_POpage = By.xpath("//h1[text()='No Access']");
    
	/*
	 * public static By selectDateFromCalender(String date) { return By.xpath(
	 * "//table[contains(@class,'CalendarMonth_table')]//td[contains(@aria-label,'"+
	 * date+"')]"); }
	 */
    
    
    /*PO page elements*/
    
    public static By tbx_searchPO = By.xpath("//input[@name='query']");
    public static By lst_OrderNo_POtable = By.xpath("//td[@class='order-no']");
    public static By lst_OrderDate_POtable = By.xpath("//td[@class='order-date']");
    public static By lst_TotalOrder_POtable = By.xpath("//td[@class='order-total']");
    public static By lst_Edit_POtable = By.xpath("//div[@title='Edit']");
    public static By lst_btn_reorder_POtable = By.xpath("//div[@id='btn_reorder']");
    public static By lst_RequestedBy_POtable = By.xpath("//td[@class='order-request']");
    public static By lst_VendorName_POtable = By.xpath("//td[@class='order-vendor']");
    public static By lst_Status_POtable = By.xpath("//td[@id='btn_status']");
    public static By lst_btn_StatusDelivered = By.xpath("//button[@id='btn_deliv']");
    public static By btn_status = By.xpath("//td[@id='btn_status']");
    public static By hdr_OrderNo_POTable = By.xpath("//th[@class='order-no']");
    public static By hdr_OrderDate_POTable = By.xpath("//th[@class='order-date']");
    public static By hdr_RequestedBy_POTable = By.xpath("//th[@class='order-request']");
    public static By hdr_Vendor_POTable = By.xpath("//th[@class='order-vendor']");
    public static By hdr_TotalOrder_POTable = By.xpath("//th[@class='order-total']");
    
}
