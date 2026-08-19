package Report;

import TextFile.TextFileHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class Report {


    final public void GenerateReport(){
        List<String > result = new ArrayList<>( );

        result.add(createHeader()) ;
        result.addAll(collectData() ) ;
        result.add("==================================") ;
        result.addAll(createSummary()) ;

        outputReport(result);
    }
     public abstract List<String> collectData();
    final public String createHeader(){
        String Header = "==================================\n" +
                "             REPORT\n" +
                "==================================";
        return Header ;
    }

    public abstract List<String> createSummary() ;
    final public void outputReport(List<String> report){
        TextFileHandler handler = new TextFileHandler() ;
        String filePath ="reports/Report.txt" ;
        handler.WriteLine(filePath,report);
        System.out.println("Have been written Successfully");
    }

}
