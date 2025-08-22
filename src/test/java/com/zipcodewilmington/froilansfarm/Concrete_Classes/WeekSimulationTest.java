package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WeekSimulationTest {

    Farm farm;
    Farmer froilan;
    Pilot froilanda;

    @BeforeEach
    void setup() {
        farm = new Farm();

        froilan = new Farmer("Froilan");
        froilanda = new Pilot("Froilanda");

        // Setup 5 CropRows
        for (int i = 0; i < 5; i++) {
            farm.getField().addCropRow(new Croprow());
        }

        // Setup 3 Stables with 10 horses total
        int horseCounter = 0;
        for (int i = 0; i < 3; i++) {
            Stable stable = new Stable();
            farm.getStables().add(stable);
            while (stable.getResidents().size() < 3 && horseCounter < 10) {
                stable.addResident(new Horse());
                horseCounter++;
            }
        }

        // Setup 4 ChickenCoops with 15 chickens
        int chickenCounter = 0;
        for (int i = 0; i < 4; i++) {
            ChickenCoop coop = new ChickenCoop();
            farm.getChickenCoops().add(coop);
            while (coop.getResidents().size() < 4 && chickenCounter < 15) {
                coop.addResident(new Chicken());
                chickenCounter++;
            }
        }
    }

    // Helper: Daily routine (riding, feeding, breakfast)
    void performDailyRoutine() {
        // Ride all horses
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getResidents()) {
                froilan.mount(horse);
                assertTrue(horse.isOccupied());
                froilan.dismount(horse);
                assertFalse(horse.isOccupied());
            }
        }

        // Feed each horse 3 Earcorn
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getResidents()) {
                for (int i = 0; i < 3; i++) {
                    horse.eat(new Earcorn());
                }
            }
        }

        // Breakfast
        // Froilan eats: 1 Corn, 2 Tomato, 5 Egg
        froilan.eat(new Earcorn());
        froilan.eat(new Tomato());
        froilan.eat(new Tomato());
        for (int i = 0; i < 5; i++) {
            froilan.eat(new EdibleEgg());
        }

        // Froilanda eats: 2 Corn, 1 Tomato, 2 Egg
        froilanda.eat(new Earcorn());
        froilanda.eat(new Earcorn());
        froilanda.eat(new Tomato());
        froilanda.eat(new EdibleEgg());
        froilanda.eat(new EdibleEgg());
    }

    @Test
    void simulateWeek() {
        // ===== SUNDAY =====
        performDailyRoutine();
        Croprow row1 = farm.getField().getCropRows().get(0);
        Croprow row2 = farm.getField().getCropRows().get(1);
        Croprow row3 = farm.getField().getCropRows().get(2);
        froilan.plantCropSafely(new Cornstalk(), row1);
        froilan.plantCropSafely(new TomatoPlant(), row2);
        froilan.plantCropSafely(new Cornstalk(), row3);
        assertEquals(1, row1.getCrops().size());
        assertEquals(1, row2.getCrops().size());
        assertEquals(1, row3.getCrops().size());

        // ===== MONDAY =====
        performDailyRoutine();
        CropDuster duster = new CropDuster();
        for (Croprow row : farm.getField().getCropRows()) {
            duster.fertilizeCropRow(row);
        }
        for (Croprow row : farm.getField().getCropRows()) {
            for (Crops crop : row.getCrops()) {
                assertTrue(crop.hasBeenFertilized());
            }
        }

        // ===== TUESDAY =====
        performDailyRoutine();
        Tractor tractor = new Tractor();
        List<Edible> harvest = tractor.harvest(farm.getField());
        assertTrue(harvest.size() > 0);

        // ===== WEDNESDAY =====
        performDailyRoutine();
        // Maybe Froilan plants more crops
        froilan.plantCropSafely(new TomatoPlant(), row1);
        froilan.plantCropSafely(new Cornstalk(), row2);
        assertTrue(row1.getCrops().size() >= 1);
        assertTrue(row2.getCrops().size() >= 1);

        // ===== THURSDAY =====
        performDailyRoutine();
        // Froilanda flies CropDuster again
        for (Croprow row : farm.getField().getCropRows()) {
            duster.fertilizeCropRow(row);
        }

        // ===== FRIDAY =====
        performDailyRoutine();
        // Tractor harvests again
        List<Edible> harvestFriday = tractor.harvest(farm.getField());
        assertNotNull(harvestFriday);

        // ===== SATURDAY =====
        performDailyRoutine();
        // Free day? Just check Froilan/Froilanda alive & making noise
        froilan.makeNoise();
        froilanda.makeNoise();
        assertEquals("Froilan", froilan.getName());
        assertEquals("Froilanda", froilanda.getName());
    }
}
