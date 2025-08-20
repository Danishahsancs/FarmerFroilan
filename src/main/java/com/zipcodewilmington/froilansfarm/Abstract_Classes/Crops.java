package com.zipcodewilmington.froilansfarm.Abstract_Classes;

import com.zipcodewilmington.froilansfarm.Interfaces.Produce;

public abstract class Crops implements Produce {

    private boolean hasBeenHarvested;
   
    public boolean hasBeenHarvested() {
        return hasBeenHarvested;
    }

    public void harvest() {
        hasBeenHarvested = true;
    }
}
