package pojo;



public class Pojo_post_request {
	private String user_first_name;
	private String user_last_name;
	private long user_contact_number;
	private String user_email_id;
	private Pojo_post_address userAddress;
	private String endpoint;
	private int exp_statuscode;
	
   
	
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public long getUser_contact_number() {
		return user_contact_number;
	}
	public void setUser_contact_number(long user_contact_number) {
		this.user_contact_number = user_contact_number;
	}
	public String getUser_email_id() {
		return user_email_id;
	}
	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}
	public Pojo_post_address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Pojo_post_address userAddress) {
		this.userAddress = userAddress;
	}
	
	
	 public String getEndpoint() {
			return endpoint;
		}
		public void setEndpoint(String endpoint) {
			this.endpoint = endpoint;
		}
		public int getExp_statuscode() {
			return exp_statuscode;
		}
		public void setExp_statuscode(int exp_statuscode) {
			this.exp_statuscode = exp_statuscode;
		}
		
	

}
