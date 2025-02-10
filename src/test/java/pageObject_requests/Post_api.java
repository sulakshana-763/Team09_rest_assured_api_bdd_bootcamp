package pageObject_requests;

public class Post_api {
	
	public String postParams;
	public String getParamsWithId;
	public String getParamsWithUserName;
	public String putParamsWithId;
	public String deleteParamsWithId;
	public String deleteParamsWithUserName;
	
	
public String addNewUser() {
		
		return "{\r\n" +
				  "  \"userAddress\": {\r\n" + "   \r\n" +
				  "    \"plotNumber\": \"capri-88\",\r\n" + "    \"street\": \"adb\",\r\n" +
				  "    \"state\": \"ca\",\r\n" + "    \"country\": \"us\",\r\n" +
				  "    \"zipCode\": 2345\r\n" + "  },\r\n" + "   \r\n" +
				  "  \"user_first_name\": \"shree\",\r\n" +
				  "  \"user_last_name\": \"redd\",\r\n" +
				  "  \"user_contact_number\": 1222222222,\r\n" +
				  "  \"user_email_id\": \"shree@gmial.com\",\r\n" +
				  "  \"creation_time\": \"\",\r\n" + "  \"last_mod_time\": \"\"\r\n" +
				  "}";
	}

}
