/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import java.util.ArrayList;

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
    private ArrayList<Itasks> taskHistory = new ArrayList<>();
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
        if(currTask == null){
            currTask = task;
        }
        else{
            System.out.println("Volunteer already has a task!");
        }
    }
    public void CompleteTask(){
        if(currTask != null){
            taskHistory.add(currTask);
            this.hoursCount += currTask.estimatedHours;
            currTask = null;
        }
    }
}


abstract class Itasks{
    int estimatedHours;
    public Itasks(int h){
        this.estimatedHours = h;
    }
}
interface Icertificate{
    
}
class NewComerCertificate implements Icertificate{
    
}
interface Iskills{
    
}
class BaseSkill implements Iskills{
    
}