package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;
import org.openqa.selenium.Keys;
import pages.DashboardOverviewPage;
import pages.DashboardPage;
import pages.PromotionPage;
import supportLibraries.Utility_Functions;

import static supportLibraries.Utility_Functions.timeWait;
import static supportLibraries.Utility_Functions.xSendKeyBoardkeys;

public class DashboardOverview extends ReusableLib {

    public DashboardOverview(Helper helper) {
        super(helper);
    }

    /*
     * Function to  navigate to Dashboard Issues page
     * @author : Machruk
     */

    public void navigateToDashboardOverview() {

        waitForElementPresent(DashboardOverviewPage.lbl_Dashboard_Overview_Map);

        Utility_Functions.xWaitForLoad(driver, globalWait);
        if (xWaitForElementVisible(DashboardOverviewPage.SiteOvrvw_ReportMissed, globalWait)) {
            report.updateTestLog("Verify that Dashboard Overview page is launched", "Dashboard Overview Page is launched", Status.PASS);
        } else {
            report.updateTestLog("Verify that Dashboard Overview page is launched", "Dashboard Overview Page is not launched", Status.FAIL);
        }
    }

    /*
     * Function to Verify Filter by Department is working properly
     * @author : Machruk
     */

    public void verifyFilterByDepartment() {
        String selectDepartment = "Special AutoDepartment";
        navigateToDashboardOverview();
        waitForElementClickable(DashboardOverviewPage.drpdwn_Departments, globalWait);
        xSendKeyBoardkeys(driver, DashboardOverviewPage.drpdwn_Departments, selectDepartment, Keys.ENTER);
        click(DashboardOverviewPage.slct_depart1);



        //click(DashboardOverviewPage.btnApply);

    }

    /*
     * Function to Verify Filter by Site is working properly
     * @author : Machruk
     */

    public void verifyFilterBySite() {
        String selectSite = "Jack Site";
        navigateToDashboardOverview();
        waitForElementClickable(DashboardOverviewPage.drpdwn_Site, globalWait);
        xSendKeyBoardkeys(driver, DashboardOverviewPage.drpdwn_Site, selectSite, Keys.ENTER);
        click(DashboardOverviewPage.btnApply);
    }


    /*
     * Function to Verify Filter by This Week is working properly
     * @author : Machruk
     */

    public void verifyFilterByThisWeek() {
        navigateToDashboardOverview();

        xWaitForElementPresent(driver, DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_ThisWeek, globalWait);
        click(DashboardOverviewPage.slct_ThisWeek);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReportWeek, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssuesWeek, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Last Week is working properly
     * @author : Machruk
     */

    public void verifyFilterByLastWeek() {
        navigateToDashboardOverview();

        waitForElementClickable(DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_LastWeek, globalWait);
        click(DashboardOverviewPage.slct_LastWeek);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReportWeek, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssuesWeek, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Last 7 Days is working properly
     * @author : Machruk
     */

    public void verifyFilterByLast7Days() {
        navigateToDashboardOverview();

        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_7Days, globalWait);
        click(DashboardOverviewPage.slct_7Days);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReport7Days, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssues7Days, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Last 28 Days is working properly
     * @author : Machruk
     */

    public void verifyFilterByLast28Days() {
        navigateToDashboardOverview();

        waitForElementClickable(DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_28Days, globalWait);
        click(DashboardOverviewPage.slct_28Days);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReport28Days, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssues28Days, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Last 30 Days is working properly
     * @author : Machruk
     */

    public void verifyFilterByLast30Days() {
        navigateToDashboardOverview();

        waitForElementClickable(DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_30Days, globalWait);
        click(DashboardOverviewPage.slct_30Days);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReport30Days, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssues30Days, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Last 90 Days is working properly
     * @author : Machruk
     */

    public void verifyFilterByLast90Days() {
        navigateToDashboardOverview();

        waitForElementClickable(DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_90Days, globalWait);
        click(DashboardOverviewPage.slct_90Days);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReport90Days, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssues90Days, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Last 6 Months is working properly
     * @author : Machruk
     */

    public void verifyFilterByLast6Months() {
        navigateToDashboardOverview();

        waitForElementClickable(DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_6Months, globalWait);
        click(DashboardOverviewPage.slct_6Months);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReport6Month, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssues6Month, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Last 12 Months is working properly
     * @author : Machruk
     */

    public void verifyFilterByLast12Months() {
        navigateToDashboardOverview();

        waitForElementClickable(DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_12Months, globalWait);
        click(DashboardOverviewPage.slct_12Months);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReport12Month, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssues12Month, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Last Year is working properly
     * @author : Machruk
     */

    public void verifyFilterByLastYear() {
        navigateToDashboardOverview();

        waitForElementClickable(DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_LastYear, globalWait);
        click(DashboardOverviewPage.slct_LastYear);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReportLastYear, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssuesLastYear, globalWait);
        timeWait(3);
    }


    /*
     * Function to Verify Filter by Month to Date is working properly
     * @author : Machruk
     */

    public void verifyFilterByMonthToDate() {
        navigateToDashboardOverview();

        waitForElementClickable(DashboardOverviewPage.drpdwn_Period, globalWait);
        click(DashboardOverviewPage.drpdwn_Period);
        xWaitForElementPresent(driver, DashboardOverviewPage.slct_MonthToDate, globalWait);
        click(DashboardOverviewPage.slct_MonthToDate);
        click(DashboardOverviewPage.btnApply);

        //Verify chart Report Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartReportMonthToDate, globalWait);

        //Verify chart Issue Completion is Displayed
        xWaitForElementPresent(driver, DashboardOverviewPage.chartIssuesMonthToDate, globalWait);
        timeWait(3);
    }

}
