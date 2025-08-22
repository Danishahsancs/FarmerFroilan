package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;

public class CropDusterTest {

    Croprow fertCroprow;
    CropDuster duster;

    @BeforeEach
    void setup() {
        fertCroprow = new Croprow();
        duster = new CropDuster();

        fertCroprow.addCrop(new Cornstalk());
        fertCroprow.addCrop(new TomatoPlant());
        fertCroprow.addCrop(new Cornstalk());
        fertCroprow.addCrop(new TomatoPlant());
    }

    @Test
    void testCropRowNotFertilizedInitially() {
        for (Crops crop : fertCroprow.getCrops()) {
            assertFalse(crop.hasBeenFertilized());
        }
    }

    @Test
    void testCropRowFertilizedByCropDuster() {
        duster.fertilizeCropRow(fertCroprow);
        for (Crops crop : fertCroprow.getCrops()) {
            assertTrue(crop.hasBeenFertilized());
        }
    }

    @Test
    void testCropDustermakenoise() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        duster.makeNoise();

        String output = outContent.toString().trim();
        assertEquals("NYOOOOOMMM", output);

        System.setOut(originalOut);
    }
}
