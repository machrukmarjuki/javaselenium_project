package pages;

import org.openqa.selenium.By;

public class AndroidSettingPage {

    public static By termsLink = By.xpath("//android.widget.TextView[contains(@text,'TERMS')]/following-sibling::android.widget.TextView");
    public static By nimblyVersion = By.xpath("//android.widget.TextView[contains(@text,'NIMBLY VERSION')]/following-sibling::android.widget.TextView");
    public static By privacyPolicy = By.xpath("//android.widget.TextView[contains(@text,'PRIVACY POLICY')]/following-sibling::android.widget.TextView");



    public static By trmSrvc=By.xpath("//android.widget.TextView[contains(@text,'Terms of Service')]");
    public static By iso27=By.xpath("//android.widget.TextView[contains(@text,'We are ISO 27001')]");
   public static By homeBt= By.xpath("//android.view.View[@content-desc='Home']/android.widget.Image");
    public static By features= By.xpath("//android.view.View[@content-desc='Features']/android.widget.Image");
    public static By blog= By.xpath("//android.view.View[@content-desc='Blog']/android.widget.Image");
    public static By aboutUs= By.xpath("//android.view.View[@content-desc='About Us']/android.widget.Image");

    public static By BckBtn=By.xpath("//android.widget.Button[@content-desc='Settings, back']/android.widget.ImageView");
}


