package stepDefinition_requests;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import pageObject_requests.Add_new_user_page;
import utilities.ConfigReader;

public class Get_and_delete_user_with_username {

	Add_new_user_page addNewUserPage = new Add_new_user_page();
	ConfigReader reader = new ConfigReader();
	Add_new_user_stepDef add_new_user_stepdef = new Add_new_user_stepDef();
	Response resp;
	String username;
	int statusCode;
	
	@When("GET request to get newly added user with userName is send")
	public void get_request_to_get_newly_added_user_with_user_name_is_send() {
	    username = add_new_user_stepdef.username;
	    System.out.println("username in get with username = " + this.username);
		resp = add_new_user_stepdef.res.when().get(reader.getWithUsername(),username).then().log().all().extract().response();
		this.statusCode = resp.getStatusCode();
		System.out.println("statusCode in get with username = " + this.statusCode);
	}
	
	@Then("The status recieved is success code")
	public void the_status_recieved_is_success_code() {
		Assert.assertEquals(statusCode, 200, "Expected status code 200.");
	}

	@When("DELETE request with new user userName is send")
	public void delete_request_with_new_user_user_name_is_send() {
		 username = add_new_user_stepdef.username;
		 System.out.println("username in delete with username = " + this.username);
		resp = add_new_user_stepdef.res.when().delete(reader.deleteWithUsername(), username).then().log().all().extract().response();
		this.statusCode = resp.getStatusCode();	
		System.out.println("statusCode in delete with username = " + this.statusCode);
	}


}
