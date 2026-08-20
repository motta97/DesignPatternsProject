/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns.VolunteersDataCollectionStrategies;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.PhysicalLaborVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import MVC.Viewer;
import Enums.EquipmentCertifications;

/**
 *
 * @author abeer
 */
public class PhysicalLaborVolunteerDataCollectionStrategy extends BaseVolunteerdataCollectionStrategy{
    
    @Override
    public BasicVolunteerDataContainer CollectVolunteerData(){
        super.InitializeBaseParamters();
        return RegisterPhysicalLaborVolunteer();
    }
     public PhysicalLaborVolunteerDataContainer RegisterPhysicalLaborVolunteer( ){
         
         float maxCap = Viewer.promptForFLoat("Max carry capacity: ");
         boolean reqAcc = Viewer.promptForBoolean("Do you require accomodation? ");
         Viewer.DisplayMsg("Choose equipment certifications: ");
         
         Collection<EquipmentCertifications> certifiedTools = new Collection<>();
         Iiterator iterator = new Collection<>(EquipmentCertifications.values()).createStandardIterator();
         Viewer.ChoicesDisplayer(iterator);
         int input = Viewer.promptForInt("Send -1 when done");
         while(input != -1 ){
             if(!(input>EquipmentCertifications.values().length || input<=0))
                certifiedTools.Add(EquipmentCertifications.values()[input-1]);
             else
                 Viewer.DisplayMsg("Enter a valid input");
             iterator = new Collection<>(EquipmentCertifications.values()).createStandardIterator();
             Viewer.ChoicesDisplayer(iterator);
             input = Viewer.promptForInt("Send -1 when done");
         }
         return new PhysicalLaborVolunteerDataContainer(id,maxCap,reqAcc,certifiedTools);
     }
}
