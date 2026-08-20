package DonationManagement;

import utility.txtGetter;

public class PremiumDonor extends DonorDecorater{



    public PremiumDonor (Donor ref){
        super(ref.getName() , ref.getPhone() , ref.getEmail() , ref);

    }

    @Override
    public String getDescription() {
        return super.getDescription()+ txtGetter.getMessage("PremiumDonor_getDescription","src/DonationManagement/DonationManagementMessages.txt");
    }

    @Override
    public String showBenefits() {
        return super.showBenefits()+txtGetter.getMessage("PremiumDonor_showBenefits","src/DonationManagement/DonationManagementMessages.txt");
    }
    @Override
    public String getType(){
        return "PREMIUM_DONOR" ;
    }
}
