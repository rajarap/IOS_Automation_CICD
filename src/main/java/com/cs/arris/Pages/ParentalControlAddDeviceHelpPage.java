package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ParentalControlAddDeviceHelpPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement closeButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental Control Devices\"]") 
	public MobileElement helptitle;
	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_EditProfileSave\"]")
//	public MobileElement deviceText;

	public ParentalControlAddDeviceHelpPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseButton() {
		if(closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}

//	public boolean verifyUIOnAddDeviceHelpPage() {
//		try {
//			if (helptitle.isDisplayed())
//				utils.log().info(helptitle.getText() + " title is displayed ");
//			else
//				utils.log().info("Parental Control Profile title is not displayed");
//
//			if (deviceText.isDisplayed())
//				utils.log().info("Parent Control Devices Help text is displayed ");
//			else
//				utils.log().info("Parental Control Devices Help Text is not displayed");
//
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}


	@Override
	public boolean isAt() {
		if (helptitle.isDisplayed()) {
			utils.log().info("On Parental Control Profile Help Page");
			return true;
		} else {
			utils.log().info("Not on Parental Control Profile Help Page");
			return false;
		}
	}
}
