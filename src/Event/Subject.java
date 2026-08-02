package Event;

import java.util.Observer;

public interface Subject {
    public void registerObserver(EventObserver o);
    public void removeObserver(EventObserver o);
    public void notifyObservers(String eventNotification);

}
