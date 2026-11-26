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
    public int getUserId() {
        return user_id;
    }

    public String getFullName() {
        return full_name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getUsertype() {
        return usertype;
    }
}
