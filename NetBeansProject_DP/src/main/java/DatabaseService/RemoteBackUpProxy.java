/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DatabaseService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author abeer
 */
public interface RemoteBackUpProxy extends Remote {
    void StoreData(ArrayList<String> data)throws RemoteException;
    ArrayList<String> GetData() throws RemoteException;
     String getAuthAndPass() throws RemoteException;
     void GetAuthorAndPass(String auth,String pass) throws RemoteException;
}

