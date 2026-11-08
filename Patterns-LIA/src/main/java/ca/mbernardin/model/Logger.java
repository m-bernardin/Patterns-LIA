package ca.mbernardin.model;

import java.sql.SQLException;
import java.io.IOException;

/**
 * Logger
 */
public class Logger {
    private static void log(String message){
    }
    public static void logSQL(SQLException e){
    }
    public static void logIo(IOException e){
    }
}
