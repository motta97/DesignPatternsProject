package DonationMVC;

import DonationManagement.Donation;
import DonationManagement.DonationFactory;
import DonationManagement.Donor;
import DonationManagement.DonorFactory;
import TextFile.DonationTextFileRepository;
import TextFile.DonorTextFileRepository;

import java.util.Collections;
import java.util.List;

public class DonationModel {

    private  DonorTextFileRepository donorRepository;
    private  DonationTextFileRepository donationRepository;

    private  List<Donor> donors;
    private  List<Donation> donations;




    public DonationModel(){
        donorRepository = new DonorTextFileRepository() ;
        donationRepository = new DonationTextFileRepository() ;

        donors = donorRepository.loadAll() ;
        donations = donationRepository.loadAll(donors) ;


    }

    public Donor registerDonor(String name,  String donorType, String phone, String email) {



        Donor donor = DonorFactory.createDonor(name,  donorType, phone, email);

        donors.add(donor);

        donorRepository.saveAll(donors);

        return donor;
    }

    public Donation makeDonation(int donorId, String paymentMethod, String donationType, double value, String paymentDetails) {

        if (value <= 0) {
            throw new IllegalArgumentException(
                    "Donation value must be greater than zero."
            );
        }

        Donor donor = findDonorById(donorId);

        Donation donation = DonationFactory.createDonation(donor, paymentMethod, donationType, value, paymentDetails);

        donations.add(donation);

        donationRepository.saveAll(donations);

        return donation;
    }

    public Donor findDonorById(int id) {

        Donor donor = findDonorOrNull(id);

        if (donor == null) {
            throw new IllegalArgumentException(
                    "Donor not found: " + id
            );
        }

        return donor;
    }

    public Donation findDonationById(int id) {

        for (Donation donation : donations) {
            if (donation.getId() == id) {
                return donation;
            }
        }

        throw new IllegalArgumentException(
                "Donation not found: " + id
        );
    }

    public List<Donor> getAllDonors() {

        return donors ;

    }

    public List<Donation> getAllDonations() {

        return donations ;

    }

    private Donor findDonorOrNull(int id) {

        for (Donor donor : donors) {

            if (donor.getId() == id) {
                return donor;
            }
        }

        return null;
    }
}