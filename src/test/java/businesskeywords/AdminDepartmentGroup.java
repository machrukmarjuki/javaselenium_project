package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.*;
import supportLibraries.Utility_Functions;

import java.util.Random;

import static supportLibraries.Utility_Functions.*;

public class AdminDepartmentGroup extends ReusableLib {

    /***
     *  Constructor to initialize the {@link Helper} object and in turn the and wrap the objects with it
     * @param helper
     */
    public AdminDepartmentGroup(Helper helper) {
        super(helper);
    }

    /***
     * Keyword to navigate to Department group tab
     * @author Zahran
     */
    public void navigatetoDepartmentGroup() throws InterruptedException {
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminDepartmentPage.departmentLnk, "Clicked Departments page");
        click(AdminDepartmentGroupPage.departmentgroupTab, "Clicked on Department Group tab");
        vrfyElmentExist(AdminDepartmentGroupPage.departmentgrpverify, "Navigated to department group");
        Utility_Functions.xAssertEquals(report, "Group Your departments to display the analytics in one go.", getText(AdminDepartmentGroupPage.departmentgrpverify), "Successful department group tab contains confirmation text");
    }

    /***
     * Keyword to add Department group tab
     * @author Zahran
     */
    public void addDepartmentGroup() throws InterruptedException {
        String rn = RandomStringUtils.randomAlphanumeric(4);
        String depgroupName = "AutoDepartmentGroup_" + rn;
        jsonData.putData("DepartmentGroupName", depgroupName);
        Utility_Functions.xUpdateJson("DepartmentGroupName", depgroupName);
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminDepartmentPage.departmentLnk, "Clicked Departments page");
        click(AdminDepartmentGroupPage.departmentgroupTab, "Clicked on Department Group tab");
        click(AdminDepartmentGroupPage.adddepartmentgroupbutton);
        sendKeys(AdminDepartmentGroupPage.departmentgroupName, depgroupName);
        sendKeys(AdminDepartmentGroupPage.departmentgroupDesc, "Desc for created Department Group");
        String depname = Utility_Functions.xGetJsonAsString("DepartmentName");
        xSendKeyBoardkeys(driver, AdminDepartmentGroupPage.departmentName, depname, Keys.ENTER);
        click(AdminDepartmentGroupPage.savebutton);
        vrfyElmentExist(AdminDepartmentGroupPage.toastmessage, "Toast message exists");
        Utility_Functions.xAssertEquals(report, "Success create a new department group", getText(AdminDepartmentGroupPage.toastmessage), "Successful department group toast message contains confirmation text");
    }

    /***
     * Keyword to reset Department group tab
     * @author Zahran
     */
    public void resetDepartmentGroup() throws InterruptedException {

        String rn = RandomStringUtils.randomAlphanumeric(4);
        String depgroupName = "AutoDepartmentGroup_" + rn;
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminDepartmentPage.departmentLnk, "Clicked Departments page");
        click(AdminDepartmentGroupPage.departmentgroupTab, "Clicked on Department Group tab");
        click(AdminDepartmentGroupPage.adddepartmentgroupbutton);
        sendKeys(AdminDepartmentGroupPage.departmentgroupName, depgroupName);
        sendKeys(AdminDepartmentGroupPage.departmentgroupDesc, "Desc for created Department Group");
        String depname = Utility_Functions.xGetJsonAsString("DepartmentName");
        xSendKeyBoardkeys(driver, AdminDepartmentGroupPage.departmentName, depname, Keys.ENTER);
        click(AdminDepartmentGroupPage.resetbutton);
        Utility_Functions.xAssertEquals(report, "", getAttribute(AdminDepartmentGroupPage.departmentgroupName, "value"), "Name field has no data");
        Utility_Functions.xAssertEquals(report, "", getAttribute(AdminDepartmentGroupPage.departmentgroupDesc, "value"), "Desc field has no data");
        Utility_Functions.xAssertEquals(report, "", getText(AdminDepartmentGroupPage.departmentsdiv), "No departments existent");
    }

    /***
     * Keyword to deactivate Department group tab
     * @author Zahran
     */
    public void deactivateDepartmentGroup() throws InterruptedException {

        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminDepartmentPage.departmentLnk, "Clicked Departments page");
        click(AdminDepartmentGroupPage.departmentgroupTab, "Clicked on Department Group tab");
        click(AdminDepartmentGroupPage.depgroup);
        String groupname=getAttribute(AdminDepartmentGroupPage.departmentgroupName,"value");
        click(AdminDepartmentGroupPage.deactivatebutton);
        click(AdminDepartmentGroupPage.confirmdeactivatebutton);
        vrfyElmentExist(AdminDepartmentGroupPage.toastmessage, "Toast message exists");
        Utility_Functions.xAssertEquals(report, "Success deactivated department group", getText(AdminDepartmentGroupPage.toastmessage), "Successful department group toast message contains confirmation text");
        click(AdminDepartmentGroupPage.inactivetab);
        Assert.assertTrue(getText(AdminDepartmentGroupPage.departmentsgroups).contains(groupname));
    }

    /***
     * Keyword to reactivate Department group tab
     * @author Zahran
     */
    public void reactivateDepartmentGroup() throws InterruptedException {

        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminDepartmentPage.departmentLnk, "Clicked Departments page");
        click(AdminDepartmentGroupPage.departmentgroupTab, "Clicked on Department Group tab");
        Utility_Functions.xWaitForElementPresent(driver,AdminDepartmentGroupPage.deactivatebutton,40);
        click(AdminDepartmentGroupPage.inactivetab);
        click(AdminDepartmentGroupPage.depgroup);
        String groupname=getAttribute(AdminDepartmentGroupPage.departmentgroupName,"value");
        click(AdminDepartmentGroupPage.reactivatebutton);
        click(AdminDepartmentGroupPage.confirmreactivatebutton);
        vrfyElmentExist(AdminDepartmentGroupPage.toastmessage, "Toast message exists");
        Utility_Functions.xAssertEquals(report, "Success reactivated department group", getText(AdminDepartmentGroupPage.toastmessage), "Successful department group toast message contains confirmation text");
        click(AdminDepartmentGroupPage.activetab);
        Assert.assertTrue(getText(AdminDepartmentGroupPage.departmentsgroups).contains(groupname));
    }
}
