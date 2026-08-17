package DonationManagement;

public class CashMethod implements DonateMethod{
    @Override
    public void ProcessDonation() {
        System.out.println("Cash Method");
    }

    @Override
    public String getMethodType() {
        return "CashMethod";
    }
}
