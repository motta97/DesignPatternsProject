/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import ClassStatePattern.BusyState;
import ClassStatePattern.IdleState;
import ClassStatePattern.VolunteerState;
import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.CriticalSkillCondition;
import IteratorPackage.FilteredIterator;
import IteratorPackage.Icondition;
import IteratorPackage.Iiterator;
import SkillDecorator.Iskills;
import Tasks.Itasks;
import java.util.ArrayList;
import SkillDecorator.BaseSkill;
import utility.User;
import Enums.TaskSkills;
/**
 *
 * @author Compuomart
 */
public abstract class Volunteer extends User{
    
    private String id;
    
    private Iskills skills;
    private int hoursCount;
    private Itasks currTask;
    private VolunteerState vState;
    private Collection<Itasks> taskHistory = new Collection();
    private Icertificate certificate;
    
    public Volunteer(String name, String id,  String phone,String email){
        super(name,phone,email);
    
        this.id = id;
        
        currTask = null;
        hoursCount = 0;
        skills = new BaseSkill();
        certificate = new NewComerCertificate();
        vState = new IdleState();
    }
    public final BasicVolunteerDataContainer getData(){
        return getVolunteerDataAsContainer();
    }
    abstract BasicVolunteerDataContainer getVolunteerDataAsContainer();
    
    public String getID(){
        return id;
    }
    @Override
    public String getType(){
        return "VOLUNTEER";
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
        return hasCriticalSkills(task) && checkRole(task) && vState.CanHandleEmergency();
    }
    public final void HandleInjury(){
        //ReduceWorkLoad();
    }
    
    abstract boolean checkRole(Itasks task);
    //abstract boolean checkCapability(Itasks task);
    //abstract boolean ReduceWorkLoad();
    
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
    private boolean hasCriticalSkills(Itasks task){
        Icondition<TaskSkills> c = new CriticalSkillCondition();
        Collection<TaskSkills> taskSkills = task.GetNeededSkills();
        FilteredIterator skillsIterator = (FilteredIterator) taskSkills.createFilteredIterator(c);
        boolean hasAllCriticalSkills = true;
        TaskSkills currSkill;
        while(skillsIterator.hasNext()){
            currSkill = (TaskSkills) skillsIterator.getNext();
            hasAllCriticalSkills = this.skills.hasSkill(currSkill+"");
            if(!hasAllCriticalSkills){
                break;
            }
        }
        return hasAllCriticalSkills;
    }
    public void SetState(VolunteerState state){
        this.vState = state;
    }
    
    public void EndRest(){
        vState.EndRest(this);
    }
}



interface Icertificate{
    
}
class NewComerCertificate implements Icertificate{
    
}

