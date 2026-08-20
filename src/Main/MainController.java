package Main;

import BeneficiaryMVC.BeneficiaryController;
import BeneficiaryMVC.BeneficiaryFacade;
import BeneficiaryMVC.BeneficiaryModel;
import BeneficiaryMVC.BeneficiaryView;
import DonationMVC.DonationController;
import DonationMVC.DonationFacade;
import DonationMVC.DonationModel;
import DonationMVC.DonationView;

import java.util.Scanner;

public class MainController {
    private DonationController donationController ;
    private BeneficiaryController beneficiaryController ;
    private MainView mainView ;
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
    }

    public void start(){
        Scanner sc = new Scanner(System.in) ;
        int choice;
        boolean flag = true;
        while (flag) {
            mainView.showMenu() ;
            choice = sc.nextInt();
            switch (choice) {

                case 1 -> {
                    donationController.start();
                }
                case 2 -> {
                    beneficiaryController.start();
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
