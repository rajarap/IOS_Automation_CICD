package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ParentalControlEditUserProfileNameDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_EditProfileTitleLabel\"]") 
	public MobileElement editProfileNameTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_EditProfileSubTitle\"]") 
	public MobileElement editProfileNameMessage; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Profiles_Screen_Label_ProfileNameTitle\"]") 
	public MobileElement editProfileNameLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Parental_Control_Profiles_Screen_TextField_EditProfile\"]") 
	public MobileElement enterProfileName;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_EditProfileSave\"]") 
	public MobileElement saveButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Profiles_Screen_Button_EditProfileClose\"]") 
	public MobileElement closeButton; 
	
	
	public ParentalControlEditUserProfileNameDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean verifyUIOnEditUserProfileDialog() {
		try {
			if (editProfileNameTitle.isDisplayed())
				utils.log().info("Title - " + editProfileNameTitle.getText() + " - is displayed");
			else
				utils.log().info("Edit Profile Name Title is not displayed");

			if (editProfileNameMessage.isDisplayed())
				utils.log().info(editProfileNameMessage.getText() + " text is displayed");
			else
				utils.log().info("Please provide a name for the profile text is not displayed");

			if (editProfileNameLabel.isDisplayed())
				utils.log().info(editProfileNameLabel.getText() + " label is displayed");
			else
				utils.log().info("Profile Name Label is not displayed");

			if (enterProfileName.isDisplayed())
				utils.log().info("Profile Name: " + enterProfileName.getText() + " is displayed");
			else
				utils.log().info("Enter User Profile Name text is not displayed");

			if (saveButton.isDisplayed())
				utils.log().info(saveButton.getText() + " button is displayed");
			else
				utils.log().info("Save Changes button is not displayed");

			if (closeButton.isDisplayed())
				utils.log().info("Close Icon is displayed");
			else
				utils.log().info("Close Icon is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean clickSaveButton() {
		super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Done\"`]")).click();
		if (saveButton.isDisplayed()) {
			click(saveButton);
			utils.log().info("Clicked on Save Changes Button");
			return true;
		} else {
			utils.log().info("Save Changes button is not displayed");
			return false;
		}
	}
	
	public boolean clickCloseIcon() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean enterUserProfileName() {
		if (enterProfileName.isDisplayed()) {
			super.generateProfileName();
			clear(enterProfileName);
			super.sendKeys(enterProfileName, super.profileName);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if (editProfileNameTitle.isDisplayed()) {
			utils.log().info("On Edit User Profile Dialog");
			return true;
		} else {
			utils.log().info("Not on Edit User Profile Dialog");
			return false;
		}
	}
}
