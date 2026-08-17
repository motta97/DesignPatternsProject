package BeneficaryManagement;

public class Medical_support extends supportDecorater{
    public Medical_support(Isupport ref) {
        super(ref);
    }

    @Override
    public String getDescription() {
        return ref.getDescription()+" some description of medical support";
    }

    @Override
    public String getSupport() {
        return ref.getSupport()+" + , Medical ";
    }
}
