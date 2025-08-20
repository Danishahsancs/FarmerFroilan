package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Person;

public class Pilot extends Person {

    public Pilot(String name) {
        super(name); // Use parent constructor
    }

    @Override
    public void makeNoise() {
        System.out.println(getName() + " says: Ready for takeoff!");
    }
}