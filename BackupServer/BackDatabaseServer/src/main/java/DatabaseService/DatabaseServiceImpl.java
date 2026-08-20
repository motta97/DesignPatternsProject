/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author abeer
 */
public class DatabaseServiceImpl extends UnicastRemoteObject implements RemoteBackUpProxy,Remote{
    private String filePath;
    private static DatabaseServiceImpl instance;
    private String serverAuth;
    private String pass;
    private DatabaseServiceImpl(String path,String auth,String pass) throws RemoteException{
        this.filePath = path;
        this.pass = pass;
        this.serverAuth = auth;
    }
    public static DatabaseServiceImpl getInstance(String path,String auth,String pass) throws RemoteException{
        if(instance==null){
            instance = new DatabaseServiceImpl(path,auth,pass);
        }
        return instance;
    }
    public void StoreData(ArrayList<String> data) throws RemoteException{
       try{
           java.io.FileWriter fileWriter = new java.io.FileWriter(filePath,false);
           java.io.PrintWriter printer = new java.io.PrintWriter(fileWriter);
           
           for(String item : data){
               printer.println(item);
           }
           printer.close();
       }catch(java.io.IOException e){
           System.out.println("Failed to reach file: "+e.getMessage());
       }
   }
    @Override
    public ArrayList<String> GetData(){
        ArrayList<String> fileContent = new ArrayList<>();
        try{
            java.io.FileReader fileReader = new java.io.FileReader(filePath);
            java.io.BufferedReader buffer = new java.io.BufferedReader(fileReader);
            String line;
            while((line=buffer.readLine())!=null){
                String[] data = line.split(",");
                for(String s:data){
                    fileContent.add(s);
                }
                
            }
            buffer.close();
        }catch(java.io.IOException e){
            System.out.println("Failed to read file: "+e.getMessage());
        }
        return fileContent;
    }
    public void SetStoragePath(String path){
        this.filePath = path;
    }

    @Override
     public String getAuthAndPass(){
        return this.serverAuth+this.pass;
    }

    @Override
    public void GetAuthorAndPass(String auth, String pass) throws RemoteException {
        this.serverAuth = auth;
        this.pass = pass;
    }
}
