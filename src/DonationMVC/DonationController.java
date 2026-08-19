package DonationMVC;

import DonationManagement.Donation;
import DonationManagement.Donor;
import utility.*;

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
                    case 7 ->
                            RemoveLastDonation() ;
                    case 8 ->
                            RemoveLastDonor() ;
                    case 9->
                            facade.GenerateReport() ;
                    case 10 ->
                            adminModule() ;
                    case 11 ->
                            facade.UndoRemoveLastDonation();
                    case 12 ->
                            facade.UndoRemoveLastDonor();
                    case 0 ->
                            flag = false;

                    default ->
                            view.showError("Invalid choice.");
                }


        }
    }

    public void registerDonor() {

        String name = view.readString("Name: ");



        String type = view.readString("Type (basic/premium/vip): ");

        String phone = view.readString("Phone: ");

        String email = view.readString("Email: ");

        Donor donor = facade.registerDonor(name,  type, phone, email);

        view.showSuccess("Donor registered.");

        view.showDonor(donor);
    }

    public void makeDonation() {

        int donorId = view.readInt("Donor ID: ");

        String donationType = view.readString("Donation type (money/thing): ");

        if(donationType.equals("thing")){
            double value = view.readDouble("Amount or quantity: ");
            Donation donation = facade.makeDonation(donorId, "thing", donationType, value, "");
            view.showSuccess("Donation created.");

            view.showDonation(donation);
            return ;

        }
        double value = view.readDouble("Amount or quantity: ");



        String paymentMethod = view.readString("Method (cash/check/online): ");

        if(paymentMethod.equals("cash")){
            Donation donation = facade.makeDonation(donorId, paymentMethod, donationType, value, "");

            view.showSuccess("Donation created.");

            view.showDonation(donation);
            return ;
        }

        String paymentDetails = view.readString("Payment details: ");

        Donation donation = facade.makeDonation(donorId, paymentMethod, donationType, value, paymentDetails);

        view.showSuccess("Donation created.");

        view.showDonation(donation);
    }

    public void findDonor() {

        int id = view.readInt("Donor ID: ");

        Donor donor = facade.findDonor(id);

        view.showDonor(donor);
    }

    public void findDonation() {

        int id = view.readInt("Donation ID: ");

        Donation donation = facade.findDonation(id);

        view.showDonation(donation);
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
                case 1 ->{DonationMangmentMessagesAdd(txtSetter) ;}
                case 2 ->{DonationMangmentMessagesUpdate(txtSetter);}
                case 3 -> {DonationMangmentMessagesDelete(txtSetter);}
                case 0 -> flag =false ;
            }
        }
    }

    public void RemoveLastDonation(){
        facade.RemoveLastDonation();
    }

    public void RemoveLastDonor(){
        facade.RemoveLastDonor();
    }

public void DonationMangmentMessagesAdd(ItxtSetter txtSetter){

    String filePath = "src/DonationManagement/DonationManagementMessages.txt" ;
    String Message = view.readString("Enter the new Message: ");
    txtSetter.SetMessage(filePath,Message);}

public void DonationMangmentMessagesDelete(ItxtSetter txtSetter){


    boolean flag = true ;
    String filePath = "src/DonationManagement/DonationManagementMessages.txt" ;
    int choice ;
    while(flag) {
        view.showDonationMangementMessages();
        choice = view.readInt("choice : ");
        switch (choice) {
            case 1 -> {

                txtSetter.RemoveMessage(filePath,"BasicDonor_getDescription");}
            case 2 -> {

                txtSetter.RemoveMessage(filePath,"BasicDonor_showBenefits");}
            case 3 -> {

                txtSetter.RemoveMessage(filePath,"CashMethod_ProcessDonation");}
            case 4 -> {

                txtSetter.RemoveMessage(filePath,"CashMethod_getMethodType");}
            case 5 -> {

                txtSetter.RemoveMessage(filePath,"CheckMethod_ProcessDonation_1");}
            case 6 -> {

                txtSetter.RemoveMessage(filePath,"CheckMethod_ProcessDonation_2");}
            case 7 -> {

                txtSetter.RemoveMessage(filePath,"CheckMethod_getMethodType");}
            case 8 -> {

                txtSetter.RemoveMessage(filePath,"MoneyDonation_getType");}
            case 9 -> {

                txtSetter.RemoveMessage(filePath,"onlineMethod_ProcessDonation_1");}
            case 10 -> {

                txtSetter.RemoveMessage(filePath,"onlineMethod_ProcessDonation_2");}
            case 11 -> {

                txtSetter.RemoveMessage(filePath,"onlineMethod_ProcessDonation_3");}
            case 12 -> {

                txtSetter.RemoveMessage(filePath,"onlineMethod_getMethodType");}
            case 13 -> {

                txtSetter.RemoveMessage(filePath,"PremiumDonor_getDescription");}
            case 14 -> {

                txtSetter.RemoveMessage(filePath,"PremiumDonor_showBenefits");}
            case 15 -> {

                txtSetter.RemoveMessage(filePath,"thingmethod_getMethodType");}
            case 16 -> {

                txtSetter.RemoveMessage(filePath,"VIPDonor_getDescription");}
            case 17 -> {

                txtSetter.RemoveMessage(filePath,"VIPDonor_showBenefits");}

            case 0 -> flag = false;
        }






}
    }
public void DonationMangmentMessagesUpdate(ItxtSetter txtSetter){


    boolean flag = true ;
    String filePath = "src/DonationManagement/DonationManagementMessages.txt" ;
    int choice ;
    while(flag) {
        view.showDonationMangementMessages();
        choice = view.readInt("choice : ");
        switch (choice) {
            case 1 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"BasicDonor_getDescription",Message);}
            case 2 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"BasicDonor_showBenefits",Message);}
            case 3 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"CashMethod_ProcessDonation",Message);}
            case 4 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"CashMethod_getMethodType",Message);}
            case 5 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"CheckMethod_ProcessDonation_1",Message);}
            case 6 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"CheckMethod_ProcessDonation_2",Message);}
            case 7 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"CheckMethod_getMethodType",Message);}
            case 8 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"MoneyDonation_getType",Message);}
            case 9 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"onlineMethod_ProcessDonation_1",Message);}
            case 10 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"onlineMethod_ProcessDonation_2",Message);}
            case 11 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"onlineMethod_ProcessDonation_3",Message);}
            case 12 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"onlineMethod_getMethodType",Message);}
            case 13 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"PremiumDonor_getDescription",Message);}
            case 14 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"PremiumDonor_showBenefits",Message);}
            case 15 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"thingmethod_getMethodType",Message);}
            case 16 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"VIPDonor_getDescription",Message);}
            case 17 -> {
                String Message = view.readString("Enter the new Message: ");
                txtSetter.Update(filePath,"VIPDonor_showBenefits",Message);}

            case 0 -> flag = false;
        }
    }










}

}