package BeneficaryManagement;

import DonationManagement.Donation;

public class Collection implements DistributionStrategy{
    @Override
    public void distribute(Beneficiary beneficiary, Donation donation) {

        System.out.println(beneficiary.getName() + " can collect donation " + donation.getId() + " from one of our locations.");
    }
}
