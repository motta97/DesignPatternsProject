/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

/**
 *
 * @author Compuomart
 */
public abstract class Volunteer {
    private String name;
    private String id;
    private String phone;
    private String email;
    private String preferences;
    private String qualifications;
    private int hoursCount;
    
    public Volunteer(String id,String name, String phone, String email, String prefs,String qualifications){
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.preferences = prefs;
        this.hoursCount = 0;
        this.qualifications = qualifications;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public abstract void AssignTask();
    public abstract void UnAssignTask();
}
