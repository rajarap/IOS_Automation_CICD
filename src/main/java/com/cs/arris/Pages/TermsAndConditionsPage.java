package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TermsAndConditionsPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Terms_Conditions_Screen_Button_IUnderstand&Agree\"]")
	public MobileElement understandAndAgreeButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Terms_Conditions_Screen_TitleLabel_Terms&Conditions\"]")
	public MobileElement termsAndConditionsTitle;

	
	public TermsAndConditionsPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickUnderstandAndAgreeButton() {
		if (understandAndAgreeButton.isDisplayed()) {
			click(understandAndAgreeButton); 
			utils.log().info("Clicked on Understand And Agree Button");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (termsAndConditionsTitle.isDisplayed()) {
			utils.log().info("On Terms And Conditions Page");
			return true;
		} else {
			utils.log().info("Not on Terms And Conditions Page");
			return false;
		}

	}

}
