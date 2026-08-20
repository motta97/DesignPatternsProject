/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns;

import DataContainers.BaseTaskDataContainer;
import DataContainers.BloodExtractionTaskDataContainer;
import DataContainers.MedicalTaskDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import MVC.Viewer;
import Enums.BloodType;

/**
 *
 * @author abeer
 */
public class BloodExtractionTaskDataCollectionStrategy extends MedicalTaskDataCollectionStrategy{
    @Override
    public BaseTaskDataContainer CollectTaskData(){
        return StoreTaskData((MedicalTaskDataContainer) super.CollectTaskData());
    }
    public BloodExtractionTaskDataContainer StoreTaskData(MedicalTaskDataContainer data){
         boolean isFasting = Viewer.promptForBoolean("Fasting status: ");
         int vialsCount = Viewer.promptForInt("Enter vials count: ");
         BloodType bt;
         int input = 0;
         Iiterator bloodTypeIterator;
         while(input>BloodType.values().length || input<=0){
             bloodTypeIterator = new Collection<BloodType>(BloodType.values()).createStandardIterator();
             Viewer.ChoicesDisplayer(bloodTypeIterator);
             input = Viewer.promptForInt("Enter a valid choice");
         }
         bt = BloodType.values()[input-1];
         
         return new BloodExtractionTaskDataContainer(data.getNeededSkills(),data.getHoursNeeded(),isFasting,vialsCount,bt,data.getMedicalRecord(),data.getReqSpeciality());
    }
}
