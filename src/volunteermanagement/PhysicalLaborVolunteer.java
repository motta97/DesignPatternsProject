/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.PhysicalLaborVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.DataCondition;
import IteratorPackage.Icondition;
import IteratorPackage.Iiterator;
import Tasks.Itasks;
import Enums.MedicalDiagnosis;
import Enums.EquipmentCertifications;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author mohandiss
 */
public class PhysicalLaborVolunteer extends Volunteer {
    private float currMaxLiftingCapacity;
    private boolean requiresAccomadation;
    private Collection<EquipmentCertifications> certifiedEquipments;
    private Collection<MedicalDiagnosis> medicalCondition;
    private String Role;
    private int currRequiredWeekHours = 60;
    private int originalWeekHours = currRequiredWeekHours;
    private float originalLiftingCapacity;
    private PhysicalLaborVolunteerDataContainer dataContainer;
    public PhysicalLaborVolunteer(String n,String ph,String e,PhysicalLaborVolunteerDataContainer container)
    {
        
        
        super(n, container.getID(), ph, e);
        this.currMaxLiftingCapacity = container.getMaxCap();
        this.originalLiftingCapacity = this.currMaxLiftingCapacity;
        this.requiresAccomadation = container.getAccomadationStatus();
        this.dataContainer = container;
        this.certifiedEquipments = container.getCertifiedEquipment();
        //this.Role; --> implement roles
    }
    @Override
    public BasicVolunteerDataContainer getVolunteerDataAsContainer(){
        
        return dataContainer;
    }
    public void AddEquipmentCertification(EquipmentCertifications ec){
        certifiedEquipments.Add(ec);
    }
    public void RemoveCertification(EquipmentCertifications ec){
        this.certifiedEquipments.Remove(ec);
    }
    
    public boolean CanLift(float weight){
        if(weight < this.currMaxLiftingCapacity){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean CanOperate(EquipmentCertifications equipment){
        Icondition<EquipmentCertifications> c = new DataCondition<EquipmentCertifications>(equipment);
        Iiterator findEquipCertificate = this.certifiedEquipments.createFilteredIterator(c);
        if(findEquipCertificate.hasNext()){
            return true;
        }
        return false;
    }
  /*  public boolean CanTakeTask(Itasks task){
        if(this.isAvailable){
            
        }
    }
*/
    @Override
    public String getRole() {
        return this.Role;
    }
    
    public void UpdateHealthCondition(MedicalDiagnosis md){
        this.medicalCondition.Add(md);
    }
    public void ReduceExpectedEffort(boolean canWork,int reducedHours, float reducedLiftingWeight){
        this.currMaxLiftingCapacity -= reducedLiftingWeight;
        this.currRequiredWeekHours -= reducedHours;
        
    }
    

    @Override
    boolean checkRole(Itasks task) {
        //still need physical labor tasks
        return false;
    }

}
    