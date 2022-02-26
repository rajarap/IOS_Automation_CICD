package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SpeedTestHistoryPage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	public JavascriptExecutor js;
	public int counter = 1;
	int size;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle]"),  //Speed Test History
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[338,149][742,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement speedTestHistoryTitle; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //Navigate up
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	})
	public MobileElement cloudIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/speed_test_history")
	public MobileElement speedTestHistoryDinning;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/speed_test_time']")
	public MobileElement speedTestHistoryDateTime;
	
	@AndroidFindBy (xpath = "//android.widget.LinearLayout[@resource-id='com.arris.sbcBeta:id/wifi_speed_test_View']")
	public MobileElement speedTestHistoryView;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/run_speed_test_again")
	public MobileElement runTestAgainButton;
	
	public SpeedTestHistoryPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public void verifySpeedTestHistory()
	{
		utils.log().info("Speed Test History Details");
		utils.log().info("**************************");
		
		List<MobileElement> speedTestHistory = (List<MobileElement>) super.getDriver().findElementsById("com.arris.sbcBeta:id/speed_test_history");
		size = speedTestHistory.size();
		
		for (MobileElement e : speedTestHistory)
		{
			utils.log().info("Speed Test History : " + counter);
			utils.log().info("-------------------------");
			
			if(size > 2)
			{
				if (counter > 2)
				{
					//super.scrollToElementByXpath(e.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+counter+"]"));
					js = (JavascriptExecutor) super.getDriver();
					MobileElement me = e.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+counter+"]");
					js.executeScript("arguments[0].scrollIntoView();", me);
				}
			}
				
			utils.log().info("Speed Test Date-Time   : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/speed_test_time']").getText());
			
			if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']").isDisplayed())
			{
				utils.log().info("Device Image is displayed");
			}
			utils.log().info("Device Name : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/device_name_history']").getText());
			
			if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/router_image']").isDisplayed())
			{
				utils.log().info("mAX Router Image is displayed");
			}
			utils.log().info("Device Name : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/router_name_history']").getText());
			
			if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/right_speed_test_icon']").isDisplayed())
			{
				utils.log().info("Internet Image is displayed");
			}
			utils.log().info("Device Name : " + e.findElementByXPath("//android.widget.TextView[@bounds='[863,584][971,630]']").getText());
			
			utils.log().info("Wifi Download Text    : " + e.findElementByXPath("//android.widget.TextView[@text='Download']").getText());
			utils.log().info("Wifi Download Speed   : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/wifi_download_speed']").getText());
			utils.log().info("Wifi Upload Text      : " + e.findElementByXPath("//android.widget.TextView[@text='Upload']").getText());
			utils.log().info("Wifi Upload Speed     : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/wifi_upload_speed']").getText());
			
			utils.log().info("Internet Download Text    : " + e.findElementByXPath("//android.widget.TextView[@text='Download']").getText());
			utils.log().info("Internet Download Speed   : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internet_download_speed']").getText());
			utils.log().info("Internet Upload Text      : " + e.findElementByXPath("//android.widget.TextView[@text='Upload']").getText());
			utils.log().info("Internet Upload Speed     : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internet_upload_speed']").getText());
			
			counter++;
		}
	}
	
	//click back icon on notification page
	public void clickBackIcon()
	{
		click(backIcon); 
		utils.log().info("Speed Test History Page - Clicked on Back Button");
	}
	
	public void clickHelpIcon()
	{
		click(helpIcon); 
		utils.log().info("Speed Test History Page - Clicked on Help Button");
	}
	
	public void clickRunTestAgainButton()
	{
		click(runTestAgainButton);
		utils.log().info("Speed Test History Page - Clicked on Run Test Again button");
	}
	
	public HomePage getHomePageObject()
	{
		HomePage homePage = new HomePage();
		return homePage;
	}
	
	 public NetworkPage getNetworkPageObject() {
		 NetworkPage networkPage = new NetworkPage();
	     return networkPage;
	  }
	 
	 public ParentalControlProfilesPage getParentalControlPageObject() {
		 ParentalControlProfilesPage parentalControlPage = new ParentalControlProfilesPage();
	     return parentalControlPage;
	  }
	
	 public FooterIconsPage getFooterIconsPageObject() {
		 FooterIconsPage footerIconsPage = new FooterIconsPage();
	     return footerIconsPage;
	  }
	 
	 public SpeedTestPage getSpeedTestPageObject() {
		 SpeedTestPage speedTestPage = new SpeedTestPage();
	     return speedTestPage;
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
