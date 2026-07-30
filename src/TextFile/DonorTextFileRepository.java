package TextFile;

import DonationManagement.BasicDonor;
import DonationManagement.Donor;
import DonationManagement.DonorFactory;
import DonationManagement.PremiumDonor;
import DonationManagement.VIPDonor;

import java.util.ArrayList;
import java.util.List;


public  class DonorTextFileRepository {

    private static final String FILE_NAME =
            "donors.txt";

    private final TextFileManager fileManager;

    public DonorTextFileRepository() {

        fileManager =
                TextFileManager.getInstance();
    }

    public List<Donor> loadAll() {

        List<Donor> donors =
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
                        "Skipping invalid donor line: "
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

                String donorType =
                        parts[4];

                Donor donor =
                        DonorFactory.createDonor(
                                name,
                                donorType,
                                phone,
                                email
                        );

                if (donor == null) {
                    throw new IllegalArgumentException(
                            "Unknown donor type: "
                                    + donorType
                    );
                }

                donors.add(donor);

            } catch (RuntimeException exception) {

                System.err.println(
                        "Skipping invalid donor record: "
                                + exception.getMessage()
                );
            }
        }

        return donors;
    }

    public void saveAll(List<Donor> donors) {

        List<String> lines =
                new ArrayList<>();

        lines.add(
                "# id|name|phone|email|donorType"
        );

        for (Donor donor : donors) {

            String line =
                    donor.getId() + "|"
                            + TextFileCodec.encode(
                            donor.getName()
                    ) + "|"
                            + TextFileCodec.encode(
                            donor.getPhone()
                    ) + "|"
                            + TextFileCodec.encode(
                            donor.getEmail()
                    ) + "|"
                            + getDonorType(donor);

            lines.add(line);
        }

        fileManager.writeAll(
                FILE_NAME,
                lines
        );
    }

    private String getDonorType(Donor donor) {

        if (donor instanceof VIPDonor) {
            return "vip";
        }

        if (donor instanceof PremiumDonor) {
            return "premium";
        }

        if (donor instanceof BasicDonor) {
            return "basic";
        }

        throw new IllegalArgumentException(
                "Unsupported donor class: "
                        + donor.getClass().getName()
        );
    }
}