/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataContainers;

import IteratorPackage.Collection;
import volunteermanagement.Enums.BloodType;
import volunteermanagement.Enums.MedicalDiagnosis;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public class BloodExtractionTaskDataContainer extends MedicalTaskDataContainer{
    private boolean isFasting;
    private int reqVialsCount;    
    private BloodType bloodType;
    public BloodExtractionTaskDataContainer( Collection<TaskSkills> reqSkills, int hours, boolean isFasting, int vialsCount, BloodType bt,Collection<MedicalDiagnosis> mRecord, MedicalFields speciality) {
        super( reqSkills, hours,mRecord,speciality);
        this.isFasting = isFasting;
        this.reqVialsCount = vialsCount;
        this.bloodType = bt;
    }
    public boolean getFastingStatus(){
        return this.isFasting;
    }
    public int reqVialsCount(){
        return this.reqVialsCount;
    }
    public BloodType getBloodType(){
        return this.bloodType;
    }
    
}