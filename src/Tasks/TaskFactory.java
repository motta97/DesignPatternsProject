/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import DataContainers.BaseTaskDataContainer;
import DataContainers.BloodExtractionTaskDataContainer;
import DataContainers.MedicalTaskDataContainer;
import DataContainers.VacinationTaskDataContainer;
import DataContainers.XRayScanTaskDataContainer;
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
    public static Itasks CreateTask(TaskType taskType, BaseTaskDataContainer container){
        switch(taskType){
            case TaskType.XRS:
                return new XRayScan((XRayScanTaskDataContainer) container);
            case TaskType.VAC:
                return new Vacination((VacinationTaskDataContainer) container);
            case TaskType.MCU:
                return new MedicalCheckUp((MedicalTaskDataContainer) container);
            case TaskType.BE:
                return new BloodExtraction((BloodExtractionTaskDataContainer) container);
            default:
                return null;
        }
    }
}
