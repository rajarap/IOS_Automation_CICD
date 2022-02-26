package com.cs.arris.JsonMappers;

import java.io.File;
import java.io.IOException;

import com.cs.arris.Interface.W31_Onboarding_TestData;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SignUp_TestData {
	
	@JsonProperty("email_address")
	String email_address;
	
	@JsonProperty("first_name")
	String first_name;
	
	@JsonProperty("last_name")
	String last_name;
	
	@JsonProperty("ssid_name")
	String ssid_name;
	
	@JsonProperty("ssid_pwd")
	String ssid_pwd;
	
	@JsonProperty("udid")
	String udid;
	
	public String getEmail_address() {
		return email_address;
	}


	public String getFirst_name() {
		return first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public String getSsid_name() {
		return ssid_name;
	}


	public String getSsid_pwd() {
		return ssid_pwd;
	}


	public String getUdid() {
		return udid;
	}
	
    public static W31_Onboarding_TestData get(String jsonFileName) throws JsonParseException, JsonProcessingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(jsonFileName), W31_Onboarding_TestData.class);
    }
	
}
