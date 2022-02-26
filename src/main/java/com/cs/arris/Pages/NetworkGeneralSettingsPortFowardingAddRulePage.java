package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;

public class NetworkGeneralSettingsPortFowardingAddRulePage extends ParentClass implements Page {
	public TestUtils utils = new TestUtils();
	String[] ipAddress = {"192.168.7.101", "192.168.7.102" , "192.168.7.103", "192.168.7.104" , "192.168.7.105"};

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_Close\"]")
	public MobileElement closeButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Label_AddPort\"]")
	public MobileElement portRuletitle;

//	@iOSXCUITFindBy(xpath="")
//	public MobileElement portRuleNameLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Port_Forwarding_Screen_TextField\"]")
	public MobileElement enterPortRuleNameTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Label_Protocol\"]")
	public MobileElement protocolLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_Tcp\"]")
	public MobileElement tcpButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_Udp\"]")
	public MobileElement udpButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_TcpUdpRule\"]")
	public MobileElement tcpUdpButton;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Label_Internal\"]")
	public MobileElement enterInternalPortStartLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Port_Forwarding_Screen_TextField_Internal\"]")
	public MobileElement enterInternalPortStartTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Label_InternalEnd\"]")
	public MobileElement enterInternalPortEndLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Port_Forwarding_Screen_TextField_InternalEnd\"]")
	public MobileElement enterInternalPortEndTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Label_External\"]")
	public MobileElement enterExternalPortStartLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Port_Forwarding_Screen_TextField_External\"]")
	public MobileElement enterExternalPortStartTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Label_ExternalEnd\"]")
	public MobileElement enterExternalPortEndLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Port_Forwarding_Screen_TextField_ExternalEnd\"]")
	public MobileElement enterExternalPortEndTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Label_InternalIP\"]")
	public MobileElement enterInternalIPAddressLabel;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeTextField[@name=\"Port_Forwarding_Screen_TextField_InternalIP\"]")
	public MobileElement enterInternalIPAddressTextBox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_Save\"]")
	public MobileElement saveChangesButton;
	
	//Error messages
	
	//All fields are mandatory
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error0\"]")
	public MobileElement allFieldsAreMandatoryError;
	
	//Please enter Port Forwarding Rule Name.
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Port_Forwarding_Screen_Button_Save\"]")
//	public MobileElement portNameDialogError;
	
	//Port should be in between 1 to 65536
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error1\"]")
	public MobileElement internalPortStartError;
	
	//Port should be in between 1 to 65536
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error2\"]")
	public MobileElement internalPortEndError;
	
	//Start port should be lesser than End port
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error1\"]")
	public MobileElement internalStartPortLessThanEndPort;
	
	//Port should be in between 1 to 65536
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error3\"]")
	public MobileElement externalPortStartError;
	
	//Port should be in between 1 to 65536
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error4\"]")
	public MobileElement externalPortEndError;
	
	//Start port should be lesser than End port
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error3\"]")
	public MobileElement externalStartPortLessThanEndPort;
	
	//Please enter a valid IP Address
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error0\"]")
	public MobileElement enterValidIPAddress;
	
	//IP Address must be within the subnet range.
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText[@name=\"Port_Forwarding_Screen_Button_Label_Error5\"]")
	public MobileElement enterInvalidIPAddress;
	
	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneLink;
	
	
	public NetworkGeneralSettingsPortFowardingAddRulePage() {
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}

	public NetworkPortRuleEditFaliedAlertDialog getPortRuleEditFailedDialogObject() {
		NetworkPortRuleEditFaliedAlertDialog  portRuleEditFailed = new NetworkPortRuleEditFaliedAlertDialog();
		return portRuleEditFailed;
	}
	
	
	public boolean clickCloseButton() {
		if (closeButton.isDisplayed()) {
			click(closeButton);
			utils.log().info("Clicked on Close Button");
			return true;
		} else {
			utils.log().info("Close button is not displayed");
			return false;
		}
	}
	public boolean clickSaveButton() {
		click(doneLink);
		if (saveChangesButton.isDisplayed()) {
			click(saveChangesButton);
			utils.log().info("Clicked on Save Changes Button");
			return true;
		} else {
			utils.log().info("Save Changes button is not displayed");
			return false;
		}
	}

	public boolean verifyUIOnPortForwardingAddRulePage() {
		utils.log().info("                                                                                  ");
		utils.log().info("**********************************************************************************");
		utils.log().info("Verifying UI Elements on Network - General Settings Port Forwarding Add Rule Page ");
		utils.log().info("**********************************************************************************");
		try {
			if (portRuletitle.isDisplayed())
				utils.log().info(portRuletitle.getText() + " title text is displayed ");

			if (closeButton.isDisplayed())
				utils.log().info("Close Icon is displayed ");

			if (enterPortRuleNameTextBox.isDisplayed())
				utils.log().info("Port Forwarding Rule Name text box is displayed ");

			if (protocolLabel.isDisplayed())
				utils.log().info(protocolLabel.getText() + " label is displayed ");

			if (tcpButton.isDisplayed())
				utils.log().info("TCP button is displayed ");

			if (udpButton.isDisplayed())
				utils.log().info("UDP button is displayed ");

			if (tcpUdpButton.isDisplayed())
				utils.log().info("TCP/UDP button is displayed ");

			if (enterInternalPortStartLabel.isDisplayed())
				utils.log().info(enterInternalPortStartLabel.getText() + " label is displayed ");

			if (enterInternalPortStartTextBox.isDisplayed())
				utils.log().info("Enter Internal Port Start text box is displayed ");

			if (enterInternalPortEndLabel.isDisplayed())
				utils.log().info(enterInternalPortEndLabel.getText() + " label is displayed ");

			if (enterInternalPortEndTextBox.isDisplayed())
				utils.log().info("Enter Internal Port End text box is displayed ");

			if (enterExternalPortStartLabel.isDisplayed())
				utils.log().info(enterExternalPortStartLabel.getText() + " label is displayed ");

			if (enterExternalPortStartTextBox.isDisplayed())
				utils.log().info("Enter External Port Start text box is displayed ");

			if (enterExternalPortEndLabel.isDisplayed())
				utils.log().info(enterExternalPortEndLabel.getText() + " label is displayed ");

			if (enterExternalPortEndTextBox.isDisplayed())
				utils.log().info("Enter Internal Port End text box is displayed ");

			if (enterInternalIPAddressLabel.isDisplayed())
				utils.log().info(enterInternalIPAddressLabel.getText() + " label is displayed ");

			if (enterInternalIPAddressTextBox.isDisplayed())
				utils.log().info("Enter Internal IP Address text box is displayed ");

			if (saveChangesButton.isDisplayed())
				utils.log().info("Save button is displayed");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterPortForwardingRuleName() {
		utils.log().info("                                                 ");
		utils.log().info("*************************************************");
		utils.log().info("Verifying Enter Port Forwarding Rule Name Error  ");
		utils.log().info("*************************************************");
		click(doneLink);
		this.clickSaveButton();
		super.pause(2);
		if(allFieldsAreMandatoryError.isDisplayed())
			utils.log().info("Validation Message : " + allFieldsAreMandatoryError.getText() + " is displayed");
		
		String ruleName = super.generatePortRuleName();
		clear(enterPortRuleNameTextBox);
		sendKeys(enterPortRuleNameTextBox, ruleName);
		utils.log().info("Entered Rule Name : " + ruleName);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterInternalPortStart() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Enter Internal Port Start Error   ");
		utils.log().info("********************************************");
		click(doneLink);
		this.clickSaveButton();
		super.pause(2);
		
		if(internalPortStartError.isDisplayed())
			utils.log().info("Validation Message : " + internalPortStartError.getText() + " is displayed");
		
		String internalPortStart = super.generateInternalPortStart();
		clear(enterInternalPortStartTextBox);
		sendKeys(enterInternalPortStartTextBox, internalPortStart);
		utils.log().info("Entered Internal Port Start : " + internalPortStart);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterInternalPortEnd() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Enter Internal Port End Error   ");
		utils.log().info("********************************************");
		click(doneLink);
		this.clickSaveButton();
		super.pause(2);
		
		if(internalPortEndError.isDisplayed())
			utils.log().info("Validation Message : " + internalPortEndError.getText() + " is displayed");
		
		int startPort1 = Integer.valueOf(enterInternalPortStartTextBox.getText());
		String internalPortEnd = String.valueOf(startPort1 -= 5);
		clear(enterInternalPortEndTextBox);
		sendKeys(enterInternalPortEndTextBox, internalPortEnd);
		utils.log().info("Entered Internal Port End : " + internalPortEnd);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyInternalPortStartLessThenPortEnd() {
		utils.log().info("                                                                 ");
		utils.log().info("*****************************************************************");
		utils.log().info("Verifying Internal Port Start Should Be Less Than Port End Error ");
		utils.log().info("*****************************************************************");
		click(doneLink);
		this.clickSaveButton();
		super.pause(2);
		
		if(internalStartPortLessThanEndPort.isDisplayed())
			utils.log().info("Validation Message : " + internalStartPortLessThanEndPort.getText() + " is displayed");
		String internalPortEnd = super.generateInternalPortEnd();
		clear(enterInternalPortEndTextBox);
		sendKeys(enterInternalPortEndTextBox, internalPortEnd);
		utils.log().info("Entered Internal Port End greater than Internal Port Start : " + internalPortEnd);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterExternalPortStart() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Enter External Port Start Error   ");
		utils.log().info("********************************************");
		click(doneLink);
		this.clickSaveButton();
		super.pause(2);
		
		if(externalPortStartError.isDisplayed())
			utils.log().info("Validation Message : " + externalPortStartError.getText() + " is displayed");
		
		String externalPortStart = super.generateExternalPortStart();
		sendKeys(enterExternalPortStartTextBox, externalPortStart);
		utils.log().info("Entered External Port Start : "+ externalPortStart);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterExternalPortEnd() {
		utils.log().info("                                            ");
		utils.log().info("********************************************");
		utils.log().info("Verifying Enter External Port End Error     ");
		utils.log().info("********************************************");
		click(doneLink);
		this.clickSaveButton();
		super.pause(2);
		
		if(externalPortEndError.isDisplayed())
			utils.log().info("Validation Message : " + externalPortEndError.getText() + " is displayed");
		
		String externalPortEnd = super.generateExternalPortEnd();
		
		int startPort1 = Integer.valueOf(enterExternalPortStartTextBox.getText());
		String externalPortEnd1 = String.valueOf(startPort1 -= 5);
		clear(enterExternalPortEndTextBox);
		sendKeys(enterExternalPortEndTextBox, externalPortEnd1);
		utils.log().info("Entered External Port End : " + externalPortEnd1);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyExternalPortStartLessThenPortEnd() {
		utils.log().info("                                                                 ");
		utils.log().info("*****************************************************************");
		utils.log().info("Verifying External Port Start Should Be Less Than Port End Error ");
		utils.log().info("*****************************************************************");
		click(doneLink);
		this.clickSaveButton();
		super.pause(2);
		
		if(externalStartPortLessThanEndPort.isDisplayed())
			utils.log().info("Validation Message : " + externalStartPortLessThanEndPort.getText() + " is displayed");
		String externalPortEnd = super.generateExternalPortEnd();
		clear(enterExternalPortEndTextBox);
		sendKeys(enterExternalPortEndTextBox, externalPortEnd);
		utils.log().info("Entered External Port End greater than External Port Start" + externalPortEnd);
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterValidIPAddress() {
		utils.log().info("                                        ");
		utils.log().info("****************************************");
		utils.log().info("Verifying Enter Valid IP Address Error  ");
		utils.log().info("****************************************");
		click(doneLink);
		this.clickSaveButton();
		super.pause(2);
		
		if(enterValidIPAddress.isDisplayed())
			utils.log().info("Validation Message : " + enterValidIPAddress.getText() + " is displayed");
		//enter invalid IP address
		return true;
	}
	
	//Click Save Changes without entering any data
	public boolean verifyEnterInValidIPAddress() {
		utils.log().info("                                                            ");
		utils.log().info("************************************************************");
		utils.log().info("Verifying Enter Valid IP Address Within Subnet Range Error  ");
		utils.log().info("************************************************************");
		
		click(doneLink);
		sendKeys(enterInternalIPAddressTextBox, "127.0.0.1");
		utils.log().info("Entered Invalid IP Address : 127.0.0.1");
		click(doneLink);
		this.clickSaveButton();
		
		if(enterInvalidIPAddress.isDisplayed())
			utils.log().info("Validation Message : " + enterInvalidIPAddress.getText() + " is displayed");
		
		click(doneLink);
		clear(enterInternalIPAddressTextBox);
		sendKeys(enterInternalIPAddressTextBox, super.generateIPAdress());
		utils.log().info("Entered valid IP Address");
		
		super.getDriver().hideKeyboard();
		this.clickSaveButton();
		super.pause(10);
		return true;
	}
	
	public boolean selectTCP() {
		if(tcpButton.isDisplayed())
			click(tcpButton);
		return true;
	}
	
	public boolean selectUDP() {
		if(udpButton.isDisplayed())
			click(udpButton);
		return true;
	}
	
	public boolean selectTCPUDP() {
		if(tcpUdpButton.isDisplayed())
			click(tcpUdpButton);
		return true;
	}
	
	public boolean enterPortRuleName() {
		clear(enterPortRuleNameTextBox);
		if(enterPortRuleNameTextBox.isDisplayed())
			sendKeys(enterPortRuleNameTextBox, super.generatePortRuleName());
		utils.log().info("Enterted Port Rule Name : " + enterPortRuleNameTextBox.getText());
		click(doneLink);
		return true;
	}
	
	public boolean enterInternalPortStart() {
		clear(enterInternalPortStartTextBox);
		if(enterInternalPortStartTextBox.isDisplayed())
			sendKeys(enterInternalPortStartTextBox, super.generateInternalPortStart());
		utils.log().info("Enterted Internal Port Start : " + enterInternalPortStartTextBox.getText());
		click(doneLink);
		return true;
	}
	
	public boolean enterInternalPortEnd() {
		clear(enterInternalPortEndTextBox);
		if(enterInternalPortEndTextBox.isDisplayed())
			sendKeys(enterInternalPortEndTextBox, super.generateInternalPortEnd());
		utils.log().info("Enterted Internal Port End : " + enterInternalPortEndTextBox.getText());
		click(doneLink);
		return true;
	}
	
	public boolean enterExternalPortStart() {
		clear(enterExternalPortStartTextBox);
		if(enterExternalPortStartTextBox.isDisplayed())
			sendKeys(enterExternalPortStartTextBox, super.generateExternalPortStart());
		utils.log().info("Enterted External Port Start : " + enterExternalPortStartTextBox.getText());
		click(doneLink);
		return true;
	}
	
	public boolean enterExternalPortEnd() {
		clear(enterExternalPortEndTextBox);
		if(enterExternalPortEndTextBox.isDisplayed())
			sendKeys(enterExternalPortEndTextBox, super.generateExternalPortEnd());
		utils.log().info("Enterted External Port Stop : " + enterExternalPortEndTextBox.getText());
		click(doneLink);
		return true;
	}
	
	public boolean enterIPAddress() {
		clear(enterInternalIPAddressTextBox);
		if(enterInternalIPAddressTextBox.isDisplayed())
			sendKeys(enterInternalIPAddressTextBox, super.generateIPAdress());
		utils.log().info("Enterted IP Address : " + enterInternalIPAddressTextBox.getText());
		click(doneLink);
		return true;
	}
	
	
	
	@Override
	public boolean isAt() {
		if (portRuletitle.isDisplayed()) {
			utils.log().info("On Port Forwarding Add Rule Page");
			return true;
		} else {
			utils.log().info("Not on Port Forwarding Add Rule Page");
			return false;
		}
	}
}
