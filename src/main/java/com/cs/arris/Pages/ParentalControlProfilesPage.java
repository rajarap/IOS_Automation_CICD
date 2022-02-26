package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ParentalControlProfilesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle']"), 
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[359,149][721,223]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/txtToolBarTitle") })
	public MobileElement parentalControlTitle;
	
	@AndroidFindAll({
		@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),
		@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
		@AndroidBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") })
	public MobileElement cloudIcon;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"), 
			@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	public MobileElement backButton;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"), 
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[980,153][1046,219]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/helpIcon") })
	public MobileElement helpIcon;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_parental_view']"), 
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[102,276][540,378]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/profile_parental_view") })
	public MobileElement profilesTab;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/blocked_parental_view']"), 
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[540,276][978,378]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/blocked_parental_view") })
	public MobileElement currentlyBlockedTab;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/parental_enable_disable']"), 
			@AndroidBy(xpath = "//android.widget.Switch[@bounds='[980,153][1046,219]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/parental_enable_disable") })
	public MobileElement parentalControlToggleIcon;
	
	//Delete User Profiles
	
	@AndroidFindBy(id = "com.arris.sbcBeta:id/delete")
	public MobileElement deleteIcon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Delete']")
	public MobileElement deleteLabel;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Are you sure you want delete this Profile? This action cannot be undone.']")
	public MobileElement deleteConfirmationText;
	
	//Delete User Profiles
	
	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	//click currently blocked devices tab when enable parental control on profiles tab is ON and profiles are blocked.
	public ParentalControlCurrentlyBlockedPage getParentalControlCurrentlyBlockedTabPageObject() {
		ParentalControlCurrentlyBlockedPage parentalControlCurrentlyBlockedTabPage = new ParentalControlCurrentlyBlockedPage();
		return parentalControlCurrentlyBlockedTabPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}
	
	//click on currently blocked tab. Alert dialog should be displayed when enable prarental control toggle button is off.
	public ParentalControlAlertDialog getParentalControlAlertDialogObject() {
		ParentalControlAlertDialog alertDialog = new ParentalControlAlertDialog();
		return alertDialog;
	}

	public ParentalControlProfilesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void clickBackButton() {
		click(backButton);
		utils.log().info("Parental Control Page - Clicked on Back Button");
	}

	public void clickHelpIcon() {
		click(helpIcon);
		utils.log().info("Parental Control Page - Clicked on Help Icon");
	}

	public void verifyUIOnParentalControlPage() {
		try {
			if (parentalControlTitle.isDisplayed())
				utils.log().info("Title - " + parentalControlTitle.getText() + " - is displayed");
		} catch (Exception e) {
			utils.log().info("Parental Control Title Text is not displayed");
		}

		try {
			if (backButton.isDisplayed())
				utils.log().info("Back Button is displayed");
		} catch (Exception e) {
			utils.log().info("Back Button is not displayed");
		}
		
		try {
			if (cloudIcon.isDisplayed())
				utils.log().info("Cloud Icon is displayed");
		} catch (Exception e) {
			utils.log().info("PCloud Icon is not displayed");
		}

		try {
			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
		} catch (Exception e) {
			utils.log().info("Help Icon is not displayed");
		}

		try {
			if (profilesTab.isDisplayed())
				utils.log().info("Profiles Tab is displayed");
		} catch (Exception e) {
			utils.log().info("Profiles Tab is not displayed");
		}

		try {
			if (currentlyBlockedTab.isDisplayed())
				utils.log().info("Currently Blocked Tab is displayed");
		} catch (Exception e) {
			utils.log().info("Currently Blocked Tab is not displayed");
		}
	}

	public void clickProfilesTab() {
		try {
			click(profilesTab);
			utils.log().info("Clicked Profiles Tab on Parental Control Page");
		} catch (Exception e) {
			utils.log().info("Profiles Tab on Parental Control Page is not displayed");
		}
	}

	public void clickCurrentlyBlockedsTab() {
		try {
			click(currentlyBlockedTab);
			utils.log().info("Clicked Currently Blocked Tab on Parental Control Page");
		} catch (Exception e) {
			utils.log().info("Currently Blocked Tab on Parental Control Page is not displayed");
		}
	}

	@Override
	public boolean isAt() {
		if (parentalControlTitle.isDisplayed()) {
			utils.log().info("On Parental Control Page");
			return true;
		} else {
			utils.log().info("Not on Parental Control Page");
			return false;
		}
	}
}
