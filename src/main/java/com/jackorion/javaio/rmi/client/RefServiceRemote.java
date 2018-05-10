package com.jackorion.javaio.rmi.client;

import com.jackorion.javaio.rmi.ref.RefService;
import com.jackorion.javaio.rmi.remote.Request;
import com.jackorion.javaio.rmi.remote.RemoteExecutor;

import java.rmi.RemoteException;

public class RefServiceRemote implements RefService {
    private RemoteExecutor remoteExecutor;

    public RefServiceRemote(RemoteExecutor remoteExecutor) {
        this.remoteExecutor = remoteExecutor;
    }

    @Override
    public String getValue(String code, char key) {
        Request request = new RefRequest("getValue", code + "," + key);
        try {
            return remoteExecutor.execute(request);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateValue(String code, char key, String newValue) {
        Request request = new RefRequest("update", code + "," + key + "," + newValue);
        try {
            remoteExecutor.execute(request);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
