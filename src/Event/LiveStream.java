package Event;

public class LiveStream extends EventDecorator{
    public LiveStream(Event event){
        this.component = event;
    }
    public String getDescription() {
        return "Live Stream"+ component.getDescription();

    }
    public double getCost(){
        return 200.0+ component.getCost();
    }
}
