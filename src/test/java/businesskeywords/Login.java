package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.paulhammant.ngwebdriver.NgWebDriver;
import pages.AndroidCheckInPage;
import supportLibraries.Utility_Functions;

public class Login extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public Login(Helper helper) {
        super(helper);
    }


    /**
     * Keyword to launch the application
     *
     * @author Gopesh
     */
    private static String  env = System.getProperty("ENV");
    public void lauchApp() {
        if (env == null) {
            env = properties.getProperty("ENV");
        }
        String url = properties.getProperty(env + "URL");
        driver.get(url);
        NgWebDriver ngDriver=driver.getNgWebDriver();
        ngDriver.waitForAngularRequestsToFinish();
    }

    /**
     * Keyword to Login
     *
     * @author Gopesh
     */
    public void login() {
        String userName = properties.getProperty(env + "User");
        String pwd = properties.getProperty(env + "PWD");
        Utility_Functions.waitForElementVisible(driver, AndroidCheckInPage.email, globalWait);

        sendKeys(AndroidCheckInPage.email, userName, " Email entered Successfully");
        sendKeys(AndroidCheckInPage.pwd, pwd, "Pwd entered successfully");
        click(AndroidCheckInPage.submitBtn, "clicked on Submit button successfully");
    }

}
