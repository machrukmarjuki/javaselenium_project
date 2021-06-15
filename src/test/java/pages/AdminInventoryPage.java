package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;
import supportLibraries.Utility_Functions;

public class AdminInventoryPage extends ReusableLib {

    public AdminInventoryPage(Helper helper) {
        super(helper);
    }

    /* Inventory Locators */
    public static  By inventoryLnk= By.xpath("//a[@href='/admin/inventory']");
    public static  By addSKU= By.xpath("//button[contains(@id,'btn_add_sku')]");
    public static  By SKUname= By.xpath("//input[@id='input_sku_name']");
    public static  By SKUnumber= By.xpath("//input[@id='input_sku_no']");
    public static  By SKUdesc= By.xpath("//textarea[@id='input_prod_desc']");
    public static  By SKUtag= By.xpath("(//input[starts-with(@id,'react-select-')])[1]");
    public static  By SKUassignsite= By.xpath("(//input[starts-with(@id,'react-select-')])[2]");
    public static  By SKUtype= By.xpath("(//input[starts-with(@id,'react-select-')])[3]");
    public static  By SKUmeasure= By.xpath("(//input[starts-with(@id,'react-select-')])[4]");
    public static  By SKUcustom= By.xpath("//span[contains(@id,'radiobtn_spec_200')]");
    public static  By submitbutton= By.xpath("//button[contains(@id,'btn_submit_sku')]");
    public static  By searchbox= By.xpath("//input[@id='input_search_sku']");
    public static  By editbutton= By.xpath("//button[@id='btn_edit_sku']");
    public static  By deletebutton= By.xpath("//button[@id='btn_del_sku']");
    public static  By Yesbutton= By.xpath("(//button[@id='btn_yes_delete'])[2]");

}
