/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StrategyPatterns.AssignmentStrategies;

import StrategyPatterns.AssignmentStrategies.IAssignmentStrategy;
import ClassStatePattern.IdleState;
import ClassStatePattern.RestingState;
import IteratorPackage.CanHandleEmergencyAssignment;
import IteratorPackage.Collection;
import IteratorPackage.FilteredIterator;
import IteratorPackage.Icondition;
import IteratorPackage.OrCondition;
import IteratorPackage.VolunteerStateCondition;
import Tasks.Itasks;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public class EmergencyAssignmentStrategy extends IAssignmentStrategy {

    public EmergencyAssignmentStrategy(Collection<Volunteer> v) {
        super(v);
    }

    @Override
    void Assign(Itasks task) {
        
        Icondition c = new CanHandleEmergencyAssignment(task);
        FilteredIterator volunteerIterator = (FilteredIterator) volunteersCollection.createFilteredIterator(c);
        if(volunteerIterator.hasNext()){
            Volunteer availableVol = (Volunteer) volunteerIterator.getNext();
            availableVol.EndRest();
            availableVol.AssignTask(task);
            System.out.println("EMERGENCY ASSIGNMENT!");
            System.out.println("Assigned task to: "+availableVol.getName()+" "+availableVol.getID());
        }
        else{
            System.out.println("All volunteers are busy!");
        }
    }
    
}
