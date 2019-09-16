package com.company.module.RestAPIAutomation;

import com.company.module.RestAPIAutomation.service.Service;
import com.jayway.restassured.response.Response;

/**
 * Every test when i want to call CreateTestAPI of Service class, I need to have the object the Service class. So in testbase class where I will have
 * the reference, I dont need to supply the reference for them in any test.
 * @author atupadhy
 *
 */
public class TestBase {

	Response response;
	
	Service service;
}
