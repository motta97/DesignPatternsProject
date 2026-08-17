package DonationMVC;

import DonationManagement.Donation;
import DonationManagement.DonationFactory;
import DonationManagement.Donor;
import DonationManagement.DonorFactory;
import TextFile.DonaitonRepository;
import TextFile.DonorRepository;

import java.util.List;

public class DonationModel {

//    private  DonorTextFileRepository donorRepository;
//    private  DonationTextFileRepository donationRepository;
    private DonorRepository donorRepository ;
    private DonaitonRepository donationRepository;
    private  List<Donor> donors;
    private  List<Donation> donations;




    public DonationModel(){
        donorRepository = new DonorRepository() ;
        donationRepository = new DonaitonRepository() ;

        donors = donorRepository.getAll() ;
        donations = donationRepository.getAll() ;


    }

    public Donor registerDonor(String name,  String donorType, String phone, String email) {



        Donor donor = DonorFactory.createDonor(name,  donorType, phone, email);

        donors.add(donor);

        donorRepository.saveAll(donors);

        return donor;
    }

    public Donation makeDonation(int donorId, String paymentMethod, String donationType, double value, String paymentDetails) {

        if (value <= 0) {
            System.out.println("The value must be greater than 0");
            return null ;
        }

        Donor donor = findDonorById(donorId);

        Donation donation = DonationFactory.createDonation(donor, paymentMethod, donationType, value, paymentDetails);

        donations.add(donation);

        donationRepository.saveAll(donations);

        return donation;
    }

    public Donation findDonationById(int id) {

        for (Donation donation : donations) {
            if (donation.getId() == id) {
                return donation;
            }
        }

      return null ;
    }

    public List<Donor> getAllDonors() {

        return donors ;

    }

    public List<Donation> getAllDonations() {

        return donations ;

    }

    public Donor findDonorById(int id) {

        for (Donor donor : donors) {

            if (donor.getId() == id) {
                return donor;
            }
        }

        return null;
    }

    public Donation GetLastDonation(){

        return donations.getLast() ;
    }

    public void RemoveDonationById(int id){
        Donation ref = donations.get(id) ;
        if(ref != null){
            donations.remove(ref) ;
            donationRepository.saveAll(donations) ;
        }else {
            System.out.println("Donation not found");
        }


    }

    public Donor GetLastDonor(){

        return donors.getLast() ;
    }

    public void RemoveDonorbyId(int id){
       Donor ref = donors.get(--id) ;
       if(ref != null){

           donors.remove(ref) ;
           donorRepository.saveAll(donors);


       }else {
           System.out.println("Donor is not found");
       }
    }


}