package com.cs.arris.Pages;

import org.openqa.selenium.support.PageFactory;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainDevicePage extends ParentClass implements Page
{
	public TestUtils utils = new TestUtils();
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageButton[@content-desc='Navigate up']"),  //back button
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[0,112][147,259]']")
	})
	public MobileElement backButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtToolBarTitle']"),  //main device name
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[485,149][595,223]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtToolBarTitle") 
	})
	public MobileElement mainDeviceName;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/helpIcon']"),  //help Icon
		@AndroidBy (xpath = "//android.widget.ImageButton[@bounds='[980,153][1046,219]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/helpIcon") 
	})
	public MobileElement helpIcon; 
		
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/img_toolbar_remote_lca"),  
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[909,154][972,217]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/img_toolbar_remote_lca") 
	})
	public MobileElement cloudIcon; 

	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.RadioButton[@resource-id='com.arris.sbcBeta:id/buttonAll']"),  //All tab
		@AndroidBy (xpath = "//android.widget.RadioButton[@bounds='[79,397][541,484]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/buttonAll") 
	})
	public MobileElement allButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/button5Ghz']"),  //5.0 GHz
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[320,422][541,509]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/button5Ghz") 
	})
	public MobileElement fiveGHzButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/button2.4Ghz']"),  //2.4 GHz
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[538,422][759,509]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/button2.4Ghz") 
	})
	public MobileElement twoFourGHzButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/buttonEthernet']"),  //ethernet
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[756,422][978,509]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/buttonEthernet") 
	})
	public MobileElement ethernetButton; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRoutername']"),  //MAIN
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[463,1038][617,1102]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txtRoutername") 
	})
	public MobileElement mainRouterName; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_room_online']"),  //Online or Offline
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[468,1119][612,1172]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_online") 
	})
	public MobileElement mainRouterStatus; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.view.ViewGroup[@resource-id='com.arris.sbcBeta:id/txt_dining_room_led_block']"),  //LED Settings
		@AndroidBy (xpath = "//android.view.ViewGroup[@bounds='[51,1223][1029,1362]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_led_block") 
	})
	public MobileElement ledBlock; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgLedOpenClose']"),  //LED plus icon
		@AndroidBy (xpath = "//android.widget.ImageView[@bounds='[921,1257][995,1328]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/imgLedOpenClose") 
	})
	public MobileElement ledPlusIcon; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.SeekBar[@resource-id='com.arris.sbcBeta:id/seekBar']"),  //seek bar
		@AndroidBy (id = "com.arris.sbcBeta:id/seekBar") 
	})
	public MobileElement seekBar; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/ten_progress_tv']"),  //10
		@AndroidBy (id = "com.arris.sbcBeta:id/ten_progress_tv") 
	})
	public MobileElement ten; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/twenty_progress_tv']"),  //20
		@AndroidBy (id = "com.arris.sbcBeta:id/twenty_progress_tv") 
	})
	public MobileElement twenty; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/thirty_progress_tv']"),  //30
		@AndroidBy (id = "com.arris.sbcBeta:id/thirty_progress_tv") 
	})
	public MobileElement thirty; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/forty_progress_tv']"),  //40
		@AndroidBy (id = "com.arris.sbcBeta:id/forty_progress_tv") 
	})
	public MobileElement fourty; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/fifty_progress_tv']"),  //50
		@AndroidBy (id = "com.arris.sbcBeta:id/fifty_progress_tv") 
	})
	public MobileElement fifty; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/sixty_progress_tv']"),  //60
		@AndroidBy (id = "com.arris.sbcBeta:id/sixty_progress_tv") 
	})
	public MobileElement sixty; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/seventy_progress_tv']"),  //70
		@AndroidBy (id = "com.arris.sbcBeta:id/seventy_progress_tv") 
	})
	public MobileElement seventy; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/eighty_progress_tv']"),  //80
		@AndroidBy (id = "com.arris.sbcBeta:id/eighty_progress_tv") 
	})
	public MobileElement eighty; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/ninety_progress_tv']"),  //90
		@AndroidBy (id = "com.arris.sbcBeta:id/ninety_progress_tv") 
	})
	public MobileElement ninety; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/hundred_progress_tv']"),  //100
		@AndroidBy (id = "com.arris.sbcBeta:id/hundred_progress_tv") 
	})
	public MobileElement hundred; 
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_led_color_title']"),  //Choose Color brightness
		@AndroidBy (xpath = "//android.widget.TextView[@bounds='[222,1519][995,1565]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_led_color_title") 
	})
	public MobileElement colorBrightness;
	
	//**************** MAIN mAX ROUTER DETAILS ******************
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_room_more_detail_block_title']"),  //Details text
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_title") 
	})
	public MobileElement details;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDeviceOpenClose']"),  //Expand to get router details
		@AndroidBy (id = "com.arris.sbcBeta:id/imgDeviceOpenClose") 
	})
	public MobileElement detailsPlusImage;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_room_more_detail_block_channel']"),  //Channel Label
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_channel") 
	})
	public MobileElement channelLabel;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtChannelOne']"),  //Channel Text  [1 Devices ( 5 GHz)]
		@AndroidBy (id = "com.arris.sbcBeta:id/txtChannelOne") 
	})
	public MobileElement channelText;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_room_wan_ip_address']"),  //WAN IP Label
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_wan_ip_address") 
	})
	public MobileElement wanIPLabel;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceWanIp']"),  //Channel Text  [1 Devices ( 5 GHz)]
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDeviceWanIp") 
	})
	public MobileElement wanIP;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceLanIp']"),  //LAN IP Label
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDeviceLanIp") 
	})
	public MobileElement lanIPLabel;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceLanIpA']"),  //LAN IP TExt
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDeviceLanIpA") 
	})
	public MobileElement lanIP;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_room_more_detail_block_mac_add_title']"),  //MAc Address label
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_mac_add_title") 
	})
	public MobileElement macAddressLabel;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceMacAddress']"),  //MAc Address text
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_mac_add_title") 
	})
	public MobileElement macAddressText;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_room_more_detail_block_serial_title']"),  //Serial No.
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_serial_title") 
	})
	public MobileElement serialNumberLabel;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceSerialNum']"),  //Serial No.
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDeviceSerialNum") 
	})
	public MobileElement serialNumberText;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_room_more_detail_block_firmware_title']"),  //Serial No.
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_firmware_title") 
	})
	public MobileElement firnwareLabel;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceFirmware']"),  //AXR.0335.201111.12
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDeviceFirmware") 
	})
	public MobileElement firnwareText;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_dining_room_more_detail_block_model_title']"),  //Model No.
		@AndroidBy (id = "com.arris.sbcBeta:id/txt_dining_room_more_detail_block_model_title") 
	})
	public MobileElement modelNumberLabel;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtDeviceModelNumber']"),  //W31
		@AndroidBy (id = "com.arris.sbcBeta:id/txtDeviceModelNumber") 
	})
	public MobileElement modelNumberText;
	
	//**************** MAIN mAX ROUTER DETAILS ******************
	
	//**************** CONNECTED DEVICES DETAILS ******************
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.arris.sbcBeta:id/recycleViewDiningRoom']"),  //list of devices connected to the main device (router)
		@AndroidBy (id = "com.arris.sbcBeta:id/recycleViewDiningRoom") 
	})
	public MobileElement listOfAllDevicesConnected;
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/devicesNumbers']"),  //Connected Devices (2)
		@AndroidBy (id = "com.arris.sbcBeta:id/devicesNumbers") 
	})
	public MobileElement noOfConnectedDevices;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDevice']")
	public MobileElement deviceImage;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceName']")
	public MobileElement deviceName;
	
	@AndroidFindBy (id = "com.arris.sbcBeta:id/txtSignalStrength")
	public MobileElement deviceSignalStrength;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceDownloadSpeed']")
	public MobileElement deviceDownloadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceUploadSpeed']")
	public MobileElement deviceUploadSpeed;
	
	@AndroidFindBy (xpath = "//android.widget.ImageView[@resource-id='com.arris.sbcBeta:id/imgDeviceInfoOpen']")
	public MobileElement expandButton;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_ip_address']")
	public MobileElement ipAddressLabel;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceIpAddress']")
	public MobileElement deviceIPAddress;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/tv_mac_address']")
	public MobileElement macAddressLabel1;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceMacAddress']")
	public MobileElement deviceMACAddress;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txt_channel']")
	public MobileElement channelLabel1;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtInnerDeviceChannel']")
	public MobileElement deviceChannelNumber;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/txtRssi']")
	public MobileElement rssiLabel;
	
	@AndroidFindBy (xpath = "//android.widget.TextView[@resource-id='com.arris.sbcBeta:id/rssi']")
	public MobileElement deviceRSSIText;
	
	//**************** CONNECTED DEVICES DETAILS ******************
	
	@AndroidFindAll({
		@AndroidBy (xpath = "//android.widget.Button[@resource-id='com.arris.sbcBeta:id/restartRouter']"),  //Restart Router Button
		@AndroidBy (xpath = "//android.widget.Button[@bounds='[51,1839][1029,1976]']"),
		@AndroidBy (id = "com.arris.sbcBeta:id/restartRouter") 
	})
	public MobileElement restartRouterButton;
	 

	
	public MainDevicePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(super.getDriver()), this);
	}
	
	public void clickContinueButton()
	{
		utils.log().info("Congratulations Page - Clicked on Continue Button");
	}
	
	
	
	@Override
	public boolean isAt() {
		super.pause();
		return true;
	}
}
