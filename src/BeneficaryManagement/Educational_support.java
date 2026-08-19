package BeneficaryManagement;

import utility.txtGetter;

public class Educational_support extends supportDecorater{
    public Educational_support(Isupport ref) {
        super(ref);
    }

    @Override
    public String getDescription() {

        return ref.getDescription()+ txtGetter.getMessage("Educational_support_getDescription","src/BeneficaryManagement/BeneficaryMangementMessages.txt");
    }

    @Override
    public String getSupport() {

        return ref.getSupport()+txtGetter.getMessage("Educational_support_getSupport","src/BeneficaryManagement/BeneficaryMangementMessages.txt");
    }
}
