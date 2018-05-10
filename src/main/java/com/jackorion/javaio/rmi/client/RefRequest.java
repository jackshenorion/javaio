package com.jackorion.javaio.rmi.client;

import com.jackorion.javaio.rmi.remote.Request;

import java.io.Serializable;

public class RefRequest implements Request, Serializable {

    private String name;
    private String input;

    public RefRequest(String name, String input) {
        this.name = name;
        this.input = input;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInput() {
        return input;
    }
}
