package ca.mbernardin.model;

import java.util.Locale;

public class Session {
    private static User currentUser;
    private static Locale locale = Locale.ENGLISH;

    public static User getCurrentUser() {
        return currentUser;
    }
    public static void setCurrentUser(User newUser) {
        currentUser = newUser;
    }
    public static int getCurrentUserId() {
        return currentUser.getUserId();
    }



}
