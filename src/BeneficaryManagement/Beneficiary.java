package BeneficaryManagement;

import DonationManagement.Donation;

public class Beneficiary extends User {

    private Isupport supp_type ;
    private DistributionStrategy ref ;

    public Beneficiary(String name, int id, String phone, String email) {
        super(name, id, phone, email);
    }

    public void setSupp_type(Isupport supp_type) {
        this.supp_type = supp_type;
    }




    public void setRef(DistributionStrategy ref) {
        this.ref = ref;
    }

    public Isupport getSupp_type() {
        return supp_type;
    }

    public DistributionStrategy getRef() {
        return ref;
    }

    public void distributeDonation(Donation donation) {



        ref.distribute(this, donation);
    }

    @Override
    public String toString() {

        String supportDescription =
                supp_type == null
                        ? "No support"
                        : supp_type.getSupport();

        String strategyName =
                ref == null
                        ? "No strategy"
                        : ref.getClass().getSimpleName();

        return "Beneficiary{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", support='" + supportDescription + '\'' +
                ", distributionStrategy='" + strategyName + '\'' +
                '}';
    }


}
