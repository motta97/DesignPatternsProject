package BeneficaryManagement;

public class Educational_support extends supportDecorater{
    public Educational_support(Isupport ref) {
        super(ref);
    }

    @Override
    public String getDescription() {
        return ref.getDescription()+" some description about educational support";
    }

    @Override
    public String getSupport() {
        return ref.getSupport()+" + Educational Support";
    }
}
