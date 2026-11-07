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
}
