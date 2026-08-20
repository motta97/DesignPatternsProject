/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import IteratorPackage.Collection;
import volunteermanagement.Enums.TaskType;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.TaskSkills;
/**
 *
 * @author Compuomart
 */
public abstract class MedicalTask extends Itasks{
    private MedicalFields medicalSpeciality;
    protected static int globalTaskCounter =0;
    public MedicalTask(TaskType taskType, int hoursNeeded,Collection<TaskSkills> neededSkills,MedicalFields medicalSpeciality){
        super(taskType, hoursNeeded,neededSkills);
        this.medicalSpeciality = medicalSpeciality;
        globalTaskCounter++;
    }
    public MedicalFields getMedicalSpeciality(){
        return this.medicalSpeciality;
    }
}
