/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.MedicalVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import java.util.Scanner;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.VolunteerClassifications;

/**
 *
 * @author abeer
 */
public class Viewer {
    private static Scanner scanner = new Scanner(System.in);
    private static Viewer instance;

    private Viewer(){
        
    }
    public static Viewer getInstance(){
        if(instance == null){
            instance = new Viewer();
        }
        return instance;
    }
    public void DisplayGreeting(){
        System.out.println("Welcome to volunteer management module!");
        System.out.println("How can we help you today?");
    }
    public int MainMenuView(){

        int userChoice = 0;
        while(userChoice>4 || userChoice<1){
            System.out.println("Please choose a valid option from the list");
            System.out.println("1- Register New volunteer");
        System.out.println("2- AssignTask");
        System.out.println("3- View Data");
        System.out.println("4- Exit");
        
            userChoice = scanner.nextInt();
        }
        scanner.nextLine();
        return userChoice;
    }
    
    
    public static void ChoicesDisplayer(Iiterator iterator){
            int pos = 1;
            while(iterator.hasNext()){
                System.out.println(pos+"-"+iterator.getNext());
                pos++;
            }
    }
    public static void DisplayMsg(String msg){
        System.out.println(msg);
    }
    public static String promptForString(String msg){
        System.out.println(msg);
        return scanner.nextLine();
    }
    public static float promptForFLoat(String msg){
        System.out.println(msg);
        float input = scanner.nextFloat(); 
        scanner.nextLine();
        return input;
    }
    public static int promptForInt(String msg){
        System.out.println(msg);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
    
    public static boolean promptForBoolean(String msg) {
        System.out.println(msg);
        boolean input = scanner.nextBoolean();
        scanner.nextLine();
        return input;
    }
}
