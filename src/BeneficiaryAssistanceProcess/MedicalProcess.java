package BeneficiaryAssistanceProcess;

public class MedicalProcess extends SupportProcess{
    @Override
    public void checkEligibility() {
        System.out.println("Check Eligibility for a Medical process . . . . . .");
    }

    @Override
    public void prepareSupport() {
        System.out.println("Prepare a Medical Support . . . . . .");
    }
}
