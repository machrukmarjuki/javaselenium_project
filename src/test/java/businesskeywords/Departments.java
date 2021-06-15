package businesskeywords;

import static supportLibraries.Utility_Functions.timeWait;
import static supportLibraries.Utility_Functions.xSendKeyBoardkeys;

import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;

import commonkeywords.CommonKeys;
import pages.AdminDepartmentPage;
import pages.AdminQuestionnairePage;
import pages.AdminSitePage;
import pages.AndroidCheckInPage;
import pages.DashboardPage;
import pages.DepartmentPages;
import supportLibraries.Utility_Functions;

public class Departments extends ReusableLib{

	CommonKeys ck;
	public Departments(Helper helper) {
		super(helper);
		ck = new CommonKeys(helper);
	}

	/*
	 * Function to verify that all functionalities like add department,bulk-upload,department group etc 
	 *  are being displayed in the department page
	 *  @author: Rudra
	 */
	public void verifyDepartmentElements()
	{


		vrfyElmentExist(DepartmentPages.lbl_department,"Department Header is present");
		vrfyElmentExist(DepartmentPages.lbl_departmentgroup,"Department Group Header is present");
		vrfyElmentExist(DepartmentPages.btn_addDepartment,"Add Department Button is present");
		vrfyElmentExist(DepartmentPages.btn_bulkupload,"Bulk Upload Button is present");
		vrfyElmentExist(DepartmentPages.inp_searchdepartment,"Search Department Button is present");
		vrfyElmentExist(DepartmentPages.span_dept_active,"Active Link in Department tab is present");
		vrfyElmentExist(DepartmentPages.span_dept_inactive,"Inactive Link in Department tab is present");
		click(DepartmentPages.lbl_departmentgroup);
		vrfyElmentExist(DepartmentPages.span_deptgrp_inactive,"Inactive Link in Department Group tab is present");
		vrfyElmentExist(DepartmentPages.span_deptgrp_active,"Active Link in Department Group tab is present");
	}
	/*
	 * Function to get the details of the searched department rerutn in form of hashmap
	 * @author: Rudra
	 */
	public HashMap<Integer,List<String>> getActiveDepartments()
	{

		waitForElementPresent(DepartmentPages.lbl_department);
		waitForElementPresent(DepartmentPages.span_dept_active);
		List<WebElement>rows = getListElement(DepartmentPages.tr_activedepartments);
		int rowcnt = rows.size();
		int colCount = (getListElement(DepartmentPages.td_activedepartmentscolumns)).size() -1;
		HashMap<Integer,List<String>> m = new HashMap();
		List<String> val = null;
		if(rowcnt > 0)
		{	
			for (int i = 1 ; i <=rowcnt;i++)
			{
				val = new ArrayList<String>();
				for( int j = 1; j <=colCount;j++)
				{

					val.add(driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText());
				}
				m.put(i, val);
			}
		}
		System.out.println("The values Of HashMap:"+m);
		return m;
	}

	/*
	 * Function to verify error message for Duplicate Unique Key
	 * @author: Rudra
	 */
	public void verifyErrorMessageForDuplicateUniqueKey()
	{
		List<String> department = getActiveDepartments().get(1);
		System.out.println("Unique Key is :-"+department.get(0));
		click(DepartmentPages.btn_addDepartment);
		waitForElementPresent(DepartmentPages.inp_departmentName);
		sendKeys(DepartmentPages.inp_departmentName,jsonData.getData("DepartName"),"Entered the DepartmentName");
		sendKeys(DepartmentPages.inp_description,jsonData.getData("Description"),"Entered the Department description");
		sendKeys(DepartmentPages.inp_email,jsonData.getData("email"),"Entered the Department email");
		sendKeys(DepartmentPages.inp_uniqueKey,department.get(0),"Entered the Department email");
		click(DepartmentPages.btn_save);
		vrfyElmentExist(DepartmentPages.div_deptexistedmsg,"The error message Department existed is being displayed");


	}
	/*
	 * Function to verify error message for Duplicate Department Name
	 * @author: Rudra
	 */
	public void verifyErrorMessageForDuplicateDepartmentName()
	{
		List<String> department = getActiveDepartments().get(1);
		click(DepartmentPages.btn_addDepartment);
		timeWait(5);
		waitForElementPresent(DepartmentPages.inp_departmentName);
		sendKeys(DepartmentPages.inp_departmentName,department.get(1),"Entered the DepartmentName");
		sendKeys(DepartmentPages.inp_description,jsonData.getData("Description"),"Entered the Department description");
		sendKeys(DepartmentPages.inp_email,jsonData.getData("email"),"Entered the Department email");
		sendKeys(DepartmentPages.inp_uniqueKey,Utility_Functions.xGenerateAlphaNumericString(),"Entered the Department email");
		click(DepartmentPages.btn_save);
		vrfyElmentExist(DepartmentPages.div_deptexistedmsg,"The error message Department existed is being displayed");
	}
	/*
	 * Function to search for a created department
	 * @author: Rudra
	 */
	public void searchCreatedDepartment()
	{
		waitForElementClickable(DepartmentPages.btn_addDepartment,25);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 15);
		sendKeys(DepartmentPages.inp_searchdepartment,Utility_Functions.xGetMasterJsonData("DepartmentName"),"Entered the Department to search");
		xSendKeyBoardkeys(driver, DepartmentPages.inp_searchdepartment, Keys.ENTER);
		waitForElementPresent(DepartmentPages.div_loadingContainer);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 15);
		String deptSearch = "//span[text()='" + Utility_Functions.xGetMasterJsonData("DepartmentName") + "']";
		waitForElementPresent(By.xpath(deptSearch));

	}
	/*
	 * Function search and Open Department edit page
	 * @author: Rudra
	 */
	public void editSearchedDepartment()
	{
		waitForElementClickable(DepartmentPages.btn_addDepartment,25);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 15);
		List<String> department = getActiveDepartments().get(2);
		Utility_Functions.xUpdateJson("DuplicateName", department.get(1));
		sendKeys(DepartmentPages.inp_searchdepartment,Utility_Functions.xGetMasterJsonData("DepartmentName"),"Entered the Department to search");
		xSendKeyBoardkeys(driver, DepartmentPages.inp_searchdepartment, Keys.ENTER);
		waitForElementPresent(DepartmentPages.div_loadingContainer);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 15);
		waitForElementClickable(DepartmentPages.img_editdepartmentbutton,15);
		waitForElementPresent(DepartmentPages.img_editdepartmentbutton);
		List<WebElement> departmentseditbuttons = getListElement(DepartmentPages.img_editdepartmentbutton);
		click(departmentseditbuttons.get(0),"Clicked on the edit button  of the respective department");
		timeWait(5);

	}
	/*
	 * Function sto edit department Name of an existing department
	 * @author: Rudra
	 */
	public void verifyErrorMsgForDuplicateNameForExistingDepartmentName()
	{
		waitForElementPresent(DepartmentPages.inp_departmentName);
		sendKeys(DepartmentPages.inp_departmentName,Utility_Functions.xGetJsonAsString("DuplicateName"),"Entered Name");
		click(DepartmentPages.btn_save,"clicked on save button");
		vrfyElmentExist(DepartmentPages.div_deptexistedmsg,"The error message Department existed is being displayed");

	}
	/*
	 * Function search and Open Department And Block
	 * @author: Rudra
	 */
	public void blockSearchedDepartment()
	{
		sendKeys(DepartmentPages.inp_searchdepartment,Utility_Functions.xGetMasterJsonData("DepartmentName"),"Entered the Department to search");
		waitForElementPresent(DepartmentPages.div_loadingContainer);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 15);
		waitForElementPresent(DepartmentPages.img_editdepartmentbutton);
		List<WebElement> departmentseditbuttons = getListElement(DepartmentPages.img_blockdepartmentbutton);
		click(departmentseditbuttons.get(0));
		waitForElementPresent(DepartmentPages.span_blockdepartmentconfirmation);
		vrfyElmentExist(DepartmentPages.span_blockdepartmentconfirmation,"The Block confirmation message is being displayed");
		click(DepartmentPages.btn_blockconfirm);
		vrfyElmentExist(DepartmentPages.msg_blocksuccess,"The Department "+Utility_Functions.xGetMasterJsonData("DepartmentName")+" is blocked successfully");
		timeWait(5);
		driver.navigate().refresh();
		timeWait(10);
		click(DepartmentPages.span_dept_inactive);
		sendKeys(DepartmentPages.inp_searchdepartment,Utility_Functions.xGetMasterJsonData("DepartmentName"),"Entered the Department to search");
		waitForElementPresent(DepartmentPages.div_loadingContainer);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 15);
		String inactivedept = "//tbody/tr/td[2]/span[text()='"+Utility_Functions.xGetMasterJsonData("DepartmentName")+"']";
		vrfyElmentExist(By.xpath(inactivedept),"The department "+Utility_Functions.xGetMasterJsonData("DepartmentName")+" is being displayed in inactive section");
		timeWait(5);

	}
	/*
	 * Function to Activate a Inactive Department
	 * @author: Rudra
	 */
	public void activatedDepartment()
	{
		click(DepartmentPages.btn_activatedepartment);
		waitForElementPresent(DepartmentPages.span_activatedepartmentconfirmation);
		vrfyElmentExist(DepartmentPages.span_activatedepartmentconfirmation,"The Activation confirmation message is displayed");
		click(DepartmentPages.btn_activateconfirm);
		vrfyElmentExist(DepartmentPages.msg_activationsuccess,"The department is activated successfully");
		driver.navigate().refresh();
		timeWait(15);

	}

	/*
	 * Function to verify that department is created with all details as given by user
	 * @author: Rudra
	 */
	public void verifyDepartmentDetails()
	{
		editSearchedDepartment();
		waitForElementPresent(DepartmentPages.inp_departmentName);
		driver.navigate().refresh();
		timeWait(10);
		waitForElementPresent(DepartmentPages.inp_departmentName);
		xAssertEquals(Utility_Functions.xGetMasterJsonData("DepartmentName"),DepartmentPages.inp_departmentName,"The department value are matched","value");
		xAssertEquals(Utility_Functions.xGetMasterJsonData("DepartmentEmail"),DepartmentPages.inp_email,"The department email value matched","value");
		xAssertEquals(Utility_Functions.xGetMasterJsonData("UniqueKey"),DepartmentPages.inp_uniqueKey,"The department uniquekey matched","value");
		String siteName = "//label[text()='Sites']/parent::div//span[text()='"+Utility_Functions.xGetMasterJsonData("SiteName")+"']";
		vrfyElmentExist(By.xpath(siteName),"The site is added successfully");
		String questionnaire = "//label[text()='Questionnaires']/parent::div//span[text()='"+Utility_Functions.xGetMasterJsonData("QuestionnaireTitle")+"']";
		vrfyElmentExist(By.xpath(siteName),"The questionnaire is added successfully");
	}
	/*
	 * Function to Add Department Group
	 * @author: Rudra
	 */
	public void createDepartmentGroup() 
	{
		waitForElementClickable(DepartmentPages.btn_addDepartment,40);
		waitForElementPresent(DepartmentPages.lbl_departmentgroup);
		click(DepartmentPages.lbl_departmentgroup);
		waitForElementClickable(DepartmentPages.btn_addDepartmentGroup,45);
		click(DepartmentPages.btn_addDepartmentGroup);
		waitForElementPresent(DepartmentPages.lbl_newdepartmentGroup);
		String departgroupName = Utility_Functions.xGenerateAlphaNumericString();
		Utility_Functions.xUpdateJson("DepartmentGroupName", departgroupName);
		sendKeys(DepartmentPages.inp_departgroupName,departgroupName,"Entered DepartmentName group");
		String depatdescription =  Utility_Functions.xGenerateAlphaNumericString();
		Utility_Functions.xUpdateJson("DepartmentGroupDesc", depatdescription);
		sendKeys(DepartmentPages.inp_departgroupDesc,depatdescription,"Entered Department description group");
		click(DepartmentPages.div_addDepartments);
		timeWait(3);
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_DOWN,2);
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		timeWait(3);
		String addedDepartment = driver.findElement(DepartmentPages.div_departmentNameGroup).getText();
		Utility_Functions.xUpdateJson("DepartmentNameGroup", addedDepartment);
		click(DepartmentPages.btn_savedepartmentgroup);
		vrfyElmentExist(DepartmentPages.msg_departGroupcreated,"Department Created Successfully");
		waitForElementClickable(DepartmentPages.inp_searchDepartmentGroup,15);
		sendKeys(DepartmentPages.inp_searchDepartmentGroup,departgroupName,"Enter Department to be searched");
		String deptResult = "//h6[contains(text(),'"+departgroupName+"')]";
		vrfyElmentExist(By.xpath(deptResult),"The department got created successfully and can be searched");
		System.out.println("Department Description is :"+Utility_Functions.xGetJsonData("DepartmentGroupDesc"));



	}
	/*
	 * Function to land on the Department Group Page
	 * @author: Rudra
	 */
	public void clickOnDepartmentGroupTab()
	{
		waitForElementClickable(DepartmentPages.btn_addDepartment,40);
		waitForElementPresent(DepartmentPages.lbl_departmentgroup);
		click(DepartmentPages.lbl_departmentgroup);
		waitForElementPresent(DepartmentPages.btn_addDepartmentGroup);
		xWaitForElementPresent(driver,DepartmentPages.div_activeDepartments,50);
		if(isDisplayed(DepartmentPages.btn_addDepartmentGroup))
		{
			report.updateTestLog("Verification", "The Department Group Page is launched", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The Department Group Page is not launched", Status.FAIL);
		}
	}
	/*
	 * Function to verify components of Department Group page
	 * @author: Rudra
	 */
	public void verifyDepartmentGroupPage()
	{

		waitForElementClickable(DepartmentPages.btn_addDepartmentGroup,45);
		vrfyElmentExist(DepartmentPages.btn_addDepartmentGroup,"The Add Department Button is present");
		waitForElementPresent(DepartmentPages.div_collectionOfcreated_group);
		vrfyElmentExist(DepartmentPages.div_collectionOfcreated_group,"The Created Department Group Section is being displayed");
		vrfyElmentExist(DepartmentPages.span_deptgrp_inactive,"Inactive Link in Department Group tab is present");
		vrfyElmentExist(DepartmentPages.span_deptgrp_active,"Active Link in Department Group tab is present");
		String displayedName = getAttribute(DepartmentPages.inp_deptNameplacholder,"value");
		xAssertEquals(displayedName,DepartmentPages.div_activeselectedDepartmentGroup,"Proper Name is displayed in the description");
		if(getAttribute(DepartmentPages.inp_departDescplaceholder,"value")!=null)
		{
			report.updateTestLog("Verification", "The active department description is displayed", Status.PASS);
		}else {
			report.updateTestLog("Verification", "The active department description is not displayed", Status.FAIL);
		}


	}
	/*
	 * Function to search department group
	 * @author: Rudra
	 */
	public void searhDepartmentGroup()
	{
		timeWait(9);
		sendKeys(DepartmentPages.inp_searchDepartmentGroup,Utility_Functions.xGetJsonData("DepartmentGroupName"),"Enter Department Group to be searched");
		xSendKeyBoardkeys(driver, DepartmentPages.inp_searchDepartmentGroup, Keys.ENTER);
		timeWait(4);
		String deptResult = "//h6[contains(text(),'"+Utility_Functions.xGetJsonData("DepartmentGroupName")+"')]";
		waitForElementClickable(By.xpath(deptResult),15);
		vrfyElmentExist(By.xpath(deptResult),"The department got created successfully and can be searched");
		click(By.xpath(deptResult));
		timeWait(3);

	}
	/*
	 * Function to verify that department details are displayed
	 * @author: Rudra
	 */
	public void verifyDepartmentGroupDetails()
	{
		xAssertEquals(Utility_Functions.xGetJsonData("DepartmentGroupName"),DepartmentPages.inp_departgroupName,"The departmentgroup name  value are matched","value");
		xAssertEquals(Utility_Functions.xGetJsonData("DepartmentGroupDesc"),DepartmentPages.inp_departgroupDesc,"The departmentgroup description  value are matched","value");
		xAssertEquals(Utility_Functions.xGetJsonData("DepartmentNameGroup"),DepartmentPages.div_departmentNameGroup,"The departmentgroup description  value are matched");
	}
	/*
	 * Function to click On Reset Button On DepartmentGroup
	 * @author: Rudra
	 */
	public void clickResetButton()
	{
		waitForElementClickable(DepartmentPages.btn_reset,15);
		click(DepartmentPages.btn_reset);

	}
	/*
	 * Function to verify that department group details are cleared
	 * @author: Rudra
	 */
	public void verifyDepartmentDetailsIsCleared()
	{
		if(getAttribute(DepartmentPages.inp_departgroupName,"value").isEmpty())
		{
			report.updateTestLog("Verifcation", "Department Name is cleared", Status.PASS);
		}else {
			report.updateTestLog("Verifcation", "Department Name is not cleared", Status.FAIL);
		}
		if(getAttribute(DepartmentPages.inp_departgroupDesc,"value").isEmpty())
		{
			report.updateTestLog("Verifcation", "DepartmentGroupName is cleared", Status.PASS);
		}else {
			report.updateTestLog("Verifcation", "DepartmentGroupName is not cleared", Status.FAIL);
		}

	}

	/*
	 * Function to create a department and add site and questionnaire
	 * @author: Rudra
	 */
	public void createDepartment ()  {

		String rn = RandomStringUtils.randomAlphanumeric(4);
		int rnNum = Utility_Functions.xRandomFunction(99);
		int rnNum1 = Utility_Functions.xRandomFunction(999999);
		String email =  properties.getProperty(properties.getProperty("ENV") + "User") ;
		String depName = "Master_AutoDepartment_" + rn + rnNum;
		int depkey=rnNum1;
		String DepartmentDesc ="Created Department for Automation purposes";
		jsonData.putData("DepartmentName", depName);
		Utility_Functions.xUpdateMasterJson("DepartmentName", depName);
		waitForElementClickable(AdminSitePage.adminBtn,25);
		click(AdminSitePage.adminBtn);
		/*waitForElementClickable(AdminSitePage.manageLink,25);
		click(AdminSitePage.manageLink, "Clicked on Manage link "); 
		try {
			waitForElementClickable(AdminDepartmentPage.departmentLnk,15);
			click(AdminDepartmentPage.departmentLnk, "Clicked on Department link");
		}catch(Exception e) {
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.manageLink,25);
			click(AdminSitePage.manageLink, "Clicked on Manage link ");
		}*/
		ck.navToManageLink();
		waitForElementClickable(AdminDepartmentPage.departmentLnk,15);
		click(AdminDepartmentPage.departmentLnk, "Clicked on Department link");
		waitForElementPresent(DepartmentPages.div_loadingContainer);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 40);
		waitForElementClickable(AdminDepartmentPage.adddepartment,25);
		click(AdminDepartmentPage.adddepartment, "Clicked on Add Departments button");
		sendKeys(AdminDepartmentPage.departmentname, depName,"Entered Site Name");
		sendKeys(AdminDepartmentPage.departmentdescription, DepartmentDesc,"Entered Department Description");
		sendKeys(AdminDepartmentPage.departmentemail, email,"Entered Department Email");
		Utility_Functions.xUpdateJson("DepartmentEmail", email);
		sendKeys(AdminDepartmentPage.departmentkey, String.valueOf(rnNum1),"Entered Department key");
		Utility_Functions.xUpdateJson("UniqueKey", String.valueOf(rnNum1));
		click(AdminDepartmentPage.departmentcheckkey, "Clicked on Key check button ");
		xWaitForElementPresent(driver,AdminDepartmentPage.departmentresetkey, globalWait);
		click(AdminDepartmentPage.savebutton);
		Utility_Functions.xWaitForElementPresent(driver, AdminDepartmentPage.departmentstable, globalWait);
		vrfyElmentExist(AdminDepartmentPage.departmentstable,"Departments table exists ");
		click(DepartmentPages.anc_logut,"Clicked on the Log out button");
		xWaitForElementPresent(driver,AndroidCheckInPage.email,50);
		//ck.addSiteToDepartment();
		//ck.addQuestionnaireToDepartment();
		//ck.clickDepartment();


	}
	/*
	 * Function to create a department  and update the information in Master Data sheet
	 * @author: Rudra
	 */
	public void createDepartmentMaster ()  {

		String rn = RandomStringUtils.randomAlphanumeric(4);
		int rnNum = Utility_Functions.xRandomFunction(99);
		int rnNum1 = Utility_Functions.xRandomFunction(999999);
		String email =  properties.getProperty(properties.getProperty("ENV") + "User") ;
		String depName = "Master_AutoDepartment_" + rn + rnNum;
		int depkey=rnNum1;
		String DepartmentDesc ="Created Department for Automation purposes";
		jsonData.putData("DepartmentName", depName);
		Utility_Functions.xUpdateJson("DepartmentName", depName);
		Utility_Functions.xUpdateMasterJson("DepartmentName", depName);
		waitForElementClickable(AdminSitePage.adminBtn,25);
		click(AdminSitePage.adminBtn);
		/*waitForElementClickable(AdminSitePage.manageLink,25);
		click(AdminSitePage.manageLink, "Clicked on Manage link "); 
		try {
			waitForElementClickable(AdminDepartmentPage.departmentLnk,15);
			click(AdminDepartmentPage.departmentLnk, "Clicked on Department link");
		}catch(Exception e) {
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.manageLink,25);
			click(AdminSitePage.manageLink, "Clicked on Manage link ");
		}*/
		ck.navToManageLink();
		waitForElementClickable(AdminDepartmentPage.departmentLnk,15);
		click(AdminDepartmentPage.departmentLnk, "Clicked on Department link");
		waitForElementPresent(DepartmentPages.div_loadingContainer);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 40);
		waitForElementClickable(AdminDepartmentPage.adddepartment,25);
		click(AdminDepartmentPage.adddepartment, "Clicked on Add Departments button");
		sendKeys(AdminDepartmentPage.departmentname, depName,"Entered Site Name");
		sendKeys(AdminDepartmentPage.departmentdescription, DepartmentDesc,"Entered Department Description");
		sendKeys(AdminDepartmentPage.departmentemail, email,"Entered Department Email");
		Utility_Functions.xUpdateJson("DepartmentEmail", email);
		Utility_Functions.xUpdateMasterJson("DepartmentEmail", email);
		sendKeys(AdminDepartmentPage.departmentkey, String.valueOf(rnNum1),"Entered Department key");
		Utility_Functions.xUpdateJson("UniqueKey", String.valueOf(rnNum1));
		Utility_Functions.xUpdateMasterJson("UniqueKey", String.valueOf(rnNum1));
		click(AdminDepartmentPage.departmentcheckkey, "Clicked on Key check button ");
		xWaitForElementPresent(driver,AdminDepartmentPage.departmentresetkey, globalWait);
		click(AdminDepartmentPage.savebutton);
		Utility_Functions.xWaitForElementPresent(driver, AdminDepartmentPage.departmentstable, globalWait);
		vrfyElmentExist(AdminDepartmentPage.departmentstable,"Departments table exists ");
		click(DepartmentPages.anc_logut,"Clicked on the Log out button");
		xWaitForElementPresent(driver,AndroidCheckInPage.email,50);
		//ck.addSiteToDepartment();
		//ck.addQuestionnaireToDepartment();
		//ck.clickDepartment();


	}
	/**
	 * Key word to add a new site and associate to a existing department
	 *
	 * @author Rudra
	 */
	public void addSiteToDepartment() {
		String rn = RandomStringUtils.randomAlphanumeric(4);
		int rnNum = Utility_Functions.xRandomFunction(99);
		String sitName = "AutoSite_" + rn + rnNum;
		Utility_Functions.xUpdateJson("SiteName", sitName);
		waitForElementClickable(AdminSitePage.adminBtn,40);
		/*click(AdminSitePage.adminBtn,"cliicked on the admin link");
		waitForElementClickable(AdminSitePage.manageLink,40);
		click(AdminSitePage.manageLink, "Clicked on Manage link ");
		try {
			waitForElementClickable(AdminSitePage.siteLnk,15);
			click(AdminSitePage.siteLnk, "Clicked on Site link ");

		}catch(Exception e){
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.manageLink,55);
			click(AdminSitePage.manageLink,"Clicked on Manage Link");
		}*/
		ck.navToManageLink();
		waitForElementClickable(AdminSitePage.siteLnk,15);
		click(AdminSitePage.siteLnk, "Clicked on Site link ");
		waitForElementClickable(AdminSitePage.addBtn,35);
		click(AdminSitePage.addBtn, "Clicked on Add Sites button ");
		timeWait(10);
		xWaitForElementPresent(driver, AdminSitePage.tab_details_site, globalWait);
		sendKeys(AdminSitePage.input_name_site, sitName, "Entered Site Name");
		sendKeys(AdminSitePage.input_address_site, jsonData.getData("SiteAddress") , "Entered Site Name");
		Utility_Functions.xUpdateJson("SiteAddress", jsonData.getData("SiteAddress"));
		Utility_Functions.xClick(driver, AdminSitePage.select_address_site);
		xSendKeyBoardkeys(driver, AdminSitePage.drpdwn_assign_dept, Utility_Functions.xGetJsonAsString("DepartmentName"), Keys.ENTER);
		xSendKeyBoardkeys(driver, AdminSitePage.selectSiteDpt, Utility_Functions.xGetJsonAsString("DepartmentName"), Keys.ENTER);
		xSendKeyBoardkeys(driver, AdminSitePage.selectSupervisor,driver.findElement(AdminSitePage.span_loggedinuser).getText(), Keys.ENTER);
		click(AdminSitePage.addTolistSupervisor);

		xSendKeyBoardkeys(driver, AdminSitePage.selectSiteAuditor, Utility_Functions.xGetJsonAsString("DepartmentName"), Keys.ENTER);
		xSendKeyBoardkeys(driver, AdminSitePage.selectAuditor, driver.findElement(AdminSitePage.span_loggedinuser).getText(), Keys.ENTER);
		click(AdminSitePage.addTolistAuditor);

		xSendKeyBoardkeys(driver, AdminSitePage.selectTimeZon, "Pacific/Palau", Keys.ENTER);

		click(AdminSitePage.btn_save_site, "Clicked on Site Save Button");
		vrfyElmentExist(AdminSitePage.msg_savedmsg,"Site details added to Department");
		timeWait(2);

	}
	/**
	 * Key word to add a new site and associate to a existing department and update the same in Master data sheet
	 *
	 * @author Rudra
	 */
	public void addSiteToDepartmentMaster() {
		String rn = RandomStringUtils.randomAlphanumeric(4);
		int rnNum = Utility_Functions.xRandomFunction(99);
		String sitName = "AutoSite_" + rn + rnNum;
		Utility_Functions.xUpdateJson("SiteName", sitName);
		Utility_Functions.xUpdateMasterJson("SiteName", sitName);
		waitForElementClickable(AdminSitePage.adminBtn,40);
		/*click(AdminSitePage.adminBtn,"cliicked on the admin link");
		waitForElementClickable(AdminSitePage.manageLink,40);
		click(AdminSitePage.manageLink, "Clicked on Manage link ");
		try {
			waitForElementClickable(AdminSitePage.siteLnk,15);
			click(AdminSitePage.siteLnk, "Clicked on Site link ");

		}catch(Exception e){
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.manageLink,55);
			click(AdminSitePage.manageLink,"Clicked on Manage Link");
		}*/
		ck.navToManageLink();
		waitForElementClickable(AdminSitePage.siteLnk,15);
		click(AdminSitePage.siteLnk, "Clicked on Site link ");
		waitForElementClickable(AdminSitePage.addBtn,35);
		click(AdminSitePage.addBtn, "Clicked on Add Sites button ");
		timeWait(10);
		xWaitForElementPresent(driver, AdminSitePage.tab_details_site, globalWait);
		sendKeys(AdminSitePage.input_name_site, sitName, "Entered Site Name");
		sendKeys(AdminSitePage.input_address_site, jsonData.getData("SiteAddress") , "Entered Site Name");
		Utility_Functions.xUpdateJson("SiteAddress", jsonData.getData("SiteAddress"));
		Utility_Functions.xUpdateMasterJson("SiteAddress", jsonData.getData("SiteAddress"));
		Utility_Functions.xClick(driver, AdminSitePage.select_address_site);
		xSendKeyBoardkeys(driver, AdminSitePage.drpdwn_assign_dept, Utility_Functions.xGetJsonAsString("DepartmentName"), Keys.ENTER);
		xSendKeyBoardkeys(driver, AdminSitePage.selectSiteDpt, Utility_Functions.xGetJsonAsString("DepartmentName"), Keys.ENTER);
		xSendKeyBoardkeys(driver, AdminSitePage.selectSupervisor,driver.findElement(AdminSitePage.span_loggedinuser).getText(), Keys.ENTER);
		click(AdminSitePage.addTolistSupervisor);

		xSendKeyBoardkeys(driver, AdminSitePage.selectSiteAuditor, Utility_Functions.xGetJsonAsString("DepartmentName"), Keys.ENTER);
		xSendKeyBoardkeys(driver, AdminSitePage.selectAuditor, driver.findElement(AdminSitePage.span_loggedinuser).getText(), Keys.ENTER);
		click(AdminSitePage.addTolistAuditor);

		xSendKeyBoardkeys(driver, AdminSitePage.selectTimeZon, "Pacific/Palau", Keys.ENTER);

		click(AdminSitePage.btn_save_site, "Clicked on Site Save Button");
		vrfyElmentExist(AdminSitePage.msg_savedmsg,"Site details added to Department");
		timeWait(2);

	}
	/*
	 * Function to create a Questionnaire for any department
	 * @author: Rudra
	 */
	public 	void addQuestionnaireToDepartment()
	{
		waitForElementClickable(AdminSitePage.adminBtn,40);
		/*click(AdminSitePage.adminBtn,"cliicked on the admin link");
		waitForElementClickable(AdminSitePage.manageLink,40);
		click(AdminSitePage.manageLink, "Clicked on Manage link ");
		try {
			waitForElementClickable(AdminQuestionnairePage.questionnaireLnk,20);
			click(AdminQuestionnairePage.questionnaireLnk);
		}catch(Exception e) {
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.manageLink,55);
			click(AdminSitePage.manageLink,"Clicked on Manage Link");
		}*/
		ck.navToManageLink();
		waitForElementClickable(AdminQuestionnairePage.questionnaireLnk,20);
		click(AdminQuestionnairePage.questionnaireLnk);
		waitForElementClickable(AdminQuestionnairePage.addquestionnaire,40);
		click(AdminQuestionnairePage.addquestionnaire);
		waitForElementClickable(AdminQuestionnairePage.questionnairetitle,40);
		String questiontitle  = "AutoTitle"+Utility_Functions.xGenerateAlphaNumericString();
		Utility_Functions.xUpdateJson("QuestionnaireTitle",questiontitle);
		sendKeys(AdminQuestionnairePage.questionnairetitle,questiontitle,"Questionnaire title Entered");
		xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_dept,Utility_Functions.xGetJsonAsString("DepartmentName"),Keys.ENTER);
		xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_cat,jsonData.getData("QuestionnaireCategory"),Keys.ENTER);
		Utility_Functions.xUpdateJson("QuestionnaireCategory",jsonData.getData("QuestionnaireCategory"));
		sendKeys(AdminQuestionnairePage.questionname,jsonData.getData("QuestionnaireQuestion"),"Question Entered");
		click(AdminQuestionnairePage.btn_applytocategory);
		timeWait(5);
		click(AdminQuestionnairePage.btn_applyconfirmation);
		timeWait(2);
		click(AdminQuestionnairePage.publishbtn);
		vrfyElmentExist(AdminQuestionnairePage.toastmessage,"Questionnaire added to Department "+Utility_Functions.xGetJsonAsString("DepartmentName"));



	}
	/*
	 * Function to create a Questionnaire for any department and update the same in master data sheet
	 * @author: Rudra
	 */
	public 	void addQuestionnaireToDepartmentMaster()
	{
		waitForElementClickable(AdminSitePage.adminBtn,40);
		/*click(AdminSitePage.adminBtn,"cliicked on the admin link");
		waitForElementClickable(AdminSitePage.manageLink,40);
		click(AdminSitePage.manageLink, "Clicked on Manage link ");
		try {
			waitForElementClickable(AdminQuestionnairePage.questionnaireLnk,20);
			click(AdminQuestionnairePage.questionnaireLnk);
		}catch(Exception e) {
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.manageLink,55);
			click(AdminSitePage.manageLink,"Clicked on Manage Link");
		}*/
		ck.navToManageLink();
		waitForElementClickable(AdminQuestionnairePage.questionnaireLnk,20);
		click(AdminQuestionnairePage.questionnaireLnk);
		waitForElementClickable(AdminQuestionnairePage.addquestionnaire,40);
		click(AdminQuestionnairePage.addquestionnaire);
		waitForElementClickable(AdminQuestionnairePage.questionnairetitle,40);
		String questiontitle  = "AutoTitle"+Utility_Functions.xGenerateAlphaNumericString();
		Utility_Functions.xUpdateJson("QuestionnaireTitle",questiontitle);
		Utility_Functions.xUpdateMasterJson("QuestionnaireTitle",questiontitle);
		sendKeys(AdminQuestionnairePage.questionnairetitle,questiontitle,"Questionnaire title Entered");
		xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_dept,Utility_Functions.xGetJsonAsString("DepartmentName"),Keys.ENTER);
		xSendKeyBoardkeys(driver,AdminQuestionnairePage.drpdwn_assign_cat,jsonData.getData("QuestionnaireCategory"),Keys.ENTER);
		Utility_Functions.xUpdateJson("QuestionnaireCategory",jsonData.getData("QuestionnaireCategory"));
		Utility_Functions.xUpdateMasterJson("QuestionnaireCategory",jsonData.getData("QuestionnaireCategory"));
		sendKeys(AdminQuestionnairePage.questionname,jsonData.getData("QuestionnaireQuestion"),"Question Entered");
		click(AdminQuestionnairePage.btn_applytocategory);
		timeWait(5);
		click(AdminQuestionnairePage.btn_applyconfirmation);
		timeWait(2);
		click(AdminQuestionnairePage.publishbtn);
		vrfyElmentExist(AdminQuestionnairePage.toastmessage,"Questionnaire added to Department "+Utility_Functions.xGetJsonAsString("DepartmentName"));



	}
	/*
	 * Function to  navigate to department page
	 * @author : Rudra
	 */
	public void navigateToDepartmentPage()
	{
		waitForElementClickable(DashboardPage.lnk_adminpage,25);
		/*click(DashboardPage.lnk_adminpage,"Clicked on Admin Link");
		waitForElementClickable(AdminSitePage.manageLink,55);
		click(AdminSitePage.manageLink,"Clicked on Manage Link");
		try {
			waitForElementClickable(AdminSitePage.spanDepartment,55);
			click(AdminSitePage.spanDepartment,"Clicked on Department Span");
		}catch(Exception e) {

			System.out.println(e.getMessage());
			driver.navigate().refresh();
			waitForElementClickable(AdminSitePage.manageLink,55);
			click(AdminSitePage.manageLink,"Clicked on Manage Link");
		}*/
		ck.navToManageLink();
		waitForElementClickable(AdminSitePage.spanDepartment,55);
		click(AdminSitePage.spanDepartment,"Clicked on Department Span");
		//waitForElementPresent(DepartmentPages.div_loadingContainer);
		waitForElementDisappear(DepartmentPages.div_loadingContainer, 50);
		waitForElementPresent(DepartmentPages.lbl_department);
		if(isDisplayed(DepartmentPages.lbl_department)) {
			report.updateTestLog("Verify that Department page is launched", "Department Page is launched", Status.PASS);
		}else {
			report.updateTestLog("Verify that Department page is launched", "Department Page is not launched", Status.PASS);
		}
	}
	/*
	 * Function to  verify is department data is present or not if 
	 * not present then create a new department , if present
	 * Then user should be navigated to Department Page
	 * @author : Rudra
	 */
	public void createDepartmentIfNotPresent()
	{
		String deptname = Utility_Functions.xGetMasterJsonData("DepartmentName");
		if(deptname!=null)		
		{	
			navigateToDepartmentPage();
			System.out.println("Department "+deptname+" already present");
		}else {
			createDepartment();
		}
	}
	/*
	 * Function To Update Master Sheet Data
	 * @author : Rudra
	 */
	public void updateMasterSheet()
	{
		String deptname=Utility_Functions.xGetMasterJsonData("DepartmentName");
		String uniquekey = Utility_Functions.xGetMasterJsonData("UniqueKey");
		String sitename =  Utility_Functions.xGetMasterJsonData("SiteName");
		String questionnaireTitle = Utility_Functions.xGetMasterJsonData("QuestionnaireTitle");
		if(deptname==null ||sitename==null||questionnaireTitle==null||uniquekey==null)
		{
			waitForElementClickable(DepartmentPages.btn_addDepartment,25);
			waitForElementDisappear(DepartmentPages.div_loadingContainer, 15);
			sendKeys(DepartmentPages.inp_searchdepartment,"Master_","Search for Master Data");
			xSendKeyBoardkeys(driver, DepartmentPages.inp_searchdepartment, Keys.ENTER);
			waitForElementPresent(DepartmentPages.div_loadingContainer);
			waitForElementDisappear(DepartmentPages.div_loadingContainer, 15);
			List<String> department = getActiveDepartments().get(1);
			Utility_Functions.xUpdateMasterJson("UniqueKey", department.get(0));
			Utility_Functions.xUpdateMasterJson("DepartmentName", department.get(1));
			Utility_Functions.xUpdateMasterJson("DepartmentEmail", department.get(3));
			timeWait(3);
			List<WebElement> departmentseditbuttons = getListElement(DepartmentPages.img_editdepartmentbutton);
			timeWait(2);
			click(departmentseditbuttons.get(0),"Clicked on the edit button  of the respective department");
			waitForElementPresent(DepartmentPages.inp_departmentName);
			driver.navigate().refresh();
			waitForElementPresent(DepartmentPages.inp_departmentName);
			waitForElementPresent(DepartmentPages.span_siteName);
			Utility_Functions.xUpdateMasterJson("SiteName",driver.findElement(DepartmentPages.span_siteName).getText());
			Utility_Functions.xUpdateMasterJson("QuestionnaireTitle",driver.findElement(DepartmentPages.span_questionnaire).getText());
		}
		
	}
	/*
	 * Function to navigate to Department Group Page
	 * @author : Rudra
	 */
	public void navigateToDepartmentGroupTab()
	{
		waitForElementClickable(DepartmentPages.lbl_departmentgroup,40);
		click(DepartmentPages.lbl_departmentgroup,"Clicked on the Department Group Tab");
		xWaitForElementPresent(driver,DepartmentPages.btn_addDepartmentGroup,50);
		xWaitForElementPresent(driver,DepartmentPages.div_activeDepartments,50);

	}
	/*
	 * Function to verify whether any Department Group is present or not
	 * If not present create one
	 * @author : Rudra
	 */
	public void createDepartmentGroupIfnotPresent()
	{
		List<WebElement> activeDept = getListElement(DepartmentPages.div_activeDepartments);
		if(activeDept.size()<=0)
		{
			createDepartmentGroup();
		}else {
			click(activeDept.get(0),"Clicked on the first active DepartmentGroup");
		}
	}
	/*
	 * Function to deactivate active group
	 * @author : Rudra
	 */
	public void deaactivateDepartmentGroup()
	{
		waitForElementClickable(DepartmentPages.span_deactivateDepartmentGrp,40);
		click(DepartmentPages.span_deactivateDepartmentGrp,"clicked on the deactivate department group button");
		waitForElementPresent(DepartmentPages.confmDeptDeactivate);
		waitForElementClickable(DepartmentPages.btn_cnfrmDeptGrpDeactivate,35);
		click(DepartmentPages.btn_cnfrmDeptGrpDeactivate,"Clicked on the Deactivate Department Group confirmation button ");
		vrfyElmentExist(DepartmentPages.msg_deactivateDeptGrp,"Department Group Successfully Deactivated");
	}
	/*
	 * Function to reactivate deactivated group
	 * @author : Rudra
	 */
	public void reactivateDepartmentGrp()
	{
		waitForElementClickable(DepartmentPages.btn_reactivate,55);
		click(DepartmentPages.btn_reactivate,"Clicked on Reactivate button");
		waitForElementClickable(DepartmentPages.btn_cnfrm_reactivation,55);
		click(DepartmentPages.btn_cnfrm_reactivation,"Clicked on Reactivate confirmation button");
		vrfyElmentExist(DepartmentPages.msg_deactivateDeptGrp,"Department Group Successfully Reactivated");
	}
}

