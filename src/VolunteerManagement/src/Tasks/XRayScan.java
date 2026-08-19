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
public class XRayScan extends MedicalTask{
    private static int taskCounter = 0;
    private String targetScan;
    private boolean isPregnant;
    public XRayScan(int hours,Collection<TaskSkills> neededSkills,Map<String, Object> extraData) {
        super(TaskType.MCU,hours,neededSkills,(MedicalFields)extraData.get("MedicalField"));
        taskCounter++;
        this.targetScan = (String)extraData.get("TargetScan");
        this.isPregnant = (boolean)extraData.get("isPregnant");
        
    }

    @Override
    String getTaskSeqNum() {
        return globalTaskCounter+""+taskCounter;
    }
}
