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

public class ParentalControlAddProfileDialog extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_AddProfileTitle\"]")  //PROFILE NAME
	public MobileElement profileName; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_Close\"]")  
	public MobileElement closeIcon; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_AddProfileSubTitle\"]")  //Please provide a name for the profile.
	public MobileElement profileMessage1; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_ProfileNameTitle\"]")  //Profile Name
	public MobileElement profileTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Parental_Control_Screen_TextField_NewProfile\"]")  //text box to enter profile name
	public MobileElement enterProfileName; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_CreateProfile\"]")  //create profile button
	public MobileElement createProfileButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_ProfileExist\"]")
	public MobileElement profileNameExists;
	
		
	public ParentalControlAddProfileDialog()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean verifyUIOnProfilesPage() {
		try {
			if (profileName.isDisplayed())
				utils.log().info(profileName.getText() + " text is displayed");
			else
				utils.log().info(profileName.getText() + " text is not displayed");

			if (profileMessage1.isDisplayed())
				utils.log().info(profileMessage1.getText() + " text is displayed");
			else
				utils.log().info(profileMessage1.getText() + " text is not displayed");

			if (profileTitle.isDisplayed())
				utils.log().info(profileTitle.getText() + " text is displayed");
			else
				utils.log().info(profileTitle.getText() + " text is not displayed");

			if (enterProfileName.isDisplayed())
				utils.log().info(enterProfileName.getText() + " text is displayed");
			else
				utils.log().info(enterProfileName.getText() + " text is not displayed");

			if (closeIcon.isDisplayed())
				utils.log().info("Close Icon is displayed");
			else
				utils.log().info("Close Icon is not displayed");

			if (createProfileButton.isDisplayed())
				utils.log().info("Create Profile Button is displayed");
			else
				utils.log().info("Create Profile Button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean enterProfileName() {
		if (enterProfileName.isDisplayed()) {
			super.generateProfileName();
			super.sendKeys(enterProfileName, super.profileName);
			utils.log().info("Entered new Profle Name");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickCloseIcon() {
		if (closeIcon.isDisplayed()) {
			click(closeIcon);
			utils.log().info("Clicked on Close Icon");
			return true;
		} else {
			return false;
		}
	}
	
	public boolean clickCreateProfileButton() {
		////XCUIElementTypeButton[@name="Done"]
		super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Done\"`]")).click();
		if (createProfileButton.isDisplayed()) {
			click(createProfileButton);
			utils.log().info("Clicked on Create Profile Button Icon");
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if(profileName.isDisplayed())
		{
			utils.log().info("On Create Profile Name Dialog");
			return true;}
		else {
			utils.log().info("Not on Create Profile Name Dialog");
		return false;}
	}
}
