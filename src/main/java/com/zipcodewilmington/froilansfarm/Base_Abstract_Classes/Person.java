package com.zipcodewilmington.froilansfarm.Base_Abstract_Classes;

import com.zipcodewilmington.froilansfarm.Interfaces.Eater;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.Interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.Interfaces.Rider;

public abstract class Person implements Rider, Eater, NoiseMaker{
    private String name;
    protected Rideable currentlyRiding; // Protected so subclasses can access if needed

    public Person() {
        this.currentlyRiding = null;
    }

    public Person(String name) {
        this.name = name;
        this.currentlyRiding = null;
    }

    // Common riding implementation
    @Override
    public void mount(Rideable rideable) {
        if (currentlyRiding == null && !rideable.isOccupied()) {
            currentlyRiding = rideable;
            rideable.setRider(this); // Coordinate with the rideable
        }
    }

    @Override
    public void dismount(Rideable rideable) {
        if (currentlyRiding == rideable) { // Verify we're dismounting the right thing
            currentlyRiding = null;
            rideable.setRider(null); // Clear the rideable's rider
        }
    }

    // Common eating behavior
    @Override
    public void eat(Edible object) {
        System.out.println(getName() + " is eating a " + object);
    }

    // Common greeting - can be overridden by subclasses
    @Override
    public void makeNoise() {
        System.out.println("Hello!");
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rideable getCurrentlyRiding() {
        return currentlyRiding;
    }

    public boolean isRiding() {
        return currentlyRiding != null;
    }
}