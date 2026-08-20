/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassStatePattern;

import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public class IdleState implements VolunteerState {

    @Override
    public boolean CanTakeTask(){
        return true;
    }
    @Override
    public void NextState(Volunteer v) {
        System.out.println("Volunteer is now occupied");
        v.SetState(new BusyState());
    }
    @Override
    public boolean CanHandleEmergency(){
        return true;
    }

    @Override
    public void EndRest(Volunteer v){
        System.out.println("volunteer is not resting");
    }
}
