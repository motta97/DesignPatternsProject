/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import IteratorPackage.Collection;
import IteratorPackage.DataCondition;
import IteratorPackage.Icondition;
import IteratorPackage.Iiterator;
import StrategyPatterns.VolunteersDataCollectionStrategies.BaseVolunteerdataCollectionStrategy;
import StrategyPatterns.VolunteersDataCollectionStrategies.DataCollectionStrategyFactory;
import utility.IuserFactoryAdapter;
import utility.User;
import Enums.VolunteerClassifications;

/**
 *
 * @author abeer
 */
public class VolunteerFactoryAdapter implements IuserFactoryAdapter {
    private VolunteerFactory volFactory;
    private BaseVolunteerdataCollectionStrategy collectionStrategy;
    
    public User createUserVolunteer(VolunteerClassifications volClassify,String name,String email,String phone){
        collectionStrategy = DataCollectionStrategyFactory.createStrategy(volClassify);
        BasicVolunteerDataContainer container = collectionStrategy.CollectVolunteerData();
        return volFactory.createVolunteer(volClassify, name,phone,email,container);
        
    }

    @Override
    public User CreateInstance(String type, String name, String email, String phoneNumber) {
        VolunteerClassifications volClassify = ConverteStringTypeToEnum(type);
        return createUserVolunteer(volClassify,name,email,phoneNumber);
    }
    
    private VolunteerClassifications ConverteStringTypeToEnum(String type){
        return VolunteerClassifications.valueOf(type);
    }
}
