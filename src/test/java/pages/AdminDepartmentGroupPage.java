package pages;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.openqa.selenium.By;
import supportLibraries.Utility_Functions;

public class AdminDepartmentGroupPage extends ReusableLib {

    public AdminDepartmentGroupPage(Helper helper) {
        super(helper);
    }

    /* Department Group LOcators */
    public static  By departmentgroupTab=By.xpath("//a[@href='/admin/departmentsgroup']");
    public static  By departmentgrpverify=By.xpath(("//div[starts-with(@class,'DepartmentGroupManager__DepartmentGroupDescription-')]/p"));
    public static  By adddepartmentgroupbutton=By.xpath("//button[contains(.,'Add department group')]");
    public static  By departmentgroupName=By.xpath("//input[contains(@placeholder,'Enter the department group name')]");
    public static  By departmentgroupDesc=By.xpath("//input[contains(@placeholder,'Enter a description for the department group')]");
    public static  By departmentName=By.xpath("//div[contains(@class,'select-editor__input')]/input");
    public static  By savebutton=By.xpath("//button[contains(.,'Save')]");
    public static  By resetbutton=By.xpath("//button[contains(.,'Reset')]");
    public static  By departmentsdiv=By.xpath("//div[starts-with(@class,'DepartmentGroupEditorStyles__AssignContainer')]");
    public static  By depgroup= By.xpath("(//h6[contains(@class,'title')])[1]");
    public static  By deactivatebutton= By.xpath("//button[contains(.,'Deactivate Group')]");
    public static  By confirmdeactivatebutton= By.xpath("//div[contains(@class,'buttonGroup')]/button[2]");
    public static  By reactivatebutton= By.xpath("//button[contains(.,'Reactivate')]");
    public static  By confirmreactivatebutton= By.xpath("//div[contains(@class,'buttonGroup')]/button[2]");
    public static  By inactivetab= By.xpath("//span[contains(.,'Inactive')]");
    public static  By activetab= By.xpath("//span[contains(.,'Active')]");
    public static  By departmentsgroups= By.xpath("//div[starts-with(@class,'DepartmentGroupListStyles__DepartmentListContainer')]");
    public static  By toastmessage= By.xpath("//div[contains(@class,'toast-body')]");

}
