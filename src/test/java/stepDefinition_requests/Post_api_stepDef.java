package stepDefinition_requests;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Pojo_post_address;
import pojo.Pojo_post_request;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Post_api_stepDef {
	ResponseSpecification resspec;
	RequestSpecification res;
	Response response;
	
	@Given("User sets Auth type as basic auth and enters {string} and {string}")
	public void user_sets_auth_type_as_basic_auth_and_enters_and(String string, String string2) {
	    
	    
	}

	@Given("new user request payload with valid fields and sets Post with valid URI")
	public void new_user_request_payload_with_valid_fields_and_sets_post_with_valid_uri() {
	   //RestAssured.baseURI = "https://userserviceapp-f5a54828541b.herokuapp.com";
	   Pojo_post_request postrequest= new Pojo_post_request();
	   postrequest.setUser_first_name("Britto");
	   postrequest.setUser_last_name("jones");
	   postrequest.setUser_contact_number(6765446789L);
	   postrequest.setUser_email_id("jonr@gmail.com");
	   
	   Pojo_post_address address =new Pojo_post_address();
	   address.setPlotNumber("Y-45");
	   address.setStreet("hallmark street");
	   address.setState("utao");
	   address.setCountry("US");
	   address.setZipCode(76568);
	   postrequest.setUserAddress(address);
	    
	   RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://userserviceapp-f5a54828541b.herokuapp.com")
			   .setContentType(ContentType.JSON).build();
	   resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	   res= given().spec(req).body(postrequest);


	}

	@When("user sends the {string} with valid {string}")
	public void user_sends_the_with_valid(String string, String string2) {
	   response = res.when().post("/uap/createusers").then().spec(resspec).extract().response();
		
	    
	}

	@Then("user receives {string} as {string}")
	public void user_receives_as(String string, String string2) {
	    assertEquals(response.getStatusCode(), 200);
	    
	}

	

	@Then("{string} is {string}")
	public void is(String key, String expvalue) {
	    String resp = response.asString();
	    JsonPath js = new JsonPath(resp);
	    assertEquals(js.get(key).toString(),expvalue);
	}


}
