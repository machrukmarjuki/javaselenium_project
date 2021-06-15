package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class AuditorsTest extends TestConfigurations {

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=14)
	public void Tc_621_anavigatetoAuditors(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to navigate to auditors view");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=14)
	public void Tc_623_addAuditor(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to add an auditor");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=16)
	public void Tc_628_editAuditor(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to edit an auditor");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=17)
	public void Tc_624_blockAuditor(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to block an auditor");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=18)
	public void Tc_625_activateAuditor(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to activate an auditor");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=19)
	public void Tc_627_downloadAuditor(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to download an auditor");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=20)
	public void Tc_626_bulkupload(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to upload an auditor");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

	@Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=15)
	public void Tc_622_verifysearchauditor(SeleniumTestParameters testParameters) {
		testParameters.setCurrentTestDescription("TC to upload an auditor");
		CoreScript coreScript = new CoreScript(testParameters);
		coreScript.driveTestExecution();
		tearDownTestRunner(testParameters, coreScript);
	}

}
