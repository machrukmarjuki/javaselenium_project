package pages;

import org.openqa.selenium.By;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;

public class DashboardPage extends ReusableLib{

	public DashboardPage(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}

	public static By txt_sitemapOverview = By.xpath("	//*[text()='Sites Overview Map']");
	public static By lnk_adminpage = By.id("menu_adm");
	
	public static By lnk_Dashboard = By.xpath("//span[text()='Dashboard']");
	public static By lbl_Dashboard_Overview_Map = By.className("sites-overview--map");
	public static By lnk_Dashboard_Issues = By.xpath("//span[text()='Issues']");
	public static By lbl_TotalIssues = By.xpath("//p[text()='Total Issues']");
	
	public static By lst_crclProgressBar = By.xpath("//div[@class='CircularProgressBar-border']");
}
