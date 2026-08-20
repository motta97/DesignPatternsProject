/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import ClassStatePattern.TaskOpenState;
import ClassStatePattern.TaskState;
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
    private TaskState state;
    private Collection<TaskSkills> skillsNeeded;
    public Itasks(TaskType tc,int h,Collection<TaskSkills> neededSkills){
        this.hoursNeeded = h;
        this.taskCode = tc;
        this.skillsNeeded = neededSkills;
        this.state = new TaskOpenState();
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
    public void SetTaskState(TaskState newState){
        this.state = newState;
    }
    public void CompleteTask(){
        state.Complete(this);
    }
    public void ResolveTask(){
        state.Resolve(this);
    }
    public void ReopenTask(){
        state.Reopen(this);
    }
    public void CloseTask(){
        state.Close(this);
    }
    public void AssignTask(){
        state.Assign(this);
    }
}
