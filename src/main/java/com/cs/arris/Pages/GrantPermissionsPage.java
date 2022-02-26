package com.cs.arris.Pages;

import org.openqa.selenium.support.FindBy;
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

public class GrantPermissionsPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Permission_Screen_TitleLabel_GrantAccess\"]")
	public MobileElement grantAccessPermissionMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Permission_Screen_SubTitleLabel_GrantAccess\"]")
	public MobileElement accessToResourcesMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"This is used during installation for accessing the bluetooth and when selecting a Wi-Fi Network. ARRIS does not collect and share location information with 3rd parties.\"]")
	public MobileElement locationMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"locationIcon\"]")
	public MobileElement locationIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[4]")
	public MobileElement locationText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement storageMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"storageIcon\"]")
	public MobileElement storageIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"This is used to cache data to optimize the performance of the application. \"]")
	public MobileElement storageText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name=\"NavigationBar_Button_Help\"]")
	public MobileElement phoneMessage;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"phoneIcon1\"]")
	public MobileElement phoneIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"This is used to allow dial access to contact customer support when needed.\"]")
	public MobileElement phoneText;

	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/btn_fragment_permission_continue']"),
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[112,1966][968,2042]']")
	})
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Permission_Screen_Button_Continue\"]")
	public MobileElement continueButton;
	

	
	//######################  While Using this app  ##############################

	@AndroidFindBy (id = "com.android.permissioncontroller:id/permission_message")
	public MobileElement whileUsingThisAppPopUpMessage;
	
	@AndroidFindBy (id = "com.android.permissioncontroller:id/permission_allow_button")
	public MobileElement whileUsingThisAppPopUpAllowLink;	//Click allow - Select the below device screen should appear
	
	@AndroidFindBy (id = "com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button")
	public MobileElement whileUsingThisAppPopUpDenyLink;
	
	//######################  While Using this app  ##############################
	
	
	
	
	//######################  Only this time  ##############################
	
	//######################  Only this time  ##############################
	
	public GrantPermissionsPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public boolean VerifyHelpIcon()
	{
		utils.log().info("Grant Access Permissions Page - Is Help icon displayed");
		if (helpIcon.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getGrantAccessPermissionMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Grant Access Permission Message");
		return grantAccessPermissionMessage.getText();
	}
	
	public String getAccessToResourceMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Grant Access To Resource Message");
		return accessToResourcesMessage.getText();
	}
	
	public String getLocationMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Location Message");
		return locationMessage.getText();
	}
	
	public String getLocationText()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Location Text");
		return locationText.getText();
	}
	
	public boolean VerifyLocationIcon()
	{
		utils.log().info("Grant Access Permissions Page - Is Location icon displayed");
		if (locationIcon.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getStorageMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Storage Access Message");
		return storageMessage.getText();
	}
	
	public String getStorageText()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Storage Message");
		return storageText.getText();
	}
	
	public boolean VerifyStorageIcon()
	{
		utils.log().info("Grant Access Permissions Page - is Storge icon displayed");
		if (storageIcon.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getPhoneMessage()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Phone Message");
		return phoneMessage.getText();
	}
	
	public String getPhoneText()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Phone Text");
		return phoneText.getText();
	}
	
	public boolean VerifyPhoneIcon()
	{
		utils.log().info("Grant Access Permissions Page - is Phone icon displayed");
		if (phoneIcon.isDisplayed())
			return true;
		else
			return false;
	}
	
	public String getContinueButtonText()
	{
		utils.log().info("Grant Access Permissions Page - Retrieving Continue Button Text");
		return continueButton.getText();
	}
	
	public void clickContinueButton() 
	{
		click(continueButton);
		utils.log().info("Grant Permissions - Clicked on Continue Button");

	}
	
	@Override
	public boolean isAt() {
		if(continueButton.isDisplayed())
		{
			utils.log().info("At Grant Permissions Page");
			return true;
		}
		else
		{
			utils.log().info("Grant Permissions Page is not displayed");
			return false;
		}
	}
	
}
