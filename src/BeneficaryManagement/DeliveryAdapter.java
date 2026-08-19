package BeneficaryManagement;

import DonationManagement.Donation;

public class DeliveryAdapter implements DistributionStrategy{
    ExternalDeliveryInterface external;
    public DeliveryAdapter(ExternalDeliveryInterface external){
        this.external = external ;
    }


    @Override
    public void distribute(Beneficiary ref, Donation donation) {
        this.external.CalcShipping();
        this.external.sendPackage();
        this.external.GetTrackingStatus();
        System.out.println("Donation " + donation.getId() + " will be delivered to " + ref.getName()+ " Using an external Delivery Company");

    }
}
