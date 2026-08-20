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
public class TaskResolvedState implements TaskState {

    public TaskResolvedState() {
    }

    @Override
    public void Assign(Itasks t) {
        Viewer.DisplayMsg("Task already assigned");
    }

    @Override
    public void Resolve(Itasks t) {
        Viewer.DisplayMsg("Task already resolved");
    }

    @Override
    public void Reopen(Itasks t) {
        Viewer.DisplayMsg("Reopening task, transitioning back to in progress state");
        t.SetTaskState(new TaskInProgressState());
    }

    @Override
    public void Close(Itasks t) {
        Viewer.DisplayMsg("Closing task, transitioning from resolved to closed state");
        t.SetTaskState(new TaskClosedState());
    }

    @Override
    public void Complete(Itasks t) {
        Viewer.DisplayMsg("Cannot complete task yet");
    }
    
}
