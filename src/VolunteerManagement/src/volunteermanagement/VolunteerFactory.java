/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.MedicalVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.PhysicalLaborVolunteerDataContainer;
import java.util.Map;
import volunteermanagement.Enums.VolunteerClassifications;

/**
 *
 * @author abeer
 */
public class VolunteerFactory {
    public static Volunteer createVolunteer(VolunteerClassifications vc, BasicVolunteerDataContainer container){
       switch(vc){
           case VolunteerClassifications.Medical:
               return new MedicalVolunteer((MedicalVolunteerDataContainer) container);
           case VolunteerClassifications.PhysicalLabor:
               return new PhysicalLaborVolunteer((PhysicalLaborVolunteerDataContainer) container);
           case VolunteerClassifications.Adminstrative:
               return null;
           default:
               System.out.println("Invalid classification or not implemented in factory yet");
               return null;
       } 
    }
}
