package Commuincation;

public abstract class APITemplate {
    public void createPost(String description) {
        prepareMessage(description);
        connectToCommunicationService();
        sendMessage();
        logResult();
    }
    public void prepareMessage(String description) {

    }
    public abstract void connectToCommunicationService();
    public abstract void sendMessage();
    public void logResult(){

    }
}
