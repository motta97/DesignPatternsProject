package BeneficiaryAssistanceProcess;

public abstract class SupportProcess {
    public final void ProcessSupport(){
        validateRequest() ;
        checkEligibility() ;
        prepareSupport() ;
        distributeSupport() ;
        completeRequest() ;
    }
    public final  void validateRequest(){
        System.out.println("Validate Request . . . . . ");

    } ;
    public abstract void checkEligibility() ;
    public abstract void prepareSupport();
    public final   void distributeSupport(){
        System.out.println("Distribute Support . . . . . ");
    } ;
    public final void completeRequest(){
        System.out.println("Complete Request . . . . . . . ");
    } ;
}
