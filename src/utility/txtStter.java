package utility;

import TextFile.TextFileHandler;

import java.util.List;

public class txtStter implements ItxtSetter{
    @Override
    public  void SetMessage(String filepath, String line) {
        List<String> strings = txtGetter.getAllMessages(filepath) ;
        strings.add(line) ;
        TextFileHandler handler = new TextFileHandler() ;
        handler.WriteLine(filepath,strings);

    }

    @Override
    public void RemoveMessage(String filePath, String line) {

        List<String> strings = txtGetter.getAllMessages(filePath) ;
        TextFileHandler handler = new TextFileHandler() ;
        for(String item : strings){
            if(item.equals(line)){
                strings.remove(item) ;
                handler.WriteLine(filePath,strings);
                System.out.println("Message Remove Successfully");
                return ;

            }
        }
        System.out.println("Message Not found");
    }

@Override
    public void Update(String filePath, String line , String Message) {

        List<String> strings = txtGetter.getAllMessages(filePath) ;
        TextFileHandler handler = new TextFileHandler() ;
        for(String item : strings){
            if(item.equals(line)){
                String[]parts =item.split("=") ;
                Message = parts[0]+Message ;
                strings.remove(item) ;
                strings.add(Message) ;
                handler.WriteLine(filePath,strings);
                System.out.println("Message Updated Successfully");
                return ;

            }
        }
        System.out.println("Message Not found");
    }
}
