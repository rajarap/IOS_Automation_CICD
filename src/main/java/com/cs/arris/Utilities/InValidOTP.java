package com.cs.arris.Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

public class InValidOTP 
{
	//public static String hostName = "smtp.gmail.com";
//	public static String hostName = "imap.gmail.com";
//	public static String mailStoreType = "imap";
//	public static String OTP;
	
	public int messageCount;
	public int newMessageCount;
	public int unreadMsgCount;
	public String emailSubject;
	public Message emailMessage;
	public String OTP;
	private boolean textIsHtml = false;
	public InputStream testData = null;
	TestUtils utils = new TestUtils();
	Properties properties = new Properties();
	
	public String getValidOTP()
	{

		Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");
	    
	    try 
	    {
	    	loadTestData("emailDetails");
	        Session session = Session.getInstance(sysProps, null);
	        Store store = session.getStore();
	        store.connect(properties.getProperty("hostname"), properties.getProperty("username"), properties.getProperty("password"));
	        Folder emailInbox = store.getFolder("INBOX");
	        emailInbox.open(Folder.READ_WRITE);
	        messageCount = emailInbox.getMessageCount();
	        emailMessage = emailInbox.getMessage(messageCount);
	        newMessageCount = emailInbox.getNewMessageCount();    
	        emailSubject = emailMessage.getSubject();
	        String body = getText(emailMessage);
	        OTP = getValidOTPCode(body); //Your verification code is 511855.
	        emailMessage.setFlag(Flags.Flag.SEEN, true);
	        emailInbox.close(true);
	        store.close();

	    }catch (Exception mexp) 
	    {
	        mexp.printStackTrace();
	    }
	    return OTP;
	}
	
	private static String getValidOTPCode(String content) {
		String[] contents = content.split(" ");
		String code = contents[contents.length-1];
		return code.substring(0, 6);
	}
	
	public String getInValidOTP()
	{
		Properties sysProps = System.getProperties();
	    sysProps.setProperty("mail.store.protocol", "imaps");
	    
	    try 
	    {
	    	loadTestData("emailDetails");
	        Session session = Session.getInstance(sysProps, null);
	        Store store = session.getStore();
	        store.connect(properties.getProperty("hostname"), properties.getProperty("username"), properties.getProperty("password"));
	        Folder emailInbox = store.getFolder("INBOX");
	        emailInbox.open(Folder.READ_WRITE);
	        messageCount = emailInbox.getMessageCount();
	        emailMessage = emailInbox.getMessage(messageCount);
	        newMessageCount = emailInbox.getNewMessageCount();    
	        emailSubject = emailMessage.getSubject();
	        String body = getText(emailMessage);
	        OTP = getInvalidOTPCode(body); //Your verification code is 511855.
	        
	        emailMessage.setFlag(Flags.Flag.SEEN, true);
	        emailInbox.close(true);
	        store.close();

	    }catch (Exception mexp) 
	    {
	        mexp.printStackTrace();
	    }
	    return OTP;
	}

	
	private static String getInvalidOTPCode(String content) {
		String[] contents = content.split(" ");
		String code = contents[contents.length-1];
		String invalidPassCode = code.replaceAll("[0-9]", "0");
		return invalidPassCode;
	}
	
	
	public void loadTestData(String filePath)
	  {
			//load the strings.xml file and assign strings object to strings ThreadLocal
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
	
//	public static void getPassCode()
//	{
//		
//		//Gmeil code: 
//		Properties properties = new Properties();   
//		properties.put("mail.imap.host", host);
//		properties.put("mail.imap.port", "993");
//		properties.put("mail.imap.starttls.enable", "true");
//		properties.put("mail.imap.ssl.trust", host);
//		
//		try 
//		{       
//			Session emailSession = Session.getDefaultInstance(properties);
//			Store store = emailSession.getStore("imaps");
//			store.connect(host, user, pwd);
//			
//			// create the inbox object and open it
//			Folder inbox = store.getFolder("Inbox");
//			inbox.open(Folder.READ_WRITE);
//			
//			// retrieve the messages from the folder in an array and print it
//			Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
//			System.out.println("messages.length---" + messages.length);
//			
//			for (int i = 0, n = messages.length; i < n; i++) {
//				Message message = messages[i];
//				message.setFlag(Flag.SEEN, true);
//				System.out.println("---------------------------------");
//				System.out.println("Email Number " + (i + 1));
//				System.out.println("Subject: " + message.getSubject());
//				System.out.println("From: " + message.getFrom()[0]);
//				System.out.println("Text: " + message.getContent().toString());
//			}
//			inbox.close(false);
//			store.close();
//			} catch (Exception mex) {
//				mex.printStackTrace();
//		}
//	}
	
	private String getText(Part p) throws MessagingException, IOException 
	{
		if (p.isMimeType("text/*")) 
		{
			String s = (String)p.getContent();
			textIsHtml = p.isMimeType("text/html");
			return s;
		}
		
		if (p.isMimeType("multipart/alternative")) 
		{
			// prefer html text over plain text
			Multipart mp = (Multipart)p.getContent();
			String text = null;
			for (int i = 0; i < mp.getCount(); i++) 
			{
				Part bp = mp.getBodyPart(i);
				if (bp.isMimeType("text/plain")) 
				{
					if (text == null)
						text = getText(bp);
					continue;
				} else if (bp.isMimeType("text/html")) {
					String s = getText(bp);
					if (s != null)
						return s;
				} else 
				{
					return getText(bp);
				}
			}
			return text;
		} else if (p.isMimeType("multipart/*")) 
		{
			Multipart mp = (Multipart)p.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				String s = getText(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}

		return null;
	}
}




//Gmeil code: 
//Properties properties = new Properties();   
//properties.put("mail.imap.host", hostName);
//properties.put("mail.imap.port", "993");
//properties.put("mail.imap.starttls.enable", "true");
//properties.put("mail.imap.ssl.trust", hostName);
//
//try 
//{       
//	Session emailSession = Session.getDefaultInstance(properties);
//	Store store = emailSession.getStore("imaps");
//	store.connect(hostName, username, password);
//	
//	// create the inbox object and open it
//	Folder inbox = store.getFolder("Inbox");
//	inbox.open(Folder.READ_WRITE);
//	
//	// retrieve the messages from the folder in an array and print it
//	Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
//	System.out.println("messages.length---" + messages.length);
//	
//	for (int i = 0, n = messages.length; i < n; i++) {
//		Message message = messages[i];
//		message.setFlag(Flag.SEEN, true);
//		System.out.println("---------------------------------");
//		System.out.println("Email Number " + (i + 1));
//		System.out.println("Subject: " + message.getSubject());
//		System.out.println("From: " + message.getFrom()[0]);
//		System.out.println("Text: " + message.getContent().toString());
//	}
//	inbox.close(false);
//	store.close();
//	} catch (Exception mex) {
//		mex.printStackTrace();
//}