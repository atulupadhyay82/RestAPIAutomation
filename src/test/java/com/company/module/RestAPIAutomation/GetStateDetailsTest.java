package com.company.module.RestAPIAutomation;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.company.module.RestAPIAutomation.responsepojo.GetStateDetail;
import com.company.module.RestAPIAutomation.responsepojo.GetStateDetailResponse;
import com.company.module.RestAPIAutomation.service.Service;
import com.google.gson.Gson;

public class GetStateDetailsTest extends TestBase {
	
	/*
	 * To store response data (will have all state name) which we are getting at runtime and then compare it with the testData which we either got from the DB or from the hardcoded
	 * list
	 */
	List<Object> stateName;
	List<Object> testData;
	
	
	/*
	 * I know it is response and fixed otherwise call your DB and get the values from DB then put an assertion.
	 */
	@BeforeClass
	public void dataSetUp() {
		testData.add("Bihar");
		testData.add("UP");
		testData.add("Karnataka");
		testData.add("Kerala");
		testData.add("Tamilnadu");
		testData.add("MP");
		
	}
	
	@Test
	public void getStateDetailsAPITest() {
		service= new Service();
		response= service.getStateDetails();
		
		/*
		 * Response which are we getting at runtime, will instantiate our response POJO class (means will set the memeber of this class and its inner class)
		 */
		if(response.getStatusCode() == 200)
		{
			System.out.println(response.asString());
			Gson gson=new Gson();
			GetStateDetailResponse getStateDetailResponse=gson.fromJson(response.asString(), GetStateDetailResponse.class);
			List<GetStateDetail> stateData= getStateDetailResponse.getGetStateDetails();
			
			stateName= new ArrayList<Object>();
			
			for(int i=0; i<stateData.size();i++) {
				stateName.add(stateData.get(i).getName());
			}
			Assert.assertEquals(stateName, testData);
		}
		else {
			Assert.assertEquals(false,response.asString());
		}
		
	}

}
