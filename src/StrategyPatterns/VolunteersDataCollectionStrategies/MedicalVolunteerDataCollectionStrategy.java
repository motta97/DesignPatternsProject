/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns.VolunteersDataCollectionStrategies;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import DataContainers.VolunteersDataContainers.MedicalVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import MVC.Viewer;
import static MVC.Viewer.ChoicesDisplayer;
import Enums.MedicalFields;

/**
 *
 * @author abeer
 */
public class MedicalVolunteerDataCollectionStrategy extends BaseVolunteerdataCollectionStrategy{
    private static Viewer viewer = Viewer.getInstance();
    @Override
    public BasicVolunteerDataContainer CollectVolunteerData() {
        super.InitializeBaseParamters();
        return RegisterMedicalVolunteer();
    }
    public MedicalVolunteerDataContainer RegisterMedicalVolunteer( ){
        
        
        MedicalFields field = HandleMedicalFields();
        
        String lic = viewer.promptForString("License: ");
        
        String certificationLevel = viewer.promptForString("Certification level: ");
        
        String certifier = viewer.promptForString("Certifier: ");
        
        int limit = viewer.promptForInt("limit per day: ");
        
        String expDate = viewer.promptForString("licnese expiry date: ");
        
        MedicalVolunteerDataContainer dataContainer = new MedicalVolunteerDataContainer(id,field,lic,certificationLevel,expDate,limit,certifier);
        return dataContainer;
    }
    private  MedicalFields HandleMedicalFields(){
        viewer.DisplayMsg("Choose medicalField: ");
        Collection<MedicalFields> availableFields = new Collection(MedicalFields.values());
        Iiterator fieldsIterator = availableFields.createStandardIterator();
        int choice = 0;
        while(choice>MedicalFields.values().length||choice<1){
            
            ChoicesDisplayer(fieldsIterator);
            choice = viewer.promptForInt("Enter a valid choice");
            fieldsIterator = availableFields.createStandardIterator();
        }
        MedicalFields chosenField = MedicalFields.values()[choice-1] ;
        
        return chosenField;
    }
}
