/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataContainers.VolunteersDataContainers;

import java.time.LocalDate;
import java.util.Map;
import Enums.MedicalFields;
import Enums.VolunteerClassifications;

/**
 *
 * @author abeer
 */
public class MedicalVolunteerDataContainer extends BasicVolunteerDataContainer{
    private MedicalFields specialization;
    private String certificationLevel;
    private String certifiedBy;
    private String lic;
    private LocalDate expDate;
    private int limitPerDay;
    public MedicalVolunteerDataContainer(String id,MedicalFields specialization,String license, String certificationLevel,String expDate,int limitPerDay,String certifiedBy) 
     throws IllegalArgumentException{
        super(id);
        this.specialization = specialization;
        this.certificationLevel = certificationLevel;
        this.certifiedBy = certifiedBy;
        this.lic = license;
        this.expDate = LocalDate.parse(expDate);
        this.limitPerDay = limitPerDay;
    }
    
    public MedicalFields getField(){
        return this.specialization;
    }
    public String getCertificationLevel(){
        return this.certificationLevel;
    }
    public String getCertifier(){
        return this.certifiedBy;
    }
    public LocalDate getLicenseExpDate(){
        return this.expDate;
    }
    public String getLicense(){
        return this.lic;
    }
    public int getLimitPerDay(){
        return this.limitPerDay;
    }
    @Override
    public String getContainerAsString(){
        return super.getContainerAsString()+","+this.specialization+","+this.certificationLevel+","+this.certifiedBy
                +","+this.lic+","+this.limitPerDay+","+this.expDate.toString();
    }

    @Override
    VolunteerClassifications getVolunteerType() {
        return VolunteerClassifications.Medical;
    }
    
}
