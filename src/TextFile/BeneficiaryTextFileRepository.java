package TextFile;

import BeneficaryManagement.BeneficaryFactory;
import BeneficaryManagement.Beneficiary;
import BeneficaryManagement.DigitalTransfer;
import BeneficaryManagement.DistributionStrategy;
import BeneficaryManagement.HomeDelivery;
import BeneficaryManagement.Isupport;
import BeneficaryManagement.supportDecorater;

import java.util.ArrayList;
import java.util.List;

public  class BeneficiaryTextFileRepository {

    private static final String FILE_NAME =
            "beneficiaries.txt";

    private final TextFileManager fileManager;

    public BeneficiaryTextFileRepository() {

        fileManager =
                TextFileManager.getInstance();
    }

    public List<Beneficiary> loadAll() {

        List<Beneficiary> beneficiaries =
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

            if (parts.length != 6) {

                System.err.println(
                        "Skipping invalid beneficiary line: "
                                + line
                );

                continue;
            }

            try {
                int id =
                        Integer.parseInt(parts[0]);

                String name =
                        TextFileCodec.decode(parts[1]);

                String phone =
                        TextFileCodec.decode(parts[2]);

                String email =
                        TextFileCodec.decode(parts[3]);

                String supportsText =
                        parts[4];

                String strategyType =
                        parts[5];

                Beneficiary beneficiary =
                        BeneficaryFactory
                                .createBeneficary(
                                        name,
                                        phone,
                                        email,
                                        strategyType
                                );

                if (!supportsText.isBlank()) {

                    String[] supports =
                            supportsText.split(",");

                    for (String supportType : supports) {

                        Isupport createdSupport =
                                BeneficaryFactory
                                        .createSupport(
                                                supportType.trim(),
                                                beneficiary
                                                        .getSupp_type()
                                        );

                        if (!(createdSupport instanceof supportDecorater decorator)) {

                            throw new IllegalArgumentException(
                                    "Factory did not create "
                                            + "a support decorator."
                            );
                        }

                        beneficiary.setSupp_type(decorator);
                    }
                }

                beneficiaries.add(beneficiary);

            } catch (RuntimeException exception) {

                System.err.println(
                        "Skipping invalid beneficiary record: "
                                + exception.getMessage()
                );
            }
        }

        return beneficiaries;
    }

    public void saveAll(
            List<Beneficiary> beneficiaries) {

        List<String> lines =
                new ArrayList<>();

        lines.add(
                "# id|name|phone|email|supports|"
                        + "distributionStrategy"
        );

        for (Beneficiary beneficiary :
                beneficiaries) {

            String line =
                    beneficiary.getId() + "|"
                            + TextFileCodec.encode(
                            beneficiary.getName()
                    ) + "|"
                            + TextFileCodec.encode(
                            beneficiary.getPhone()
                    ) + "|"
                            + TextFileCodec.encode(
                            beneficiary.getEmail()
                    ) + "|"
                            + String.join(
                            ",",
                            extractSupports(
                                    beneficiary
                                            .getSupp_type()
                            )
                    ) + "|"
                            + getStrategyName(
                            beneficiary.getRef()
                    );

            lines.add(line);
        }

        fileManager.writeAll(
                FILE_NAME,
                lines
        );
    }

    private List<String> extractSupports(
            Isupport support) {

        List<String> supports =
                new ArrayList<>();

        if (support == null) {
            return supports;
        }

        String supportText =
                support.getSupport().toLowerCase();

        if (supportText.contains("medical")) {
            supports.add("medical");
        }

        if (supportText.contains("housing")) {
            supports.add("housing");
        }

        if (supportText.contains("educational")) {
            supports.add("educational");
        }

        return supports;
    }

    private String getStrategyName(
            DistributionStrategy strategy) {

        if (strategy == null ||
                strategy instanceof
                        BeneficaryManagement.Collection) {

            return "collection";
        }

        if (strategy instanceof DigitalTransfer) {
            return "transfer";
        }

        if (strategy instanceof HomeDelivery) {
            return "delivery";
        }

        throw new IllegalArgumentException(
                "Unsupported distribution strategy: "
                        + strategy.getClass().getName()
        );
    }
}