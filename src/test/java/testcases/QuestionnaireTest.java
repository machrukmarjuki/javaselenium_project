package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class QuestionnaireTest extends TestConfigurations {

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=5)
	public void Tc_643_questionnairesamecategory(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to add questionnaire with same category questions");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=6)
	public void Tc_644_questionnairedifferentcategory(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to add questionnaire with different category questions");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=7)
	public void Tc_642_verifycreatequestionnaire(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to verify create questionnaire");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=9)
	public void Tc_834_editquestionnaire(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to edit questionnaire");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=10)
	public void Tc_646_clonequestionnaire(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to clone department ");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=13)
	public void Tc_645_deletequestionnaire(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to delete department ");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=8)
	public void Tc_641_verifysearchquestionnaire(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to verify search department ");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=11)
	public void Tc_648_uploaddquestionnaire(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to upload department ");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=12)
	public void Tc_647_downloadquestionnaire(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to download department ");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}
}
