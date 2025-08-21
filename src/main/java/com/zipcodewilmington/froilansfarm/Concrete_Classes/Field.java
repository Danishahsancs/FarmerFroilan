package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Croprow> cropRows = new ArrayList<>();

    // add a crop row to the field
    public void addCropRow(Croprow cropRow) {
        cropRows.add(cropRow);
    }

    // get crop rows in the field
    public List<Croprow> getCropRows() {
        return cropRows;
    }
}
