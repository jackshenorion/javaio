package com.jackorion.javaio.network;

import java.rmi.RemoteException;

public class HelloImpl implements Hello{
    @Override
    public void printMsg() throws RemoteException {
        System.out.println("Hello world!!!");
    }
}
