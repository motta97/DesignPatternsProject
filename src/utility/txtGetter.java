package utility;

import TextFile.TextFileHandler;

import java.util.List;

public class txtGetter {
    public static String getMessage(String msg,String filepath){
        TextFileHandler handler = new TextFileHandler() ;
        List<String> messages =handler.ReadFile(filepath) ;
        for(String line :messages){

            String[]parts = line.split("=");
            if(parts[0].equals(msg))
            {
                return parts[1] ;
            }
        }
        return "Not Found Your Message" ;
    }
    public static List<String> getAllMessages(String filepath){
        TextFileHandler handler = new TextFileHandler() ;
        List<String> messages =handler.ReadFile(filepath) ;
        return messages;
    }
}
