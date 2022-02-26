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
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NotificationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle]"), // Notification
			@AndroidBy(xpath = "//android.widget.TextView[@bounds='[413,149][668,223]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/txtToolBarTitle") })
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Notification\"]")
	public MobileElement notificationTitleText;

	@AndroidFindAll({ @AndroidBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]"), // Navigate up
			@AndroidBy(xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']") })
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@AndroidFindAll({
			@AndroidBy(xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),
			@AndroidBy(xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
			@AndroidBy(id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") })
	public MobileElement cloudIcon;

	public NotificationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	// click back icon on notification page
	public boolean clickBackButton() {
		if (backIcon.isDisplayed()) {
			click(backIcon);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyUIOnNotificationsPage() {
		try {
			if (notificationTitleText.isDisplayed())
				utils.log().info("Notifications Title - " + notificationTitleText.getText() + " - is displayed");
			else
				utils.log().info("Notifications Title is not displayed");

			if (backIcon.isDisplayed())
				utils.log().info("Back Icon is displayed");
			else
				utils.log().info("Back Icon is not displayed");

//			if (cloudIcon.isDisplayed())
//				utils.log().info("Cloud Icon is displayed");
//			else
//				utils.log().info("Cloud Icon is displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (notificationTitleText.isDisplayed()) {
			utils.log().info("At Notifications Page");
			return true;
		} else {
			utils.log().info("Notifications Page is not displayed");
			return false;
		}
	}
}
