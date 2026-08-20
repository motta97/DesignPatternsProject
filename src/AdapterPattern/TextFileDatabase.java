/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdapterPattern;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import Tasks.Itasks;
import java.io.IOException;
import volunteermanagement.Volunteer;
import java.io.Serializable;
import volunteermanagement.Enums.VolunteerClassifications;
/**
 *
 * @author abeer
 */
public class TextFileDatabase implements Idatabase{
    private String tasksFilePath;
    private String volunteersFilePath;
    
    public TextFileDatabase(String tasksFilePath,String volunteersFilePath){
        this.tasksFilePath = tasksFilePath;
        this.volunteersFilePath = volunteersFilePath;
    }
    @Override
    public void SaveVolunteers(Collection<Volunteer> data) {
        try{
            java.io.FileWriter writer = new java.io.FileWriter(this.volunteersFilePath,false);
            java.io.PrintWriter printer = new java.io.PrintWriter(writer);
            Iiterator dataIterator = data.createStandardIterator();
            String line="";
            Volunteer v;
            while(dataIterator.hasNext()){
                v = (Volunteer)dataIterator.getNext();
                BasicVolunteerDataContainer container = v.getData();
                line = container.getContainerAsString();
                printer.println(line);
            }
            printer.close();
        }catch(java.io.IOException e){
            System.out.print("Error accessing filepath: "+e.getMessage());
        }
    }

    @Override
    public Collection<Volunteer> LoadVolunteers() {
        Collection<Volunteer> loadedVolunteers = new Collection<>();
        try{
            java.io.FileReader fileReader = new java.io.FileReader(this.volunteersFilePath);
            java.io.BufferedReader buffer = new java.io.BufferedReader(fileReader);
            String line;
            while((line=buffer.readLine())!=null){
                String[] data = line.split(",");
                VolunteerClassifications type = VolunteerClassifications.valueOf(data[0]);
            }
            buffer.close();
        }catch(java.io.IOException e){
            System.out.println("Couldn't read volunteers file: "+e.getMessage());
        }
        return loadedVolunteers;
    }

    @Override
    public void SaveTasks(Collection<Itasks> data) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Itasks> LoadTasks() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void InsertTask(Itasks task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void InsertVolunteer(Volunteer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void DeleteTask(Itasks task) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void DeleteVolunteer(Volunteer v) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void UpdateTask(String taskCode, Itasks newTask) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void UpdateVolunteer(String id, Volunteer newVol) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
