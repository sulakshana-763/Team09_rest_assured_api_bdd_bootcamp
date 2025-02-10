package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ConfigReader {
	
	    private static Properties properties;
	    private final static String propertyFilePath = ".\\Config\\config.properties";    
	    
	    
	    public static void readConfig() throws Throwable {
	        InputStream fis;
	        fis = ConfigReader.class.getClassLoader().getResourceAsStream(propertyFilePath);
	        properties = new Properties();
	        if (fis == null) {
	            throw new FileNotFoundException("Property file '" + propertyFilePath + "' not found in the classpath");
	        }
	        try {
	            properties.load(fis);
	            fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	    
	    
	    public static String baseUrl()
        {    	
             String BaseURL=properties.getProperty("baseurl");
             if (BaseURL != null)
                return BaseURL;
             else 
                 throw new RuntimeException("baseurl not specified in the Config.properties file");
        }
	    
	    public static String username()
        {    	
             String UserName=properties.getProperty("username");
             if (UserName != null)
                return UserName;
             else 
                 throw new RuntimeException("username not specified in the Config.properties file");
        }
	    
	    
	    public static String password()
        {    	
             String PassWord=properties.getProperty("password");
             if (PassWord != null)
                return PassWord;
             else 
                 throw new RuntimeException("PassWord not specified in the Config.properties file");
        }
	    static {
	        try {
				readConfig(); //static block to ensure readConfig() is called automatically before any method is accessed.
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    
	    public static String endpoint()
        {    	
             String EndPoint=properties.getProperty("endpoint");
             if (EndPoint != null)
                return EndPoint;
             else 
                 throw new RuntimeException("EndPoint not specified in the Config.properties file");
        }
	    static {
	        try {
				readConfig(); //static block to ensure readConfig() is called automatically before any method is accessed.
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	    
	    
	    
	    
	    
	   
	    }
