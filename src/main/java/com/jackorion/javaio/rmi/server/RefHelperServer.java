package com.jackorion.javaio.rmi.server;

import com.jackorion.javaio.rmi.ref.RefService;
import com.jackorion.javaio.rmi.ref.RefServiceImpl;
import com.jackorion.javaio.rmi.remote.RemoteExecutor;
import com.jackorion.javaio.rmi.remote.Request;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RefHelperServer implements RemoteExecutor {
    private RefService refService;

    public RefHelperServer() {
        this.refService = new RefServiceImpl();
    }

    @Override
    public String execute(Request request) throws RemoteException {
        switch (request.getName()) {
            case "getValue": return getValue(request);
            case "update": update(request); return "";
            default: return null;
        }
    }

    private String getValue(Request request) {
        String input = request.getInput();
        String[] split = input.split(",");
        return refService.getValue(split[0], split[1].charAt(0));
    }

    private void update(Request request) {
    }

    public static void main(String[] args) {
        try {
            RefHelperServer refHelperServer = new RefHelperServer();
            RemoteExecutor stub =
                    (RemoteExecutor) UnicastRemoteObject.exportObject(refHelperServer, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("RefRemote", stub);
            System.out.println("RemoteExecutor bound");
        } catch (Exception e) {
            System.err.println("RemoteExecutor exception:");
            e.printStackTrace();
        }
    }
}
