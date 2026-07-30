package Commuincation;

import BeneficaryManagement.User;

public interface CommunicationStrategy
{
    public boolean send(User receiver, String message);
}
