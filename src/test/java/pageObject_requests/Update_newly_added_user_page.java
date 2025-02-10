package pageObject_requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.ConfigReader;

public class Update_newly_added_user_page {

	static ConfigReader reader = new ConfigReader();
	
	public static RequestSpecification getUpdateUserRequest() {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri(reader.getBaseUrl())
				.setAuth(io.restassured.RestAssured.basic(reader.getUsername(), reader.getUserPassword()))
				.addHeader("Content-Type","application/json").build();
		return req;
	}
	
	public static ResponseSpecification getUpdateUserResponse() {
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).build();
		return res;
	}
}
