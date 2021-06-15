package pages;

import org.openqa.selenium.By;

public class AndroidProfilePage {

    public static By totlRpt=By.xpath("//android.widget.TextView[contains(@text,'TOTAL REPORTS')]");

    public static By schudled=By.xpath("//android.widget.TextView[contains(@text,'SCHEDULED')]/preceding-sibling::android.widget.TextView[@index='0']");
    public static By ontime=By.xpath("//android.widget.TextView[contains(@text,'SCHEDULED')]/preceding-sibling::android.widget.TextView[@index='1']");
    public static By madeUp=By.xpath("//android.widget.TextView[contains(@text,'SCHEDULED')]/preceding-sibling::android.widget.TextView[@index='2']");
    public static By monData=By.xpath("//android.widget.TextView[contains(@text,'MON')]/preceding-sibling::android.widget.TextView");
    public static By tueData=By.xpath("//android.widget.TextView[contains(@text,'TUE')]/preceding-sibling::android.widget.TextView");
    public static By wedData=By.xpath("//android.widget.TextView[contains(@text,'WED')]/preceding-sibling::android.widget.TextView");
    public static By thuData=By.xpath("//android.widget.TextView[contains(@text,'THU')]/preceding-sibling::android.widget.TextView");
    public static By friData=By.xpath("//android.widget.TextView[contains(@text,'FRI')]/preceding-sibling::android.widget.TextView");
    public static By satData=By.xpath("//android.widget.TextView[contains(@text,'SAT')]/preceding-sibling::android.widget.TextView");
    public static By sunData=By.xpath("//android.widget.TextView[contains(@text,'SUN')]/preceding-sibling::android.widget.TextView");
    public static By navArrow=By.xpath("//android.widget.TextView[contains(@text,'›')]");

    /**flags**/

    public static By totalFlags=By.xpath("//android.widget.TextView[contains(@text,'TOTAL FLAGS')]/preceding-sibling::android.widget.TextView[@index='0']");

    public static By flagPrVisit=By.xpath("//android.widget.TextView[contains(@text,'TOTAL FLAGS')]/preceding-sibling::android.widget.TextView[@index='1']");
    public static By missedflag=By.xpath("//android.widget.TextView[contains(@text,'TOTAL FLAGS')]/preceding-sibling::android.widget.TextView[@index='3']");



}


