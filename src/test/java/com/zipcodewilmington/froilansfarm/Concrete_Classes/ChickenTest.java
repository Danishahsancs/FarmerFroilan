package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Animal;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChickenTest {
 @Test
    public void testChickenIsAnimal() {
        Chicken chicken = new Chicken();
        assertTrue(chicken instanceof Animal, "Chicken should be a subclass of Animal");
    }
    

}
