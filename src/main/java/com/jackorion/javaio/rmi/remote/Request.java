package com.jackorion.javaio.rmi.remote;

import java.io.Serializable;

public interface Request extends Serializable {
    String getName();
    String getInput();
}
