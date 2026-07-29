package DonationManagement;

import java.util.ArrayList;

public class DonationProgram {
    ArrayList<observerDonationProgram> observers ;
    public DonationProgram(){
        observers = new ArrayList<>() ;

    }

    public void add(observerDonationProgram ref){
        observers.add(ref) ;
    }

    public void remove(observerDonationProgram ref){

        observers.remove(ref) ;
    }

    public void notifyall(){

        for(int i =0 ;i<observers.size() ;i++){

            observers.get(i).update();
        }
    }
}
