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
public class XRayScanTaskDataContainer extends MedicalTaskDataContainer{
    private boolean isPregnant;
    private String targetScan;
    public XRayScanTaskDataContainer(IteratorPackage.Collection<TaskSkills> reqSkills, int hours, boolean isPregnant, String targetScan,Collection<MedicalDiagnosis> mRecord, MedicalFields speciality) {
        super(reqSkills, hours,mRecord,speciality);
        this.isPregnant = isPregnant;
        this.targetScan = targetScan;
    }
    public boolean getIsPregnant(){
        return this.isPregnant;
    }
    public String getTargetScan(){
        return this.targetScan;
    }
} 