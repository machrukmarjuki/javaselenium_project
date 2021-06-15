package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AndroidIssueTrckrPage;
import supportLibraries.Utility_Functions;

import java.util.HashMap;

public class AndroidIssueTracker extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public AndroidIssueTracker(Helper helper) {
        super(helper);
    }


    /**
     * Keyword to  Validate Issue status and resolved it
     *
     * @Gopesh
     */
    public void validateAppHome() {
        String siteName = Utility_Functions.xGetJsonAsString("ReportedSiteName");
        click(AndroidIssueTrckrPage.issueTb, "Clicked on Sales  progress ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        waitForVisible(AndroidIssueTrckrPage.issueTrackerLabel);
        click(AndroidIssueTrckrPage.filtrBtn, "Clicked on filter  progress ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        click(AndroidIssueTrckrPage.siteList);
        sendKeys(AndroidIssueTrckrPage.srchSite, siteName);


        //Utility_Functions.xfindElAndClick(driver,AndroidIssueTrckrPage.filtrdSite,"Site_Name",siteName);
        WebElement el = Utility_Functions.findElementByXpath(driver, AndroidIssueTrckrPage.filtrDt, "Site_Name", siteName);
        click(el);
        click(el, "Click on Site");
        click(AndroidIssueTrckrPage.applybtn, "Click on Apply ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        click(AndroidIssueTrckrPage.thsWeek);
        waitForElementClickable(AndroidIssueTrckrPage.issueUpdatBtn, globalWait);
        Utility_Functions.timeWaitMiliSeconds(400);
        String Status = getText(AndroidIssueTrckrPage.status);
        xAssertEquals("OPEN", AndroidIssueTrckrPage.status, "Validate Status ");

        click(AndroidIssueTrckrPage.issueUpdatBtn, "Click on Issue update button");
        waitForElementClickable(AndroidIssueTrckrPage.updtsubmit, globalWait);
        sendKeys(AndroidIssueTrckrPage.issueCmtTxtBx, "Issue has been resolved");
        click(AndroidIssueTrckrPage.takePhoto);
        click(AndroidIssueTrckrPage.takePhoto, "Click on  photo button");
        click(AndroidIssueTrckrPage.takePic, "Photo taken");
        click(AndroidIssueTrckrPage.resolveBtn, "Clicked on Resolved");
        click(AndroidIssueTrckrPage.updtsubmit, "Click on Issue Submit button");
        waitForElementClickable(AndroidIssueTrckrPage.issueBckBtn, globalWait);
        Status = getText(AndroidIssueTrckrPage.status);

        xAssertEquals("RESOLVED", AndroidIssueTrckrPage.status, "Validate Status ");


    }


    /**
     * Key world to Create a new AdHoc Issue
     *
     * @Gopesh
     */
    public void createAdHocIssue() {
        String siteName = Utility_Functions.xGetJsonAsString("ReportedSiteName");
        String flag = jsonData.getData("Flag");
        click(AndroidIssueTrckrPage.issueTb, "Clicked on Sales  progress ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        waitForVisible(AndroidIssueTrckrPage.issueTrackerLabel);
        click(AndroidIssueTrckrPage.adhocIssueBtn, "Clicked on create Adhoc issue btn ");
        waitForElementClickable(AndroidIssueTrckrPage.updtsubmit, globalWait);
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String addHocIssue = "AutoAdHocIssue_" + rn + rnNum;
        switch (flag) {
            case "Red":
                click(AndroidIssueTrckrPage.selectRedFlag, "select  Red flag");
                break;
            case "Yellow":
                click(AndroidIssueTrckrPage.selectYellwFlag, "select Yellow flag");
        }
        sendKeys(AndroidIssueTrckrPage.enterTitle, addHocIssue, "entered issue title as " + addHocIssue);
        click(AndroidIssueTrckrPage.selectSite);
        waitForVisible(AndroidIssueTrckrPage.chooseAssigned);
        String getSelectSite = getText(AndroidIssueTrckrPage.selectDrpByIndex);
        click(AndroidIssueTrckrPage.selectDrpByIndex);
        click(AndroidIssueTrckrPage.selectDrpByIndex);
//        androiScrollAndClick(siteName);
//        androiScrollAndClick(siteName);
        sendKeys(AndroidIssueTrckrPage.issueCmtTxtBx, "Ad Hoc Issue has been Added");
        click(AndroidIssueTrckrPage.selectIssueCatgry);
        Utility_Functions.timeWaitMiliSeconds(500);

        String getSelectedIssue = getText(AndroidIssueTrckrPage.selectCatDrpByIndex);
        click(AndroidIssueTrckrPage.selectCatDrpByIndex);
        click(AndroidIssueTrckrPage.selectCatDrpByIndex);
        //waitForElementClickable(AndroidIssueTrckrPage.enterIssueCatgry,globalWait);
//        androiScrollAndClick("Demo");
//        androiScrollAndClick("Demo");
        click(AndroidIssueTrckrPage.selectIssueDepart);
        Utility_Functions.timeWaitMiliSeconds(500);
        waitForVisible(AndroidIssueTrckrPage.chooseReportLabl);
        // waitForVisible(AndroidIssueTrckrPage.chooseAssigned);
        String getSelecDepart = getText(AndroidIssueTrckrPage.selectDrpByIndex);
        click(AndroidIssueTrckrPage.selectDrpByIndex);
        // click(AndroidIssueTrckrPage.selectDrpByIndex);
        // androiScrollAndClick("testGuest");
        click(AndroidIssueTrckrPage.updtsubmit, "Click on Issue Submit button");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        Utility_Functions.timeWaitMiliSeconds(400);
        String Status = getText(AndroidIssueTrckrPage.status);
        xAssertEquals("OPEN", AndroidIssueTrckrPage.status, "Validate Status ");
        Utility_Functions.xUpdateJson("AdHocIssue", addHocIssue);
        waitForElementClickable(AndroidIssueTrckrPage.issueBckBtn, globalWait);
        click(AndroidIssueTrckrPage.issueBckBtn, "Click on Back Arrow");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        androiScrollToText(addHocIssue);
        By issue = By.xpath("//android.widget.TextView[@text='" + addHocIssue + "']");
        vrfyElmentExist(issue, "Newly created Adhoc issue");
        // update data in Json file
        HashMap<String, String> filter = new HashMap<>();
        filter.put("SiteName", siteName);
        filter.put("SelectedCatName", getSelectedIssue);
        filter.put("SelectedDepartName", getSelecDepart);
        filter.put("CustomIssueName", addHocIssue);
        filter.put("Flag", flag);
        Utility_Functions.xUpdateJson("AddHocIssue", filter);
    }


    public void validateFilterBySite(){
        navToIssueTab();
        click(AndroidIssueTrckrPage.filtrBtn, "Clicked on filter  progress ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        issueFilter("SITE");

        click(AndroidIssueTrckrPage.applybtn, "Click on Apply ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        HashMap<String, String> filtrMap = Utility_Functions.xGetJsonMap("AddHocIssue");
        String siteName = filtrMap.get("SiteName");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        androiScrollToText(siteName);
        By issue = By.xpath("//android.widget.TextView[@text='" + siteName.toUpperCase() + "']");
        vrfyElmentExist(issue, "Filter by site: "+siteName+" working successfully");
    }
    public void validateFilterByDepart(){
        navToIssueTab();
        click(AndroidIssueTrckrPage.filtrBtn, "Clicked on filter  progress ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        issueFilter("DEPART");
        click(AndroidIssueTrckrPage.applybtn, "Click on Apply ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        HashMap<String, String> filtrMap = Utility_Functions.xGetJsonMap("AddHocIssue");
        String filterByVal = filtrMap.get("SelectedDepartName");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        androiScrollToText(filterByVal);
        By issue = By.xpath("//android.widget.TextView[@text='" + filterByVal + "']");
        vrfyElmentExist(issue, "Filter by Department: "+filterByVal+" working successfully");
    }
    public void issueFilter(String filterBy) {
        HashMap<String, String> filtrMap = Utility_Functions.xGetJsonMap("AddHocIssue");
        String siteName = filtrMap.get("SiteName");

        switch (filterBy.toUpperCase()) {
            case "SITE":
                click(AndroidIssueTrckrPage.siteList, "Click on Site filter arrow");
                sendKeys(AndroidIssueTrckrPage.srchSite, siteName,"Enter Site name "+siteName);
                WebElement siteEl = Utility_Functions.findElementByXpath(driver, AndroidIssueTrckrPage.filtrDt, "Site_Name", siteName);
                click(siteEl);
                click(siteEl, "Click on Site");
                break;
            case "DEPART":
                String dept = filtrMap.get("SelectedDepartName");
                click(AndroidIssueTrckrPage.departmntLIst,"Click on department filter");
                sendKeys(AndroidIssueTrckrPage.srchDepart, dept,"Enter Department "+dept);
                WebElement el = Utility_Functions.findElementByXpath(driver, AndroidIssueTrckrPage.filtrDt, "Site_Name", dept);
                click(el);
                click(el, "Click on Departent");
                break;
            case "FLAG":
                String flag = filtrMap.get("Flag");
                switch (flag) {
                    case "Red":
                        click(AndroidIssueTrckrPage.selectRedFlag, "select  Red flag");
                        break;
                    case "Yellow":
                        click(AndroidIssueTrckrPage.selectYellwFlag, "select Yellow flag");
                }
                break;
            case "QUESTION":

                break;


        }


        //Utility_Functions.xfindElAndClick(driver,AndroidIssueTrckrPage.filtrdSite,"Site_Name",siteName);

    }

    public void validateFilterByFlag(){
        navToIssueTab();
        click(AndroidIssueTrckrPage.filtrBtn, "Clicked on filter  progress ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        issueFilter("DEPART");
        issueFilter("FLAG");
        click(AndroidIssueTrckrPage.applybtn, "Click on Apply ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        HashMap<String, String> filtrMap = Utility_Functions.xGetJsonMap("AddHocIssue");
        String filterByVal = filtrMap.get("SelectedDepartName");
        String flag = filtrMap.get("Flag");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        androiScrollToText(filterByVal);
        By issue = By.xpath("//android.widget.TextView[@text='" + filterByVal + "']");
        vrfyElmentExist(issue, "Filter by Flag : "+flag+" working successfully");

    }
    public void navToIssueTab(){
        click(AndroidIssueTrckrPage.issueTb, "Clicked on Sales  progress ");
        waitForElementDisappear(AndroidIssueTrckrPage.issueLoading, globalWait);
        waitForVisible(AndroidIssueTrckrPage.issueTrackerLabel);
    }

}
