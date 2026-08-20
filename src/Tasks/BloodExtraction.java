/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import DataContainers.BaseTaskDataContainer;
import DataContainers.BloodExtractionTaskDataContainer;
import IteratorPackage.Collection;
import java.util.Map;
import Enums.BloodType;
import Enums.MedicalFields;
import Enums.TaskSkills;
import Enums.TaskType;
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
    private BaseTaskDataContainer data;
    public BloodExtraction(BloodExtractionTaskDataContainer data){
        super(TaskType.BE,data.getHoursNeeded(),data.getNeededSkills(),data.getReqSpeciality());
        taskCounter++;
        this.vialsRequired = data.reqVialsCount();
        this.isFasting = data.getFastingStatus();
        this.bloodType = data.getBloodType();
        this.data = data;
    }

    @Override
    String getTaskSeqNum() {
        return globalTaskCounter+""+taskCounter;
    }

    @Override
    BaseTaskDataContainer taskData() {
        return data;
    }

    
    
}


