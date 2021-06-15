package testcases;

import com.gsInfo.core.CoreScript;
import com.gsInfo.core.TestConfigurations;
import com.gsInfo.framework.selenium.SeleniumTestParameters;
import org.testng.annotations.Test;

public class AdminDashboardTest extends TestConfigurations {

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=1)
    public void Tc_800_verifyDashboardoverview(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to verify dashboard overview");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }

    @Test(groups = {}, dataProvider = "DesktopBrowsers", dataProviderClass = TestConfigurations.class,priority=1)
    public void Tc_801_verifyoverviewfilterfunctionality(SeleniumTestParameters testParameters) {
        testParameters.setCurrentTestDescription("TC to verify dashboard overview filter functionality");
        CoreScript coreScript = new CoreScript(testParameters);
        coreScript.driveTestExecution();
        tearDownTestRunner(testParameters, coreScript);
    }
}
