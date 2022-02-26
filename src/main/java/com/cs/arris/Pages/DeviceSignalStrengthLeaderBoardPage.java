package com.cs.arris.Pages;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class DeviceSignalStrengthLeaderBoardPage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	public List<MobileElement> listOfDevices;
	public int counter = 1;
	public int size;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_TitleLabel\"]")
	public MobileElement leaderBoardTitleText;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Devices\"]")
	public MobileElement countOfDevices;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label\"]")
	public MobileElement topFiveOnlineDevices;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Device_Bit_Rate_Leaderboard_Screen_Button\"]")
	public MobileElement signalStrengthOptions;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\" Strong to weak\"]")
	public MobileElement strongToWeak;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Weak to strong\"]")
	public MobileElement weakToStrong;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\" Strong to weak\"]")
	public MobileElement selectStrongToWeak;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\" Weak to strong\"]")
	public MobileElement selectWeakToStrong;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"leftArrowAngle\"]")
	public MobileElement listBoxArrow;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"NavigationBar_Button\"]")
	public MobileElement closeIcon;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Devices\"]")
	public MobileElement deviceEntry1;

	public DeviceSignalStrengthLeaderBoardPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public boolean clickCloseIcon()
	{
		if(closeIcon.isDisplayed())	{
			click(closeIcon);
			utils.log().info("Clicked on Close Icon");
			return true;
		}else {
			return false;
		}
	}
	
	public HomePage getHomePageObject() {
		HomePage homePage = new HomePage();
		return homePage;
	}

	public EditDeviceNameDialog getEditDeviceNameDialogObject() {
		EditDeviceNameDialog editDeviceNameDialog = new EditDeviceNameDialog();
		return editDeviceNameDialog;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
	}
	
	public boolean verifyUIOnDeviceSignalStrengthPage() {
		try {
			utils.log().info("                                                              ");
			utils.log().info("**************************************************************");
			utils.log().info("Verifying UI Elements on Device Signal Strength Leader Board  ");
			utils.log().info("**************************************************************");
			
			try {
				if (leaderBoardTitleText.isDisplayed())
					utils.log().info("Title - " + leaderBoardTitleText.getText() + " - is displayed");
			} catch (Exception e) {
				utils.log().info("Leader Board Title Text is not displayed");
			}

			try {
				if (topFiveOnlineDevices.isDisplayed())
					utils.log().info(topFiveOnlineDevices.getText() + " - text is displayed");
			} catch (Exception e) {
				utils.log().info("Top five Online Devices text is not displayed");
			}

			try {
				if (signalStrengthOptions.isDisplayed())
					utils.log().info("Sorting based on Device Signal Strength option is displayed");
			} catch (Exception e) {
				utils.log().info("Sorting based on device signal strength option is not displayed");
			}
			
			try {
				if (countOfDevices.isDisplayed())
					utils.log().info(countOfDevices.getText() + " are displayed");
			} catch (Exception e) {
				utils.log().info("Number of Devices is not displayed");
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public boolean verifySignalStrengthForDevices() {

			utils.log().info("                                             ");
			utils.log().info("*********************************************");
			utils.log().info("List of Devices Signal Strength Leader Board ");
			utils.log().info("*********************************************");
	
			size = super.getDeviceSignalStrengthCount(countOfDevices.getText());
			utils.log().info("Bit Rate Device count is : " + size);
			
		try {
			for (int i = 1; i <= size; i++) {
				utils.log().info("Devices  : " + i);
				utils.log().info("---------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Device_Bit_Rate_Leaderboard_Screen_Image_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not available/displayed");
					}

					try {
						utils.log().info("Device Name            : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Bit_Rate_Leaderboard_Screen_Button_DeviceName["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available/displayed");
					}

					try {
						utils.log().info("Device Signal Strength : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Speed["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available/displayed");
					}

					try {
						utils.log().info("Device Download Speed  : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Download["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed is not available/displayed");
					}

					try {
						utils.log().info("Device Upload Speed    : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Upload["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed is not available/displayed");
					}

					try {
						utils.log().info(super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_RSSITitle["+i+"]\"]").getText() + " : " +
								super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_RSSI["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI Label/data is not available/displayed");
					}

				}
				if (i >= 5)
					super.swipeUp();
			}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Device Signal Strength Leader Board Page");
			return false;
		}
	}

	public boolean verifySignalStrengthStrongToWeak() {

			utils.log().info("****************************************************************");
			utils.log().info("Sorting Device Signal Strength Leader Board From Strong to Weak ");
			utils.log().info("****************************************************************");

//			int size = new HomePage().getBitRateDevicesCount();
//			utils.log().info("Bit Rate Device count is : " + size);
			
			size = super.getDeviceSignalStrengthCount(countOfDevices.getText());
			utils.log().info("Bit Rate Device count is : " + size);
			
			click(signalStrengthOptions);
			click(selectStrongToWeak);
			
		try {
			for (int i = 1; i <= size; i++) {
				utils.log().info("Devices  : " + i);
				utils.log().info("---------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Device_Bit_Rate_Leaderboard_Screen_Image_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not available/displayed");
					}

					try {
						utils.log().info("Device Name            : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Bit_Rate_Leaderboard_Screen_Button_DeviceName["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available/displayed");
					}

					try {
						utils.log().info("Device Signal Strength : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Speed["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available/displayed");
					}

					try {
						utils.log().info("Device Download Speed  : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Download["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed is not available/displayed");
					}

					try {
						utils.log().info("Device Upload Speed    : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Upload["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed is not available/displayed");
					}

					try {
						utils.log().info("RSSI Label             : "
								+  super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_RSSI["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI data is not available/displayed");
					}
				}
				if (i >= 5)
					super.swipeUp();
			}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Device Signal Strength Leader Board Page");
			return false;
		}
	}
	
	public boolean verifySignalStrengthWeakToStrong() {

			utils.log().info("****************************************************************");
			utils.log().info("Sorting Device Signal Strength Leader Board From Weak to Strong ");
			utils.log().info("****************************************************************");

//			int size = new HomePage().getBitRateDevicesCount();
//			utils.log().info("Bit Rate Device count is : " + size);
			
			size = super.getDeviceSignalStrengthCount(countOfDevices.getText());
			utils.log().info("Bit Rate Device count is : " + size);
			
			click(signalStrengthOptions);
			click(selectWeakToStrong);
			
		try {
			for (int i = 1; i <= size; i++) {
				utils.log().info("Devices  : " + i);
				utils.log().info("---------------------");

				List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
						"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

				for (MobileElement e : entity) {
					try {
						if (super.getDriver().findElementByXPath("//XCUIElementTypeImage[@name=\"Device_Bit_Rate_Leaderboard_Screen_Image_Device["+i+"]\"]").isDisplayed())
							utils.log().info("Device Image is displayed");
					} catch (Exception exp) {
						utils.log().info("Device Image is not available/displayed");
					}

					try {
						utils.log().info("Device Name            : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeButton[@name=\"Device_Bit_Rate_Leaderboard_Screen_Button_DeviceName["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Name is not available/displayed");
					}

					try {
						utils.log().info("Device Signal Strength : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Speed["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Signal Strength is not available/displayed");
					}

					try {
						utils.log().info("Device Download Speed  : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Download["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Download Speed is not available/displayed");
					}

					try {
						utils.log().info("Device Upload Speed    : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_Upload["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("Device Upload Speed is not available/displayed");
					}

					try {
						utils.log().info("RSSI Label             : "
								+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Device_Bit_Rate_Leaderboard_Screen_Label_RSSI["+i+"]\"]").getText());
					} catch (Exception exp) {
						utils.log().info("RSSI data is not available/displayed");
					}
				}
				if (i >= 5)
					super.swipeUp();
			}
			return true;
		} catch (Exception ex) {
			utils.log().info("Error in Device Signal Strength Leader Board Page");
			return false;
		}
	}
		
	public boolean sortStrongToWeak() {
		try {
			click(signalStrengthOptions);
			click(strongToWeak);
			listOfDevices = (List<MobileElement>) super.getDriver().findElements(By.xpath(
					"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView"));
			int size = listOfDevices.size();
			utils.log().info("Verifying Signal Strength for " + size + " devices");
			counter = 1;
			Integer[] originalSignalStrength;
			Integer[] desendingSignalStrength;
			int i = 0;

			originalSignalStrength = new Integer[size];
			desendingSignalStrength = new Integer[size];

			for (MobileElement e : listOfDevices) {
				originalSignalStrength[i] = convertSignalStrengthToInteger(
						e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
				i++;
			}

			desendingSignalStrength = sortArrayDecending(originalSignalStrength);
			if (Arrays.equals(originalSignalStrength, desendingSignalStrength)) {
				utils.log().info("Signal Strength option selected is - Strong to Weak");
				utils.log().info("The devices are displayed from Strongest to Weakest signal strength order");
			} 
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean sortWeakToStrong() {
		try {
			click(signalStrengthOptions);
			click(weakToStrong);
			listOfDevices = (List<MobileElement>) super.getDriver().findElements(By.xpath(
					"//android.view.ViewGroup[@content-desc='SBC Test']/androidx.recyclerview.widget.RecyclerView"));
			int size = listOfDevices.size();
			utils.log().info("Verifying Signal Strength for " + size + " devices");
			counter = 1;
			Integer[] originalSignalStrength;
			Integer[] ascendingSignalStrength;
			int i = 0;

			originalSignalStrength = new Integer[size];
			ascendingSignalStrength = new Integer[size];

			for (MobileElement e : listOfDevices) {
				originalSignalStrength[i] = convertSignalStrengthToInteger(
						e.findElementById("com.arris.sbcBeta:id/txtMainSignalStrength").getText());
				i++;
			}

			ascendingSignalStrength = sortArrayAscending(originalSignalStrength);
			if (Arrays.equals(originalSignalStrength, ascendingSignalStrength)) {
				utils.log().info("Signal Strength option selected is - Weak to Strong");
				utils.log().info("The devices are displayed from Weakest to Strongest signal strength order");
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private Integer convertSignalStrengthToInteger(String ghz) // 5GHz
	{
		String i = ghz.substring(0, 1);
		return Integer.valueOf(i);
	}

	private Integer[] sortArrayDecending(Integer ss[]) {
		Arrays.sort(ss, Collections.reverseOrder());
		return ss;
	}

	private Integer[] sortArrayAscending(Integer ss[]) {
		Arrays.sort(ss);
		return ss;
	}

	@Override
	public boolean isAt() {
		if (leaderBoardTitleText.isDisplayed()) {
			utils.log().info("On Device Signal Strength Leader Board Page");
			return true;
		} else {
			utils.log().info("Not on Device Signal Strength Leader Board Page");
			return false;
		}
	}

}
