package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.zipcodewilmington.froilansfarm.Interfaces.Edible;
import com.zipcodewilmington.froilansfarm.Interfaces.Rideable;
import com.zipcodewilmington.froilansfarm.Interfaces.Rider;

public class HorseTest {

    @Test
    public void testMakenoise() {
        Horse horse = new Horse();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        horse.makeNoise();

        assertEquals("Neigh\n", outContent.toString());
    }

    @Test
    public void testEat() {
        Horse horse = new Horse();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Edible food = new Edible() {
        };

        horse.eat(food);

        assertEquals("Horse is eating.\n", outContent.toString());
    }

    @Test
    public void testMountandDimount(){
    Horse horse = new Horse();
    Rider rider = new Rider() {

        @Override
        public void mount(Rideable horse) {
            horse.setRider(this);

        }

        @Override
        public void dismount(Rideable horse) {
            horse.setRider(null);

        }
    };
    rider.mount (horse);
    assertEquals(rider, horse.getRider());
     assertEquals(true, horse.isOccupied());

    rider.dismount (horse);
    assertEquals(null, horse.getRider());
     assertEquals(false, horse.isOccupied());
}
}