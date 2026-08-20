package Event;

public class VIPAccess extends EventDecorator{
    public VIPAccess(Event event){
        this.component = event;
    }
    @Override
    public double getCost() {
        return 350.0+ component.getCost();
    }
    public  String getDescription(){
        return "VIP Access "+component.getDescription();
    }
}
