package DonationManagement;

import java.util.Scanner;

public class DonationFactory {

    public static Donation createDonation(Donor donor ,String method , String type , double value , String Paymentdetails) {


        DonationType donationtype = createDonationtype(type , value) ;
        DonateMethod donatemethod = createDonateMethod(method , Paymentdetails) ;


        return new Donation(donor , donatemethod , donationtype) ;
    }





    public static DonationType createDonationtype(String type , double value){


        switch (type.toLowerCase()){

            case "money" -> {return new MoneyDonation(value) ;}
            case "thing" -> {return new ThingDonation((int)value) ;}
            default -> {
                System.out.println("unknown  type");
            }

        }
        return null ;

    }

    public static DonateMethod createDonateMethod(String method , String Paymentdetails){


        switch (method.toLowerCase()){

            case "cash" ->{return new CashMethod() ;}
            case "check" ->{

                return new CheckMethod(Paymentdetails) ;}

            case "online" -> {

                return new onlineMethod(Paymentdetails) ;

            }
            default -> {
                System.out.println("unknown method ");
            }

        }

        return null ;


    }




}
