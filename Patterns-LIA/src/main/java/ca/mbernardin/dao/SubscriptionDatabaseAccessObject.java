package ca.mbernardin.dao;

import java.util.HashSet;
import java.util.Set;

import ca.mbernardin.model.Subscription;
import ca.mbernardin.model.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * SubscriptionDatabaseAccessObject
 */
public class SubscriptionDatabaseAccessObject extends DatabaseAccessObject{
    public static Set<Subscription> getAll(){
        try(Connection connection=DriverManager.getConnection(target);
            Statement query=connection.createStatement();
            ResultSet resultSet=query.executeQuery("SELECT * FROM Subscription;")){
                Set<Subscription> results=new HashSet<>();
                while(resultSet.next()){
                    int subscription_id=resultSet.getInt("subscription_id");
                    int user_id=resultSet.getInt("user_id");
                    int conference_id=resultSet.getInt("conference_id");
                    boolean waitinglist_status=resultSet.getBoolean("waiting_status");
                    Date waitinglist_position=resultSet.getDate("waitinglist_position");
                    results.add(new Subscription(subscription_id, user_id, conference_id, waitinglist_status, waitinglist_position));
                }
                return results;
        }
        catch(SQLException e){
            Logger.logSQL(e);
            return null;
        }
    }
}
