/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns;

import DataContainers.BaseTaskDataContainer;
import DataContainers.MedicalTaskDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import MVC.Viewer;
import Enums.MedicalDiagnosis;
import Enums.MedicalFields;

/**
 *
 * @author abeer
 */
public class MedicalTaskDataCollectionStrategy extends BaseTaskDataCollectionStrategy{
    
    @Override 
    public BaseTaskDataContainer CollectTaskData(){
        return StoreMedicalTaskData(super.CollectTaskData());
    }
    public MedicalTaskDataContainer StoreMedicalTaskData(BaseTaskDataContainer data){
        
        Iiterator fieldsIterator;
        int input = 0; 
                
        while(input>MedicalFields.values().length || input<=0){
            fieldsIterator = new Collection<MedicalFields>(MedicalFields.values()).createStandardIterator();
            Viewer.ChoicesDisplayer(fieldsIterator);
            input = Viewer.promptForInt("choose task's medical field");
        }
        MedicalFields field = MedicalFields.values()[input-1];
        Collection<MedicalDiagnosis> medicalRecord = new Collection<>();
        return new MedicalTaskDataContainer(data.getNeededSkills(),data.getHoursNeeded(),medicalRecord,field);
    }
}
