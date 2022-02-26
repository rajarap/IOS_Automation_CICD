package com.cs.arris.Pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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

public class NetworkGeneralSettingsPortForwardingPage extends ParentClass implements Page {

	public TestUtils utils = new TestUtils();

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_NavigationBar_TitleLabel\"]")
	public MobileElement portForwardingTitle;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_NavigationBar_Button_Back\"]")
	public MobileElement backIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_NavigationBar_Button_Help\"]")
	public MobileElement helpIcon;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_AddRule\"]")
	public MobileElement addRuleButton;

	public NetworkGeneralSettingsPortForwardingPage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public NetworkGeneralSettingsPortFowardingHelpPage getPortForwardingHelpPageObject() {
		NetworkGeneralSettingsPortFowardingHelpPage portForwardingHelpPage = new NetworkGeneralSettingsPortFowardingHelpPage();
		return portForwardingHelpPage;
	}

	public NetworkGeneralSettingsPortFowardingAddRulePage getPortForwardingAddRulePageObject() {
		NetworkGeneralSettingsPortFowardingAddRulePage portForwardingHAddRulePage = new NetworkGeneralSettingsPortFowardingAddRulePage();
		return portForwardingHAddRulePage;
	}
	
	public NetworkEditPortForwardingRulePage getEditPortForwardingRulePageObject() {
		NetworkEditPortForwardingRulePage editPortForwardingRulePage = new NetworkEditPortForwardingRulePage();
		return editPortForwardingRulePage;
	}

	public FooterIconsPage getFooterIconsPageObject() {
		FooterIconsPage footerIconsPage = new FooterIconsPage();
		return footerIconsPage;
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
			utils.log().info("Clicked on Help Button");
			return true;
		} else {
			utils.log().info("Help Button is not displayed");
			return false;
		}
	}

	public boolean clickAddRuleButton() {
		if (addRuleButton.isDisplayed()) {
			click(addRuleButton);
			utils.log().info("Clicked on Add Rule Button");
			return true;
		} else {
			utils.log().info("Add Rule Button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnPortForwardingPage() {
			utils.log().info("                                                                         ");
			utils.log().info("*************************************************************************");
			utils.log().info("Verifying UI Elements on Network - General Settings Port Forwarding Page ");
			utils.log().info("*************************************************************************");

			try {
				if (portForwardingTitle.isDisplayed())
					utils.log().info(portForwardingTitle.getText() + " title text is displayed ");

				if (backIcon.isDisplayed())
					utils.log().info("Back Icon is displayed ");

				if (helpIcon.isDisplayed())
					utils.log().info("Help Icon is displayed");

				if (addRuleButton.isDisplayed())
					utils.log().info("Add Rule button is displayed");
				return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public boolean verifyPortFowardingRules() {
		utils.log().info("                                         ");
		utils.log().info("*****************************************");
		utils.log().info(" Verifying List of Port Forwarding Rules ");
		utils.log().info("*****************************************");
	
		try {
			for (int i = 1; i <= 3; i++) {
			utils.log().info("Port Forwarding Rule  : " + i);
			utils.log().info("----------------------------");

			List<MobileElement> entity = (List<MobileElement>) super.getDriver()
				.findElementsByXPath("androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["+i+"]/android.widget.FrameLayout/android.widget.LinearLayout");

			for (MobileElement e : entity) {
				if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/description_name']").isDisplayed())
					utils.log().info("Port Forwardig Rule Name is displayed");
				else
					utils.log().info("Port Forwardig Rule Name is not displayed");
				
				if (e.findElementByXPath("//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/edit_btn']").isDisplayed())
					utils.log().info("Port Forwardig Edit Rule Name Icon is displayed");
				else
					utils.log().info("Port Forwardig Edit Rule Name Icon is not displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@text='Protocol']").isDisplayed())
					utils.log().info("Protocol Label is displayed");
				else
					utils.log().info("Protocol Label is not displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/protocol_name']").isDisplayed())
					utils.log().info(e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/protocol_name']").getText() + " Protocol is displayed");
				else
					utils.log().info("Selected Protocol is not displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@text='IP Address']").isDisplayed())
					utils.log().info("IP Address Label is displayed");
				else
					utils.log().info("IP Address Label is not displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/portforwarding_ip_address']").isDisplayed())
					utils.log().info("IP Address : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/portforwarding_ip_address']").getText() + " is displayed");
				else
					utils.log().info("IP Address is not displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@text='Internal Port Range']").isDisplayed())
					utils.log().info("Internal Port Range Label is displayed");
				else
					utils.log().info("Internal Port Range Label is not displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internal_port_range']").isDisplayed())
					utils.log().info("Internal Port Range : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internal_port_range']").getText() + " is displayed");
				else
					utils.log().info("Internal Port Range is not displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@text='External Port Range']").isDisplayed())
					utils.log().info("External Port Range Label is displayed");
				else
					utils.log().info("External Port Range Label is not displayed");
				
				if (e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/external_port_range']").isDisplayed())
					utils.log().info("External Port Range : " + e.findElementByXPath("//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/internal_port_range']").getText() + " is displayed");	
				else
					utils.log().info("External Port Range is not displayed");
			}
		}
			return true;
		}catch(Exception e){
			utils.log().info("No Device found to prioritize");
			return false;
		}
	}

	public boolean clickEditPortFowardingRuleIcon() {
		utils.log().info("                            ");
		utils.log().info("****************************");
		utils.log().info(" Edit Port Forwarding Rules ");
		utils.log().info("****************************");
	
		try {
			for (int i = 1; i <= 1; i++) {
			utils.log().info("Editing Port Forwarding Rule  : " + i);
			utils.log().info("-------------------------------------");

			List<MobileElement> entity = (List<MobileElement>) 
			super.getDriver().findElementsByXPath("//XCUIElementTypeApplication[@name=\"SBC Test\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell["+i+"]");

			for (MobileElement e : entity) {		
				if (e.findElementByXPath("//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_"+i+"\"]").isDisplayed())
					click(e.findElementByXPath("//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_"+i+"\"]"));
				else
					utils.log().info("Port Forwardig Edit Rule Name Icon is not displayed");
			}
		}
			return true;
		}catch(Exception e){
			utils.log().info("No Rule found to edit");
			return false;
		}
	}

	@Override
	public boolean isAt() {
		if (portForwardingTitle.isDisplayed()) {
			utils.log().info("On General Settings Port Fowarding Page");
			return true;
		} else {
			utils.log().info("Not on General Settings Port Fowarding Page");
			return false;
		}
	}
}
