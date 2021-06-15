package pages;

import org.openqa.selenium.By;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;

public class DepartmentPages extends ReusableLib{

	public DepartmentPages(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}
	
	public static By lbl_department = By.xpath("//a[text()='Departments']");
	public static By lbl_departmentgroup = By.xpath("//a[text()='Departments Group']");
	public static By btn_addDepartment = By.id("btn_add_dept");
	public static By  btn_bulkupload = By.id("btn_bulk_upld_dept");
	public static By inp_searchdepartment = By.id("input_search_dept");
	public static By span_dept_active = By.id("tab_actv_dept");
	public static By span_dept_inactive = By.id("tab_del_dept");
	public static By span_deptgrp_active = By.xpath("//span[text()='Active']");
	public static By span_deptgrp_inactive = By.xpath("//span[text()='Inactive']");
	public static By tr_activedepartments = By.xpath("//tbody/tr");
	public static By td_activedepartmentscolumns=By.xpath("//tbody/tr[1]/td");
	public static By inp_departmentName = By.id("input_name_dept");
	public static By inp_description = By.id("input_desc_dept");
	public static By inp_email = By.id("input_email_dept");
	public static By inp_uniqueKey = By.id("input_key_dept");
	public static By btn_save = By.id("btn_save_dept");
	public static By div_deptexistedmsg = By.xpath("//*[text()='Department already exists']");
	public static By img_editdepartmentbutton=By.xpath("//tbody/tr/td//img[@id='btn_edit_dept']");
	public static By img_blockdepartmentbutton= By.xpath("//tbody/tr/td//img[@id='btn_block_dept']");
	public static By span_blockdepartmentconfirmation  = By.xpath("//span[text()=' Are you sure you want to block this department?']");
	public static By btn_blockconfirm = By.id("btn_block_yes");
	public static By msg_blocksuccess=By.xpath("//*[text()='Successfully Block department']");
	public static By btn_activatedepartment= By.id("btn_activate");
	public static By span_activatedepartmentconfirmation = By.xpath("//span[text()=' Are you sure want you to activate this department?']");
	public static By btn_activateconfirm = By.id("btn_activate_yes");
	public static By msg_activationsuccess= By.xpath("//*[text()='Successfully Activate department']");
	public static By div_loadingContainer = By.xpath("//div[contains(@class,'loadingContainer')]");
	public static By span_siteName= By.xpath("//label[text()='Sites']/parent::div//span[1]");
	public static By span_questionnaire=By.xpath("//label[text()='Questionnaires']/parent::div//span[1]");
	public static By anc_logut = By.id("menu_logout");
	
	//Department Group Tab
	
	public static By btn_addDepartmentGroup = By.xpath("//*[text()='Add department group']");
	public static By lbl_newdepartmentGroup = By.xpath("//*[text()='New department group']");
	public static By inp_departgroupName = By.xpath("//*[text()='Name']/following-sibling::input");
	public static By inp_departgroupDesc = By.xpath("//*[text()='Description']/following-sibling::input");
	public static By div_addDepartments = By.xpath("//*[text()='Add Department']");
	public static By div_departmentNameGroup = By.xpath("//label[text()='Departments']/parent::div/div[1]/div[2]/div/span[1]");
	public static By inp_searchDepartmentGroup = By.name("filterQuery");
	public static By btn_savedepartmentgroup = By.xpath("//button[text()='Save']");
	public static By msg_departGroupcreated = By.xpath("//*[text()='Success create a new department group']");
	public static By div_collectionOfcreated_group = By.xpath("//div[@class='DepartmentGroupListStyles__DepartmentListContainer-n8wbxn-0 ebTRlW']");
	public static By div_activeselectedDepartmentGroup = By.xpath("//div[@class='departmentItem active ']/h6");
	public static By inp_deptNameplacholder = By.xpath("//input[@placeholder='Enter the department group name']");
	public static By inp_departDescplaceholder = By.xpath("//input[@placeholder='Enter a description for the department group']");
	public static By btn_reset = By.xpath("//button/span[text()='Reset']");
	public static By div_activeDepartments=By.xpath("//div[@class='DepartmentGroupListStyles__DepartmentListContainer-n8wbxn-0 ebTRlW']/div/h6");
	public static By span_deactivateDepartmentGrp=By.xpath("//span[text()='Deactivate Group']");
	public static By  confmDeptDeactivate= By.xpath("//p[text()='Are you sure you want to deactivate this department group?']");
	public static By btn_cnfrmDeptGrpDeactivate=By.xpath("//button[text()='Deactivate Group']");
	public static By msg_deactivateDeptGrp = By.xpath("//*[text()='Success deactivated department group']");
	public static By btn_reactivate = By.xpath("//button[text()='Reactivate']");
	public static By btn_cnfrm_reactivation = By.xpath("//div[@class='buttonGroup']//button[text()='Reactivate']");
	public static By msg_reactivateDeptGrp= By.xpath("//*[text()='Success reactivated department group']");
}

