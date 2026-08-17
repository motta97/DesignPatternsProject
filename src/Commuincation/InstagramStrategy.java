package Commuincation;

public class InstagramStrategy implements SocialMediaStrategy {
    @Override
    public void post(String description) {
        System.out.println("POSTING "+description+" ON INSTAGRAM...");
    }
}
