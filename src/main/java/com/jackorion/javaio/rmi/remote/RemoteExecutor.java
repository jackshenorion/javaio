package com.jackorion.javaio.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteExecutor extends Remote {
    String execute(Request request) throws RemoteException;
}