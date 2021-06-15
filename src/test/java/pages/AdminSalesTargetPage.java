package pages;

import org.openqa.selenium.By;
import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;

public class AdminSalesTargetPage extends ReusableLib{

	public AdminSalesTargetPage(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}
	
	//Top Filters
	
	public static By btn_SalesTargetMenu = By.id("menu_adm_sales_target");
	public static By tbx_searchSales = By.id("input_search_sales");
	public static By hdr_period = By.xpath("//div[@class='section period']/h6");
	public static By btn_editPeriod = By.id("btn_save_period");
	public static By ddn_month = By.xpath("//div[@id='drpdwn_month']/div[1]/div[1]/div[1]");
	public static By ddn_input_month = By.xpath("(//div[@id='drpdwn_month']//input)[1]");
	public static By ddn_year = By.xpath("//div[@id='drpdwn_years']/div[1]/div[1]/div[1]");
	public static By ddn_input_year = By.xpath("(//div[@id='drpdwn_years']//input)[1]");
	public static By btn_UploadSales = By.id("btn_upload_sales");
	public static By btn_UploadTarget = By.id("btn_upload_target");
	
	//Sales Target table elements
	
	public static By tbl_hdr_Site = By.xpath("//th[@class='col-name']");
	public static By tbl_hdr_Department = By.xpath("//th[@class='col-department']");
	public static By tbl_hdr_AssignedAuditors = By.xpath("//th[@class='col-auditor']");
	public static By tbl_hdr_TotalSalesMade = By.xpath("//th[@class='col-figure']");
	public static By tbl_hdr_SalesTarget = By.xpath("//th[@class='col-target']");
	public static By tbl_hdr_Progress = By.xpath("//th[@class='col-score']");
	
	public static By lst_Sites = By.xpath("//td[@class='col-name']");
	public static By lst_Department = By.xpath("//td[@class='col-department']");
	public static By lst_Auditor = By.xpath("//td[@class='col-auditor']");
	public static By lst_TotalSalesMade = By.xpath("//td[@class='col-figure']");
	public static By lst_TotalSalesMade_text = By.xpath("//span[@class='col-figure-value']");
	
	public static By lst_SalesTarget = By.xpath("//td[@class='col-target']");
	public static By lst_SalesTarget_text = By.xpath("//span[@class='col-target-value']");
	
	public static By lst_btn_editSalesTarget = By.xpath("//span[@class='col-target-edit']");
	public static By lst_Progress = By.xpath("//td[@class='col-score']");
	public static By lst_Progress_Bar = By.xpath("//td[@class='col-score']/div[1]/div[2]/div");
	
	public static By lst_btn_viewDetails = By.id("btn_view_detail");
	
	public static By btn_leftArrow_pageNavigation = By.id("btn_left_arrow");
	public static By btn_rightArrow_pageNavigation = By.id("btn_right_arrow");
	public static By lst_pageNumbers = By.xpath("//button[@id='btn_left_arrow']/following-sibling::button[not(@id='btn_right_arrow')]");
	
	//Sales Target modal elements

	public static By title_period = By.xpath("//div[contains(@class,'SalesTargetModal__CalendarHeader')]//div[@class='title']");
	
	//Edit Sales target modal
	public static By ddn_month_editST = By.xpath("//div[@id='drpdwn_edit_month']/div/div[1]");
	public static By input_month_editST = By.xpath("//div[@id='drpdwn_edit_month']/div[1]//input");
	public static By ddn_year_editST = By.xpath("//div[@id='drpdwn_edit_year']/div/div[1]");
	public static By input_year_editST = By.xpath("//div[@id='drpdwn_edit_year']/div[1]//input");
	public static By tbx_amount = By.id("input_amount");
	public static By txt_siteName_ST = By.xpath("//div[@class='row']/div[@class='col']/div");
	public static By btn_saveSalesTarget = By.id("btn_save_target");
	public static By btn_cancelSalesTarget = By.id("btn_cancel_target");
	public static By msg_successEditST = By.xpath("//div[text()='Success create SalesTarget']");
	
	//Sales Details modal elements
	
	public static By hdr_SalesDetails = By.xpath("//div[contains(@class,'SalesTargetModal__Column')]/div[@class='title']");
	public static By hdr_salesDetail_period = By.xpath("//div[contains(@class,'SalesTargetModal__CalendarHeader')]/div[@class='title']");
	public static By lbl_siteName_saleDetail = By.xpath("//div[text()='Site']/following-sibling::div");
	public static By lbl_departmentName_saleDetail = By.xpath("//div[text()='Sales Detail']/following-sibling::div[2]/div[2]");
	public static By lbl_salesTargetMonthly = By.xpath("//div[text()='Sales Target for the month']/following-sibling::div");
	public static By lbl_salesMadeMonthly = By.xpath("//div[text()='Sales Made for the month']/following-sibling::div");
	public static By lbl_progressSales = By.xpath("//div[@class='progress-text']");
	
	public static By lst_addSales_box = By.xpath("//div[@class='add-sales']");
	public static By lst_btn_addSales = By.xpath("//button[@id='btn_add_sales']");
	public static By lst_tbx_inputSales = By.xpath("//input[@id='input_sales']");
	public static By lst_btn_inputSalesSubmit = By.xpath("//input[@id='input_sales']");
	public static By msg_successCreateSales = By.xpath("//div[text()='Success create Sales']");
	public static By lst_salesFigure = By.xpath("//div[@class='figure']");
	
	public static By lst_calenderCell = By.xpath("//div[contains(@class,'SalesTargetModal__CalendarCell')]");
	public static By lst_dlt_trash = By.xpath("//span[@class='date-trash']");
	public static By lst_btn_yes = By.xpath("//button[text()='Yes']");
	
}
