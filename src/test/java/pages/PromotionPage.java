package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;

public class PromotionPage extends ReusableLib {

    public PromotionPage(Helper helper) { super(helper); }

    public  static By adminBtn=By.id("menu_adm");
    public static By promoLink= By.id("menu_adm_promo");
    public static By newPromoBtn= By.id("btn_new_promo");
    public static By tabActPromo= By.id("tab_active_promo");
    public static By tabSchedPromo= By.id("tab_sched_promo");
    public static By tabArchPromo= By.id("tab_archi_promo");
    public static By inputTitlePromo= By.id("input_title_promo");
    public static By inputDescPromo= By.id("input_desc_promo");
    public static By btn_addimage = By.id("btn_add_image");
    public static By inputCostPromo= By.id("input_cost_promo");
    public static By radioBtnAllSites= By.id("radiobtn_all_sites");
    public static By radioBtnSpecSite= By.id("radiobtn_spec_sites");
    public static By drpdwnSpecSite=By.xpath("//*[@id='drpdwn_spec_sites']//input");
    public static By radioBtnSpecDept= By.id("radiobtn_spec_dept");
    public static By drpdwnSpecDept= By.xpath("//*[@id='drpdwn_spec_dept']//input");
    public static By div_loadingContainer = By.xpath("//div[@class='LoadingDots'");
    public static By th_promotion_titleheader = By.xpath("//th[text()='Promotion Title']");
    
    
    public static By radioBtnSendNow= By.id("radiobtn_send_now");
    public static By datePickerSendNow= By.id("drpdwn_end_date");
    public static By datePickerSendNowTime= By.id("drpdwn_end_date_time");
    public static By datePickerSendNowAmPm= By.id("drpdwn_end_date_ampm");
    public static By radioBtnSpecDate= By.id("radiobtn_spec_date");
    public static By datePickerNextMonth= By.xpath("//*[@aria-label='Move forward to switch to the next month.']//*[@class]");
    public static By selectStartDate= By.xpath("//*[@class='CalendarMonth_table CalendarMonth_table_1']//*[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2'][text()='15']");
    public static By datePickerStart= By.id("drpdwn_spec_startdate");
    public static By drpdwnStartTime= By.xpath("//*[@id='drpdwn_spec_startdate_time']//input");
    public static By drpdwnStartAmPm = By.xpath("//*[@id='drpdwn_spec_startdate_ampm']//input");
    public static By datePickerEnd= By.id("drpdwn_spec_enddate");
    public static By selectEndDate= By.xpath("//*[@class='CalendarMonth_table CalendarMonth_table_1']//*[@class='CalendarDay CalendarDay_1 CalendarDay__default CalendarDay__default_2'][text()='18']");
    public static By drpdwnEndTime= By.xpath("//*[@id='drpdwn_spec_enddate_time']//input");
    public static By drpdwnEndAmPm= By.xpath("//*[@id='drpdwn_spec_enddate_ampm']//input");

    public static By btnSavePromo= By.id("btn_save_promo");
    public static By btnCancelPromo= By.id("btn_cancel_promo");
    public static By alertSaveMsg= By.xpath("//div[contains(text(),'Success create Promotion')]");
    public static By updateSaveMsg= By.xpath("//div[contains(text(),'Success update Promotion')]");

    public static By alertNoTitle= By.xpath("//div[contains(text(),'Promotion Title must be filled')]");
    public static By alertNoDesc= By.xpath("//div[contains(text(),'Promotion Message must be filled')]");
    public static By alertNoSpecSite= By.xpath("//div[contains(text(),'Sites must be filled')]");
    public static By alertNoSpecDept= By.xpath("//div[contains(text(),'Department must be filled')]");


    public static By btnEditPromo= By.id("btn_edit_romo");
    public static By iconEndPromo= By.xpath("//img[@id='btn_end_promo']");
    public static By btnEndPromo= By.id("btn_end_promo");
    public static By btnResendPromo= By.xpath("//tbody/tr[1]/td[8]/button[1]");

}
