package ca.mbernardin.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * PasswordDatabaseAccessObjectTest
 */
public class PasswordDatabaseAccessObjectTest {
    @BeforeEach
    public void build(){
        DatabaseAccessObject.intializeDatabase();
    }
    @AfterEach
    public void teardown(){
        File database=new File("../../../../../main/resources/ca/mbernardin/database/database.db");
        database.delete();
    }
    @Test
    public void rejectsDuplicateIdCreatePasswordTest(){
        assertFalse(PasswordDatabaseAccessObject.create(1,"testPassword"));
    }
    @Test void rejectsBadIdCreatePasswordTest(){
        assertFalse(PasswordDatabaseAccessObject.create(-1,"testPassword"));
    }
    @Test
    public void acceptsValidPasswordCreationTest(){
        assertTrue(PasswordDatabaseAccessObject.create(6,"testPassword"));
    }
    @Test
    public void acceptsValidPasswordUpdateTest(){
        assertTrue(PasswordDatabaseAccessObject.update(2,"testPassword"));
    }
    @Test
    public void rejectsInvalidPasswordUpdateTest(){
        assertFalse(PasswordDatabaseAccessObject.update(7,"testPassword"));
        assertFalse(PasswordDatabaseAccessObject.update(-1,"testPassword"));
    }
    @Test
    public void validatesGoodPasswordTest(){
        assertTrue(PasswordDatabaseAccessObject.validatePassword(3,"ali123"));
    }
    @Test
    public void doesNotValidateBadPasswordTest(){
        assertFalse(PasswordDatabaseAccessObject.validatePassword(3,"testPassword"));
    }
    @Test
    public void doesNotValidateInvalIdPasswordTest(){
        assertFalse(PasswordDatabaseAccessObject.validatePassword(-1,"testPassword"));
        assertFalse(PasswordDatabaseAccessObject.validatePassword(7,"testPassword"));
    }
}
