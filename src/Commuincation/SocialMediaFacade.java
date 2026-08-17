package Commuincation;

public class SocialMediaFacade {
    private SocialMediaStrategy socialMediaStrategy;
    public void setSocialMediaStrategy(SocialMediaStrategy socialMediaStrategy) {
        this.socialMediaStrategy = socialMediaStrategy;
    }
    public void post(String description) {
        if(socialMediaStrategy == null) {
            return;
        }
        socialMediaStrategy.post(description);
    }
    public void postOnAll(String description) {
        if(socialMediaStrategy == null) {
            return;
        }
        socialMediaStrategy = new InstagramStrategy();
        socialMediaStrategy.post(description);
        socialMediaStrategy= new FacebookStrategy();
        socialMediaStrategy.post(description);
        socialMediaStrategy = new XStrategy();
        socialMediaStrategy.post(description);
    }
}
