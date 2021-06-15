package commonkeywords;

import static supportLibraries.Utility_Functions.timeWait;
import static supportLibraries.Utility_Functions.xSendKeyBoardkeys;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.google.common.collect.Ordering;
import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;

import pages.AdminQuestionnairePage;
import pages.AdminSitePage;
import pages.DepartmentPages;
import supportLibraries.Utility_Functions;

public class CommonKeys extends ReusableLib {

    public CommonKeys(Helper helper) {
        super(helper);
        // TODO Auto-generated constructor stub
    }


    /*
     * Function to  click on Department
     * @author : Rudra
     */
    public void clickDepartment() {
        waitForElementClickable(AdminSitePage.spanDepartment, 55);
        click(AdminSitePage.spanDepartment);
        waitForElementPresent(DepartmentPages.lbl_department);
        if (isDisplayed(DepartmentPages.lbl_department)) {
            report.updateTestLog("Verify that Department page is launched", "Department Page is launched", Status.PASS);
        } else {
            report.updateTestLog("Verify that Department page is launched", "Department Page is not launched", Status.PASS);
        }
    }

    /*
     * Function to  update excel to create site data
     * @author : Rudra
     */
    public void writeToSiteUploadExcel() {
        Fillo fillo = new Fillo();
        //F:\GSInfo\GSNimbly\nimbly-java-selenium-automation\src\test\resources\DataFile\site-template.xlsx
        String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\DataFile\\site-template.xlsx";
        System.out.println("The excel path is:" + excelPath);
        try {
            Connection con = fillo.getConnection(excelPath);
            String query = "Delete From Sites where Name is not  NULL";
            con.executeUpdate(query);
            con.close();
        } catch (FilloException e) {

            e.printStackTrace();
        }
        int sitecount = Integer.parseInt(jsonData.getData("NoOfSites"));
        try {
            Connection con = fillo.getConnection(excelPath);
            for (int i = 1; i <= sitecount; i++) {
                String siteName = "AutoSite_Bulk" + Utility_Functions.xGenerateAlphaNumericString();
                String query = "INSERT INTO Sites(Name,Subtitle,DepartmentKey,Country,Province,City,Address,\"Auditors (emails separated by comma) Optional\",\"Supervisor (email) Optional\") VALUES ('"
                        + siteName + "','" + siteName + "','" + Utility_Functions.xGetMasterJsonData("UniqueKey") + "','"
                        + jsonData.getData("SiteCountry") + "','" + jsonData.getData("SiteProvince") + "','"
                        + jsonData.getData("SiteCity") + "','" + jsonData.getData("BulkSiteAddress") + "','"
                        + Utility_Functions.xGetMasterJsonData("DepartmentEmail") + "','"
                        + Utility_Functions.xGetMasterJsonData("DepartmentEmail") + "')";
                System.out.println(query);
                Utility_Functions.xUpdateJson("BulkSiteName_" + i, siteName);
                con.executeUpdate(query);
            }
            String query = "Select * FROM Sites";
            Recordset recordset = con.executeQuery(query);
            while (recordset.next()) {
                System.out.println(recordset.getField("DepartmentKey"));
            }
            con.close();
        } catch (FilloException e) {
            e.printStackTrace();
        }

    }

    /**
     * Common method to Navigate to Admin Module and then to Manage Link
     */
    public void navToManageLink() {
        click(AdminSitePage.adminBtn);
        click(AdminSitePage.manageLink, "Clicked on Manage link ");
        waitForElementDisappear(AdminSitePage.pageLoad, globalWait);
        Utility_Functions.timeWait(1);
        ngWaitRequestToFinish();
        waitForElementDisappear(AdminSitePage.pageLoad, globalWait);
        Utility_Functions.timeWaitMiliSeconds(300);
        if (!isDisplayed(AdminSitePage.manageLink)||isDisplayed(AdminSitePage.noAccess)) {
            refreshPage();
            ngWaitRequestToFinish();
            waitForElementDisappear(AdminSitePage.pageLoad, globalWait);
            Utility_Functions.timeWait(1);
            click(AdminSitePage.manageLink, "Clicked on Manage link ");
            waitForElementDisappear(AdminSitePage.pageLoad, globalWait);
            Utility_Functions.timeWaitMiliSeconds(300);
        }
    }
    
    /*
	 * Function to  check Sorting if list <String>
	 * @author : Sairab
	 * @param module pass status of PO to open e.g.
     *       asc = to check if data is sorted in ascending order
     *       desc = to check if data is sorted in descending order
	 */
	public void checkSortingByColumn(String sortingType, List<String> lst_text)
	{
		boolean sorted;
		
		if(sortingType.contains("asc")) {
			sorted = Ordering.natural().isOrdered(lst_text);
			if(sorted) {
				report.updateTestLog("Verify data is sorted in acsending order", "Data is sorted in acsending order", Status.PASS);
			}else {
				report.updateTestLog("Verify data is sorted in acsending order", "Data is NOT sorted in acsending order", Status.FAIL);
			}
		}
		
		if(sortingType.contains("desc")) {
			sorted = Ordering.natural().reverse().isOrdered(lst_text);
			if(sorted) {
				report.updateTestLog("Verify data is sorted in descending order", "Data is sorted in descending order", Status.PASS);
			}else {
				report.updateTestLog("Verify data is sorted in descending order", "Data is NOT sorted in descending order", Status.FAIL);
			}
		}		
	}
	
	/*
	 * Function to  check Sorting if list <Integer>
	 * @author : Sairab
	 * @param module pass status of PO to open e.g.
     *       asc = to check if data is sorted in ascending order
     *       desc = to check if data is sorted in descending order
	 */
	public void checkSortingByColumn2(String sortingType, List<Integer> lst_text)
	{
		boolean sorted;
		
		if(sortingType.contains("asc")) {
			sorted = Ordering.natural().isOrdered(lst_text);
			if(sorted) {
				report.updateTestLog("Verify data is sorted in acsending order", "Data is sorted in acsending order", Status.PASS);
			}else {
				report.updateTestLog("Verify data is sorted in acsending order", "Data is NOT sorted in acsending order", Status.FAIL);
			}
		}
		
		if(sortingType.contains("desc")) {
			sorted = Ordering.natural().reverse().isOrdered(lst_text);
			if(sorted) {
				report.updateTestLog("Verify data is sorted in descending order", "Data is sorted in descending order", Status.PASS);
			}else {
				report.updateTestLog("Verify data is sorted in descending order", "Data is NOT sorted in descending order", Status.FAIL);
			}
		}		
	}

}
