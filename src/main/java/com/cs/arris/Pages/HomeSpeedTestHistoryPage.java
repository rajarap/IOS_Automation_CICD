package com.cs.arris.Pages;

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

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomeSpeedTestHistoryPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public SwipeActions swipe = new SwipeActions();
	public List<MobileElement> me;
	public int counter = 1;
	int size;
	
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_TitleLabel\"]")
	public MobileElement speedTestHistoryTitle; 
	
//	@AndroidFindAll({
//		@AndroidBy (xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/speed_test_history']"), 
//		@AndroidBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView"),
//		@AndroidBy (id = "com.arris.sbcBeta:id/speed_test_history") 
//	})
//	public MobileElement speedTestHistoryDinning;
	
	public HomeSpeedTestHistoryPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	 
	 public SpeedTestPage getSpeedTestPageObject() {
		 SpeedTestPage speedTestPage = new SpeedTestPage();
	     return speedTestPage;
	  }
	 
		public boolean verifyHomeSpeedTestHistory() {
			try {
				utils.log().info("                                     ");
				utils.log().info("*************************************");
				utils.log().info("Details of Speed Test History Details");
				utils.log().info("*************************************");

				utils.log().info("Title : " + speedTestHistoryTitle.getText());

				for (int i = 1; i <= 3; i++) {
					List<MobileElement> entity = (List<MobileElement>) super.getDriver().findElementsByXPath(
					"//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");
					
					for (MobileElement m : entity) {
						utils.log().info("                         ");
						utils.log().info("Speed Test History : " + i);
						utils.log().info("-------------------------");
						
						utils.log().info("Date and Time: " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_Date["+i+"]\"]").getText());
						utils.log().info("Device Name : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_Phone["+i+"]\"]").getText());
						utils.log().info("Router Name : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_Device["+i+"]\"]").getText());
						utils.log().info("Internet Name : "	+ super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_Internet["+i+"]\"]").getText());
						utils.log().info("Wifi Download Text : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_PhoneDownloadTitle["+i+"]\"]").getText());
						utils.log().info("Wifi Download Speed: " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_PhoneDownload["+i+"]\"]").getText());
						utils.log().info("Wifi Upload Text : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_PhoneUploadTitle["+i+"]\"]").getText());
						utils.log().info("Wifi Upload Speed: " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_PhoneUpload["+i+"]\"]").getText());
						utils.log().info("Internet Download Text : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_InternetDownloadTitle["+i+"]\"]").getText());
						utils.log().info("Internet Download Speed: " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_InternetDownload["+i+"]\"]").getText());
						utils.log().info("Internet Upload Text	: " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_InternetUploadTitle["+i+"]\"]").getText());
						utils.log().info("Internet Upload Speed : " + super.getDriver().findElementByXPath("//XCUIElementTypeStaticText[@name=\"Speed_History_Screen_Label_InternetUpload["+i+"]\"]").getText());
						
						utils.log().info("************************************");
					}
					if (i == 2)
						super.swipeUp();
				}
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
	@Override
	public boolean isAt() {
		if(speedTestHistoryTitle.isDisplayed())
		{
			utils.log().info("On Speed Test History Page");
			return true;}
		else {
			utils.log().info("Not on Speed Test History Page");
		return false;}
	}
}
