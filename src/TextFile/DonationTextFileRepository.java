package TextFile;

import DonationManagement.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class DonationTextFileRepository {

    private static final String FILE_NAME =
            "donations.txt";

    private final TextFileManager fileManager;

    public DonationTextFileRepository() {

        fileManager =
                TextFileManager.getInstance();
    }

    public List<Donation> loadAll(
            List<Donor> donors) {

        Map<Integer, Donor> donorsById =
                new HashMap<>();

        for (Donor donor : donors) {
            donorsById.put(
                    donor.getId(),
                    donor
            );
        }

        List<Donation> donations =
                new ArrayList<>();

        List<String> lines =
                fileManager.readAll(FILE_NAME);

        for (String line : lines) {

            if (line.isBlank() ||
                    line.startsWith("#")) {

                continue;
            }

            String[] parts =
                    line.split("\\|", -1);

            if (parts.length != 5) {

                System.err.println(
                        "Skipping invalid donation line: "
                                + line
                );

                continue;
            }

            try {
                int donorId =
                        Integer.parseInt(parts[0]);

                String donationType =
                        parts[1];

                double value =
                        Double.parseDouble(parts[2]);

                String paymentMethod =
                        parts[3];

                String paymentDetails =
                        TextFileCodec.decode(parts[4]);

                Donor donor =
                        donorsById.get(donorId);

                if (donor == null) {

                    System.err.println(
                            "Skipping donation because donor "
                                    + donorId
                                    + " was not found."
                    );

                    continue;
                }

                /*
                 * The ID is generated automatically
                 * inside your Donation constructor.
                 */
                Donation donation =
                        DonationFactory.createDonation(
                                donor,
                                paymentMethod,
                                donationType,
                                value,
                                paymentDetails
                        );

                donations.add(donation);

            } catch (RuntimeException exception) {

                System.err.println(
                        "Skipping invalid donation record: "
                                + exception.getMessage()
                );
            }
        }

        return donations;
    }

    public void saveAll(
            List<Donation> donations) {

        List<String> lines =
                new ArrayList<>();

        lines.add(
                "# donorId|donationType|value|"
                        + "paymentMethod|paymentDetails"
        );

        for (Donation donation : donations) {

            DonationData data =
                    extractDonationData(donation);

            String line =
                    donation.getDonor().getId() + "|"
                            + data.donationType + "|"
                            + data.value + "|"
                            + data.paymentMethod + "|"
                            + TextFileCodec.encode(
                            data.paymentDetails
                    );

            lines.add(line);
        }

        fileManager.writeAll(
                FILE_NAME,
                lines
        );
    }

    private DonationData extractDonationData(
            Donation donation) {

        DonationType type =
                donation.getDonationType();

        String donationType;
        double value;

        if (type instanceof MoneyDonation moneyDonation) {

            donationType = "money";
            value = moneyDonation.getAmount();

        } else if (
                type instanceof ThingDonation thingDonation) {

            donationType = "thing";
            value = thingDonation.getQuantity();

        } else {

            throw new IllegalArgumentException(
                    "Unsupported donation type: "
                            + type.getClass().getName()
            );
        }

        DonateMethod method =
                donation.getMethod();

        String paymentMethod;
        String paymentDetails;

        if (method instanceof CashMethod) {

            paymentMethod = "cash";
            paymentDetails = "";

        } else if (
                method instanceof CheckMethod checkMethod) {

            paymentMethod = "check";
            paymentDetails =
                    checkMethod.getCheckNumber();

        } else if (
                method instanceof onlineMethod online) {

            paymentMethod = "online";
            paymentDetails =
                    online.getCreditCardNumber();

        }
        else if (
                method instanceof thingmethod thing) {

            paymentMethod = "online";
            paymentDetails = "" ;

        }


        else {

            throw new IllegalArgumentException(
                    "Unsupported payment method: "
                            + method.getClass().getName()
            );
        }

        return new DonationData(
                donationType,
                value,
                paymentMethod,
                paymentDetails
        );
    }

    private static final class DonationData {

        private final String donationType;
        private final double value;
        private final String paymentMethod;
        private final String paymentDetails;

        private DonationData(
                String donationType,
                double value,
                String paymentMethod,
                String paymentDetails) {

            this.donationType =
                    donationType;

            this.value =
                    value;

            this.paymentMethod =
                    paymentMethod;

            this.paymentDetails =
                    paymentDetails;
        }
    }
}