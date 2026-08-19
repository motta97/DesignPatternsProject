package Commuincation;

public class SocialMediaFacade {
    private SocialMediaStrategy socialMediaStrategy;
    public void setSocialMediaStrategy(SocialMediaStrategy socialMediaStrategy) {
        this.socialMediaStrategy = socialMediaStrategy;
    }
    public boolean post(String description) {
        if(socialMediaStrategy == null) {
            return false;
        }
        return socialMediaStrategy.post(description);
    }
    public void postOnAll(String description) {
        if(socialMediaStrategy == null) {
            return;
        }
        socialMediaStrategy = new InstagramStrategy(new InstagramAPI());
        socialMediaStrategy.post(description);
        socialMediaStrategy= new FacebookStrategy(new FacebookAPI());
        socialMediaStrategy.post(description);
        socialMediaStrategy = new XStrategy(new XAPI());
        socialMediaStrategy.post(description);
    }
}
