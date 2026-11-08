package ca.mbernardin.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * DatabaseAccessObjectTest
 */
public class DatabaseAccessObjectTest {
    @AfterEach
    public void teardown(){
        File database=new File("src/main/resources/ca/mbernardin/database/database.db");
        database.delete();
    }
    @Test
    public void initializeDatabaseTest(){
        assertTrue(DatabaseAccessObject.intializeDatabase());
    }
}
