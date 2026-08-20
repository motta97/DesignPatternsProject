/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

import java.util.ArrayList;

/**
 *
 * @author Compuomart
 */
public class StandardIterator<T> implements Iiterator<T>{
    private int position =0;
    private ArrayList<T> currList;
    public StandardIterator(ArrayList<T> l){
        currList = l;
    }
    @Override
    public boolean hasNext(){
        if(position >= currList.size()){
            return false;
        }
        else{
            return true;
        }
        
    }
    @Override
    public T getNext(){
        T temp = currList.get(position);
        position++;
        return temp;
    }
}
