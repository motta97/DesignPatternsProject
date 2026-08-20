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
    
    public BasicVolunteerDataContainer CollectVolunteerData(){
        viewer.DisplayMsg("Enter new Volunteer data: ");
        
        String name = viewer.promptForString("Name: ");
        
        String id = viewer.promptForString("ID: ");
        
        String email = viewer.promptForString("Email: ");
        
        String phone = viewer.promptForString("Phone: ");
        
        return new BasicVolunteerDataContainer(name,id,email,phone);
    };
}
