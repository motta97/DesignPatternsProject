/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

import ClassStatePattern.VolunteerState;

/**
 *
 * @author Compuomart
 */
public class VolunteerStateCondition implements Icondition<VolunteerState> {
    private VolunteerState desiredState;
    public VolunteerStateCondition(VolunteerState s){
        this.desiredState = s;
    }
    @Override
    public boolean IsDesired(VolunteerState t) {
        return desiredState.equals(t);
    }
    
}
