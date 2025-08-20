package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Aircraft;

public class CropDuster extends Aircraft {

    public CropDuster() {
        super(); // Calls Vehicle constructor
    }

    public void fertilizeCropRow(Croprow cropRow) {
        // TODO: Implement when CropRow class is setup
        System.out.println("Fertilizing crop row");
    }

    @Override
    public void makeNoise() {
        System.out.println("NYOOOOOMMM");
    }
}