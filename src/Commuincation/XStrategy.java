package Commuincation;

public class XStrategy implements SocialMediaStrategy {
    @Override
    public void post(String description) {
        System.out.println("POSTING "+description+" ON X...");
    }
}
