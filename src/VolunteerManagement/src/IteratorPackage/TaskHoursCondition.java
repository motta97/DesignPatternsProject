/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

import Tasks.Itasks;

/**
 *
 * @author Compuomart
 */
public class TaskHoursCondition implements Icondition<Itasks>{

    int hours;
    public TaskHoursCondition(int hours){
        this.hours = hours;
    }
    @Override
    public boolean IsDesired(Itasks t) {
        if(t.GetHoursNeeded()>this.hours){
            return true;
        }
        else{
            return false;
        }
    }
    
}
