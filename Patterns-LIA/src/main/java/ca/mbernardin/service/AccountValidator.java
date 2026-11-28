package ca.mbernardin.service;

import ca.mbernardin.service.exceptions.InvalidFormatException;

/**
 * AccountValidator
 * Provides methods for validating account information.
 * @author Mathieu Bernardin
 */
public class AccountValidator {
    /**
     * Regex pattern to validate a name.
     */
    private static final String NAME_PATTERN="^(([A-Z][a-z]+(-[A-Z][a-z]+)?) ){2,}$";
    // TODO add all domain extensions
    // TODO verify the \\ works as expected
    /**
     * Regex pattern to validate an email.
     */
    private static final String EMAIL_PATTERN="^[a-zA-Z0-9\\.\\-_]+@[a-zA-Z0-9\\.\\-_]+\\.(com|ca|org|gov|info|wiki)$";
    /**
     * Regex pattern to validate a password.
     */
    private static final String PSSWD_PATTERN="^[a-zA-Z0-9\\.\\-\\?#_!@]{10,}$";
    /**
     * Stores all special characters allowed in a password.
     */
    public static final char[] PSSWD_SPECIAL_CHARS={'.','-','?','#','_','!','@'};
    // This class should never be instantiated, and so the constructor is made private.
    private AccountValidator(){}
    /**
     * Validates information for a new account.
     * @param name - the name for the new account.
     * @param email - the email for the new account.
     * @param age - the age for the new account.
     * @param psswd - the password for the new account.
     * @return true if all parameters are valid.
     * @throws InvalidFormatException - if not all parameters are valid.
     */
    public static boolean validateNewAccount(String name,String email,String age,String psswd)throws InvalidFormatException{
        InvalidFormatException exception=new InvalidFormatException();
        name.trim();
        email.trim();
        age.trim();
        psswd.trim();
        // required to satisfy the space at the end of NAME_PATTERN's core pattern group
        name+=" ";
        if(!name.matches(NAME_PATTERN))exception.invalidateName();
        if(!email.matches(EMAIL_PATTERN))exception.invalidateEmail();
        if(!psswd.matches(PSSWD_PATTERN))exception.invalidatePsswd();
        if(!validateAge(age))exception.invalidateAge();
        if(!exception.isEmpty())throw exception;
        return true;
    }
    // TODO determine if we want a min age
    /**
     * Validates an age value.
     * @param age - the age to be validated.
     * @return true if age is a positive, non-zero integer; false otherwise.
     */
    private static boolean validateAge(String age){
        try{
            int ageVal=Integer.parseInt(age);
            return ageVal>0;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
