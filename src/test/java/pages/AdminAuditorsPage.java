package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;

public class AdminAuditorsPage extends ReusableLib {


    public AdminAuditorsPage(Helper helper) {
        super(helper);
    }

    /* Auditors locators*/

    public static  By auditorsLnk= By.xpath("//a[@href='/admin/auditors']");
    public static  By adduser= By.xpath("//button[contains(@id,'btn_add_user')]");
    public static  By username= By.xpath("//input[@id='input_user_auditor']");
    public static  By useremail= By.xpath("//input[@id='input_email_auditor']");
    public static  By userdepartment= By.xpath("(//input[starts-with(@id,'react-select-')])[2]");
    public static  By userphone= By.xpath("//input[contains(@id,'input_phone_auditor')]");
    public static  By savebutton= By.xpath("//button[contains(@id,'btn_save_auditor')]");
    public static  By searchbox= By.xpath("//input[@name='filterQuery']");
    public static  By editicon= By.xpath("//img[@id='btn_edit_auditor']");
    public static  By deleteicon= By.xpath("//img[@id='btn_block']");
    public static  By deleteconfirm= By.xpath("//button[@id='btn_yes_block_auditor']");
    public static  By toastmessage= By.xpath("//div[contains(@class,'toast-body')]");
    public static  By blockedtab= By.xpath("//span[contains(@id,'tab_bloked_auditor')]");
    public static  By activatebtn= By.xpath("//button[contains(@id,'btn_activate_auditor')]");
    public static  By confirmactivate= By.xpath("//button[contains(@id,'btn_yes_activate_auditor')]");
    public static  By checkauditor= By.xpath("(//span[contains(@class,'checkmark')])[2]");
    public static  By downloadbtn= By.xpath("//button[contains(.,'Download (1) Selected')]");
    public static  By Yesbtn= By.xpath("//div[contains(.,'Download the selected auditors?')]/following-sibling::div/button[2]");
    public static  By bulkupload= By.xpath("//button[contains(@id,'btn_bulk_upload_auditor')]");
    public static  By uploadxlsx= By.xpath("//label[contains(.,'Upload .xlsx')]");
    public static  By uploadbtn= By.xpath("//button[contains(@id,'btn_upload_auditor')]");
    public static  By uploadedfile= By.xpath("//div[contains(@class,'truncate')]");
    public static  By Auditorstable= By.xpath("//table[contains(@class,'AuditorListTable__AuditorListTableContainer')]");
    public static  By activatetab= By.xpath("//span[contains(@id,'tab_active_auditor')]");
    public static  By downloadselectedbtn= By.xpath("//button[contains(.,'Download  Selected')]");
}
