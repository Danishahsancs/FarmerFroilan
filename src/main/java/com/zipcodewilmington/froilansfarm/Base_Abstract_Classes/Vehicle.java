package com.zipcodewilmington.froilansfarm.Base_Abstract_Classes;

import com.zipcodewilmington.froilansfarm.Interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.Interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.Interfaces.Rider;

public abstract class Vehicle implements Rideable, NoiseMaker {
    protected Rider currentRider; 
    
    public Vehicle() {
        this.currentRider = null;
    }
    

    @Override
    public void setRider(Rider rider) {
        if (!isOccupied()) {
            currentRider = rider;
        }
    }

    @Override
    public Rider getRider() {
        return currentRider;
    }

    @Override
    public boolean isOccupied() {
        return currentRider != null;
    }
}