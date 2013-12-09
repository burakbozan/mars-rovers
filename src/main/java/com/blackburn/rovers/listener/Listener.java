package com.blackburn.rovers.listener;

import com.blackburn.rovers.exception.OutOfPlateauException;

public interface Listener {
    void change(ChangeEvent event) throws OutOfPlateauException;
}
