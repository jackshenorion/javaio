package com.jackorion.javaio.network;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

public class HelloServer {

    public HelloServer() {
    }

    public static void main(String[] args) {
        try {
            HelloImpl hello = new HelloImpl();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(hello, 0);
            Registry registry = LocateRegistry.createRegistry(0);
            registry.bind("Hello", stub);
            System.out.println("RefHelperServer ready");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
