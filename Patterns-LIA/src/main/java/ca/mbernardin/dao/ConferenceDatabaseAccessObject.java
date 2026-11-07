package ca.mbernardin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.util.HashSet;
import java.util.Set;

import ca.mbernardin.model.Conference;
import ca.mbernardin.model.Logger;

/**
 * ConferenceDatabaseAccessObject
 */
public class ConferenceDatabaseAccessObject extends DatabaseAccessObject{
    public static Set<Conference> getAll() {
    	try(Connection connection=DriverManager.getConnection(target);
            Statement query=connection.createStatement();
            ResultSet resultSet=query.executeQuery("SELECT * FROM Conference;");){
                Set<Conference> results=new HashSet<>();
                while(resultSet.next()){
                    int conference_id=resultSet.getInt("conference_id");
                    String title=resultSet.getString("title");
                    int capacity=resultSet.getInt("capacity");
                    Date start_date=resultSet.getDate("start_date");
                    Date end_date=resultSet.getDate("end_date");
                    String location=resultSet.getString("location");
                    results.add(new Conference(conference_id, title, capacity, start_date, end_date, location));
                }
                return results;
        }
        catch(SQLException e){
            Logger.logSQL(e);
            return null;
        }
    }
    public static Conference getById(int id){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement query=connection.prepareStatement("SELECT * FROM Conference WHERE conference_id=?;");){
                query.setInt(1,id);
                ResultSet resultSet=query.executeQuery();
                int conference_id=resultSet.getInt("conference_id");
                String title=resultSet.getString("title");
                int capacity=resultSet.getInt("capacity");
                Date start_date=resultSet.getDate("start_date");
                Date end_date=resultSet.getDate("end_date");
                String location=resultSet.getString("location");
                return new Conference(conference_id, title, capacity, start_date, end_date, location);
        }
        catch(SQLException e){
            Logger.logSQL(e);
            return null;
        }
    }
    public static void create(String title,int capacity,Date start_date,Date end_date,String location){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement inserter=connection.prepareStatement("INSERT INTO Conference VALUES(?,?,?,?,?);");){
                inserter.setString(1,title);
                inserter.setInt(2,capacity);
                inserter.setDate(3,start_date);
                inserter.setDate(4,end_date);
                inserter.setString(5,location);
                inserter.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void removeById(int conference_id){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement remover=connection.prepareStatement("DELETE FROM Conference WHERE conference_id=?;");){
                remover.setInt(1,conference_id);
                remover.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void updateTitle(int conference_id,String title){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE Conference SET title=? WHERE conference_id=?;");){
                updater.setString(1,title);
                updater.setInt(2,conference_id);
                updater.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void updateCapacity(int conference_id,int capacity){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE Conference SET capacity=? WHERE conference_id=?;");){
                updater.setString(1,capacity);
                updater.setInt(2,conference_id);
                updater.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void updateStartDate(int conference_id,Date start_date){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE Conference SET start_date=? WHERE conference_id=?;");){
                updater.setDate(1,start_date);
                updater.setInt(2,conference_id);
                updater.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void updateEndDate(int conference_id,Date end_date){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE Conference SET end_date=? WHERE conference_id=?;");){
                updater.setDate(1,end_date);
                updater.setInt(2,conference_id);
                updater.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void updateLocation(int conference_id,String location){}
}
