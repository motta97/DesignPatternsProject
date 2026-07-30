package Event;

public class VIPAccess extends EventDecorator{
    @Override
    public double getCost() {
        return 350.0+ component.getCost();
    }
    public  String getDescription(){
        return "VIP Access "+component.getDescription();
    }
}
