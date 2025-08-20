package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Animal;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.Interfaces.Rider;

public class Horse extends Animal implements Rideable {
    private Rider rider;

    // Animal
    @Override
    public void makeNoise() {
        System.out.println("Neigh");
    }

    @Override
    public void eat(Edible object) {
        System.out.println("Horse is eating.");
    }

    // Rideable
    @Override
    public void setRider(Rider rider) {
        this.rider = rider;
    }

    @Override
    public Rider getRider() {
        return rider;
    }


    @Override
    public boolean isOccupied() {
        return rider != null;
    }
    
}
