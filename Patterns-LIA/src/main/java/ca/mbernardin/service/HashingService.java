package ca.mbernardin.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * HashingService
 */
public class HashingService{
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
