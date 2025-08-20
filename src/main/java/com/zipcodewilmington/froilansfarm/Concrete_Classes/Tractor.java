package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.FarmVehicle;

public class Tractor extends FarmVehicle {
    
    public Tractor() {
        super(); // Calls Vehicle constructor
    }

    @Override
    public void makeNoise() {
        System.out.println("put-put-put");
    }
}