package DonationManagement;

public class CheckMethod implements DonateMethod {
    private String CheckNumber ;

    public CheckMethod(String cn){
        this.CheckNumber = cn ;
    }

    public String getCheckNumber() {
        return CheckNumber;
    }

    @Override
    public void ProcessDonation() {
        System.out.println("[checking with the bank the check validaity] . . . . . . ");
        System.out.println("[check is ok]");
    }
}
