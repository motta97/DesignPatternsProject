/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.backdatabaseserver;

import DatabaseService.DatabaseServiceImpl;
import DatabaseService.ProxyServer;
import DatabaseService.RemoteBackUpProxy;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author abeer
 */
public class BackUpDbServer {
    
    public static void main(String[] args) {
        try{
        String path  = "serverLogs.txt";
        Registry reg = LocateRegistry.createRegistry(8000);
        RemoteBackUpProxy proxy = ProxyServer.getInstance(DatabaseServiceImpl.getInstance(path,"User","123"));
        reg.rebind("DataService", proxy);
        }catch(java.io.IOException e){
            System.out.println("Error in network: "+e.getMessage());
        }
    }
}
