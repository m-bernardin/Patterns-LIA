package ca.mbernardin.i18n;

import ca.mbernardin.model.Session;

import java.util.Locale;
import java.util.ResourceBundle;

public final class I18n {
    private I18n(){}

    public static ResourceBundle bundle() {
        Locale locale = Session.getLocale();
        if(locale == null) locale = Locale.ENGLISH;
        return ResourceBundle.getBundle("ca.mbernardin.i18n.messages", locale);
    }

    public static String translate(String key) {
        return bundle().getString(key);
    }
}
