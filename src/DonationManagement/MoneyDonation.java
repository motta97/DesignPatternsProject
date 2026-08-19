package DonationManagement;

import utility.txtGetter;

public class MoneyDonation implements DonationType{
    private double amount ;

    public MoneyDonation(double amount){
        this.amount = amount ;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String getType() {
        return txtGetter.getMessage("MoneyDonation_getType","src/DonationManagement/DonationManagementMessages.txt");
    }
}
