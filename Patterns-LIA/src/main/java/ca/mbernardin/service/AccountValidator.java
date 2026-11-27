package ca.mbernardin.service;

import ca.mbernardin.service.exceptions.InvalidFormatException;

/**
 * AccountValidator
 */
public class AccountValidator {
    private static final String NAME_PATTERN="^(([A-Z][a-z]+(-[A-Z][a-z]+)?) ){2,}$";
    // TODO add all domain extensions
    // TODO verify the \\ works as expected
    private static final String EMAIL_PATTERN="^[a-zA-Z0-9\\.\\-_]+@[a-zA-Z0-9\\.\\-_]+\\.(com|ca|org|gov|info|wiki)$";
    private static final String PSSWD_PATTERN="^[a-zA-Z0-9\\.\\-\\?#_!@]{10,}$";
    public static final char[] PSSWD_SPECIAL_CHARS={'.','-','?','#','_','!','@'};
    public static boolean validateNewAccount(String name,String email,int age,String psswd){
        InvalidFormatException exception=new InvalidFormatException();        
        if(!name.matches(NAME_PATTERN))exception.invalidateName();
        if(!email.matches(EMAIL_PATTERN))exception.invalidateEmail();
        if(!psswd.matches(PSSWD_PATTERN))exception.invalidatePsswd();
        if(!validateAge(age))exception.invalidateAge();
        if(!exception.isEmpty())throw exception;
        return true;
    }
    // TODO determine if we want a min age
    private static boolean validateAge(int age){return age>0;}
}
