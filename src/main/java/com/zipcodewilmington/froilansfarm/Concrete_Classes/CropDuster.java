package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Aircraft;
import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;

public class CropDuster extends Aircraft {

    public CropDuster() {
        super();
    }

    public void fertilizeCropRow(Croprow cropRow) {
        System.out.println("NYOOOOOMMM - Flying over crops...");
        for (Crops crop : cropRow.getCrops()) {
            crop.fertilize();
        }
        System.out.println("Crop row fertilized from the air!");
    }


    @Override
    public void makeNoise() {
        System.out.println("NYOOOOOMMM");
    }
}