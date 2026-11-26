package ca.mbernardin.service;

import ca.mbernardin.dao.UserDatabaseAccessObject;
import ca.mbernardin.model.Session;

public class UserService {
    //private UserDatabaseAccessObject userdao = new UserDatabaseAccessObject();

    static public void serviceCreate(String fullname, String email, String age, String password) {
        if(isValidName(fullname) && isValidEmail(email) && isRightAge(numerizeAge(age))) {
            UserDatabaseAccessObject.create(fullname, email, numerizeAge(age), password);
            System.out.println("User created");
        }
    }
    public static void serviceModifyName(String fullname) {
        if(isValidName(fullname)) {
            UserDatabaseAccessObject.updateFullName(Session.getCurrentUserId(), fullname);
        }
    }
    public static void serviceModifyEmail(String email) {
        if(isValidEmail(email)) {
            UserDatabaseAccessObject.updateEmail(Session.getCurrentUserId(), email);
        }

    }
    public static void serviceModifyAge(String age) {
        if(isRightAge(numerizeAge(age))) {
            UserDatabaseAccessObject.updateAge(Session.getCurrentUserId(), numerizeAge(age));
        }
    }

    public static boolean isValidName(String name) {
        if(name==null) return false;
        return name.matches("[a-zA-Z ]+");
    }
    public static boolean isValidEmail(String email) {
        if(email==null) return false;
        return email.matches("^[a-zA-Z\\d._-]+@[a-zA-Z\\d._-]+\\.[a-zA-Z]{2,}$");
    }
    public static boolean isRightAge(int age) {
        return age<18;
    }
    public static int numerizeAge(String age) {
        if(age==null || !age.matches("[\\d]*")) return 0;
        return Integer.parseInt(age);
    }
}
