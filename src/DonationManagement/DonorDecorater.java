package DonationManagement;

public class DonorDecorater extends Donor{
    protected Donor ref ;
    public DonorDecorater(String name ,  String phone , String email , Donor ref){
        super(name ,  phone , email) ;
            this.ref = ref ;
    }

    @Override
    public String getDescription() {
        return ref.getDescription();
    }

    @Override
    public String showBenefits() {
        return ref.showBenefits() ;
    }

    @Override
    public String getType() {
        return "DonorDecorater";
    }
}
