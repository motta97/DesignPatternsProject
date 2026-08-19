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
                7. Remove Last Beneficiary
                8. Register Request
                9. Show all Requests
                10. Track a Request
                11. Generate a Report
                12. Enter Admin Module
                13. Undo Removing Last Beneficiary
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
    public void ViewAdmin(){

        System.out.println("""
                ===== Admin Module =====
                1.Add new Message to Beneficiary Requests
                2.Add new Message to Beneficiary Management
                3.Update a Message
                4.Delete a Message
                0. Return Back
                """);
    }
    public void showBeneficaryMangementMessages(){

        System.out.println("""
                ===== Beneficiary Messages =====
                1.BasicSupport class , method=> getDescription
                2.BasicSupport class , method=> getSupport
                3.Educationalsupport class, method =>getDescription
                4.Educationalsupport class, method=>getSupport
                5.ExternalDelivery class , method=> sendPackage
                6.ExternalDelivery class , method=> CalcShipping
                7.ExternalDelivery class , method=> GetTrackingStatus
                8.Housingsupport class , method=>getDescription
                9.Housingsupport class , method=> getSupport
                10.Medicalsupport class , method=> getDescription
                11.Medicalsupport class , method=> getSupport
                0. Return Back
                """);
    }

    public void showBeneficaryRequestsMessages(){

        System.out.println("""
                ===== Beneficiary Messages =====
                1.ErrorMessage
                2.approve command to a Pending state
                3.reject command to a Pending state
                4.processNew command to a new state
                5.Complete command to a InProgress state
                6.startDistribution Command to Approved state
                0. Return Back
                """);
    }

    public String readString(String message) {

        System.out.print(message);

        return scanner.nextLine().trim();
    }

    public int readInt(String message) {

           return Integer.parseInt(readString(message));


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




}