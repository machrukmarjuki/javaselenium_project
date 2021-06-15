package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class AdminDepartmentsTest extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=1)
    public void Tc_631_adddepartment(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to add department ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=2)
    public void Tc_630_verifysearchdepartment(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to verify search department ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=3)
    public void Tc_632_editdepartment(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to edit department ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=4)
    public void Tc_633_deletedepartment(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to delete department ");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

}
