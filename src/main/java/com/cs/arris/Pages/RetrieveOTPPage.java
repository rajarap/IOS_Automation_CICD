package com.cs.arris.Pages;

import java.lang.reflect.Method;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cs.arris.Base.ParentClass;
import com.cs.arris.Interface.Page;
import com.cs.arris.Utilities.TestUtils;

public class RetrieveOTPPage  extends ParentClass
{
	TestUtils utils = new TestUtils();
	String hostName = "smtp.gmail.com";
	String username;
	String password; 
//	String username = "";
//	String password = ""; 
	int messageCount;
	int newMessageCount;
	int unreadMsgCount;
	String emailSubject;
	Message emailMessage;
	String passCode;
	
  
     public void retrieveOTP()
	  {
		  try 
		    {
			  	Properties sysProps = System.getProperties();
				sysProps.setProperty("mail.store.protocol", "imaps");
		        
				Session session = Session.getInstance(sysProps, null);
		        Store store = session.getStore();
		        store.connect(hostName, username, password);
		        
		        Folder emailInbox = store.getFolder("INBOX");
		        emailInbox.open(Folder.READ_WRITE);
		        
		        messageCount = emailInbox.getMessageCount();
		        System.out.println("Total Message Count: " + messageCount);
		        
		        unreadMsgCount = emailInbox.getNewMessageCount();
		        System.out.println("Unread Emails count:" + unreadMsgCount);
		        
		        if(unreadMsgCount == 0)
		        {
		        	utils.log("OTP mail still not recieved");
		        	utils.log("Polling INBOX");
		        	for(int i = 2; i <= 10; i++)
		        	{
		        		pause(i);
		        		if(getUnReadMessageCount(emailInbox) != 0)
		        		{
		        			if (emailMessage.getSubject().contains("Your verification code"))
		        			{
		        				passCode= getOTPCode(emailMessage.getContent().toString());
		        				super.OTP = passCode;
		        			}
	        				break;
		        		}
		        		utils.log("OTP mail still not recieved");
		        	}
		        }
		       // emailMessage = emailInbox.getMessage(messageCount);
		        System.out.println("OTP is : " + passCode);
		        emailMessage.setFlag(Flags.Flag.SEEN, true);
		        emailInbox.close(true);
		        store.close();
		    }catch (Exception mexp) 
		    {
		        mexp.printStackTrace();
		    }
		  	
	  }
	  
		 private String getOTPCode(String content) 
		 {
			String[] contents = content.split(" ");
			String code = contents[contents.length-1];
			return code.substring(0, 6);
		 }
		 
		 private int getUnReadMessageCount(Folder emailInbox)
		 {
			 try {
				unreadMsgCount = emailInbox.getNewMessageCount();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		     return unreadMsgCount;
		 }
}
