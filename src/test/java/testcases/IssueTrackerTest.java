package testcases;

import org.testng.annotations.Test;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;

public class IssueTrackerTest extends TestConfigurations {
	
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1010_ToverifynavigationtoIssueTrackerPage(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify navigation to IssueTracker Page");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1012_ToverifyfilterByQuestionnaire(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify whether filter by questionnaire functionality is working as desired");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1013_ToverifyfilterByUser(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify whether filter by user functionality is working as desired");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1014_ToverifyfilterByDepartment(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify whether filter by department functionality is working as desired");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1015_ToverifyfilterBySite(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify whether filter by Site functionality is working as desired");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1016_ToverifyfilterByFlag(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify whether filter by Site functionality is working as desired");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1017_ToverifyfilterByStatus(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify whether filter by Status functionality is working as desired");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1022_ToverifyFilterByQuestionTitleAndCategory(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify filter by question title and category");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1023_ToverifyAddIssueModal(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify that the AddIssue modal contains all the desired fields");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups= {},dataProvider="DesktopBrowsers",dataProviderClass= TestConfigurations.class)
	public void  Tc_1024_ToverifyAddIssueFunctionality(SeleniumTestParameters testParameters)
	{
		testParameters.setCurrentTestDescription("Test case to verify that user is able to create a new issue");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
	}
}
