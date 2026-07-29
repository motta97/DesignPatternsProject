package BeneficiaryMVC;

import BeneficaryManagement.Beneficiary;

import java.util.List;
import java.util.Scanner;

public class BeneficiaryView {

    private final Scanner scanner;

    public BeneficiaryView(
            Scanner scanner) {

        this.scanner = scanner;
    }

    public void showMenu() {

        System.out.println("""
                
                ===== Beneficiary Management =====
                1. Register beneficiary
                2. Add support
                3. Change distribution strategy
                4. Distribute donation
                5. Show all beneficiaries
                6. Find beneficiary by ID
                0. Return to main menu
                """);
    }

    public String readString(
            String message) {

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

    public void showBeneficiary(Beneficiary beneficiary) {

        System.out.println("\nBeneficiary information:");

        System.out.println(beneficiary);
    }

    public void showBeneficiaries(List<Beneficiary> beneficiaries) {

        System.out.println("\n--- Beneficiaries ---");

        if (beneficiaries.isEmpty()) {

            System.out.println("No beneficiaries found.");

            return;
        }

        for (Beneficiary beneficiary : beneficiaries) {

            System.out.println(beneficiary);
        }
    }

    public void showSuccess(String message) {

        System.out.println("Success: " + message);
    }

    public void showError(String message) {

        System.out.println("Error: " + message);
    }
}