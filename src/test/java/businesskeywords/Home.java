package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;
import org.openqa.selenium.By;
import pages.HomePage;
import supportLibraries.Utility_Functions;

import static supportLibraries.Utility_Functions.*;

public class Home extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public Home(Helper helper) {
        super(helper);
    }


  
    public void mobileApp() {
        if (isDisplayed(HomePage.appEmail)) {
            Utility_Functions.waitForElementVisible(driver, HomePage.appEmail, globalWait);
            sendKeys(HomePage.appEmail, "nimblyqc@gmail.com", " Email entered Successfully");
            sendKeys(HomePage.appPwd, "Admin2021", "Pwd entered successfully");
            click(HomePage.appSbmtBtn, "clicked on Submit button successfully");
        }
        String siteName=Utility_Functions.xGetJsonAsString("SiteName");
       By siteNameBy =By.xpath("//android.widget.TextView[contains(@text,'"+siteName+"')]");
        Utility_Functions.waitForElementVisible(driver, HomePage.appSetting, globalWait);
        click(siteNameBy, "Clicked on Site Successfully");
        click(HomePage.reportsTab, "Clicked on Report successfully");
        click(HomePage.calender, "Clicked on Calender successfully");

        click(HomePage.salestb, "Clicked on Sales successfully");
        timeWait(2);
        waitForElementVisible(driver, HomePage.achvdPerf, globalWait);
        String text = Utility_Functions.getText(driver, HomePage.achvdPerf, "text");
        System.out.println("Text " + text);
        report.updateTestLog("%Target Acheived",text, Status.PASS);
        click(HomePage.backTohomepage);
//        AndroidDriver androidDriver=  driver.getAndriodDriver();
//        androidDriver.pressKey(new KeyEvent(BACK) );

        click( HomePage.appSetting, "clicked on Setting button successfully");
        Utility_Functions.waitForElementVisible(driver, HomePage.applogOut, globalWait);
        click( HomePage.applogOut, "clicked on Logout button successfully");
        click( HomePage.yesBtn, "clicked on Yes button successfully");
    }
}
