package pages;

import com.gsInfo.core.ReusableLib;
import com.gsInfo.core.Helper;
import org.openqa.selenium.By;

public class HomePage extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public HomePage(Helper helper) {
        super(helper
        );


    }

    public static By email= By.name("email");
    public static By pwd=By.name("password");
    public static By submitBtn= By.id("btn_login");
    public static By admin=By.xpath("//a[contains(text(),'Admin')]");
    public static By site=By.xpath("//span[contains(text(),'AutoSite')]");
    public static By edit=By.xpath("//span[contains(text(),'AutoSite')]/../../..//button[contains(text(),'Edit details')]");

   // @AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
    public  static By  appEmail =By.xpath("//android.widget.EditText[@text='Email']");

    public  static By  appPwd =By.xpath("//android.widget.EditText[@text='Password']");

    public  static By   appSbmtBtn =By.xpath("//android.widget.TextView[@text='SUBMIT']");

    public static By  appProfile=By.xpath("//android.widget.TextView[@text='Profile']");
    public static By  appSetting=By.xpath("//android.widget.TextView[@text='Settings']");
    public static By  applogOut=By.xpath("//android.widget.TextView[@text='ACCOUNT LOGOUT']");
    public static By  yesBtn=By.xpath("//android.widget.Button[@resource-id='android:id/button2']");



    public static By appSiteLandingPage =By.xpath("//android.widget.TextView[@text='Outlet']");
    public static By startCheckOut =By.xpath("//android.widget.TextView[@text='Start Anytime']");

    public static By schedule =By.xpath("//android.widget.TextView[@text='Scheduled']");
    public static By checkIn =By.xpath("//android.widget.TextView[@text='Check In']");
    public static By reportsTab =By.xpath("//android.widget.TextView[@text='Reports']");
    public static By calender =By.xpath("//android.widget.TextView[@text='Calendar']");

    public static By salestb=By.xpath("//android.widget.TextView[@text='Sales']");
    public static By achvdPe=By.xpath("//android.widget.TextView[@text='You've Achieved']");
    public static By achvdPerf=By.xpath("//android.widget.TextView[contains(@text,'Achieved')]/..//android.widget.HorizontalScrollView//android.widget.TextView[1]");
    public static By backTohomepage =By.xpath("//android.widget.TextView[contains(@text,'AutoSite_')]/preceding-sibling::android.view.ViewGroup/android.widget.TextView");



}
