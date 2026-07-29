package DonationManagement;

public class VIPDonor extends DonorDecorater{



    public VIPDonor(Donor ref) {

        super(ref.getName() , ref.getId() , ref.getPhone() , ref.getEmail() , ref);

    }

    @Override
    public String getDescription() {
        return super.getDescription()+" and some description for VIP";
    }

    @Override
    public String showBenefits() {
        return super.showBenefits()+" and some benefits for VIP";
    }
}
