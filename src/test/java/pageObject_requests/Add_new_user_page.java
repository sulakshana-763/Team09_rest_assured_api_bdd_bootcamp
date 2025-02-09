package pageObject_requests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.GetUsers;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class Add_new_user_page {

	GetUsers getUser = new GetUsers();
	static ConfigReader reader = new ConfigReader();
	static String userEmail;
	public static Map<String, Map<String, String>> testCaseDataMap = new HashMap<>();
	static Map<String, String> testData;
	// static Map<String, String> testData = testCaseDataMap.get("validUser");

	public static RequestSpecification getPostRequest() {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(reader.getBaseUrl())
				.setAuth(io.restassured.RestAssured.basic(reader.getUsername(), reader.getUserPassword()))
				.addHeader("Content-Type", "application/json").build();
		return req;
	}

	public static ResponseSpecification getPostResponse() {
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(201).build();
		return responseSpec;
	}

	public static void loadTestCases() {
		
		ExcelReader excelReader = new ExcelReader(reader.getExcelFilepath(), "userData");
		testCaseDataMap = excelReader.readAllTestCases(); // Load all test cases for all login combinations
		System.out.println("Login test cases loaded successfully!" + testCaseDataMap.keySet());
		testData = testCaseDataMap.get("validUser");
		userEmail = testData.get("userEmailId");		
	}

	

}
