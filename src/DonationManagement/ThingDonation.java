package DonationManagement;

public class ThingDonation implements DonationType{

    private int Quantity ;

    public int getQuantity() {
        return Quantity;
    }

    public ThingDonation(int q){
        this.Quantity = q ;
    }

    @Override
    public String getType() {
        return "Thing with Quantity = "+Quantity;
    }
}

