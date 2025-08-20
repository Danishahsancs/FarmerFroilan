package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

public class Cornstalk extends Crops {

    @Override
    public Edible yield() {
        if (hasBeenFertilized() && hasBeenHarvested()) {
            return new Earcorn();
        }
        return null; // no ear corn produced
    }
 
    
}
