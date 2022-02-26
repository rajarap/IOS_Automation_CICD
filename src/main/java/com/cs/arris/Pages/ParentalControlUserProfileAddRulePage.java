package com.cs.arris.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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

public class ParentalControlUserProfileAddRulePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public List<String> deviceList = new ArrayList<String>();
	public int deviceListSize;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_NavigationBar_TitleLabel\"]") 
	public MobileElement enableScheduleTimeTitle; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_NoRule\"]")
	public MobileElement noActiveRuleFoundText; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Parental_Control_Time_Schedule_Screen_Label_NoActiveInfo\"]")
	public MobileElement noActiveRuleFoundMessage; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backButton; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_NavigationTitle_Button_Help\"]")
	public MobileElement helpIcon; 
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"cross\"]")
	public MobileElement cloudIcon;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Parental_Control_Time_Schedule_Screen_Button_AddTimeRule\"]")
	public MobileElement addScheduleButton; 
	
	public ParentalControlAddRuleHelpPage getParentalAddRuleHelpPageObject(){
		ParentalControlAddRuleHelpPage addDeviceHelpPage = new ParentalControlAddRuleHelpPage();
		return addDeviceHelpPage;
	}
	
	public ParentalControlAddRuleAddInternetBlockingScheduleDialog getInternetBlockingScheduleDialogObject(){
		ParentalControlAddRuleAddInternetBlockingScheduleDialog addinternetBlockingDialog = new ParentalControlAddRuleAddInternetBlockingScheduleDialog();
		return addinternetBlockingDialog;
	}
	
	
	public ParentalControlUserProfileAddRulePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
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

	public boolean clickHelpIcon() {
		if (helpIcon.isDisplayed()) {
			click(helpIcon);
			utils.log().info("Clicked on Help Icon");
			return true;
		} else {
			utils.log().info("Help Icon is not displayed");
			return false;
		}
	}

	public boolean clickAddScheduleButton() {
		if (addScheduleButton.isDisplayed()) {
			click(addScheduleButton);
			utils.log().info("Clicked on Add Time Schedule Button");
			return true;
		} else {
			utils.log().info("Add Time Schedule button is not displayed");
			return false;
		}
	}
	
	
	public boolean verifyUIOnEnableScheduleTimePage() {
		try {
			if (enableScheduleTimeTitle.isDisplayed())
				utils.log().info("Title - " + enableScheduleTimeTitle.getText() + " - is displayed");
			else
				utils.log().info("Enable Schedule Time Title is not displayed");

			if (backButton.isDisplayed())
				utils.log().info("Back button is displayed");
			else
				utils.log().info("Back button button is not displayed");

			if (helpIcon.isDisplayed())
				utils.log().info("Help Icon is displayed");
			else
				utils.log().info("Help Icon is not displayed");
			
			if (noActiveRuleFoundText.isDisplayed())
				utils.log().info(noActiveRuleFoundText.getText() + " is displayed");
			else
				utils.log().info("No Active Time Rule Found, is not displayed");
			
			if (noActiveRuleFoundMessage.isDisplayed())
				utils.log().info("No Time Schedule Added to this profile, is displayed");
			else
				utils.log().info("No Time Schedule Added to this profile, is not displayed");
			
			if (addScheduleButton.isDisplayed())
				utils.log().info(addScheduleButton.getText() + " button is displayed");
			else
				utils.log().info("Add Time Schedule button is not displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

//	public boolean verifyUIonEnableScheduleTimePage() {
//
//		utils.log().info("*********************************************************************");
//		utils.log().info("Add Rule - Details of Schedules Listed in Enabled Schedule Time Page ");
//		utils.log().info("*********************************************************************");
//		
//		int size = super.getDriver().findElementsByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/time_block_list_view']").size();
//		try {
//			for (int i = 1; i <= size ; i++) 
//			{
//				utils.log().info("Enable Schedule Time - Rule : " + i);
//				utils.log().info("---------------------------------");
//
//				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + i + "]/android.widget.FrameLayout/android.widget.LinearLayout");
//
//				for (MobileElement e : entity) 
//				{
//					try {
//						if (e.findElementById("com.arris.sbcBeta:id/time_block_every_day").isDisplayed()) 
//						{
//							try {
//								if (e.findElementByXPath(
//										"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']")
//										.isDisplayed())
//									utils.log().info("Schedule Time : " + e.findElementByXPath(
//											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']")
//											.getText());
//							} catch (Exception exp) {
//								utils.log().info("EveryDay Schedule Time is not displayed ");
//							}
//		
//							try {
//								if (e.findElementById("com.arris.sbcBeta:id/time_block_every_day").isDisplayed())
//									utils.log().info(e.findElementById("com.arris.sbcBeta:id/time_block_every_day").getText()
//											+ " button is displayed ");
//							} catch (Exception exp) {
//								utils.log().info("EVERY DAY button is not displayed ");
//							}
//							
//							try {
//								if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='false']").isDisplayed())
//									utils.log().info("Time Block Toggle Button is currently disabled");
//								else if(e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='true']").isDisplayed())
//									utils.log().info("Time Block Toggle Button is currently enabled");
//								else utils.log().info("Time Block Toggle Button not displayed");
//							} catch (Exception exp) {}
//									
//							utils.log().info("****************************************************");
//							utils.log().info("                                                    ");
//						}
//					}catch(Exception exp) {	}
//				}
//			}
//			return true;
//		} catch (Exception p) {
//			return false;
//		}
//	}
	
	public boolean verifyUIonEnableScheduleTimePage() {

		utils.log().info("****************************************************************************");
		utils.log().info("Add Rule - Details of Schedules Listed in Enabled Schedule Time Custom Page ");
		utils.log().info("****************************************************************************");
		
		int size = super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable").size();
		utils.log().info("Count of Schedule Time : " + size);
		
		try {
			for (int i = 1; i <= size ; i++) 
			{
				utils.log().info("Enable Schedule Time - Rule : " + i);
				utils.log().info("----------------------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver()
						.findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

			for (MobileElement e : entity) 
			{
				try {
						try {
							if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").isDisplayed())
								utils.log().info("Schedule Time : " + e.findElementByXPath(
											"//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/time_block_start_end_time']").getText());
						} catch (Exception exp) {
								utils.log().info("Schedule Time is not displayed ");
						}
						
						try {
							if (e.findElementById("com.arris.sbcBeta:id/time_block_every_day").isDisplayed()) 
								utils.log().info("EveryDay Schedule Time : " + e.findElementById("com.arris.sbcBeta:id/time_block_every_day").getText());
						} catch (Exception exp) {
								utils.log().info("EveryDay Schedule Time is not displayed ");
						}
					
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbSunday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSunday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSunday").getText() + " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbMonday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbMonday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbMonday").getText() + " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbTuesday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbTuesday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbTuesday").getText()
									+ " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbWednesday").isDisplayed())
								utils.log()
										.info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbWednesday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbWednesday").getText()
									+ " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbThrusday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbThrusday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbThrusday").getText()
									+ " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbFriday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbFriday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbFriday").getText()
									+ " is not displayed ");
						}
	
						try {
							if (e.findElementById("com.arris.sbcBeta:id/cbSaturday").isDisplayed())
								utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSaturday").getText());
						} catch (Exception exp) {
							utils.log().info("DOW : " + e.findElementById("com.arris.sbcBeta:id/cbSaturday").getText()
									+ " is not displayed ");
						}
						
						try {
							if (e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='false']").isDisplayed())
								utils.log().info("Time Block Toggle Button is currently disabled");
							else if(e.findElementByXPath("//android.widget.Switch[@resource-id='com.arris.sbcBeta:id/time_block_enable_disable' and @checked='true']").isDisplayed())
								utils.log().info("Time Block Toggle Button is currently enabled");
							else utils.log().info("Time Block Toggle Button not displayed");
						} catch (Exception exp) {}
		
						utils.log().info("****************************************************");
						utils.log().info("                                                    ");
				}catch(Exception exp) {}
			}
			}
			return true;
		} catch (Exception p) {
			return false;
		}
	}
	

	@Override
	public boolean isAt() {
		if(enableScheduleTimeTitle.isDisplayed())
		{
			utils.log().info("On Add Rule - Enable Schedule Time Page");
			return true;}
		else {
			utils.log().info("Not on Add Rule - Enable Schedule Time Page");
		return false;}
	}
	
}
