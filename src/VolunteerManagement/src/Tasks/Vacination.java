/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

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
    public Vacination(int hours,Collection<TaskSkills> neededSkills,Map<String,Object> extraData){
        super(TaskType.MCU,hours,neededSkills,(MedicalFields)extraData.get("MedicalField"));
        taskCounter++;
        
        this.vaccineBatchNum = (String) extraData.get("batchNum");
        this.observationTime = (int)extraData.get("obsTime");
    }
    @Override
    String getTaskSeqNum(){
        return globalTaskCounter+""+taskCounter;
    }

    
}
