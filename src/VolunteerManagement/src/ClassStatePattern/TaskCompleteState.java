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
public class TaskCompleteState implements TaskState {


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
        Viewer.DisplayMsg("Task completed!");
    }

    @Override
    public void Close(Itasks t) {
        Viewer.DisplayMsg("Task already closed");
    }
    @Override
    public void Complete(Itasks t) {
        Viewer.DisplayMsg("Task completed!");
    }
}
