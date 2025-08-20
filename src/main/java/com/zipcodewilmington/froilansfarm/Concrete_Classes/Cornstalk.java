package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

public class Cornstalk extends Crops {
    private boolean hasBeenFertilized;

    @Override
    public Edible yield() {
        if (hasBeenFertilized() && hasBeenHarvested()) {
            return new Earcorn();
        }
        return null; // no ear corn produced
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
