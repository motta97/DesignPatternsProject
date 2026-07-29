package DonationManagement;

public class onlineMethod implements DonateMethod {
    private String CreditCardNumber ;
    public onlineMethod(String ccn){
        this.CreditCardNumber = ccn ;
    }

    public String getCreditCardNumber() {
        return CreditCardNumber;
    }

    @Override
    public void ProcessDonation() {
        System.out.println("[Checking Credi card number] . . . . . ");
        System.out.println("[Process Transactions ] . . . . . . . ");
        System.out.println("[payment success]");
    }
}
