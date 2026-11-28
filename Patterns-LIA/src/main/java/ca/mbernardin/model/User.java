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
}
