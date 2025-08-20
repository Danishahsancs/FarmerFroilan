package com.zipcodewilmington.froilansfarm.Base_Abstract_Classes;

import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

public abstract class Produce {
    private boolean hasBeenFertilized = false;

    public boolean hasBeenFertilized() {
        return hasBeenFertilized;
    }

    public void fertilize() {
        hasBeenFertilized = true;
    }

    public abstract Edible yield(); // Method that must be implemented by subclasses that returns an Edible object
}
