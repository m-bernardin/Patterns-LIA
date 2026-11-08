package ca.mbernardin;

import ca.mbernardin.dao.ConferenceDatabaseAccessObject;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;


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
    public void getByID_invalid() {
        assertNull(ConferenceDatabaseAccessObject.getById(-1));
    }
    @Test
    public void create() {
        assertTrue(ConferenceDatabaseAccessObject.create("test title", 2, Date.valueOf("2025-01-01"), Date.valueOf("2025-01-01"), "montreal"));
    }
    @Test
    public void create_invalid() {
        assertTrue(ConferenceDatabaseAccessObject.create(null, -2, null, null, null));
    }
    @Test
    public void removeByID() {
        assertTrue(ConferenceDatabaseAccessObject.removeById(-1));
    }
    @Test
    public void updateTitle() {
        assertTrue(ConferenceDatabaseAccessObject.updateTitle(3, "test title"));
    }
    @Test
    public void updateTitle_invalid() {
        assertTrue(ConferenceDatabaseAccessObject.updateTitle(-3, "test title"));
    }
    @Test
    public void updateCapacity() {
        assertTrue(ConferenceDatabaseAccessObject.updateCapacity(4, 10));
    }
    @Test
    public void updateCapacity_invalid() {
        assertTrue(ConferenceDatabaseAccessObject.updateCapacity(-4, 10));

    }
    @Test
    public void updateStartDate() {
        assertTrue(ConferenceDatabaseAccessObject.updateStartDate(5, Date.valueOf("2025-01-01")));
    }
    @Test
    public void updateStartDate_invalid() {
        assertTrue(ConferenceDatabaseAccessObject.updateStartDate(-5, Date.valueOf("2025-01-01")));
    }
    @Test
    public void updateEndDate() {
        assertTrue(ConferenceDatabaseAccessObject.updateEndDate(6, Date.valueOf("2025-01-01")));
    }
    @Test
    public void updateEndDate_invalid() {
        assertTrue(ConferenceDatabaseAccessObject.updateEndDate(-6, Date.valueOf("2025-01-01")));
    }
    @Test
    public void updateLocation() {
        assertTrue(ConferenceDatabaseAccessObject.updateLocation(7, "Laval"));
    }
    @Test
    public void updateLocation_invalid() {
        assertTrue(ConferenceDatabaseAccessObject.updateLocation(-7, "Laval"));
    }
}