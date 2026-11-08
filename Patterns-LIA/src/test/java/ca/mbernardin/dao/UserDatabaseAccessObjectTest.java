package ca.mbernardin.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserDatabaseAccessObjectTest {
    @Test
    public void getAll() {
        assertNotNull(UserDatabaseAccessObject.getAll());
    }
    @Test
    public void getById() {
        assertNotNull(UserDatabaseAccessObject.getById(1));
    }
    @Test
    public void getById_invalid() {
        assertNull(UserDatabaseAccessObject.getById(-1));
    }
    @Test
    public void removeById() {
        assertTrue(UserDatabaseAccessObject.removeById(-1));
    }
    @Test
    public void create() {
        assertTrue(UserDatabaseAccessObject.create("test name", "test email", 20, "testhashedpassword"));
    }
    @Test
    public void create_invalid() {
        assertTrue(UserDatabaseAccessObject.create(null, null, 20, "testhashedpassword"));
    }
    @Test
    public void getIdByEmail() {
        assertEquals(1, UserDatabaseAccessObject.getIdByEmail("test email"));
    }
    @Test
    public void getIdByEmail_invalid() {
        assertEquals(-1, UserDatabaseAccessObject.getIdByEmail(null));
    }
    @Test
    public void updateFullName() {
        assertTrue(UserDatabaseAccessObject.updateFullName(1, "new name"));
    }
    @Test
    public void updateFullName_invalid() {
        assertTrue(UserDatabaseAccessObject.updateFullName(-1, "new name"));
    }
    @Test
    public void updateEmail() {
        assertTrue(UserDatabaseAccessObject.updateEmail(1, "new email"));
    }
    @Test
    public void updateEmail_invalid() {
        assertTrue(UserDatabaseAccessObject.updateEmail(-1, "new email"));
    }
    @Test
    public void updateAge() {
        assertTrue(UserDatabaseAccessObject.updateAge(1, 20));
    }
    @Test
    public void updateAge_invalid() {
        assertTrue(UserDatabaseAccessObject.updateAge(-1, 20));
    }
}
