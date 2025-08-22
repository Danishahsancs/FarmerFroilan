package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FarmTest {

    private Farm farm;

    @BeforeEach
    void setup() {
        farm = new Farm();
    }

    @Test
    void testFarmNotNull() {
        assertNotNull(farm);
    }

    @Test
    void testFarmHasField() {
        assertNotNull(farm.getField(), "Farm should have a field");
    }

    @Test
    void testFarmHasStables() {
        assertNotNull(farm.getStables(), "Farm should have stables");
        assertTrue(farm.getStables().size() >= 0, "Farm should manage a list of stables");
    }

    @Test
    void testFarmHasCoops() {
        assertNotNull(farm.getChickenCoops(), "Farm should have coops");
        assertTrue(farm.getChickenCoops().size() >= 0, "Farm should manage a list of coops");
    }

    @Test
    void testFarmHasFarmHouse() {
        assertNotNull(farm.getFarmHouse(), "Farm should have a farmhouse");
    }

    @Test
    void testAddStableIncreasesCount() {
        int initialSize = farm.getStables().size();
        farm.getStables().add(new Stable());
        assertEquals(initialSize + 1, farm.getStables().size());
    }

    @Test
    void testAddCoopIncreasesCount() {
        int initialSize = farm.getChickenCoops().size();
        farm.getChickenCoops().add(new ChickenCoop());
        assertEquals(initialSize + 1, farm.getChickenCoops().size());
    }

    @Test
    void testFarmDoesNotContainRandomObject() {
        // negative test: make sure something unrelated is not in farm’s structures
        assertFalse(farm.getStables().contains(new ChickenCoop()), 
                    "ChickenCoop should not appear in stables");
    }
}
