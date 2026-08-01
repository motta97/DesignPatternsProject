package Commuincation;

import utility.User;

public interface CommunicationStrategy
{
    public boolean send(User receiver, String message);
}
