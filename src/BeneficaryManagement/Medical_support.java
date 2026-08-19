package BeneficaryManagement;

import utility.txtGetter;

public class Medical_support extends supportDecorater{
    public Medical_support(Isupport ref) {
        super(ref);
    }

    @Override
    public String getDescription() {
        return ref.getDescription()+ txtGetter.getMessage("Medical_support_getDescription","src/BeneficaryManagement/BeneficaryMangementMessages.txt");
    }

    @Override
    public String getSupport() {
        return ref.getSupport()+txtGetter.getMessage("Medical_support_getSupport","src/BeneficaryManagement/BeneficaryMangementMessages.txt");
    }
}
