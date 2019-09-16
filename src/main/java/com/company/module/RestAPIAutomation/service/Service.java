package com.company.module.RestAPIAutomation.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.company.module.RestAPIAutomation.requestpojo.Address;
import com.company.module.RestAPIAutomation.requestpojo.CreatePerson;
import com.company.module.RestAPIAutomation.responsepojo.CreatePersonResponse;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Service {
	
	List<JSONObject> list;
	
	/**
	 * This API will create the person. With this, now we can test CreatePerson API. This will give response in the JSON.
	 * @param name 
	 * @param surname 
	 * @param city 
	 * @param landmark 
	 * @param state 
	 * @param zipcode 
	 * @return 
	 */
	public Response createPersonAPI(String name, String surname, String city, String landmark, String state, String zipcode) {
		 CreatePerson createPerson=new CreatePerson();
		 createPerson.setName(name);
		 createPerson.setSurname(surname);
		 
		 Address address=new Address();
		 createPerson.setAddress(address);
		 
		 address.setCity(city);
		 address.setLandmark(landmark);
		 address.setState(state);
		 address.setZipcode(zipcode);
		 
		 /*
		  * Now we have set the data, need to post it to the server.
		  * We will be sending request in the json format, also wants to get the response from server in the same format.
		  */
		 
		 RequestSpecification requestSpecification= RestAssured.given();
		 requestSpecification.contentType("application/json");
		 requestSpecification.accept("application/json");
		 
		 /*
		  * We need to convert our POJO object into. As per the development team specification, your json is not the arraylist i.e. within the 
		  * square bracker "[]". So we will create one arraylist and it will take jsonobject class object.
		  */
		 JSONObject jsonObject=new JSONObject(createPerson);
		 list= new ArrayList<JSONObject>();
		 list.add(jsonObject); 
		 System.out.println(list);
		 
		 requestSpecification.body(list);
		 Response response = requestSpecification.post(ServiceURL.createPersonURL);
		 /*
		  * To put the assertion at the runtime, you need to initialize the all the three response pojo through the response of this CreatePerson API.
		  */
		 return response;
	}
	
	/*
	 * In testng, it will be replaced with test method.
	 */
	public static void main(String[] args) {
		Service service = new Service();
		Response data = service.createPersonAPI("name", "surname", "city", "landmark", "state", "560072");
		System.out.println(data.asString());
		
		if(data.getStatusCode() ==200)
		{
			Gson gson=new Gson();
			CreatePersonResponse createPersonResponse= gson.fromJson(data.asString(), CreatePersonResponse.class);
			
			/*
			 * Now put the assertion. Here i know my payload so I do the hardcoding. Ideally, we can create database connection. From the db, we will read and compart it 
			 * with response. 
			 */
			
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getCity(), "city");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getLandmark(), "landmark");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getState(),"state");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getAddress().getZipcode(),"560072");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getName(),"name");
			Assert.assertEquals(createPersonResponse.getResponse().get(0).getSurname(),"surname");
		}
	
	}
	
	/**
	 * This API will retrun state details. I want to convert into testNG file. Just go src/test/java 
	 * @return 
	 */
	@Test
	public Response getStateDetails() {
		RequestSpecification requestSpecification= RestAssured.given();
		 requestSpecification.contentType("application/json");
		 requestSpecification.accept("application/json");
		 System.out.println("endpoint URL is..."+ServiceURL.getStateDetails);
		 Response response = requestSpecification.get(ServiceURL.getStateDetails);
		 return response;
	}

}
