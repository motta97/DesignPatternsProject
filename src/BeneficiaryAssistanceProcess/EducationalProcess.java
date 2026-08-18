package BeneficiaryAssistanceProcess;

public class EducationalProcess extends SupportProcess{
    @Override
    public void checkEligibility() {
        System.out.println("Check Eligibility for a Educational process . . . . . .");
    }

    @Override
    public void prepareSupport() {
        System.out.println("Prepare a Educational Support . . . . . .");
    }
}
