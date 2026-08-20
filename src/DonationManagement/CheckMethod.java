package DonationManagement;

import utility.txtGetter;

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
        System.out.println(txtGetter.getMessage("CheckMethod_ProcessDonation_1","src/DonationManagement/DonationManagementMessages.txt"));
        System.out.println(txtGetter.getMessage("CheckMethod_ProcessDonation_2","src/DonationManagement/DonationManagementMessages.txt"));
    }

    @Override
    public String getMethodType() {
        return txtGetter.getMessage("CheckMethod_getMethodType","src/DonationManagement/DonationManagementMessages.txt");
    }

    @Override
    public String getPaymentDetails() {
        return CheckNumber;
    }
}
