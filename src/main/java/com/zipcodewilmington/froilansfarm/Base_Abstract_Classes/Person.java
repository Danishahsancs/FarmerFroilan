package com.zipcodewilmington.froilansfarm.Base_Abstract_Classes;

import com.zipcodewilmington.froilansfarm.Interfaces.Eater;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Interfaces.NoiseMaker;
import com.zipcodewilmington.froilansfarm.Interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.Interfaces.Rider;

public abstract class Person implements Rider, Eater, NoiseMaker {

    String name;

    @Override
    public void makeNoise() {
    }

    @Override
    public void eat(Edible object) {
    }

    @Override
    public void mount(Rideable rideable) {
    }

    @Override
    public void dismount(Rideable rideable) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
