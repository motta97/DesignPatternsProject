package BeneficaryManagement;

import TextFile.TextFileHandler;
import utility.txtGetter;

import java.util.List;

public class test {
    static void main() {
//        System.out.println( txtGetter.getMessage("BasicSupport_getDescription","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("BasicSupport_getSupport","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("Educational_support_getDescription","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("Educational_support_getSupport","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("ExternalDelivery_sendPackage","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("ExternalDelivery_CalcShipping","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("ExternalDelivery_sendPackage","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("ExternalDelivery_GetTrackingStatus","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("Housing_support_getDescription","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("Housing_support_getSupport","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("Medical_support_getDescription","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
//        System.out.println( txtGetter.getMessage("Medical_support_getSupport","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));

        List<String> strings = txtGetter.getAllMessages("src/BeneficaryManagement/BeneficaryMangementMessages.txt") ;
        TextFileHandler handler = new TextFileHandler() ;
        String line = "Demo_demotest=[Demo messages]";
        for(String item : strings){
            if(item.equals(line)){
                strings.remove(item) ;
                handler.WriteLine("src/BeneficaryManagement/BeneficaryMangementMessages.txt",strings);
                System.out.println("Message Remove Successfully");
                return ;

            }
        }
        System.out.println("Message Not found");




    }
}
