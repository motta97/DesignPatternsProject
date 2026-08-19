package DonationManagement;

import utility.txtGetter;

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
        System.out.println(txtGetter.getMessage("onlineMethod_ProcessDonation_1","src/DonationManagement/DonationManagementMessages.txt"));
        System.out.println(txtGetter.getMessage("onlineMethod_ProcessDonation_2","src/DonationManagement/DonationManagementMessages.txt"));
        System.out.println(txtGetter.getMessage("onlineMethod_ProcessDonation_3","src/DonationManagement/DonationManagementMessages.txt"));
    }

    @Override
    public String getMethodType() {
        return txtGetter.getMessage("onlineMethod_getMethodType","src/DonationManagement/DonationManagementMessages.txt");
    }
}
