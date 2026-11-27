package ca.mbernardin.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Logger
 */
public class LoggingService {
    private static final File LOG_TARGET=new File("~/Cegep/Patterns/Patterns-LIA/Patterns-LIA/src/main/resources/ca/mbernardin/errorlog.log");
    private static String formatMessage(String message){
        return String.format("[ERROR] @ %s\n%s",LocalDateTime.now(),message);
    }
    private static void log(String message){
        try(FileWriter writer=new FileWriter(LOG_TARGET)){
            if(!LOG_TARGET.exists())LOG_TARGET.createNewFile();
            writer.append(formatMessage(message));
        }
        catch(IOException e){
            System.out.println(formatMessage("Catastrophic failure. Could not write previous error to log.\n"+e.getStackTrace()));
        }
    }
    public static void logSQL(SQLException e){
        log(String.format("[%d] SQL Exception: %s\n%s",e.getErrorCode(),e.getLocalizedMessage(),e.getStackTrace()));
    }
    public static void logIo(IOException e){
        log(String.format("[%d] IO Exception: %s\n%s",e.getErrorCode(),e.getLocalizedMessage(),e.getStackTrace()));
    }
}
