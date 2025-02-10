package pojo;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PostTestdataBuild {
	
//	    private List<Pojo_payload_list> testCases;
//
//	    public List<Pojo_payload_list> getTestCases() {
//	        return testCases;
//	    }
//
//	    public void setTestCases(List<Pojo_payload_list> testCases) {
//	        this.testCases = testCases;
//	    }
	
	private List<Pojo_payload_list> requests;

    public List<Pojo_payload_list> getRequests() {
        return requests;
    }

    public void setRequests(List<Pojo_payload_list> requests) {
        this.requests = requests;
    }
	    
	    
	    
	    
	    
	    
}
	
	
	
	
	
	
	
	
	
	
	
	
//	public static Pojo_post_request createPayload(JSONObject userjsondata) {
//		 Pojo_post_request postrequest= new Pojo_post_request();
//		   postrequest.setUser_first_name((String) userjsondata.get("user_first_name"));
//		   postrequest.setUser_last_name((String) userjsondata.get("user_last_name"));
//		   postrequest.setUser_contact_number((long) userjsondata.get("user_contact_number"));
//		   postrequest.setUser_email_id((String) userjsondata.get("user_email_id"));
//		   
//		   Pojo_post_address address =new Pojo_post_address();
//		   address.setPlotNumber((String) userjsondata.get("plotNumber"));
//		   address.setStreet((String) userjsondata.get("street"));
//		   address.setState((String) userjsondata.get("state"));
//		   address.setCountry((String) userjsondata.get("country"));
//		   address.setZipCode((int) userjsondata.get("zipCode"));
//		   postrequest.setUserAddress(address);
//		   return postrequest;
//		   
//		   
//	}
	
//public JSONObject readDataFromJsonFile() throws IOException, ParseException {
//	JSONParser jsonparser = new JSONParser();
//	try {
//		
//		FileReader reader = new FileReader("./src/test/resource/TestDataNiranj/testdatajson.json");
//		JSONArray jsonarray = (JSONArray)jsonparser.parse(reader);
//		
//		
//		for (Object obj:jsonarray) {
//			JSONObject reqObj = (JSONObject)obj;
//		    JSONArray request = (JSONArray)reqObj.get("requests");
//		
//			
//		for (Object reqobj:request) {
//			JSONObject req = (JSONObject)reqobj;
//			JSONArray dataarray = (JSONArray)req.get("data");
//			
//			
//		for (Object dataobj: dataarray) {
//			 JSONObject userjsondata = (JSONObject) dataobj;
//			 
//			 Pojo_post_request postRequest = createPayload(userjsondata);
//			 System.out.println("Generated Payload: " + postRequest);
//			 
//		}
//		}
//		}
//		} catch (FileNotFoundException e) {
//		
//		e.printStackTrace();
//}
//	return JSONObject;
//	
	
	
	
//	 postrequest.setUser_first_name("Britto");
//	   postrequest.setUser_last_name("jones");
//	   postrequest.setUser_contact_number(9427627869L);
//	   postrequest.setUser_email_id("jodrgy@britto.com");
//	   
//	   Pojo_post_address address =new Pojo_post_address();
//	   address.setPlotNumber("Y-45");
//	   address.setStreet("hallmark street");
//	   address.setState("utao");
//	   address.setCountry("US");
//	   address.setZipCode(76568);
//	   postrequest.setUserAddress(address);
//	   return postrequest;	
	
	
//	String ufirstName = (String) userjsondata.get("user_first_name");
//	String ufirstName = (String) userjsondata.get("user_first_name");
//	String ufirstName = (String) userjsondata.get("user_contact_number");
//	String ufirstName = (String) userjsondata.get("user_email_id");
//	
//	String ufirstName = (String) userjsondata.get("plotNumber");
//	String ufirstName = (String) userjsondata.get("street");
//	String ufirstName = (String) userjsondata.get("state");
//	String ufirstName = (String) userjsondata.get("country");
//	String ufirstName = (String) userjsondata.get("zipCode");
//}
	
	
	
	

	
	

//}
