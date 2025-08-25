package com.zipcodewilmington.froilansfarm;

import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Person;
import com.zipcodewilmington.froilansfarm.Concrete_Classes.*;
import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

import java.util.*;

public class MainApplication {

    // Pantry to hold harvested food
    private static Map<Class<? extends Edible>, Integer> pantry = new HashMap<>();

    public static void main(String[] args) {
        Farm farm = new Farm();
        Farmer froilan = new Farmer("Froilan");
        Pilot froilanda = new Pilot("Froilanda");

        // Add crop rows
        for (int i = 0; i < 5; i++) {
            farm.getField().addCropRow(new Croprow());
        }

        // Add horses
        int horseCounter = 0;
        Stable stable = null;
        for (int i = 0; i < 3; i++) {
            stable = new Stable();
            farm.getStables().add(stable);
            while (stable.getResidents().size() < 3 && horseCounter <= 10) {
                stable.addResident(new Horse());
                horseCounter++;
            }
        }
        stable.addResident(new Horse());

        // Add chickens
        int chickenCounter = 0;
        for (int i = 0; i < 4; i++) {
            ChickenCoop coop = new ChickenCoop();
            farm.getChickenCoops().add(coop);
            while (coop.getResidents().size() < 4 && chickenCounter < 15) {
                coop.addResident(new Chicken());
                chickenCounter++;
            }
        }

        // Seed pantry with starting food (until first harvest)
        addToPantry(Earcorn.class, 250);
        addToPantry(Tomato.class, 30);
        addToPantry(EdibleEgg.class, 60);

        // Run week simulation
        System.out.println("=== WEEK SIMULATION START ===");

        runDay("SUNDAY", () -> {
            Croprow row1 = farm.getField().getCropRows().get(0);
            Croprow row2 = farm.getField().getCropRows().get(1);
            Croprow row3 = farm.getField().getCropRows().get(2);
            froilan.plantCropSafely(new Cornstalk(), row1);
            froilan.plantCropSafely(new TomatoPlant(), row2);
            froilan.plantCropSafely(new Cornstalk(), row3);
        }, farm, froilan, froilanda);

        runDay("MONDAY", () -> {
            CropDuster duster = new CropDuster();
            for (Croprow row : farm.getField().getCropRows()) {
                duster.fertilizeCropRow(row);
            }
        }, farm, froilan, froilanda);

        runDay("TUESDAY", () -> {
            Tractor tractor = new Tractor();
            List<Edible> harvest = tractor.harvest(farm.getField());
            for (Edible e : harvest) {
                addToPantry(e.getClass(), 1);
            }
        }, farm, froilan, froilanda);

        runDay("WEDNESDAY", () -> {
            // Froilan plants more crops
            Croprow row1 = farm.getField().getCropRows().get(0);
            Croprow row2 = farm.getField().getCropRows().get(1);
            froilan.plantCropSafely(new TomatoPlant(), row1);
            froilan.plantCropSafely(new Cornstalk(), row2);
        }, farm, froilan, froilanda);

        runDay("THURSDAY", () -> {
            CropDuster duster = new CropDuster();
            for (Croprow row : farm.getField().getCropRows()) {
                duster.fertilizeCropRow(row);
            }
        }, farm, froilan, froilanda);

        runDay("FRIDAY", () -> {
            Tractor tractor = new Tractor();
            List<Edible> harvest = tractor.harvest(farm.getField());
            for (Edible e : harvest) {
                addToPantry(e.getClass(), 1);
            }
        }, farm, froilan, froilanda);

        runDay("SATURDAY", () -> {
            froilan.makeNoise();
            froilanda.makeNoise();
        }, farm, froilan, froilanda);

        System.out.println("=== WEEK SIMULATION END ===");
        System.out.println("Final Pantry: ");
        printPantry();
    }

    // ---------- Utility Methods ----------

    private static void runDay(String day, Runnable uniqueAction, Farm farm, Farmer froilan, Pilot froilanda) {
        System.out.println("\n--- " + day + " ---");
        performDailyRoutine(farm, froilan, froilanda);
        uniqueAction.run();
        System.out.println("--- END OF " + day + " ---");
    }

    private static void performDailyRoutine(Farm farm, Farmer froilan, Pilot froilanda) {
        // Ride horses
        int i = 1;
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getResidents()) {
                froilan.mount(horse);
                System.out.println("Riding Horse" + i++);
                froilan.dismount(horse);
            }
        }

        System.out.println();

        // Feed horses 3 corn each
        int horseNum = 1;
        for (Stable stable : farm.getStables()) {
            for (Horse horse : stable.getResidents()) {
                for (i = 0; i < 3; i++) {
                    if (takeFromPantry(Earcorn.class)) {
                        System.out.print("#" + horseNum + " ");
                        horse.eat(new Earcorn());
                    } else {
                        System.out.println("⚠ Not enough corn to feed horse!");
                    }
                }
                horseNum++;
            }
        }

        System.out.println();

        // Breakfast
        // Froilan eats 1 Corn, 2 Tomato, 5 Eggs
        eatFromPantry(froilan, Earcorn.class, 1);
        eatFromPantry(froilan, Tomato.class, 2);
        eatFromPantry(froilan, EdibleEgg.class, 5);

        System.out.println();

        // Froilanda eats 2 Corn, 1 Tomato, 2 Eggs
        eatFromPantry(froilanda, Earcorn.class, 2);
        eatFromPantry(froilanda, Tomato.class, 1);
        eatFromPantry(froilanda, EdibleEgg.class, 2);

        System.out.println();

        System.out.println("Pantry after breakfast: ");
        printPantry();
    }

    private static void eatFromPantry(Person person, Class<? extends Edible> foodType, int amount) {
        for (int i = 0; i < amount; i++) {
            if (takeFromPantry(foodType)) {
                try {
                    person.eat(foodType.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(
                        "⚠ " + person.getName() + " couldn’t eat " + foodType.getSimpleName() + " (none left)");
            }
        }
    }

    private static void addToPantry(Class<? extends Edible> foodType, int count) {
        pantry.put(foodType, pantry.getOrDefault(foodType, 0) + count);
    }

    private static boolean takeFromPantry(Class<? extends Edible> foodType) {
        int current = pantry.getOrDefault(foodType, 0);
        if (current > 0) {
            pantry.put(foodType, current - 1);
            return true;
        }
        return false;
    }

    private static void printPantry() {
        System.out.println("=== Pantry Contents ===");
        if (pantry.isEmpty()) {
            System.out.println("Pantry is empty.");
            return;
        }
        for (Map.Entry<Class<? extends Edible>, Integer> entry : pantry.entrySet()) {
            System.out.println(entry.getKey().getSimpleName() + ": " + entry.getValue());
        }
        System.out.println("======================");
    }

}
