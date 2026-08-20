/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataContainers;

import IteratorPackage.Collection;
import volunteermanagement.Enums.MedicalDiagnosis;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public class VacinationTaskDataContainer extends MedicalTaskDataContainer{
    private String vaccineBatchNum;
    private int obsTime;
    
    public VacinationTaskDataContainer(Collection<TaskSkills> reqSkills, int hours,String vaccNum,int obsTime,Collection<MedicalDiagnosis> mRecord, MedicalFields speciality) {
        super(reqSkills, hours,mRecord,speciality);
        this.obsTime = obsTime;
        this.vaccineBatchNum = vaccNum;
    }
    
    public String getVaccNum(){
        return this.vaccineBatchNum;
    }
    public int getObsTime(){
        return this.obsTime;
    }
    @Override
    
    public String getContainerAsString(){
        return super.getContainerAsString()+","+this.vaccineBatchNum+","+obsTime;
    }
}
