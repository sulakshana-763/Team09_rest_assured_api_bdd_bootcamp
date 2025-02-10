package utilities;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.Pojo_payload_list;
import pojo.Pojo_post_request;
import pojo.PostTestdataBuild;

public class ElementUtils {
	
	private Response response;
	private List<Pojo_payload_list> testCases;

	private static RequestSpecification req ;
	String UserName=ConfigReader.username();
	String PassWord = ConfigReader.password();
	String BaseUrl =ConfigReader.baseUrl();
	private PreemptiveBasicAuthScheme authBasic = new PreemptiveBasicAuthScheme();
	public RequestSpecification requestUrl() throws FileNotFoundException {
		{
			if (req==null)
			{
		
		 PrintStream logStream = new  PrintStream(new FileOutputStream("logging.txt"));
			authBasic.setUserName(UserName);
			authBasic.setPassword(PassWord);
		//RestAssured.baseURI = "https://userserviceapp-f5a54828541b.herokuapp.com";
  	    req =new RequestSpecBuilder().setBaseUri(BaseUrl)
				   .setAuth(authBasic)
				   .addFilter(RequestLoggingFilter.logRequestTo(logStream))
				   .addFilter(ResponseLoggingFilter.logResponseTo(logStream) )
				   .setContentType(ContentType.JSON).build();
  	    return req;
			}
		}
		return req;
		
	}

//	public String getJsonPath(Response response, String key) {
//	    JsonPath jsonPath = new JsonPath(response.asString());
//	    
//	    // Check if the key exists before accessing it
//	    if (jsonPath.getMap("$").containsKey(key)) {
//	        return jsonPath.getString(key);
//	    } else {
//	        throw new RuntimeException("Key '" + key + "' not found in response JSON.");
//	    }
//	}
	
	
	
	public static String getJsonPath(Response response, String key) {
        if (response == null) {
            throw new NullPointerException("Response is null. Ensure API call is made before calling getJsonPath.");
        }

        String respBody = response.asString();
        System.out.println("Response Body: " + respBody);  // Debugging
        
        JsonPath jsonPath = new JsonPath(respBody);
        
        if (jsonPath.get(key) == null) {
            throw new RuntimeException("Key '" + key + "' not found in response JSON.");
        }

        return jsonPath.get(key).toString();
    }
	
	
	
	
	
	

	
//	public void readfileJsonUsingPojoClasses() throws  DatabindException, IOException{
//		// Load JSON file
//        ObjectMapper objectMapper = new ObjectMapper();
//        PostTestdataBuild testData = objectMapper.readValue(new File("./src/test/resource/TestDataNiranj/testdatajson.json"), PostTestdataBuild.class);
//        testCases = testData.getTestCases();
//	   
//        // Iterate over each test case
//        for (Pojo_payload_list testCase : testCases) {
//        	List<Pojo_post_request> users= testCase.getUsers();
//        	
//        	
//        	
//        	
//            for (Pojo_post_request user : users) {
//                response = (Response) given()
//                        .contentType(ContentType.JSON);
                        
	//}
	
      //  }
      //  }

}