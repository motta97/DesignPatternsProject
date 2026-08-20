/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataContainers.VolunteersDataContainers;

import IteratorPackage.Collection;
import volunteermanagement.Enums.EquipmentCertifications;
import volunteermanagement.Enums.VolunteerClassifications;

/**
 *
 * @author abeer
 */
public class PhysicalLaborVolunteerDataContainer extends BasicVolunteerDataContainer{
    private float maxCap;
    private boolean reqAccomdations;
    private Collection<EquipmentCertifications> certifiedTools;
    public PhysicalLaborVolunteerDataContainer(String n, String id, String ph, String email,float maxCap,boolean reqAcc,Collection<EquipmentCertifications>tools) {
        super(n, id, ph, email);
        this.maxCap = maxCap;
        this.reqAccomdations = reqAcc;
        this.certifiedTools = tools;
        if(tools ==null) this.certifiedTools = new Collection<EquipmentCertifications>();
    }
    public float getMaxCap(){
        return this.maxCap;
    }
    public boolean getAccomadationStatus(){
        return this.reqAccomdations;
    }
    public Collection<EquipmentCertifications> getCertifiedEquipment(){
        return this.certifiedTools;
    }
    @Override
    public String getContainerAsString(){
        return super.getContainerAsString()+","+this.maxCap+","+this.reqAccomdations+","+this.certifiedTools.collectionToString();
    }

    @Override
    VolunteerClassifications getVolunteerType() {
        return VolunteerClassifications.PhysicalLabor;
    }
    
    
}
