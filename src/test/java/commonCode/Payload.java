package commonCode;

import java.util.HashMap;
import java.util.Map;

import utilities.ConfigReader;
import utilities.ExcelReader;

public class Payload {
	
	static ConfigReader reader = new ConfigReader();
	public static String userEmail;
	public static String plotNumber;
	public static String street;
	public static String state;
	public static String country;
	public static int zipCode;
	public static String user_first_name;
	public static String user_last_name;
	public static int user_contact_number;
	
	public static Map<String, Map<String, String>> testCaseDataMap = new HashMap<>();
	static Map<String, String> testData;
	
public static void loadTestCases() {
		
		ExcelReader excelReader = new ExcelReader(reader.getExcelFilepath(), "userData");
		testCaseDataMap = excelReader.readAllTestCases(); // Load all test cases for all login combinations
		System.out.println("Login test cases loaded successfully!" + testCaseDataMap.keySet());
		testData = testCaseDataMap.get("validUser");
		userEmail = testData.get("userEmailId");
		plotNumber = testData.get("plotNumber");
	    street = testData.get("street");
	    state = testData.get("state");
	    country = testData.get("country");
	   // zipCode = Integer.parseInt(testData.get("zipcode").replace(".0", ""));
	    
	    zipCode = (int) Double.parseDouble(testData.get("zipcode").split("\\.")[0]);
	    user_contact_number = (int) Double.parseDouble(testData.get("usercontactnumber"));
	    user_last_name = testData.get("userlastname");
	    user_first_name = testData.get("userfirstname");
	   // user_contact_number = Integer.parseInt(testData.get("usercontactnumber").replace(".0", ""));
	    System.out.println("user mail = " + userEmail);
	    System.out.println("plotNumber = " + plotNumber);
	    System.out.println("street = " + street);
	    System.out.println("user state = " + state);
	    System.out.println("user country = " + country);
	    System.out.println("user zipCode = " + zipCode);
	    System.out.println("user user_last_name = " + user_last_name);
	    System.out.println("user user_first_name = " + user_first_name);
	    System.out.println("user user_contact_number = " + user_contact_number);
	}	
	
	
public static String addNewUser() {
    return "{\r\n" +
            "  \"userAddress\": {\r\n" +
            "    \"plotNumber\": \"" + plotNumber + "\",\r\n" +
            "    \"street\": \"" + street + "\",\r\n" +
            "    \"state\": \"" + state + "\",\r\n" +
            "    \"country\": \"" + country + "\",\r\n" +
            "    \"zipCode\": " + zipCode + "\r\n" +
            "  },\r\n" +
            "  \"user_first_name\": \"" + user_first_name + "\",\r\n" +
            "  \"user_last_name\": \"" + user_last_name + "\",\r\n" +
          //  "  \"user_contact_number\": " + user_contact_number + ",\r\n" +
          "  \"user_contact_number\": 1222222222,\r\n" +
            "  \"user_email_id\": \"" + userEmail + "\",\r\n" +
            "  \"creation_time\": \"\",\r\n" +
            "  \"last_mod_time\": \"\"\r\n" +
            "}";
}

	/*
	 * public static String addNewUser() {
	 * 
	 * return "{\r\n" + "  \"userAddress\": {\r\n" + "   \r\n" +
	 * "    \"plotNumber\": \"capri-88\",\r\n" + "    \"street\": \"adb\",\r\n" +
	 * "    \"state\": \"ca\",\r\n" + "    \"country\": \"us\",\r\n" +
	 * "    \"zipCode\": 2345\r\n" + "  },\r\n" + "   \r\n" +
	 * "  \"user_first_name\": \"shree\",\r\n" +
	 * "  \"user_last_name\": \"redd\",\r\n" +
	 * "  \"user_contact_number\": 1222222222,\r\n" +
	 * "  \"user_email_id\": \"shree@gmial.com\",\r\n" +
	 * "  \"creation_time\": \"\",\r\n" + "  \"last_mod_time\": \"\"\r\n" + "}"; }
	 */
}
