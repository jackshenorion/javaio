package com.jackorion.javaio.rmi.ref;

public interface RefService {
    String getValue(String code, char key);
    void updateValue(String code, char key, String newValue);
}
