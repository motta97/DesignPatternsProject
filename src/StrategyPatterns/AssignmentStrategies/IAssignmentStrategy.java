/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package StrategyPatterns.AssignmentStrategies;

import IteratorPackage.Collection;
import Tasks.Itasks;
import volunteermanagement.Volunteer;

/**
 *
 * @author Compuomart
 */
public abstract class IAssignmentStrategy {
    protected Collection<Volunteer> volunteersCollection;
    public IAssignmentStrategy(Collection<Volunteer> v){
        this.volunteersCollection = v;
    }
    abstract void Assign(Itasks task);
}
