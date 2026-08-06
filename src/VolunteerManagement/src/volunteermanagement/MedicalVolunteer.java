/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import volunteermanagement.Enums.MedicalFields;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
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
    
    public MedicalVolunteer (String name, String id, String phone,
            String email, String prefs
            ,String license, String certificationLevel,String expDate, 
            MedicalFields specialization,
            int limitPerDay,String certifiedBy,String Role) throws IllegalArgumentException{
        super(name, id, phone, email, prefs);
        this.Role = Role;
        this.specialization = specialization;
        this.medicalLicense = license;
        try{
            this.licExpDate = LocalDate.parse(expDate);
        }catch(DateTimeParseException e){
            throw new IllegalArgumentException("ExpirationDate format is not correct!");
        }
        this.certifiedBy = certifiedBy;
        this.certificationLevel = certificationLevel;
        this.checkupLimitPerDay = limitPerDay;
        
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
    
}


class MedicalCheckUp extends Itasks{
    private MedicalFields medicalSpeciality;
    public MedicalCheckUp(int h, MedicalFields mfield) {
        super(h);
        this.medicalSpeciality = mfield;
    }
    public MedicalFields GetMedicalField(){
        return this.medicalSpeciality;
    }
}