package DonationManagement;

public class Reciept {
    private Donation ref ;
    public Reciept(Donation ref){
        this.ref = ref ;
    }
    public double calcTax(){

        return ref.getAmount()*0.14;
    }

    public double calcTotal(){

        return ref.getAmount()*1.14 ;
    }

}
