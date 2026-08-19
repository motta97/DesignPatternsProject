/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import IteratorPackage.Collection;
import Tasks.BloodExtraction;
import Tasks.Vacination;
import Tasks.Itasks;
import Tasks.MedicalCheckUp;
import Tasks.XRayScan;
import java.util.Map;
import volunteermanagement.Enums.TaskSkills;
import volunteermanagement.Enums.TaskType;

/**
 *
 * @author Compuomart
 */
public class TaskFactory {
    public static Itasks CreateTask(TaskType taskType, int hours,Collection<TaskSkills> neededSkills ,Map<String,Object> extraData){
        if(taskType == TaskType.MCU){
            return new MedicalCheckUp(hours,neededSkills,extraData);
        }
        else if(taskType == TaskType.VAC){
            return new Vacination(hours,neededSkills,extraData);
        }
        else if(taskType == TaskType.BE){
            return new BloodExtraction(hours,neededSkills,extraData);
        }
        else if(taskType == TaskType.XRS){
            return new XRayScan(hours,neededSkills,extraData);
        }
        else{
            return null;
        }
    }
}
