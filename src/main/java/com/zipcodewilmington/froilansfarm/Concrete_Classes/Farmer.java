package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Person;
import com.zipcodewilmington.froilansfarm.Interfaces.Botanist;

public class Farmer extends Person implements Botanist {

    public Farmer(String name) {
        super(name); // Use parent constructor
    }

    @Override
    public void plant(Crops crop) {
        System.out.println(getName() + " is planting " + crop);
        // TODO: Implement actual planting logic
    }

    // Option 5: Smart planting with validation
    public boolean plantCropSafely(Crops crop, Croprow cropRow) {
        // Validation: Check for null crop
        if (crop == null) {
            System.out.println(getName() + " cannot plant a null crop!");
            return false;
        }
        
        // Validation: Check for null crop row
        if (cropRow == null) {
            System.out.println(getName() + " needs a crop row to plant in!");
            return false;
        }
        
        // Step 1: Call the interface method (fulfills Botanist contract)
        plant(crop);
        
        // Step 2: Actually place the crop in the field
        cropRow.addCrop(crop);
        
        System.out.println(getName() + " successfully planted " + crop.getClass().getSimpleName() + " in the crop row!");
        return true;
    }

    @Override
    public void makeNoise() {
        System.out.println(getName() + " says: Time to get to work!");
    }
}