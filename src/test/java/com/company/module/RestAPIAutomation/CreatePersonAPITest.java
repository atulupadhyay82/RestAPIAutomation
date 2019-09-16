package com.company.module.RestAPIAutomation;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.company.module.RestAPIAutomation.responsepojo.CreatePersonResponse;
import com.company.module.RestAPIAutomation.service.Service;
import com.google.gson.Gson;

/**
 * Here I am testing the CreatePersonAPI webservice. Also showing how we can convert service test (written in main method of Service class)
 *  into the testNG test.
 * @author atupadhy
 *
 */
public class CreatePersonAPITest extends TestBase{
	
	/*
	 * These are the arguments I need to supply before testing the createpersonAPI().
	 */
	String name;
	String surname;
	String city;
	String zipcode;
	String state;
	String landmark;
	
	/*
	 * I am initializing these variables in before class. Its up to you if you want to initialize them via a external file like excel file, properties
	 * file. I have hardcoded there.
	 */

	@BeforeClass
	public void dataSetUp() {
		name= "serviceTest";
		surname="servicesurname";
		city="servicecity";
		landmark= "servicelandmark";
		state="servicestate";
		zipcode="560078";
		
	}
	
	@Test
	public void createPersonAPITest() {
		service= new Service();
		response= service.createPersonAPI(name, surname, city, landmark, state, zipcode);
		
		if(response.getStatusCode() ==200)
		{
			Gson gson=new Gson();
			/*
			 * GSOn will instantiate the all the inner class of CreatePersonResponse. You dont need to worry about it.
			 */
			CreatePersonResponse createPersonResponse= gson.fromJson(response.asString(), CreatePersonResponse.class);
			
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
	
	
}
