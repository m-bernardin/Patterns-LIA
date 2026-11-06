package ca.mbernardin.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * DatabaseObject
 */
public abstract class DatabaseObject {
    private static String target="jdbc:sqlite:/src/main/java/model/database/database.db";
    protected static ResultSet executeQuery(PreparedStatement query){
        try(Connection connection=DriverManager.getConnection(target)){
                return query.executeQuery();
        }
        catch(SQLException e){
            System.out.println(" SQL exception: ["+e.getErrorCode()+"] "+e.getMessage());
            return null;
        }
    }
    protected static boolean executeUpdate(PreparedStatement update){
        try(Connection connection=DriverManager.getConnection(target)){
            update.executeUpdate();
            return true;
        }
        catch(SQLException e){
            System.out.println(" SQL exception: ["+e.getErrorCode()+"] "+e.getMessage());
            return false;
        }
    }
}
