package Commuincation;

public class XStrategy implements SocialMediaStrategy {
    APITemplate xAPI;
    public XStrategy(APITemplate xAPI) {
        this.xAPI = xAPI;
    }
    @Override
    public boolean post(String description) {
        xAPI.createPost(description);
        return true;
    }
}
