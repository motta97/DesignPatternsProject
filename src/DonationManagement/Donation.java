package DonationManagement;

public class Donation {
    private static int  counter =0 ;
    private int id ;
    private Donor donor ;
    private DonateMethod method ;
    private DonationType type ;

    public Donation(Donor donor ,DonateMethod method , DonationType type){
        counter++ ;
        id= counter ;
        this.donor = donor ;
        this.method = method ;
        this.type = type ;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public void setMethod(DonateMethod method) {
        this.method = method;
    }

    public void setType(DonationType type) {
        this.type = type;
    }

    public double getAmount(){
        if(this.type instanceof MoneyDonation){
            return ((MoneyDonation) type).getAmount() ;
        }
        return 0.00 ;
    }

    public String gettype(){
        return type.getType() ;
    }

    public  int getId() {
        return id;
    }

    public Donor getDonor() {
        return donor;
    }

    public DonationType getDonationType() {
        return type;
    }

    public DonateMethod getMethod() {
        return method;
    }

    @Override
    public String toString() {

        String donationValue;

        if (type instanceof MoneyDonation moneyDonation) {
            donationValue =
                    "amount=" + moneyDonation.getAmount();

        } else if (type instanceof ThingDonation thingDonation) {
            donationValue =
                    "quantity=" + thingDonation.getQuantity();

        } else {
            donationValue = "unknown";
        }

        return "Donation{" +
                "id=" + getId() +
                ", donorId=" + donor.getId() +
                ", donorName='" + donor.getName() + '\'' +
                ", type='" + type.getType() + '\'' +
                ", " + donationValue +
                ", method='" +
                method.getClass().getSimpleName() + '\'' +
                '}';
    }
}
