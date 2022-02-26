package com.cs.arris.Interface;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface W31_Onboarding_TestData 
{
    public W31_Onboarding_TestData get(String jsonFileName) throws StreamReadException, DatabindException, IOException;

}