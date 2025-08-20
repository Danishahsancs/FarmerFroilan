package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Person;
import com.zipcodewilmington.froilansfarm.Interfaces.Botanist;

public class Farmer extends Person implements Botanist {

    public Farmer(String name) {
        super(name); // Use parent constructor
    }

    @Override
    public void plant(Crops crop) {
        System.out.println(getName() + " is planting " + crop);
        // TODO: Implement actual planting logic
    }

    @Override
    public void makeNoise() {
        System.out.println(getName() + " says: Time to get to work!");
    }
}