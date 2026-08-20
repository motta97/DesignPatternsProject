package Main;

import BeneficiaryMVC.BeneficiaryController;
import BeneficiaryMVC.BeneficiaryFacade;
import BeneficiaryMVC.BeneficiaryModel;
import BeneficiaryMVC.BeneficiaryView;
<<<<<<< Updated upstream
=======
import CommunicationMVC.CommunicationController;
>>>>>>> Stashed changes
import DonationMVC.DonationController;
import DonationMVC.DonationFacade;
import DonationMVC.DonationModel;
import DonationMVC.DonationView;
<<<<<<< Updated upstream
=======
import EventMVC.EventContoller;
import utility.UserController;
>>>>>>> Stashed changes

import java.util.Scanner;

public class MainController {
    private DonationController donationController ;
    private BeneficiaryController beneficiaryController ;
    private MainView mainView ;
<<<<<<< Updated upstream
=======
    private UserController userController ;
    private CommunicationController communicationController ;
    private EventContoller eventController;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    }

    public void start(){
        Scanner sc = new Scanner(System.in) ;
        int choice;
        boolean flag = true;
        while (flag) {
            mainView.showMenu() ;
            choice = sc.nextInt();
=======
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
>>>>>>> Stashed changes
            switch (choice) {

                case 1 -> {
                    donationController.start();
                }
                case 2 -> {
                    beneficiaryController.start();
                }
<<<<<<< Updated upstream
=======
                case 3 -> {
                    eventController.start();
                }
                case 4 -> {
                    communicationController = new CommunicationController(userID);
                    communicationController.start();
                }
>>>>>>> Stashed changes
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
