package ca.mbernardin.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ca.mbernardin.model.Logger;

/**
 * DatabaseObject
 */
public class DatabaseAccessObject {
    private static String fileLocation="src/main/resources/ca/mbernardin/database/database.db";
    protected static String target="jdbc:sqlite:"+fileLocation;
    public static boolean intializeDatabase(){
        try(Connection connection=DriverManager.getConnection(target);
            Statement executer=connection.createStatement();){
                File database=new File(fileLocation);
                if(!database.exists())database.createNewFile();
                List<String> definitionCommands=readFile(new File("src/main/resources/ca/mbernardin/sql/schema.sql"));
                List<String> seedingCommands=readFile(new File("src/main/resources/ca/mbernardin/sql/seed.sql"));
                for(int i=0;i<definitionCommands.size();++i)executer.executeUpdate(definitionCommands.get(i));
                for(int i=0;i<seedingCommands.size();++i)executer.executeUpdate(seedingCommands.get(i));
                return true;
        }
        catch(IOException e1){
            Logger.logIo(e1);
            return false;
        }
        catch(SQLException e2){
            Logger.logSQL(e2);
            return false;
        }

    }
    private static List<String> readFile(File file) throws FileNotFoundException{
        List<String> commands=new ArrayList<>();
        Scanner reader=new Scanner(file);
        String command="";
        String line="";
        while(reader.hasNext()){
            line=reader.nextLine().trim();
            if(line.matches("--.*"))continue;
            command+=line+" ";
            if(line.matches(".*;")){
                commands.add(command);
                command="";
            }
        }
        reader.close();
        return commands;
    }
}
