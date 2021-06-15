package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import pages.AdminAuditorsPage;
import pages.AdminQuestionnairePage;
import pages.AdminSitePage;
import supportLibraries.Utility_Functions;

import java.util.Random;

import static supportLibraries.Utility_Functions.*;

public class AdminAuditors extends ReusableLib  {
    public static String username;

    /***
     *  Constructor to initialize the {@link Helper} object and in turn the and wrap the objects with it
     * @param helper
     */
    public AdminAuditors(Helper helper) {
        super(helper);
    }

    /***
     * Keyword to navigate to auditors page
     * @author Zahran
     */
    public void navigatetoAuditors () throws InterruptedException {

        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminAuditorsPage.auditorsLnk, "Clicked on Auditors link");
        vrfyElmentExist(AdminAuditorsPage.adduser,"AddUser button shown");
        vrfyElmentExist(AdminAuditorsPage.bulkupload,"BulkUpload button shown");
        vrfyElmentExist(AdminAuditorsPage.downloadselectedbtn,"DownloadSelected button shown");
        vrfyElmentExist(AdminAuditorsPage.activatetab,"Activate tab shown");
        vrfyElmentExist(AdminAuditorsPage.blockedtab,"Blocked tab shown");
        vrfyElmentExist(AdminAuditorsPage.searchbox,"Search box shown");
        vrfyElmentExist(AdminAuditorsPage.Auditorstable,"Users table shown");
    }

    /***
     * Keyword to add an auditor
     * @author Zahran
     */
    public void addAuditor () throws InterruptedException {
        Random random = new Random();
        String rn = RandomStringUtils.randomAlphanumeric(4);
        String rn1 = String.format("%04d", random.nextInt(10000));
        String auditorName = "test" + rn;
        jsonData.putData("AuditorName", auditorName);
        Utility_Functions.xUpdateJson("AuditorName", auditorName);
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminAuditorsPage.auditorsLnk, "Clicked on Auditors link");
        click(AdminAuditorsPage.adduser, "Clicked on Add User button");
        sendKeys(AdminAuditorsPage.username, auditorName,"Entered username");
        sendKeys(AdminAuditorsPage.useremail, "test"+rn+"@hellonimbly.com","Entered user email");
        xSendKeyBoardkeys(driver, AdminAuditorsPage.userdepartment, "QA Department", Keys.ENTER);
        sendKeys(AdminAuditorsPage.userphone, "+20 114 411 "+rn1,"Entered user phone");
        String email=driver.findElement(AdminAuditorsPage.useremail).getAttribute("value");
        click(AdminAuditorsPage.savebutton);
        vrfyElmentExist(AdminAuditorsPage.toastmessage,"Toast message shown");
        Utility_Functions.xAssertEquals(report,email+" successfully added.",getText(AdminAuditorsPage.toastmessage),"Successful toast message contains confirmation text");
    }

    /***
     * Keyword to edit an auditor
     * @author Zahran
     */
    public void editAuditor () throws InterruptedException {

        String auditorName=Utility_Functions.xGetJsonAsString("AuditorName");
        searchAuditor(auditorName);
        click(AdminAuditorsPage.editicon);
        xWaitForElementPresent(driver,AdminAuditorsPage.useremail, globalWait);
        sendKey(AdminAuditorsPage.username,username+"Updated");
        auditorName=driver.findElement(AdminAuditorsPage.username).getAttribute("value");
        jsonData.putData("AuditorName",auditorName);
        Utility_Functions.xUpdateJson("AuditorName", auditorName);
        click(AdminAuditorsPage.savebutton);
        vrfyElmentExist(AdminAuditorsPage.toastmessage,"Toast message shown");
        Utility_Functions.xAssertEquals(report,"Successfully updated user",getText(AdminAuditorsPage.toastmessage),"Successful toast message contains confirmation text");
    }

    /***
     * Keyword to block an auditor
     * @author Zahran
     */
    public void blockAuditor () throws InterruptedException {

        String auditorName=Utility_Functions.xGetJsonAsString("AuditorName");
        searchAuditor(auditorName);
        click(AdminAuditorsPage.deleteicon);
        click(AdminAuditorsPage.deleteconfirm);
        vrfyElmentExist(AdminAuditorsPage.toastmessage,"Toast message shown");
        Utility_Functions.xAssertEquals(report,"Successfully Block User",getText(AdminAuditorsPage.toastmessage),"Successful toast message contains confirmation text");
    }

    /***
     * Keyword to activatr a blocked auditor
     * @author Zahran
     */
    public void activateAuditor () throws InterruptedException {

        String auditorName=Utility_Functions.xGetJsonAsString("AuditorName");
        searchAuditor(auditorName);
        click(AdminAuditorsPage.blockedtab);
        click(AdminAuditorsPage.activatebtn);
        click(AdminAuditorsPage.confirmactivate);
        vrfyElmentExist(AdminAuditorsPage.toastmessage,"Toast message shown");
        Utility_Functions.xAssertEquals(report,"Successfully Activate User",getText(AdminAuditorsPage.toastmessage),"Successful toast message contains confirmation text");
    }

    /***
     * Keyword to download an auditor
     * @author Zahran
     */
    public void downloadAuditor () throws InterruptedException {

        String auditorName=Utility_Functions.xGetJsonAsString("AuditorName");
        searchAuditor(auditorName);
        click(AdminAuditorsPage.checkauditor);
        click(AdminAuditorsPage.downloadbtn);
        click(AdminAuditorsPage.Yesbtn);
        vrfyElmentExist(AdminAuditorsPage.toastmessage,"Toast message shown");
        Utility_Functions.xAssertEquals(report,"Success in downloading auditors",getText(AdminAuditorsPage.toastmessage),"Successful toast message contains confirmation text");
    }

    /***
     * Keyword to upload an auditor
     * @author Zahran
     */
    public void bulkupload () throws InterruptedException {
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminAuditorsPage.auditorsLnk, "Clicked on Auditors link");
        click(AdminAuditorsPage.bulkupload);
        click(AdminAuditorsPage.uploadxlsx);
        xUploadFile(report,System.getProperty("user.dir")+"\\src\\test\\resources\\Files for upload\\user-template.xlsx");
        vrfyElmentExist(AdminAuditorsPage.uploadedfile,"File selected successfully");
        timeWait(3);
        click(AdminAuditorsPage.uploadbtn);
        vrfyElmentExist(AdminAuditorsPage.toastmessage,"Toast message shown");
        Utility_Functions.xAssertEquals(report,"Successfully upload users bulk",getText(AdminAuditorsPage.toastmessage),"Successful toast message contains confirmation text");
    }

    /***
     * Keyword to search for an auditor
     * @param auditorName this is the searchable auditor name
     * @author Zahran
     */
    public void searchAuditor (String auditorName) throws InterruptedException {
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminAuditorsPage.auditorsLnk, "Clicked on Questionnaire link");
        sendKeys(AdminAuditorsPage.searchbox, auditorName);
    }

    /***
     * Keyword to verify searchable auditor
     * @author Zahran
     */
    public void verifySearchAuditor () throws InterruptedException {
        String auditorName=Utility_Functions.xGetJsonAsString("AuditorName");
        searchAuditor(auditorName);
        Utility_Functions.xWaitForElementPresent(driver, AdminQuestionnairePage.questionnairestable, globalWait);
        vrfyElmentExist(AdminAuditorsPage.Auditorstable,"Search row exists .. ");
    }
}
