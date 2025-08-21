package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Animal;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Interfaces.Produce;

public class Chicken extends Animal implements Produce {
    private boolean hasBeenFertilized;

    @Override
    public void makeNoise() {
       System.out.println("Cluck");
    }

    @Override
    public void eat(Edible object) {
        // chicken eats edible object
        System.out.println("Chicken is pecking at the food.");
    }

    @Override
    public Edible yield() {
        return new EdibleEgg(); // return an EdibleEgg object
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
