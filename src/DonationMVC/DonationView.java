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
                7. Remove Last Donation
                8. Remove Last Donor
                9. Generate a Report
                10. Admin Module
                11. Undo Removing Last Donation
                12. Undo Removing Last Donor
                0. Return to main menu
                """);
    }

    public void ViewAdmin(){
        System.out.println("""
                ===== Admin Module =====
                1.Add Message to Donation Management messages
                2.Update a Message
                3.Delete a Message
                0.return back
                """);

    }

    public void showDonationMangementMessages(){

        System.out.println("""
                ===== Donation Messages =====
                1.BasicDonor class , method=> getDescription
                2.BasicDonor class , method=> showBenefits
                3.CashMethod class, method =>ProcessDonation
                4.CashMethod class, method=>getMethodType
                5.CheckMethod class , method=> ProcessDonation_1
                6.CheckMethod class , method=> ProcessDonation_2
                7.CheckMethod class , method=> getMethodType
                8.MoneyDonation class , method=>getType
                9.onlineMethod class , method=> ProcessDonation_1
                10.onlineMethod class , method=> ProcessDonation_2
                12.onlineMethod class , method=> ProcessDonation_3
                13.onlineMethod class , method=> getMethodType
                14.PremiumDonor class , method=> getDescription
                15.PremiumDonor class , method=> showBenefits
                16.thingmethod class , method=> getMethodType
                17.VIPDonor class , method=> getDescription
                18.VIPDonor class , method=> showBenefits
                0. Return Back
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