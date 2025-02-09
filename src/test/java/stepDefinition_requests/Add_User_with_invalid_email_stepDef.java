package stepDefinition_requests;

import commonCode.Payload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import pageObject_requests.Add_new_user_page;
import pojo.GetUsers;
import utilities.ConfigReader;

public class Add_User_with_invalid_email_stepDef {

	Add_new_user_page newUserPage = new Add_new_user_page();
	ConfigReader reader = new ConfigReader();
	RequestSpecification res;
	Response rawResponse;
	String statusCode;
	String message;
	GetUsers getUserresponse;
	@Given("POST request for adding new user")
	public void post_request_for_adding_new_user() {
	  
		Payload.loadTestCases();
		res = given().spec(newUserPage.getPostRequest()).body(Payload.addNewUserWithInvalidEmail());
	}

	@When("Add new user POST request is send with invalid email")
	public void add_new_user_post_request_is_send_with_invalid_email() {
	   
		
		  rawResponse = res.when().post(reader.createNewUser()).then().spec(newUserPage.getPostResponseForInvalidEmail())
		  	.log().all().extract().response(); 
		  getUserresponse = rawResponse.as(GetUsers.class);
		  statusCode = getUserresponse.getStatus();
		  message = getUserresponse.getMessage();
	}

	@Then("The status recieved is not found")
	public void the_status_recieved_is_not_found() {
		Assert.assertEquals(statusCode, "400 BAD_REQUEST", "Expected status code 400.");
		Assert.assertEquals(message, "User email Id is required and should be in proper email format");
	}

}
