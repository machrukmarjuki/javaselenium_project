package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;


public class AdminSitePage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public AdminSitePage(Helper helper) {
        super(helper);
    }

    public  static By adminBtn=By.id("menu_adm");
    public static  By manageLink= By.xpath("//span[text()='Manage']");
    public static  By siteLnk= By.xpath("//span[text()='Sites']");
    public static By addBtn=By.id("btn_add_site");
    public static By tab_details_site= By.id("tab_details_site");
    public static By input_name_site=By.id("input_name_site");
    public static By input_subsite=By.name("subtitle");
    public static By input_address_site=By.id("input_address_site");
    public static By select_address_site= By.xpath("//ul[contains(@class,'geosuggest__suggests')]//li[1]/span");
    public static By input_city_site=By.id("input_city_site");
    public static By input_country_site=By.id("input_country_site");
    public static By  selectTimeZon=By.xpath("//*[@id='drpdwn_time_zone']//input");
    public static By drpdwn_assign_dept=By.xpath("//*[@id='drpdwn_assign_dept']//input");
    public static By selectSiteDpt=By.xpath("//*[@id='site-detail__department-supervisor-dropdown']//input");
    public static By selectSupervisor=By.xpath("//*[@id='site-detail__users-supervisor-dropdown']//input");
    public static By addTolistSupervisor=By.xpath("//span[text()='Supervisor']/..//button[text()='Add to list']");
    public static By selectSiteAuditor=By.xpath("//*[@id='site-detail__department-auditor-dropdown']//input");
    public static By selectAuditor=By.xpath("//*[@id='site-detail__users-auditor-dropdown']//input");
    public static By addTolistAuditor=By.xpath("//span[text()='Auditor']/..//button[text()='Add to list']");
    public static By btn_save_site=By.id("btn_save_site");
    public static By alertSaveMgs=By.xpath("//div[contains(text(),'Updates')]");
    public static By btnUndoChng=By.xpath("//button[text()='Undo Changes']");
    public static By spanDepartment = By.cssSelector("a[id='menu_dept']>span");
    public static By editSite=By.xpath("//button[text()='Edit details']");
    public static By span_loggedinuser = By.xpath("//span[contains(text(),'Logged in as,')]/following-sibling::span");
    public static By msg_savedmsg = By.xpath("//*[text()='Updates saved.']");
    public static By btn_bulkUpload = By.id("btn_bulk_upload_sites");
    public static By span_listofbulkitems = By.xpath("//button[@id='btn_bulk_upload_sites']/following-sibling::div/div/span");
    
    
    /** Report Schedule8*/

    public static By RptSchedulTab=By.id("tab_schedule_site");

    public static By RptSchdlLandingPage=By.xpath("//span[text()='Setup Reporting Schedule']");
    public static By drpdwn_quest_report=By.xpath("//*[@id='drpdwn_quest_report']//input");
    public static By loadQest=By.xpath("//div[contains(@class,'SiteScheduleQuestionnaireTabSingle__RowBox')]//div[text()='KTProgress']");
    public static By btn_save_schedule=By.id("btn_save_schedule");

    /**Search**/

    public static By srchInput= By.id("input_search_site");
    public static By srchMGlss=By.xpath("//div[contains(@class,'SitesListHeader__Icon')]/img");

    /**Delete Site **/

    public static By dltBtn=By.id("btn_block");

    public static By alrtYesBtn=By.id("btn_yes_block_site");

    public static By dltMsg=By.xpath("//span[contains(text(),'No Sites found')]");

    public static By siteLoader=By.xpath("//div[contains(@class,'SitesList__LoadingContainer')]");


    /** Block Site*/

    public static By blokedSite= By.id("tab_blocked_sites");

    public static By actveSite=By.id("tab_active_sites");

    public static By removeBtn=By.xpath("//button[text()='Remove']");

    public static By reActive=By.id("btn_reactive_site");
   public static By unBlock=By.id("btn_yes_unblock_site");

    public static By skuTab=By.xpath("//div[text()='SKUs']");

    public static By loadSpinnr=By.xpath("//div[data-testid='confirmModal']/div[@class='LoadingSpinner-root']");
    
    
    /** Site Bulk Upload*/
    
    public static By btn_BulkUpload = By.id("btn_bulk_upload_sites");
    public static By btn_BulkSiteUpload = By.xpath("//span[@id='btn_site_upload']");
    public static By btn_BulkSiteUpload_SelectFile = By.xpath("//label[@class='selectFile']");
    public static By btn_UploadConfirm = By.id("btn_upload");
    
    public static By msg_TemplateUploaded = By.className("failText");
    public static By msg_TemplateUploaded_Error = By.xpath("//div[@class='fileBar']/following-sibling::span");
    public static By msg_UploadError_DuplicateSiteName = By.xpath("//ul[@class='errorList']//li");
    
    /** Schedule Bulk Upload*/
    public static By btn_BulkScheduleUpload = By.xpath("//span[@id='btn_schedule_upload']");
    public static By btn_BulkScheduleUpload_SelectFile = By.xpath("//label[@for='file']");
    public static By btn_ScheduleUploadConfirm = By.id("btn_sche_upload");
    
    public static By msg_ScheduleTemplateUploaded = By.xpath("//div[@class='error']/div[1]");
    public static By msg_ScheduleTemplateUploaded_Error = By.xpath("//div[@class='error']/div[2]/span");
    public static By msg_ScheduleUploadError_DuplicateSchedule = By.xpath("//div[@class='error-detail']/div[2]");
    

    //bulk upload Site 
    public static By div_reportingSchdlmsg=By.xpath("//div[text()='Don’t forget to setup your Reporting Schedule after uploading.']");
    public static By div_subtitle = By.xpath("//div[text()='Once you’ve uploaded the .xlsx file, go to the site you’ve added and click edit to setup the reporting schedule.']");
    public static By lbl_uploadxlsbtn = By.xpath("//label[text()='Upload .xlsx']");
    public static By btn_upload=By.id("btn_upload");
    public static By msg_bulkuploadsite = By.xpath("//*[text()='Successfully upload sites bulk']");
    public static By btn_cancelBulkUpload = By.id("btn_cancel_upload");
    public static By msg_error = By.xpath("//*[text()='Errors']");

    public static By pageLoad=By.xpath("//*[contains(text(),'Please wait while we're loading')]");
    public static By noAccess=By.xpath("//h1[contains(text(),' No Access')]");
    public static By nosite=By.xpath("//span[contains(text(),'No Sites found.')]");










}
