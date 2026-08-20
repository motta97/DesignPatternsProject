package utility;

import java.util.List;

public interface ItxtSetter {
    public  void SetMessage(String filepath ,String line) ;
    public void RemoveMessage(String filePath , String line);
    public void Update(String filePath, String line , String Message);
}
