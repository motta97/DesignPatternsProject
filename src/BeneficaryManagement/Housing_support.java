package BeneficaryManagement;

public class Housing_support extends supportDecorater{
    public Housing_support(Isupport ref) {
        super(ref);
    }

    @Override
    public String getDescription() {
        return ref.getDescription()+" some description about Housing support";
    }

    @Override
    public String getSupport() {
        return ref.getSupport()+" + , Housing ";
    }
}
