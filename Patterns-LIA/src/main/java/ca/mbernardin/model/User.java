package ca.mbernardin.model;

/**
 * User
 */
public class User {
    private int user_id;
    private String full_name;
    private String email;
    private int age;
    private String usertype;
    public User(int user_id,String full_name,String email,int age,String usertype){
	    this.user_id=user_id;
        this.full_name=full_name;
        this.email=email;
        this.age=age;
        this.usertype=usertype;
    }
    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
