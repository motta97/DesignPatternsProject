/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdapterPattern;

import DataContainers.BaseTaskDataContainer;
import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.MedicalVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.PhysicalLaborVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.DataCondition;
import IteratorPackage.Icondition;
import IteratorPackage.Iiterator;
import Tasks.Itasks;
import java.io.IOException;
import volunteermanagement.Volunteer;
import java.io.Serializable;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.util.ArrayList;
import volunteermanagement.Enums.EquipmentCertifications;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.TaskType;
import volunteermanagement.Enums.VolunteerClassifications;
import volunteermanagement.MedicalVolunteer;
import volunteermanagement.PhysicalLaborVolunteer;
/**
 *
 * @author abeer
 */
public class TextFileDatabase implements Idatabase{
    private String tasksFilePath;
    private String volunteersFilePath;
    private static TextFileDatabase instance;
    private TextFileDatabase(String tasksFilePath,String volunteersFilePath){
        this.tasksFilePath = tasksFilePath;
        this.volunteersFilePath = volunteersFilePath;
    }
    public static TextFileDatabase getInstance(String tasksFilePath,String volFilePath){
        if(instance ==null){
            instance = new TextFileDatabase(tasksFilePath,volFilePath);
        }
        return instance;
    }
    public void SetTasksFilePath(String filePath){
        this.tasksFilePath = filePath;
    }
    public void SetVolFilePath(String filePath){
        this.volunteersFilePath = filePath;
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
                line = v.getName()+","+v.getPhone()+","+v.getEmail()+","+container.getContainerAsString();
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
                
                VolunteerClassifications type = VolunteerClassifications.valueOf(data[3]);
                
                Volunteer v = parseStringDataToVolunteer(type,data);
                loadedVolunteers.Add(v);
            }
            buffer.close();
        }catch(java.io.IOException e){
            System.out.println("Couldn't read volunteers file: "+e.getMessage());
        }
        return loadedVolunteers;
    }
    
    private Volunteer parseStringDataToVolunteer(VolunteerClassifications type,String[] data){
        return VolunteerParseFactory.ParseStringToVolunteer(type, data);
    }

    @Override
    public void SaveTasks(Collection<Itasks> data) {
        try{
            java.io.FileWriter writer = new java.io.FileWriter(this.tasksFilePath,false);
            java.io.PrintWriter printer = new java.io.PrintWriter(writer);
            Iiterator dataIterator = data.createStandardIterator();
            String line="";
            Itasks t;
            while(dataIterator.hasNext()){
                t = (Itasks)dataIterator.getNext();
                BaseTaskDataContainer container = t.getData();
                line = t.GetTaskCode()+","+container.getContainerAsString();
                printer.println(line);
            }
            printer.close();
        }catch(java.io.IOException e){
            System.out.print("Error accessing filepath: "+e.getMessage());
        }
    }

    @Override
    public Collection<Itasks> LoadTasks() {
        Collection<Itasks> loadedTasks = new Collection<>();
        try{
            java.io.FileReader fileReader = new java.io.FileReader(this.tasksFilePath);
            java.io.BufferedReader buffer = new java.io.BufferedReader(fileReader);
            String line;
            while((line=buffer.readLine())!=null){
                String[] data = line.split(",");
                
                TaskType type = TaskType.valueOf(data[3]);
                
                Itasks t = parseStringDataToTask(type,data);
                loadedTasks.Add(t);
            }
            buffer.close();
        }catch(java.io.IOException e){
            System.out.println("Couldn't read volunteers file: "+e.getMessage());
        }
        return loadedTasks;
    }

    @Override
    public void InsertTask(Itasks task) {
        Collection<Itasks> tasks = this.LoadTasks();
        tasks.Add(task);
        this.SaveTasks(tasks);
    }

    @Override
    public void InsertVolunteer(Volunteer v) {
        Collection<Volunteer> collection = this.LoadVolunteers();
        collection.Add(v);
        this.SaveVolunteers(collection);
    }

    @Override
    public void DeleteTask(Itasks task) {
        Collection<Itasks> collection = this.LoadTasks();
        collection.Remove(task);
        this.SaveTasks(collection);
    }

    @Override
    public void DeleteVolunteer(Volunteer v) {
        Collection<Volunteer> collection = this.LoadVolunteers();
        collection.Remove(v);
        this.SaveVolunteers(collection);
    }

    @Override
    public void UpdateTask(String taskCode, Itasks newTask) {
        Collection<Itasks> collection = this.LoadTasks();
        Icondition<String> c = new DataCondition<>(taskCode);
        Iiterator<Itasks> taskIterator = collection.createFilteredIterator(c);
        if(taskIterator.hasNext()){
            Itasks oldTask = taskIterator.getNext();
            collection.Remove(oldTask);
            collection.Add(newTask);
            this.SaveTasks(collection);
        }
    }

    @Override
    public void UpdateVolunteer(String id, Volunteer newVol) {
        Collection<Volunteer> collection = this.LoadVolunteers();
        Icondition<String> c = new DataCondition<>(id);
        Iiterator<Volunteer> volIterator = collection.createFilteredIterator(c);
        if(volIterator.hasNext()){
            Volunteer old = volIterator.getNext();
            collection.Remove(old);
            collection.Add(newVol);
            this.SaveVolunteers(collection);
        }
    }

    
    private Itasks parseStringDataToTask(TaskType type, String[] data) {
        return TaskParseFactory.ParseTaskToString(type, data);
    }
    
}
