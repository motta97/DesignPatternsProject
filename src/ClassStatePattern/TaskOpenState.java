/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassStatePattern;

import MVC.Viewer;
import Tasks.Itasks;

/**
 *
 * @author abeer
 */
public class TaskOpenState implements TaskState{

    
    @Override
    public void Assign(Itasks t) {
        Viewer.DisplayMsg("Task is now assigned");
        t.SetTaskState(new TaskInProgressState());
    }

    @Override
    public void Resolve(Itasks t) {
        Viewer.DisplayMsg("Cannot transition to ResolvedState from OpenState");
    }

    @Override
    public void Reopen(Itasks t) {
        Viewer.DisplayMsg("task has just opened");
    }

    @Override
    public void Close(Itasks t) {
        Viewer.DisplayMsg("Cannot transition to ClosedState from OpenState");
    }
    @Override
    public void Complete(Itasks t) {
        Viewer.DisplayMsg("Cannot complete task yet");
    }
    
}
