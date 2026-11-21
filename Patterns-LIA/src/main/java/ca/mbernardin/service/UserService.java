package ca.mbernardin.service;

import ca.mbernardin.dao.UserDatabaseAccessObject;

public class UserService {
    private UserDatabaseAccessObject userdao = new UserDatabaseAccessObject();

    public void serviceCreate(String fullname, String email, String age, String password) {
        if(isValidName(fullname) && isValidEmail(email) && isRightAge(numerizeAge(age))) {
            userdao.create(fullname, email, numerizeAge(age), password);
            System.out.println("User created");
        }
    }

    public boolean isValidName(String name) {
        if(name==null) return false;
        return name.matches("[a-zA-Z ]+");
    }
    public boolean isValidEmail(String email) {
        if(email==null) return false;
        return email.matches("^[a-zA-Z\\d._-]+@[a-zA-Z\\d._-]+\\.[a-zA-Z]{2,}$");
    }
    public boolean isRightAge(int age) {
        return age<18;
    }
    public int numerizeAge(String age) {
        if(age==null || !age.matches("[\\d]*")) return 0;
        return Integer.parseInt(age);
    }
}
