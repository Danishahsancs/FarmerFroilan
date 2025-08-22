package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import com.zipcodewilmington.froilansfarm.Abstract_Classes.FarmVehicle;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

public class Tractor extends FarmVehicle {

    public Tractor() {
        super();
    }

    @Override
    public void makeNoise() {
        System.out.println("put-put-put");
    }

    // 🚜 Harvest an entire CropRow and collect Edibles
    public List<Edible> harvest(Croprow cropRow) {
        List<Edible> harvestedFood = new ArrayList<>();

        for (Crops crop : cropRow.getCrops()) {
            crop.harvest(); // mark as harvested
            Edible food = crop.yield(); // collect food
            if (food != null) {
                harvestedFood.add(food);
            }
        }

        System.out.println("Tractor harvested " + harvestedFood.size() + " items from a crop row!");
        return harvestedFood;
    }

    //  Harvest the entire Field (all CropRows)
    public List<Edible> harvest(Field field) {
        List<Edible> totalHarvest = new ArrayList<>();

        for (Croprow row : field.getCropRows()) {
            totalHarvest.addAll(harvest(row)); // reuse row harvesting
        }

        System.out.println("Tractor finished harvesting the field. Total items: " + totalHarvest.size());
        return totalHarvest;
    }
}
