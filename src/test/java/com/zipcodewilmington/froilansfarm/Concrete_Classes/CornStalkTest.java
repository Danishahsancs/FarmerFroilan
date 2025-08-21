package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.Interfaces.Edible;

import static org.junit.jupiter.api.Assertions.*;

public class CornStalkTest {

    @Test
    void testCornstalkNotFertilizedInitially() {
        Cornstalk cornstalk = new Cornstalk();
        assertFalse(cornstalk.hasBeenFertilized(), "New cornstalk should not be fertilized");
    }

    @Test
    void testFertilizeCornstalk() {
        Cornstalk cornstalk = new Cornstalk();
        cornstalk.fertilize();
        assertTrue(cornstalk.hasBeenFertilized(), "Cornstalk should be fertilized after calling fertilize()");
    }

    @Test
    void testYieldWhenFertilized() {
        Cornstalk cornstalk = new Cornstalk();
        cornstalk.fertilize();
        cornstalk.harvest();
        assertNotNull(cornstalk.yield(), "Fertilized cornstalk should yield earcorn");
        assertInstanceOf(Earcorn.class, cornstalk.yield());
    }

    @Test
    void testYieldWhenNotFertilized() {
        Cornstalk cornstalk = new Cornstalk();
        assertNull(cornstalk.yield(), "Non-fertilized cornstalk should not yield");
    }

    @Test
    void testMultipleYieldsProduceNewEarcorns() {
        Cornstalk cornstalk = new Cornstalk();
        cornstalk.fertilize();
        cornstalk.harvest(); // make sure yield works

        Edible first = cornstalk.yield();
        Edible second = cornstalk.yield();

        assertNotNull(first, "First yield should not be null");
        assertNotNull(second, "Second yield should not be null");
        assertNotSame(first, second, "Each yield() should produce a new Earcorn instance");
        assertInstanceOf(Earcorn.class, first, "Yield should be an Earcorn");
    }

    @Test
    void testNegativeCornstalkIsNotAnimal() {
        Object cornstalk = new Cornstalk();
        assertFalse(cornstalk instanceof com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Animal);
    }
}
