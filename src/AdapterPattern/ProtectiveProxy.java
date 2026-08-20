/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdapterPattern;

import IteratorPackage.Collection;
import MVC.Viewer;
import Tasks.Itasks;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public class ProtectiveProxy implements Idatabase{
    private Idatabase db;
    private static ProtectiveProxy instance;
    private ProtectiveProxy(Idatabase db){
        this.db = db;
    }
    public static ProtectiveProxy getInstance(Idatabase db){
        if(instance == null){
            instance = new ProtectiveProxy(db);
        }
        return instance;
    }

    @Override
    public void SaveVolunteers(Collection<Volunteer> data) {
        db.SaveVolunteers(data);
    }

    @Override
    public Collection<Volunteer> LoadVolunteers() {
        int pass = Viewer.promptForInt("Enter password: ");
        if(pass == 111)
            return db.LoadVolunteers();
        else{
            Viewer.DisplayMsg("Wrong pass, access denied!");
            return new Collection<>();
        }
        
    }

    @Override
    public void SaveTasks(Collection<Itasks> data) {
        db.SaveTasks(data);
    }

    @Override
    public Collection<Itasks> LoadTasks() {
        int pass = Viewer.promptForInt("Enter password: ");
        if(pass == 222)
            return db.LoadTasks();
        else{
            Viewer.DisplayMsg("Wrong pass, access denied!");
            return new Collection<>();
        }
    }

    @Override
    public void InsertTask(Itasks task) {
        int pass = Viewer.promptForInt("Enter password: ");
        if(pass == 112)
            db.InsertTask(task);
        else{
            Viewer.DisplayMsg("Wrong pass, access denied!");
        }
    }

    @Override
    public void InsertVolunteer(Volunteer v) {
        db.InsertVolunteer(v);
    }

    @Override
    public void DeleteTask(Itasks task) {
        int pass = Viewer.promptForInt("Enter password: ");
        if(pass == 121)
            db.DeleteTask(task);
        else{
            Viewer.DisplayMsg("Wrong pass, access denied!");
            
        }
    }

    @Override
    public void DeleteVolunteer(Volunteer v) {
        int pass = Viewer.promptForInt("Enter password: ");
        if(pass == 111)
            db.DeleteVolunteer(v);
        else{
            Viewer.DisplayMsg("Wrong pass, access denied!");
        }
    }

    @Override
    public void UpdateTask(String taskCode, Itasks newTask) {
        db.UpdateTask(taskCode, newTask);
    }

    @Override
    public void UpdateVolunteer(String id, Volunteer newVol) {
        db.UpdateVolunteer(id, newVol);
    }
    
}
