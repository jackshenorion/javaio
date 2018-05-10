package com.jackorion.javaio.rmi.ref;

public class RefServiceImpl implements RefService {
    @Override
    public String getValue(String code, char key) {
        return code + key;
    }

    @Override
    public void updateValue(String code, char key, String newValue) {
    }
}
