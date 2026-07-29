package BeneficiaryMVC;

import BeneficaryManagement.Beneficiary;
import DonationMVC.DonationFacade;
import DonationMVC.DonationModel;
import DonationManagement.Donation;

import java.util.Scanner;

public class BeneficiaryController {

    private final BeneficiaryFacade
            beneficiaryFacade;

    private final DonationFacade
            donationFacade;

    private final BeneficiaryView view;

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

                    case 0 ->
                            flag = false;

                    default -> view.showError("Invalid choice.");
                }

            } catch (RuntimeException exception) {

                view.showError(exception.getMessage());
            }
        }
    }

    private void registerBeneficiary() {

        String name =
                view.readString("Name: ");

        int id =
                view.readInt(
                        "Beneficiary ID: "
                );

        String phone =
                view.readString("Phone: ");

        String email =
                view.readString("Email: ");

        String strategy =
                view.readString(
                        "Strategy "
                                + "(delivery/collection/transfer): "
                );

        Beneficiary beneficiary =
                beneficiaryFacade
                        .registerBeneficiary(
                                name,
                                id,
                                phone,
                                email,
                                strategy
                        );

        view.showSuccess(
                "Beneficiary registered."
        );

        view.showBeneficiary(
                beneficiary
        );
    }

    private void addSupport() {

        int beneficiaryId =
                view.readInt(
                        "Beneficiary ID: "
                );

        String supportType =
                view.readString(
                        "Support "
                                + "(medical/housing/educational): "
                );

        Beneficiary beneficiary =
                beneficiaryFacade.addSupport(
                        beneficiaryId,
                        supportType
                );

        view.showSuccess(
                "Support added."
        );

        view.showBeneficiary(
                beneficiary
        );
    }

    private void changeStrategy() {

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

    private void distributeDonation() {

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

        /*
         * The Donation module retrieves the Donation.
         */
        Donation donation =
                donationFacade.findDonation(
                        donationId
                );

        /*
         * The Beneficiary module performs distribution.
         */
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

    private void findBeneficiary() {

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
}