/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MVC;

import AdapterPattern.Idatabase;
import AdapterPattern.ProtectiveProxy;
import AdapterPattern.TextFileDatabase;
import AdapterPattern.VirtualProxy;
import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import static MVC.Viewer.ChoicesDisplayer;
import StrategyPatterns.DataCollectionStrategyFactory;
import StrategyPatterns.VolunteersDataCollectionStrategies.BaseVolunteerdataCollectionStrategy;
import volunteermanagement.Enums.VolunteerClassifications;
import volunteermanagement.MedicalVolunteer;
import volunteermanagement.Volunteer;
import volunteermanagement.VolunteerFactory;

/**
 *
 * @author abeer
 */
public class VolunteerManagementController {
    private static Viewer volunteerViewer = Viewer.getInstance();
    String volFilePath;
    String taskFilePath;
    private Idatabase db;
    Collection<Volunteer> data;
    private static BaseVolunteerdataCollectionStrategy dataCollectionStrategy;
    
    public void start(){
        volunteerViewer.DisplayGreeting();
        int userChoice = volunteerViewer.MainMenuView();
        HandleMainMenuChoice(userChoice);
        InitializeDB();
    }
    
    public void HandleMainMenuChoice(int choice){
        switch(choice){
            case 1:
            {
                
                SaveAllVolunteer(data);
            }
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
    
    private  void SaveAllVolunteer(Collection<Volunteer> data) {
        
        db.SaveVolunteers(data);
        
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
    
    public void SetTaskFilePath(String path){
        this.taskFilePath = path;
    }
    public void SetVolFilePath(String path){
        this.volFilePath = path;
    }
    private void InitializeDB() {
        
        db = ProtectiveProxy.getInstance(VirtualProxy.getInstance(taskFilePath,volFilePath));
    }
}
