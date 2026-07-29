package BeneficaryManagement;

import DonationManagement.Donation;

public class HomeDelivery implements DistributionStrategy{
    @Override
    public void distribute(Beneficiary beneficiary, Donation donation) {

        System.out.println("Donation " + donation.getId() + " will be delivered to " + beneficiary.getName());
    }
}
