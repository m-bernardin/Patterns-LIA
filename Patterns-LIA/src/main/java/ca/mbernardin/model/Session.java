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
        if(currentUser != null) {
            return currentUser.getUserId();
        }
        else {
            return -1;
        }
    }
    public static void clear() {
        currentUser = null;
    }

    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(Locale locale) {
        Session.locale = locale;
    }
}
