package ca.mbernardin.service;

import java.sql.SQLException;
import java.io.File;
import java.io.IOException;

/**
 * Logger
 */
public class LoggingService {
    private static final File LOG_TARGET=new File("~/Cegep/Patterns/Patterns-LIA/Patterns-LIA/src/main/resources/ca/mbernardin/errorlog.log");
    private static void log(String message){
    }
    public static void logSQL(SQLException e){
    }
    public static void logIo(IOException e){
    }
}
