package ca.mbernardin.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class SubscriptionDatabaseAccessObjectTest {

    private String originalTarget;

    @BeforeEach
    void setUp() {
    	  DatabaseAccessObject.intializeDatabase();
    }
    @AfterEach
    public void teardown(){
        File database=new File("src/main/resources/ca/mbernardin/database/database.db");
        database.delete();
    }
    
    @Test
    void testCreateSubscription() {
        boolean result = SubscriptionDatabaseAccessObject.create(1, 1,false, Date.valueOf("2026-11-05"));
        assertTrue(result, "Subscription successfull");
    }
    
    @Test
    void testRemoveSubscription() {
        boolean created = SubscriptionDatabaseAccessObject.create( 1,  1, false,Date.valueOf("2026-11-05")  );
        assertTrue(created, "Subscription created");
        
        boolean remove= SubscriptionDatabaseAccessObject.remove(1, 1);
        assertTrue(remove, "Subscription removed");
    }
    @Test
    void testGetAllSubscriptions() {
        boolean created = SubscriptionDatabaseAccessObject.create(1, 1, false, Date.valueOf("2026-11-05"));
        assertTrue(created);
        var subscriptions = SubscriptionDatabaseAccessObject.getAll();
        assertNotNull(subscriptions, "Subscriptions not be null");
        assertFalse(subscriptions.isEmpty(), "Subscriptions not be empty");
    }
    
    @Test
    void testGetConfirmedSubscriptions() {
        boolean created = SubscriptionDatabaseAccessObject.create(1, 1, false, Date.valueOf("2026-11-05"));
        assertTrue(created, "Subscription created");
        var confirm=  SubscriptionDatabaseAccessObject.getConfirmedSubscriptions(1);
        assertNotNull(confirm, "Confirmed subscriptions not be null");
        assertFalse(confirm.isEmpty(), "Confirmed subscriptions not be empty");
    }
    @Test
    void testRemoveFromWaitingList() {
        boolean created = SubscriptionDatabaseAccessObject.create(1, 1, true, Date.valueOf("2026-11-05"));
        boolean remove = SubscriptionDatabaseAccessObject.removeFromWaitingList(1, 1);
        assertTrue(remove, "Participant remove from waiting list");
    }
}
     
