package com.cs.arris.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Pages.DeviceSignalStrengthLeaderBoardPage;

public class TestingDeviceCount 
{
	static String hh;
	static String mm;
	static String med;
	static ValidOTP otp;
	
	public static void main(String args[])
	{
//		ParentClass pc = new ParentClass();
//		Integer count = pc.getCountOfDevicesWithSpace("Devices (2)");
//		System.out.println(count.toString());
		
//		ParentClass pc = new ParentClass();
//		System.out.println(pc.getDeviceSignalStrengthCount("03 Devices"));
//		System.out.println(pc.getDeviceSignalStrengthCount("03 Devices"));
//		System.out.println(pc.get5GHzCountOfDevices("2 Devices ( 5 GHz)"));
//		System.out.println(pc.get24GHzCountOfDevices("2 Devices ( 2.4 GHz)"));
//		System.out.println(java.time.LocalTime.now());
	
//    	pickHour();
//    	pickMinute();
//    	pickMedian();
		
		verifyOTP();
    	
		
	}
	
	public static void verifyOTP()
	{
//		otp = new ValidOTP();
//		String code = otp.getValidOTP();
//		System.out.println("OTP CODE IS: " + code);
			otp = new ValidOTP();
			otp.getValidOTP();
	}
	
	public static void pickTime()
	{
		LocalTime localTime = java.time.LocalTime.now();
		//utils.log().info("Local Time is" + localTime);  //19:12:55.514827
		
		DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
    	String dateStr = dateFormat.format(new Date()).toString();
    	System.out.println("Current Time is : " + dateStr);  //07.16 PM
    	String strPattern = "^0+";
    	String dateString = dateStr.replaceAll(strPattern, ""); //7.16 PM
    	
    	String[] str = dateString.split(" "); // 7.16      PM
    	med = str[1];
    	if(str[0].length() == 4)
    	{
    		hh = str[0].substring(0, 1);
    		mm = str[0].substring(2);
    	}
    	else
    	{
    		hh = str[0].substring(0, 2);
    		mm = str[0].substring(3);
    	}
	}
	
	public static void pickHour()
	{
		pickTime();
		Integer hrInt = Integer.valueOf(hh);
		Integer hr = hrInt++;
		if(hr >= 12)
		{
			hr = hr -= 11;
			if(med.equals("PM"))
				med = "AM";
			if(med.equals("AM"))
				med = "PM";
			
			String hrs = Integer.toString(hr);
			System.out.println("Hours = " + hrs);
		}else
		{
			String hrs = Integer.toString(hr);
			System.out.println("Hours = " + hrs);
		}
	}
	
	public static void pickMinute()
	{
		pickTime();
		Integer minInt = Integer.valueOf(mm);
		Integer mint = minInt += 5;
		if(mint >= 60)
		{
			mint = mint -= 55;
			String mins = Integer.toString(mint);
			System.out.println("Minutes = " + mins);
		}else
		{
			String mins = Integer.toString(mint);
			System.out.println("Minutes = " + mins);
		}
	}
	
	public static void pickMedian()
	{
		System.out.println("Median = " + med);
	}
	
	
	public static void getAllDevicesCount(String allDevices)
	{
		String str1 = allDevices.replaceAll("\\p{P}", "");
		System.out.println(str1);
		
	}

}
