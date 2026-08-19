package DonationManagement;

import utility.txtGetter;

public class VIPDonor extends DonorDecorater{



    public VIPDonor(Donor ref) {

        super(ref.getName() ,  ref.getPhone() , ref.getEmail() , ref);

    }

    @Override
    public String getDescription() {
        return super.getDescription()+ txtGetter.getMessage("VIPDonor_getDescription","src/DonationManagement/DonationManagementMessages.txt");
    }

    @Override
    public String showBenefits() {
        return super.showBenefits()+txtGetter.getMessage("VIPDonor_showBenefits","src/DonationManagement/DonationManagementMessages.txt");
    }
}
