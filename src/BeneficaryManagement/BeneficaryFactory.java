package BeneficaryManagement;

public class BeneficaryFactory {

    public static Beneficiary createBeneficary(String name,  String phone, String email, String distributionType) {

        Beneficiary beneficiary = new Beneficiary(name,  phone, email);

        beneficiary.setSupp_type(
                new BasicSupport()
        );

        beneficiary.setRef(
                createDistributionStrategy(
                        distributionType
                )
        );

        return beneficiary;
    }


    public static Isupport createSupport(String supportType , Isupport curr){

        if(curr == null){
            curr = new BasicSupport() ;
        }

        if(supportType == null || supportType ==""){


            return curr ;
        }

        switch (supportType.toLowerCase()){

            case("medical") ->{return new Medical_support(curr) ;}
            case("educational") -> {return new Educational_support(curr) ;}
            case("housing") -> {return new Housing_support(curr) ;}
            default -> {
                System.out.println("unknown support type");
            }


        }

        return curr ;

    }


    public static DistributionStrategy
    createDistributionStrategy(String strategy) {

        if (strategy == null || strategy.isBlank()) {
            return new Collection();
        }

        return switch (strategy.trim().toLowerCase()) {
            case "collect", "collection" ->
                    new Collection();

            case "delivery" ->
                    new HomeDelivery();

            case "transfer" ->
                    new DigitalTransfer();

            default ->
                    throw new IllegalArgumentException(
                            "Unknown strategy: " + strategy
                    );
        };
    }
}
