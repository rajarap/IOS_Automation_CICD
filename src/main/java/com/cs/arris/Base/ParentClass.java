package com.cs.arris.Base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.cs.arris.Reports.ExtentReport;
import com.cs.arris.Utilities.Direction;
import com.cs.arris.Utilities.SwipeActions;
import com.cs.arris.Utilities.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.SupportsNetworkStateManagement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ParentClass 
{
	public Properties properties = new Properties();
	
	protected static ThreadLocal <AppiumDriver<MobileElement>> appiumDriver = new ThreadLocal<AppiumDriver<MobileElement>>();
	protected static ThreadLocal <Properties> props = new ThreadLocal<Properties>();
	protected static ThreadLocal <HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <HashMap<String, String>> errorcode = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <HashMap<String, String>> testdata = new ThreadLocal<HashMap<String, String>>();
	protected static ThreadLocal <String> platformName = new ThreadLocal<String>();
	protected static ThreadLocal <String> deviceName = new ThreadLocal<String>();
	protected static ThreadLocal <String> dateTime = new ThreadLocal<String>();
//	protected static ThreadLocal <Properties> otpEmailprops = new ThreadLocal<Properties>();
	private static AppiumDriverLocalService server;
	
	TestUtils utils = new TestUtils();
	public AndroidDriver andDriver ;
	public AppiumDriver<MobileElement> driver;
	public AndroidDriver<MobileElement> androidDriver;
	public DesiredCapabilities desiredCapabilities ;
	public URL url;
	public InputStream inputStream = null;
	public InputStream stringsis = null;
	public InputStream errorCode = null;
	public InputStream testData = null;
	
	public String pltName;
	public String dvcName;
	public File ssFile;
	public String OTP;
	public String mainDevice;
	public String device1;
	public String device2;
	public String deviceStatus;
	public String ssidNumber;
//	public String ssidName;
//	public String ssidpwd;
	public String randNum;
	public String profileName;
	public String ruleName;
	public String editedDeviceName;
	public String editedMainDeviceName;
	public String memberName;
	public int noOfDevices;
	public int randNumber;
	public int ipNumber;
	public int devicesConnectedToRouter;
	public List<String> profileNames = new ArrayList<String>();
	public List<String> selectedProfileNames = new ArrayList<String>();
	public List<String> deviceNames = new ArrayList<String>();
	public List<String> lanIPRuleName = new ArrayList<String>();
//	public String[] logEmailids = {"prabhu.rajarathinam@mobileprogramming.com", "prabhu.rajarathinam@commscope.com"};
	public String[] logEmailids;
	
	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	
//	@BeforeSuite
//	public void beforeSuite() throws Exception
//	{
//		setConfigProperties();
//		ThreadContext.put("ROUTINGKEY", "ServerLogs");
//		server = getAppiumService();
//		if(!checkIfAppiumServerIsRunnning(4723)) {
//			server.start();
//			server.clearOutPutStreams();
//			System.out.println("***************   Appium server started   **************");
//			utils.log().info("Appium server started");
//		} else {
//			utils.log().info("Appium server already running");
//		}	
//	}
//	
	public ParentClass() 
	{ 
		
	}
	
	@AfterSuite
	public void afterSuite() 
	{
		if (stringsis != null)
		try {
			stringsis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (errorCode != null)
			try {
				errorCode.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		if (testData != null)
			try {
				testData.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		utils.log().info("Closing App");
		getDriver().closeApp();
		utils.log().info("Quitting Driver");
		getDriver().quit();
		
		server.stop();
		utils.log().info("Appium server stopped");
		
	}
	
	public AppiumDriverLocalService getAppiumServerDefault() {
		return AppiumDriverLocalService.buildDefaultService();
	}
	
	public AppiumDriverLocalService getAppiumService() {
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("PATH",  "/Users/prabhu/.fastlane/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Library/Apple/usr/bin:/opt/homebrew/bin:/opt/homebrew/Cellar/openjdk@11/11.0.10/libexec/openjdk.jdk/Contents/Home/bin:/Users/prabhu/Library/Android/sdk:/Applications/sonar-scanner/bin:/Applications/sonarqube/bin:/usr/bin/ruby:/usr/local/bin/pod");
		environment.put("ANDROID_HOME", "/Users/prabhu/Library/Android/sdk");
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingPort(4723)
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.withEnvironment(environment)
				.withLogFile(new File("ServerLogs/server.log")));
	}
	
	@Parameters({"platform", "device"})
	@BeforeSuite
	public void beforeSuite(String platform, String device) throws Exception
	{
		setConfigProperties();
		ThreadContext.put("ROUTINGKEY", "ServerLogs");
		server = getAppiumService();
		if(!checkIfAppiumServerIsRunnning(4723)) {
			server.start();
			server.clearOutPutStreams();
			System.out.println("***************   Appium server started   **************");
			utils.log().info("Appium server started");
		} else {
			utils.log().info("Appium server already running");
		}	
		
		
		
		this.pltName = platform;
		this.dvcName = device;
		
		try
		{
			setConfigProperties();
			setDateTime(utils.dateTime());
			setPlatformName(this.pltName);
			setDeviceName(this.dvcName);
			
			//Load strings.xml, error_code.xml and logs
			loadStringsXML("strings/strings.xml");
			loadErrorCodesXML("error_codes/error_codes.xml");
			loadLogs();
		
			//Fetch url from config.properties file. setProps already set in BeforeSuite
			url = new URL(getProps().getProperty("appiumURL"));       //http://127.0.0.1:4723/wd/hub
			
			//set the DesiredCapabilites of the device
			desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getPlatformName());
			desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getDeviceName());
			
			if(getPlatformName().equalsIgnoreCase("Android"))
			{
				utils.log().info("Setting " + getPlatformName() + " driver capabilities");
				desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getProps().getProperty("androidAutomationName"));
				desiredCapabilities.setCapability(MobileCapabilityType.UDID, getProps().getProperty("androidUDID"));
				desiredCapabilities.setCapability(MobileCapabilityType.VERSION, getProps().getProperty("androidVersion"));
				desiredCapabilities.setCapability(MobileCapabilityType.APP, getProps().getProperty("androidAppLocation"));
				desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
				desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, getProps().getProperty("timeout"));
				driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
				setDriver(driver);
				getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				utils.log().info("Android Driver is set to the Thread Local context " + getDriver().getPlatformName());
				utils.log().info(getPlatformName() + " driver initialized: "); 
			}
			if(getPlatformName().equalsIgnoreCase("iOS"))
			{
				utils.log().info("Setting " + getPlatformName() + " driver capabilities");
				desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
				desiredCapabilities.setCapability(MobileCapabilityType.SUPPORTS_ALERTS, true);				
				desiredCapabilities.setCapability(IOSMobileCapabilityType.PLATFORM_NAME, getProps().getProperty("iOSPlatformName"));
				desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getProps().getProperty("iOSPlatformVersion"));
				desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getProps().getProperty("iOSAutomationName"));
				desiredCapabilities.setCapability(MobileCapabilityType.UDID, getProps().getProperty("iOSUDID"));
				//desiredCapabilities.setCapability(MobileCapabilityType.APP, getProps().getProperty("iOSAppLocation"));
				desiredCapabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getProps().getProperty("iOSBundleId"));
				desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, getProps().getProperty("xcodeOrgId"));
				desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, getProps().getProperty("timeout"));
				//desiredCapabilities.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, getProps().getProperty("updatedWDABundleId"));
				//desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, getProps().getProperty("xcodeSigningId"));	
				setDriver(new IOSDriver<MobileElement>(url, desiredCapabilities));
				getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				utils.log().info("iOS Driver is set to the Thread Local context " + getDriver().getPlatformName());
				utils.log().info(getPlatformName() + " driver initialized: "); 
			}
		}catch (Exception e) 
		{
		  utils.log().fatal("Unable to initialize " + getPlatformName() + " driver...... ABORTING !!!\n" + e.toString());
		} 
	}
	
	public boolean checkIfAppiumServerIsRunnning(int port) throws Exception {
	    boolean isAppiumServerRunning = false;
	    ServerSocket socket;
	    try {
	        socket = new ServerSocket(port);
	        socket.close();
	    } catch (IOException e) {
	    	System.out.println("1");
	        isAppiumServerRunning = true;
	    } finally {
	        socket = null;
	    }
	    return isAppiumServerRunning;
	}
	
		@BeforeTest
		public void beforeTest()
		{
			launchApp();
		}
	
		@AfterTest
		public void afterTest() 
		{
			closeApp();
		}
	
	  public void loadLogs() throws Exception 
	  {
		  String strFile = "logs" + File.separator + getPlatformName() + "_" + getUDID() + File.separator + utils.onlyDate();
			File logFile = new File(strFile);
			if (!logFile.exists()) {
				logFile.mkdirs();
			}
			//route logs to separate file for each thread
			ThreadContext.put("ROUTINGKEY", strFile);
			utils.log().info("log path: " + strFile);
	 }
	  
	  public void setConfigProperties()
	  {
			//load config.properties and assign properties object to properties ThreadLocal
			String propFileName = "config.properties";
			utils.log().info("loading... " + propFileName);
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			setProps(properties);
			utils.log().info("Config.properties object is set to Thread Local");
	  }
	  
	  public void loadTestData(String filePath)
	  {
			//load the json file and assign strings object to strings ThreadLocal
			try 
			{
				String dataFilename = filePath; 
				utils.log().info("loading..." + dataFilename);
				testData = getClass().getClassLoader().getResourceAsStream(dataFilename);
				properties.load(testData);
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  public void loadStringsXML(String stringsFile)
	  {
			//load the strings.xml file and assign strings object to strings ThreadLocal
			try 
			{
				String xmlFileName = stringsFile; 
				utils.log().info("loading... " + xmlFileName);
				stringsis = getClass().getClassLoader().getResourceAsStream(xmlFileName);
				setStrings(utils.parseStringXML(stringsis));
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  public void loadErrorCodesXML(String errorFile)
	  {
			//load the strings.xml file and assign strings object to strings ThreadLocal
			try 
			{
				String xmlFileName = errorFile; 
				utils.log().info("loading... " + xmlFileName);
				errorCode = getClass().getClassLoader().getResourceAsStream(xmlFileName);
				setErrorCode(utils.parseStringXML(errorCode));
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  
	public AppiumDriver<?> getDriver() { return appiumDriver.get(); }
	
	public void setDriver(AppiumDriver<MobileElement> driver) { appiumDriver.set(driver); }
	
	public Properties getProperties() { return props.get(); }
	
	public void setProperties(Properties properties) { props.set(properties); }
	
	public HashMap<String, String> getStrings() { return strings.get(); }
	  
	public void setStrings(HashMap<String, String> strings2) { strings.set(strings2); }
	
	public HashMap<String, String> getErrorCode() { return errorcode.get(); }
	  
	public void setErrorCode(HashMap<String, String> errorcode2) { errorcode.set(errorcode2); }
	
	public String getPlatformName() { return platformName.get(); }
	  
	public void setPlatformName(String platform2) { platformName.set(platform2); }
	
	public String getUDID() { return getProps().getProperty("iOSUDID"); }
	  
	public String getDateTime() { return dateTime.get(); }
	  
	public void setDateTime(String dateTime2) { dateTime.set(dateTime2); }
	  
	public String getDeviceName() { return deviceName.get(); }
	  
	public void setDeviceName(String deviceName2) { deviceName.set(deviceName2); }
	
	public Properties getProps() { return props.get(); }
	 
	public void setProps(Properties props2) { props.set(props2); }
	
//	public Properties getOtpProps() { return otpEmailprops.get(); }
//	 
//	public void setOtpProps(Properties otpProps) { otpEmailprops.set(otpProps); }
	
	@BeforeMethod
	public void beforeMethod() 
	{
		((CanRecordScreen) getDriver()).startRecordingScreen();
	}
	
	//stop video capturing and create *.mp4 file
	@AfterMethod
	public synchronized void afterMethod(ITestResult result) throws Exception 
	{
		String media = ((CanRecordScreen) getDriver()).stopRecordingScreen();
		
		Map <String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();		
		String dirPath = "videos" + File.separator + params.get("platform") + "_" + getUDID() 
		+ File.separator + getDateTime() + File.separator + result.getTestClass().getRealClass().getSimpleName();
		
		File videoDir = new File(dirPath);
		
		synchronized(videoDir){
			if(!videoDir.exists()) {
				videoDir.mkdirs();
			}	
		}
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
			stream.write(Base64.decodeBase64(media));
			stream.close();
			utils.log().info("video path: " + videoDir + File.separator + result.getName() + ".mp4");
		} catch (Exception e) {
			utils.log().error("error during video capture" + e.toString());
		} finally {
			if(stream != null) {
				stream.close();
			}
		}		
	}
	
	 public void waitForVisibility(MobileElement e) {
		  WebDriverWait wait = new WebDriverWait(getDriver(), TestUtils.WAIT);
		  wait.until(ExpectedConditions.visibilityOf(e));
	  }
	  
	  public void waitForVisibility(WebElement e){
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
		  .withTimeout(Duration.ofSeconds(30))
		  .pollingEvery(Duration.ofSeconds(5))
		  .ignoring(NoSuchElementException.class);
		  
		  wait.until(ExpectedConditions.visibilityOf(e));
		  }
	  
	  public void clear(MobileElement e) {
		  waitForVisibility(e);
		  e.clear();
	  }
	   
	  public void click(MobileElement e) {
		  waitForVisibility(e);
		  e.click();
	  }
	  
	  public void click(MobileElement e, String msg) {
		  waitForVisibility(e);
		  utils.log().info(msg);
		  ExtentReport.getTest().log(Status.INFO, msg);
		  e.click();
	  }
	  
	  public void sendKeys(MobileElement e, String txt) {
		  waitForVisibility(e);
		  e.sendKeys(txt);
	  }
	  
	  public void sendKeys(MobileElement e, String txt, String msg) {
		  waitForVisibility(e);
		  utils.log().info(msg);
		  ExtentReport.getTest().log(Status.INFO, msg);
		  e.sendKeys(txt);
	  }
	  
	  public String getAttribute(MobileElement e, String attribute) {
		  waitForVisibility(e);
		  return e.getAttribute(attribute);
	  }
	  
	  public void click(WebElement w) {
	  waitForVisibility(w);
	  w.click();
  }
	  
//	  public String getText(MobileElement e, String msg) {
//		  String txt = null;
//		  switch(getPlatformName()) {
//		  case "Android":
//			  txt = getAttribute(e, "text");
//			  break;
//		  case "iOS":
//			  txt = getAttribute(e, "label");
//			  break;
//		  }
//		  utils.log().info(msg + txt);
//		  ExtentReport.getTest().log(Status.INFO, msg);
//		  return txt;
//	  }
	  
//	  public MobileElement scrollToElement() 
//	  {	  
//			return (MobileElement) ((FindsByAndroidUIAutomator<?>) getDriver()).findElementByAndroidUIAutomator(
//					"new UiScrollable(new UiSelector()" + ".scrollable(true)).scrollIntoView("
//							+ "new UiSelector().description(\"test-Price\"));");
//	  }
	  public void scrollToElementById(MobileElement id) 
	  {
		   MobileElement obj = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"+
				  						".scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\" + id + \"));"));
		   waitForVisibility(obj); 
	  }
	  
	  public void scrollToElementByXpath(MobileElement id) 
	  {
		   MobileElement obj = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"+
				  						".scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\" + id + \"));"));
		   waitForVisibility(obj); 
	  }
	  
	  public void iOSScrollToElement() {
		  RemoteWebElement element = (RemoteWebElement)getDriver().findElement(By.name("test-ADD TO CART"));
		  String elementID = element.getId();
		  HashMap<String, String> scrollObject = new HashMap<String, String>();
		  scrollObject.put("element", elementID);
//		  scrollObject.put("direction", "down");
//		  scrollObject.put("predicateString", "label == 'ADD TO CART'");
//		  scrollObject.put("name", "test-ADD TO CART");
		  scrollObject.put("toVisible", "sdfnjksdnfkld");
		  getDriver().executeScript("mobile:scroll", scrollObject);
	  }

	  public void closeApp() {
		  ((InteractsWithApps) getDriver()).closeApp();
	  }
	  
	  public void launchApp() {
		  ((InteractsWithApps) getDriver()).launchApp();
	  }
	  
	  public void takeScreenshot(String methodName, ITestResult result) 
	  {
		  	System.setProperty("org.uncommons.reportng.escape-output", "false");
		  	String ssPath = "Screenshots" + File.separator + getPlatformName() + "_" + getUDID() + File.separator + utils.onlyDate();
			ssFile = new File(ssPath);
			if (!ssFile.exists()) 
			{
				ssFile.mkdirs();
			}
			File file  = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
			    try {
			        FileUtils.copyFile(file, new File(ssFile.getAbsolutePath() + File.separator + result.getTestClass().getRealClass().getSimpleName() + File.separator + methodName + ".jpg"));
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			    Reporter.log("<a href = " + ssFile.getAbsolutePath() + File.separator + result.getTestClass().getRealClass().getSimpleName() + File.separator + methodName + ".jpg" + ">screenshot</a>");
		}
	  

		public void toggleWiFI()
		{
			((AndroidDriver) this.getDriver()).toggleWifi();
		}

		 
		 public void pause()
		 {
			 try {
				 getDriver().manage().timeouts().pageLoadTimeout(TestUtils.WAIT, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 
		 public void pause(int sec)
		 {
			try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
		 
		 public void swipeUp()
		 {
			 new SwipeActions().swipeScreen(Direction.UP);
		 }
		 
		 public void swipeDown()
		 {
			 new SwipeActions().swipeScreen(Direction.DOWN);
		 }
		 
		 public Integer getCountOfRulesWithSpace(String noOfRulessText) 
			{
				//Rules (2)
				String rules = noOfRulessText.trim(); 
				int length = rules.length();
				if (length == 9)//Rules (12)
				{
					return Integer.valueOf(rules.substring(7, 8));
				} else
				{
					return Integer.valueOf(rules.substring(7, 9));
				}
			}

		public Integer getCountOfDevicesWithSpace(String noOfDevicesText) 
		{
			//From Home page Devices (2)
			String text = noOfDevicesText.replaceAll("\\p{P}", "");
			String[] devices = text.trim().split("");  //3
			return Integer.valueOf(devices[1]);
		}
		
		public Integer getCountOfDevices(String noOfDevicesText) 
		{
			String devices = noOfDevicesText.trim(); 
			int length = devices.length();
			if (length == 11)//Devices (2)
			{
				return Integer.valueOf(devices.substring(9, 10));
			}
			else
			{
				//Devices (12)
				return Integer.valueOf(devices.substring(9, 11));
			}
		}
		
		public Integer getTotalDevicesAdded(String noOfDevicesText) 
		{
			String devices = noOfDevicesText.trim(); 
			int length = devices.length();
			if (length == 21)//1 Total Devices Added - 21
			{
				return Integer.valueOf(devices.substring(0, 1));
			}
			else
			{
				//12 Total Devices Added - 22
				return Integer.valueOf(devices.substring(0, 2));
			}
		}
		
		public Integer getDeviceSignalStrengthCount(String numberOfDevicesText1) {
			// 02 Devices
			String devices = numberOfDevicesText1;
			if (devices.startsWith("0")) {
				return Integer.valueOf(devices.substring(1, 2));
			} else {
				return Integer.valueOf(devices.substring(0, 2));
			}
		}
		
//		public void generateSSIDNameAndPassword()
//		{
//			 Integer randomNumber = (int)(Math.random()*900)+100;
//			 ssidNumber = String.valueOf(randomNumber);
//			 ssidName = "arrisw31-"+ssidNumber;
//			 ssidpwd = "1234567890";
//		}
		
		public void generateProfileName()
		{
			//Integer randomNumber = (int)(Math.random()*9000)+1000;
			Random r = new Random();
			int low = 10;
			int high = 100;
			int result = r.nextInt(high-low) + low;
			randNum = String.valueOf(result);
			profileName = "profile"+ randNum;
			profileNames.add(profileName);
		}
		
		public String generateRouterSSID()
		{
			Random r = new Random();
			int low = 100;
			int high = 999;
			int result = r.nextInt(high-low) + low;
			randNum = String.valueOf(result);
			String routerName = "arrisW31-"+ randNum;
			utils.log().info("Name generated : " + routerName);
			return routerName;
		}
		
		public String generatePortRuleName()
		{
			Random r = new Random();
			int low = 10;
			int high = 3000;
			int result = r.nextInt(high-low) + low;
			randNum = String.valueOf(result);
			String portRuleName = "PR"+ randNum;
			return portRuleName;
		}
		
		public String generateGuestNetworkeName()
		{
			Random r = new Random();
			int low = 10;
			int high = 999;
			int result = r.nextInt(high-low) + low;
			randNum = String.valueOf(result);
			String guestNet = "guestNet"+ randNum;
			return guestNet;
		}
		
		public String generateInternalPortStart()
		{
			Random r = new Random();
			int low = 1001;
			int high = 15000;
			int result = r.nextInt(high-low) + low;
			return String.valueOf(result);
		}
		
		public String generateInternalPortEnd()
		{
			Random r = new Random();
			int low = 15001;
			int high = 30000;
			int result = r.nextInt(high-low) + low;
			return String.valueOf(result);
		}
		
		public String generateExternalPortStart()
		{
			Random r = new Random();
			int low = 30001;
			int high = 45000;
			int result = r.nextInt(high-low) + low;
			return String.valueOf(result);
		}
		
		public String generateExternalPortEnd()
		{
			Random r = new Random();
			int low = 46000;
			int high = 64000;
			int result = r.nextInt(high-low) + low;
			return String.valueOf(result);
		}
		
		public String generateIPAdress()
		{
			Random r = new Random();
			int low = 101;
			int high = 253;
			int result = r.nextInt(high-low) + low;
			randNum = String.valueOf(result);
			String ipAdd = "192.168.7."+ randNum;
			 return ipAdd;
		}
			
		public void generateRandomNumber13()
		{
			int min = 1;
			int max = 2;
			Random rand = new Random();
			randNumber = rand.nextInt(max - min + 1) + min;
		}
		
		//For Network - LAN IP Reservation
		public void generateRuleName()
		{
			Random r = new Random();
			int low = 10;
			int high = 999;
			int result = r.nextInt(high-low) + low;
			 randNum = String.valueOf(result);
			 ruleName = "rule"+ randNum;
			 lanIPRuleName.add(ruleName);
		}
		
		public String generateMemberName()
		{
			Random r = new Random();
			int low = 10;
			int high = 999;
			int result = r.nextInt(high-low) + low;
			 randNum = String.valueOf(result);
			 memberName = "member"+ randNum;
			 return memberName;
			
		}
		
//		//For Network - LAN IP Reservation
//		public String generateGuestNetworkName()
//		{
//			Random r = new Random();
//			int low = 1;
//			int high = 10;
//			int result = r.nextInt(high-low) + low;
//			 randNum = String.valueOf(result);
//			 String guestName = "GuestNet"+ randNum;
//			 return guestName;
//		}
		
		//generate IP between device id between 2 and 254.
		public void generateRandomIPNumber()
		{
			int min = 2;
			int max = 200;
			Random rand = new Random();
			ipNumber = rand.nextInt(max - min + 1) + min;
		}

		public Integer getAllCountOfDevices(String totalDevices) {
			//Connected Devices (3)  Connected Devices (13)
			String text = totalDevices.replaceAll("\\p{P}", "");
			String[] allDevices = text.trim().split(" ");  //3
			return Integer.valueOf(allDevices[2]);
		}
		
		public Integer get5GHzCountOfDevices(String totalDevices) {
			//2 Devices ( 5 GHz)
			String[] allDevices = totalDevices.trim().split(" ");  //2
			return Integer.valueOf(allDevices[0]);
		}
		
		public Integer get24GHzCountOfDevices(String totalDevices) {
			//2 Devices ( 2.4 GHz)
			String[] allDevices = totalDevices.trim().split(" ");  //2
			return Integer.valueOf(allDevices[0]);
		}
		
		public void swipeUserProfile(Direction dir) {
		    Dimension size;
			size = getDriver().manage().window().getSize();
			TouchAction action = new TouchAction(getDriver());

		    int startX = 0;
		    int endX = 0;
		    int startY = 0;
		    int endY = 0;

		    switch (dir) {
		        case LEFT:
		            startY = (int) (size.height / 2);
		            startX = (int) (size.width * 0.08);
		            endX = (int) (size.width * 0.70);
		            action.press(PointOption.point(260, 400)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(120, 400)).release().perform();

		            break;
		    }
		}
		
		public void swipeMinutes(Direction dir) {
		    Dimension size;
			size = getDriver().manage().window().getSize();
			TouchAction action = new TouchAction(getDriver());

		    int startX = 0;
		    int endX = 0;
		    int startY = 0;
		    int endY = 0;

		    switch (dir) {
		        case UP:
		            startY = (int) (size.height / 2);
		            startX = (int) (size.width * 0.08);
		            endX = (int) (size.width * 0.70);
		            action.press(PointOption.point(184, 660)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(184, 626)).release().perform();

		            break;
		    }
		}
		
		public void swipeWhosHomeNotificationMinutes(Direction dir) {
		    Dimension size;
			size = getDriver().manage().window().getSize();
			TouchAction action = new TouchAction(getDriver());

		    int startX = 0;
		    int endX = 0;
		    int startY = 0;
		    int endY = 0;

		    switch (dir) {
		        case UP:
		            startY = (int) (size.height / 2);
		            startX = (int) (size.width * 0.08);
		            endX = (int) (size.width * 0.70);
		            action.press(PointOption.point(183, 685)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(183, 625)).release().perform();

		            break;
		    }
		}
		
		public void swipeAssocaitedDevices(Direction dir) {
		    Dimension size;
			size = getDriver().manage().window().getSize();
			TouchAction action = new TouchAction(getDriver());

		    int startX = 0;
		    int endX = 0;
		    int startY = 0;
		    int endY = 0;

		    switch (dir) {
		        case LEFT:
		            startY = (int) (size.height / 2);
		            startX = (int) (size.width * 0.08);
		            endX = (int) (size.width * 0.70);
		            action.press(PointOption.point(275, 422)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(127, 422)).release().perform();

		            break;
		    }
		}
		
		public void swipeAssocaitedRules(Direction dir) {
		    Dimension size;
			size = getDriver().manage().window().getSize();
			TouchAction action = new TouchAction(getDriver());

		    int startX = 0;
		    int endX = 0;
		    int startY = 0;
		    int endY = 0;

		    switch (dir) {
		        case LEFT:
		            startY = (int) (size.height / 2);
		            startX = (int) (size.width * 0.08);
		            endX = (int) (size.width * 0.70);
		            action.press(PointOption.point(250, 555)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(140, 555)).release().perform();

		            break;
		    }
		}
		
		public void swipeConnectedDevices(Direction dir) {
		    Dimension size;
			size = getDriver().manage().window().getSize();
			TouchAction action = new TouchAction(getDriver());

		    int startX = 0;
		    int endX = 0;
		    int startY = 0;
		    int endY = 0;

		    switch (dir) {
		        case RIGHT:
		            startY = (int) (size.height / 2);
		            startX = (int) (size.width * 0.90);
		            endX = (int) (size.width * 0.05);
		            action.press(PointOption.point(427, 878)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(427, 554)).release().perform();

		            break;

		        case LEFT:
		            startY = (int) (size.height / 2);
		            startX = (int) (size.width * 0.08);
		            endX = (int) (size.width * 0.70);
		            action.press(PointOption.point(245, 392)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
		                    .moveTo(PointOption.point(120, 392)).release().perform();

		            break;

		        case UP:
		            endY = (int) (size.height * 0.50);
		            startY = (int) (size.height * 0.10);
		            startX = (size.width / 2);
		            action.press(PointOption.point(169, 492)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
                    .moveTo(PointOption.point(1697, 200)).release().perform();
		            break;


		        case DOWN:
		            startY = (int) (size.height * 0.70);
		            endY = (int) (size.height * 0.30);
		            startX = (size.width / 2);
		            action.press(PointOption.point(427, 878)).waitAction( WaitOptions.waitOptions(Duration.ofMillis(1300)))
                    .moveTo(PointOption.point(427, 554)).release().perform();

		            break;
		    }
		}
		
}
	
	
	
	
	







	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//Switch based on platform name
//	switch (getPlatformName())
//	{
//		case "Android":
//			System.out.println("Inside Android DesiredCapabilities...Platform Name ---> : " + getPlatformName());
//			desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getProps().getProperty("androidAutomationName"));
//			desiredCapabilities.setCapability(MobileCapabilityType.UDID, getProps().getProperty("androidUDID"));
//			desiredCapabilities.setCapability(MobileCapabilityType.VERSION, getProps().getProperty("androidVersion"));
//			desiredCapabilities.setCapability(MobileCapabilityType.APP, getProps().getProperty("androidAppLocation"));
//			driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
//			System.out.println("=======> "+ driver.getPlatformName());
//			break;
//		default:
//			throw new Exception("Invalid platform! - " + getPlatformName());
//	}
//	setDriver(driver);
//	utils.log().info("driver initialized: " + getDriver()); 
//	PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
//}catch (Exception e) {
//	  utils.log().fatal("driver initialization failure. ABORT!!!\n" + e.toString());
//  } finally {
//	  if(inputStream != null) {
//		  try {
//			inputStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	  }
//	  if(stringsis != null) {
//		  try {
//			stringsis.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	  }
//  }
