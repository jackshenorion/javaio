package com.jackorion.javaio.rmi.client;

import com.jackorion.javaio.rmi.ref.RefService;
import com.jackorion.javaio.rmi.remote.RemoteExecutor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RefClient {

    public static void main(String[] args) {
        try {
            String name = "RefRemote";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            int count = Integer.parseInt(args[1]);
            RemoteExecutor remoteExecutor = (RemoteExecutor) registry.lookup(name);
            RefService refService = new RefServiceRemote(remoteExecutor);
            long successCount = 0;
            long failedCount = 0;
            System.out.println("Started: " + System.nanoTime());
            for (int i = 0; i < count; i ++) {
                String code = String.valueOf(i);
                char key = 'a';
                String value = refService.getValue(code, key);
                if ((code+key).equals(value)) {
                    successCount++;
                } else {
                    failedCount++;
                }
                if (i % 100_000 == 0) {
                    System.out.println(i + " Processed " + System.nanoTime());
                }
            }
            System.out.println("Finished: " + System.nanoTime());
            System.out.println("Succeed : " + successCount);
            System.out.println("Failed  : " + failedCount);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
