package Event;

public abstract class EventDecorator implements Component {
    protected Component component;

    public abstract String getDescription();
    public abstract double getCost();

}
