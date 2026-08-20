/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataContainers.VolunteersDataContainers;


import Enums.*;

/**
 *
 * @author abeer
 */
public abstract class BasicVolunteerDataContainer{
    String id;
    public BasicVolunteerDataContainer(String id){
        this.id = id;
        
    }
    
    public String getID(){
        return this.id;
    }
    
    public String getContainerAsString(){
        return getVolunteerType()+","+this.id;
    }
    abstract VolunteerClassifications getVolunteerType();
}
