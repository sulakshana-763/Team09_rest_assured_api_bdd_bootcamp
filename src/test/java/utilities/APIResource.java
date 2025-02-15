package utilities;

public enum APIResource {
	PostRequestAPI ("/uap/createusers"),
	PutRequestAPI ("​/uap​/updateuser​/{userId}"),
	GetuserFirstnameAPI ("/uap/users/username/{userFirstName}"),
    GetUserIdAPI ("​/uap/user/{userId}"),
    GeleteuserFirstnameAPI ("​/uap​/deleteuser​/username​/{userFirstName}"),
	DeleteUserIdAPI("​/uap​/deleteuser​/{userId}");
	String resource;

	APIResource(String resource) {
	this.resource = resource;	
	}
	
	public String getResource() {
		return resource;
	}
	
	public String getuserid(String userId)
	{
	return  "{\"user_id\": "+userId+"}";
	}
	       
	}


