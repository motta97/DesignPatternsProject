package Main;

import BeneficiaryMVC.BeneficiaryController;
import BeneficiaryMVC.BeneficiaryFacade;
import BeneficiaryMVC.BeneficiaryModel;
import BeneficiaryMVC.BeneficiaryView;
import CommunicationMVC.CommunicationController;
import DonationMVC.DonationController;
import DonationMVC.DonationFacade;
import DonationMVC.DonationModel;
import DonationMVC.DonationView;
import EventMVC.EventContoller;
import utility.UserController;

import java.util.Scanner;

public class MainController {
    private DonationController donationController ;
    private BeneficiaryController beneficiaryController ;
    private MainView mainView ;
    private UserController userController ;
    private CommunicationController communicationController ;
    private EventContoller eventController;
    public MainController(){

         mainView = new MainView() ;
        BeneficiaryModel beneficiaryModel = new BeneficiaryModel();
        BeneficiaryFacade beneficiaryFacade = new BeneficiaryFacade(beneficiaryModel);
        DonationModel donationModel = new DonationModel();
        DonationFacade donationFacade = new DonationFacade(donationModel);
        Scanner sc = new Scanner(System.in);
        DonationView donationView = new DonationView(sc);
        BeneficiaryView beneficiaryView = new BeneficiaryView(sc);
        beneficiaryController = new BeneficiaryController(beneficiaryFacade, donationFacade, beneficiaryView);
        donationController = new DonationController(donationFacade, donationView);
        userController = new UserController();
        eventController = new EventContoller();
    }

    public void start(){
        //halt until the user log in
        int userID = -1;
        while(userID==-1){
            userID = userController.mainMenu();
        }
        boolean flag = true;
        while (flag) {


            mainView.showMainMenu();
            int choice = mainView.getInt("Please enter your choice");
            switch (choice) {

                case 1 -> {
                    donationController.start();
                }
                case 2 -> {
                    beneficiaryController.start();
                }
                case 3 -> {
                    eventController.start();
                }
                case 4 -> {
                    communicationController = new CommunicationController(userID);
                    communicationController.start();
                }
                case 0 -> {
                    flag = false;
                }
                default -> {
                    System.out.println("Enter valid choice");
                }
            }


        }
    }

}
