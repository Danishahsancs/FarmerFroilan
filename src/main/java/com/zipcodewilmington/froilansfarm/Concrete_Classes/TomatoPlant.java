package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

public class TomatoPlant extends Crops {
    private boolean hasBeenFertilized;

    @Override
    public Edible yield() {
        if (hasBeenFertilized() && hasBeenHarvested()) {
            return new Tomato();
        }
        return null; // no tomato produced
    }

    @Override
    public void fertilize() {
        hasBeenFertilized = true;
    }

    @Override
    public boolean hasBeenFertilized() {
        return hasBeenFertilized;
    }

}
