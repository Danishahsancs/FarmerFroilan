package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;

public class Croprow {
    private List<Crops> crops = new ArrayList<>();

    //add a crop to the row
    public void addCrop(Crops crop) {
        crops.add(crop);
    }
    // get crops in row
    public List<Crops> getCrops() {
        return crops;
    }
}
