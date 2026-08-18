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
public class BusyState implements VolunteerState {

    public BusyState() {
    }

    @Override
    public void NextState(Volunteer v) {
        System.out.println("Volunteer has finished task");
        v.SetState(new RestingState());
    }

    @Override
    public boolean CanTakeTask() {
        return false;
    }
    @Override
    public boolean CanHandleEmergency(){
        return false;
    }
}
