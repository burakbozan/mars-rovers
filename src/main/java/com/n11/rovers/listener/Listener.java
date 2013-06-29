package com.n11.rovers.listener;

import com.n11.rovers.exception.OutOfPlateauException;

public interface Listener {
    void change(ChangeEvent event) throws OutOfPlateauException;
}
