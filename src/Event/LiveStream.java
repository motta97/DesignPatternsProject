package Event;

public class LiveStream extends EventDecorator{
    public String getDescription() {
        return "Live Stream"+ component.getDescription();

    }
    public double getCost(){
        return 200.0+ component.getCost();
    }
}
