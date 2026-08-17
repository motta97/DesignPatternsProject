package BeneficiaryMVC;

import BeneficaryManagement.Beneficiary;
import BeneficaryRequestStatus.BeneficiaryRequest;

import java.util.List;
import java.util.Scanner;

public class BeneficiaryView {

    private  Scanner scanner;

    public BeneficiaryView(Scanner scanner) {

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
                7. Undo Register of Beneficiary
                8. Register Request
                9. Show all Requests
                10. Track a Request
                0. Return to main menu
                """);
    }


    public void TrackRequest(){

        System.out.println("""
                ===== Beneficiary Request =====
                1.Approve Request
                2.Reject Request
                3.Start Distrbution
                4.Complete Request
                5. Process new Request
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

    public void showRequests(List<BeneficiaryRequest> Requests){
        System.out.println("\n--- Beneficiary Requests ---");

        if (Requests.isEmpty()) {

            System.out.println("No Requests found.");

            return;
        }
        for (BeneficiaryRequest request : Requests) {

            System.out.println(request);
        }

    }

    public void showError(String message){
        System.out.println(message);
    }
    public void showSuccess(String message){
        System.out.println(message);
    }


}