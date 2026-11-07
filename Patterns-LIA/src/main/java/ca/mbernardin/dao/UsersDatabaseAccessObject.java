package ca.mbernardin.dao;

import java.util.HashSet;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ca.mbernardin.model.Logger;
import ca.mbernardin.model.User;

/**
 * UsersDatabaseObject
 */
public class UsersDatabaseAccessObject extends DatabaseAccessObject{
    public static Set<User> getAll(){
        try(Connection connection=DriverManager.getConnection(target);
            Statement query=connection.createStatement();
            ResultSet resultSet=query.executeQuery("SELECT * FROM Users;")){
                Set<User> users=new HashSet<>();
                while(resultSet.next()){
                    int user_id=resultSet.getInt("user_id");
                    String full_name=resultSet.getString("full_name");
                    String email=resultSet.getString("email");
                    int age=resultSet.getInt("age");
                    String usertype=resultSet.getString("usertype");
                    users.add(new User(user_id,full_name,email,age,usertype));
                }
                return users;
        }
        catch(SQLException e){
            Logger.logSQL(e);
            return null;
        }
    }
    public static User getById(int id){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement query=connection.prepareStatement("SELECT * FROM User WHERE user_id=?;");){
                query.setInt(1,id);
                ResultSet resultSet=query.executeQuery();
                int user_id=resultSet.getInt("user_id");
                String full_name=resultSet.getString("full_name");
                String email=resultSet.getString("email");
                int age=resultSet.getInt("age");
                String usertype=resultSet.getString("usertype");
                return new User(user_id, full_name, email, age, usertype);
            }
        catch(SQLException e){
            Logger.logSQL(e);
            return null;
        }
    }
    public static void removeById(int id){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement userTableRemover=connection.prepareStatement("DELETE FROM User WHERE user_id=?;");){
                userTableRemover.setInt(1,id);
                userTableRemover.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void create(String full_name,String email,int age,String hashedPassword){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement inserter=connection.prepareStatement("INSERT INTO User VALUES(?,?,?,'Participant');");){
                inserter.setString(1,full_name);
                inserter.setString(2,email);
                inserter.setInt(3,age);
                inserter.executeUpdate();
                PasswordDatabaseAccessObject.create(getIdByEmail(email),hashedPassword);
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static int getIdByEmail(String email){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement query=connection.prepareStatement("SELECT user_id FROM User WHERE email=?;");){
                query.setString(1,email);
                ResultSet results=query.executeQuery();
                if(results.next()){
                    return results.getInt("user_id");
                }
                else return -1;
        }
        catch(SQLException e){
            Logger.logSQL(e);
            return -1;
        }
    }
    public static void updateFullName(int user_id, String full_name){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE User SET full_name=? WHERE user_id=?;");){
                updater.setString(1,full_name);
                updater.setInt(2,user_id);
                updater.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void updateEmail(int user_id, String email){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE User SET email=? WHERE user_id=?;");){
                updater.setString(1,email);
                updater.setInt(2,user_id);
                updater.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
    public static void updateAge(int user_id, int age){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE User SET age=? WHERE user_id=?;");){
                updater.setInt(1,age);
                updater.setInt(2,user_id);
                updater.executeUpdate();
        }
        catch(SQLException e){
            Logger.logSQL(e);
        }
    }
}
