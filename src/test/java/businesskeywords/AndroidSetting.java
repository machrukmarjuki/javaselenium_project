package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;

import java.util.Set;

public class AndroidSetting extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public AndroidSetting(Helper helper) {
        super(helper);
    }

    public void swithtoHybridApp() {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1


    }

    public void switchToNative() {
        driver.context("NATIVE_APP");
    }

}
