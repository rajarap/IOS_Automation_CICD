package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

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

public class ParentalControlCurrentlyBlockedPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement parentalControlTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Profiles\"]")
	public MobileElement profilesTab; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Currently Blocked\"]")
	public MobileElement currentlyBlockedTab; 

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Blocked\"]")  //There are currently no Blocked Profiles
	public MobileElement currentlyBlockederrorMessage1; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_BlockedNote\"]")  //Please note the profile will only appear here if the time block applied on the particular profile is active.
	public MobileElement currentlyBlockederrorMessage2; 
	
		
	public ParentalControlCurrentlyBlockedPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickProfilesTab() {
		if (profilesTab.isDisplayed()) {
			click(profilesTab);
			utils.log().info("Clicked on Profiles Button");
			return true;
		} else {
			utils.log().info("Profiles Tab is not displayed");
			return false;
		}
	}

	
	
	public boolean verifyInternetPausedUserProfiles() {
		try {
			utils.log().info("*********************************************************************");
			utils.log().info("Details of User Profiles For Whom Internet is Currently Paused/Blocked");
			utils.log().info("*********************************************************************");

			for (int i = 1; i < 3; i++) 
			{
				utils.log().info("Blocked User Profile : " + i);
				utils.log().info("--------------------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");
				
				for (MobileElement e : entity) {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Screen_Image_BlockedProfile["+i+"]\"]").isDisplayed()) {
							utils.log().info("Profile Image is displayed");
					} else {
						utils.log().info("Profile Image is not displayed ");}

					if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_BlockedProfile["+i+"]\"]").isDisplayed()) {
						utils.log().info("Profile user Name is : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_BlockedProfile["+i+"]\"]").getText());
					} else {
						utils.log().info("User Profile Name is not displayed ");}
	
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_BlockedConnectedDevice["+i+"]\"]").isDisplayed()) {
							utils.log().info("Number of Devices Paused for Internet Connection is : " + (super.getDriver().findElementByXPath(
								"//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_BlockedConnectedDevice["+i+"]\"]").getText()));
					} else {
						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");	}
	
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_BlockedPause["+i+"]\"]").isDisplayed()) {
							utils.log().info("Internet Paused Label is displayed : " + (super.getDriver().findElementByXPath(
									"//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_BlockedPause["+i+"]\"]").getText()));
					} else {
						utils.log().info("Internet Paused Label is not displayed ");}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
					}
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("No User Profile list in Parental Control Profiles Page ");
			return false;
		}
	}

	public boolean verifyNoBlockedProfileMessages() {
		try {
			if (currentlyBlockederrorMessage1.isDisplayed())
				utils.log().info(currentlyBlockederrorMessage1.getText() + " message is displayed");
			else
				utils.log().info("There are currently no Blocked Profiles message is not displayed");

			if (currentlyBlockederrorMessage2.isDisplayed())
				utils.log().info(currentlyBlockederrorMessage2.getText() + " message is displayed");
			else
				utils.log().info(
						"Please note the profile will only appear here if the time block applied on the particular profile is active message is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if(currentlyBlockedTab.isDisplayed())
		{
			utils.log().info("On Parental Control - Currently Blocked Page");
			return true;}
		else {
			utils.log().info("Not on Parental Control - Currently Blocked Page");
		return false;}
	}
}
