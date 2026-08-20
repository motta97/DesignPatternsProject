package utility;

public class ProxyTextSetter implements ItxtSetter {
    private txtStter ref ;
    private User user ;
    public ProxyTextSetter(User user){
        ref= new txtStter() ;
        this.user = user ;
    }
    @Override
    public void SetMessage(String filepath, String line) {
        if(user instanceof Admin){
            ref.SetMessage(filepath,line);
        }else {
            System.out.println("You are not Authorized to do this !");
        }

    }

    @Override
    public void RemoveMessage(String filePath, String line) {
        // check Admin if yes
        if(user instanceof Admin){
            ref.RemoveMessage(filePath,line);
        }
        else {
            System.out.println("You are not Authorized to do this !");
        }
    }

    @Override
    public void Update(String filePath, String line, String Message) {
        if(user instanceof Admin){
            ref.Update(filePath,line,Message);
        }
        else {
            System.out.println("You are not Authorized to do this !");
        }

    }
}
