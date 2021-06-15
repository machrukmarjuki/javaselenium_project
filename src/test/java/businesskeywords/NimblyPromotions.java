package businesskeywords;

import com.gsInfo.core.Helper;
import com.gsInfo.core.ReusableLib;
import com.gsInfo.framework.Status;

import commonkeywords.CommonKeys;
import pages.DashboardPage;
import pages.PromotionPage;
import supportLibraries.Utility_Functions;

public class NimblyPromotions  extends ReusableLib {

	CommonKeys ck;
	public NimblyPromotions(Helper helper) 
	{
		super(helper);
		ck=new CommonKeys(helper);
	}
	/*
	 * FUnction to navigate to Promotion page
	 * @author : Rudranil
	 */
	public void navigateToPromotionpage()
	{
		waitForElementClickable(DashboardPage.lnk_adminpage,35);
		click(DashboardPage.lnk_adminpage,"Clicked on the Admin menu");
		waitForElementClickable(PromotionPage.promoLink,20);
		click(PromotionPage.promoLink,"Clicked on the Promotion menu");
		waitForElementDisappear(PromotionPage.div_loadingContainer,20);
		waitForElementClickable(PromotionPage.newPromoBtn, 35);
		if(isDisplayedinPage(PromotionPage.th_promotion_titleheader))
		{
			report.updateTestLog("Navigate To Promotion Page", "Promotion Page is launched successfully",Status.PASS);

		}else {
			report.updateTestLog("Navigate To Promotion Page", "Promotion Page is not launched successfully",Status.FAIL);
		}


	}

	/* Function to verify fields in New promotion portal
	 * @author : Rudranil
	 */
	public void verifyNewPromotionModal()
	{
		waitForElementClickable(PromotionPage.newPromoBtn, 15);
		click(PromotionPage.newPromoBtn,"Clicked on the New Promotion Button");
		vrfyElmentExist(PromotionPage.inputTitlePromo, "Verifying presence of Promotion Title field");
		vrfyElmentExist(PromotionPage.inputDescPromo, "Verifying presence of Promotion Description field");
		vrfyElmentExist(PromotionPage.btn_addimage, "Verifying presence of Add image button");
		vrfyElmentExist(PromotionPage.radioBtnAllSites, "Verification of presence of All Sites radio button");
		vrfyElmentExist(PromotionPage.radioBtnSpecSite, "Verification of presence of Specific Sites radio button");
		vrfyElmentExist(PromotionPage.radioBtnSpecDept, "Verification of presence of Specific Department radio button");
		vrfyElmentExist(PromotionPage.radioBtnSendNow, "Verification of presence of Send Now radio button");
		vrfyElmentExist(PromotionPage.datePickerSendNow, "Verification of presence of Send Now Date field");
		vrfyElmentExist(PromotionPage.datePickerSendNowTime, "Verification of presence of Send Now Time field");
		vrfyElmentExist(PromotionPage.datePickerSendNowAmPm, "Verification of presence of Send AM/PM  field");
		vrfyElmentExist(PromotionPage.radioBtnSpecDate, "Verification of presence of Specific Date radio button");
		vrfyElmentExist(PromotionPage.datePickerStart, "Verification of presence of Specific Date start date field");
		vrfyElmentExist(PromotionPage.datePickerEnd, "Verification of presence of Specific Date end date field");
		vrfyElmentExist(PromotionPage.inputCostPromo, "Verification of presence of Promotional Cost field");
		vrfyElmentExist(PromotionPage.btnSavePromo, "Verification of presence of Save Promotion button");
		vrfyElmentExist(PromotionPage.btnCancelPromo, "Verification of presence of Cancel Promotion button");
	}
	
	/* Function to create a new promotion will all sites, all department
	 *  and send date as current date 
	 * @author : Rudranil
	 */
	public void createNewPromotionAllSiteAllDept()
	{
		waitForElementClickable(PromotionPage.newPromoBtn, 15);
		click(PromotionPage.newPromoBtn,"Clicked on the New Promotion Button");
		waitForElementPresent(PromotionPage.inputTitlePromo);
		String promoName = "Auto"+Utility_Functions.xGenerateAlphaNumericString();
		String promodecs = Utility_Functions.xGenerateAlphaNumericString();
		sendKeys(PromotionPage.inputTitlePromo, promoName,"Entered The Promotion Title");
		sendKeys(PromotionPage.inputDescPromo, promodecs,"Entered the Promotion Description");
		click(PromotionPage.radioBtnAllSites,"Clicked on All SItes");
		click(PromotionPage.radioBtnSendNow,"Clicked on Send Now radio button");
		sendKeys(PromotionPage.inputCostPromo, jsonData.getData("PromotionCost"));
		click(PromotionPage.btnSavePromo,"clicked on the Save Promotion Button");
		vrfyElmentExist(PromotionPage.alertSaveMsg, "Promotion created successfully");
		waitForElementDisappear(PromotionPage.alertSaveMsg, 45);
		click(PromotionPage.btnCancelPromo,"Clicked on the Cancel Button");
		Utility_Functions.xUpdateJson("PromotionTitle", promoName);
		Utility_Functions.xUpdateJson("PromotionDescription", promodecs);
	}
}
