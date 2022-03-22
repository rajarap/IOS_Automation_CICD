package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.RandomEmailAddress;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignupPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public String email;
	public String emailID;
	public RandomEmailAddress random;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"BOBAHelp\"]") 
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") 
	public MobileElement welcomeMessage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Create_Your_Account_Screen_SubTitleLabel_LetsGetStartedByCreatingYourAccount\"]") 
	public MobileElement createAccountMessage;
	
	
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]") 
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Create_Your_Account_Screen_TextField_Email\"]")
	public MobileElement emailAddress;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Create_Your_Account_Screen_TextField_FirstName\"]") 
	public MobileElement firstName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Create_Your_Account_Screen_TextField_LastName\"]") 
	public MobileElement lastName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Create_Your_Account_Screen_Button_TermsCheck\"]") 
	public MobileElement agreeCheckBox;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Create_Your_Account_Screen_Button_OptionCheck\"]") 
	public MobileElement recieveUpdateCheckBox;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Create_Your_Account_Screen_Button_SignUp\"]") 
	public MobileElement signupButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Create_Your_Account_Screen_Label_AlreadyRegistered\"]") 
	public MobileElement alreadyRegisteredText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Create_Your_Account_Screen_Button_SignIn\"]") 
	public MobileElement signinButton;
	

	public SignupPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void enterValidEmailAddress(String email)
	{
		this.emailID = email;
		sendKeys(emailAddress, email);
		utils.log().info("SigUp Page - Entered users valid email address");
	}
	
	public void enterFirstName(String fname)
	{
		sendKeys(firstName, fname);
		utils.log().info("SigUp Page - Entered users first name");
	}
	
	public void enterLastName(String lname)
	{
		sendKeys(lastName, lname);
		utils.log().info("SigUp Page - Entered users last name");
	}
	
	public void clickSignupButton()
	{
		click(signupButton);
		utils.log().info("SignUp Page - Clicked on Sign Up Button");
	}
	
	public void clickSignInButton()
	{
		click(signinButton);
		utils.log().info("SignUp Page - Clicked on Signin Button");
	}
	
	public String getEmailAddress() {
		super.generateEmailId();
		return super.mail7EmailId; //userxxxx
	}
	
	public void clickAgreeTermsAndConditionsCheckBox()
	{
		if(agreeCheckBox.isSelected()){
			utils.log().info("SignUp Page - Checkbox is already selected");
		}else {
			click(agreeCheckBox);
			utils.log().info("SignUp Page - Clicked on I Agree to Terms and Conditions check box");
		}
	}
	
	@Override
	public boolean isAt() {
		if(createAccountMessage.isDisplayed())
		{
			utils.log().info("At SignUp Page");
			return true;
		}
		else
		{
			utils.log().info("SignUp Page is not displayed");
			return false;
		}
	}

}
