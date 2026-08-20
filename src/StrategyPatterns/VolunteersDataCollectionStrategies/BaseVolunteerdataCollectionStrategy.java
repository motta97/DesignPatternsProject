/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns.VolunteersDataCollectionStrategies;

import DataContainers.VolunteersDataContainers.BasicVolunteerDataContainer;
import MVC.Viewer;

/**
 *
 * @author abeer
 */
public abstract class BaseVolunteerdataCollectionStrategy {
    private static Viewer viewer = Viewer.getInstance();
<<<<<<<< Updated upstream:src/StrategyPatterns/VolunteersDataCollectionStrategies/BaseVolunteerdataCollectionStrategy.java
    protected String name,id,email,phone;
========
    protected String id;
    
>>>>>>>> Stashed changes:NetBeansProject_DP/src/main/java/StrategyPatterns/VolunteersDataCollectionStrategies/BaseVolunteerdataCollectionStrategy.java
    public void InitializeBaseParamters(){
        viewer.DisplayMsg("Enter new Volunteer data: ");
        
         name = viewer.promptForString("Name: ");
        
         id = viewer.promptForString("ID: ");
        
         email = viewer.promptForString("Email: ");
        
         phone = viewer.promptForString("Phone: ");
        
        
    };
    public abstract BasicVolunteerDataContainer CollectVolunteerData();
}
