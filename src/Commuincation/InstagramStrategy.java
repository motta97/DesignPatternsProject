package Commuincation;

public class InstagramStrategy implements SocialMediaStrategy {
    APITemplate instagramAPI;
    public InstagramStrategy(APITemplate instagramAPI) {
        this.instagramAPI = instagramAPI;
    }
    @Override
    public boolean post(String description) {
        instagramAPI.createPost(description);
        return true;
    }
}
