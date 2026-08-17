package TextFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileHandler {
    private static TextFileHandler ref = null ;
    public static TextFileHandler GetInstance(){
        if(ref == null){
            ref = new TextFileHandler() ;
        }
        return ref ;
    }

    public  void WriteLine(String filePath , List<String> Lines){

        try(FileWriter writer = new FileWriter(filePath)){

            for(String line : Lines){
                writer.write(line+"\n");
            }


        }
        catch (Exception e) {
            System.out.println("Could not write file");
        }


    }

    public  List<String> ReadFile(String filePath){


        ArrayList<String> lines = new ArrayList<>() ;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath));){

            String Line ;
            while((Line = reader.readLine()) != null){
               lines.add(Line) ;
            } ;


        }catch (FileNotFoundException e){
            System.out.println("Cannot find the file");
        }
        catch (Exception e) {
            System.out.println("Cannot Read this file");

        }

    return lines ;
    }


}
