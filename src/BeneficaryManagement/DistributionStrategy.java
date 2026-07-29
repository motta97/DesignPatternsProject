package BeneficaryManagement;

import DonationManagement.Donation;

public interface DistributionStrategy {
    public void distribute(Beneficiary ref , Donation donation) ;

}
