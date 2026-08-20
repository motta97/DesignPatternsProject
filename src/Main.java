<<<<<<<< Updated upstream:src/Main.java
import BeneficiaryMVC.BeneficiaryController;
import BeneficiaryMVC.BeneficiaryFacade;
import BeneficiaryMVC.BeneficiaryModel;
import BeneficiaryMVC.BeneficiaryView;
import DonationMVC.DonationController;
import DonationMVC.DonationFacade;
import DonationMVC.DonationModel;
import DonationMVC.DonationView;
import TextFile.TextFileHandler;

import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;
========
import Main.MainController;
>>>>>>>> Stashed changes:NetBeansProject_DP/src/main/java/Main.java

/**
 * Application entry point — delegates to MainController.
 */
public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.start();
    }
}