/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns.AssignmentStrategies;

import StrategyPatterns.AssignmentStrategies.IAssignmentStrategy;
import ClassStatePattern.IdleState;
import IteratorPackage.AndCondition;
import IteratorPackage.CanBeAssignedCondition;
import IteratorPackage.Collection;
import IteratorPackage.FilteredIterator;
import IteratorPackage.Icondition;
import IteratorPackage.VolunteerStateCondition;
import Tasks.Itasks;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public class StandardAssignmentStrategy extends IAssignmentStrategy{

    public StandardAssignmentStrategy(Collection<Volunteer> v) {
        super(v);
    }

    @Override
    void Assign(Itasks task) {
        
        Icondition c2 = new CanBeAssignedCondition(task);
        
        FilteredIterator volunteerIterator = (FilteredIterator) volunteersCollection.createFilteredIterator(c2);
        Volunteer availableVolunteer;
        if(volunteerIterator.hasNext()){
            availableVolunteer = (Volunteer)volunteerIterator.getNext();
            availableVolunteer.AssignTask(task);
            System.out.println("Assigned task to: "+availableVolunteer.getName()+" "+availableVolunteer.getID());
        }else{
            System.out.println("No available qualified volunteers for the task");
        }
       
        
    }
    
}
