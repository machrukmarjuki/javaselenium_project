package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.*;
import software.amazon.awssdk.services.eks.model.Issue;
import supportLibraries.Utility_Functions;

import java.sql.Time;

import static supportLibraries.Utility_Functions.*;

public class IssueTracker extends ReusableLib {

    public IssueTracker (Helper helper) { super(helper); }

    public void navigateIssueTracker(){
        //Click Issue Tracker menu
        xWaitForElementPresent(driver, IssueTrackerPage.issueTrackerLink, globalWait);
        click(IssueTrackerPage.issueTrackerLink);
        xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
    }

    /**
     * Keyword to Verify "Issue Tracker" page is rendered correctly
     *
     * @author machruk
     */
    public void issueTrackerPageRendered(){
        navigateIssueTracker();
        vrfyElmentExist(IssueTrackerPage.drpdwnByQuest, "Verify filter by Questionnaire is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnByUser, "Verify filter by User is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnByDept, "Verify filter by Department is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnBySite, "Verify filter by Site is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnByFlag, "Verify filter by Flag is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnByStatus, "Verify filter by Status is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnByPrior, "Verify filter by Prior is available");
        vrfyElmentExist(IssueTrackerPage.viewByStartDate, "Verify view by Start Date is available");
        vrfyElmentExist(IssueTrackerPage.viewByEndDate, "Verify view by End Date is available");
        vrfyElmentExist(IssueTrackerPage.sortByDateCreated, "Verify sort by Date Created is available");
        vrfyElmentExist(IssueTrackerPage.sortByDueDate, "Verify sort by Due Date is available");

    }

    /**
     * Keyword to Verify filter by "Questionnaire" is working properly
     *
     * @author machruk
     */

    public void filterByQuest() {
        String questIssue = "colorbox";
        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.drpdwnByQuest, globalWait);
        timeWait(10);

        xWaitForElementPresent(driver, IssueTrackerPage.drpdwnByQuest, globalWait);
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnByQuest, "colorbox", Keys.ENTER);

        xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
        timeWait(10);

        String srchResult = "(//span[text()='colorbox '])[1]";
        //xWaitForElementPresent(driver, By.xpath(srchResult), globalWait);
        vrfyElmentExist(By.xpath(srchResult), "The User " + questIssue + " is present");

    }

    /**
     * Keyword to Verify filter by "User" is working properly
     *
     * @author machruk
     */

    public void filterByUser() {

        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        timeWait(10);

        xWaitForElementPresent(driver, IssueTrackerPage.drpdwnByUser, globalWait);
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnByUser, "Iqbal", Keys.ENTER);

        xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
        timeWait(10);

        String searchUser=Utility_Functions.xGetJsonAsString("IssueUser");

        String srchResult = "(//span[text()='" + searchUser+ "'])[1]";
        vrfyElmentExist(By.xpath(srchResult), "The User " + searchUser + " is present");

    }


    /**
     * Keyword to Verify filter by "Department" is working properly
     *
     * @author machruk
     */
    public void filterByDepartment() {

        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        timeWait(10);

        xWaitForElementPresent(driver, IssueTrackerPage.drpdwnByDept, globalWait);
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnByDept, "Special AutoDepartment", Keys.ENTER);

        xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
        timeWait(10);

        String searchDept=Utility_Functions.xGetJsonAsString("IssueDept");

        String srchResult = "(//span[text()='" + searchDept+ "'])[1]";
        vrfyElmentExist(By.xpath(srchResult), "The User " + searchDept + " is present");

    }


    /**
     * Keyword to Verify filter by "Site" is working properly
     *
     * @author machruk
     */
    public void filterBySite(){
        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        timeWait(10);

        xWaitForElementPresent(driver, IssueTrackerPage.drpdwnBySite, globalWait);
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnBySite, "Pasar Pagi", Keys.ENTER);

        xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
        timeWait(10);

        String searchSite=Utility_Functions.xGetJsonAsString("IssueSite");

        String srchResult = "(//span[text()='" + searchSite+ "'])[1]";
        vrfyElmentExist(By.xpath(srchResult), "The site " + searchSite + " is present");

    }

    /**
     * Keyword to Verify filter by "Flag" is working properly
     *
     * @author machruk
     */
    public void filterByFlag(){
        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        timeWait(10);

        xWaitForElementPresent(driver, IssueTrackerPage.drpdwnByFlag, globalWait);
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnByFlag, "Red", Keys.ENTER);

        xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
        timeWait(10);

        String searchFlag=Utility_Functions.xGetJsonAsString("IssueFlag");

        String srchResult = "(//span[text()='" + searchFlag+ "'])[1]";
        vrfyElmentExist(By.xpath(srchResult), "The Flag " + searchFlag + " is present");

    }

    /**
     * Keyword to Verify filter by "Status" is working properly
     *
     * @author machruk
     */
    public void filterByStatus(){
        String IssueStatus = "Open";
        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        timeWait(10);

        xWaitForElementPresent(driver, IssueTrackerPage.drpdwnByStatus, globalWait);
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnByStatus, "Open", Keys.ENTER);

        xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
        timeWait(10);

        String srchResult = "(//span[text()='" + IssueStatus+ "'])[1]";
        vrfyElmentExist(By.xpath(srchResult), "The Status " + IssueStatus + " is present");

    }


    /**
     * Keyword to Verify filter by "Priority" is working properly
     *
     * @author machruk
     */
    public void filterByPriority(){
        String IssuePriority = "High";
        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        timeWait(10);

        xWaitForElementPresent(driver, IssueTrackerPage.drpdwnByPrior, globalWait);
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnByPrior, IssuePriority, Keys.ENTER);
        xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
        timeWait(10);
        String srchResult = "(//span[text()='" + IssuePriority+ "'])[1]";
        xWaitForElementPresent(driver, By.xpath(srchResult), globalWait);
        vrfyElmentExist(By.xpath(srchResult), "The Status " + IssuePriority + " is present");


    }

    /**
     * Keyword to Verify View by periods is working properly
     *
     * @author machruk
     */
    public void viewByPeriods() {
        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        timeWait(10);

        //Select Start Date
        click(IssueTrackerPage.viewByStartDate);
        xWaitForElementPresent(driver, IssueTrackerPage.datePickerPrevMonth, globalWait);
        click(IssueTrackerPage.datePickerPrevMonth);
        click(IssueTrackerPage.selectStartDate);
        //click(IssueTrackerPage.selectEndDate);

        //Select End Date
        //click(IssueTrackerPage.viewByEndDate);
        //xWaitForElementPresent(driver, IssueTrackerPage.datePickerNextMonth, globalWait);
        //click(IssueTrackerPage.datePickerNextMonth);
        //xWaitForElementPresent(driver, IssueTrackerPage.selectEndDate, globalWait);




    }


    /**
     * Keyword to Verify Sort by "Date Created" is working properly
     *
     * @author machruk
     */
    public void sortByDateCreated() {
        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDateCreated, globalWait);
        timeWait(10);

        //Select Sort by Due Date
        click(IssueTrackerPage.sortByDateCreated);
        //Assertion to verify sort by due date is working properly
        //xWaitForElementToBeClickable(driver, IssueTrackerPage.selectStartDate, globalWait);


    }

    /**
     * Keyword to Verify sort by "Due Date" is working properly
     *
     * @author machruk
     */
    public void sortByDueDate() {
        navigateIssueTracker();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        timeWait(10);

        //Select Sort by Due Date
        click(IssueTrackerPage.sortByDueDate);
        //Assertion to verify sort by due date is working properly
        //xWaitForElementToBeClickable(driver, IssueTrackerPage.selectStartDate, globalWait);


    }




    /**
     * Keyword to Verify add Issue is successfully
     *
     * @author machruk
     */
    public void addIssue(){
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String issueTitle = "AutoIssue_" + rn + rnNum;
        String issueUser = "Iqbal";
        String issueDept = "Special AutoDepartment";
        String issueSite = "Pasar Pagi";
        String issueFlag = "Red";



        Utility_Functions.xUpdateJson("IssueTitle", issueTitle);
        Utility_Functions.xUpdateJson("IssueUser", issueUser);
        Utility_Functions.xUpdateJson("IssueDept", issueDept);
        Utility_Functions.xUpdateJson("IssueSite", issueSite);
        Utility_Functions.xUpdateJson("IssueFlag", issueFlag);
        Utility_Functions.xUpdateJson("IssueFlag", issueFlag);

        timeWait(5);
        //Input Issue Title
        sendKeys(IssueTrackerPage.inputIssueTitle, issueTitle, "Entered Issue Title");

        //Severity
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnSeverityIssue, issueFlag, Keys.ENTER);
        //Site
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnSiteIssue, issueSite, Keys.ENTER);
        //Assigned to User
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnAssignedUser, issueUser, Keys.ENTER);
        //Comment Issue
        sendKeys(IssueTrackerPage.inputCommentIssue, "This issue was created using automation");
        //Select Due Date
        //click(IssueTrackerPage.drpdwnDueDate);
        //xWaitForElementPresent(driver, IssueTrackerPage.datePickerNextMonth, globalWait);
        //click(IssueTrackerPage.datePickerNextMonth);
        //xWaitForElementPresent(driver, IssueTrackerPage.selectDueDate, globalWait);
        //click(IssueTrackerPage.selectDueDate);
        //xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnDueTime, "17:00", Keys.ENTER);

        //Select Category
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnCateg, "Daily Activity", Keys.ENTER);

        //Click Add (Save)
        click(IssueTrackerPage.saveIssueBtn, "Click Add button is successfully");
        //Assigned Department
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnAssignedDept, issueDept, Keys.ENTER);
        //Reporter Department
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnReporterDept, issueDept, Keys.ENTER);
        //Click Add (Save)
        click(IssueTrackerPage.saveIssueBtn, "Click Add button is successfully");
        //Success toast
        //Utility_Functions.xWaitForElementPresent(driver, IssueTrackerPage.successToast, globalWait);


        //Verify Issue is displayed
        driver.navigate().refresh();
        searchIssue();
        timeWait(5);



    }

    /**
     * Keyword to Verify "Add Issue" Modal is rendered correctly
     *
     * @author machruk
     */
    public void addIssueModal(){
        //Click Add Issue button
        click(IssueTrackerPage.addIssueBtn);
        xWaitForElementPresent(driver, IssueTrackerPage.inputIssueTitle, globalWait);

        vrfyElmentExist(IssueTrackerPage.inputIssueTitle, "Verify Issue Title field is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnCateg, "Verify Category dropdown is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnAssignedDept, "Verify Assigned Department dropdown is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnReporterDept, "Verify Reporter Department dropdown is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnAssignedUser, "Verify Assigned User dropdown is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnSiteIssue, "Verify Site dropdown is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnSeverityIssue, "Verify Severity dropdown is available");
        vrfyElmentExist(IssueTrackerPage.drpdwnDueDate, "Verify Due Date dropdown is available");
        //vrfyElmentExist(IssueTrackerPage.drpdwnDueTime, "Verify Due Time dropdown is available");
        vrfyElmentExist(IssueTrackerPage.inputCommentIssue, "Verify Comment Issue field is available");
        vrfyElmentExist(IssueTrackerPage.linkAddImage, "Verify Add Image link is available");
        vrfyElmentExist(IssueTrackerPage.saveIssueBtn, "Verify Save button is available");
        vrfyElmentExist(IssueTrackerPage.cancelIssueBtn, "Verify Cancel button is available");

    }

    /**
     * Keyword to Verify warning messages is displayed when Required Fields are skipped
     *
     * @author machruk
     */
    public void requiredFields(){
        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String issueTitle = "AutoIssue_" + rn + rnNum;

        Utility_Functions.xUpdateJson("IssueTitle", issueTitle);

        navigateIssueTracker();

        //Click Add Issue button
        click(IssueTrackerPage.addIssueBtn);
        xWaitForElementPresent(driver, IssueTrackerPage.inputIssueTitle, globalWait);

        //Click Add (Save)
        click(IssueTrackerPage.saveIssueBtn, "Click Add button is successfully");
        //Warning Message
        xWaitForElementPresent(driver, IssueTrackerPage.wrngMsgField,globalWait);
        vrfyElmentExist(IssueTrackerPage.wrngMsgField, "Verify warning message is displayed");

        //Input Issue Title
        sendKeys(IssueTrackerPage.inputIssueTitle, issueTitle, "Entered Issue Title");
        //Click Add (Save)
        click(IssueTrackerPage.saveIssueBtn, "Click Add button is successfully");
        //Warning Message
        vrfyElmentExist(IssueTrackerPage.wrngMsgField, "Verify warning message is displayed");


        //Site
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnSiteIssue, "Pasar Pagi", Keys.ENTER);
        //Click Add (Save)
        click(IssueTrackerPage.saveIssueBtn, "Click Add button is successfully");
        //Warning Message
        vrfyElmentExist(IssueTrackerPage.wrngMsgField, "Verify warning message is displayed");

        //Assigned Department
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnAssignedDept, "Special AutoDepartment", Keys.ENTER);
        //Click Add (Save)
        click(IssueTrackerPage.saveIssueBtn, "Click Add button is successfully");
        //Warning Message
        vrfyElmentExist(IssueTrackerPage.wrngMsgField, "Verify warning message is displayed");

        //Reporter Department
        xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnReporterDept, "Special AutoDepartment", Keys.ENTER);


        //Click Add (Save)
        click(IssueTrackerPage.saveIssueBtn, "Click Add button is successfully");
        //Success toast
        Utility_Functions.xWaitForElementPresent(driver, IssueTrackerPage.successToast, globalWait);
        timeWait(3);

    }

    /**
     * Keyword to Verify update status to resolved is successfully
     *
     * @author machruk
     */
    public void updateStatusResolved () throws InterruptedException {
        //Click Issue Tracker menu
        navigateIssueTracker();

        //Search Issue
        searchIssue();

        //Change Status to Resolved
        xSendKeyBoardkeys(driver, IssueTrackerPage.detailIssueStatus, "Resolved", Keys.ENTER);
        //Verify change to resolved successfully
        driver.navigate().refresh();
        xWaitForElementPresent(driver, IssueTrackerPage.sortByDueDate, globalWait);
        searchIssue();
        xWaitForElementPresent(driver, IssueTrackerPage.statusResolved, globalWait);
        timeWait(3);


    }

    /**
     * Keyword to Verify add comment is successfully
     *
     * @author machruk
     */
    public void addComment(){
        sendKeys(IssueTrackerPage.inputComment, "This Issue has been resolved using automation");
        xWaitForElementPresent(driver, IssueTrackerPage.postBtn, globalWait);
        click(IssueTrackerPage.postBtn);
        timeWait(3);

    }

    /**
     * Keyword to Verify search issue is working properly
     *
     * @author machruk
     */
    public void searchIssue(){
        //Filter by Open Status
        //xSendKeyBoardkeys(driver, IssueTrackerPage.drpdwnByStatus, "Open", Keys.ENTER);
        xWaitForElementPresent(driver, IssueTrackerPage.inputSearchIssue, globalWait);

        String searchIssue=Utility_Functions.xGetJsonAsString("IssueTitle");
        sendKey(IssueTrackerPage.inputSearchIssue,searchIssue);
        String srchResult = "(//span[text()='" + searchIssue+ "'])[1]";
        click(By.xpath(srchResult));
        xWaitForElementPresent(driver, IssueTrackerPage.detailIssueStatus, globalWait);


    }





}
