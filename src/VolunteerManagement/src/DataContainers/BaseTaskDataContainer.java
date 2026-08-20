/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataContainers;

import ClassStatePattern.TaskState;
import IteratorPackage.Collection;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public class BaseTaskDataContainer {
    
    private Collection<TaskSkills> neededSkills;
    private int hoursNeeded;
    
    public BaseTaskDataContainer(Collection<TaskSkills> reqSkills, int hours){
        
        this.neededSkills = reqSkills;
        this.hoursNeeded = hours;
    }
    
    
    public Collection<TaskSkills> getNeededSkills(){
        return this.neededSkills;
    }
    public int getHoursNeeded(){
        return this.hoursNeeded;
    }
    
}
