/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdapterPattern;

import DataContainers.VolunteersDataContainers.MedicalVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.PhysicalLaborVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import volunteermanagement.Enums.EquipmentCertifications;
import volunteermanagement.Enums.MedicalFields;
import volunteermanagement.Enums.VolunteerClassifications;
import volunteermanagement.MedicalVolunteer;
import volunteermanagement.PhysicalLaborVolunteer;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public class VolunteerParseFactory {
    public static Volunteer ParseStringToVolunteer(VolunteerClassifications type, String[] data){
        switch(type){
            case VolunteerClassifications.PhysicalLabor:
               return HandlePhysicalLaborParsing(data);
            case VolunteerClassifications.Medical:
                return HandleMedicalParsing(data);
            default:
                return null;
        }        
                
        }
    
    
    private static Volunteer HandleMedicalParsing(String[] data){
        String name = data[0];
        String phone = data[1];
        String email = data[2];
        String id = data[4];
        //super.getContainerAsString()+","+this.specialization+","+this.certificationLevel+","+this.certifiedBy+","+this.lic+","+this.limitPerDay+","+this.expDate.toString();
        MedicalFields speciality  = MedicalFields.valueOf(data[5]);
        String certificationLevel = data[6];
        String certifiedBy = data[7];
        String lic = data[8];
        int limit = parseInt(data[9]);
        LocalDate expDate = LocalDate.parse(data[10]);
        MedicalVolunteerDataContainer container = new MedicalVolunteerDataContainer(id,speciality,lic,certificationLevel,expDate.toString(),limit,certifiedBy);
        return new MedicalVolunteer(name,phone,email,container);
    }
    
    private static Volunteer HandlePhysicalLaborParsing(String[] data) {
        //return super.getContainerAsString()+","+this.maxCap+","+this.reqAccomdations+","+this.certifiedTools.collectionToString();
        String name = data[0];
        String phone = data[1];
        String email = data[2];
        String id = data[4];
        float maxCap = parseFloat(data[5]);
        boolean reqAcc = parseBoolean(data[6]);
        Collection<EquipmentCertifications> certifiedEquipment = new Collection<>();
        String[] tools = data[7].split("\\|");
        Collection<String> toolsCollection = new Collection<>(tools);
        Iiterator<String> toolsIterator = toolsCollection.createStandardIterator();
        while(toolsIterator.hasNext()){
            String tool = toolsIterator.getNext();
            
            certifiedEquipment.Add(EquipmentCertifications.valueOf(tool));
        }
        PhysicalLaborVolunteerDataContainer container = new PhysicalLaborVolunteerDataContainer(id,maxCap,reqAcc,certifiedEquipment); 
        return new PhysicalLaborVolunteer(name,phone,email,container);
    }
    


}