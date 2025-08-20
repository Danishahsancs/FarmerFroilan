package com.zipcodewilmington.froilansfarm.Abstract_Classes;

import com.zipcodewilmington.froilansfarm.Interfaces.Produce;

public abstract class Crops implements Produce {

    private boolean hasBeenHarvested;
    private boolean hasBeenFertilized;

    public boolean hasBeenFertilized() {
        return hasBeenFertilized;
    }

    public void fertilize() {
        hasBeenFertilized = true;
    }

    public boolean hasBeenHarvested() {
        return hasBeenHarvested;
    }

    public void harvest() {
        hasBeenHarvested = true;
    }
}
