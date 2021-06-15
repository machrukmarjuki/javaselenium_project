package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import pages.AdminDepartmentPage;
import pages.AdminQuestionnairePage;
import pages.AdminSitePage;

import supportLibraries.Utility_Functions;

import static supportLibraries.Utility_Functions.*;

public class AdminQuestionnaire extends ReusableLib {
    /***
     * Constructor to initialize the {@link Helper} object and in turn the and wrap the objects with it
     * @param helper
     */
    public AdminQuestionnaire(Helper helper) {
        super(helper);
    }

    /***
     * Keyword to create a questionnaire with questions of same category
     * @author Zahran
     */
    public void addQuestionnairesamecategory () throws InterruptedException {

        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String quesName = "Autoquestionnaire_" + rn + rnNum;
        String QuestionnaireDesc ="Created Questionnaire for Automation purposes";
        jsonData.putData("QuestionnaireName", quesName);
        Utility_Functions.xUpdateJson("QuestionnaireName", quesName);
        String depname=Utility_Functions.xGetJsonAsString("DepartmentName");
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminQuestionnairePage.questionnaireLnk, "Clicked on Questionnaire link");
        click(AdminQuestionnairePage.addquestionnaire);
        sendKeys(AdminQuestionnairePage.questionnairetitle,quesName);
        xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_dept,depname,Keys.ENTER);
        xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_cat,"Category #1",Keys.ENTER);
        sendKeys(AdminQuestionnairePage.questionname,"What do you prefer ?");
        xSendKeyBoardkeys(driver,AdminQuestionnairePage.questiontype,"Green/Yellow/Red Flag",Keys.ENTER);
        sendKeys(AdminQuestionnairePage.Yestxtbox,"Yes");
        sendKeys(AdminQuestionnairePage.Notxtbox,"No");
        sendKeys(AdminQuestionnairePage.RedFlagtxtbox,"Can't Answer!");
        click(AdminQuestionnairePage.photochkbox);
        click(AdminQuestionnairePage.videochkbox);
        click(AdminQuestionnairePage.docschkbox);
        click(AdminQuestionnairePage.publishbtn);
        Utility_Functions.xAssertEquals(report,"Questionnaire has been successfully saved",getText(AdminQuestionnairePage.toastmessage),"Successful toast message contains confirmation text");
        vrfyElmentExist(AdminQuestionnairePage.toastmessage,"Toast message shown");
    }

    /***
     * Keywprd to create a questionnaire with questions of different categories
     * @author Zahran
     */
    public void addQuestionnairedifferentcategory () throws InterruptedException {

        String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        String quesName = "Autoquestionnaire_" + rn + rnNum;
        String QuestionnaireDesc ="Created Questionnaire for Automation purposes";
        jsonData.putData("QuestionnaireName", quesName);
        Utility_Functions.xUpdateJson("QuestionnaireName", quesName);
        String depname=Utility_Functions.xGetJsonAsString("DepartmentName");
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminQuestionnairePage.questionnaireLnk, "Clicked on Questionnaire link");
        click(AdminQuestionnairePage.addquestionnaire);
        sendKeys(AdminQuestionnairePage.questionnairetitle,quesName);
        xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_dept,depname,Keys.ENTER);
        xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_cat,"Category #1",Keys.ENTER);
        sendKeys(AdminQuestionnairePage.questionname,"What do you prefer ?");
        xSendKeyBoardkeys(driver,AdminQuestionnairePage.questiontype,"Green/Yellow/Red Flag",Keys.ENTER);
        sendKeys(AdminQuestionnairePage.Yestxtbox,"Yes");
        sendKeys(AdminQuestionnairePage.Notxtbox,"No");
        sendKeys(AdminQuestionnairePage.RedFlagtxtbox,"Can't Answer!");
        click(AdminQuestionnairePage.photochkbox);
        click(AdminQuestionnairePage.videochkbox);
        click(AdminQuestionnairePage.docschkbox);
        click(AdminQuestionnairePage.addcategorybtn);
        xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_cat1,"Category #2",Keys.ENTER);
        sendKeys(AdminQuestionnairePage.questionname1,"What color do you like ?");
        sendKeys(AdminQuestionnairePage.Yestxtbox,"Green");
        sendKeys(AdminQuestionnairePage.Notxtbox,"Yellow");
        sendKeys(AdminQuestionnairePage.RedFlagtxtbox,"Red");
        click(AdminQuestionnairePage.publishbtn);

    }

    /***
     * Keyword to verify created questionniare
     * @author Zahran
     */
    public void verifyCreateQuestionnaire () throws InterruptedException {
        addQuestionnairedifferentcategory();
        Utility_Functions.xAssertEquals(report,"Questionnaire has been successfully saved",getText(AdminQuestionnairePage.toastmessage),"Successful toast message contains confirmation text");
        vrfyElmentExist(AdminQuestionnairePage.toastmessage,"Toast message shown");
    }

    /***
     * Keyword to edit created questionnaire
     * @author Zahran
     */
    public void editQuestionnaire () throws InterruptedException {
        String questname = Utility_Functions.xGetJsonAsString("QuestionnaireName");
        searchQuestionnaire(questname);
        xWaitForElementPresent(driver,AdminQuestionnairePage.editicon, globalWait);
        click(AdminQuestionnairePage.editicon);
        xWaitForElementPresent(driver,AdminQuestionnairePage.questionnairetitle, globalWait);
        sendKeys(AdminQuestionnairePage.questionnairetitle,questname+" Updated");
        questname=driver.findElement(AdminQuestionnairePage.questionnairetitle).getAttribute("value");
        jsonData.putData("QuestionnaireName",questname);
        Utility_Functions.xUpdateJson("QuestionnaireName", questname);
        click(AdminQuestionnairePage.editpublishbtn);
        Utility_Functions.xAssertEquals(report,"Questionnaire has been successfully saved",getText(AdminQuestionnairePage.toastmessage),"Successful toast message contains confirmation text");
        vrfyElmentExist(AdminQuestionnairePage.toastmessage,"Toast message shown");
    }

    /***
     * Keyword to duplicate created questionnaire
     * @author Zahran
     */
    public void duplicateQuestionnaire () throws InterruptedException {
        String questname = Utility_Functions.xGetJsonAsString("QuestionnaireName");
        searchQuestionnaire(questname);
        xWaitForElementPresent(driver,AdminQuestionnairePage.cloneicon, globalWait);
        click(AdminQuestionnairePage.cloneicon);
        click(AdminQuestionnairePage.cloneYes);
        vrfyElmentExist(AdminQuestionnairePage.questionnairestable,"Questionnaire table shown");
    }

    /***
     * Keyword to delete created questionnaire
     * @author Zahran
     */
    public void deleteQuestionnaire () throws InterruptedException {
        String questname = Utility_Functions.xGetJsonAsString("QuestionnaireName");
        searchQuestionnaire(questname);
        xWaitForElementPresent(driver,AdminQuestionnairePage.deleteicon, globalWait);
        click(AdminQuestionnairePage.deleteicon);
        click(AdminQuestionnairePage.deleteYes);
        Utility_Functions.xAssertEquals(report,"Successfull delete questionnaire",getText(AdminQuestionnairePage.toastmessage),"Successful toast message contains confirmation text");
        vrfyElmentExist(AdminQuestionnairePage.toastmessage,"Toast message shown");
    }

    /***
     * Keyword to download a questionniare
     * @author Zahran
     */
    public void downloadQuestionnaire () throws InterruptedException {
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminQuestionnairePage.questionnaireLnk, "Clicked on Questionnaire link");
        xWaitForElementPresent(driver,AdminQuestionnairePage.questchkbox, globalWait);
        click(AdminQuestionnairePage.questchkbox);
        click(AdminQuestionnairePage.downloadbtn);
        click(AdminQuestionnairePage.Yesbtn);
        xWaitForElementPresent(driver,AdminQuestionnairePage.questionnairestable, globalWait);
        Utility_Functions.xAssertEquals(report,"Success download questionnaires",getText(AdminQuestionnairePage.toastmessage),"Successful toast message contains confirmation text");
        vrfyElmentExist(AdminQuestionnairePage.toastmessage,"Toast message shown");
    }

    /***
     * Keyword to bulk upload a questionniare
     * @author Zahran
     */
    public void bulkuploadQuestionnaire () throws InterruptedException {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        String depname=Utility_Functions.xGetJsonAsString("DepartmentName");
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminQuestionnairePage.questionnaireLnk, "Clicked on Questionnaire link");
        click(AdminQuestionnairePage.bulkuploadbtn);
        sendKeys(AdminQuestionnairePage.questname,"Uploaded questionnaire"+rn);
        //xSendKeyBoardkeys(driver, AdminQuestionnairePage.templatename, "Covid-19 - Risk Assessment (English)", Keys.ENTER);
        xSendKeyBoardkeys(driver, AdminQuestionnairePage.deptname, depname, Keys.ENTER);
        click(AdminQuestionnairePage.selectxlsxbtn);
        xUploadFile(report,System.getProperty("user.dir")+"\\src\\test\\resources\\Files for upload\\Covid-19 - Risk Assessment (English).xlsx");
        vrfyElmentExist(AdminQuestionnairePage.uploadedfile,"File selected successfully");
        timeWait(3);
        Utility_Functions.xMouseClick(driver,driver.findElement(AdminQuestionnairePage.submitbutton));
        //click(AdminQuestionnairePage.submitbutton);
        Utility_Functions.xAssertEquals(report,"Success upload bulk questionnaire",getText(AdminQuestionnairePage.toastmessage),"Successful toast message contains confirmation text");
        vrfyElmentExist(AdminQuestionnairePage.toastmessage,"Toast message shown");
    }

    /***
     * Keyword to search for a questionniare
     * @param questname to pass the searchable questionniare name
     * @author Zahran
     */
    public void searchQuestionnaire (String questname) throws InterruptedException {
        //String questname = Utility_Functions.xGetJsonAsString("QuestionnaireName");
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminQuestionnairePage.questionnaireLnk, "Clicked on Questionnaire link");
        sendKeys(AdminQuestionnairePage.searchtxbox, questname);
    }

    /***
     * Keyword to verify searched questionniare
     * @author Zahran
     */
    public void verifySearchQuestionnaire () throws InterruptedException {
        String questname = Utility_Functions.xGetJsonAsString("QuestionnaireName");
        searchQuestionnaire(questname);
        Utility_Functions.xWaitForElementPresent(driver, AdminQuestionnairePage.questionnairestable, globalWait);
        vrfyElmentExist(AdminQuestionnairePage.questionnairestable,"Search row exists .. ");
    }
}
