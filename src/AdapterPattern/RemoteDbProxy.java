/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdapterPattern;

import DataContainers.BaseTaskDataContainer;
import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import DatabaseService.RemoteBackUpProxy;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import MVC.Viewer;
import Tasks.Itasks;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public class RemoteDbProxy implements Idatabase{
    private RemoteBackUpProxy remoteServer;
    
    public RemoteDbProxy() throws RemoteException, NotBoundException{
        try{
            Registry reg = LocateRegistry.getRegistry("localhost",8000);
            remoteServer = (RemoteBackUpProxy)reg.lookup("DataService");
            remoteServer.GetAuthorAndPass("User","123");
        }catch(java.io.IOException e){
            Viewer.DisplayMsg("Backup server failed to connect"+e.getMessage());
        }
    }

    @Override
    public void SaveVolunteers(Collection<Volunteer> data) {
        if(remoteServer ==null)
            return;
        ArrayList<String> backUpData = new ArrayList<>();
        Iiterator dataIterator = data.createStandardIterator();
        while(dataIterator.hasNext()){
            Volunteer v = (Volunteer)dataIterator.getNext();
            BasicVolunteerDataContainer container = v.getData();
            String line = v.getName()+","+v.getPhone()+","+v.getEmail()+","+container.getContainerAsString();
            backUpData.add(line);
        }
        try{
            remoteServer.StoreData(backUpData);
            Viewer.DisplayMsg("Volunteers successfully stored in backup server");
        }catch(java.io.IOException e){
            Viewer.DisplayMsg("Error in uploading to server: "+e.getMessage());
        }
        
    }

    @Override
    public Collection<Volunteer> LoadVolunteers() {
        return new Collection<>();
    }

    @Override
    public void SaveTasks(Collection<Itasks> data) {
        if(remoteServer ==null)
            return;
        ArrayList<String> backUpData = new ArrayList<>();
        Iiterator dataIterator = data.createStandardIterator();
        while(dataIterator.hasNext()){
            Itasks t = (Itasks)dataIterator.getNext();
            BaseTaskDataContainer container = t.getData();
            String line = t.GetTaskCode()+","+container.getContainerAsString();
            backUpData.add(line);
        }
        try{
            remoteServer.StoreData(backUpData);
            Viewer.DisplayMsg("tasks successfully stored in backup server");
        }catch(java.io.IOException e){
            Viewer.DisplayMsg("Error in uploading to server: "+e.getMessage());
        }
    }

    @Override
    public Collection<Itasks> LoadTasks() {
        return new Collection<>();
    }

    @Override
    public void InsertTask(Itasks task) {
       }

    @Override
    public void InsertVolunteer(Volunteer v) {
        }

    @Override
    public void DeleteTask(Itasks task) {
        }

    @Override
    public void DeleteVolunteer(Volunteer v) {
        }

    @Override
    public void UpdateTask(String taskCode, Itasks newTask) {
        }

    @Override
    public void UpdateVolunteer(String id, Volunteer newVol) {
        }
    
}
