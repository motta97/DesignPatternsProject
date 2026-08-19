/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import IteratorPackage.Collection;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Enums.TaskType;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public abstract  class Itasks {
    private int hoursNeeded;
    private Volunteer currVolunteer;
    protected TaskType taskCode;
    private Collection<TaskSkills> skillsNeeded;
    public Itasks(TaskType tc,int h,Collection<TaskSkills> neededSkills){
        this.hoursNeeded = h;
        this.taskCode = tc;
        this.skillsNeeded = neededSkills;
    }
    public final String GetTaskCode(){
        return this.taskCode+""+getTaskSeqNum();  // GetTaskCode calls getTaskSeqNum from child
    }
    public void SetVolunteer(Volunteer v){
        this.currVolunteer = v;
    }
    abstract String getTaskSeqNum();  //template pattern
    
    public int GetHoursNeeded(){
        return hoursNeeded;
    }
    public Collection GetNeededSkills(){
        return this.skillsNeeded;
    }
}
