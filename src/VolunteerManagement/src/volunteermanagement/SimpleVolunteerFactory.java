/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

/**
 *
 * @author Compuomart
 */
public class SimpleVolunteerFactory {
    public static Volunteer CreateVolunteer(String Role, String name, String id, String phone,String email,String prefs,String qualifications){
        if(Role.equals("Admin")){
            return new AdministrativeVolunteer(id,name,phone,email,prefs,qualifications);
        }
        else if(Role.equals("Labor")){
            return new PhysicalLaborVolunteer(id,name,phone,email,prefs,qualifications);
        }
        else{
            return null;
        }
    }
}
