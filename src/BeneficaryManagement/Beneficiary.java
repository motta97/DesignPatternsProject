package BeneficaryManagement;

import DonationManagement.Donation;

import utility.User ;

public class Beneficiary extends User {

    private Isupport supp_type ;
    private DistributionStrategy ref ;

    public Beneficiary(String name,  String phone, String email) {
        super(name,  phone, email);
    }

    @Override
    public String getType() {
        return "BASIC_BENEFECIARY";
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

        String supportDescription = supp_type == null ? "No support" : supp_type.getSupport();

        String strategyName = ref == null ? "No strategy" : ref.getClass().getSimpleName();

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
