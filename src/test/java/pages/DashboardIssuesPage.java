package pages;

import org.openqa.selenium.By;
import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;

public class DashboardIssuesPage extends ReusableLib{

	public DashboardIssuesPage(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}
	
	//Top Filters
	
	public static By ddn_Departments = By.xpath("//div[contains(@class,'AnalyticsControllerStyles__Root')]/div[1]/div[1]/div[1]/div[1]");
	public static By ddn_TimeFrame = By.xpath("//div[contains(@class,'AnalyticsControllerStyles__Root')]/div[2]/div[1]/div[1]/div[1]");
	public static By dtpckr_DateInput1 = By.xpath("//div[contains(@class,'AnalyticsControllerStyles__Root')]//div[@class='DateInput DateInput_1'][1]");
	public static By dtpckr_DateInput2 = By.xpath("//div[contains(@class,'AnalyticsControllerStyles__Root')]//div[@class='DateInput DateInput_1'][2]");
	
	
	//Flag block elements
	
	public static By lbl_FlagHeader = By.xpath("//div[@class='AnalyticsChart-title'][text()='Flag']");
	public static By lbl_Flag_Red = By.xpath("//span[text()='Red']");
	public static By lbl_Flag_Yellow = By.xpath("//span[text()='Yellow']");
	public static By lbl_Flag_RedYellow = By.xpath("//span[text()='Red + Yellow']");
	public static By graph_IssuesChart = By.xpath("//div[@id='chart-issues']");
	
	//Total Issues block elements
	
	public static By lbl_TotalIssues_header = By.xpath("//p[text()='Total Issues']");
	public static By lbl_IssuesReported = By.xpath("//p[text()='Issues Reported']");
	public static By lbl_IssuesReported_Value = By.xpath("//p[text()='Issues Reported']/following-sibling::p");
	public static By lbl_IssuesOverdue = By.xpath("//p[text()='Issues Overdue']");
	public static By lbl_AvgResTime = By.xpath("//p[text()='Average Resolution Time']");
	public static By lbl_AvgResTime_Value = By.xpath("//p[text()='Average Resolution Time']/following-sibling::p");
	
	//Issues Resolution block elements
	
	public static By lbl_IssuesResolutiion_Header = By.xpath("//p[text()='Issues Resolution']");
	public static By lbl_IssuesDue = By.xpath("//p[text()='Issues Due']");
	public static By lbl_IssuesDue_Value = By.xpath("//p[text()='Issues Due']/following-sibling::p");
	public static By lbl_IssuesResolved = By.xpath("//p[text()='Issues Resolved']");
	public static By lbl_IssuesResolved_Value = By.xpath("//p[text()='Issues Resolved']/following-sibling::p");
	public static By lbl_IssuesCompRate = By.xpath("//p[text()='Issues Completion Rate']");
	
	//Top Issues BBy Flag block elements
	
	public static By hdr_TopIssuesByFlag = By.xpath("//h3[contains(text(),'Top Issues by')]");
	public static By lbl_IssueByFlag = By.xpath("//div[text()='Top Issues by Flags']");
	public static By lbl_IssueFromQuestions = By.xpath("//div[text()='Issues from Questions']");
	public static By lbl_IssuesCount = By.xpath("//div[@class='AnalyticsIssuesList-numbers']/span[1]");
	public static By lst_IssuesByFlag_TableRow = By.xpath("//tbody[@class='main']/tr");
	public static By lst_TableHeader_TopIssuesByFlag = By.xpath("//thead[@class='main']//th");
	
	public static By hdr_IssesByQuestion = By.xpath("//h3[text()='Issues from Questions']");
	public static By lst_TableHeader_IssuesByQuestion = By.xpath("//thead[@class=\"main\"]//th");	

}
