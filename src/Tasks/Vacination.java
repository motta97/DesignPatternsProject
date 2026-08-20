/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import DataContainers.VacinationTaskDataContainer;
import IteratorPackage.Collection;
import Tasks.MedicalTask;
import static Tasks.MedicalTask.globalTaskCounter;
import java.util.Map;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Enums.TaskType;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public class Vacination extends MedicalTask{
    
    private String vaccineBatchNum;
    private int observationTime;
    
    private static int taskCounter=0;
    public Vacination(VacinationTaskDataContainer data){
        super(TaskType.VAC,data.getHoursNeeded(),data.getNeededSkills(),data.getReqSpeciality());
        taskCounter++;
        
        this.vaccineBatchNum = data.getVaccNum();
        this.observationTime = data.getObsTime();
    }
    @Override
    String getTaskSeqNum(){
        return globalTaskCounter+""+taskCounter;
    }

    
}
