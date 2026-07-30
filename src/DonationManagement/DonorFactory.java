package DonationManagement;

import java.util.Locale;

public class DonorFactory {

    public static Donor createDonor(String name,  String type, String phone, String email) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException(
                    "Donor type is required."
            );
        }

        return switch (type.trim().toLowerCase()) {
            case "basic" ->
                    new BasicDonor(
                            name,  phone, email
                    );

            case "premium" ->
                    new PremiumDonor(
                            new BasicDonor(
                                    name,  phone, email
                            )
                    );

            case "vip" ->
                    new VIPDonor(
                            new BasicDonor(
                                    name,  phone, email
                            )
                    );

            default ->
                    throw new IllegalArgumentException(
                            "Unknown donor type: " + type
                    );
        };
    }
}
