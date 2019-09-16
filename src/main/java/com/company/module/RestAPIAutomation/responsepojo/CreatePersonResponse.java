package com.company.module.RestAPIAutomation.responsepojo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * main class in the response pojo classes
 * @author atupadhy
 *
 */
public class CreatePersonResponse {

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
