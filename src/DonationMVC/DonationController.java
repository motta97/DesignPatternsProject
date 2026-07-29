package DonationMVC;

import DonationManagement.Donation;
import DonationManagement.Donor;

import java.util.Scanner;

public class DonationController {

    private  DonationFacade facade;
    private  DonationView view;

    public DonationController(DonationFacade facade ,DonationView view) {

        this.facade = facade;
        this.view = view;
    }

    public void start() {

        boolean flag = true;

        while (flag) {

            view.showMenu();

            int choice =
                    view.readInt("Choose: ");

                switch (choice) {

                    case 1 ->
                            registerDonor();

                    case 2 ->
                            makeDonation();

                    case 3 ->
                            view.showDonors(facade.getAllDonors());

                    case 4 ->
                            view.showDonations(facade.getAllDonations());

                    case 5 ->
                            findDonor();

                    case 6 ->
                            findDonation();

                    case 0 ->
                            flag = false;

                    default ->
                            view.showError("Invalid choice.");
                }


        }
    }

    private void registerDonor() {

        String name = view.readString("Name: ");

        int id = view.readInt("Donor ID: ");

        String type = view.readString("Type (basic/premium/vip): ");

        String phone = view.readString("Phone: ");

        String email = view.readString("Email: ");

        Donor donor = facade.registerDonor(name, id, type, phone, email);

        view.showSuccess("Donor registered.");

        view.showDonor(donor);
    }

    private void makeDonation() {

        int donorId = view.readInt("Donor ID: ");

        String donationType = view.readString("Donation type (money/thing): ");

        double value = view.readDouble("Amount or quantity: ");

        String paymentMethod = view.readString("Method (cash/check/online): ");

        String paymentDetails = view.readString("Payment details: ");

        Donation donation = facade.makeDonation(donorId, paymentMethod, donationType, value, paymentDetails);

        view.showSuccess("Donation created.");

        view.showDonation(donation);
    }

    private void findDonor() {

        int id = view.readInt("Donor ID: ");

        Donor donor = facade.findDonor(id);

        view.showDonor(donor);
    }

    private void findDonation() {

        int id = view.readInt("Donation ID: ");

        Donation donation = facade.findDonation(id);

        view.showDonation(donation);
    }
}