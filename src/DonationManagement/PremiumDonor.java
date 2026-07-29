package DonationManagement;

public class PremiumDonor extends DonorDecorater{



    public PremiumDonor (Donor ref){
        super(ref.getName() , ref.getId() , ref.getPhone() , ref.getEmail() , ref);

    }

    @Override
    public String getDescription() {
        return super.getDescription()+" some descirption for premimum ";
    }

    @Override
    public String showBenefits() {
        return super.showBenefits()+" some benfits for premium";
    }
}
