package ca.mbernardin;

import ca.mbernardin.dao.ConferenceDatabaseAccessObject;
import ca.mbernardin.model.Conference;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ConferenceDAO_test {

    @Test
    public void getAll() {
        assertNotNull(ConferenceDatabaseAccessObject.getAll());
    }
    @Test
    public void getByID() {
        assertNotNull(ConferenceDatabaseAccessObject.getById(1));
    }
    @Test
    public void create() {
        assertTrue(ConferenceDatabaseAccessObject.create("test title", 2, Date.valueOf("2025-01-01"), Date.valueOf("2025-01-01"), "montreal"));
    }


}