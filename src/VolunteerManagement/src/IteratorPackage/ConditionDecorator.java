/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

/**
 *
 * @author Compuomart
 */
public abstract class ConditionDecorator<T> implements Icondition<T> {
    protected Icondition<T> wrappedCondition;
    public ConditionDecorator(Icondition c){
        this.wrappedCondition = c;
    }
    @Override
    public boolean IsDesired(T item){
        return wrappedCondition.IsDesired(item);
    }
}
