package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;
import supportLibraries.Utility_Functions;

public class AdminDashboardPage extends ReusableLib {

    public AdminDashboardPage(Helper helper) {
        super(helper);
    }

    /* Dashboard Group LOcators */

    public static  By dashboard_lnk=By.xpath("//a[@id='menu_dsbrd']");
    public static  By dashboardoverview_lnk=By.xpath("//a[@id='menu_dsbrd_overview']");
    public static  By sitesoverviewmap=By.xpath("//div[contains(.,'Sites Overview Map')]");
    public static  By zoominbutton=By.xpath("//button[contains(@title,'Zoom in')]");
    public static  By zoomoutbutton=By.xpath("//button[contains(@title,'Zoom out')]");
    public static  By map=By.xpath("//div[contains(@class,'MapIssueClusterer__Root')]");
    public static  By reportsDone=By.xpath("//div[starts-with(@class,'ReportsStatisticOverview__Root')]");
    public static  By reportsCompletion=By.xpath("(//div[contains(@class,'AnalyticsScore-card')])[1]");
    public static  By reportsmissed=By.xpath("(//div[contains(@class,'AnalyticsScore-card')])[2]");
    public static  By issuesresolved=By.xpath("//div[contains(@class,'IssuesStatisticOverview__Root')]");
    public static  By issuescompletion=By.xpath("(//div[contains(@class,'AnalyticsScore-card')])[3]");;
    public static  By issuesreported=By.xpath("(//div[contains(@class,'AnalyticsScore-card')])[4]");;
    public static  By greenflag=By.xpath("(//div[contains(@class,'AnalyticsScore-card')])[5]");;
    public static  By redflag=By.xpath("(//div[contains(@class,'AnalyticsScore-card')])[6]");;
    public static  By yellowflag=By.xpath("(//div[contains(@class,'AnalyticsScore-card')])[7]");;
    public static  By issuescategory=By.xpath("//div[contains(@class,'IssuesStatisticOverview__IssueCategoryLayout')]");
    public static  By departmentsfilter=By.xpath("(//div[contains(@class,'select-editor__value-')])[1]");
    public static  By sitesfilter=By.xpath("(//div[contains(@class,'select-editor__value-')])[2]");
    public static  By periodfilter=By.xpath("//div[contains(@class,'AnalyticsControllerStyles__Root')]/div[3]/div");
    public static  By periodfilterinput=By.xpath("(//input[starts-with(@id,'react-select-')])[3]");
    public static  By startdatepicker=By.xpath("//input[contains(@id,'analytics_start_date')]");
    public static  By enddatepicker=By.xpath("//input[contains(@id,'analytics_end_date')]");
    public static  By redflagcluster1=By.xpath("(//div[@class='cluster'])[1]/img/following-sibling::div");
    public static  By redflagcluster2=By.xpath("(//div[@class='cluster'])[2]/img/following-sibling::div");
    public static  By redflagpin1=By.xpath("(//div[@class='cluster'])[3]/img/following-sibling::div");
    public static  By redflagpin2=By.xpath("(//div[@class='cluster'])[4]/img/following-sibling::div");
    public static  By redflagcount=By.xpath("(//div[contains(@class,'MapStatistic__Container-')])[1]/div[2]");
    public static  By yellowflagcount=By.xpath("(//div[contains(@class,'MapStatistic__Container-')])[2]/div[2]");
    public static  By greenflagcount=By.xpath("(//div[contains(@class,'MapStatistic__Container-')])[3]/div[2]");
    public static  By reportscompletedcount=By.xpath("(//div[contains(@class,'MapStatistic__Container-')])[4]/div[2]");
    public static  By reportsmissedcount=By.xpath("(//div[contains(@class,'MapStatistic__Container-')])[5]/div[2]");


}
