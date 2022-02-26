package com.cs.arris.Pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HomeNetworkHealthOptimizationSettingsPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public SwipeActions swipe = new SwipeActions();
	public TouchAction action = new TouchAction(getDriver());
	public List<MobileElement> me;
	public int counter = 1;
	int size;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"Network Health Optimization\"]")
	public MobileElement backButton; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network Optimization Settings\"]")
	public MobileElement networkOptimizationSettingsTitle; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Optimization\"]")
	public MobileElement optimizationLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSwitch[@name=\"Network_Health_Settings_Screen_Switch\"]")
	public MobileElement networkOptimizationToggleButton; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_OptimizationDetail\"]")
	public MobileElement networkOptimizationTurneOnText; 
	
	
	// After enabling network optimization settings
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Sensitivity\"]")
	public MobileElement recommendedSensitivitiy; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_SensitivityDetail\"]")
	public MobileElement controlSensitivityText; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Low\"]")
	public MobileElement lowSensitivityLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Medium\"]")
	public MobileElement mediumSensitivityLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_High\"]")
	public MobileElement highSensitivityLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeSlider[@name=\"Network_Health_Settings_Screen_Slider\"]")
	public MobileElement sliderImage; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Low\"]")
	public MobileElement lowSensitivitySliderPosition; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Medium\"]")
	public MobileElement mediumSensitivitySliderPosition; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_High\"]")
	public MobileElement HighSensitivitySliderPosition; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Notification\"]")
	public MobileElement notifiedLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Title[1]\"]")
	public MobileElement connectedDevicesSignalLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Title[2]\"]")
	public MobileElement satelliteSignalLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Title[3]\"]")
	public MobileElement satelliteLinkSignalLabel; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Network_Health_Settings_Screen_Label_Title[4]\"]")
	public MobileElement ispLinkSpeedRateLabel; 
	
	
	//On disabling network optimization settings toggle button
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"NH_Recommendation_Alert_Screen_TitleLabel\"]")
	public MobileElement turnOffNetworkOptimizationTitle; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"NH_Recommendation_Alert_Screen_Label_Description\"]")
	public MobileElement confirmationMessage; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"NH_Recommendation_Alert_Screen_Button\"]")
	public MobileElement turnOffButton; 
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeButton[@name=\"NH_Recommendation_Alert_Screen_Button_Cancel\"]")
	public MobileElement cancelButton; 
	

	
	public HomeNetworkHealthOptimizationSettingsPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	 
	 public HomeNetworkHealthOptimizationConnectedDevicesPage getConnectedDevicesPageObject() {
		 HomeNetworkHealthOptimizationConnectedDevicesPage connectedDevice = new HomeNetworkHealthOptimizationConnectedDevicesPage();
	     return connectedDevice;
	  }
	 
	 public HomeNetworkHealthOptimizationSatelliteSignalPage getSatelliteSignalPageObject() {
		 HomeNetworkHealthOptimizationSatelliteSignalPage satelliteSignal = new HomeNetworkHealthOptimizationSatelliteSignalPage();
	     return satelliteSignal;
	  }
	 
	 public HomeNetworkHealthOptimizationSatelliteLinkRatePage getSatelliteLinkRatePageObject() {
		 HomeNetworkHealthOptimizationSatelliteLinkRatePage satelliteLink = new HomeNetworkHealthOptimizationSatelliteLinkRatePage();
	     return satelliteLink;
	  }
	 
	 public HomeNetworkHealthOptimizationISPSpeedRatePage getISPSpeedRatePageObject() {
		 HomeNetworkHealthOptimizationISPSpeedRatePage ispRate = new HomeNetworkHealthOptimizationISPSpeedRatePage();
	     return ispRate;
	  }
	 
		public boolean clickTurnOffButton() {
			if (turnOffButton.isDisplayed()) {
				click(turnOffButton);
				utils.log().info("Clicked on Yes Turn it Off Button");
				return true;
			} else {
				utils.log().info("Yes Turn it Off Button is not displayed");
				return false;
			}
		}
		
		public boolean clickCancelButton() {
			if (cancelButton.isDisplayed()) {
				click(cancelButton);
				utils.log().info("Clicked on Cancel Button");
				return true;
			} else {
				utils.log().info("Cancel Button is not displayed");
				return false;
			}
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
		
		public boolean clickConnectedDeviceSignalButton() {
			if (connectedDevicesSignalLabel.isDisplayed()) {
				click(connectedDevicesSignalLabel);
				utils.log().info("Clicked on Connected Device Signal button");
				return true;
			} else {
				utils.log().info("Connected Device Signal button is not displayed");
				return false;
			}
		}
		
		public boolean clickSatelliteSignalButton() {
			if (satelliteSignalLabel.isDisplayed()) {
				click(satelliteSignalLabel);
				utils.log().info("Clicked on Satellite Signal button");
				return true;
			} else {
				utils.log().info("Satellite Signal button is not displayed");
				return false;
			}
		}
		
		public boolean clickSatelliteLinkRateButton() {
			if (satelliteLinkSignalLabel.isDisplayed()) {
				click(satelliteLinkSignalLabel);
				utils.log().info("Clicked on Satellite Link Signal button");
				return true;
			} else {
				utils.log().info("Satellite Link Signal button is not displayed");
				return false;
			}
		}
		
		public boolean clickISPSpeedRateButton() {
			super.swipeUp();
			if (ispLinkSpeedRateLabel.isDisplayed()) {
				click(ispLinkSpeedRateLabel);
				utils.log().info("Clicked on ISP Speed Rate button");
				return true;
			} else {
				utils.log().info("ISP Speed Rate button is not displayed");
				return false;
			}
		}
		
		public boolean enableHealthOptimization() {
			try {
				String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Network_Health_Settings_Screen_Switch\"`]")).getAttribute("value");
				int value = Integer.parseInt(str);
				if(value == 0)
				{
					super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Network_Health_Settings_Screen_Switch\"`]")).click();
					utils.log().info("Network Optimization is enabled");
				}else {
					utils.log().info("Network Optimization is already enabled");
				}
				return true;
			} catch(Exception e) {
				utils.log().info("Issue in enabling Network Optimization");
				return true;
			}
		}

		public boolean disableHealthOptimization() {
			try {
				String str = super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Network_Health_Settings_Screen_Switch\"`]")).getAttribute("value");
				int value = Integer.parseInt(str);
				if(value == 1)
				{
					super.getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSwitch[`name == \"Network_Health_Settings_Screen_Switch\"`]")).click();
					
					try {
						if(turnOffNetworkOptimizationTitle.isDisplayed() && turnOffButton.isDisplayed())
							click(turnOffButton);
						utils.log().info("Clicked on Yes Turn Off button");
					}catch(Exception e) {utils.log().info("Confirmation dialog to turn off network optimization is not displayed");}

					utils.log().info("Network Optimization is disabled");
				}else {
					utils.log().info("Network Optimization is already disabled");
				}
				return true;
			} catch(Exception e) {
				utils.log().info("Issue in enabling Network Optimization");
				return true;
			}
		}
		
		public void mobileSwipeSeekBar(Direction dir) {
		    final int ANIMATION_TIME = 200; // ms
		    final HashMap<String, String> scrollObject = new HashMap<String, String>();
		    MobileElement element = (MobileElement) getDriver().findElement(MobileBy.iOSClassChain("**/XCUIElementTypeSlider[`name == \"Device_Detail_Screen_Slider\"`]"));
		    switch (dir) {
		        case LEFT: 
			            action.press(PointOption.point(286, 449)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(185, 449)).release().perform();
			            scrollObject.put("direction", dir.name().toLowerCase());
			            break;
		        case RIGHT: 
		            	action.press(PointOption.point(185, 449)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
                    		.moveTo(PointOption.point(286, 449)).release().perform();
		            scrollObject.put("direction", dir.name().toLowerCase());
		            break;
		        default:
		            throw new IllegalArgumentException("mobileSwipeElementIOS(): dir: '" + dir + "' NOT supported");
		    }
		    scrollObject.put("element", element.getId());
		    try {
		        getDriver().executeScript("mobile:swipe", scrollObject);
		        Thread.sleep(ANIMATION_TIME); 
		    } catch (Exception e) {
		        System.err.println("mobileSwipeElementIOS(): FAILED\n" + e.getMessage());
		    }
		}
		
		public void tapLow()
		{
			int endX = 23;
			int endY = 345;
			PointOption p = new PointOption();
			p.withCoordinates(endX, endY);
			action.tap(p).perform();
		}
		
		public void tapMedium()
		{
			int endX = 186;
			int endY = 345;
			PointOption p = new PointOption();
			p.withCoordinates(endX, endY);
			action.tap(p).perform();
		}
	 
		
		public void tapHigh()
		{
			int endX = 354;
			int endY = 345;
			PointOption p = new PointOption();
			p.withCoordinates(endX, endY);
			action.tap(p).perform();
		}
	 
	 
	 public boolean verifyNetworkOptimizationSettingsPageUI() {
			
			utils.log().info("                                                                   ");
			utils.log().info("*******************************************************************");
			utils.log().info("Details of UI Elements on Network Health Optimization Settings Page");
			utils.log().info("*******************************************************************");
			try {
				try {
					if (networkOptimizationSettingsTitle.isDisplayed())
						utils.log().info(networkOptimizationSettingsTitle.getText() + " title text is displayed");
				} catch (Exception e1) {
					utils.log().info("Network Health Optimization Settings title text is not displayed");
				}

				try {
					if (backButton.isDisplayed())
						utils.log().info("Back button is displayed");
				} catch (Exception e1) {
					utils.log().info("Back button is not displayed");
				}
				
				try {
					if (networkOptimizationToggleButton.isDisplayed())
						utils.log().info("Optimization Toggle button is displayed");
				} catch (Exception e1) {
					utils.log().info("Optimization Toggle button is not displayed");
				}
				
				try{
					if (optimizationLabel.isDisplayed())
						utils.log().info(optimizationLabel.getText() + " label is displayed");
				}catch(Exception e) {
					utils.log().info("Optimization label is not displayed");
				}
				
				try{
					if (networkOptimizationTurneOnText.isDisplayed())
						utils.log().info(networkOptimizationTurneOnText.getText() + " message is displayed");
				}catch(Exception e) {
					utils.log().info("Turn on optimization to access network health & view recommendations message is not displayed");
				}

				return true;
			} catch (Exception e) {
				return false;
			}
		}
	 
	 public boolean verifyNetworkOptimizationSettingsEnabledPageUI() {
			
			utils.log().info("                                                                           ");
			utils.log().info("***************************************************************************");
			utils.log().info("Details of UI Elements on Network Health Optimization Settings Enabled Page");
			utils.log().info("***************************************************************************");
			try {
				try {
					if (recommendedSensitivitiy.isDisplayed())
						utils.log().info(recommendedSensitivitiy.getText() + " text is displayed");
				} catch (Exception e1) {
					utils.log().info("Recommendation sensitivity text is not displayed");
				}

				try {
					if (controlSensitivityText.isDisplayed())
						utils.log().info(controlSensitivityText.getText() + " text is displayed");
				} catch (Exception e1) {
					utils.log().info("Control the recommendation frequency by adjusting the sensitivity is not displayed");
				}
				
				try {
					if (lowSensitivityLabel.isDisplayed())
						utils.log().info(lowSensitivityLabel.getText() + " text is displayed");
				} catch (Exception e1) {
					utils.log().info("Low text is not displayed");
				}
				
				try {
					if (mediumSensitivityLabel.isDisplayed())
						utils.log().info(mediumSensitivityLabel.getText() + " text is displayed");
				} catch (Exception e1) {
					utils.log().info("Medium(Optional) is not displayed");
				}
				
				try {
					if (highSensitivityLabel.isDisplayed())
						utils.log().info(highSensitivityLabel.getText() + " text is displayed");
				} catch (Exception e1) {
					utils.log().info("High is not displayed");
				}
				
				try {
					if (sliderImage.isDisplayed())
						utils.log().info("Slider Image is displayed");
				} catch (Exception e1) {
					utils.log().info("Slider Image is not displayed");
				}
				
				try {
					if (notifiedLabel.isDisplayed())
						utils.log().info(notifiedLabel.getText() + " text is displayed");
				} catch (Exception e1) {
					utils.log().info("You will be notified as soon as your  text is not displayed");
				}
				
				try{
					if (connectedDevicesSignalLabel.isDisplayed())
						utils.log().info(connectedDevicesSignalLabel.getText() + " label is displayed");
				}catch(Exception e) {
					utils.log().info("Connected Device signal notification is not displayed");
				}
				
				try{
					if (satelliteSignalLabel.isDisplayed())
						utils.log().info(satelliteSignalLabel.getText() + " message is displayed");
				}catch(Exception e) {
					utils.log().info("Satellite Signal Strength notification is not displayed");
				}
				
				try{
					if (satelliteLinkSignalLabel.isDisplayed())
						utils.log().info(satelliteLinkSignalLabel.getText() + " message is displayed");
				}catch(Exception e) {
					utils.log().info("Satellite Link Rate notification is not displayed");
				}
				
				super.swipeUp();
				
				try{
					if (ispLinkSpeedRateLabel.isDisplayed())
						utils.log().info(ispLinkSpeedRateLabel.getText() + " message is displayed");
				}catch(Exception e) {
					utils.log().info("ISP Speed Rate notification is not displayed");
				}

				return true;
			} catch (Exception e) {
				return false;
			}
		}
	 
	
	@Override
	public boolean isAt() {
		if(networkOptimizationSettingsTitle.isDisplayed())
		{
			utils.log().info("On Network Health Optimization Settings Page");
			return true;
		}else {
			utils.log().info("Not on Network Health Optimization Settings Page");
		return false;}
	}
}
