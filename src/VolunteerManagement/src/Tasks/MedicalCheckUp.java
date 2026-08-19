/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import IteratorPackage.Collection;
import Tasks.MedicalTask;
import java.util.Map;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Enums.TaskType;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public class MedicalCheckUp extends MedicalTask {
    
    private static int taskCounter = 0;
    //add list of symptoms
    
    public MedicalCheckUp(int hours,Collection<TaskSkills> neededSkills,Map<String,Object> extraData){
        super(TaskType.MCU,hours,neededSkills,(MedicalFields)extraData.get("MedicalField"));
        taskCounter++;
    }
    @Override
    String getTaskSeqNum(){
        return globalTaskCounter+""+taskCounter+"";
    }

    
}
