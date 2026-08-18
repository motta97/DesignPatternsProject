package BeneficaryManagement;

import utility.txtGetter;

public class Housing_support extends supportDecorater{
    public Housing_support(Isupport ref) {
        super(ref);
    }

    @Override
    public String getDescription() {
        return ref.getDescription()+ txtGetter.getMessage("Housing_support_getDescription","src/BeneficaryManagement/BeneficaryMangementMessages.txt");
    }

    @Override
    public String getSupport() {
        return ref.getSupport()+txtGetter.getMessage("Housing_support_getSupport","src/BeneficaryManagement/BeneficaryMangementMessages.txt");
    }
}
