package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;
import org.openqa.selenium.By;
import pages.AndroidCheckInPage;
import supportLibraries.Utility_Functions;

import java.util.HashMap;

import static supportLibraries.Utility_Functions.*;

public class AndroidCheckIn extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public AndroidCheckIn(Helper helper) {
        super(helper);
    }



    /**
     * Key word to Login in Android App
     *
     * @Gopesh
     */
    public void andoidLogin() {

        if (isDisplayed(AndroidCheckInPage.appEmail)) {
            Utility_Functions.waitForElementVisible(driver, AndroidCheckInPage.appEmail, globalWait);
            sendKeys(AndroidCheckInPage.appEmail, "nimblyqc@gmail.com", " Email entered Successfully");
            sendKeys(AndroidCheckInPage.appPwd, "Admin2021", "Pwd entered successfully");
            click(AndroidCheckInPage.appSbmtBtn, "clicked on Submit button successfully");
        }
        if (isDisplayed(AndroidCheckInPage.proceedBtn)) {

            click(AndroidCheckInPage.proceedBtn, "clicked on Proceed button successfully");
        }
        timeWait(1);
        waitForVisible(AndroidCheckInPage.weeklyHome);


    }

    /**
     * Key word to Check In Site
     *
     * @Gopesh
     */
    public void mobileApp() {
        String siteName =
                "AutoSite_";
        By siteNameBy = By.xpath("//android.widget.TextView[contains(@text," + siteName + "')]");
        Utility_Functions.timeWait(3);
        waitForElementDisappear(AndroidCheckInPage.progressBar,globalWait+40);
        Utility_Functions.waitForElementVisible(driver, AndroidCheckInPage.appSetting, globalWait);
        waitForElementDisappear(AndroidCheckInPage.progressBar,globalWait);
        click(AndroidCheckInPage.tapToReport, "Click on seeMap");
        // androiScrollAndClick(siteName);
        Utility_Functions.timeWait(2);
        waitForElementClickable(AndroidCheckInPage.seeMap, globalWait);
        click(AndroidCheckInPage.seeMap, "Click on seeMap");
        click(AndroidCheckInPage.setLoc, "set location");
        click(AndroidCheckInPage.chckInOutYes, "Confirm location");
        waitForVisible(AndroidCheckInPage.strtAnytime);
        if (isDisplayed(AndroidCheckInPage.notStrted)) {
            click(AndroidCheckInPage.notStrted, "Clicked on  Not Started");
            waitForElementClickable(AndroidCheckInPage.checkIn, globalWait);
            click(AndroidCheckInPage.checkIn, "Clicked on Check In button");
            click(AndroidCheckInPage.chckInOutYes, "Checked -In ");
        } else {
            click(AndroidCheckInPage.progressbtn, "Clicked on  Not Started");
            waitForElementClickable(AndroidCheckInPage.cntnBtn, globalWait);
            click(AndroidCheckInPage.cntnBtn, "Clicked on Check In button");

        }

        waitForVisible(AndroidCheckInPage.questions);
        String questionNumber = Utility_Functions.getText(driver, AndroidCheckInPage.questions);
        String[] numArry = questionNumber.split("of");
        String num = numArry[1].trim();
        String[] questions = {"Red", "No", "Yes"};
        for (int i = 0; i < Integer.parseInt(num); i++) {
            String val = i < questions.length ? questions[i] : "Yes";
            HashMap<String, String> questsn = selectQuestion(val);
        }

        click(AndroidCheckInPage.reviewRpt, "Clicked on Review Report ");
        waitForVisible(AndroidCheckInPage.smryRed);
        String redFlag = getText(AndroidCheckInPage.smryRed);
        redFlag = redFlag.split(":")[1].trim();
        String grnFlag = getText(AndroidCheckInPage.smryGrn);
        grnFlag = grnFlag.split(":")[1].trim();
        String yellowFlag = getText(AndroidCheckInPage.smryYllw);
        yellowFlag = yellowFlag.split(":")[1].trim();
        click(AndroidCheckInPage.chckOut, "Clicked on Check out button");

        click(AndroidCheckInPage.chckInOutYes, "Checked -out yes  ");


        String reportedSite = getText(AndroidCheckInPage.reportedSite);

        Utility_Functions.xUpdateJson("ReportedSiteName", reportedSite);

        xAssertEquals("0" + redFlag, AndroidCheckInPage.redflags, "Validate Total RedFlag");
        xAssertEquals("0" + grnFlag, AndroidCheckInPage.greenflags, "Validate Total GreenFlag");
        xAssertEquals("0" + yellowFlag, AndroidCheckInPage.yellowflags, "Validate Total YellowGlag");


        click(AndroidCheckInPage.gtBtn, "Clicked on Got  ");


    }

    /**
     * KeyWord to Logout from Andoid App
     *
     * @Gopesh
     */
    public void androidLogOut() {
        click(AndroidCheckInPage.appSetting, "clicked on Setting button successfully");
        Utility_Functions.waitForElementVisible(driver, AndroidCheckInPage.applogOut, globalWait);
        click(AndroidCheckInPage.applogOut, "clicked on Logout button successfully");
        click(AndroidCheckInPage.yesBtn, "clicked on Yes button successfully");
    }


    /**
     * Keyword to Validate UI for Android
     *
     * @gopesh
     */
    public void androidUI() {
        waitForVisible(AndroidCheckInPage.weeklyHome);
        waitForElementDisappear(AndroidCheckInPage.progressBar,globalWait);
        click(AndroidCheckInPage.notifcationPop,"Clicked on Notification Link");
        click(AndroidCheckInPage.notifcationClose,"Closed Notification Pop up");
        click(AndroidCheckInPage.saleNotfcsn,"Click on Sales Pop up lin");
        waitForVisible(AndroidCheckInPage.salePopUp);
        click(AndroidCheckInPage.closeSaleNotifcations,"Closed Sale Pop up");
        androidNavToSite();
        click(AndroidCheckInPage.reportsTab, "Clicked on Report successfully");
        click(AndroidCheckInPage.calender, "Clicked on Calender successfully");

        click(AndroidCheckInPage.salestb, "Clicked on Sales successfully");
        timeWait(2);
        waitForElementVisible(driver, AndroidCheckInPage.achvdPerf, globalWait);
        String text = Utility_Functions.getText(driver, AndroidCheckInPage.achvdPerf, "text");
        System.out.println("Text " + text);
        report.updateTestLog("%Target Acheived", text, Status.PASS);
        click(AndroidCheckInPage.backTohomepage);

    }

    public HashMap<String, String> selectQuestion(String val) {
        HashMap<String, String> questsn = new HashMap<>();
        String noQuestion = null;
        String redFlgQuetion = null;
        switch (val) {
            case "Yes":
                click(AndroidCheckInPage.questionsYes);
                clickIfAvlble(AndroidCheckInPage.nxtQsn, "Clicked on Next Question");
                Utility_Functions.timeWaitMiliSeconds(400);
                break;
            case "No":
                click(AndroidCheckInPage.questionsNo);


                String questionName = Utility_Functions.getText(driver, AndroidCheckInPage.questionName);
                noQuestion = noQuestion == null ? questionName : noQuestion + "," + questionName;
                sendKeys(AndroidCheckInPage.cmt, "Automation Comment - NO", "Comment Added ");
                clickIfAvlble(AndroidCheckInPage.nxtQsn, "Clicked on Next Question");
                Utility_Functions.timeWaitMiliSeconds(400);
                break;
            case "Red":
                click(AndroidCheckInPage.questionsRed);


                questionName = Utility_Functions.getText(driver, AndroidCheckInPage.questionName);
                redFlgQuetion = redFlgQuetion == null ? questionName : redFlgQuetion + "," + questionName;
                sendKeys(AndroidCheckInPage.cmt, "Automation Comment - NO", "Comment Added ");
                clickIfAvlble(AndroidCheckInPage.nxtQsn, "Clicked on Next Question");
                Utility_Functions.timeWaitMiliSeconds(400);
                break;

        }
        questsn.put("No", noQuestion);
        questsn.put("Red", redFlgQuetion);
        return questsn;


    }

    public void androidNavToSite() {
        Utility_Functions.timeWait(3);
        waitForVisible(AndroidCheckInPage.weeklyHome);
        Utility_Functions.waitForElementVisible(driver, AndroidCheckInPage.appSetting, globalWait);
        waitForVisible(AndroidCheckInPage.weeklyHome);
        click(AndroidCheckInPage.tapToReport, "Click on Site");
        // androiScrollAndClick(siteName);
        Utility_Functions.timeWait(2);
        waitForElementClickable(AndroidCheckInPage.seeMap, globalWait);
    }

    public void androidNavToSpecicSite(String siteName) {
        Utility_Functions.timeWait(3);
        waitForVisible(AndroidCheckInPage.weeklyHome);
        Utility_Functions.waitForElementVisible(driver, AndroidCheckInPage.appSetting, globalWait);
        waitForVisible(AndroidCheckInPage.weeklyHome);
        androiScrollAndClick(siteName);
        Utility_Functions.timeWait(2);
        waitForElementClickable(AndroidCheckInPage.seeMap, globalWait);
    }
}
