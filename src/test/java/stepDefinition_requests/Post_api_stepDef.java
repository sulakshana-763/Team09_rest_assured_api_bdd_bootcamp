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
	private RequestSpecification resOfReq;
	private Response response;
	private List<Pojo_payload_list> testCases;
	
	private Pojo_post_request reqdata =new Pojo_post_request();
	private PostTestdataBuild data =new PostTestdataBuild();
	
	private String endpoint =ConfigReader.endpoint();
	
	
	@Given("User sets Auth type as basic auth and enters {string} and {string}")
	public void user_sets_auth_type_as_basic_auth_and_enters_and(String string, String string2) throws FileNotFoundException {
		
		requestUrl();
	    
	}

	@Given("new user request payload with valid fields and sets Post with valid URI")
	public void new_user_request_payload_with_valid_fields_and_sets_post_with_valid_uri() throws IOException {
		
//		// Load JSON file
//        ObjectMapper objectMapper = new ObjectMapper();
//        PostTestdataBuild testData = objectMapper.readValue(new File("./src/test/resource/TestDataNiranj/testdatajson.json"), PostTestdataBuild.class);
//        testCases = testData.getTestCases();
//	   
//        // Iterate over each test case
//        for (Pojo_payload_list testCase : testCases) {
//        	List<Pojo_post_request> users= testCase.getUsers();
//            for (Pojo_post_request user : users) {
//            	resOfReq = given().contentType(ContentType.JSON).spec(requestUrl()).body(user);
//            			}
//            }
                       
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
                
                
                
	  // resOfReq= given().spec(requestUrl()).body();


	}

	@When("user sends the {string} with valid {string}")
	public void user_sends_the_with_valid(String postRequest, String valid) {
		// Extract the endpoint from the test data
		
	   
		
		 resspec =new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		 response = resOfReq.when().post(endpoint).then().spec(resspec).extract().response();
	
		 System.out.println("Response Received: " + response.getStatusCode()); 
	}

	@Then("user receives {string} as {string}")
	public void user_receives_as(String string, String string2) {
		 //int statuscode = reqdata.getExp_statuscode();
		assertEquals(response.getStatusCode(), 201 );
		
	    System.out.println("Response Received: " + response.getStatusCode()); 
	   
	    
	
	


	
	    try {
	        String userId = getJsonPath(response, "user_id");
	        System.out.println("userId: " + userId);
	    } catch (Exception ignored) {
	        System.out.println("Key 'user_id' not found in response JSON.");
	    }
	}

}
