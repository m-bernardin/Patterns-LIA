package ca.mbernardin.service.exceptions;

import java.util.HashSet;
import java.util.Set;

import ca.mbernardin.service.AccountValidator;

/**
 * InvalidFormatException
 * Allows controllers to access context on why an accounts information is not valid.
 * @see AccountValidator
 * @author Mathieu Bernardin
 */
public class InvalidFormatException extends Exception{
    /**
     * Keeps track of the causes for invalidity.
     */
    private Set<String> causes=new HashSet<>();
    /**
     * Adds name to the Set of causes for invalidity.
     */
    public void invalidateName(){causes.add("name");}
    /**
     * Adds email to the Set of causes for invalidity.
     */
    public void invalidateEmail(){causes.add("email");}
    /**
     * Adds age to the Set of causes for invalidity.
     */
    public void invalidateAge(){causes.add("age");}
    /**
     * Adds password to the Set of causes for invalidity.
     */
    public void invalidatePsswd(){causes.add("psswd");}
    /**
     * Gets the causes for invalidity.
     * @return the Set of invalidity causes.
     */
    public Set<String> getCauses(){return causes;}
    /**
     * Determines if any invalidity causes have been added.
     * @return true if causes is empty; false otherwise.
     */
    public boolean isEmpty(){return causes.isEmpty();}
}
