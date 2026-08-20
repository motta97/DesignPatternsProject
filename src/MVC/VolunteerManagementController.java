/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import AdapterPattern.Idatabase;
import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import static MVC.Viewer.ChoicesDisplayer;
import StrategyPatterns.VolunteersDataCollectionStrategies.DataCollectionStrategyFactory;
import StrategyPatterns.VolunteersDataCollectionStrategies.BaseVolunteerdataCollectionStrategy;
import Enums.VolunteerClassifications;
import volunteermanagement.MedicalVolunteer;
import volunteermanagement.Volunteer;
import volunteermanagement.VolunteerFactory;

/**
 *
 * @author abeer
 */
public class VolunteerManagementController {
    private static Viewer volunteerViewer = Viewer.getInstance();
    private Idatabase db;
    private static BaseVolunteerdataCollectionStrategy dataCollectionStrategy;
    
    public static void start(){
        volunteerViewer.DisplayGreeting();
        int userChoice = volunteerViewer.MainMenuView();
        HandleMainMenuChoice(userChoice);
    }
    
    public static void HandleMainMenuChoice(int choice){
        switch(choice){
            case 1:
                
                break;
            case 2:
                //AssignTask();
                break;
            case 3:
                // display data options();
                break;
            case 4:
                //exit
                break;
            default:
                //invalid choice
                break;
                
        }
    }
    
    public static void SetDataCollectionStrategy(BaseVolunteerdataCollectionStrategy strategy){
        dataCollectionStrategy = strategy;
    }
    public static void RegisterVolunteer(String name, String phone,String email){
        BasicVolunteerDataContainer dataContainer;
        VolunteerClassifications volClass = SetVolunteerRole();
        dataCollectionStrategy = DataCollectionStrategyFactory.createStrategy(volClass);
        if(dataCollectionStrategy != null){
            dataContainer =dataCollectionStrategy.CollectVolunteerData();
            
            Volunteer newVol = VolunteerFactory.createVolunteer(volClass,name,phone,email,dataContainer);
        }
        else{
            volunteerViewer.DisplayMsg("Collection strategy has not been implemented yet!");
        }
        //Store in the model
    }
    
    public static VolunteerClassifications SetVolunteerRole(){
        volunteerViewer.DisplayMsg("Choose role for the new volunteer");
        Collection<VolunteerClassifications> volunteerClasses = new Collection(VolunteerClassifications.values());
        Iiterator classesIterator = volunteerClasses.createStandardIterator();
        
        int userChoice=0;
        
        while(userChoice>VolunteerClassifications.values().length || userChoice<1){
            
            ChoicesDisplayer(classesIterator);
            userChoice = volunteerViewer.promptForInt("Enter valid choice: ");
            classesIterator = volunteerClasses.createStandardIterator();
        }
        
        return VolunteerClassifications.values()[userChoice-1];
    }
}
