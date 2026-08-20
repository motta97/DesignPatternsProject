/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdapterPattern;

import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import MVC.Viewer;
import Tasks.Itasks;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public class VirtualProxy implements Idatabase{

    
    Collection<Volunteer> dataVol;
    Collection<Itasks> dataTasks;
    String tasksFilePath;
    String volFilePath;
    private static VirtualProxy instance;
    private static Idatabase db;
    private  VirtualProxy(Idatabase db){
        this.db = db;
    }
    @Override
    public void SaveVolunteers(Collection<Volunteer> data) {
        db.SaveVolunteers(data);
    }

    @Override
    public Collection<Volunteer> LoadVolunteers() {
        if(this.dataVol == null){
            Viewer.DisplayMsg("Loading volunteers data from db...");
            dataVol = db.LoadVolunteers();
        }
        return dataVol;
    }
    public void ViewVolunteers(){
        if(dataVol == null){
            Viewer.DisplayMsg("Loading data..");
            dataVol = LoadVolunteers();
        }
        Iiterator dataIterator = dataVol.createStandardIterator();
        Viewer.ChoicesDisplayer(dataIterator);
    }
    @Override
    public void SaveTasks(Collection<Itasks> data) {
        db.SaveTasks(data);
    }

    @Override
    public Collection<Itasks> LoadTasks() {
        return db.LoadTasks();
    }
    
    public void ViewTasks(){
        if(dataTasks == null){
            Viewer.DisplayMsg("Loading tasks...");
            dataTasks = LoadTasks();
        }
        Iiterator dataIterator = dataTasks.createStandardIterator();
        Viewer.ChoicesDisplayer(dataIterator);
    }

    @Override
    public void InsertTask(Itasks task) {
        db.InsertTask(task);
        this.dataTasks = null;
    }

    @Override
    public void InsertVolunteer(Volunteer v) {
        db.InsertVolunteer(v);
        dataVol = null;
    }

    @Override
    public void DeleteTask(Itasks task) {
        
        db.DeleteTask(task);
        this.dataTasks = null;
    }

    @Override
    public void DeleteVolunteer(Volunteer v) {
        db.DeleteVolunteer(v);
        this.dataVol = null;
    }

    @Override
    public void UpdateTask(String taskCode, Itasks newTask) {
     db.UpdateTask(taskCode, newTask);
     dataTasks = null;
    }

    @Override
    public void UpdateVolunteer(String id, Volunteer newVol) {
        db.UpdateVolunteer(id, newVol);
        this.dataVol = null;
    }
    public static VirtualProxy getInstance(String taskFilePath, String volFilePath) {
        if(instance == null){
            instance = new VirtualProxy(TextFileDatabase.getInstance(taskFilePath, volFilePath));
        }
        return instance;
        
    }
}
