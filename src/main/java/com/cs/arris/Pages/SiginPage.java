package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SiginPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Back\"]")
	public MobileElement backbutton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Welcome_Screen_TitleLabel_Welcome\"]")
	public MobileElement welcomeMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Welcome_Screen_SubTitleLabel_PleaseEnterYourEmailAddress\"]")
	public MobileElement accessAccountMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Welcome_Screen_Label_EmailID\"]")
	public MobileElement signinEmailAddressLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Welcome_Screen_TextField_EmailID\"]")
	public MobileElement emailAddressTextBox;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Welcome_Screen_Button_SignIn\"]")
	public MobileElement signinButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Welcome_Screen_Label_NotRegisteredYet\"]")
	public MobileElement signinNotRegisteredYetText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Welcome_Screen_Button_SignUp\"]")
	public MobileElement signUpButton;
	
	
	public SiginPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean enterEmailAddress(String email)
	{
		sendKeys(emailAddressTextBox, email);
		utils.log().info("Sigin Page - Entered user email address");
		return true;
	}
	
	public boolean clearEmailAddress()
	{
		clear(emailAddressTextBox);
		return true;
	}
	
	public boolean clickSigninButton()
	{
		if(signinButton.isEnabled())
		{
			click(signinButton);
			utils.log().info("Sigin Page - Clicked on Signin Button");
		}
		return true;
	}
	
	public void clickSignUpButton()
	{
		click(signUpButton);
		utils.log().info("Sigin Page - Clicked on SignUp Button");
	}
	
	@Override
	public boolean isAt() {
		if(signinButton.isDisplayed())
		{
			utils.log().info("At Signin Page");
			return true;
		}
		else
		{
			utils.log().info("Signin Page is not displayed");
			return false;
		}
	}
	
}
