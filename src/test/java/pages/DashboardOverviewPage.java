package pages;

import businesskeywords.DashboardOverview;
import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;

public class DashboardOverviewPage extends ReusableLib {

    public DashboardOverviewPage (Helper helper) {
        super(helper);
    }

    //button
    public static By btnApply = By.xpath("//button[text()='Apply']");
    public static By btnReset = By.xpath("//button[text()='Reset']");

    //Top Filters
    public static By drpdwn_Departments = By.xpath("//*[contains(@class, 'CheckboxFilter__CheckboxValueContainer')][text()='All Departments']");
    public static By slct_depart1 = By.xpath("//*[contains(@class, 'CheckboxFilter__CheckboxOption')]//label[text()='2237 Test']");
    public static By drpdwn_Site = By.xpath("//*[contains(@class, 'CheckboxFilter__CheckboxValueContainer')][text()='All Site']");
    public static By drpdwn_Questionnaire = By.xpath("//*[contains(@class, 'CheckboxFilter__CheckboxValueContainer')][text()='All Questionnaires']");
    public static By drpdwn_User = By.xpath("//*[contains(@class, 'CheckboxFilter__CheckboxValueContainer')][text()='All User']");
    public static By drpdwn_Period = By.xpath("//div[contains(@class,'AnalyticsControllerStyles__Root')]//*[text()='Last 7 Days']");
    public static By slct_ThisWeek = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='This Week']");
    public static By slct_LastWeek = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Last Week']");
    public static By slct_7Days = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Last 7 Days']");
    public static By slct_28Days = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Last 28 Days']");
    public static By slct_30Days = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Last 30 Days']");
    public static By slct_90Days = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Last 90 Days']");
    public static By slct_6Months = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Last 6 Months']");
    public static By slct_12Months = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Last 12 Months']");
    public static By slct_LastYear = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Last Year']");
    public static By slct_MonthToDate = By.xpath("//div[contains(@class,'PeriodFilter__PeriodOption')][text()='Month-to-date']");
    public static By dtpckr_StartDate = By.xpath("//div[contains(@class,'AnalyticsControllerStyles__Root')]//div[@class='DateInput DateInput_1'][1]");
    public static By dtpckr_EndDate = By.xpath("//div[contains(@class,'AnalyticsControllerStyles__Root')]//div[@class='DateInput DateInput_1'][2]");


    //Site Overview Map
    public static By loadingMap = By.id("");
    public static By lbl_Dashboard_Overview_Map = By.className("sites-overview--map");
    public static By SiteOvrvw_ReportMissed = By.xpath("//div[@class='statistic-row--category'][text()='Report Missed']");
    public static By SiteOvrvw_RedFlag = By.xpath("//div[@class='statistic-row--category'][text()='Red Flag']");
    public static By SiteOvrvw_YellowFlag = By.xpath("//div[@class='statistic-row--category'][text()='Yellow Flag']");
    public static By SiteOvrvw_GreenFlag = By.xpath("//div[@class='statistic-row--category'][text()='Green Flag']");
    public static By SiteOvrvw_ReportCmplt = By.xpath("//div[@class='statistic-row--category'][text()='Report Complete']");



    //Report Overview
    public static By tab_scheduled = By.xpath("//*[text()='Scheduled']");
    public static By tab_adhoc = By.xpath("//*[text()='Ad-Hoc']");
    public static By chartReportWeek = By.xpath("//*[@class='AnalyticsScore-period-text'][text()='7 days']");
    public static By chartReport7Days = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' 7 days']");
    public static By chartReport28Days = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' 28 days']");
    public static By chartReport30Days = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' 30 days']");
    public static By chartReport90Days = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' 90 days']");
    public static By chartReport6Month = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' 6 months']");
    public static By chartReport12Month = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' 12 months']");
    public static By chartReportLastYear = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' last year']");
    public static By chartReportMonthToDate = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' Month-to-Date']");





    //Issue Overview
    public static By chartIssuesWeek = By.xpath("//*[@class='AnalyticsScore-period-text'][text()='7 days']");
    public static By chartIssues7Days = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' 7 days']");
    public static By chartIssues28Days = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' 28 days']");
    public static By chartIssues30Days = By.xpath("//*[@class='AnalyticsScore-period-text'][text()='vs. past 30 days']");
    public static By chartIssues90Days = By.xpath("//*[@class='AnalyticsScore-period-text'][text()='vs. past 90 days']");
    public static By chartIssues6Month = By.xpath("//*[@class='AnalyticsScore-period-text'][text()='vs. past 6 month(s)']");
    public static By chartIssuesLastYear = By.xpath("//*[@class='AnalyticsScore-period-text'][text()='vs. past 1 year(s)']");
    public static By chartIssuesMonthToDate = By.xpath("//*[@class='AnalyticsScore-period-text'][text()=' Month-to-Date']");
    public static By chartIssues12Month = By.xpath("//*[@class='AnalyticsScore-period-text'][text()='vs. past 12 month(s)']");


}
