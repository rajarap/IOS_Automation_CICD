package com.cs.arris.Pages;

import java.util.List;

import org.apache.commons.lang3.time.StopWatch;
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

public class WhosHomeMonitoringPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_NavigationBar_Title\"]")
	public MobileElement whosHomeMonitoringPageTitle;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Main_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Main_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backButton;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_Monitoring\"])[1]")
	public MobileElement monitoringLabel;

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeSwitch[@name=\"WH_Main_Screen_Switch\"])[1]")
	public MobileElement monitoringToggleButton;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_Home\"])[1]")
	public MobileElement whosHomeLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_In\"]")
	public MobileElement whosInOutLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_Count\"]")
	public MobileElement memberCount;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_Notify\"]")
	public MobileElement notifyMeLabel;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"WH_Main_Screen_Image_Bell\"]")
	public MobileElement notifyBellIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"WH_Main_Screen_Image_Expand\"]")
	public MobileElement expandArrow;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"WH_Main_Screen_Button_Add\"]")
	public MobileElement addButton;
	

	public WhosHomeMonitoringPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public WhosHomeChangeMemberNameDialog getChangeMemberNamePageObject() {
		WhosHomeChangeMemberNameDialog changeMemberName = new WhosHomeChangeMemberNameDialog();
		return changeMemberName;
	}
	
	public WhosHomeChangeDeviceDialog getChangeMemberDeviceNamePageObject() {
		WhosHomeChangeDeviceDialog changeMemberDeviceName = new WhosHomeChangeDeviceDialog();
		return changeMemberDeviceName;
	}
	
	public WhosHomeRemoveMemberDialog getRemoveMemberPageObject() {
		WhosHomeRemoveMemberDialog removeMemberName = new WhosHomeRemoveMemberDialog();
		return removeMemberName;
	}
	
	public WhosHomeNotifyMeWhenPage getNotifyMeWhenPageObject() {
		WhosHomeNotifyMeWhenPage notifyMeWhen = new WhosHomeNotifyMeWhenPage();
		return notifyMeWhen;
	}
	
	

	public boolean clickBackButton() {
		if (backButton.isDisplayed()) {
			click(backButton);
			utils.log().info("Clicked on Back Button");
			return true;
		} else {
			utils.log().info("Back Button is not displayed");
			return false;
		}
	}
	
	public boolean clickHelpButton() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}

	public boolean clickAddButton() {
		if (addButton.isDisplayed()) {
			click(addButton);
			utils.log().info("Clicked on Add Button");
			return true;
		} else {
			utils.log().info("Add button is not displayed");
			return false;
		}
	}
	
	public boolean clickArrowButton() {
		if (expandArrow.isDisplayed()) {
			click(expandArrow);
			utils.log().info("Clicked on Arrow Button");
			return true;
		} else {
			utils.log().info("Arrow button is not displayed");
			return false;
		}
	}
	
	public boolean clickNotifyMeText() {
		if (notifyMeLabel.isDisplayed()) {
			click(notifyMeLabel);
			utils.log().info("Clicked on Notify Text");
			return true;
		} else {
			utils.log().info("Notify Text is not displayed");
			return false;
		}
	}
	
	public boolean clickChangeNameOption() {
		if (super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Change Name\"`]")).isDisplayed()) {
			click(super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Change Name\"`]")));
			utils.log().info("Clicked on Change Member Name Option");
			return true;
		} else {
			utils.log().info("Change Member Name Option is not displayed");
			return false;
		}
	}
	
	public boolean clickChangeDeviceOption() {
		if (super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Change Device\"`]")).isDisplayed()) {
			click(super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Change Device\"`]")));
			utils.log().info("Clicked on Change Device Name Option");
			return true;
		} else {
			utils.log().info("Change Device Name Option is not displayed");
			return false;
		}
	}
	
	public boolean clickRemoveMemberOption() {
		if (super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Remove Member\"`]")).isDisplayed()) {
			click(super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"Remove Member\"`]")));
			utils.log().info("Clicked on Remove Member Name Option");
			return true;
		} else {
			utils.log().info("Remove Member Name Option is not displayed");
			return false;
		}
	}
	
	public boolean enableMonitoring() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"WH_Main_Screen_Switch\"`][1]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 0)  //disabled
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"WH_Main_Screen_Switch\"`][1]")).click();
				utils.log().info("Monitoring is enabled.");
			}else {
				utils.log().info("Monitoring is already enabled.");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in enabling Monitoring");
			return true;
		}
	}
	
	public boolean disableMonitoring() {
		try {
			String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"WH_Main_Screen_Switch\"`][1]")).getAttribute("value");
			int value = Integer.parseInt(str);
			if(value == 1)  //enabled
			{
				super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"WH_Main_Screen_Switch\"`][1]")).click();
				
				utils.log().info("Monitoring is disabled.");
			}else {
				utils.log().info("Monitoring is already disabled.");
			}
			return true;
		} catch(Exception e) {
			utils.log().info("Issue in disabling Monitoring");
			return true;
		}
	}

	public boolean verifyWhoseHomeWelcomePage() {
		utils.log().info("                                                    ");
		utils.log().info("****************************************************");
		utils.log().info("Details of UI Elements on Who's Home Monitoring Page");
		utils.log().info("****************************************************");
		try {
			try {
				if (whosHomeMonitoringPageTitle.isDisplayed())
					utils.log().info(whosHomeMonitoringPageTitle.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("WHO'S HOME Title text is not displayed");
			}
			
			try {
				if (backButton.isDisplayed())
					utils.log().info("BACK button is displayed");
			} catch (Exception e) {
				utils.log().info("BACK button is not displayed");
			}
			
			try {
				if (helpIcon.isDisplayed())
					utils.log().info("Help button is displayed");
			} catch (Exception e) {
				utils.log().info("Help button is not displayed");
			}
			
			try {
				if (monitoringLabel.isDisplayed())
					utils.log().info(monitoringLabel.getText() + " Label is displayed");
			} catch (Exception e) {
				utils.log().info("Monitoring label is not displayed");
			}
			
			try {
				if (monitoringToggleButton.isDisplayed())
					utils.log().info("Monitoring Toggle button is displayed");
			} catch (Exception e) {
				utils.log().info("Monitoring Toggle button is not displayed");
			}
			
			try {
				if (whosHomeLabel.isDisplayed())
					utils.log().info(whosHomeLabel.getText() + " button is displayed");
			} catch (Exception e) {
				utils.log().info("Who’s Home label is not displayed");
			}

			try {
				if (whosInOutLabel.isDisplayed())
					utils.log().info(whosInOutLabel.getText() + " label is displayed");
			} catch (Exception e) {
				utils.log().info("WHO’S IN / OUT label is not displayed");
			}

			try {
				if (memberCount.isDisplayed())
					utils.log().info(memberCount.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Member Count is not displayed");
			}
			
			try {
				if (notifyBellIcon.isDisplayed())
					utils.log().info("Notify Me Bell Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Notify Me Bell Icon is not displayed");
			}

			try {
				if (addButton.isDisplayed())
					utils.log().info("Add Icon is displayed");
			} catch (Exception e) {
				utils.log().info("Add Icon is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean listOFMonitoringMembers() {
		utils.log().info("                                  ");
		utils.log().info("**********************************");
		utils.log().info("Details of Members Being Monitored");
		utils.log().info("**********************************");

		int size = super.getDriver().findElements(MobileBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable")).size();
	//	utils.log().info("Count is : " + size);
			
		for (int i = 1 ; i <= size; i++) {
			utils.log().info("Members Device Details : " + i);
			utils.log().info("------------------------------");
						
			List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
			"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

			for (MobileElement e : entity) {
				
				try {
				if (super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"WH_Main_Screen_Button_Option["+ i++ +"]\"]").isDisplayed()){
					utils.log().info("Member Initial is displayed ");}
				} catch (Exception exp) {
					utils.log().info("Member Initial is not displayed ");
				}
				
				try {
				if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_MemberName["+ i++ +"]\"]").isDisplayed()){
					utils.log().info("Member Name is  : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_MemberName["+ i++ +"]\"]").getText());}
				} catch (Exception exp) {
					utils.log().info("Member name is not displayed ");
				}
				
				try {
				if (super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_Status["+ i++ +"]\"]").isDisplayed()){
					utils.log().info("Monitoring Device is  : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"WH_Main_Screen_Label_Status["+ i++ +"]\"]").getText());}
				} catch (Exception exp) {
					utils.log().info("Monitoing Device name is not displayed ");
				}

				utils.log().info("****************************************************");
				utils.log().info("                                                    ");
			}
		}
			return true;
	}
	
	public boolean selectMemberOptionIcon() {
	//	int size = super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable").size();
	//	utils.log().info("Count is : " + size);
			
		for (int i = 2 ; i <= 2; i++) {		
			List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
			"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

			for (MobileElement e : entity) {
				try {								     
				if (e.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"icon ellipses\"`]")).isDisplayed())
					e.findElement(MobileBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"icon ellipses\"`]")).click();
					utils.log().info("Clicked on Member Eclipse option ");
				} catch (Exception exp) {
					utils.log().info("Member Eclipse option is not displayed ");
				}
							
				utils.log().info("****************************************************");
				utils.log().info("                                                    ");
			}
		}
			return true;
	}
	
	@Override
	public boolean isAt() {
		if (whosHomeMonitoringPageTitle.isDisplayed()) {
			utils.log().info("On WHO'S HOME Monitoring Page");
			return true;
		} else {
			utils.log().info("Not on WHO'S HOME Monitoring Page");
			return false;
		}
	}
}
