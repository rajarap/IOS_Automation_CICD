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

public class AddDeviceStepsForActivationPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activation_Step_Screen_TitleLabel_StepsForActivation\"]")
	public MobileElement stepsForActivation;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Activation_Step_Screen_SubTitleLabel_ThereAreJustAFewSteps\"]")
	public MobileElement titleDescriptionText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Activation_Step_Screen_Image_Step1\"]")
	public MobileElement firstSquareBox;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Activation_Step_Screen_Image_Step2\"]")
	public MobileElement secondSquareBox;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Activation_Step_Screen_Button_LetsStart\"]")
	public MobileElement letsStartButton;

	public AddDeviceStepsForActivationPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickStartButton() {
		if (letsStartButton.isDisplayed()) {
			click(letsStartButton);
			utils.log().info("Clicked on Let's Start Button");
			return true;
		} else {
			utils.log().info("Let's Start Button is not displayed");
			return false;
		}
	}

	public boolean verifyStepsForActivationUI() {
		try {
			if (stepsForActivation.isDisplayed())
				utils.log().info(stepsForActivation.getText() + " text is displayed");
			else
				utils.log().info("Steps For Activation Text is not displayed");

			if (titleDescriptionText.isDisplayed())
				utils.log().info(titleDescriptionText.getText() + " text is displayed");
			else
				utils.log().info("Description Text is not displayed");
	
			if (firstSquareBox.isDisplayed())
				utils.log().info("Step1 box is displayed");
			else
				utils.log().info("Step1 box is not displayed");

			if (secondSquareBox.isDisplayed())
				utils.log().info("Step2 box is displayed");
			else
				utils.log().info("Step2 box is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (stepsForActivation.isDisplayed()) {
			utils.log().info("On Add Device - Steps For Activation Page");
			return true;
		} else {
			utils.log().info("Not on Add Device - Steps For Activation Page");
			return false;
		}
	}
}
