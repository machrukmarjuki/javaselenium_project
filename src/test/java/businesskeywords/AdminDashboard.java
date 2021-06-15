package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.*;
import supportLibraries.Utility_Functions;

import java.text.ParseException;
import java.time.LocalDate;


import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static supportLibraries.Utility_Functions.*;

public class AdminDashboard extends ReusableLib{

    /***
     *  Constructor to initialize the {@link Helper} object and in turn the and wrap the objects with it
     * @param helper
     */
    public AdminDashboard(Helper helper) {
        super(helper);
    }

    /***
     * Keyword to verify dashboard overview UI
     * @author Zahran
     */
    public void verifyDashboardoverview () throws InterruptedException {

        click(AdminDashboardPage.dashboard_lnk);
        click(AdminDashboardPage.dashboardoverview_lnk);
        vrfyElmentExist(AdminDashboardPage.sitesoverviewmap,"SitesOverviewMap area exists");
        Utility_Functions.xAssertThat(report,"Reports Done","",getText(AdminDashboardPage.reportsDone),"Successful found reports done");
        Utility_Functions.xAssertThat(report,"Report Completion","",getText(AdminDashboardPage.reportsCompletion),"Successful found reports completion");
        Utility_Functions.xAssertThat(report,"Missed Reports","",getText(AdminDashboardPage.reportsmissed),"Successful found reports missed");
        Utility_Functions.xAssertThat(report,"Issues Resolved","",getText(AdminDashboardPage.issuesresolved),"Successful found issues resolved");
        Utility_Functions.xAssertThat(report,"Issues Completion","",getText(AdminDashboardPage.issuescompletion),"Successful found issues completion");
        Utility_Functions.xAssertThat(report,"Issues Reported","",getText(AdminDashboardPage.issuesreported),"Successful found issues reported");
        Utility_Functions.xAssertThat(report,"Green Flag","",getText(AdminDashboardPage.greenflag),"Successful found green flag");
        Utility_Functions.xAssertThat(report,"Red Flag","",getText(AdminDashboardPage.redflag),"Successful found red flag");
        Utility_Functions.xAssertThat(report,"Yellow Flag","",getText(AdminDashboardPage.yellowflag),"Successful found yellow flag");
        Utility_Functions.xAssertThat(report,"Issues' Category","",getText(AdminDashboardPage.issuescategory),"Successful found Issues Category");
        vrfyElmentExist(AdminDashboardPage.departmentsfilter,"Departments Filter  exists");
        vrfyElmentExist(AdminDashboardPage.sitesfilter,"Sites Filter exists");
        vrfyElmentExist(AdminDashboardPage.startdatepicker,"Start Date Filter exists");
        vrfyElmentExist(AdminDashboardPage.enddatepicker,"End Date Filter exists");

    }

    /***
     * Keyword to verify dashboard overview default filters functionality
     * @author Zahran
     */
    public void verifyDefaultFiltersfunctionality () throws InterruptedException, ParseException {

        click(AdminDashboardPage.dashboard_lnk);
        click(AdminDashboardPage.dashboardoverview_lnk);
        vrfyElmentExist(AdminDashboardPage.departmentsfilter,"Departments Filter exists");
        vrfyElmentExist(AdminDashboardPage.sitesfilter,"Sites Filter exists");
        vrfyElmentExist(AdminDashboardPage.periodfilter,"Periods Filter exists");
        vrfyElmentExist(AdminDashboardPage.startdatepicker,"Start-Date Filter exists");
        vrfyElmentExist(AdminDashboardPage.enddatepicker,"End-Date Filter exists");
        Utility_Functions.xWaitForElementPresentInPage(driver,AdminDashboardPage.zoominbutton,60);
        xSendKeyBoardkeys(driver, AdminDashboardPage.periodfilterinput, "Custom", Keys.ENTER);
        sendKeys(AdminDashboardPage.startdatepicker,"13/12/2020");
        sendKeys(AdminDashboardPage.enddatepicker,"10/06/2021");
        timeWait(10);
        click(AdminDashboardPage.zoomoutbutton);
        timeWait(3);
        click(AdminDashboardPage.zoomoutbutton);
        timeWait(3);
        Utility_Functions.xAssertThat(report,"07","",getText(AdminDashboardPage.redflagcluster1),"Successful found cluster 1");
        Utility_Functions.xAssertThat(report,"13","",getText(AdminDashboardPage.redflagcluster2),"Successful found cluster 2");
        Utility_Functions.xAssertThat(report,"20","",getText(AdminDashboardPage.redflagcount),"Successful found Red Flag count");
        Utility_Functions.xAssertThat(report,"05","",getText(AdminDashboardPage.yellowflagcount),"Successful found Yellow Flag count");
        Utility_Functions.xAssertThat(report,"205","",getText(AdminDashboardPage.greenflagcount),"Successful found Green Flag count");
        Utility_Functions.xAssertThat(report,"31","",getText(AdminDashboardPage.reportscompletedcount),"Successful found Completed reports count");
        Utility_Functions.xAssertThat(report,"1.9 K","",getText(AdminDashboardPage.reportsmissedcount),"Successful found Missed reports count");

    }

}
