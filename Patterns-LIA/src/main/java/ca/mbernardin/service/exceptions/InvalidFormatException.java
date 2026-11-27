package ca.mbernardin.service.exceptions;

import java.util.HashSet;
import java.util.Set;

/**
 * InvalidFormatException
 */
public class InvalidFormatException extends Exception{
    private Set<String> causes=new HashSet<>();
    public void invalidateName(){causes.add("name");}
    public void invalidateEmail(){causes.add("email");}
    public void invalidateAge(){causes.add("age");}
    public void invalidatePsswd(){causes.add("psswd");}
    public Set<String> getCauses(){return causes;}
    public boolean isEmpty(){return causes.isEmpty();}
}
