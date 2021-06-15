package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.WebElement;
import pages.DemoAdminSitePage;
import supportLibraries.Utility_Functions;

public class DemoAdminSite extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public DemoAdminSite(Helper helper) {
        super(helper);
    }

    /**
     * Keyword to login into application
     * @author gopesh
     */
    public void demoLogin(){

      // WebElement loginWebElement= driver.findElement(DemoAdminSitePage.loginName);
     //  loginWebElement.sendKeys("gopesh@hellonimbly.com");

        String email = jsonData.getData("Email");
        String password = jsonData.getData("Password");
        String address = jsonData.getData("Address");


        sendKeys(DemoAdminSitePage.loginName,email);
//       WebElement pws=driver.findElement(DemoAdminSitePage.loginPws);
//       pws.sendKeys("password1");

        sendKeys(DemoAdminSitePage.loginPws,"password1");


//       WebElement submtBtn= driver.findElement(DemoAdminSitePage.submitBtn);
//       submtBtn.click();
//

        click(DemoAdminSitePage.submitBtn);


    }
}
