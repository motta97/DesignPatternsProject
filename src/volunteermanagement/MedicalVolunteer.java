/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.MedicalVolunteerDataContainer;
import Tasks.Itasks;
import Tasks.MedicalTask;
import Enums.MedicalFields;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Map;
/**
 *
 * @author Compuomart
 */
public class MedicalVolunteer extends Volunteer {
    private int checkupLimitPerDay;
    private String certifiedBy;
    private MedicalFields specialization;
    private String certificationLevel;
    private String medicalLicense;
    private LocalDate licExpDate;
    private LocalDate currDate = LocalDate.now();
    private String Role;
    private MedicalVolunteerDataContainer dataContainer;
    public MedicalVolunteer (String n,String ph,String e,MedicalVolunteerDataContainer container) throws IllegalArgumentException{
        
        //String license, String certificationLevel,String expDate, MedicalFields specialization,int limitPerDay,String certifiedBy,String Role
        super(n, container.getID(), ph, e);
        //this.Role; --> implement roles
        this.dataContainer = container;
        this.specialization = container.getField();
        this.medicalLicense = container.getLicense();
            this.licExpDate = container.getLicenseExpDate();
        
        this.certifiedBy = container.getCertifier();
        this.certificationLevel = container.getCertificationLevel();
        this.checkupLimitPerDay = container.getLimitPerDay();
        
    }
    @Override
    public BasicVolunteerDataContainer getVolunteerDataAsContainer(){
        return dataContainer;
    }
    @Override
    public String getRole() {
        return this.Role;
    }
    
    public boolean IsLiscenseValid(){
        if(this.licExpDate.isEqual(currDate) || this.licExpDate.isBefore(currDate)){
            return false;
        }
        else{
            return true;
        }
    }
    public MedicalFields GetSpeciality(){
        return this.specialization;
    }
    
    public String GetDegreeOfSpecialization(){
        return this.certificationLevel;
    }

    @Override
    boolean checkRole(Itasks task) {
        if(task instanceof MedicalTask)
            return true;
        else
            return false;
    }
    
}

