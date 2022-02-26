package com.cs.arris.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.SwipeOnElement;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ParentalControlWithProfilesPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public SwipeActions swipe = new SwipeActions();
	public MobileElement me;
	public int counter = 1;
	public int elementX;
	public int elementY;
	int size;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement parentalControlTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement cloudIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Profiles\"]")
	public MobileElement profilesTab;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Currently Blocked\"]")
	public MobileElement currentlyBlockedTab;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Enable\"]") // Enable Parental Control Text
	public MobileElement enableParentalControlText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_EnableInfo\"]")
	public MobileElement enableDisableProfileText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Parental_Control_Screen_Switch_Enable\"]")
	public MobileElement parentalControlToggleButton;
	
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Global\"]")
	public MobileElement globalSettingText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_Expand\"]")
	public MobileElement globalSettingExpandButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_PauseAll\"]")
	public MobileElement pauseAllProfilesText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_PauseInfo\"]")
	public MobileElement pauseInternetAccessToAllText;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeSwitch[@name=\"Parental_Control_Screen_Switch_PauseAll\"]")
	public MobileElement pauseAllProfilesToggleButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_User\"]") // User Profiles Text
	public MobileElement userProfilesText;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"+ Add Profile\"]")
	public MobileElement addProfileLink;

	//When there are no user profiles
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_NoProfile\"]")
	public MobileElement noProfilesText1;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Image_Note\"]")
	public MobileElement noProfilesText2;
	
	//Delete Associated Rules
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement deleteProfileIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement deleteProfileLabel;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Network_Settings_Screen_Label_MainWifi\"]")
	public MobileElement deleteProfileConfirmationText;
	
	//Delete Associated Rules
	
	//Delete User Profiles
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_IButton_DeleteClose\"]")
	public MobileElement closeButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_AlertTitle\"]")
	public MobileElement alertTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_AlertNote\"]")
	public MobileElement alertSubTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_Ok\"]")
	public MobileElement okButton;
	
	//Delete Alert Dialog
	
	
	//Delete User Profiles
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Delete\"]")
	public MobileElement deleteUserProfile;
	
	//Delete User Profiles
	
	//Pause Internet For all Profiles 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_PauesClose\"]")
	public MobileElement closeResumeButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_PauseHeader\"]")
	public MobileElement pauseTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Pause\"]")
	public MobileElement pauseSubTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_PauseOne\"]")
	public MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_PauseTwo\"]")
	public MobileElement yesPauseButton;
	//Pause Internet For all Profiles 
	
	//Resume Internet For all Profiles 
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_PauesClose\"]")
	public MobileElement close;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_PauseHeader\"]")
	public MobileElement resumeTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Pause\"]")
	public MobileElement resumeSubTitle;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_PauseOne\"]")
	public MobileElement cancelResumeButton;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Screen_Button_PauseTwo\"]")
	public MobileElement yesResumeButton;
	//Resume Internet For all Profiles 

	
	public ParentalControlWithProfilesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	// click currently blocked devices tab when enable parental control on profiles
	// tab is ON and profiles are blocked.
	public ParentalControlCurrentlyBlockedPage getParentalControlCurrentlyBlockedTabPageObject() {
		ParentalControlCurrentlyBlockedPage parentalControlCurrentlyBlockedTabPage = new ParentalControlCurrentlyBlockedPage();
		return parentalControlCurrentlyBlockedTabPage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}

	// click on currently blocked tab. Alert dialog should be displayed when enable
	// prarental control toggle button is off.
	public ParentalControlAlertDialog getParentalControlAlertDialogObject() {
		ParentalControlAlertDialog alertDialog = new ParentalControlAlertDialog();
		return alertDialog;
	}

	// On-click of Enable parent control toggle button sometime ratings page comes
	// up
	public AppRatingDialog getAppRatingDialogObject() {
		AppRatingDialog ratingDialog = new AppRatingDialog();
		return ratingDialog;
	}

	public ParentalControlAddProfileDialog getAddProfileDialogObject() {
		ParentalControlAddProfileDialog addProfileDialog = new ParentalControlAddProfileDialog();
		return addProfileDialog;
	}

	public ParentalControlUserProfilePage getUserProfilePageObject() {
		ParentalControlUserProfilePage userProfilePage = new ParentalControlUserProfilePage();
		return userProfilePage;
	}

	public ParentalControlHelpPage getParentalHelpPageObject() {
		ParentalControlHelpPage helpPage = new ParentalControlHelpPage();
		return helpPage;
	}

	public ParentalControlPauseInternetforAllProfilesDialog getPauseInternetForAllDialogObject() {
		ParentalControlPauseInternetforAllProfilesDialog pauseInternet = new ParentalControlPauseInternetforAllProfilesDialog();
		return pauseInternet;
	}

	public ParentalControlResumeInternetforAllProfilesDialog getResumeInternetForAllDialogObject() {
		ParentalControlResumeInternetforAllProfilesDialog resumeInternet = new ParentalControlResumeInternetforAllProfilesDialog();
		return resumeInternet;
	}

	public boolean verifyUIOnParentalControlProfilesPage() {
		utils.log().info("**********************************************************");
		utils.log().info("Verifying Objects on Parental Control - Profiles Tab      ");
		utils.log().info("**********************************************************");

		try {
			try {
				if (parentalControlTitle.isDisplayed())
					utils.log().info("Title - " + parentalControlTitle.getText() + " - is displayed");
			} catch (Exception e1) {
				utils.log().info("Parental Control Title Text is not displayed");
			}
			
			try {
				if (backButton.isDisplayed())
					utils.log().info("Back Button is displayed");
				}catch(Exception e) {utils.log().info("Back Button is not displayed");}

			try {
				if (cloudIcon.isDisplayed())
					utils.log().info("Cloud Icon is displayed");
				}catch(Exception e) {utils.log().info("Cloud Icon is not displayed");}

			try {
				if (helpIcon.isDisplayed())
					utils.log().info("Help Icon is displayed");
			} catch (Exception e1) {
				utils.log().info("Help Icon is not displayed");
			}

			try {
				if (profilesTab.isDisplayed())
					utils.log().info("Profiles Tab is displayed");
			} catch (Exception e1) {
				utils.log().info("Profiles Tab is not displayed");
			}

			try {
				if (currentlyBlockedTab.isDisplayed())
					utils.log().info("Currently Blocked Tab is displayed");
			} catch (Exception e1) {
				utils.log().info("Currently Blocked Tab is not displayed");
			}
			
			try {
				if (enableParentalControlText.isDisplayed())
					utils.log().info(enableParentalControlText.getText() + " text is displayed");
			} catch (Exception e1) {
				utils.log().info("Enable Parental Control Text is not displayed");
			}
			
			try {
				if (parentalControlToggleButton.isDisplayed())
					utils.log().info("Parental Control Toggle button is displayed");
			}catch(Exception exp) {
				utils.log().info("Parental Control Toggle button is not displayed");
			}
			
			try {
				if (globalSettingText.isDisplayed())
					utils.log().info("Global Settings Text is displayed");
				}catch(Exception e) {
					utils.log().info("Global Settings Text is not displayed since there are no profiles created");
				}

			try {
				if (globalSettingExpandButton.isDisplayed())
					utils.log().info("Global Settings Expand button is displayed");
				click(globalSettingExpandButton);
				}catch(Exception e) {
					utils.log().info("Global Settings Expand button is not displayed since there are no profiles created");
				}
			
			try {
				if (pauseAllProfilesText.isDisplayed())
					utils.log().info(pauseAllProfilesText.getText() + " text is displayed");
			}catch(Exception e) {
				utils.log().info("Pause All Profiles text is not displayed");
			}
		
			try {
				if (pauseInternetAccessToAllText.isDisplayed())
				utils.log().info(pauseInternetAccessToAllText.getText() + " text is displayed");
			}catch(Exception e) {
				utils.log().info("Pause Internet For All Profiles text is not displayed");
			}
			
			try {
				if (pauseAllProfilesToggleButton.isDisplayed())
					utils.log().info("Pause All Profiles Switch button is displayed");
			}catch(Exception exp) {
				utils.log().info("Pause All Profiles is not displayed");
			}

			try {
				if (userProfilesText.isDisplayed())
					utils.log().info(userProfilesText.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("User Profiles text is not displayed");
			}

			try {
				if (addProfileLink.isDisplayed())
					utils.log().info(addProfileLink.getText() + " link is displayed");
			} catch (Exception e) {
				utils.log().info("Add Profile link is not displayed");
			}
			
			try {	
				if (noProfilesText1.isDisplayed())
					utils.log().info(noProfilesText1.getText());
			}catch(Exception exp) {
				utils.log().info("Currently there are users under Parental Control ");
			}

			return true;

		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean verifyUIForGlobalSettingsOnProfilesPage() {
		utils.log().info("                                                                          ");
		utils.log().info("************************************************************8*************");
		utils.log().info("Verifying Global Settings Objects on Parental Control - Profiles Tab      ");
		utils.log().info("**************************************************************************");

		try {
		
			try {
				if (globalSettingText.isDisplayed())
					utils.log().info("Global Settings Text is displayed");
				}catch(Exception e) {utils.log().info("Global Settings Text is not displayed since there are no profiles created");}

			try {
				if (globalSettingExpandButton.isDisplayed())
					utils.log().info("Global Settings Expand button is displayed");
				click(globalSettingExpandButton);
				}catch(Exception e) {utils.log().info("Global Settings Expand button is not displayed since there are no profiles created");}
			

			try {
				if (pauseAllProfilesText.isDisplayed())
					utils.log().info(pauseAllProfilesText.getText() + " text is displayed");
			} catch (Exception e1) {
				utils.log().info("Pause All Profiles text is not displayed");
			}
		
			try {
				if (pauseInternetAccessToAllText.isDisplayed())
					utils.log().info(pauseInternetAccessToAllText.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Pause Internet For All Profiles text is not displayed");
			}
			
			try {
				if (pauseAllProfilesToggleButton.isDisplayed())
					utils.log().info("Pause All Profiles Switch button is displayed");
			}catch(Exception exp) {utils.log().info("Pause All Profiles is not displayed");}
			
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back button is not displayed");
			return false;
		}
	}

	public boolean clickHelpIcon() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Icon");
			return true;
		} else {
			utils.log().info("Help button is not displayed");
			return false;
		}
	}

	public boolean clickProfilesTab() {
		if (profilesTab.isDisplayed()) {
			click(profilesTab);
			utils.log().info("Clicked Profiles Tab on Parental Control Page");
			return true;
		} else {
			utils.log().info("Profiles Tab on Parental Control Page is not displayed");
			return false;
		}
	}

	public boolean clickCurrentlyBlockedTab() {
		if (currentlyBlockedTab.isDisplayed()) {
			click(currentlyBlockedTab);
			utils.log().info("Clicked Currently Blocked Tab on Parental Control Page");
			return true;
		} else {
			utils.log().info("Currently Blocked Tab on Parental Control Page is not displayed");
			return false;
		}
	}
	
	public boolean clickGlobalSettingExpandButton() {
		if (globalSettingExpandButton.isDisplayed()) {
			click(globalSettingExpandButton);
			utils.log().info("Clicked on Global Setting Expand Button");
			return true;
		} else {
			utils.log().info("Currently Global Setting Expand Button is not displayed");
			return false;
		}
	}
	
	public boolean pauseInternetForSelectedUsers()
	{
		utils.log().info("                                          ");
		utils.log().info("******************************************");
		utils.log().info("Pause Internet for Selected User Profiles ");
		utils.log().info("******************************************");
		

		try {
			for (int i = 1; i <= 3; i=+2) {
				utils.log().info("                  ");
				utils.log().info("User Profile : " + i);
				utils.log().info("------------------");
				
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_Profile["+i+"]\"`]")).getAttribute("value");
					int value = Integer.parseInt(str);
					if(value == 0)  //disabled
					{
						super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_Profile["+i+"]\"`]")).click();
						utils.log().info("Parental internet is enabled");
					}else {
						utils.log().info("Parental Control is already enabled");
					}
				}
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in Pausing Internet for selected User Profile ");
			return false;
		}
	}
	
	public boolean resumeInternetForSelectedUsers()
	{
		utils.log().info("                                           ");
		utils.log().info("*******************************************");
		utils.log().info("Resume Internet for Selected User Profiles ");
		utils.log().info("*******************************************");
		

		try {
			for (int i = 1; i <= 3; i+=2) {
				
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_Profile["+i+"]\"`]")).getAttribute("value");
					int value = Integer.parseInt(str);
					if(value == 1)  //enabled
					{
						super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_Profile["+i+"]\"`]")).click();
						utils.log().info("Parental internet is disabled");
					}else {
						utils.log().info("Parental Control is already disabled");
					}
				}
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in Resuming Internet for selected User Profile ");
			return false;
		}
	}

	public boolean enableParentalControl() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_Enable\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				//click(parentalControlToggleButton);  click to enable parental control switch button
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_Enable\"`]")).click();
				utils.log().info("Parental Control is enabled. Add Profile option is enabled to add new profiles.");
			}else {
				utils.log().info("Parental Control is already enabled. Add Profile option is enabled to add new profiles.");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling parental control");
			return true;
		}
	}

	public boolean disableParentalControl() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_Enable\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				//click(parentalControlToggleButton);
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_Enable\"`]")).click();
				utils.log().info("Parental Control is disabled. Add Profile option is disabled");
			}else {
				utils.log().info("Parental Control is already disabled. Add Profile option is disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling parental control");
			return true;
		}
	}
	
	public boolean enablePauseAllProfiles() {
		try {
			click(globalSettingExpandButton);
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_PauseAll\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)
			{
				//click(pauseAllProfilesToggleButton);
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_PauseAll\"`]")).click();
				utils.log().info("Parental Control Global Settings. Pause All Profiles is enabled");
			}else {
				utils.log().info("Parental Control Global Settings. Pause All Profiles is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling Pause All Profiles");
			return true;
		}
	}

	public boolean disablePauseAllProfiles() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_PauseAll\"`]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				//click(pauseAllProfilesToggleButton);
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Parental_Control_Screen_Switch_PauseAll\"`]")).click();
				utils.log().info("Parental Control Global Settings. Pause All Profiles is disabled");
			}else {
				utils.log().info("Parental Control Global Settings. Pause All Profiles is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling Pause All Profiles");
			return true;
		}
	}

	public boolean clickAddProfilesLink() {
		if (addProfileLink.isDisplayed()) {
			click(addProfileLink);
			utils.log().info("Clicked on Add Profile Link");
			return true;
		} else {
			utils.log().info("Add Profile link is not displayed");
			return false;
		}
	}
	
	public boolean clickYesPauseInternetButton() {
		if (yesPauseButton.isDisplayed()) {
			click(yesPauseButton);
			utils.log().info("Clicked on YES, PAUSE INTERNET button");
			return true;
		} else {
			utils.log().info("YES, PAUSE INTERNET button is not displayed");
			return false;
		}
	}
	
	public boolean clickCancelInternetResumeButton() {
		if (cancelResumeButton.isDisplayed()) {
			click(cancelResumeButton);
			utils.log().info("Clicked on CANCEL button");
			return true;
		} else {
			utils.log().info("CANCEL button is not displayed");
			return false;
		}
	}
	
	public boolean clickYesResumeInternetButton() {
		if (yesResumeButton.isDisplayed()) {
			click(yesResumeButton);
			utils.log().info("Clicked on YES, RESUME INTERNET button");
			return true;
		} else {
			utils.log().info("YES, RESUME INTERNET button is not displayed");
			return false;
		}
	}
	
	public boolean clickCancelInternetPauseButton() {
		if (cancelButton.isDisplayed()) {
			click(cancelButton);
			utils.log().info("Clicked on CANCEL button");
			return true;
		} else {
			utils.log().info("CANCEL button is not displayed");
			return false;
		}
	}

	public boolean verifyUserProfile() {

		utils.log().info("                                                          ");
		utils.log().info("**********************************************************");
		utils.log().info("Details of User Profiles created in Parental Control Page ");
		utils.log().info("**********************************************************");
		
//		int size = super.getDriver().findElementsByXPath(
//		"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable").size();
//		utils.log().info("No of User Profiles added : " + size);
		
		try {
			for (int i = 1; i <= 3; i++) {
				utils.log().info("                   ");
				utils.log().info("User Profile : " + i);
				utils.log().info("------------------");
				
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Parental_Control_Screen_Image_Profile["+i+"]\"]").isDisplayed())
							utils.log().info("Profile Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Profile Image is not displayed ");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").isDisplayed()) {
							utils.log().info("Profile user Name is : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").getText());}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_ConnectedDevice["+i+"]\"]").isDisplayed()) {
							utils.log().info("Number of Devices Paused for Internet Connection is : " + (super.getDriver().findElementByXPath(
											"//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_ConnectedDevice["+i+"]\"]").getText()));}
					} catch (Exception exp) {
						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Pause["+i+"]\"]").isDisplayed()) {
							utils.log().info("Paused Internet Label is displayed : " + (super.getDriver().findElementByXPath(
									"//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Pause["+i+"]\"]").getText()));}
					} catch (Exception exp) {
						utils.log().info("Paused Internet Label is not displayed ");
					}

					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeSwitch[@name=\"Parental_Control_Screen_Switch_Profile["+i+"]\"]").isSelected())
							utils.log().info("Internet is Paused for this user");
						else
							utils.log().info("Internet is not Paused for this user");
					} catch (Exception exp) {}

					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
			return false;
		}
	}

	public boolean pauseInternetForSelectedUserProfile() {
		utils.log().info("**********************************************");
		utils.log().info("Internet Is Paused For Selected User Profiles ");
		utils.log().info("**********************************************");

		try {
			for (int i = 0; i < 5; i += 2) {
				utils.log().info("User Profile : " + i);
				utils.log().info("----------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
								+ "]");
				for (MobileElement e : entity) {
					try {
						if (super.getDriver().findElementByXPath(
								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
								.isDisplayed()) {
							utils.log().info("Profile user Name is : " + super.getDriver().findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
									.getText());
							selectedProfileNames.add(super.getDriver().findElementByXPath(
									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
									.getText());
						}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}

					try {
						if (super.getDriver().findElementByXPath(
								"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
								.isDisplayed())
							utils.log()
									.info("Internet is not Paused for this user. Switch is : " + (super.getDriver().findElementByXPath(
											"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
											.getText()));
						else
							utils.log().info("Internet is Paused for this user. Switch is : " + (super.getDriver().findElementByXPath(
									"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']")
									.getText()));
					} catch (Exception exp) {
						utils.log().info("Paused Internet Switch is not displayed ");
					}
					utils.log().info("****************************************************");
					utils.log().info("                                                    ");
				}
				if (i == 3)
					new SwipeActions().swipeScreen(Direction.UP);
				super.pause(3);
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
			return false;
		}
	}

	public boolean clickOnUserProfile() {
		
		utils.log().info("****************************************");
		utils.log().info("Selecting a User Profile from the list  ");
		utils.log().info("****************************************");
		super.generateRandomNumber13();

		try {
			for (int i = 1; i <= 1; i++) {
//				utils.log().info("User Profile : " + i);
//				utils.log().info("------------------");
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");


				for (MobileElement e : entity) {
					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").isDisplayed()) {
							utils.log().info("Clicking on User profile Name : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").getText());
							super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Parental_Control_Screen_Label_Profile["+i+"]\"]").click();
						}
					} catch (Exception exp) {
						utils.log().info("User Profile Name is not displayed ");
					}
				}
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("User Profile does not exits. Please create one");
			return false;
		}
	}
	
	public boolean deleteUserProfile() {
		
		utils.log().info("                                      ");
		utils.log().info("**************************************");
		utils.log().info("Deleting a User Profile from the list ");
		utils.log().info("**************************************");

			try {
				utils.log().info("Delete User Profile ");
				utils.log().info("--------------------");
				
//				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
//				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable/XCUIElementTypeCell[1]");
	
			    super.swipeUserProfile(Direction.LEFT);
			    
			    if(deleteUserProfile.isDisplayed()) {
			    	click(deleteUserProfile); }
			    
			    if(alertTitle.isDisplayed()) {
			    	click(okButton); }
			    super.pause(35);
			return true;
		} catch (Exception exp) {
			utils.log().info("User Profile does not exits. Please create one");
			return false;
		}
	}

//	public boolean verifyPauseInternetAccessForAllUserProfile() {
//		counter = 1;
//		utils.log().info("***************************************************");
//		utils.log().info("Internet Is Paused For The Following User Profiles ");
//		utils.log().info("***************************************************");
//		try {
//			for (int i = 1; i < 3 ; i++) {
//				utils.log().info("User Profile : " + counter);
//				utils.log().info("----------------------");
//				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
//						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
//								+ "]");
//				
//				for (MobileElement e : entity) {
//					try {
//						if (super.getDriver().findElementByXPath(
//								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//								.isDisplayed()) {
//							utils.log().info("Profile user Name is : " + super.getDriver().findElementByXPath(
//									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//									.getText());
//						}
//					} catch (Exception exp) {
//						utils.log().info("User Profile Name is not displayed ");
//					}
//
//					try {
//						if (super.getDriver().findElementByXPath(
//								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
//								.isDisplayed()) {
//							utils.log().info("Number of Devices Paused for Internet Connection is : " + (e
//									.findElementByXPath(
//											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
//									.getText()));
//						}
//					} catch (Exception exp) {
//						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
//					}
//
//					try {
//						if (super.getDriver().findElementByXPath(
//								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
//								.isDisplayed()) {
//							utils.log().info("Paused Internet Label is displayed : " + (super.getDriver().findElementByXPath(
//									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
//									.getText()));
//						}
//					} catch (Exception exp) {
//						utils.log().info("Paused Internet Label is not displayed ");
//					}
//
//					try {
//						if (super.getDriver().findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").isDisplayed())
//							utils.log().info("Internet is Paused for this user. Switch is : " + (super.getDriver().findElementByXPath(
//									"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").getText()));
//					} catch (Exception exp) {
//						utils.log().info("Internet is not Paused for this user. Switch is : " + (super.getDriver().findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']").getText()));
//					}
//					utils.log().info("****************************************************");
//					utils.log().info("                                                    ");
//					counter++;
//				}
//				if (i == 3)
//					new SwipeActions().swipeScreen(Direction.UP);
//				super.pause(3);
//			}
//			return true;
//		} catch (Exception exp) {
//			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
//			return false;
//		}
//	}
//
//	public boolean verifyResumeInternetAccessForAllUserProfile() {
//		counter = 1;
//		utils.log().info("****************************************************");
//		utils.log().info("Internet Is Resumed For The Following User Profiles ");
//		utils.log().info("****************************************************");
//		
//		try {
//			for (int i = 1; i < 3 ; i++) {
//				utils.log().info("User Profile : " + counter);
//				utils.log().info("----------------------");
//				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
//						"//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i
//								+ "]");
//				for (MobileElement e : entity) {
//					try {
//						if (super.getDriver().findElementByXPath(
//								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//								.isDisplayed()) {
//							utils.log().info("Profile user Name is : " + super.getDriver().findElementByXPath(
//									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_name']")
//									.getText());
//						}
//					} catch (Exception exp) {
//						utils.log().info("User Profile Name is not displayed ");
//					}
//
//					try {
//						if (super.getDriver().findElementByXPath(
//								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
//								.isDisplayed()) {
//							utils.log().info("Number of Devices Paused for Internet Connection is : " + (e
//									.findElementByXPath(
//											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/profile_connected_devices']")
//									.getText()));
//						}
//					} catch (Exception exp) {
//						utils.log().info("Number of Devices Paused for Internet Connection is not displayed ");
//					}
//
//					try {
//						if (super.getDriver().findElementByXPath(
//								"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
//								.isDisplayed()) {
//							utils.log().info("Paused Internet Label is displayed : " + (super.getDriver().findElementByXPath(
//									"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/pause_internet_message']")
//									.getText()));
//						}
//					} catch (Exception exp) {
//						utils.log().info("Paused Internet Label is not displayed ");
//					}
//
//					try {
//						if (super.getDriver().findElementByXPath(
//								"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
//								.isDisplayed()) {
//							utils.log()
//									.info("Internet is not Paused for this user. Switch is : " + (super.getDriver().findElementByXPath(
//											"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='false']")
//											.getText()));
//						} else
//							utils.log().info("Internet is Paused for this user. Switch is : " + (super.getDriver().findElementByXPath(
//									"//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/profile_enable_disable' and @checked='true']")
//									.getText()));
//					} catch (Exception exp) {
//						utils.log().info("Paused Internet Switch is not displayed ");
//					}
//					utils.log().info("****************************************************");
//					utils.log().info("                                                    ");
//					counter++;
//				}
//				if (i == 3)
//					new SwipeActions().swipeScreen(Direction.UP);
//				super.pause(3);
//			}
//			return true;
//		} catch (Exception exp) {
//			utils.log().info("Error in retrieving User Profile list in Parental Control Profiles Page ");
//			return false;
//		}
//	}

	@Override
	public boolean isAt() {
		if (enableParentalControlText.isDisplayed()) {
			utils.log().info("On Parental Control - Profiles Page");
			return true;
		} else {
			utils.log().info("Not on Parental Control - Profilees Page");
			return false;
		}
	}
}
