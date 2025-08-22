package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class FarmerTest {

    private Farmer farmer;
    private Croprow cropRow;

    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setup() {
        farmer = new Farmer("Froilan");
        cropRow = new Croprow();

        // Capture console output
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testFarmerHasName() {
        assertEquals("Froilan", farmer.getName());
    }

    @Test
    void testMakeNoise() {
        farmer.makeNoise();
        String output = outContent.toString().trim();
        assertTrue(output.contains("Time to get to work!"));
    }

    @Test
    void testPlantPrintsMessage() {
        Crops corn = new Cornstalk();
        farmer.plant(corn);
        String output = outContent.toString().trim();
        assertTrue(output.contains("planting"));
    }

    @Test
    void testPlantCropSafelyWithNullCrop() {
        boolean result = farmer.plantCropSafely(null, cropRow);
        assertFalse(result, "Farmer should not plant a null crop");
    }

    @Test
    void testPlantCropSafelyWithNullCropRow() {
        boolean result = farmer.plantCropSafely(new Cornstalk(), null);
        assertFalse(result, "Farmer should not plant in a null crop row");
    }

    @Test
    void testPlantCropSafelySuccess() {
        Crops corn = new Cornstalk();
        boolean result = farmer.plantCropSafely(corn, cropRow);

        assertTrue(result, "Farmer should successfully plant when inputs are valid");
        assertEquals(1, cropRow.getCrops().size(), "CropRow should contain the planted crop");
        assertEquals(corn, cropRow.getCrops().get(0), "The crop in the row should match the planted crop");
    }
}
