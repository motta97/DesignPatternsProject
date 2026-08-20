/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns;

import DataContainers.BaseTaskDataContainer;
import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import MVC.Viewer;
import Enums.TaskSkills;

/**
 *
 * @author abeer
 */
public abstract class BaseTaskDataCollectionStrategy {
    
   
    
    public BaseTaskDataContainer CollectTaskData(){
        Viewer.DisplayMsg("Enter task data: ");
        
        int hours = Viewer.promptForInt("hours needed: ");
        
        Collection<TaskSkills> neededSkills =new Collection<>();
        Viewer.DisplayMsg("Enter skills needed for the task: ");
        Iiterator skillIterator;
        int choice =0;
        while(choice != -1){
            skillIterator = new Collection<TaskSkills>(TaskSkills.values()).createStandardIterator();
            Viewer.ChoicesDisplayer(skillIterator);
            choice = Viewer.promptForInt("Enter -1 to end");
            if(choice>TaskSkills.values().length || choice<=0){
                Viewer.DisplayMsg("Invalid input, please choose within the given options");
                continue;
            }
            else{
                neededSkills.Add(TaskSkills.values()[choice-1]);
            }
        }
         
        
        return new BaseTaskDataContainer(neededSkills,hours);
    };
}


