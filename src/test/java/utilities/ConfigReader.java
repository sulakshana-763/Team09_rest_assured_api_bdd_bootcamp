package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties properties;
	public final static String filePath = "./src/test/resources/global.properties";

	 static {
	        try {
	            loadConfig();
	        } catch (Throwable e) {
	            throw new RuntimeException("Failed to load configuration properties", e);
	        }
	    }
	public static void loadConfig() throws Throwable {
		try {
			FileInputStream fis;
			fis = new FileInputStream(filePath);
			properties = new Properties();
			try {
				properties.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + filePath);
		}	
	}
	 public static String getBaseUrl() {
	        String baseUrl = properties.getProperty("base_Url");
	        if(baseUrl != null) return baseUrl;
	        else throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
	    }
	 
	 public static String createNewUser() {
	        String createUser = properties.getProperty("createUser");
	        if(createUser != null) return createUser;
	        else throw new RuntimeException("createUser not specified in the Configuration.properties file.");
	    }
	 
	 public static String getWithId() {
	        String getWithId = properties.getProperty("getWithId");
	        if(getWithId != null) return getWithId;
	        else throw new RuntimeException("getWithId not specified in the Configuration.properties file.");
	    }
	 
	 public static String getWithUsername() {
	        String getWithUsername = properties.getProperty("getWithUsername");
	        if(getWithUsername != null) return getWithUsername;
	        else throw new RuntimeException("getWithUsername not specified in the Configuration.properties file.");
	    }
	 
	 public static String deleteWithId() {
	        String deleteWithId = properties.getProperty("deleteWithId");
	        if(deleteWithId != null) return deleteWithId;
	        else throw new RuntimeException("deleteWithId not specified in the Configuration.properties file.");
	    }
	 
	 public static String deleteWithUsername() {
	        String deleteWithUsername = properties.getProperty("deleteWithUsername");
	        if(deleteWithUsername != null) return deleteWithUsername;
	        else throw new RuntimeException("deleteWithUsername not specified in the Configuration.properties file.");
	    }
	 
	 public static String updateUser() {
	        String updateUser = properties.getProperty("updateUser");
	        if(updateUser != null) return updateUser;
	        else throw new RuntimeException("updateUser not specified in the Configuration.properties file.");
	    }

	    public static String getUsername() {
	        String username = properties.getProperty("user_name");
	        if(username != null) return username;
	        else throw new RuntimeException("user_name not specified in the Configuration.properties file.");
	    }
	    public static String getUserPassword() {
	        String userPassword = properties.getProperty("user_Password");
	        if(userPassword != null) return userPassword;
	        else throw new RuntimeException("user_Password not specified in the Configuration.properties file.");
	    }
	    public static String getExcelFilepath() {
	        String excelFilepath = properties.getProperty("excel_Filepath");
	        if(excelFilepath != null) return excelFilepath;
	        else throw new RuntimeException("excel_Filepath not specified in the Configuration.properties file.");
	    }  

}
