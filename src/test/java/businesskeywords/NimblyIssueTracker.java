package businesskeywords;

import static supportLibraries.Utility_Functions.timeWait;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;

import pages.IssueTrackerPage;
import supportLibraries.Utility_Functions;

public class NimblyIssueTracker extends ReusableLib {

	public NimblyIssueTracker(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Function to navigate to Issue Tracker page after Login
	 * @author : Rudra
	 */
	public void navigateToIssueTrackerPage()
	{
		xWaitForElementPresent(driver, IssueTrackerPage.issueTrackerLink, globalWait);
		click(IssueTrackerPage.issueTrackerLink,"Clicked on the Issue Tracker Menu");
		xWaitForElementPresent(driver, IssueTrackerPage.addIssueBtn, globalWait);
		waitforPageReadyState();
	}
	/*
	 * Function to verify AddIssueModal
	 * @author: Rudra
	 */
	public void verifyAddIssueModal()
	{
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		click(IssueTrackerPage.addIssueBtn,"Clicked on the AddIssue Button");
		waitForElementPresent(IssueTrackerPage.label_addIssue);
		vrfyElmentExist(IssueTrackerPage.inputIssueTitle, "Question Title field is present");
		vrfyElmentExist(IssueTrackerPage.drpdwnCateg, "Category Dropdown field is present");
		vrfyElmentExist(IssueTrackerPage.drpdwnReporterDept, "Reporter Department Dropdown field is present");
		vrfyElmentExist(IssueTrackerPage.drpdwnAssignedDept, "Assigned Department Dropdown field is present");
		vrfyElmentExist(IssueTrackerPage.drpdwnSeverityIssue, "Severity Dropdown field is present");
		vrfyElmentExist(IssueTrackerPage.drpdwnDueTime, "Due Date and Time Calendar field is present");
		vrfyElmentExist(IssueTrackerPage.drpdwnSiteIssue, "Site Dropdownr field is present");
		vrfyElmentExist(IssueTrackerPage.inputCommentIssue, "Comment field is present");
		vrfyElmentExist(IssueTrackerPage.linkAddImage, "Add Image field is present");
		vrfyElmentExist(IssueTrackerPage.saveIssueBtn, "Save Button is present");
		vrfyElmentExist(IssueTrackerPage.cancelIssueBtn, "Cancel Button is present");
	}
	/*
	 * Function to Add a new  Issue
	 * @author: Rudra
	 */
	public void addNewIssue()
	{
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		click(IssueTrackerPage.addIssueBtn,"Clicked on the AddIssue Button");
		String questionTitle = "AutoQuest"+Utility_Functions.xGenerateAlphaNumericString();
		sendKeys(IssueTrackerPage.inputIssueTitle,questionTitle,"Entered the QUestion Title");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_TAB,1);
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_DOWN,1);
		//sendKeys(IssueTrackerPage.drpdwnCateg,"Cleanliness & Store Atmosphere","Entered the Category value");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_TAB,1);
		copyPaste(Utility_Functions.xGetMasterJsonData("DepartmentName"),"Entered the AssignedDepartment value");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_TAB,1);
		copyPaste(Utility_Functions.xGetMasterJsonData("DepartmentName"),"Entered the ReportedDepartment value");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_TAB,1);
		copyPaste("Yellow","Entered the severity of issue");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_TAB,1);
		timeWait(1);
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_TAB,5);
		copyPaste(Utility_Functions.xGetMasterJsonData("SiteName"),"Entered the severity of issue");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_TAB,1);
		copyPaste(Utility_Functions.xGetMasterJsonData("UserName"),"Entered the severity of issue");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_TAB,1);
		sendKeys(IssueTrackerPage.inputCommentIssue,"Test Comments","Entered the severity of issue");
		click(IssueTrackerPage.linkAddImage,"Clicked on Add Image");
		String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\DataFile\\issueimage.jpg";
		StringSelection stringSelection = new StringSelection(excelPath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		timeWait(2);
		Utility_Functions.xSendmultipleKeyBoardkeys(KeyEvent.VK_CONTROL,KeyEvent.VK_V);
		timeWait(2);
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		waitForElementPresent(IssueTrackerPage.linkchangeImage);
		click(IssueTrackerPage.saveIssueBtn,"CLicked on the save button");
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		if(isDisplayedinPage(IssueTrackerPage.removeAllBtn))
		{
			click(IssueTrackerPage.removeAllBtn,"Clicked on the removeall button");
			waitForElementPresent(IssueTrackerPage.div_questionnaire);
		}
		sendKeys(IssueTrackerPage.inputSearchIssue,questionTitle,"Entered the question title to search");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		timeWait(2);
		boolean flg = isDisplayedinPage(IssueTrackerPage.issuecard_0);
		while(!flg)
		{
			timeWait(2);
			System.out.println("Waiting.....");
			flg = isDisplayedinPage(IssueTrackerPage.issuecard_0);
		}
		waitForElementPresent(IssueTrackerPage.issuecard_0);
		waitForElementPresent(IssueTrackerPage.issuecard_QuestionTitle);
		xAssertEquals(questionTitle,IssueTrackerPage.issuecard_QuestionTitle,"Verifying Issue creation");
		Utility_Functions.xUpdateJson("IssueQuestion",questionTitle );
	}
	/*
	 * Function to verify filter by Questionnaire and verify result
	 * @author: Rudra
	 */
	public void filterByQuestionnaire()
	{
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		waitForElementClickable(IssueTrackerPage.filter_byquestionnaire,40);
		click(IssueTrackerPage.filter_byquestionnaire,"Clicked on the filter by Questionnaire dropdown");
		boolean flg = true;
		int i=0;
		By questionnaire =null;
		while(flg==true)
		{

			if(i>0)
			{	click(questionnaire,"Clicked on the filter by Questionnaire dropdown");
			timeWait(2);
			Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_DOWN,1);
			Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}else {
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}
			String filterValue=Utility_Functions.findElementByXpath(driver,IssueTrackerPage.ByQuestfilterValue).getText();
			questionnaire = By.xpath("//*[text()='"+filterValue+"']");
			flg=isDisplayedinPage(IssueTrackerPage.noissuefound);
			if(flg==false)
			{
				xAssertEquals(filterValue,IssueTrackerPage.issuecard_Questionnaire,"Search result is proper based on filter");
			}
			i++;
		}
		if(flg==true)
		{
			report.updateTestLog("Filter By Questionnaire", "No issues found using filter condition", Status.PASS);
		}
	}
	/*
	 * Function to check if we user needs to create new issue 
	 * @author: Rudra
	 */
	public void createNewIssueIfrequired()
	{
		String question=Utility_Functions.xGetJsonAsString("IssueQuestion");
		if(question==null)
		{
			addNewIssue();
		}
	}
	/*
	 * Function to check filter by question or category is working fine or not
	 * @author: Rudra
	 */
	public  void filterIssueByQuestionAndCategory()
	{
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		waitForElementPresent(IssueTrackerPage.issuecard_0);
		sendKeys(IssueTrackerPage.inputSearchIssue,Utility_Functions.xGetJsonData("IssueQuestion"),"Entered the question title to search");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		boolean flg = isDisplayedinPage(IssueTrackerPage.issuecard_0);
		while(!flg)
		{
			timeWait(2);
			flg = isDisplayedinPage(IssueTrackerPage.issuecard_0);
		}
		waitForElementPresent(IssueTrackerPage.issuecard_0);
		waitForElementPresent(IssueTrackerPage.issuecard_QuestionTitle);
		xAssertEquals(Utility_Functions.xGetJsonData("IssueQuestion"),IssueTrackerPage.issuecard_QuestionTitle,"Filter result based on question title is correct");
		sendKeys(IssueTrackerPage.inputSearchIssue,"Cleanliness","Entered the question title to search");
		Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
		flg = isDisplayedinPage(IssueTrackerPage.issuecard_0);
		while(!flg)
		{
			timeWait(2);
			flg = isDisplayedinPage(IssueTrackerPage.issuecard_0);
		}
		waitForElementPresent(IssueTrackerPage.issuecard_0);
		waitForElementPresent(IssueTrackerPage.issuecard_QuestionTitle);
		String category = getText(IssueTrackerPage.issecard_category);
		if(category.contains("Cleanliness"))
		{
			report.updateTestLog("Filter By QuestionTiteOrCategory", "The filter is working correctly based on category", Status.PASS);
		}else {
			report.updateTestLog("Filter By QuestionTiteOrCategory", "The filter is not working correctly based on category", Status.FAIL);
		}

	}
	/*
	 * Function to verify filter by User and verify result
	 * @author: Rudra
	 */
	public void filterIssueByUser()
	{
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		waitForElementClickable(IssueTrackerPage.filter_byuser,40);
		click(IssueTrackerPage.filter_byuser,"Clicked on the filter by user dropdown");
		boolean flg = true;
		int i=0;
		By user =null;
		while(flg==true)
		{
			if(i > 0)
			{
				click(user,"Clicked on the filter by user dropdown");
				timeWait(2);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_DOWN,1);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}else {
				//Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_UP,1);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}
			String filterValue=Utility_Functions.findElementByXpath(driver,IssueTrackerPage.ByUserfiltervalue).getText();
			user = By.xpath("//*[text()='"+filterValue+"']");
			flg=isDisplayedinPage(IssueTrackerPage.noissuefound);
			if(flg==false)
			{
				click(IssueTrackerPage.issuecard_0,"clicked on the first issue");
				By xpath = By.xpath("//div[@id='drpdwn_assgn_user']//div[text()='"+filterValue+"']");
				waitForElementPresent(xpath);
				vrfyElmentExist(xpath, "The user filter is displaying proper result");

			}
			i++;

		}
		if(flg==true)
		{
			report.updateTestLog("Filter By User", "No issues found using filter condition", Status.PASS);
		}
	}
	/*
	 * Function to verify filter by department and verify result
	 * @author: Rudra
	 */
	public void filterIssueByDepartment()
	{
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		waitForElementClickable(IssueTrackerPage.filter_byDept,40);
		click(IssueTrackerPage.filter_byDept,"Clicked on the filter by Department dropdown");
		boolean flg = true;
		int i=0;
		By department =null;
		while(flg==true)
		{
			if(i > 0)
			{
				click(department,"Clicked on the filter by department dropdown");
				timeWait(2);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_DOWN,1);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}else {
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}
			String filterValue=Utility_Functions.findElementByXpath(driver,IssueTrackerPage.ByDeptfiltervalue).getText();
			department = By.xpath("//*[text()='"+filterValue+"']");
			flg=isDisplayedinPage(IssueTrackerPage.noissuefound);
			if(flg==false)
			{
				click(IssueTrackerPage.issuecard_0,"clicked on the first issue");
				By reporterdep = By.xpath("//div[@id='drpdwn_reporter_dept']//div[text()='"+ filterValue +"']");
				By  assigneddep = By.xpath("//div[@id='drpdwn_assgn_dept']//div[text()='"+ filterValue +"']");
				if(isDisplayedinPage(reporterdep)||isDisplayedinPage(assigneddep))
				{
					report.updateTestLog("Filter By Department", "Filter result by department is working as desired", Status.PASS);
				}else {
					report.updateTestLog("Filter By Department", "Filter result by department is not working as desired", Status.FAIL);
				}
			}
			i++;
		}
		if(flg==true)
		{
			report.updateTestLog("Filter By User", "No issues found using filter condition", Status.PASS);
		}

	}
	/*
	 * Function to verify filter by site name  and verify result
	 * @author: Rudra
	 */
	public void filterIssueBySite()
	{
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		waitForElementClickable(IssueTrackerPage.filter_bySite,40);
		click(IssueTrackerPage.filter_bySite,"Clicked on the filter by site dropdown");
		boolean flg = true;
		int i=0;
		By site =null;
		while(flg==true)
		{
			if(i > 0)
			{
				click(site,"Clicked on the filter by site dropdown");
				timeWait(2);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_DOWN,1);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}else {

				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}
			String filterValue=Utility_Functions.findElementByXpath(driver,IssueTrackerPage.BySitefiltervalue).getText();
			site = By.xpath("//*[text()='"+filterValue+"']");
			flg=isDisplayedinPage(IssueTrackerPage.noissuefound);
			if(flg==false)
			{
				click(IssueTrackerPage.issuecard_0,"clicked on the first issue");
				waitForElementPresent(IssueTrackerPage.issuecard_site);
				xAssertEquals(filterValue,IssueTrackerPage.issuecard_site,"Filter result based on site value is correct");
			}
			i++;
		}
		if(flg==true)
		{
			report.updateTestLog("Filter By User", "No issues found using filter condition", Status.PASS);
		}

	}
	/*
	 * Function to verify filter by flag value
	 * @author: Rudra
	 */
	public void  filterIssueByFlag()
	{
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		waitForElementClickable(IssueTrackerPage.filter_byFlag,40);
		click(IssueTrackerPage.filter_byFlag,"Clicked on the Filter by Flag ");
		boolean flg = true;
		int i=0;
		By flagValue =null;
		while(flg==true)
		{
			if(i > 0)
			{
				click(flagValue,"Clicked on the filter by site dropdown");
				timeWait(2);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_DOWN,1);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}else {

				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}
			String filterValue=Utility_Functions.findElementByXpath(driver,IssueTrackerPage.ByFlagfiltervalue).getText();
			flagValue = By.xpath("//*[text()='"+filterValue+"']");
			flg=isDisplayedinPage(IssueTrackerPage.noissuefound);
			if(flg==false)
			{
				click(IssueTrackerPage.issuecard_0,"clicked on the first issue");
				By flagval = By.xpath("//*[@id='drpdwn_flag']//div[text()='"+filterValue+" Flag"+"']");
				waitForElementPresent(flagval);
				xAssertEquals(filterValue+" Flag",flagval,"Filter result based on flag value is correct");
			}
			i++;
		}	
		if(flg==true)
		{
			report.updateTestLog("Filter By User", "No issues found using filter condition", Status.PASS);
		}

	}
	/*
	 * Function to verify filter by status value
	 * @author: Rudra
	 */
	public void filterIssueByStatus()
	{
		waitForElementPresent(IssueTrackerPage.div_questionnaire);
		waitForElementClickable(IssueTrackerPage.addIssueBtn, 50);
		waitForElementClickable(IssueTrackerPage.filter_byStatus,40);
		click(IssueTrackerPage.filter_byStatus,"Clicked on the Filter by Status ");
		boolean flg = true;
		int i=0;
		By status =null;
		while(flg==true)
		{
			if(i > 0)
			{
				click(status,"Clicked on the filter by site dropdown");
				timeWait(2);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_DOWN,1);
				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}else {

				Utility_Functions.xSendKeyBoardkeys(KeyEvent.VK_ENTER,1);
			}
			String filterValue=Utility_Functions.findElementByXpath(driver,IssueTrackerPage.ByStatusfiltervalue).getText();
			status= By.xpath("//*[text()='"+filterValue+"']");
			flg=isDisplayedinPage(IssueTrackerPage.noissuefound);
			if(flg==false)
			{
				click(IssueTrackerPage.issuecard_0,"clicked on the first issue");
				By statusdropdownval = By.xpath("//*[@id='drpdwn_status']//div[text()='"+filterValue+"']");
				vrfyElmentExist(statusdropdownval, "The filter value based on status is working as desired");
			}	
			i++;
		}
		if(flg==true)
		{
			report.updateTestLog("Filter By User", "No issues found using filter condition", Status.PASS);
		}
	}
}