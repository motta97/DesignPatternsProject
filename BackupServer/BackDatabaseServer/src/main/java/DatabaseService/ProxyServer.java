/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author abeer
 */
public class ProxyServer extends UnicastRemoteObject implements RemoteBackUpProxy{

    private String passCode;
    private String Author;
    private static ProxyServer instance;
    private RemoteBackUpProxy proxy;
    private ProxyServer(RemoteBackUpProxy prxy) throws RemoteException{
        this.proxy = prxy;
    }
    public static ProxyServer getInstance(RemoteBackUpProxy prxy)throws RemoteException{
        if(instance == null){
            instance = new ProxyServer(prxy);
        }
        return instance;
    }
    @Override
    public void StoreData(ArrayList<String> data) throws RemoteException {
        
        if(ValidData(data)){
            proxy.StoreData(data);
        }
    
    }
    
    private boolean ValidData(ArrayList<String> data){
        for(String s: data){
            if(s.contains("?si")){
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<String> GetData() throws RemoteException {
        if(this.Author==null||this.passCode==null||this.Author.isEmpty()||this.passCode.isEmpty()){
            System.out.println("Access denied");
            return new ArrayList<>();
        }
        if(proxy.getAuthAndPass().equals(Author+passCode)){
            return proxy.GetData();
        }
        else{
            System.out.println("Access denied");
            return new ArrayList<>();
        }
        }
    @Override
    public String getAuthAndPass() throws RemoteException{
        return "";
    }
    public void GetAuthorAndPass(String auth,String pass) throws RemoteException{
        this.Author = auth;
        this.passCode = pass;
    }
}
