package DonationMVC;

import DonationManagement.Donation;
import DonationManagement.Donor;

import java.util.List;

public class DonationFacade {

    private  DonationModel model;

    public DonationFacade(DonationModel model) {

        this.model = model;
    }

    public Donor registerDonor(String name, int id, String donorType, String phone, String email) {

        return model.registerDonor(name, id, donorType, phone, email);
    }

    public Donation makeDonation(int donorId, String paymentMethod, String donationType, double value, String paymentDetails) {

        return model.makeDonation(donorId, paymentMethod, donationType, value, paymentDetails);
    }

    public Donor findDonor(int donorId) {

        return model.findDonorById(donorId);
    }

    public Donation findDonation(int donationId) {

        return model.findDonationById(donationId);
    }

    public List<Donor> getAllDonors() {

        return model.getAllDonors();
    }

    public List<Donation> getAllDonations() {

        return model.getAllDonations();
    }
}