package BeneficiaryMVC;

import BeneficaryManagement.Beneficiary;
import BeneficaryRequestStatus.BeneficiaryRequest;
import BeneficaryRequestStatus.RequestState;
import Commands.RegisterBeneficiaryUndoCommand;
import DonationMVC.DonationFacade;
import DonationMVC.DonationModel;
import DonationManagement.Donation;
import Report.BeneficaryReport;
import Report.Report;
import utility.Command;

import java.util.Scanner;

public class BeneficiaryController {

    private  BeneficiaryFacade
            beneficiaryFacade;

    private  DonationFacade
            donationFacade;

    private  BeneficiaryView view;



    public BeneficiaryController(BeneficiaryFacade beneficiaryFacade ,DonationFacade donationFacade ,BeneficiaryView view) {

        this.beneficiaryFacade = beneficiaryFacade;

        this.donationFacade = donationFacade;

        this.view = view;
    }

    public void start() {

        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while (flag) {

            view.showMenu();

            System.out.println("Choose : ");
            int choice =sc.nextInt() ;


            try {

                switch (choice) {

                    case 1 ->
                            registerBeneficiary();

                    case 2 ->
                            addSupport();

                    case 3 ->
                            changeStrategy();

                    case 4 ->
                            distributeDonation();

                    case 5 -> view.showBeneficiaries(beneficiaryFacade.getAllBeneficiaries());

                    case 6 ->
                            findBeneficiary();
                    case 7 ->
                            undoRegisterBeneficary() ;
                    case 8 ->
                            registerRequest() ;
                    case 9 ->
                            view.showRequests(beneficiaryFacade.getAllRequests()) ;
                    case 10 ->
                            trackRequest() ;
                    case 11->
                        beneficiaryFacade.GenerateReport();
                    case 0 ->
                            flag = false;

                    default -> System.out.println("Invalid choice.");

                }

            } catch (RuntimeException exception) {

                System.out.println(exception.getMessage());
            }
        }
    }

    public void registerBeneficiary() {

        String name = view.readString("Name: ");


        String phone = view.readString("Phone: ");

        String email = view.readString("Email: ");

        String strategy = view.readString("Strategy " + "(delivery/collection/transfer/external): ");

        Beneficiary beneficiary = beneficiaryFacade.registerBeneficiary(name, phone, email, strategy);

        System.out.println(("Beneficiary registered."));

        view.showBeneficiary(beneficiary);
    }

    public void addSupport() {

        int beneficiaryId = view.readInt("Beneficiary ID: ");

        String supportType = view.readString("Support " + "(medical/housing/educational): ");

        Beneficiary beneficiary = beneficiaryFacade.addSupport(beneficiaryId, supportType);

        System.out.println(("Support added."));

        view.showBeneficiary(beneficiary);
    }

    public void changeStrategy() {

        int beneficiaryId = view.readInt("Beneficiary ID: ");

        String strategyType = view.readString("New strategy " + "(delivery/collection/transfer/external): ");

        Beneficiary beneficiary = beneficiaryFacade.changeDistributionStrategy(beneficiaryId, strategyType);

        System.out.println("Distribution strategy changed.");

        view.showBeneficiary(beneficiary);
    }

    public void distributeDonation() {

        int beneficiaryId = view.readInt("Beneficiary ID: ");

        int donationId = view.readInt("Donation ID: ");

        String strategyType = view.readString("Strategy " + "(delivery/collection/transfer/external): ");


        Donation donation = donationFacade.findDonation(donationId);


        beneficiaryFacade.distributeDonation(beneficiaryId, donation, strategyType);

        System.out.println("Donation distributed.");
    }

    public void findBeneficiary() {

        int id = view.readInt("Beneficiary ID: ");

        Beneficiary beneficiary = beneficiaryFacade.findBeneficiary(id);

        view.showBeneficiary(beneficiary);
    }

    public void undoRegisterBeneficary(){
        beneficiaryFacade.UndoRegisterBenefcairy();

    }

    public void registerRequest(){
        String request = view.readString("Request: ");
        int beneficiaryId = view.readInt("Beneficary Id : ");
      BeneficiaryRequest Request = beneficiaryFacade.registerRequest(request ,beneficiaryId) ;
        System.out.println("Request registered.");
        System.out.println(Request);
    }

    public void trackRequest(){
        int requestId =view.readInt("Enter Request Id : ") ;
        BeneficiaryRequest request =beneficiaryFacade.findRquest(requestId) ;
        if(request == null){
            return ;
        }

        boolean flag = true ;
        while(flag){
            view.TrackRequest();
            RequestState state = request.GetState() ;

            int choice =view.readInt("Enter your choice : ") ;
            switch(choice){
                case 1 -> {
                    state.approve(request);
                    beneficiaryFacade.savechangesTorequestReposiotry();
                }
                case 2 -> {
                    state.reject(request);
                    beneficiaryFacade.savechangesTorequestReposiotry();
                }
                case 3 -> {
                    state.startDistribution(request);
                    beneficiaryFacade.savechangesTorequestReposiotry();
                }
                case 4 -> {
                    state.complete(request);
                    beneficiaryFacade.savechangesTorequestReposiotry();
                }
                case 5 -> {
                    state.processNew(request);
                    beneficiaryFacade.savechangesTorequestReposiotry();
                }
                case 0 -> flag =false ;
            }
        }
    }


}