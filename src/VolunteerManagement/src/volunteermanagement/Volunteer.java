/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import ClassStatePattern.BusyState;
import ClassStatePattern.IdleState;
import ClassStatePattern.VolunteerState;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import SkillDecorator.Iskills;
import Tasks.Itasks;
import java.util.ArrayList;
import SkillDecorator.BaseSkill;
import volunteermanagement.Enums.TaskSkills;
/**
 *
 * @author Compuomart
 */
public abstract class Volunteer {
    private String name;
    private String id;
    private String phone;
    private String email;
    private String prefs;
    private Iskills skills;
    private int hoursCount;
    private Itasks currTask;
    private VolunteerState vState;
    private Collection<Itasks> taskHistory = new Collection();
    private Icertificate certificate;
    
    public Volunteer(String name, String id, String phone, String email,String prefs){
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.prefs = prefs;
        currTask = null;
        hoursCount = 0;
        skills = new BaseSkill();
        certificate = new NewComerCertificate();
        vState = new IdleState();
    }
    public String getName(){
        return name;
    }
    public String getID(){
        return id;
    }
    public String getEmail(){
        return this.email;
    }
    
    public abstract String getRole();
    
    public Icertificate getCertificate(){
        return this.certificate;
    }
    public Iskills getSkills(){
        return this.skills;
    }
    public void AssignTask(Itasks task){
        currTask = task;
        vState.NextState(this);
    }
    public void CompleteTask(){
        if(currTask != null){
            taskHistory.Add(currTask);
            this.hoursCount += currTask.GetHoursNeeded();
            vState.NextState(this);
            currTask = null;
        }
    }
    public final boolean CanBeAssigned(Itasks task){
        return hasRequiredSkills(task) && checkRole(task) && vState.CanTakeTask();
        
    }
    public final boolean CanHandleEmergency(Itasks task){
        return checkRole(task) && vState.CanHandleEmergency();
    }
    abstract boolean checkRole(Itasks task);
    
    private boolean hasRequiredSkills(Itasks task){
        Collection<TaskSkills> reqSkills = task.GetNeededSkills();
        Iiterator<TaskSkills> skillsIterator = reqSkills.createStandardIterator();
        TaskSkills currSkill;
        boolean hasAllSkills = true;
        while(skillsIterator.hasNext()){
            currSkill = skillsIterator.getNext();
            hasAllSkills = this.skills.hasSkill(currSkill+"");
            if(!hasAllSkills)
                break;
        }
        return hasAllSkills;
    }
    
    public void SetState(VolunteerState state){
        this.vState = state;
    }
    
    public void EndRest(){
        vState.NextState(this);
    }
}



interface Icertificate{
    
}
class NewComerCertificate implements Icertificate{
    
}

