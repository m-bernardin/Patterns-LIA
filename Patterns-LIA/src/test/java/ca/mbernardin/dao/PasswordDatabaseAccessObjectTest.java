package ca.mbernardin.dao;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * PasswordDatabaseAccessObjectTest
 */
public class PasswordDatabaseAccessObjectTest {
    @BeforeAll
    public void build(){
        DatabaseAccessObject.intializeDatabase();
    }
    @AfterAll
    public void teardown(){
        File database=new File("../../../../../main/resources/ca/mbernardin/database/database.db");
        database.delete();
    }
    @Test
    public void rejectsDuplicatePasswordTest(){

    }
    @Test
    public void acceptsValidPasswordCreationTest(){

    }
    @Test
    public void acceptsValidPasswordUpdateTest(){

    }
    @Test
    public void rejectsInvalidPasswordUpdateTest(){

    }
    @Test
    public void validatesGoodPasswordTest(){

    }
    @Test
    public void doesNotValidateBadPasswordTest(){

    }
}
