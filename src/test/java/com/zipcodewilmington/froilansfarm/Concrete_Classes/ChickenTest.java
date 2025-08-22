package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

public class ChickenTest {
 
    @Test
    public void testMakeNoise() {
        
        Chicken chicken = new Chicken();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        chicken.makeNoise();

        assertEquals("Cluck\n", outContent.toString());
    }

    @Test
    public void testEat() {
        Chicken chicken = new Chicken();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Edible food = new Edible() {};

        chicken.eat(food);

        assertEquals("Chicken is pecking at the food.\n", outContent.toString());
    }

     @Test
    public void testYieldBeforeFertilization() {
        Chicken chicken = new Chicken();
        assertNull(chicken.yield(), "Yield should be null if not fertilized");
    }

    @Test
    public void testHasBeenFertilizedFlag() {
        
        Chicken chicken = new Chicken();
       
        chicken.fertilize();
        assertTrue(chicken.hasBeenFertilized(), "Should be fertilized after calling fertilize()");
    }

}
