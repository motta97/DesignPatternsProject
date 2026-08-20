/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tasks;

import DataContainers.BaseTaskDataContainer;
import DataContainers.MedicalTaskDataContainer;
import IteratorPackage.Collection;
import Tasks.MedicalTask;
import java.util.Map;
import Enums.MedicalFields;
import Enums.TaskSkills;
import Enums.TaskType;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public class MedicalCheckUp extends MedicalTask {
    
    private static int taskCounter = 0;
    private Collection<String> symptoms;
    private BaseTaskDataContainer data;
    
    public MedicalCheckUp(MedicalTaskDataContainer data){
        super(TaskType.MCU,data.getHoursNeeded(),data.getNeededSkills(),data.getReqSpeciality());
        this.symptoms = new Collection<>();
        taskCounter++;
        this.data = data;
    }
    @Override
    String getTaskSeqNum(){
        return globalTaskCounter+""+taskCounter+"";
    }

    public void AddSymptom(String sym){
        symptoms.Add(sym);
    }
    public void RemoveSymptom(String sym){
        symptoms.Remove(sym);
    }

    @Override
    BaseTaskDataContainer taskData() {
        return this.data;
    }
    
}
