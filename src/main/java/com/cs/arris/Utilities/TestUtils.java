package com.cs.arris.Utilities;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cs.arris.Base.ParentClass;

import io.appium.java_client.android.AndroidDriver;


public class TestUtils {
	public static final long WAIT = 10;
	Date date;
	public String firstName;
	public String lastName;
	public String email;
	public String OTP;
	
	public String dateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		date = new Date();
		return dateFormat.format(date);
	}
	
	public String onlyDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = new Date();
		return dateFormat.format(date);
	}
	
	public void log(String txt) {
		ParentClass base = new ParentClass();
		String msg = Thread.currentThread().getId() + ":" + base.getPlatformName() + ":" + base.getUDID()  + ":"
				+ Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;
	
		String strFile = "logs" + File.separator + base.getPlatformName()+ "_" + base.getUDID() 
				+ File.separator + onlyDate();

		File logFile = new File(strFile);

		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(logFile + File.separator + base.getDriver().manage().logs().toString(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.println(msg);
	    printWriter.close();
	}

	public Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
	
	public HashMap<String, String> parseStringXML(InputStream file) throws Exception{
		HashMap<String, String> stringMap = new HashMap<String, String>();
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		 
		//Build Document
		Document document = builder.parse(file);
		 
		//Normalize the XML Structure; It's just too important !!
		document.getDocumentElement().normalize();
		 
		//Here comes the root node
		Element root = document.getDocumentElement();
		 
		//Get all elements
		NodeList nList = document.getElementsByTagName("string");
		 
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) node;
				// Store each element key value in map
				stringMap.put(eElement.getAttribute("name"), eElement.getTextContent());
			}
		}
		return stringMap;
	}
	
	 public String getOTP()
	 {
			String hostName;
			String username ;
			String password ;
			int messageCount;
			int newMessageCount;
			int unreadMsgCount;
			String emailSubject;
			Message emailMessage;
		  
		    Properties sysProps = System.getProperties();
		    sysProps.setProperty("mail.store.protocol", "imaps");
		    
		    try 
		    {
		        Session session = Session.getInstance(sysProps, null);
		        Store store = session.getStore();
		   //     store.connect(hostName, username, password);
		        Folder emailInbox = store.getFolder("INBOX");
		        emailInbox.open(Folder.READ_WRITE);
		        messageCount = emailInbox.getMessageCount();
		        System.out.println("Total Message Count: " + messageCount);
		        unreadMsgCount = emailInbox.getNewMessageCount();
		        System.out.println("Unread Emails count:" + unreadMsgCount);
		        emailMessage = emailInbox.getMessage(messageCount);
		        newMessageCount = emailInbox.getNewMessageCount();
		        System.out.println("New Message Count: " + newMessageCount);
		       
		        emailSubject = emailMessage.getSubject();
		        System.out.println("Subject: " + emailSubject);
		        System.out.println(emailMessage.getContent().toString());
		        OTP = getOTPCode(emailMessage.getContent().toString()); //Your verification code is 511855.
		        System.out.println("OTP is : " + OTP);
		        emailMessage.setFlag(Flags.Flag.SEEN, true);
		        emailInbox.close(true);
		        store.close();
		    }catch (Exception mexp) 
		    {
		        mexp.printStackTrace();
		    }
		    return OTP;
	  }
	 
	 private String getOTPCode(String content) 
	 {
		String[] contents = content.split(" ");
		String code = contents[contents.length-1];
		return code.substring(0, 6);
	 }
	 
	 
//	 public void writeToJSON()
//	 {
//		 	//JSON parser object to parse read file
//		 	JSONParser jsonParser = new JSONParser();
//	         
//	        try (FileReader reader = new FileReader("user_registration_data.json"))
//	        {
//	            //Read JSON file
//	        	Object obj = jsonParser.parse(reader);   
//	        	JSONArray user = (JSONArray) obj;
//	            userRegistrationData = (JSONArray) obj;
//	            System.out.println(employeeList);
//	             
//	            //Iterate over employee array
//	            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
//	 
//	        } catch (FileNotFoundException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        } catch (ParseException e) {
//	            e.printStackTrace();
//	        }
//	 }
	 
//	 public void readFromJSON(String filename, String key)
//	 {
//		 JSONParser jsonParser = new JSONParser();
//		 try
//		 {
//			 FileReader reader = new FileReader(filename);
//			 JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//			 JSONObject userObject = (JSONObject) jsonObject.get(key);
//	         firstName = (String) userObject.get("firstName");    
//	         lastName = (String) userObject.get("lastName");  
//	         email = (String) userObject.get("email");    
//		 }catch(Exception e)
//		 {
//			 e.printStackTrace();
//		 }
//         
//    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
