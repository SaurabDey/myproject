package com.org.mypac;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredTestClass {
	
	//@Test
	public void soaptest()
	{
Response resppppp=RestAssured.
		  given().
		     baseUri("http://www.dneonline.com/calculator.asmx").
		     contentType("text/xml").
		     body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n   <soapenv:Header/>\r\n   <soapenv:Body>\r\n      <tem:Add>\r\n         <tem:intA>20</tem:intA>\r\n         <tem:intB>30</tem:intB>\r\n      </tem:Add>\r\n   </soapenv:Body>\r\n</soapenv:Envelope>").
		    
		  when().
		     post();
		  
 System.out.println(":::Status code:::::");
    System.out.println(resppppp.getStatusCode());
 System.out.println(":::Resposnse Body:::::");
    System.out.println(resppppp.getBody().asString());
 System.out.println(":::Timing:::::");
    System.out.println(resppppp.getTime());

	}
	
@Test
	public void resttest()
	{
		Response respRest=RestAssured.
				given().
				  baseUri("http://dummy.restapiexample.com/api/v1/create").
				  contentType("application/json").
				  body("{\r\n\"name\":\"Datta\",\r\n\"salary\":\"12340\",\r\n\"age\":\"20\"\r\n}").
				
				 when().
				    post();
		
		System.out.println(":::Status code:::::");
		    System.out.println(respRest.statusCode());
		
		System.out.println(":::Resposnse Body:::::");
		    System.out.println(respRest.getBody().asString());
		
		System.out.println(":::Timing:::::");
		    System.out.println(respRest.getTime());
		
	}

}
