package BeneficiaryMVC;

import BeneficaryManagement.Beneficiary;
import BeneficaryRequestStatus.BeneficiaryRequest;
import BeneficaryRequestStatus.RequestState;
import Commands.RegisterBeneficiaryUndoCommand;
import DonationMVC.DonationFacade;
import DonationMVC.DonationModel;
import DonationManagement.Donation;
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

        while (flag) {

            view.showMenu();

            int choice =
                    view.readInt("Choose: ");

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
                    case 0 ->
                            flag = false;

                    default -> view.showError("Invalid choice.");
                }

            } catch (RuntimeException exception) {

                view.showError(exception.getMessage());
            }
        }
    }

    public void registerBeneficiary() {

        String name = view.readString("Name: ");


        String phone = view.readString("Phone: ");

        String email = view.readString("Email: ");

        String strategy = view.readString("Strategy " + "(delivery/collection/transfer): ");

        Beneficiary beneficiary = beneficiaryFacade.registerBeneficiary(name, phone, email, strategy);

        view.showSuccess("Beneficiary registered.");

        view.showBeneficiary(beneficiary);
    }

    public void addSupport() {

        int beneficiaryId = view.readInt("Beneficiary ID: ");

        String supportType = view.readString("Support " + "(medical/housing/educational): ");

        Beneficiary beneficiary = beneficiaryFacade.addSupport(beneficiaryId, supportType);

        view.showSuccess("Support added.");

        view.showBeneficiary(beneficiary);
    }

    public void changeStrategy() {

        int beneficiaryId =
                view.readInt(
                        "Beneficiary ID: "
                );

        String strategyType =
                view.readString(
                        "New strategy "
                                + "(delivery/collection/transfer): "
                );

        Beneficiary beneficiary =
                beneficiaryFacade
                        .changeDistributionStrategy(
                                beneficiaryId,
                                strategyType
                        );

        view.showSuccess(
                "Distribution strategy changed."
        );

        view.showBeneficiary(
                beneficiary
        );
    }

    public void distributeDonation() {

        int beneficiaryId =
                view.readInt(
                        "Beneficiary ID: "
                );

        int donationId =
                view.readInt(
                        "Donation ID: "
                );

        String strategyType =
                view.readString(
                        "Strategy "
                                + "(delivery/collection/transfer): "
                );


        Donation donation =
                donationFacade.findDonation(
                        donationId
                );


        beneficiaryFacade
                .distributeDonation(
                        beneficiaryId,
                        donation,
                        strategyType
                );

        view.showSuccess(
                "Donation distributed."
        );
    }

    public void findBeneficiary() {

        int id =
                view.readInt(
                        "Beneficiary ID: "
                );

        Beneficiary beneficiary =
                beneficiaryFacade
                        .findBeneficiary(id);

        view.showBeneficiary(
                beneficiary
        );
    }

    public void undoRegisterBeneficary(){
        beneficiaryFacade.UndoRegisterBenefcairy();

    }

    public void registerRequest(){
        String request = view.readString("Request: ");
        int beneficiaryId = view.readInt("Beneficary Id : ");
      BeneficiaryRequest Request = beneficiaryFacade.registerRequest(request ,beneficiaryId) ;
        view.showSuccess("Request registered.");
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
                case 1 -> state.approve(request);
                case 2 -> state.reject(request);
                case 3 -> state.startDistribution(request);
                case 4 -> state.complete(request);
                case 5 -> state.processNew(request);
                case 0 -> flag =false ;
            }
        }
    }



}