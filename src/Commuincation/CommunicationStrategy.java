package Commuincation;

import utility.User;

public interface CommunicationStrategy
{
     boolean send(User receiver, String message);
}
