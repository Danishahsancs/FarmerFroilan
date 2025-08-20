package com.zipcodewilmington.froilansfarm.Base_Abstract_Classes;

import com.zipcodewilmington.froilansfarm.Interfaces.Eater;
import com.zipcodewilmington.froilansfarm.Interfaces.NoiseMaker;

public abstract  class Animal implements NoiseMaker, Eater {

    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }  
}
