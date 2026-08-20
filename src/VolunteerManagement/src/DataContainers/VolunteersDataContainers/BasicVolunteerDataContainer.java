/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataContainers.VolunteersDataContainers;

import java.util.Map;

/**
 *
 * @author abeer
 */
public class BasicVolunteerDataContainer {
    String name;
    String id;
    String email;
    String phone;
    
    public BasicVolunteerDataContainer(String n,String id,String ph,String email){
        this.name = n;
        
        this.id = id;
        this.email =email;
        this.phone = ph;
    }
    public String getName(){
        return this.name;
    }
    public String getID(){
        return this.id;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){ 
        return this.phone;
    }
    
}
