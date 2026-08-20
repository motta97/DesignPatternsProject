/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns;

import DataContainers.BaseTaskDataContainer;
import DataContainers.BloodExtractionTaskDataContainer;
import DataContainers.MedicalTaskDataContainer;
import DataContainers.XRayScanTaskDataContainer;
import MVC.Viewer;

/**
 *
 * @author abeer
 */
public class XRayScanTaskDataCollectionStrategy extends MedicalTaskDataCollectionStrategy {
    @Override
    public BaseTaskDataContainer CollectTaskData(){
        return StoreTaskData((MedicalTaskDataContainer) super.CollectTaskData());
    }
    public XRayScanTaskDataContainer StoreTaskData(MedicalTaskDataContainer data){
        boolean isPregnant = Viewer.promptForBoolean("Pregnancy status: ");
        String targetScan = Viewer.promptForString("Target scan: ");
        
        return new XRayScanTaskDataContainer(data.getNeededSkills(),data.getHoursNeeded(),isPregnant,targetScan,data.getMedicalRecord(),data.getReqSpeciality());
    }
}
