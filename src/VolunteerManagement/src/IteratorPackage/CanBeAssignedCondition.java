/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

import Tasks.Itasks;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public class CanBeAssignedCondition implements Icondition<Volunteer> {
    private Itasks task;
    public CanBeAssignedCondition(Itasks task){
        this.task = task;
    }
    @Override
    public boolean IsDesired(Volunteer v){
        boolean temp = v.CanBeAssigned(task); 
        return temp;
    }
}
