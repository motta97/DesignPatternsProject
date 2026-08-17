package utility;

public interface Subject {
    public void notifyall() ;
    public void remove(Observer ref) ;
    public void add(Observer ref) ;
}
