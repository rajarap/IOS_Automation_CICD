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

public class SignupPage  extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public String email;
	public String emailID;
	public RandomEmailAddress random;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/need_help']") 
	public MobileElement helpIcon;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/title_text']") 
	public MobileElement welcomeMessage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_text']") 
	public MobileElement createAccountMessage;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/etRegistrationEmail"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,602][1029,710]']"),
		@AndroidBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etRegistrationEmail']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText") 
	})
	public MobileElement emailAddress;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/etFirstName"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,793][506,901]']"),
		@AndroidBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etFirstName']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText") 
	})
	public MobileElement firstName;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/etLastName"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[540,793][995,901]']"),
		@AndroidBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etLastName']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.EditText") 
	}) 
	public MobileElement lastName;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/tv_terms"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[143,988][637,1034]"),
		@AndroidBy (xpath = "//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/tv_terms']"),
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[3]") 
	}) 
	public MobileElement agreeCheckBox;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/cbupdatesagreement"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,1077][1029,1161]"),
		@AndroidBy (xpath = "//android.widget.CheckBox[@resource-id='com.arris.sbcBeta:id/cbupdatesagreement']"), 
		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.CheckBox[2]")
	}) 
	public MobileElement recieveUpdateCheckBox;
	
	@AndroidFindAll({
		@AndroidBy (id = "com.arris.sbcBeta:id/btnSignUp"),
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnSignUp']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,1255][1029,1392]']")
	})
	public MobileElement signupButton;
	
	@AndroidFindAll({
	@AndroidBy (id = "com.arris.sbcBeta:id/tv_registration_aws_errors"),
	@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_registration_aws_errors]"),
	@AndroidBy (xpath = "//android.widget.TextView[@bounds='[85,1453][995,1649]']"),
	@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[4]")
	})
	public MobileElement userAlreadyExistsText;
	
	@AndroidFindAll({
	@AndroidBy (id = "com.arris.sbcBeta:id/already_having_an_accountTV"),
	@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/already_having_an_accountTV']"),
	@AndroidBy (xpath = "//android.widget.TextView[@bounds='[51,1743][1029,1807]']"),
	@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[5]")
	})
	public MobileElement alreadyRegisteredText;
	
	@AndroidFindAll({
	@AndroidBy (id = "com.arris.sbcBeta:id/already_having_an_account"),
	@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/already_having_an_account']"),
	@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,1923][1029,2042]']"),
	@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button[2]")
	})
	public MobileElement signinButton;
	
	@AndroidFindBy (xpath = "//android.widget.EditText[@resource-id='com.arris.sbcBeta:id/etEmail']") 
	public MobileElement signinEmailAddress;
	
	@AndroidFindBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btnSubmit']") 
	public MobileElement signinSigninButton;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/ic_back_icon']") 
	public MobileElement backButton;
	
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

		if(userAlreadyExistsText.isDisplayed())
		{
			click(signinButton);
			utils.log().info("SignUp Page - Users already exists - Clicked on Signin Button");
			sendKeys(signinEmailAddress, emailID);
			utils.log().info("Signin Page - Users already exists - Entered users valid email address");
			click(signinSigninButton);
			utils.log().info("Signin Page - Users already exists - Clicked on Signin Button");
		}
	}
	
	public void clickSignInButton()
	{
		click(signinButton);
		utils.log().info("SignUp Page - Clicked on Signin Button");
	}
	
	@Override
	public boolean isAt() {
		if(signupButton.isDisplayed())
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
