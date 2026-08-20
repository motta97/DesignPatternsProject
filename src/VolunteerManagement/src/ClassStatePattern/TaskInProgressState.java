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
public class TaskInProgressState implements TaskState {

    public TaskInProgressState() {
    }

    @Override
    public void Assign(Itasks t) {
        Viewer.DisplayMsg("Task is In progress");
    }

    @Override
    public void Resolve(Itasks t) {
        Viewer.DisplayMsg("Task has been resolved");
        t.SetTaskState(new TaskResolvedState());
    }

    @Override
    public void Reopen(Itasks t) {
        Viewer.DisplayMsg("Task is in progress");
    }

    @Override
    public void Close(Itasks t) {
        Viewer.DisplayMsg("Cannot transition to ClosedState from InProgressState");
    }
    @Override
    public void Complete(Itasks t) {
        Viewer.DisplayMsg("Cannot complete task yet");
    }
}
