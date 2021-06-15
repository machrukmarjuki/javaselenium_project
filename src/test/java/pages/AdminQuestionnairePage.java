package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;
import supportLibraries.Utility_Functions;
public class AdminQuestionnairePage extends ReusableLib {

    public AdminQuestionnairePage(Helper helper) {
        super(helper);
    }

    /* Questionnaire locators*/
    public static  By questionnaireLnk= By.xpath("//a[@href='/admin/questionnaires']");
    public static  By addquestionnaire= By.xpath("//button[contains(.,'Create Questionnaire')]");
    public static  By questionnairetitle= By.xpath("//input[contains(@placeholder,'Questionnaire Title')]");
    public static  By drpdwn_assign_dept= By.xpath("//div[contains(@class,'transparent-border')]//input");
    public static  By drpdwn_assign_cat= By.xpath("//div[@class='questionCategoryOption']//div[contains(@id,'drpdwn_categ_quest')]//input[1]");
    public static  By questionname= By.xpath("//textarea[contains(@placeholder,'Enter the question')]");
    public static  By questiontype= By.xpath("//div[starts-with(@class,'select-editor__single-value')]/following-sibling::div/div/input");
    public static  By Yestxtbox= By.xpath("//input[contains(@placeholder,'Yes')]");
    public static  By Notxtbox= By.xpath("//input[contains(@placeholder,'No')]");
    public static  By RedFlagtxtbox= By.xpath("//input[contains(@placeholder,'Red Flag (problem is severe)')]");
    public static  By photochkbox= By.xpath("//label[contains(.,'photo')]");
    public static  By videochkbox= By.xpath("//label[contains(.,'video')]");
    public static  By docschkbox= By.xpath("//label[contains(.,'documents')]");
    public static  By addquestionbtn= By.xpath("//div[contains(@class,'addQuestion')]/span");
    public static  By  btn_applytocategory=By.xpath("//button[text()='Apply to Category']");
    public static By  btn_applyconfirmation=By.xpath("//*[@id='btn_yes_apply_categ']");
    public static  By publishbtn= By.xpath("//div[contains(.,'Create New Questionnaire')]/following-sibling::div/button");
    public static  By editpublishbtn= By.xpath("//div[contains(.,'Edit Questionnaire')]/following-sibling::div/button");
    public static  By searchtxbox= By.xpath("//input[contains(@id,'input_search_quest')]");
    public static  By editicon= By.xpath("//img[contains(@id,'btn_edit_quest')]");
    public static  By cloneicon= By.xpath("//img[contains(@id,'btn_clone_quest')]");
    public static  By deleteicon= By.xpath("//img[contains(@id,'btn_del_quest')]");
    public static  By cloneYes= By.xpath("//button[contains(@id,'btn_clone_yes')]");
    public static  By deleteYes= By.xpath("//button[contains(@id,'btn_del_yes')]");
    public static  By toastmessage= By.xpath("//div[contains(@class,'toast-body')]");
    public static  By questionnairestable= By.xpath("//table[contains(@class,'QuestionnaireList__QuestionnaireListTable')]");
    public static  By addcategorybtn= By.xpath("//button[contains(.,'Add Category')]");
    public static  By drpdwn_assign_cat1= By.xpath("(//div[contains(@id,'drpdwn_categ_quest')])[2]//input");
    public static  By questionname1= By.xpath("(//textarea[contains(@placeholder,'Enter the question')])[2]");
    public static  By questchkbox= By.xpath("(//span[contains(@class,'checkmark')])[2]");
    public static  By downloadbtn= By.xpath("//button[contains(@id,'btn_dwnld_selected')]");
    public static  By Yesbtn= By.xpath("//button[contains(.,'Yes')]");
    public static  By bulkuploadbtn= By.xpath("//button[contains(@id,'btn_bulk_upload_quest')]");
    public static  By questname= By.xpath("//input[contains(@id,'input_step1')]");
    public static  By templatename= By.xpath("(//input[starts-with(@id,'react-select-')])[1]");
    public static  By deptname= By.xpath("(//input[starts-with(@id,'react-select-')])[2]");
    public static  By selectxlsxbtn= By.xpath("//span[contains(.,'Select .xlsx')]");
    public static  By uploadedfile= By.xpath("//div[contains(@class,'success')]/div[1]");
    public static  By submitbutton= By.xpath("//button[@id='btn_upload_quest']");
}
