package BeneficaryManagement;

public abstract class supportDecorater implements Isupport {
    protected Isupport ref ;
    public supportDecorater(Isupport ref){
        this.ref = ref ;
    }
}
