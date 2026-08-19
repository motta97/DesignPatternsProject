package BeneficaryManagement;

import utility.txtGetter;

public class BasicSupport implements Isupport{
    @Override
    public String getDescription() {

        return txtGetter.getMessage("BasicSupport_getDescription","src/BeneficaryManagement/BeneficaryMangementMessages.txt");
    }

    @Override
    public String getSupport() {
        return txtGetter.getMessage("BasicSupport_getSupport","src/BeneficaryManagement/BeneficaryMangementMessages.txt");
    }
}
