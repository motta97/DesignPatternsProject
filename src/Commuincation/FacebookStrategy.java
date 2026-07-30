package Commuincation;

public class FacebookStrategy implements SocialMediaStrategy {
    @Override
    public void post(String description) {
        System.out.println("POSTING "+description+" ON FACEBOOK...");
    }
}
