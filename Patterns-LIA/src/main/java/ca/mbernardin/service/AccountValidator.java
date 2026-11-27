package ca.mbernardin.service;

/**
 * AccountValidator
 */
public class AccountValidator {
    private String fullNamePattern="^(([A-Z][a-z]+(-[A-Z][a-z]+)?) ){2,}$";
    // TODO add all domain extensions
    // TODO verify the \\ works as expected
    private String emailPattern="^[a-zA-Z0-9\\.\\-_]+@[a-zA-Z0-9\\.\\-_]+\\.(com|ca|org|gov|info|wiki)$";
    private String psswdPattern="^[a-zA-Z0-9\\.\\-\\?#_!@]{10,}$";
    private char[] psswdSpecialChars={'.','-','?','#','_','!','@'};
}
