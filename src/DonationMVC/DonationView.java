package DonationMVC;

import DonationManagement.Donation;
import DonationManagement.Donor;

import java.util.List;
import java.util.Scanner;

public class DonationView {

    private  Scanner scanner;

    public DonationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void showMenu() {

        System.out.println("""
                
                ===== Donation Management =====
                1. Register donor
                2. Make donation
                3. Show all donors
                4. Show all donations
                5. Find donor by ID
                6. Find donation by ID
                0. Return to main menu
                """);
    }

    public String readString(String message) {

        System.out.print(message);

        return scanner.nextLine().trim();
    }

    public int readInt(String message) {

        while (true) {

            try {
                return Integer.parseInt(
                        readString(message)
                );

            } catch (NumberFormatException exception) {

                showError(
                        "Please enter a valid integer."
                );
            }
        }
    }

    public double readDouble(String message) {

        while (true) {

            try {
                return Double.parseDouble(
                        readString(message)
                );

            } catch (NumberFormatException exception) {

                showError(
                        "Please enter a valid value."
                );
            }
        }
    }

    public void showDonor(Donor donor) {

        System.out.println(
                "\nDonor information:"
        );

        System.out.println(donor);
    }

    public void showDonation(
            Donation donation) {

        System.out.println(
                "\nDonation information:"
        );

        System.out.println(donation);
    }

    public void showDonors(List<Donor> donors) {

        System.out.println("\n--- Donors ---");

        if (donors.isEmpty()) {
            System.out.println("No donors found.");
            return;
        }

        for (Donor donor : donors) {

            System.out.println("ID: " + donor.getId());
            System.out.println("Name: " + donor.getName());
            System.out.println("Phone: " + donor.getPhone());
            System.out.println("Email: " + donor.getEmail());
            System.out.println("Description: " + donor.getDescription());
            System.out.println("Benefits: " + donor.showBenefits());
            System.out.println("----------------------------");
        }
    }

    public void showDonations(
            List<Donation> donations) {

        System.out.println(
                "\n--- Donations ---"
        );

        if (donations.isEmpty()) {
            System.out.println(
                    "No donations found."
            );

            return;
        }

        for (Donation donation : donations) {
            System.out.println(donation);
        }
    }

    public void showSuccess(String message) {

        System.out.println(
                "Success: " + message
        );
    }

    public void showError(String message) {

        System.out.println(
                "Error: " + message
        );
    }
}