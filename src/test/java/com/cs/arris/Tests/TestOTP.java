package com.cs.arris.Tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import com.cs.arris.Utilities.GetOTPFromNada;
import com.cs.arris.Utilities.InValidOTP;
import com.cs.arris.Utilities.ValidOTP;

public class TestOTP 
{
	public static ValidOTP otp;

	public static void main(String[] args)
	{
//		OTP otp = new OTP();
//		otp.getOTP();
//		System.out.println();
//		System.out.println();
		getOTP();
	}
	
	private static void getOTP() 
	{
		try {
			otp = new ValidOTP();
			String pass = otp.getValidOTP();
			System.out.println("OTP CODE is : " + pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Explaination: mailFolderName(Eg- "INBOX"), emailSubjectContent(Eg- Mail for OTP), emailContent(Eg- OTP is 111111), OTP length(Eg- 6) as my activation code is 6 digits.
//	public static String OutlookMailReader(String mailFolderName,String emailSubjectContent, String emailContent, int lengthOfOTP) 
//	{
//	            String hostName = "smtp-mail.outlook.com";//change it according to your mail
//	            String username = "****@***.com";//username 
//	            String password = "*******";
//	            int messageCount;
//	            int unreadMsgCount;
//	            String emailSubject;
//	            Message emailMessage;
//	            String searchText=null ;
//	            Properties sysProps = System.getProperties();
//	            sysProps.setProperty("mail.store.protocol", "imaps");
//
//	            try {
//	                Session session = Session.getInstance(sysProps, null);
//	                Store store = session.getStore();
//	                store.connect(hostName, username, password);
//	                Folder emailBox = store.getFolder(mailFolderName);
//	                emailBox.open(Folder.READ_WRITE);
//	                messageCount = emailBox.getMessageCount();
//	                System.out.println("Total Message Count: " + messageCount);
//	                unreadMsgCount = emailBox.getNewMessageCount();
//	                System.out.println("Unread Emails count:" + unreadMsgCount);
//	                for(int i=messageCount; i>(messageCount-unreadMsgCount); i--)
//	                {
//	                    emailMessage = emailBox.getMessage(i);
//	                    emailSubject = emailMessage.getSubject();
//	                    if(emailSubject.contains(emailSubjectContent))
//	                    {
//	                        System.out.println("OTP mail found");
//	                        String line;
//	                        StringBuffer buffer = new StringBuffer();
//	                        BufferedReader reader = new BufferedReader(new InputStreamReader(emailMessage.getInputStream()));
//
//	                        while ((line = reader.readLine()) != null) {
//	                            buffer.append(line);
//	                        }
//	                        String messageContent=emailContent;
//	                        String result = buffer.toString().substring(buffer.toString().indexOf(messageContent));
//	                        searchText = result.substring(messageContent.length(), messageContent.length()+lengthOfOTP);
//	                        System.out.println("Text found : "+ searchText);
//	                        emailMessage.setFlag(Flags.Flag.SEEN, true);
//	                        break;
//	                    }
//	                    emailMessage.setFlag(Flags.Flag.SEEN, true);
//	                }
//	                emailBox.close(true);
//	                store.close();
//	            } catch (Exception mex) {
//	                mex.printStackTrace();
//	                System.out.println("OTP Not found ");
//	            }
//	            return searchText;
//	        }

//	private static void getOTP() 
//	{
//		try {
//			otp = new GetOTPFromNada();
//			//otp.createNewEmailAddress("demouser106@getnada.com");
//			System.out.println(otp.getPassCode("demouser106@getnada.com"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
