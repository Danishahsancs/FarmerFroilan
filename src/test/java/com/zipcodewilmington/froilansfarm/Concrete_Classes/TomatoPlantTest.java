package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

public class TomatoPlantTest {

    @Test
    public void testYield() {
        TomatoPlant tomatoPlant = new TomatoPlant();
        tomatoPlant.fertilize();
        tomatoPlant.harvest();
        Edible tomato = tomatoPlant.yield();
        assertNotNull(tomato);
        assertTrue(tomato instanceof Tomato);
    }

}
