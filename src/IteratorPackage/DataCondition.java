/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

/**
 *
 * @author Compuomart
 */
public class DataCondition<T> implements Icondition<T>{
    private T desiredData;
    public DataCondition(T data){
        this.desiredData = data;
    }
    @Override
    public boolean IsDesired(T item){
        return desiredData.equals(item);
    }
}
