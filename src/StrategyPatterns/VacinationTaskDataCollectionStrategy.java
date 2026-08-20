/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns;

import DataContainers.BaseTaskDataContainer;
import DataContainers.BloodExtractionTaskDataContainer;
import DataContainers.MedicalTaskDataContainer;
import DataContainers.VacinationTaskDataContainer;
import MVC.Viewer;

/**
 *
 * @author abeer
 */
public class VacinationTaskDataCollectionStrategy extends MedicalTaskDataCollectionStrategy{
    @Override
    public BaseTaskDataContainer CollectTaskData(){
        return StoreTaskData((MedicalTaskDataContainer) super.CollectTaskData());
    }
    public VacinationTaskDataContainer StoreTaskData(MedicalTaskDataContainer data){
        String vaccNum = Viewer.promptForString("Enter vaccine batch number: ");
        int obsTime = Viewer.promptForInt("Enter observation time: ");
        
        return new VacinationTaskDataContainer(data.getNeededSkills(),data.getHoursNeeded(),vaccNum,obsTime,data.getMedicalRecord(),data.getReqSpeciality());
    }
}
