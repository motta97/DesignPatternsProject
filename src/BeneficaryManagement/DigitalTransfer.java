package BeneficaryManagement;

import DonationManagement.Donation;

public class DigitalTransfer implements DistributionStrategy{
    @Override
    public void distribute(Beneficiary beneficiary, Donation donation) {

        System.out.println("Donation " + donation.getId() + " will be digitally transferred to " + beneficiary.getName());
    }
}
