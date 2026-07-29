package BeneficaryManagement;

import java.util.ArrayList;

public class BeneficaryProgram {
    ArrayList<observerBeneficaryProgram> observers ;

    public BeneficaryProgram(){
        observers = new ArrayList<>() ;
    }
    public void add(observerBeneficaryProgram ref){
        observers.add(ref) ;
    }

    public void remove (observerBeneficaryProgram ref){
    observers.remove(ref) ;

    }

    public void notifyall(){

        for(int i =0 ; i<observers.size() ;i++){
            observers.get(i).update();
        }

    }
}
