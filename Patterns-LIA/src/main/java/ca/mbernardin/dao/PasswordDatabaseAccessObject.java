package ca.mbernardin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ca.mbernardin.model.Logger;

/**
 * PasswordDatabaseAccessObject
 */
public class PasswordDatabaseAccessObject extends DatabaseAccessObject{
    public static boolean validatePassword(int user_id,String hashedPassword){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement query=connection.prepareStatement("SELECT password_hash FROM Credentials WHERE user_id=?;");){
                query.setInt(1,user_id);
                ResultSet resultSet=query.executeQuery();
                String storedPassword="";
                while(resultSet.next()){
                    storedPassword=resultSet.getString("password_hash");
                }
                return hashedPassword.equals(storedPassword);

        }
        catch(SQLException e){
            Logger.logSQL(e);
            return false;
        }
    }
    protected static boolean create(int user_id,String password_hash){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement inserter=connection.prepareStatement("INSERT INTO Credentials(user_id,password_hash) VALUES(?,?);");){
                inserter.setInt(1,user_id);
                inserter.setString(2,password_hash);
                inserter.executeUpdate();
                return true;
        }
        catch(SQLException e){
            Logger.logSQL(e);
            return false;
        }
    }
    public static boolean update(int user_id,String password_hash){
        try(Connection connection=DriverManager.getConnection(target);
            PreparedStatement updater=connection.prepareStatement("UPDATE Credentials SET password_hash=? WHERE user_id=?;");){
                updater.setString(1,password_hash);
                updater.setInt(2,user_id);
                updater.executeUpdate();
                return true;
        }
        catch(SQLException e){
            Logger.logSQL(e);
            return false;
        }
    }
}
