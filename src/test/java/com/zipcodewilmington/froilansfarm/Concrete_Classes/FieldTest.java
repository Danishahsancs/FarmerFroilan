package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FieldTest {
     @Test
    public void testAddAndGetCropRows() {
        Field field = new Field();
        Croprow cropRow = new Croprow(); // assuming Croprow has a default constructor

        // add crop row to field
        field.addCropRow(cropRow);

        // get crop rows back
        List<Croprow> rows = field.getCropRows();

        // check that it contains the row
        assertEquals(1, rows.size());   // only one should be there
        assertTrue(rows.contains(cropRow)); // and it should be the same one
    }
}
