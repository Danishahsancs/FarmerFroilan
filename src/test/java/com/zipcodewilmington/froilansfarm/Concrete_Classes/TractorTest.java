package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

public class TractorTest {
     @Test
    public void testMakeNoise() {

        Tractor tractor = new Tractor();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tractor.makeNoise();

        assertEquals("put-put-put\n", outContent.toString());
    }

    @Test
    public void testHarvest() {
        Tractor tractor = new Tractor();
        Field field = new Field();
        Croprow cropRow = new Croprow();
        TomatoPlant tomatoPlant = new TomatoPlant();
        tomatoPlant.fertilize();
        cropRow.addCrop(tomatoPlant);
        field.addCropRow(cropRow);

        List<Edible> harvested = tractor.harvest(field);

        assertEquals(1, harvested.size());
        assertTrue(harvested.get(0) instanceof Tomato);
    }

}
