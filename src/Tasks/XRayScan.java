/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import DataContainers.XRayScanTaskDataContainer;
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
    public XRayScan(XRayScanTaskDataContainer data) {
        super(TaskType.XRS,data.getHoursNeeded(),data.getNeededSkills(),data.getReqSpeciality());
        taskCounter++;
        this.targetScan = data.getTargetScan();
        this.isPregnant = data.getIsPregnant();
        
    }

    @Override
    String getTaskSeqNum() {
        return globalTaskCounter+""+taskCounter;
    }
}
