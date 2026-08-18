/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import IteratorPackage.Collection;
import java.util.Map;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Enums.TaskType;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public class BloodExtraction extends MedicalTask {
    
    private static int taskCounter =0;
    private int vialsRequired;
    private boolean isFasting;
    private BloodType bloodType;
    
    public BloodExtraction(int hours, Collection<TaskSkills> neededSkills,Map<String, Object> extraData){
        super(TaskType.MCU,hours,neededSkills,(MedicalFields)extraData.get("MedicalField"));
        taskCounter++;
        this.vialsRequired = (int)extraData.get("vialsReq");
        this.isFasting = (boolean)extraData.get("isFasting");
        this.bloodType = (BloodType)extraData.get("BloodType");
    }

    @Override
    String getTaskSeqNum() {
        return globalTaskCounter+""+taskCounter;
    }

    
    
}

enum BloodType{
    A,
    B,
    AB,
    O
}
