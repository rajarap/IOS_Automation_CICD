//package com.cs.arris.Tests;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeClass;
//
//import java.io.File;
//import java.io.InputStream;
//import java.lang.reflect.Method;
//import java.util.function.Function;
//
//import org.testng.Assert;
//import org.testng.AssertJUnit;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import org.testng.asserts.IAssert;
//
//import com.cs.arris.Base.ParentClass;
//import com.cs.arris.COR.COR_EC_0005_1200_Disconnect_Bluetooth_On_Mobile_Device;
//import com.cs.arris.JsonMappers.Signin_TestData;
//import com.cs.arris.Pages.BlueToothPage;
//import com.cs.arris.Utilities.TestUtils;
//import com.cs.arris.Workflows.TC01_EC_0001_1201_Disconnect_Bluetooth_On_Mobile_Workflow;
//import com.cs.arris.Workflows.TC51_Signin_And_Onboard_Workflow;
//
//import io.appium.java_client.android.AndroidDriver;
//
//
//
//public class COR_TC01_EC_0005_1200_Disconnect_Bluetooth_On_Mobile_Device_Test extends ParentClass
//{
//	TestUtils utils = new TestUtils();
//	BlueToothPage blueTooth;
//	String email;
//	String passCode;
//	String expectedBluetoothText;
//	String expectedBluetoothMessage;
//	String firstName;
//	String lastName;
//	String expected_error_code_0005_1200;
//	String expected_error_code_0001_1201;
//	String expected_error_code_0001_0000;
//	Signin_TestData testdata;
//	COR_EC_0005_1200_Disconnect_Bluetooth_On_Mobile_Device corBluetoothConnectionFailed;
//	
//	
//	 @BeforeClass
//	 @Parameters({"signup_data"})
//	 public void beforeClass(String signup_data) throws Exception 
//	 {
//		 corBluetoothConnectionFailed = new COR_EC_0005_1200_Disconnect_Bluetooth_On_Mobile_Device();
//		 InputStream inData = Thread.currentThread().getContextClassLoader().getResourceAsStream(signup_data);
//		 testdata = Signin_TestData.getTestDataFile(inData);
//		 System.out.println(testdata.getFirst_name());
//		 System.out.println(testdata.getLast_name());
//		 System.out.println(testdata.getSsid_name());
//		 System.out.println(testdata.getUdid());
//		 System.out.println(testdata.getEmail_address());
//     }
//	
//	  @BeforeMethod
//	  public void beforeMethod(Method m) 
//	  {
//		  
//		   utils.log().info("****** starting test:" + m.getName() + "******" + "\n");
//	  }
//	  
//	  @Test
//	  public void EC_0005_1200_Disconnect_Bluetooth_On_Mobile_Test()
//	  {
//		  this.verify_error_code_0005_1200_Disable_Bluetooth_On_Mobile_Device().apply(testdata);
//	  }
//			  
//	  private Function<Signin_TestData, Signin_TestData> verify_error_code_0005_1200_Disable_Bluetooth_On_Mobile_Device() 
//	  {
//	        return corBluetoothConnectionFailed.DisableBlueToothPage
//	        		.andThen(corBluetoothConnectionFailed.GetStartedPage)
//	        		.andThen(corBluetoothConnectionFailed.GrantPermissionsPage)
//	        		.andThen(corBluetoothConnectionFailed.DeviceLocationPage)
//	        		.andThen(corBluetoothConnectionFailed.AccessResourcesOnDevicePage)
//	        		.andThen(corBluetoothConnectionFailed.SelectYourDevicePage)
//		        	.andThen(corBluetoothConnectionFailed.SelectYourDevicePage2)
//	        		.andThen(corBluetoothConnectionFailed.SiginPage)
//	        		.andThen(corBluetoothConnectionFailed.ValidOTP)
//	        		.andThen(corBluetoothConnectionFailed.EnterValidOTPPage)
//	        		.andThen(corBluetoothConnectionFailed.CodeVerifiedPage)
//			        .andThen(corBluetoothConnectionFailed.ErrorCode_0015_1805_Something_Went_Wrong_Page)
//			        .andThen(corBluetoothConnectionFailed.OptimizeYourNetworkPage)
//			        .andThen(corBluetoothConnectionFailed.SetupHomeNetworkPage)
//			        .andThen(corBluetoothConnectionFailed.UnPackYourBoxPage)
//			        .andThen(corBluetoothConnectionFailed.PlugInMaxRouterPage)
//			        .andThen(corBluetoothConnectionFailed.Error_0005_1200_Bluetooth_Connection_Failed_Page)
//			        .andThen(corBluetoothConnectionFailed.EnableBlueToothPage);
//	  }
//}
//			  
//			  
//
//			 
