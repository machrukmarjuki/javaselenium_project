package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;
import pages.AndroidCheckInPage;
import pages.AndroidProfilePage;


public class AndroidProfile extends ReusableLib {
    /**
     * Constructor to initialize the {@link Helper} object and in turn the
     * objects wrapped by it
     *
     * @param helper The {@link Helper} object
     */
    public AndroidProfile(Helper helper) {
        super(helper);
    }

    /**
     * Method to Validate data in Profile tab
     * @Gopesh
     *
     */
    public void validateProfileData(){
        click(AndroidCheckInPage.appProfile);
        waitForVisible(AndroidProfilePage.totlRpt);
        String totalrepots= getText(AndroidProfilePage.totlRpt);
        report.updateTestLog("verify","Total Report for Current Week:- "+ totalrepots, Status.PASS);
        String scheduled=getText(AndroidProfilePage.schudled);
        report.updateTestLog("verify","Total scheduled for Current Week:- "+ scheduled, Status.PASS);
        String onTime=getText(AndroidProfilePage.ontime);
        report.updateTestLog("verify","Total onTime for Current Week:- "+ onTime, Status.PASS);
        String madeUP=getText(AndroidProfilePage.madeUp);
        report.updateTestLog("verify","Total madeUP for Current Week:- "+ madeUP, Status.PASS);
        String mondata=getText(AndroidProfilePage.monData);
        report.updateTestLog("verify","Total Report for Current Week's MON:- "+ mondata, Status.PASS);
        String tuedata=getText(AndroidProfilePage.tueData);
        report.updateTestLog("verify","Total Report for Current Week's TUE:-  "+ tuedata, Status.PASS);
        String wedData=getText(AndroidProfilePage.wedData);
        report.updateTestLog("verify","Total Report for Current Week:- "+ wedData, Status.PASS);
        String thuData=getText(AndroidProfilePage.thuData);
        report.updateTestLog("verify","Total Report for Current Week's WED:- "+ thuData, Status.PASS);
        String friData=getText(AndroidProfilePage.friData);
        report.updateTestLog("verify","Total Report for Current Week's FRI:- "+ friData, Status.PASS);
        String satData=getText(AndroidProfilePage.satData);
        report.updateTestLog("verify","Total Report for Current Week's SAT:- "+ satData, Status.PASS);
        String sunData=getText(AndroidProfilePage.sunData);
        report.updateTestLog("verify","Total Report for Current Week's SUN:- "+ sunData, Status.PASS);
        click(AndroidProfilePage.navArrow,"Click on navigation arrow");
        waitForVisible(AndroidProfilePage.totalFlags);
        String totalFlags=getText(AndroidProfilePage.totalFlags);
        report.updateTestLog("verify","Total Flags for Current Week:- ", totalFlags, Status.PASS);
        String flgVist=getText(AndroidProfilePage.flagPrVisit);
        report.updateTestLog("verify","Total Flag per visit for Current Week:- "+ flgVist, Status.PASS);
        String missedFlag=getText(AndroidProfilePage.missedflag);
        report.updateTestLog("verify","Total missed flag for Current Week:- "+ missedFlag, Status.PASS);

    }
}
