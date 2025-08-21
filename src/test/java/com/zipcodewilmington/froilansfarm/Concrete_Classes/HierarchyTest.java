package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Animal;
import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Person;
import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Shelter;
import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Vehicle;
import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import com.zipcodewilmington.froilansfarm.Abstract_Classes.Aircraft;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Interfaces.Produce;
import com.zipcodewilmington.froilansfarm.Interfaces.Rideable;

public class HierarchyTest {

    // Animal hierarchy
    @Test
    void testChickenIsAnimal() {
        Chicken chicken = new Chicken();
        assertInstanceOf(Animal.class, chicken);
    }

    @Test
    void testHorseIsAnimal() {
        Horse horse = new Horse();
        assertInstanceOf(Animal.class, horse);
    }

    @Test
    void testChickenIsNotPerson() {
        Chicken chicken = new Chicken();
        assertFalse((Object)chicken instanceof Person);
    }

    @Test
    void testHorseIsNotPerson() {
        Horse horse = new Horse();
        assertFalse((Object)horse instanceof Person);
    }

    // Person hierarchy
    @Test
    void testFarmerIsPerson() {
        Farmer farmer = new Farmer("Froilan");
        assertInstanceOf(Person.class, farmer);
    }

    @Test
    void testPilotIsPerson() {
        Pilot pilot = new Pilot("Froilanda");
        assertInstanceOf(Person.class, pilot);
    }

    @Test
    void testFarmerIsNotAnimal() {
        Farmer farmer = new Farmer("Froilan");
        assertFalse((Object)farmer instanceof Animal);
    }

    @Test
    void testPilotIsNotAnimal() {
        Pilot pilot = new Pilot("Froilanda");
        assertFalse((Object)pilot instanceof Animal);
    }

    // Shelter hierarchy
    @Test
    void testChickenCoopIsShelter() {
        ChickenCoop coop = new ChickenCoop();
        assertInstanceOf(Shelter.class, coop);
    }

    @Test
    void testStableIsShelter() {
        Stable stable = new Stable();
        assertInstanceOf(Shelter.class, stable);
    }

    @Test
    void testFarmHouseIsShelter() {
        FarmHouse house = new FarmHouse();
        assertInstanceOf(Shelter.class, house);
    }

    @Test
    void testStableIsNotAnimal() {
        Stable stable = new Stable();
        assertFalse((Object)stable instanceof Animal);
    }

    // Vehicle hierarchy
    @Test
    void testTractorIsVehicle() {
        Tractor tractor = new Tractor();
        assertInstanceOf(Vehicle.class, tractor);
    }

    @Test
    void testCropDusterIsVehicle() {
        CropDuster duster = new CropDuster();
        assertInstanceOf(Vehicle.class, duster);
    }

    @Test
    void testHorseIsRideable() {
        Horse horse = new Horse();
        assertInstanceOf(Rideable.class, horse);
    }

    @Test
    void testTractorIsNotAircraft() {
        Tractor tractor = new Tractor();
        assertFalse((Object)tractor instanceof Aircraft);
    }

    @Test
    void testCropDusterIsAircraft() {
        CropDuster duster = new CropDuster();
        assertInstanceOf(Aircraft.class, duster);
    }

    @Test
    void testCropDusterIsNotAnimal() {
        CropDuster duster = new CropDuster();
        assertFalse((Object)duster instanceof Animal);
    }

    // Crop hierarchy
    @Test
    void testCornstalkIsCropsAndProduce() {
        Cornstalk corn = new Cornstalk();
        assertInstanceOf(Crops.class, corn);
        assertInstanceOf(Produce.class, corn);
    }

    @Test
    void testTomatoPlantIsCropsAndProduce() {
        TomatoPlant tomatoPlant = new TomatoPlant();
        assertInstanceOf(Crops.class, tomatoPlant);
        assertInstanceOf(Produce.class, tomatoPlant);
    }

    @Test
    void testCornstalkIsNotEdible() {
        Cornstalk corn = new Cornstalk();
        assertFalse(corn instanceof Edible);
    }

    // Edible products
    @Test
    void testEarcornIsEdible() {
        Earcorn corn = new Earcorn();
        assertInstanceOf(Edible.class, corn);
    }

    @Test
    void testTomatoIsEdible() {
        Tomato tomato = new Tomato();
        assertInstanceOf(Edible.class, tomato);
    }

    @Test
    void testEdibleEggIsEdible() {
        EdibleEgg egg = new EdibleEgg();
        assertInstanceOf(Edible.class, egg);
    }

    @Test
    void testEdibleEggIsNotAnimal() {
        EdibleEgg egg = new EdibleEgg();
        assertFalse((Object)egg instanceof Animal);
    }
}
