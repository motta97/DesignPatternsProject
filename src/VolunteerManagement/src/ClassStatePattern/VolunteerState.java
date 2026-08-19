/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ClassStatePattern;

import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public interface VolunteerState {
    public boolean CanTakeTask();
    public boolean CanHandleEmergency();
    public void NextState(Volunteer v);
}
