package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Abstract_Classes.Crops;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CroprowTest {

    private Croprow croprow;

    @BeforeEach
    void setup() {
        croprow = new Croprow();
    }

    @Test
    void testAddCropIncreasesSize() {
        assertEquals(0, croprow.getCrops().size()); // initially empty

        croprow.addCrop(new Cornstalk());
        assertEquals(1, croprow.getCrops().size());

        croprow.addCrop(new TomatoPlant());
        assertEquals(2, croprow.getCrops().size());
    }

    @Test
    void testGetCropsReturnsCorrectCrops() {
        Cornstalk corn = new Cornstalk();
        TomatoPlant tomato = new TomatoPlant();

        croprow.addCrop(corn);
        croprow.addCrop(tomato);

        List<Crops> crops = croprow.getCrops();

        assertTrue(crops.contains(corn));
        assertTrue(crops.contains(tomato));
    }

    @Test
    void testGetCropsIsNotNull() {
        assertNotNull(croprow.getCrops());
    }

    @Test
    void testAddMultipleSameTypeCrops() {
        Cornstalk corn1 = new Cornstalk();
        Cornstalk corn2 = new Cornstalk();

        croprow.addCrop(corn1);
        croprow.addCrop(corn2);

        assertEquals(2, croprow.getCrops().size());
        assertSame(corn1, croprow.getCrops().get(0));
        assertSame(corn2, croprow.getCrops().get(1));
    }
}

