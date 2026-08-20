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
import Enums.EquipmentCertifications;
import Enums.MedicalFields;
import Enums.VolunteerClassifications;
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
        switch(type){
            case VolunteerClassifications.PhysicalLabor:
               return HandlePhysicalLaborParsing(data);
            case VolunteerClassifications.Medical:
                return HandleMedicalParsing(data);
            default:
                return null;
        }
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

    private Volunteer HandlePhysicalLaborParsing(String[] data) {
        //return super.getContainerAsString()+","+this.maxCap+","+this.reqAccomdations+","+this.certifiedTools.collectionToString();
        String name = data[0];
        String phone = data[1];
        String email = data[2];
        String id = data[4];
        float maxCap = parseFloat(data[5]);
        boolean reqAcc = parseBoolean(data[6]);
        Collection<EquipmentCertifications> certifiedEquipment = new Collection<>();
        String[] tools = data[7].split("\\|");
        Collection<String> toolsCollection = new Collection<>(tools);
        Iiterator<String> toolsIterator = toolsCollection.createStandardIterator();
        while(toolsIterator.hasNext()){
            String tool = toolsIterator.getNext();
            
            certifiedEquipment.Add(EquipmentCertifications.valueOf(tool));
        }
        PhysicalLaborVolunteerDataContainer container = new PhysicalLaborVolunteerDataContainer(id,maxCap,reqAcc,certifiedEquipment); 
        return new PhysicalLaborVolunteer(name,phone,email,container);
    }
    private Volunteer HandleMedicalParsing(String[] data){
        String name = data[0];
        String phone = data[1];
        String email = data[2];
        String id = data[4];
        //super.getContainerAsString()+","+this.specialization+","+this.certificationLevel+","+this.certifiedBy+","+this.lic+","+this.limitPerDay+","+this.expDate.toString();
        MedicalFields speciality  = MedicalFields.valueOf(data[5]);
        String certificationLevel = data[6];
        String certifiedBy = data[7];
        String lic = data[8];
        int limit = parseInt(data[9]);
        LocalDate expDate = LocalDate.parse(data[10]);
        MedicalVolunteerDataContainer container = new MedicalVolunteerDataContainer(id,speciality,certificationLevel,certifiedBy,lic,limit,expDate.toString());
        return new MedicalVolunteer(name,phone,email,container);
    }
    
}
