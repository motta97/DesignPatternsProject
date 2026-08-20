/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

import Tasks.Itasks;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public class CanHandleEmergencyAssignment implements Icondition<Volunteer> {

    private Itasks task;
    public CanHandleEmergencyAssignment(Itasks task){
        this.task = task;
    }
    @Override
    public boolean IsDesired(Volunteer v) {
        return v.CanHandleEmergency(task);
    }
    
}
