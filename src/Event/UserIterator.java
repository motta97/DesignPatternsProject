package Event;

import utility.User;

import java.util.List;

public class UserIterator {
    private int position = 0;
    private List<User> users;
    public UserIterator(List<User> users ) {
        this.users = users;
    }
    public User next(){
        if(position < users.size()){
            return users.get(position++);
        }
        return null;
    }
    public boolean hasNext(){
        return position < users.size();
    }
}
