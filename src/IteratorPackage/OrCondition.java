/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

/**
 *
 * @author Compuomart
 */
public class OrCondition<T> extends ConditionDecorator<T>{
    private Icondition<T> wrappedCondition2;
    public OrCondition(Icondition<T> c1,Icondition<T> c2) {
        super(c1);
        this.wrappedCondition2 = c2;
    }
    @Override
    public boolean IsDesired(T item){
        return wrappedCondition.IsDesired(item) || wrappedCondition2.IsDesired(item);
    }
    
}
