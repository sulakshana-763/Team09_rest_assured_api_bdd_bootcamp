package stepDefinition_requests;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Pojo_payload_list;
import pojo.Pojo_post_request;
import pojo.PostTestdataBuild;
import utilities.APIResource;
import utilities.ConfigReader;
import utilities.ElementUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
public class Post_api_stepDef extends ElementUtils {
	private ResponseSpecification resspec;
	private  RequestSpecification resOfReq;
	private Response response;
	private List<Pojo_payload_list> testCases;
	
	private Pojo_post_request reqdata =new Pojo_post_request();
	private PostTestdataBuild data =new PostTestdataBuild();
	
	private Response delresponse;
	
	 static String userId;
	
	
	@Given("User sets Auth type as basic auth and enters {string} and {string}")
	public void user_sets_auth_type_as_basic_auth_and_enters_and(String string, String string2) throws FileNotFoundException {
		
		requestUrl();
	    
	}

	@Given("new user request payload with valid fields and sets Post with valid URI")
	public void new_user_request_payload_with_valid_fields_and_sets_post_with_valid_uri() throws IOException {
		
                  
		 // Load JSON file
	    ObjectMapper objectMapper = new ObjectMapper();
	    PostTestdataBuild testData = objectMapper.readValue(new File("./src/test/resource/TestDataNiranj/testdatajson.json"), PostTestdataBuild.class);
	    
	    // Iterate over each request (valid and negative scenarios)
	    for (Pojo_payload_list request : testData.getRequests()) {
	        List<Pojo_post_request> users = request.getData(); // Extract user data
	        
	        for (Pojo_post_request user : users) {
	            resOfReq = given()
	                .contentType(ContentType.JSON)
	                .spec(requestUrl())
	                .body(user);
	        }
	    }                                     
                
                
	}

	@When("user sends the {string} with {string}")
	public void user_sends_the_with(String method, String resource) throws IOException {
		
		
		// constructor will be called with the value of resource
	APIResource resourceApi = APIResource.valueOf(resource);
	System.out.println(resourceApi.getResource());
	
	resspec = new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .build();
	
//	if (method.equalsIgnoreCase("Post"))
//		response = resOfReq.when().post(resourceApi.getResource());
//	else if (method.equalsIgnoreCase("Get"))
//		response = resOfReq.when().get(resourceApi.getResource());
	response = resOfReq.when().post(resourceApi.getResource());
	
	 userId = getJsonPath(response,  "user_id");
     System.out.println("userId: " + userId);
	
		
  
	      	}
	
	
	@Then("user receives {string} as {string}")
	public void user_receives_as(String resource, String string2) throws IOException   {
		
		assertEquals(response.getStatusCode(), 201 );
		
	    System.out.println("Response Received: " + response.getStatusCode()); 
		  
//		 userId = getJsonPath(response,  "user_id");
//	     System.out.println("userId: " + userId);
//	     resOfReq = given().spec(requestUrl()).pathParams("userId: ", userId);
//	     user_sends_the_with("Get", resource);
	 
	    
	  	}
	
// get request

	@Given("user sets get request with valid userid")
	public void user_sets_get_request_with_valid_userid() throws FileNotFoundException {
		
		resOfReq = given().spec(requestUrl());

//		response= given().spec(requestUrl()).when().get("/uap/user/21234");
//		System.out.println(response.asString());
		
		}

@When("user sends the  {string} request with {string}")
public void user_sends_the_request_with(String string, String resource) throws IOException {
	APIResource resourceApi = APIResource.valueOf(resource);
	System.out.println(resourceApi.getResource());
	response = resOfReq.when().get("/uap/user/"+userId+"");
	
	  // user_sends_the_with("Get", resource );
  
}

	@Then("user receives {string} as {string} with response payload")
	public void user_receives_as_with_response_payload(String string, String string2) {
    assertEquals(response.getStatusCode(), 200 );
		
	    System.out.println("Response Received: " + response.getStatusCode()); 
			   
	}
	
	@Given("user sets delete request with valid userid")
	public void user_sets_delete_request_with_valid_userid() throws FileNotFoundException {
		resOfReq = given().spec(requestUrl());
	}
	
	@When("user sends the delete request {string} with {string}")
	public void user_sends_the_delete_request_with(String string, String resource) {
		APIResource resourceApi = APIResource.valueOf(resource);
		System.out.println(resourceApi.getResource());
		response = resOfReq.when().delete("/uap/deleteuser/"+userId+"");
		
	}
	
	@Then("user receives {string} as {string} ok")
	public void user_receives_as_ok(String string, String string2) {
		 assertEquals(response.getStatusCode(),200);
			
		    System.out.println("Response Received: " + response.getStatusCode()); 
	}
	
	@Then("user receives {string} as {string} message")
	public void user_receives_as_message(String keyValue, String ExpectedValue) {
		
	  assertEquals(getJsonPath(response,keyValue), ExpectedValue);
	}

		
}
