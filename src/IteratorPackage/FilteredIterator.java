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
public class FilteredIterator<T> implements Iiterator<T> {
    private Icondition<T> condition;
    
    private int position =0;
    private ArrayList<T> array;
    private T nextValidItem;
    public FilteredIterator(Icondition<T> c, ArrayList<T> l){
        this.array = l;
        this.condition = c;
    }
    @Override
    public boolean hasNext(){
        
            if(nextValidItem !=null){
                return true;
            }
            else{
                T temp;
                while(position<array.size()){ 
                    temp = array.get(position);
                    position++;
                    if(condition.IsDesired(temp)){
                        nextValidItem = temp;
                        return true;
                    }
                }
                return false;
            }
            
        }

    
    @Override
    public T getNext(){
        
        T temp = nextValidItem;
        nextValidItem = null;
        return temp;
    }
}
