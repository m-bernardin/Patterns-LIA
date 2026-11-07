package ca.mbernardin.dao;

import java.util.HashSet;
import java.util.Set;

import ca.mbernardin.model.Subscription;
import ca.mbernardin.model.Conference;
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
    public static void create(int user_id,int conference_id,boolean waitinglist_status,Date waitinglist_position){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement inserter=connection.prepareStatement("INSERT INTO Subscription VALUES(?,?,?,?);");){
                inserter.setInt(1,user_id);
                inserter.setInt(2,conference_id);
                inserter.setString(3,waitinglist_status+"");
                inserter.setDate(4,waitinglist_position);
                inserter.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void remove(int user_id,int conference_id){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement remover=connection.prepareStatement("DELETE FROM Subscription WHERE user_id=? AND conference_id=?;");){
                remover.setInt(1,user_id);
                remover.setInt(2,conference_id);
                remover.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void removeFromWaitingList(int user_id,int conference_id){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE Subscription SET waitinglist_status='False' WHERE user_id=? AND conference_id=?;");){
                updater.setInt(1,user_id);
                updater.setInt(2,conference_id);
                updater.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static Set<Conference> getSubscriptions(int user_id){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement query=connection.prepareStatement("SELECT * FROM Subscription WHERE user_id=?");){
                query.setInt(1,user_id);
                ResultSet resultSet=query.executeQuery();
                Set<Conference> subscriptions=new HashSet<>();
                while(resultSet.next()){
                    subscriptions.add(ConferenceDatabaseAccessObject.getById(resultSet.getInt("conference_id")));
                }
                return subscriptions;
        }
        catch(SQLException e){
            Logger.logSQL(e);
            return null;
        }
    }
}
