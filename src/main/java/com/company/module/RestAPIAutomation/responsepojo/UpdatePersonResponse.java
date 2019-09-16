package com.company.module.RestAPIAutomation.responsepojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatePersonResponse {

	@SerializedName("response")
	@Expose
	private List<Response> response = null;

	public List<Response> getResponse() {
		return response;
	}

	public void setResponse(List<Response> response) {
		this.response = response;
	}

}

/*
 * 
 * // http://localhost:8081/serviceautomation-1.0/bhanu_api/person/update
 * 
 * Request: [ { "name": "Test", "surname": "Singh", "address": {
 * "city":"testCity", "state":"testState", "zipcode":"560078",
 * "landmark":"testlandmark" } }] Response: { "response": [ { "name": "Test",
 * "surname": "Singh", "address": { "city": "testCity", "state": "testState",
 * "zipcode": "560078", "landmark": "testlandmark" } } ] }
 */
