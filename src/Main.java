import BeneficiaryMVC.BeneficiaryController;
import BeneficiaryMVC.BeneficiaryFacade;
import BeneficiaryMVC.BeneficiaryModel;
import BeneficiaryMVC.BeneficiaryView;
import DonationMVC.DonationController;
import DonationMVC.DonationFacade;
import DonationMVC.DonationModel;
import DonationMVC.DonationView;

import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BeneficiaryModel beneficiaryModel = new BeneficiaryModel() ;
        BeneficiaryFacade beneficiaryFacade = new BeneficiaryFacade(beneficiaryModel) ;
        DonationModel donationModel = new DonationModel() ;
        DonationFacade donationFacade = new DonationFacade(donationModel) ;
        Scanner sc = new Scanner(System.in) ;
        DonationView donationView = new DonationView(sc) ;
        BeneficiaryView beneficiaryView = new BeneficiaryView(sc) ;
        BeneficiaryController bc = new BeneficiaryController(beneficiaryFacade, donationFacade , beneficiaryView) ;
        DonationController dc = new DonationController(donationFacade , donationView) ;
         int choice ;
         boolean flag  = true;
        while (flag){
            System.out.println("Enter Which Donation you want");
            System.out.println("Enter 1 for Donation Module or Enter 2 for Beneficary module or Enter 0 for exit");
            choice =sc.nextInt() ;
            switch (choice){

                case 1 ->{dc.start();}
                case 2 -> {bc.start();}
                case 0 -> {flag =false ;}
                default -> {
                    System.out.println("Enter valid choice");
                }

            }
        }


    }
}