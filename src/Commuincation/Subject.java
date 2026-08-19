package Commuincation;

import utility.User;

import java.util.List;

public interface Subject {
    void setCommunicationStrategy(CommunicationStrategy communicationStrategy);
    boolean sendMessage(User sender, User receiver, String message);
    boolean sendCampaign(User sender, List<User> users, String message);
}
