package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;

public class IssueTrackerPage extends ReusableLib {

    public IssueTrackerPage(Helper helper) { super(helper); }

    public static By issueTrackerLink=By.id("menu_issue_tracker");
    public static By drpdwnByQuest=By.xpath("//*[@id='drpdwn_by_quest']//input");
    public static By filter_byquestionnaire=By.xpath("//*[text()='by Questionnaire']");
    public static By div_questionnaire = By.xpath("//*[text()='by Questionnaire']/parent::div/following-sibling::div/div");
    public static By drpdwnByUser=By.xpath("//*[@id='drpdwn_by_usr']//input");
    public static By filter_byuser=By.xpath("//*[text()='by User']");
    public static By drpdwnByDept=By.xpath("//*[@id='drpdwn_by_dept']//input");
    public static By filter_byDept=By.xpath("//*[text()='by Department']");
    public static By drpdwnBySite=By.xpath("//*[@id='drpdwn_by_site']//input");
    public static By filter_bySite= By.xpath("//*[text()='by Site']");
    public static By drpdwnByFlag=By.xpath("//*[@id='drpdwn_by_flag']//input");
    public static By filter_byFlag = By.xpath("//*[text()='by Flag']");
    public static By drpdwnByStatus=By.xpath("//*[@id='drpdwn_by_stts']//input");
    public static By filter_byStatus = By.xpath("//*[text()='by Status']");
    public static By drpdwnByPrior=By.xpath("//*[@id='drpdwn_by_prior']//input");
    public static By drpdwnUpdateByStatus=By.xpath("//*[@id='drpdwn_status'//input");
    public static By issueLoader=By.xpath("//div[contain(@class,'LoadingSkeleton-agr85v-0 fafQPj')]" );
    public static By ByQuestfilterValue=By.xpath("//div[@id='drpdwn_by_quest']/div[1]/div[1]/div[1]");
    public static By ByUserfiltervalue = By.xpath("//div[@id='drpdwn_by_usr']/div[1]/div[1]/div[1]");
    public static By ByDeptfiltervalue=By.xpath("//div[@id='drpdwn_by_dept']/div[1]/div[1]/div[1]");
    public static By BySitefiltervalue = By.xpath("//div[@id='drpdwn_by_site']/div[1]/div[1]/div[1]");
    public static By ByFlagfiltervalue = By.xpath("//div[@id='drpdwn_by_flag']/div[1]/div[1]/div[1]");
    public static By ByStatusfiltervalue = By.xpath("//div[@id='drpdwn_by_stts']/div[1]/div[1]/div[1]");
    public static By noissuefound = By.xpath("//*[text()='No issues found']");
    public static By issuecard_Questionnaire=By.xpath("//div[@data-testid='issue-card-0']//span[@data-testid='issue-card-questionnaire']");
    public static By issuecard_QuestionTitle=By.xpath("//div[@data-testid='issue-card-0']//span[@data-testid='issue-card-question']");
    public static By issecard_category = By.xpath("//div[@data-testid='issue-card-0']//span[@data-testid='issue-card-category']");
    public static By issuecard_site = By.xpath("//label[text()='Site']//following-sibling::div");
    public static By issuecard_0 = By.xpath("//div[@data-testid='issue-card-0']");
    
    
    //view by
    public static By viewByStartDate=By.id("issue_filter_start_date");
    public static By viewByEndDate=By.id("issue_filter_end_date");
    public static By datePickerPrevMonth= By.xpath("//*[@aria-label='Move backward to switch to the previous month.']//*[@class]");
    public static By selectStartDate= By.xpath("//*[@class='CalendarMonth_table CalendarMonth_table_1']//*[text()='10']");
    public static By selectEndDate= By.xpath("//*[@class='CalendarMonth_table CalendarMonth_table_1']//*[text()='25']");

    //sort by
    public static By sortByDateCreated=By.id("radiobtn_date_created");
    public static By sortByDueDate=By.id("radiobtn_due_date");

    //btn Remove All
    public static By removeAllBtn=By.xpath("//span[contains(text(),'Remove All')]");

    //Search Issue
    public static By inputSearchIssue=By.id("input_search_issue");

    //Add Issue
    public static By addIssueBtn=By.id("btn_add_issue");
    public static By inputIssueTitle=By.xpath("//input[@placeholder='Enter your question/title']");
    public static By label_addIssue = By.xpath("//div[text()='Add Issue']");
    public static By drpdwnCateg=By.xpath("//*[@class=' css-19c0xr6']//div[@class='css-lvtxqx']//input");
    public static By drpdwnAssignedDept=By.xpath("//div[@class='container']//div[@class='title' and text()='Assigned Department']/parent::div//div[@class='css-84laj4']/div/input");
    public static By drpdwnReporterDept=By.xpath("//div[@class='container']//div[@class='title' and text()='Reporter Department']/parent::div//div[@class='css-84laj4']/div/input");
    public static By drpdwnSeverityIssue=By.xpath("//div[@class='container']//div[@class='title' and text()='Severity']/parent::div//div[@class='css-84laj4']/div/input");
    public static By drpdwnSiteIssue=By.xpath("//div[@class='container']//div[@class='title' and text()='Site']/parent::div//div[@class='css-84laj4']/div/input");
    public static By drpdwnAssignedUser=By.xpath("//div[@class='container']//div[@class='title' and text()='Assigned to']/parent::div//div[@class='css-84laj4']/div/input");
    public static By drpdwnDueDate=By.id("issue-creator");
    public static By datePickerNextMonth= By.xpath("//*[@aria-label='Move forward to switch to the next month.']//*[@class]");
    public static By selectDueDate= By.xpath("//*[@class='CalendarMonth_table CalendarMonth_table_1']//*[contains(text(),'20')]");
    public static By drpdwnDueTime=By.xpath("//div[@class='container']//div[@class='title' and text()='Due Date and time']/parent::div//div[@class='css-84laj4']/div/input");
    public static By inputCommentIssue=By.xpath("//textarea[@placeholder='Enter your comment']");
    public static By linkAddImage=By.xpath("//button[contains(text(),'add image')]");
    public static By linkchangeImage=By.xpath("//button[text()='change image']");
    public static By saveIssueBtn=By.xpath("//button[contains(text(),'Add')]");
    public static By cancelIssueBtn=By.xpath("//button[contains(text(),'Cancel')]");
    public static By successToast=By.xpath("//div[contains(text(),'Success add issue')]");
    public static By wrngMsgField=By.xpath("//div[contains(text(),'Please fill in all required fields')]");

    /** Detail Issue **/
    public static By detailIssueStatus=By.xpath("//*[@id='drpdwn_status']//input");
    public static By statusResolved=By.xpath("//div[contains(text(),'Resolved')]");
    public static By inputComment=By.id("input_comment");
    public static By postBtn=By.id("btn_post_comment");








}
