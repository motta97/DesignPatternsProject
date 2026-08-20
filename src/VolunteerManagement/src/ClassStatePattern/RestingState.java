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
public class RestingState implements VolunteerState {

    public RestingState() {
    }

    @Override
    public void NextState(Volunteer v) {
        System.out.println("Volunteer has rested");
        v.SetState(new IdleState());
    }
    @Override
    public boolean CanTakeTask() {
        return false;
    }
    @Override
    public boolean CanHandleEmergency(){
        return true;
    }
    @Override
    public void EndRest(Volunteer v){
        v.SetState(new IdleState());
    }
}
