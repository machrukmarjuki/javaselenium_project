package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;

import commonkeywords.CommonKeys;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import pages.AdminAuditorsPage;
import pages.AdminDepartmentPage;
import pages.AdminSitePage;

import supportLibraries.Utility_Functions;

import static supportLibraries.Utility_Functions.*;
import static supportLibraries.Utility_Functions.timeWait;

public class AdminDepartments extends ReusableLib {
	
	CommonKeys ck;
	public AdminDepartments(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
		ck=new CommonKeys(helper);
		
	}

    /***
     * Keyword to add department
     * @author Zahran
     */
	public void addDepartment () throws InterruptedException {
		
		String rn = RandomStringUtils.randomAlphanumeric(4);
        int rnNum = Utility_Functions.xRandomFunction(99);
        int rnNum1 = Utility_Functions.xRandomFunction(999999);
        String email =  properties.getProperty(properties.getProperty("ENV") + "User") ;
        String depName = "AutoDepartment_" + rn + rnNum;
        int depkey=rnNum1;
        String DepartmentDesc ="Created Department for Automation purposes";
        jsonData.putData("DepartmentName", depName);
        Utility_Functions.xUpdateJson("DepartmentName", depName);
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link "); 
        click(AdminDepartmentPage.departmentLnk, "Clicked on Department link");
        click(AdminDepartmentPage.adddepartment, "Clicked on Add Departments button");
        sendKeys(AdminDepartmentPage.departmentname, depName);
        timeWait(2);
        sendKeys(AdminDepartmentPage.departmentdescription, DepartmentDesc);
        timeWait(2);
        sendKeys(AdminDepartmentPage.departmentemail, email);
        timeWait(2);
        sendKeys(AdminDepartmentPage.departmentkey, String.valueOf(rnNum1));
        timeWait(2);
        Utility_Functions.xUpdateJson("UniqueKey", String.valueOf(rnNum1));
        click(AdminDepartmentPage.departmentcheckkey, "Clicked on Key check button ");
        sendKeys(AdminDepartmentPage.departmentname, depName);
        xWaitForElementPresent(driver,AdminDepartmentPage.departmentresetkey, globalWait);
        Utility_Functions.xUpdateJson("DepartmentEmail", email);
        String site=Utility_Functions.xGetJsonAsString("SiteName");
        xSendKeyBoardkeys(driver, AdminDepartmentPage.drpdwn_assign_dept, site, Keys.ENTER);
        String questName=Utility_Functions.xGetJsonAsString("QuestionnaireName");
        xSendKeyBoardkeys(driver, AdminDepartmentPage.drpdwn_assign_ques, questName, Keys.ENTER);
        String auditor=Utility_Functions.xGetJsonAsString("AuditorName");
        xSendKeyBoardkeys(driver, AdminDepartmentPage.drpdwn_assign_users, auditor, Keys.ENTER);
        click(AdminDepartmentPage.savebutton);
        Utility_Functions.xWaitForElementPresent(driver, AdminDepartmentPage.departmentstable, globalWait);
        vrfyElmentExist(AdminDepartmentPage.departmentstable,"Departments table exists ");
    }

    /***
     * Keyword to edit created department
     * @autor Zahran
     */
    public void editDepartment () throws InterruptedException {
        String depName=Utility_Functions.xGetJsonAsString("DepartmentName");
        searchDepartment(depName);
        xWaitForElementPresent(driver,AdminDepartmentPage.depediticon, globalWait);
        click(AdminDepartmentPage.depediticon);
        xWaitForElementPresent(driver,AdminDepartmentPage.departmentname, globalWait);
        sendKeys(AdminDepartmentPage.departmentname,depName+" Updated");
        click(AdminDepartmentPage.savebutton);
        depName=driver.findElement(AdminDepartmentPage.departmentname).getAttribute("value");
        jsonData.putData("DepartmentName",depName);
        Utility_Functions.xUpdateJson("DepartmentName", depName);
        Utility_Functions.xAssertEquals(report,"Success update department",getText(AdminDepartmentPage.toastmessage),"Successful toast message contains confirmation text");
        vrfyElmentExist(AdminDepartmentPage.toastmessage,"Toast message shown");
    }

    /***
     * Keyword to delete created department
     * @author Zahran
     */
    public void deleteDepartment () throws InterruptedException {
        String depName=Utility_Functions.xGetJsonAsString("DepartmentName");
        searchDepartment(depName);
        xWaitForElementPresent(driver,AdminDepartmentPage.depdeleteicon, globalWait);
        click(AdminDepartmentPage.depdeleteicon);
        xWaitForElementPresent(driver,AdminDepartmentPage.depconfirmdelete, globalWait);
        click(AdminDepartmentPage.depconfirmdelete);
        Utility_Functions.xAssertEquals(report,"Successfully Block department",getText(AdminDepartmentPage.toastmessage),"Successful toast message contains confirmation text");
        vrfyElmentExist(AdminDepartmentPage.toastmessage,"Toast message shown");    }

    public void searchDepartment (String depname) throws InterruptedException {
        String depName = Utility_Functions.xGetJsonAsString("DepartmentName");
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        click(AdminDepartmentPage.departmentLnk, "Clicked on Department link");
        sendKeys(AdminDepartmentPage.searchbox, depname);
    }

    /***
     * Keyword to verify searched department
     * @author Zahran
     */
    public void verifySearchDepartment () throws InterruptedException {
        String depName=Utility_Functions.xGetJsonAsString("DepartmentName");
        searchDepartment(depName);
        Utility_Functions.xWaitForElementPresent(driver, AdminDepartmentPage.departmentstable, globalWait);
        vrfyElmentExist(AdminDepartmentPage.departmentstable,"Search row exists .. ");

    }
}
