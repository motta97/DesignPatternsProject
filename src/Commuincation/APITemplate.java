package Commuincation;

public abstract class APITemplate {
    public void createPost(String description) {
        prepareMessage(description);
        connectToCommunicationService();
        sendMessage(description);
        logResult();
    }
    public void prepareMessage(String description) {

    }
    public abstract void connectToCommunicationService();
    public abstract void sendMessage(String message);
    public void logResult(){

    }
}
