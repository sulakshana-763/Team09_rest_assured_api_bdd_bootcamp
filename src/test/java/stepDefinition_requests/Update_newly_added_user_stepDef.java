package stepDefinition_requests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import org.testng.Assert;

import commonCode.Payload;
import pageObject_requests.Update_newly_added_user_page;
import pojo.GetUsers;
import utilities.ConfigReader;

public class Update_newly_added_user_stepDef {
	
	ConfigReader reader = new ConfigReader();
	Update_newly_added_user_page updatePage = new Update_newly_added_user_page();
	Add_new_user_stepDef addNewUserStepDef = new Add_new_user_stepDef();
	RequestSpecification req;
	Response rawResponse;
	GetUsers getUserResponse;
	static int id;
	int statusCode;
	
	@Given("PUT request for updating new user with valid fields")
	public void put_request_for_updating_new_user_with_valid_fields() {
	    
		Payload.loadTestCases();	
		id = addNewUserStepDef.id;		
		req = given().spec(updatePage.getUpdateUserRequest()).body(Payload.updateUser());		
	}

	@When("PUT request to get updated user with userId is send")
	public void put_request_to_get_updated_user_with_user_id_is_send() {
	    
		rawResponse = req.when().put(reader.updateUser(),id).then().spec(updatePage.getUpdateUserResponse()).log().all()
				.extract().response();		
		int statusCode = rawResponse.getStatusCode();
		this.statusCode = statusCode;
	}
	
	@Then("Success code recieved")
	public void success_code_recieved() {

		Assert.assertEquals(statusCode, 200, "Expected status code 200.");
	}
}
