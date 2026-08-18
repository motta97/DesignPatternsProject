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
public class Collection<T>{
    ArrayList<T> collection;
    
    
    public Collection(){
        collection = new ArrayList<>();
    }
    public void Add(T t){
        collection.add(t);
    }
    public void Remove(T t){
        collection.remove(t);
    }
    
    public Iiterator<T> createStandardIterator() {
       return new StandardIterator<T>(collection);
    }
    public Iiterator<T> createFilteredIterator(Icondition c){
        return new FilteredIterator<T>(c,collection);
    }
    
}
