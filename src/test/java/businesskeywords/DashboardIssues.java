package businesskeywords;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;
import pages.DashboardIssuesPage;
import pages.DashboardPage;
import supportLibraries.Utility_Functions;
public class DashboardIssues extends ReusableLib{

	
	public DashboardIssues(Helper helper) {
		super(helper);
	}

	/*
	 * Function to  navigate to Dashboard Issues page
	 * @author : Sairab
	 */
	public void navigateToDashboardIssuesPage()
	{
		waitForElementClickable(DashboardPage.lnk_Dashboard,globalWait);
		click(DashboardPage.lnk_Dashboard,"Clicked on Dashboard Link");
		//Utility_Functions.xWaitForElementPresent(driver, DashboardPage.lbl_Dashboard_Overview_Map, 90);
		Utility_Functions.xWaitForElementPresentInPage(driver, DashboardPage.lst_crclProgressBar, 90);
		
		waitForElementClickable(DashboardPage.lnk_Dashboard_Issues, globalWait);
		click(DashboardPage.lnk_Dashboard_Issues,"Clicked on Dashboard-Issues Link");
		Utility_Functions.xWaitForLoad(driver, globalWait);
		if(xWaitForElementVisible(DashboardPage.lbl_TotalIssues, 90)) {
			report.updateTestLog("Verify that Dashboard Issues page is launched", "Dashboard Issues Page is launched", Status.PASS);
		}else {
			report.updateTestLog("Verify that Dashboard Issues page is launched", "Dashboard Issues Page is not launched", Status.FAIL);
		}
	}
	
	/*
	 * Function to  verify presence of top dropdown filters in Dashboard Issues page
	 * @author : Sairab
	 */
	public void verifyPresenceOfDropdownFiltersInDashboardIssuesPage()
	{
		int counter = 0;
		
		if(xWaitForElementVisible(DashboardIssuesPage.ddn_Departments, globalWait)) {			
			counter++;
		}else {
			report.updateTestLog("Verify the dropdown filters", "Departments drodown filter is not present in UI", Status.FAIL);
		}
		
		if(xWaitForElementVisible(DashboardIssuesPage.ddn_TimeFrame, globalWait)) {			
			counter++;
		}else {
			report.updateTestLog("Verify the dropdown filters", "Timeframe drodown filter is not present in UI", Status.FAIL);
		}
		
		if(xWaitForElementVisible(DashboardIssuesPage.dtpckr_DateInput1, globalWait)) {			
			counter++;
		}else {
			report.updateTestLog("Verify the dropdown filters", "Date Input1 drodown filter is not present in UI", Status.FAIL);
		}
		
		if(xWaitForElementVisible(DashboardIssuesPage.dtpckr_DateInput2, globalWait)) {			
			counter++;
		}else {
			report.updateTestLog("Verify the dropdown filters", "Date Input2 drodown filter is not present in UI", Status.FAIL);
		}
		
		if(counter==4) {
			report.updateTestLog("Verify the dropdown filters in Dashboard Issues page", "Dropdown filters are present in UI", Status.PASS);
		}else {
			report.updateTestLog("Verify the dropdown filters in Dashboard Issues page", "Failed to verify Dropdown filters", Status.FAIL);
		}
	}
	
	/*
	 * Function to  verify presence of Flag Analytics block in Dashboard Issues page
	 * @author : Sairab
	 */
	public void verifyPresenceOfFlagAnalyticsInDashboardIssuesPage()
	{
		int counter = 0;
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_FlagHeader, globalWait))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Flag Analytics block", "Flag header is not present in UI", Status.FAIL);
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_Flag_Red, globalWait))
			counter++;
		else
			report.updateTestLog("Verify the elements in Flag Analytics block", "Red Flag label is not present in UI", Status.FAIL);
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_Flag_Yellow, globalWait))
			counter++;
		else
			report.updateTestLog("Verify the elements in Flag Analytics block", "Yellow Flag label is not present in UI", Status.FAIL);
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_Flag_RedYellow, globalWait))
			counter++;
		else
			report.updateTestLog("Verify the elements in Flag Analytics block", "Red+Yellow flag label is not present in UI", Status.FAIL);
		
		if(xWaitForElementVisible(DashboardIssuesPage.graph_IssuesChart, globalWait))
			counter++;
		else
			report.updateTestLog("Verify the elements in Flag Analytics block", "The Issues Graph is not present in UI", Status.FAIL);
		
		if(counter==5)
			report.updateTestLog("Verify the elements in Flag Analytics block", "Successfully verified the Flag Analytics block", Status.PASS);
		else
			report.updateTestLog("Verify the elements in Flag Analytics block", "Failed to verfy labels and values in Flag Analytics block", Status.FAIL);
	}
	
	/*
	 * Function to  verify presence of Total Issues block in Dashboard Issues page
	 * @author : Sairab
	 */
	public void verifyPresenceOfTotalIssuesBlockInDashboardIssuesPage()
	{
		int counter = 0;
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_TotalIssues_header, globalWait))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Total Issues block", "Total Issues header is not present in UI", Status.FAIL);
		
		if((xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesReported, globalWait))&&(xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesReported_Value, globalWait)))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Total Issues block", "Issues reported label and value are not present in UI", Status.FAIL);
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesOverdue, globalWait))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Total Issues block", "Issues Overdue label is not present in UI", Status.FAIL);
		
		if((xWaitForElementVisible(DashboardIssuesPage.lbl_AvgResTime, globalWait))&&(xWaitForElementVisible(DashboardIssuesPage.lbl_AvgResTime_Value, globalWait)))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Total Issues block", "Average resolution Time label and vallue are not present in UI", Status.FAIL);
		
		if(counter==4)		
			report.updateTestLog("Verify the elements in Total Issues block", "Successfully verified labels and values in Total Issues block", Status.PASS);
		else
			report.updateTestLog("Verify the elements in Total Issues block", "Failed to verify labels and values in Total Issues block", Status.FAIL);
	}
	
	/*
	 * Function to  verify presence of Issues Resolution block in Dashboard Issues page
	 * @author : Sairab
	 */
	public void verifyPresenceOfIssuesResolutionBlockInDashboardIssuesPage()
	{
		int counter = 0;
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesResolutiion_Header, globalWait))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Issues Resolution block", "Issues Resolution header is not present in UI", Status.FAIL);
		
		if((xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesDue, globalWait))&&(xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesDue_Value, globalWait)))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Issues Resolution block", "Issues Due label and value are not present in UI", Status.FAIL);
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesCompRate, globalWait))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Issues Resolution block", "Issues Completion Rate label is not present in UI", Status.FAIL);
		
		if((xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesResolved, globalWait))&&(xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesResolved_Value, globalWait)))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Issues Resolution block", "Issues Resolved label and value are not present in UI", Status.FAIL);
		
		if(counter==4)		
			report.updateTestLog("Verify the elements in Issues Resolution block", "Successfully verified labels and values in Issues Resolution block", Status.PASS);
		else
			report.updateTestLog("Verify the elements in Issues Resolution block", "Failed to verify labels and values in Issues Resolution block", Status.FAIL);
	}
	
	/*
	 * Function to  verify presence of Top Issues by Flag block in Dashboard Issues page
	 * @author : Sairab
	 */
	public void verifyPresenceOfTopIssuesByFlagBlockInDashboardIssuesPage()
	{
		int counter = 0;
		xWaitForElementPresent(driver, DashboardIssuesPage.hdr_TopIssuesByFlag, globalWait);
		Utility_Functions.xScrollIntoView(driver, DashboardIssuesPage.hdr_TopIssuesByFlag);
		
		if((Utility_Functions.xWaitForElementPresent(driver, DashboardIssuesPage.hdr_TopIssuesByFlag, 90))&&(Utility_Functions.xWaitForElementPresent(driver, DashboardIssuesPage.lbl_IssueByFlag, 90)))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Top Issues by Flag block", "Top Issues by Flag header is not present in UI", Status.FAIL);
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_IssueFromQuestions, globalWait))	
			counter++;
		else
			report.updateTestLog("Verify the elements in Top Issues by Flag block", "Issues from Questions tab is not present in UI", Status.FAIL);
		
		if(xWaitForElementVisible(DashboardIssuesPage.lbl_IssuesCount, globalWait))		
			counter++;
		else
			report.updateTestLog("Verify the elements in Top Issues by Flag block", "Issues Count label is not present in UI", Status.FAIL);
		
		List<String> headers_text_Expected = new ArrayList<>();
		headers_text_Expected.add("#");
		headers_text_Expected.add("Questionnaire");
		headers_text_Expected.add("Question");
		headers_text_Expected.add("Category");
		headers_text_Expected.add("Flag");
		headers_text_Expected.add("");
		
		List<WebElement> headers = getListElement(DashboardIssuesPage.lst_TableHeader_TopIssuesByFlag);
		List<String> headers_text = new ArrayList<>();
		
		for(int i=0; i<headers.size(); i++){
			
			headers_text.add(headers.get(i).getText());
	    }
		
		if(headers_text.equals(headers_text_Expected))		
			report.updateTestLog("Verify the Header labels in Top Issues by Flag block", "Successfully verified Header labels in Top Issues by Flag block", Status.PASS);
		else
			report.updateTestLog("Verify the Header labels in Top Issues by Flag block", "Failed to verify Header labels in Top Issues by Flag block", Status.FAIL);
		
		String issuesCount = getText(DashboardIssuesPage.lbl_IssuesCount);
		String[] countOfIssues_actual_expected = issuesCount.split(" ");
		
		List<WebElement> tableRows = getListElement(DashboardIssuesPage.lst_IssuesByFlag_TableRow);
		int countOfIssues_actual = tableRows.size();
		
		if(countOfIssues_actual == (Integer.parseInt(countOfIssues_actual_expected[0])))		
			report.updateTestLog("Verify the count of rows in Top Issues by Flag block", "Successfully verified count of rows in Top Issues by Flag block", Status.PASS);
		else
			report.updateTestLog("Verify the count of rows in Top Issues by Flag block", "Failed to verify count of rows in Top Issues by Flag block", Status.FAIL);
		
		if(counter==3)		
			report.updateTestLog("Verify the elements in Top Issues by Flag block", "Successfully verified labels and values in Top Issues by Flag block", Status.PASS);
		else
			report.updateTestLog("Verify the elements in Top Issues by Flag block", "Failed to verify labels and values in Top Issues by Flag block", Status.FAIL);
	}
	
	/*
	 * Function to  to click and verify presence of Top Issues by Question block in Dashboard Issues page
	 * @author : Sairab
	 */
	public void verifyPresenceOfTopIssuesByQuestionBlockInDashboardIssuesPage()
	{
		waitForElementClickable(DashboardIssuesPage.lbl_IssueFromQuestions,globalWait);
		click(DashboardIssuesPage.lbl_IssueFromQuestions,"Clicked on Issues from questions tab");

		if(xWaitForElementVisible(DashboardIssuesPage.hdr_IssesByQuestion, 90)) {
			report.updateTestLog("Verify that Issues from Question tab opens", "Issues from Question tab is displayed", Status.PASS);
		}else
			report.updateTestLog("Verify that Issues from Question tab opens", "Issues from Question tab is NOT displayed", Status.FAIL);

		List<String> headers_text_Expected = new ArrayList<>();
		headers_text_Expected.add("#");
		headers_text_Expected.add("Questionnaire");
		headers_text_Expected.add("Category");
		headers_text_Expected.add("Questions");
		headers_text_Expected.add("Issues Completion Rate");
		headers_text_Expected.add("");
		
		List<WebElement> headers = getListElement(DashboardIssuesPage.lst_TableHeader_IssuesByQuestion);
		List<String> headers_text = new ArrayList<>();
		
		for(int i=0; i<headers.size(); i++){
			
			headers_text.add(headers.get(i).getText());
	    }
		
		if(headers_text.equals(headers_text_Expected))		
			report.updateTestLog("Verify the Header labels in Top Issues by Questions block", "Successfully verified Header labels in Top Issues by Questions block", Status.PASS);
		else
			report.updateTestLog("Verify the Header labels in Top Issues by Questions block", "Failed to verify Header labels in Top Issues by Questions block", Status.FAIL);
		
	}
	
	
	
}
	
