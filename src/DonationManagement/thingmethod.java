package DonationManagement;

import utility.txtGetter;

public class thingmethod implements DonateMethod{
    @Override
    public void ProcessDonation() {

    }

    @Override
    public String getMethodType() {
        return txtGetter.getMessage("thingmethod_getMethodType","src/DonationManagement/DonationManagementMessages.txt");
    }
}
