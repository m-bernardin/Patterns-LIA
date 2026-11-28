package ca.mbernardin.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * HashingService
 * This class provides the hash() method, which allows passwords to be stored as sha256 hashed text, instead of plaintext.
 * @author Mathieu Bernardin
 */
public class HashingService{
    // This class should never be instantiated, and so the constructor is made private.
    private HashingService(){}
    /**
     * Uses sha256 to hash a plaintext String to cryptotext.
     * @param plaintext - the text to be hashed.
     * @return the provided plaintext, hashed through sha256.
     */
    public static String hash(String plaintext){
        MessageDigest digest;
        try{
            digest=MessageDigest.getInstance("SHA-256");
        }
        catch(NoSuchAlgorithmException e){
            // TODO implement this method in service.LoggingService
            // LoggingService.logCrypto(e);
            return null;
        }
        byte[] hash=digest.digest(plaintext.getBytes());
        plaintext=null;
        return Base64.getEncoder().encodeToString(hash);
    }
}
