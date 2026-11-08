package ca.mbernardin;

import ca.mbernardin.dao.ConferenceDatabaseAccessObject;
import ca.mbernardin.model.Conference;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ConferenceDAO_test {

    @Test
    public void getAll() {
        ConferenceDatabaseAccessObject c = new ConferenceDatabaseAccessObject();
        assertNotNull(c.getAll());
    }


}