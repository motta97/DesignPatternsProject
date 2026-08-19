package DonationManagement;

import utility.txtGetter;

public class CashMethod implements DonateMethod{
    @Override
    public void ProcessDonation() {

        System.out.println(txtGetter.getMessage("CashMethod_ProcessDonation","src/DonationManagement/DonationManagementMessages.txt"));
    }

    @Override
    public String getMethodType() {

        return txtGetter.getMessage("CashMethod_getMethodType","src/DonationManagement/DonationManagementMessages.txt");
    }
}
