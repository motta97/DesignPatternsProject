package BeneficaryRequestStatus;

import TextFile.TextFileHandler;

import java.util.List;

public class test {
    static void main() {
        TextFileHandler handler = new TextFileHandler() ;
        List<String> messages =handler.ReadFile("src/BeneficaryRequestStatus/RequestStatusMessages.txt") ;
        for(String line :messages){

           String[]parts = line.split("=");
           if(parts[0].contains("ErrorMessag"))
           {
               System.out.println("Error Message from a text file |"+parts[1]);


           }
            if(parts[0].contains("approvePending"))
            {
                System.out.println("Error Message from a text file |"+parts[1]);
            }
            if(parts[0].contains("rejectPending"))
            {
                System.out.println("Error Message from a text file |"+parts[1]);
            }
        }
        handler.WriteLine("src/BeneficaryRequestStatus/RequestStatusMessages.txt",messages);
        messages =handler.ReadFile("src/BeneficaryRequestStatus/RequestStatusMessages.txt") ;
        for(String line : messages){
            System.out.println(line);
        }
    }
}
