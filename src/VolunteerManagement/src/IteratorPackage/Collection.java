/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Compuomart
 */
public class Collection<T>{
    ArrayList<T> collection;
    
    
    public Collection(){
        collection = new ArrayList<>();
    }
    public Collection(T[] arr){
        collection = new ArrayList<>(Arrays.asList(arr));
    }
    public Collection(ArrayList<T> arr){
        collection = arr;
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
