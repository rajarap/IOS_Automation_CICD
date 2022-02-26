package com.cs.arris.Pages;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByIosClassChain;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WhosHomeNotifyMeWhenPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Notify_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Notify_Screen_NavigationBar_Title\"]")
	public MobileElement notifyMeTitle;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Notify_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Notify_Screen_Label_Message\"]")
	public MobileElement notifyMeMessage;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Notify_Screen_Label_Tap\"]")
	public MobileElement tapLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Notify_Screen_Button_Add\"]")
	public MobileElement addMembers;

	
	public WhosHomeNotifyMeWhenPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}
	
	public boolean clickHelpButton() {
		if (helpButton.isDisplayed()) {
			click(helpButton);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}
	
	public boolean clickaddButton() {
		if (addMembers.isDisplayed()) {
			click(addMembers);
			utils.log().info("Clicked on Add Members plus Button");
			return true;
		} else {
			utils.log().info("Add Members plus Button is not displayed");
			return false;
		}
	}
	
	public WhosHomeNotifyMeWhenHelpPage getWhosHomeNotifyMeWhenHelpPage() {
		WhosHomeNotifyMeWhenHelpPage notifyMeHelpPage = new WhosHomeNotifyMeWhenHelpPage();
		return notifyMeHelpPage;
	}
	
	public WhosHomeAddNewNotificationPage getAddNewNotificationPageObject() {
		WhosHomeAddNewNotificationPage notifyMePage = new WhosHomeAddNewNotificationPage();
		return notifyMePage;
	}

	public boolean verifyPickADeviceDialogUI() {
		
		utils.log().info("                                                ");
		utils.log().info("************************************************");
		utils.log().info("Details of UI Elements on Whos Home Welcome Page");
		utils.log().info("************************************************");
		try {
			if (notifyMeTitle.isDisplayed())
				utils.log().info(notifyMeTitle.getText() + " Title text is displayed");
			else
				utils.log().info("NOTIFY ME WHEN Title text is not displayed");

			if (backButton.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back button is not displayed");
			
			if (helpButton.isDisplayed())
				utils.log().info("Help button is displayed");
			else
				utils.log().info("Help button is not displayed");
			
			try{
				if (notifyMeMessage.isDisplayed())
					utils.log().info(notifyMeMessage.getText() + " message is displayed");
			}catch(Exception e) {
				utils.log().info("Schedule events to receive notification when a household member enters or exits the house message is not displayed");
			}
			
			try{
				if (tapLabel.isDisplayed())
					utils.log().info(tapLabel.getText() + " message is displayed");
			}catch(Exception e) {
				utils.log().info("Tap (+) icon below to add one message is not displayed");
			}

			if (addMembers.isDisplayed())
				utils.log().info("Add members plus button is displayed");
			else
				utils.log().info("Add members plus button is not displayed");

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean enableNotification(String selector) {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain(selector)).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)
			{
				super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
				utils.log().info("Notification is enabled");
			}else {
				utils.log().info("Notification is already enabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling Notifications for selected user");
			return true;
		}
	}

	public boolean disableNotification(String selector) {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain(selector)).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)
			{
				super.getDriver().findElement(MobileBy.iOSClassChain(selector)).click();
				utils.log().info("Notification is disabled");
			}else {
				utils.log().info("Notification is already disabled");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling Notifications for selected user");
			return true;
		}
	}
	
	
	
	public boolean verifyMemberNotifications()
	{
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("List of Notifications in the NOTIFY ME WHEN Page ");
		utils.log().info("*************************************************");
		
		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();

		try {
			for (int i = 1; i <= size; i++) {
				utils.log().info("                  ");
				utils.log().info("Notification : " + i);
				utils.log().info("-------------------");
				
				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
				"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					utils.log().info("Member Name : " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_Notify_Screen_Label_MemberName["+i+"]\"]").getText());
					utils.log().info("Notification : " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_Notify_Screen_Label_Occur["+i+"]\"]").getText());
					utils.log().info("Member will be notified : " + e.findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_Notify_Screen_Label_Event["+i+"]\"]").getText());
				}
			}
			return true;
		} catch (Exception exp) {
			utils.log().info("Error in retrieving Member Notifications ");
			return false;
		}
	}
	

	@Override
	public boolean isAt() {
		if (notifyMeTitle.isDisplayed()) {
			utils.log().info("On NOTIFY ME WHEN Page");
			return true;
		} else {
			utils.log().info("Not on NOTIFY ME WHEN Page");
			return false;
		}
	}
}
