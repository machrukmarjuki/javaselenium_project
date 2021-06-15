package pages;

import org.openqa.selenium.By;

public class AndroidIssueTrckrPage {


    public static By issueTb = By.xpath("//android.widget.TextView[@text='Issue']");
    public static By issueTrackerLabel = By.xpath("//android.widget.TextView[@text='Issue Tracker']");
    public static By filtrBtn = By.xpath("//android.widget.TextView[@text='Filter']");
    public static By markAllRead = By.xpath("//android.widget.TextView[@text='Mark all as read']");
    public static By Sort = By.xpath("//android.widget.TextView[@text='Sort']");
    public static By takePhotos = By.xpath("//android.widget.TextView[@text=#983296;']");

    public static By thsWeek = By.xpath("//android.widget.TextView[@text='Due Date:']/following-sibling::android.widget.TextView");
    public static String issueSite ="//android.widget.TextView[@text='Site:']/following-sibling::android.widget.TextView[@text='Site_Name']";
    public static String filtrDt ="//android.widget.TextView[@text='Site_Name']";
    public static By issueUpdatBtn= By.xpath("//android.widget.TextView[@text='UPDATE']");

    public static By status = By.xpath("//android.view.ViewGroup[@index='7']//android.widget.TextView");

    public static By updatePopStatus =By.xpath("//android.widget.TextView[@text='COMMENT']/../preceding-sibling::android.view.ViewGroup//android.widget.TextView");

    public static By issueCmtTxtBx =By.xpath("//android.widget.EditText[@text='Update your status here']");
    public static By takePhoto =By.xpath("//android.view.ViewGroup[@index='4']/android.widget.TextView");

    public static By takePic=By.xpath("//android.view.ViewGroup[@index='1']//android.view.ViewGroup[@index='1']/android.view.ViewGroup[@index='0']/android.view.ViewGroup");

    public static By resolveBtn= By.xpath("//android.widget.TextView[@text='Resolved']");
    public static By updtsubmit = By.xpath("//android.widget.TextView[@text='Submit']");

    public static By issueBckBtn= By.xpath("//android.widget.Button[@content-desc='Issues, back']/android.widget.ImageView");

    public static By issueFltrLbl = By.xpath("//android.widget.TextView[@text='Issue Filter']");
    public static By issueFltrBckBtn = By.xpath("//android.widget.TextView[@text='Back']");
    public static By issueReset = By.xpath("//android.widget.TextView[@text='Reset']");

    public static By questionnaireList = By.xpath("//android.widget.TextView[@text='Questionnaire']/following-sibling::android.widget.TextView");
    public static By departmntLIst = By.xpath("//android.widget.TextView[@text='Department']/following-sibling::android.widget.TextView");

    public static By siteList = By.xpath("//android.widget.TextView[@text='Site']/following-sibling::android.widget.TextView");
    public static By filterSiteLbl = By.xpath("//android.widget.TextView[@text='Filter by Site']");

    public static By srchSite = By.xpath("//android.widget.EditText[@text='Search For Site']");
    public static By srchDepart= By.xpath("//android.widget.EditText[@text='Search For Department']");

    public static By issueLoading = By.xpath("//android.widget.TextView[@text='Loading More Issues...']");

    public static By applybtn = By.xpath("//android.widget.TextView[@text='Apply']");



    /**Add a new issue**/

    public static By adhocIssueBtn = By.xpath("//android.view.ViewGroup[@index='5']//android.widget.TextView");
    public static By enterTitle = By.xpath("//android.widget.EditText[contains(@text,'title')]");
    public static By selectSite = By.xpath("//android.widget.TextView[@text='Select Site']");
   // public static By selectIssueCatgry = By.xpath("//android.widget.TextView[contains(@text='category')]");
    public static By selectIssueCatgry = By.xpath("//android.view.ViewGroup[@index='5']//android.widget.TextView");
    public static By enterIssueCatgry = By.xpath("//android.widget.EditText[contains(@text,'Search issue's category')]");
    //public static By selectIssueDepart = By.xpath("//android.widget.TextView[@text='Select Reporter Department']");
    public static By selectIssueDepart = By.xpath("//android.view.ViewGroup[@index='7']//android.widget.TextView");
    public static By selectRedFlag = By.xpath("//android.widget.TextView[@text='Red Flag']");
    public static By selectYellwFlag = By.xpath("//android.widget.TextView[@text='Yellow Flag']");
    public static String deptmentString="//android.widget.TextView[@text='Department']";
    public static By chooseReportLabl = By.xpath("//android.view.ViewGroup[@index='1']//android.widget.TextView");

    public static By selectDrpByIndex=By.xpath("//android.widget.ScrollView//android.widget.TextView[@index='1']");
    public static By selectCatDrpByIndex=By.xpath("//android.widget.ScrollView//android.widget.TextView[@index='0']");
    public static By chooseAssigned=By.xpath("//android.widget.TextView[contains(@text,'Choose Assigned')]");



}


