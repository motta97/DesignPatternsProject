/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns;

import StrategyPatterns.VolunteersDataCollectionStrategies.BaseVolunteerdataCollectionStrategy;
import StrategyPatterns.VolunteersDataCollectionStrategies.MedicalVolunteerDataCollectionStrategy;
import StrategyPatterns.VolunteersDataCollectionStrategies.PhysicalLaborVolunteerDataCollectionStrategy;
import IteratorPackage.Collection;
import IteratorPackage.Iiterator;
import volunteermanagement.Enums.VolunteerClassifications;

/**
 *
 * @author abeer
 */
public class DataCollectionStrategyFactory {
    public static BaseVolunteerdataCollectionStrategy createStrategy(VolunteerClassifications volClass){
        switch(volClass){
            case VolunteerClassifications.Medical:
                return new MedicalVolunteerDataCollectionStrategy();
            case VolunteerClassifications.PhysicalLabor:
                return new PhysicalLaborVolunteerDataCollectionStrategy();
            default:
                return null;
        }
    }
}
