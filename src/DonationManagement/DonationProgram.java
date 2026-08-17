package DonationManagement;

import utility.Observer;
import utility.Subject;

import java.util.ArrayList;

public class DonationProgram implements Subject {
    ArrayList<Observer> observers ;
    public DonationProgram(){
        observers = new ArrayList<>() ;

    }

    public void add(Observer ref){
        observers.add(ref) ;
    }

    public void remove(Observer ref){

        observers.remove(ref) ;
    }

    public void notifyall(){

        for(int i =0 ;i<observers.size() ;i++){

            observers.get(i).update();
        }
    }
}
