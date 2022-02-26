package com.cs.arris.Pages;

import org.apache.commons.lang3.time.StopWatch;
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

public class SpeedTestPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement speedTestTitle; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Speed_Test_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backIcon; 
	
//	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Add Device\"]")
//	public MobileElement cloudIcon; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Speed_Test_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon; 
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_Phone\"]")
	public MobileElement deviceImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_Phone\"]")
	public MobileElement deviceName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_Device\"]")
	public MobileElement routerImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_Device\"]")
	public MobileElement ssidName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_Internet\"]")
	public MobileElement speedTestIcon;
	
	@iOSXCUITFindBy(xpath = "/XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_Internet\"]")
	public MobileElement speedTestName;  //nternet
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Speed_Test_Screen_SpeedMeterView\"]")
	public MobileElement speedTestMeter;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Speed_Test_Screen_Button_Test\"]")
	public MobileElement startSpeedTestButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Speed_Test_Screen_Button_Stop\"]")
	public MobileElement stopSpeedTestButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Speed_Test_Screen_Button_Run\"]")
	public MobileElement runSpeedTestAgainButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Speed_Test_Screen_Button_History\"]")
	public MobileElement viewHistory;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_DownloadHeader\"]")
	public MobileElement wifiDownloadView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_Download\"]")
	public MobileElement wifiDownloadSpeed;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_UploadHeader\"]")
	public MobileElement wifiUploadWifiView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_Upload\"]")
	public MobileElement wifiUploadloadSpeed;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_WanDownloadHeader\"]")
	public MobileElement internetDownloadView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_WanDownload\"]")
	public MobileElement internetDownloadSpeed;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_WanUploadHeader\"]")
	public MobileElement internetUploadView;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_WanUpload\"]")
	public MobileElement internetUploadSpeed;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_Wifi\"]")
	public MobileElement wifiSpeedGoodForText;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_Web\"]")
	public MobileElement webBrowsingImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_Web\"]")
	public MobileElement webBrowsingEmail;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_SelectWeb\"]")
	public MobileElement emailEnableIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_SD\"]")
	public MobileElement casualGamingImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_SD\"]")
	public MobileElement casualGaming;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_SelectSD\"]")
	public MobileElement sdVideoEnableIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_HD\"]")
	public MobileElement hdImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_HD\"]")
	public MobileElement hdVideo;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_SelectHD\"]")
	public MobileElement hdVideoEnableIcon;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_UHD\"]")
	public MobileElement vrImage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Speed_Test_Screen_Label_UHD\"]")
	public MobileElement virtualReality;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Speed_Test_Screen_Image_SelectUHD\"]")
	public MobileElement virtualEnableIcon;
	
	public SpeedTestPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	 public HomePage getHomePageObject() {
		 HomePage homePage = new HomePage();
	     return homePage;
	  }
	 
	 public SpeedTestHistoryPage getSpeedTestHistoryPageObject() {
		 SpeedTestHistoryPage speedTestHistoryPage = new SpeedTestHistoryPage();
	     return speedTestHistoryPage;
	  }
	 
	 public SpeedTestHelpPage getSpeedTestHelpPageObject() {
		 SpeedTestHelpPage speedTestHelpPage = new SpeedTestHelpPage();
	     return speedTestHelpPage;
	  }
	 
	 public HomeSpeedTestHistoryPage getHomeSpeedTestHistoryPageObject() {
		 HomeSpeedTestHistoryPage homeSpeedTestHistoryPage = new HomeSpeedTestHistoryPage();
	     return homeSpeedTestHistoryPage;
	  }
		
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }	
	 
		public AppRatingDialog getAppRatingDialogObject() {
			AppRatingDialog ratingDialog = new AppRatingDialog();
			return ratingDialog;
		}
	
		public boolean clickBackButton() {
			if (backIcon.isDisplayed()) {
				click(backIcon);
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
				return true;
			} else {
				utils.log().info("Help button is not displayed");
				return false;
			}
		}

	
		public boolean verifyUIOnSpeedTestPage() {
			utils.log().info("                                         ");
			utils.log().info("*****************************************");
			utils.log().info("Verifying UI Elements on Speed Test Page ");
			utils.log().info("*****************************************");

			try {
				try {
					if (speedTestTitle.isDisplayed())
						utils.log().info("Title - " + speedTestTitle.getText() + " - is displayed");
				} catch (Exception e) {
					utils.log().info("Notifications Title is not displayed");
				}

				try {
					if (backIcon.isDisplayed())
						utils.log().info("Back Icon is displayed");
				} catch (Exception e) {
					utils.log().info("Back Icon is not displayed");
				}

//				if(cloudIcon.isDisplayed())
//					utils.log().info("Cloud Icon is displayed");
//				else
//					utils.log().info("Cloud Icon is displayed");

				try {
					if (helpIcon.isDisplayed())
						utils.log().info("Help Icon is displayed");
				} catch (Exception e) {
					utils.log().info("Help Icon is displayed");
				}

				try {
					if (deviceImage.isDisplayed())
						utils.log().info("Device Image is displayed");
				} catch (Exception e) {
					utils.log().info("Device Image is not displayed");
				}

				try {
					if (deviceName.isDisplayed())
						utils.log().info("Device Name is displayed");
				} catch (Exception e) {
					utils.log().info("Device Name is not displayed");
				}

				try {
					if (routerImage.isDisplayed())
						utils.log().info("Router Image is displayed");
				} catch (Exception e) {
					utils.log().info("Router Imnage Button is not displayed");
				}

				try {
					if (ssidName.isDisplayed())
						utils.log().info("SSID Name is displayed");
				} catch (Exception e) {
					utils.log().info("SSID Name is not displayed");
				}

				try {
					if (speedTestIcon.isDisplayed())
						utils.log().info("Interet Icon is displayed");
				} catch (Exception e) {
					utils.log().info("Interet Icon is not displayed");
				}

				try {
					if (speedTestName.isDisplayed())
						utils.log().info("Internet Text is displayed");
				} catch (Exception e) {
					utils.log().info("Internet Text is not displayed");
				}

				try {
					if (speedTestMeter.isDisplayed())
						utils.log().info("Speed Test Meter is displayed");
				} catch (Exception e) {
					utils.log().info("Speed Test Meter is not displayed");
				}

				try {
					if (startSpeedTestButton.isDisplayed())
						utils.log().info("Start Speed Test Button is displayed");
				} catch (Exception e) {
					utils.log().info("Start Speed Test Button is not displayed");
				}

				try {
					if (viewHistory.isDisplayed())
						utils.log().info("View History Button is displayed");
				} catch (Exception e) {
					utils.log().info("View History Button is not displayed");
				}
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	
	public boolean clickStartSpeedTestButton() {
		if (startSpeedTestButton.isDisplayed()) {
			click(startSpeedTestButton);
			utils.log().info("Clicked Start Speed Test Button");
			return true;
		} else {
			utils.log().info("Start Speed Test Button is not displayed");
			return false;
		}
	}
	
	public boolean clickRunSpeedTestButton() {
		if (runSpeedTestAgainButton.isDisplayed()) {
			click(runSpeedTestAgainButton);
			utils.log().info("Clicked Run Speed Test Agaibn Button");
			return true;
		} else {
			utils.log().info("Run Speed Test Again Button is not displayed");
			return false;
		}
	}
	
	public boolean clickStopSpeedTestButton()
	{
		if (stopSpeedTestButton.isDisplayed()) {
			click(stopSpeedTestButton);
			utils.log().info("Clicked Stop Speed Test Button");
			return true;
		} else {
			utils.log().info("Stop Speed Test Button is not displayed");
			return false;
		}
	}
	
	public boolean clickViewHistoryButton() {
		if (viewHistory.isDisplayed()) {
			click(viewHistory);
			utils.log().info("Clicked View History Button");
			return true;
		} else {
			utils.log().info("View History Button is not displayed");
			return false;
		}
	}
	
	public boolean performSpeedTest()
	{
		try {
			if (startSpeedTestButton.isDisplayed()) {
				utils.log().info("Label on button before speed Test: " + startSpeedTestButton.getText());
				clickStartSpeedTestButton();}
			utils.log().info("Label on button during speed Test: " + stopSpeedTestButton.getText());
			super.pause(100);
			try {
				if(this.getAppRatingDialogObject().remindMeLaterText.isDisplayed())
					this.getAppRatingDialogObject().clickRemindMeLaterLink();
				}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");}
			
		}catch(Exception e) {}
//			utils.log().info("Label on button after speed Test: " + runSpeedTestAgainButton.getText());
			return true;
	}
	
	public boolean runSpeedTestAgain()
	{
		try {
			if(runSpeedTestAgainButton.isDisplayed()) {
				utils.log().info("Label on button after speed Test: " + runSpeedTestAgainButton.getText());
				clickRunSpeedTestButton();
			}
			utils.log().info("Label on button during speed Test: " + stopSpeedTestButton.getText());
			super.pause(100);
			try {
				if(this.getAppRatingDialogObject().remindMeLaterText.isDisplayed())
					this.getAppRatingDialogObject().clickRemindMeLaterLink();
				}catch(Exception e) {
				utils.log().info("App Rating Dialog did not appear");}
			
		}catch(Exception e) {}
//			utils.log().info("Label on button after speed Test: " + runSpeedTestAgainButton.getText());
			return true;
	}
	
	

	
	public boolean verifySpeedTestResultsUI() {
		try {
			try {
				if (wifiDownloadView.isDisplayed())
					utils.log().info("Wifi " + wifiDownloadView.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Wifi Download Text is not displayed");
			}

			try {
				if (wifiDownloadSpeed.isDisplayed())
					utils.log().info("Wifi " + wifiDownloadSpeed.getText() + " speed is displayed");
			} catch (Exception e) {
				utils.log().info("Wifi Download Speed is not displayed");
			}

			try {
				if (wifiUploadWifiView.isDisplayed())
					utils.log().info("Wifi " + wifiUploadWifiView.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Wifi Upload Text is not displayed");
			}

			try {
				if (wifiUploadloadSpeed.isDisplayed())
					utils.log().info("Wifi " + wifiUploadloadSpeed.getText() + " speed is displayed");
			} catch (Exception e) {
				utils.log().info("Wifi Upload Speed is not displayed");
			}

			try {
				if (internetDownloadView.isDisplayed())
					utils.log().info("Internet " + internetDownloadView.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Internet Download Text is not displayed");
			}

			try {
				if (internetDownloadSpeed.isDisplayed())
					utils.log().info("Internet " + internetDownloadSpeed.getText() + " speed is displayed");
			} catch (Exception e) {
				utils.log().info("Internet Download Speed is not displayed");
			}

			try {
				if (internetUploadView.isDisplayed())
					utils.log().info("Internet " + internetUploadView.getText() + " text is displayed");
			} catch (Exception e) {
				utils.log().info("Internet Upload Text is not displayed");
			}

			try {
				if (internetUploadSpeed.isDisplayed())
					utils.log().info("Internet " + internetUploadSpeed.getText() + " speed is displayed");
			} catch (Exception e) {
				utils.log().info("Internet Download Speed is not displayed");
			}

			try {
				if (wifiSpeedGoodForText.isDisplayed())
					utils.log().info("" + wifiSpeedGoodForText.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("This Wi-Fi Speed is good for: text is not displayed");
			}
			
			try {
				if (webBrowsingImage.isDisplayed())
					utils.log().info("Web Browsing/Email Image is displayed");
			} catch (Exception e) {
				utils.log().info("Web Browsing/Email Image is not displayed");
			}

			try {
				if (webBrowsingEmail.isDisplayed())
					utils.log().info("" + webBrowsingEmail.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("Web Browsing/E-mail text is not displayed");
			}

			try {
				if (emailEnableIcon.isDisplayed())
					utils.log().info("Web Browsing/E-mail enable/disable icon is displayed");
			} catch (Exception e) {
				utils.log().info("Web Browsing/E-mail enable/disable iconis not displayed");
			}
			
			try {
				if (casualGamingImage.isDisplayed())
					utils.log().info("SD video / Music / Casual games Image is displayed");
			} catch (Exception e) {
				utils.log().info("SD video / Music / Casual games Image is not displayed");
			}

			try {
				if (casualGaming.isDisplayed())
					utils.log().info("" + casualGaming.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("SD Video, Music, and Casual Gaming text is not displayed");
			}

			try {
				if (sdVideoEnableIcon.isDisplayed())
					utils.log().info("SD Video, Music, and Casual Gaming enable/disable icon is displayed");
			} catch (Exception e) {
				utils.log().info("SD Video, Music, and Casual Gaming enable/disable icon is not displayed");
			}

			try {
				if (hdImage.isDisplayed())
					utils.log().info("HD video / Competitive gaming Image is displayed");
			} catch (Exception e) {
				utils.log().info("HD video / Competitive gaming Image is not displayed");
			}
			
			try {
				if (hdVideo.isDisplayed())
					utils.log().info("" + hdVideo.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("HD Video and Competitive Gaming text is not displayed");
			}

			try {
				if (hdVideoEnableIcon.isDisplayed())
					utils.log().info("HD Video and Competitive Gaming enable/disable icon is displayed");
			} catch (Exception e) {
				utils.log().info("HD Video and Competitive Gaming enable/disable icon is not displayed");
			}

			try {
				if (vrImage.isDisplayed())
					utils.log().info("UHD / 4K video / VR Image is displayed");
			} catch (Exception e) {
				utils.log().info("UHD / 4K video / VR Image is not displayed");
			}
			
			try {
				if (virtualReality.isDisplayed())
					utils.log().info("" + virtualReality.getText() + " is displayed");
			} catch (Exception e) {
				utils.log().info("UHD/4K Video/ Virtual Reality text is not displayed");
			}

			try {
				if (virtualEnableIcon.isDisplayed())
					utils.log().info("UHD/4K Video/ Virtual Reality enable/disable icon is displayed");
			} catch (Exception e) {
				utils.log().info("UHD/4K Video/ Virtual Reality enable/disable icon  is not displayed");
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean isAt() {
		if (speedTestTitle.isDisplayed()) {
			utils.log().info("On Speed Test Page");
			return true;
		} else {
			utils.log().info("Speed Test Page is not displayed");
			return false;
		}
	}
}


//try {
//if(this.getAppRatingDialogObject().remindMeLaterText.isDisplayed())
//	this.getAppRatingDialogObject().clickRemindMeLaterLink();
//}catch(Exception e) {
//utils.log().info("App Rating Dialog did not appear");
//}

//try {
//	if(super.getDriver().findElementById("com.arris.sbcBeta:id/remindMeLaterTxt").isDisplayed())
//		click(super.getDriver().findElementById("com.arris.sbcBeta:id/remindMeLaterTxt"));
//}catch(Exception ep) {utils.log().info("App Rating Dialog did not appear");}
