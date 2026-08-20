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
public class MedicalTaskDataContainer extends BaseTaskDataContainer{
    
    private Collection<MedicalDiagnosis> medicalRecord;
    private MedicalFields medicalSpeciality;
    public MedicalTaskDataContainer(Collection<TaskSkills> reqSkills, int hours, Collection<MedicalDiagnosis> mRecord, MedicalFields speciality) {
        super( reqSkills, hours);
        this.medicalRecord = mRecord;
        this.medicalSpeciality = speciality;
    }
    public Collection<MedicalDiagnosis> getMedicalRecord(){
        return this.medicalRecord;
    }
    public MedicalFields getReqSpeciality(){
        return this.medicalSpeciality;
    }
}


