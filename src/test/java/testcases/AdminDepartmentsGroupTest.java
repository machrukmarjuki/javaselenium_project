package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class AdminDepartmentsGroupTest extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=1)
    public void Tc_635_navigatedepartmentgroup(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to Navogate to department group");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=1)
    public void Tc_636_adddepartmentgroup(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to add department group");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=1)
    public void Tc_637_resetdepartmentgroup(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to reset department group");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=1)
    public void Tc_638_deactivatedepartmentgroup(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to deactivate department group");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=1)
    public void Tc_1187_reactivatedepartmentgroup(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to reactivate department group");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
}
