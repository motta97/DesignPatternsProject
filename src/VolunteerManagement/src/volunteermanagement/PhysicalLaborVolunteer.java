/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import volunteermanagement.Enums.MedicalDiagnosis;
import volunteermanagement.Enums.EquipmentCertifications;
import java.util.ArrayList;

/**
 *
 * @author mohandiss
 */
public class PhysicalLaborVolunteer extends Volunteer {
    private float currMaxLiftingCapacity;
    private boolean requiresAccomadation;
    private ArrayList<EquipmentCertifications> certifiedEquipments = new ArrayList<>();
    private ArrayList<MedicalDiagnosis> medicalCondition = new ArrayList<>();
    private String Role;
    private int currRequiredWeekHours = 60;
    private int originalWeekHours = currRequiredWeekHours;
    private float originalLiftingCapacity;
    private boolean isAvailable = true;
    
    public PhysicalLaborVolunteer(String name, String id, String phone, String email, String prefs
    ,float maxCap, boolean requiresAccomadation,String Role) {
        super(name, id, phone, email, prefs);
        this.currMaxLiftingCapacity = maxCap;
        this.originalLiftingCapacity = this.currMaxLiftingCapacity;
        this.requiresAccomadation = requiresAccomadation;
        this.Role = Role;
    }
    public void AddEquipmentCertification(EquipmentCertifications ec){
        certifiedEquipments.add(ec);
    }
    public void RemoveCertification(EquipmentCertifications ec){
        for(EquipmentCertifications e : certifiedEquipments){
            if(e.equals(ec)){
                certifiedEquipments.remove(e);
            }
        }
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
        if(this.certifiedEquipments.contains(equipment)){
            return true;
        }
        else{
            return false;
        }
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
        this.medicalCondition.add(md);
    }
    public void ReduceExpectedEffort(boolean canWork,int reducedHours, float reducedLiftingWeight){
        this.currMaxLiftingCapacity -= reducedLiftingWeight;
        this.currRequiredWeekHours -= reducedHours;
        this.isAvailable = canWork;
    }
    public void BackToDuty(){
        this.isAvailable = true;
        this.currMaxLiftingCapacity = this.originalLiftingCapacity;
        this.currRequiredWeekHours = this.originalWeekHours;
    }
}
