package BeneficaryManagement;

import BeneficaryRequestStatus.BeneficiaryRequest;
import utility.txtGetter;

public class ExternalDelivery implements ExternalDeliveryInterface{


    @Override
    public void sendPackage() {
        System.out.println(txtGetter.getMessage("ExternalDelivery_sendPackage","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
    }

    @Override
    public void CalcShipping() {
        System.out.println(txtGetter.getMessage("ExternalDelivery_CalcShipping","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
    }

    @Override
    public void GetTrackingStatus() {
        System.out.println(txtGetter.getMessage("ExternalDelivery_GetTrackingStatus","src/BeneficaryManagement/BeneficaryMangementMessages.txt"));
    }
}
