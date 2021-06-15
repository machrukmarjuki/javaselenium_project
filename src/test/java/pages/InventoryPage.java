package pages;

import org.openqa.selenium.By;

public class InventoryPage {

    /**
     * SKU
     **/

    public static By tab_Sku = By.id("tab_sku_site");
    public static By inventryLnk = By.xpath("//span[text()='Inventory']");
    public static By addSkuBtnPrnt = By.xpath("//span[text()='Add SKU']");
    public static By addSkuChld = By.xpath("//button[text()='Add SKU']");

    public static By skuPopUp = By.id("add-sku-modal");
    public static By skuName = By.id("input_sku_name");
    public static By skuNO = By.id("input_sku_no");
    public static By prodDesc = By.id("input_prod_desc");

    public static By skutype = By.xpath("//*[@id='drpdwn_sku_type']//input");

    public static By uom = By.xpath("//*[@id='drpdwn_uom']//input");
    public static By sku_site = By.xpath("//*[@id='drpdwn_sku_site']//input");


    public static By addImage = By.id("btn_add_photo_sku");
    public static By customNO = By.id("input_custom_no");
    public static By btnSubmtSku = By.id("btn_submit_sku");

    public static By vrySkuName = By.xpath("//td[text()='sku-name']");
    public static By toastMsg = By.xpath("//div[contains(@class,'Toastify__toast-container Toastify__toast-container--top-right')]//div[@role='alert']");

    /**
     * replace sku-Name with actual Sku name
     */
    public static String skuEdit = "//td[text()='sku-Name']/..//button[text()='Edit']";
    public static String skuDel = "//td[text()='sku-Name']/..//button[text()='Delete']";
    public static String delYesBtn = "//td[text()='sku-Name']/..//button[text()='Yes']";


    public static By skuSrch = By.id("input_search_sku");
}
