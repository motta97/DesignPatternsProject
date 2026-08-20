package BeneficiaryMVC;

import BeneficaryManagement.Beneficiary;
import BeneficaryRequestStatus.BeneficiaryRequest;
import BeneficaryRequestStatus.RequestState;
import DonationMVC.DonationFacade;
import DonationManagement.Donation;
import utility.*;

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
                            RemoveLastBeneficiary() ;
                    case 8 ->
                            registerRequest() ;
                    case 9 ->
                            view.showRequests(beneficiaryFacade.getAllRequests()) ;
                    case 10 ->
                            trackRequest() ;
                    case 11->
                        beneficiaryFacade.GenerateReport();
                    case 12 ->
                            adminModule() ;
                    case 13 ->
                            beneficiaryFacade.UndoRemoveLastBeneficary();

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

    public void RemoveLastBeneficiary(){
        beneficiaryFacade.RemoveLastBeneficary();

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
    public void adminModule(){
        boolean flag = true ;
        int choice ;
        User user ;
        String userName =view.readString("Enter you user Name : ");
        String passKey =view.readString("Enter you Password: ") ;
        if(userName.equals("admin")&& passKey.equals("admin")){
            user = new Admin("admin","00","admin@gmail.com") ;
        }else {
            user = new normalUser("Normal","11","Normal@gmail.com") ;
        }
        ItxtSetter txtSetter = new ProxyTextSetter(user) ;
        while(flag){
            view.ViewAdmin() ;
            choice = view.readInt("choice : ");
            switch (choice){
                case 1 ->{showBeneficaryRequestMessageadd(txtSetter) ;}
                case 2 ->{showBeneficaryManagemtnMessageadd(txtSetter) ;}
                case 3 ->{UpdateModuleMessage(txtSetter);}
                case 4 -> {deleteModuleMessage(txtSetter);}
                case 0 -> flag =false ;
            }
        }
    }
    public void UpdateModuleMessage(ItxtSetter txtSetter){

        boolean flag = true ;
        int choice ;
        while(flag){
            System.out.println("Enter 1 for Update Beneficiary Requests Messages");
            System.out.println("Enter 2 for Update Beneficiary Management Module Messages");
            System.out.println("Enter 0 to get back");
            choice = view.readInt("choice : ");
            switch(choice){
                case 1 ->showBeneficaryRequestMessageupdate( txtSetter) ;
                case 2->showBeneficaryManagemtnMessageupdate( txtSetter);
                case 0-> flag =false;
            }

        }

    }

    public void showBeneficaryRequestMessageupdate(ItxtSetter txtSetter){
        boolean flag = true ;
        String filePath = "src/BeneficaryRequestStatus/RequestStatusMessages.txt" ;
        int choice ;
        while(flag) {
            view.showBeneficaryRequestsMessages();
            choice = view.readInt("choice : ");
            switch (choice) {
                case 1 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"ErrorMessage",Message);}
                case 2 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"approvePending",Message);}
                case 3 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"rejectPending",Message);}
                case 4 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"processNew",Message);}
                case 5 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"inProgressComplete",Message);}
                case 6 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"startDistributionApproved",Message);}

            case 0 -> flag = false;
        }
            }
        }

    public void showBeneficaryManagemtnMessageupdate(ItxtSetter txtSetter){
        boolean flag = true ;
        String filePath = "src/BeneficaryManagement/BeneficaryMangementMessages.txt" ;
        int choice ;
        while(flag) {
            view.showBeneficaryMangementMessages();
            choice = view.readInt("choice : ");
            switch (choice) {
                case 1 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"BasicSupport_getDescription",Message);}
                case 2 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"BasicSupport_getSupport",Message);}
                case 3 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"Educational_support_getDescription",Message);}
                case 4 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"Educational_support_getSupport",Message);}
                case 5 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"ExternalDelivery_sendPackage",Message);}
                case 6 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"ExternalDelivery_CalcShipping",Message);}
                case 7 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"ExternalDelivery_GetTrackingStatus",Message);}
                case 8 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"Housing_support_getDescription",Message);}
                case 9 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"Housing_support_getSupport",Message);}
                case 10 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"Medical_support_getDescription",Message);}
                case 11 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.Update(filePath,"Medical_support_getSupport",Message);}

                case 0 -> flag = false;
            }
        }



    }

    public void deleteModuleMessage(ItxtSetter txtSetter){

        boolean flag = true ;
        int choice ;
        while(flag){
            System.out.println("Enter 1 for Delete Beneficiary Requests Messages");
            System.out.println("Enter 2 for Delete Beneficiary Management Module Messages");
            System.out.println("Enter 0 to get back");
            choice = view.readInt("choice : ");
            switch(choice){
                case 1 ->showBeneficaryRequestMessagedelete( txtSetter) ;
                case 2->showBeneficaryManagemtnMessagedelete( txtSetter);
                case 0-> flag =false;
            }

        }

    }

    public void showBeneficaryRequestMessagedelete(ItxtSetter txtSetter){
        boolean flag = true ;
        String filePath = "src/BeneficaryRequestStatus/RequestStatusMessages.txt" ;
        int choice ;
        while(flag) {
            view.showBeneficaryRequestsMessages();
            choice = view.readInt("choice : ");
            switch (choice) {
                case 1 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"ErrorMessage");}
                case 2 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"approvePending");}
                case 3 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"rejectPending");}
                case 4 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"processNew");}
                case 5 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"inProgressComplete");}
                case 6 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"startDistributionApproved");}

                case 0 -> flag = false;
            }
        }
    }

    public void showBeneficaryManagemtnMessagedelete(ItxtSetter txtSetter){
        boolean flag = true ;
        String filePath = "src/BeneficaryManagement/BeneficaryMangementMessages.txt" ;
        int choice ;
        while(flag) {
            view.showBeneficaryMangementMessages();
            choice = view.readInt("choice : ");
            switch (choice) {
                case 1 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"BasicSupport_getDescription");}
                case 2 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"BasicSupport_getSupport");}
                case 3 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"Educational_support_getDescription");}
                case 4 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"Educational_support_getSupport");}
                case 5 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"ExternalDelivery_sendPackage");}
                case 6 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"ExternalDelivery_CalcShipping");}
                case 7 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"ExternalDelivery_GetTrackingStatus");}
                case 8 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"Housing_support_getDescription");}
                case 9 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"Housing_support_getSupport");}
                case 10 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"Medical_support_getDescription");}
                case 11 -> {
                    String Message = view.readString("Enter the new Message: ");
                    txtSetter.RemoveMessage(filePath,"Medical_support_getSupport");}

                case 0 -> flag = false;
            }
        }



    }
    public void showBeneficaryRequestMessageadd(ItxtSetter txtSetter){

        String filePath = "src/BeneficaryRequestStatus/RequestStatusMessages.txt" ;
        String Message = view.readString("Enter the new Message: ");
        txtSetter.SetMessage(filePath,Message);}

    public void showBeneficaryManagemtnMessageadd(ItxtSetter txtSetter){

        String filePath = "src/BeneficaryManagement/BeneficaryMangementMessages.txt" ;

        String Message = view.readString("Enter the new Message: ");
        txtSetter.SetMessage(filePath,Message);}

    }












