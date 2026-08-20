/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassStatePattern;

import Tasks.Itasks;

/**
 *
 * @author abeer
 */
public interface TaskState {
    void Assign(Itasks t);
    void Resolve(Itasks t);
    void Reopen(Itasks t);
    void Close(Itasks t);
    void Complete(Itasks t);
}
