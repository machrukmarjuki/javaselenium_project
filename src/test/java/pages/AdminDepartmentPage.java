package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;
import supportLibraries.Utility_Functions;


public class AdminDepartmentPage extends ReusableLib {

	public AdminDepartmentPage(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}

	/* Department locators*/

	public static  By departmentLnk= By.xpath("//a[@href='/admin/departments']");
	public static  By adddepartment= By.xpath("//button[contains(.,'Add department')]");
	public static  By departmentname= By.xpath("//input[@id='input_name_dept']");
	public static  By departmentdescription= By.xpath("//input[@id='input_desc_dept']");
	public static  By departmentemail= By.xpath("//input[@id='input_email_dept']");
	public static  By departmentkey= By.xpath("//input[@id='input_key_dept']");
	public static  By departmentcheckkey= By.xpath("//button[@id='link_check_key']");
	public static  By departmentresetkey= By.xpath("//button[contains(.,'Reset')]");
	public static  By drpdwn_assign_dept= By.xpath("//*[@id='drpdwn_site_dept']//input");
	public static  By drpdwn_assign_ques= By.xpath("//div[@id='drpdwn_quest_dept']//input");
	public static  By drpdwn_assign_users= By.xpath("//div[@id='drpdwn_user_escal1']//input");
	public static  By searchbox= By.xpath("//input[@name='filterQuery']");
	public static  By depediticon= By.xpath("//img[@id='btn_edit_dept']");
	public static  By depdeleteicon= By.xpath("//img[@id='btn_block_dept']");
	public static  By depconfirmdelete= By.xpath("//button[@id='btn_block_yes']");
	public static  By savebutton= By.xpath("//button[contains(.,'Save')]");
	public static  By departmentstable= By.xpath("//table[contains(@class,'DepartmentList__DepartmentListTable')]");
	public static  By toastmessage= By.xpath("//div[contains(@class,'toast-body')]");

}
