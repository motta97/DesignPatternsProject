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
import volunteermanagement.Enums.EquipmentCertifications;

/**
 *
 * @author abeer
 */
public class PhysicalLaborVolunteerDataCollectionStrategy extends BaseVolunteerdataCollectionStrategy{
    
    @Override
    public BasicVolunteerDataContainer CollectVolunteerData(){
        return RegisterPhysicalLaborVolunteer(super.CollectVolunteerData());
    }
     public PhysicalLaborVolunteerDataContainer RegisterPhysicalLaborVolunteer(BasicVolunteerDataContainer dc ){
         String name = dc.getName();
         String id = dc.getID();
         String email = dc.getEmail();
         String phone = dc.getPhone();
         
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
         return new PhysicalLaborVolunteerDataContainer(name,id,phone,email,maxCap,reqAcc,certifiedTools);
     }
}
