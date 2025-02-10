package pojo;

import java.util.List;

public class Pojo_payload_list {
//	private List<Pojo_post_request> users;
//
//    public List<Pojo_post_request> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<Pojo_post_request> users) {
//        this.users = users;
//    }

	
	private String name;
    private List<Pojo_post_request> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pojo_post_request> getData() {
        return data;
    }

    public void setData(List<Pojo_post_request> data) {
        this.data = data;
    }

}
