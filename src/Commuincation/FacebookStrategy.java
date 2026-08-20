package Commuincation;

public class FacebookStrategy implements SocialMediaStrategy {
    APITemplate facebookAPI;
    public FacebookStrategy(APITemplate facebookAPI) {
        this.facebookAPI = facebookAPI;
    }
    @Override
    public boolean post(String description) {
        facebookAPI.createPost(description);
         return true;
    }
}
