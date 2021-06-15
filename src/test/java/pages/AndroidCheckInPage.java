package pages;

import com.gsInfo.core.ReusableLib;
import com.gsInfo.core.Helper;
import org.openqa.selenium.By;

public class AndroidCheckInPage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public AndroidCheckInPage(Helper helper) {
        super(helper
        );


    }

    public static By email = By.name("email");
    public static By pwd = By.name("password");
    public static By submitBtn = By.id("btn_login");
    public static By admin = By.xpath("//a[contains(text(),'Admin')]");
    public static By site = By.xpath("//span[contains(text(),'AutoSite')]");
    public static By edit = By.xpath("//span[contains(text(),'AutoSite')]/../../..//button[contains(text(),'Edit details')]");


    // @AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
    public static By appEmail = By.xpath("//android.widget.EditText[@text='Email or phone number']");

    public static By appPwd = By.xpath("//android.widget.EditText[@text='Password']");

    public static By appSbmtBtn = By.xpath("//android.widget.TextView[@text='SUBMIT']");

    public static By appProfile = By.xpath("//android.widget.TextView[@text='Profile']");
    public static By appSetting = By.xpath("//android.widget.TextView[@text='Settings']");
    public static By applogOut = By.xpath("//android.widget.TextView[@text='ACCOUNT LOGOUT']");
    public static By yesBtn = By.xpath("//android.widget.Button[@text-id='YES']");

    public static By proceedBtn = By.xpath("//android.widget.TextView[@text='Proceed']");


    public static By appSiteLandingPage = By.xpath("//android.widget.TextView[@text='Outlet']");
    public static By startCheckOut = By.xpath("//android.widget.TextView[@text='Start Anytime']");

    public static By schedule = By.xpath("//android.widget.TextView[@text='Scheduled']");
    public static By checkIn = By.xpath("//android.widget.TextView[@text='Check In']");
    public static By reportsTab = By.xpath("//android.widget.TextView[@text='Reports']");
    public static By calender = By.xpath("//android.widget.TextView[@text='Calendar']");

    public static By salestb = By.xpath("//android.widget.TextView[@text='Sales']");
    public static By achvdPe = By.xpath("//android.widget.TextView[@text='You've Achieved']");
    public static By achvdPerf = By.xpath("//android.widget.TextView[contains(@text,'Achieved')]/..//android.widget.HorizontalScrollView//android.widget.TextView[1]");
    public static By backTohomepage = By.xpath("//android.widget.TextView[contains(@text,'AutoSite_')]/preceding-sibling::android.view.ViewGroup/android.widget.TextView");


    /**
     * Check In
     */

    public static By notStrted = By.xpath("//android.widget.TextView[@text='Not Started']");
    public static By progressbtn = By.xpath("//android.widget.TextView[contains(@text,'Progress')]");
    public static By cntnBtn = By.xpath("//android.widget.Button[@index='6']");
    public static By restBtn = By.xpath("//android.widget.TextView[contains(@text,'Reset')]");
    public static By schdlBtn = By.xpath("//android.widget.TextView[@text='Scheduled']");
    public static By adhoc = By.xpath("//android.widget.TextView[@text='Ad-hoc']");

    public static By questions = By.xpath("//android.widget.TextView[contains(@text,'Question')]");
    public static By questionName = By.xpath("//android.widget.TextView[contains(@text,'Question')]/following-sibling::android.widget.TextView");
    public static By questionsYes = By.xpath("//android.widget.TextView[@text='Yes']");
    public static By questionsNo = By.xpath("//android.widget.TextView[@text='No']");
    public static By questionsRed = By.xpath("//android.widget.TextView[contains(@text,'Red Flag')]");

    public static By cmt = By.xpath("//android.widget.EditText[@text='Comments']");
    public static By addPhoto = By.xpath("//android.widget.TextView[@text='Add Photo']");

    public static By nxtQsn = By.xpath("//android.widget.TextView[@text='NEXT QUESTION']");
    public static By smryRed = By.xpath("//android.widget.TextView[contains(@text,'Red Flags:')]");
    public static By smryYllw = By.xpath("//android.widget.TextView[contains(@text,'Yellow Flags:')]");
    public static By smryGrn = By.xpath("//android.widget.TextView[contains(@text,'Green Flags:')]");

    public static By chckOut = By.xpath("//android.widget.TextView[@text='CHECK-OUT']");

    public static By chckInOutYes = By.xpath("//android.widget.Button[@text='YES']");

    public static By strtAnytime =  By.xpath("//android.widget.TextView[contains(@text,'Start')]");
    public static By chckOutNo = By.xpath("//android.widget.Button[@text='NO']");

    public static By gtBtn = By.xpath("//android.widget.TextView[@text='GOT IT!']");

    public static By reviewRpt = By.xpath("//android.widget.TextView[@text='REVIEW REPORT']");


    /**
     * SALES PROGRESS
     */

    public static By salePrgrss = By.xpath("android.widget.TextView[contains(@text,'984150')]");
    public static By salePopUp = By.xpath("//android.widget.TextView[@text='SALES']");
    public static By to_date = By.xpath("//android.widget.TextView[@text='To-Date']");
    public static By to_Month = By.xpath("//android.widget.TextView[@text='Month']");
    public static By notifcsn = By.xpath("//android.widget.TextView[@text='#983194;']");
    public static By thsWeek = By.xpath("//android.widget.TextView[@text='THIS WEEK']/preceding-sibling::android.widget.TextView");
    public static By farAway = By.xpath("//android.widget.TextView[contains(@text,'You are too far')]");
   // public static By redflags = By.xpath("//android.widget.TextView[@text='Report Complete!']/../android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.TextView");

    public static By redflags =  By.xpath("//android.view.ViewGroup[@index='3']/android.widget.TextView");
    public static By yellowflags =  By.xpath("//android.view.ViewGroup[@index='4']/android.widget.TextView");
    public static By greenflags =  By.xpath("//android.view.ViewGroup[@index='5']/android.widget.TextView");

    public static By reportedSite = By.xpath("//android.widget.TextView[@text='Report Complete!']/preceding-sibling::android.widget.TextView");


    /**Open Map**/

    public static By mapButton= By.id("android:id/button2");
    public static By mapOK= By.id("android:id/button1");
    public static By closeX=By.xpath("//android.widget.TextView[@index='0']");
    public static By setLoc=By.xpath("//android.widget.TextView[@text='Set Location']");
    public static By setLocBtn=By.xpath("//android.widget.Button[@index='3']");
    public static By seeMap=By.xpath("//android.widget.TextView[@text='see map']");

    /**Generic Site*/

    public static By tapToReport=By.xpath("//android.widget.TextView[@text='TAP TO DO REPORT']");
    public static By saleNotfcsn =By.xpath("//android.widget.TextView[@text='THIS WEEK']/../preceding-sibling::android.view.ViewGroup[@index='1']/android.view.ViewGroup");
    public static By notifcationPop =By.xpath("//android.widget.TextView[@text='THIS WEEK']/../following-sibling::android.view.ViewGroup[@index='4']/android.view.ViewGroup");
    public static By notifcationClose=By.xpath("//android.widget.TextView[@text='Notifications']/preceding-sibling::android.widget.TextView");
    public static By closeSaleNotifcations = By.xpath("//android.widget.TextView[@text='SALES']/../../../preceding-sibling::android.view.ViewGroup[@index='1']/android.view.ViewGroup");
    public static By weeklyHome =By.xpath("//android.widget.TextView[@text='THIS WEEK']");
    public static By progressBar=By.xpath("//android.widget.ProgressBar[@index='0']");
}
