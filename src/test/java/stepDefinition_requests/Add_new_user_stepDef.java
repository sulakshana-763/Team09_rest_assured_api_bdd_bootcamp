package stepDefinition_requests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pageObject_requests.Add_new_user_page;
import pageObject_requests.Post_api;
import pojo.GetUsers;
import utilities.ConfigReader;
import utilities.Payloads;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.Assert;

import commonCode.Payload;

//import files.Payload;

public class Add_new_user_stepDef {
	Post_api post_api = new Post_api();
	GetUsers getUser = new GetUsers();
	GetUsers getUserresponse;
	public static RequestSpecification res;
	ConfigReader reader = new ConfigReader();
	int statusCode;
	public static int id;
	public static String username;
	public static String contentType;
	public static String server;
	Response rawResponse;
	Add_new_user_page newUserPage = new Add_new_user_page();

	@Given("POST request for adding new user is set with valid fields")
	public void post_request_for_adding_new_user_is_set_with_valid_fields() {
		
		//Initailize all testcases from excel sheet
		Payload.loadTestCases();
		//base url with auth and request body
		res = given().spec(newUserPage.getPostRequest()).body(Payload.addNewUser());
	}

	@When("Add new user POST request is send")
	public void add_new_user_post_request_is_send() {
		
		//end points for post and extract the response
		rawResponse = res.when().post(reader.createNewUser()).then().spec(newUserPage.getPostResponse()).log().all()
				.extract().response();
		// Extract the status code from the raw response
		int statusCode = rawResponse.getStatusCode();
		
		contentType = rawResponse.getHeader("Content-Type");
		server = rawResponse.getHeader("Server");
		
		// Deserialize the response body into GetUsers class
		getUserresponse = rawResponse.as(GetUsers.class);
		// Store the status code for later validation
		this.statusCode = statusCode;
		this.username = getUserresponse.getUser_first_name();
		System.out.println("username in get = " + this.username);
		id = getUserresponse.getUser_id();		
	}

	@Then("The status recieved is success")
	public void the_status_recieved_is_success() {

		Assert.assertEquals(statusCode, 201, "Expected status code 201.");
		Assert.assertEquals(contentType, "application/json", "Content-Type is incorrect.");
		Assert.assertTrue(server.contains("Cowboy"), "Server should be Cowboy.");
		Assert.assertNotNull(getUserresponse.getUser_id(), "User ID should not be null.");
		Assert.assertTrue(Integer.class.isInstance(getUserresponse.getUser_id()), "User ID should be an Integer.");
		Assert.assertEquals(rawResponse.getHeader("Content-Type"), "application/json", "Content-Type mismatch.");
		Assert.assertTrue(rawResponse.getHeader("Server").contains("Cowboy"), "Server mismatch.");
	}

	@Given("GET request for adding new user is set with valid fields")
	public void get_request_for_adding_new_user_is_set_with_valid_fields() {
		// Get api call with requestspec
		res = given().spec(newUserPage.getPostRequest());
		System.out.println("id in get = " + id);
	}

	@When("GET request to get newly added user with userId is send")
	public void get_request_to_get_newly_added_user_with_user_id_is_send() {		

		rawResponse = res.when().get(reader.getWithId(), id).then().log().all().extract().response();
		statusCode = rawResponse.getStatusCode();		
	}

	@Then("The status recieved is success with success code")
	public void the_status_recieved_is_success_with_success_code() {

		Assert.assertEquals(statusCode, 200, "Expected status code 200.");
	}

	@Given("DELETE request for deleting new user is set with valid fields")
	public void delete_request_for_deleting_new_user_is_set_with_valid_fields() {

		res = given().spec(newUserPage.getPostRequest());
		System.out.println("id in delete = " + id);
	}

	@When("DELETE request with new user userId is send")
	public void delete_request_with_new_user_user_id_is_send() throws InterruptedException {
	
		rawResponse = res.when().delete(reader.deleteWithId(), id).then().log().all().extract().response();
		statusCode = rawResponse.getStatusCode();		 
	}
}
