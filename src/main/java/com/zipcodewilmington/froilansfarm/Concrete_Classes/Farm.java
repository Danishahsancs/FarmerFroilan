package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.util.ArrayList;


public class Farm {
    private Field field;
    private ArrayList<Stable> stables;
    private ArrayList<ChickenCoop> chickenCoops;
    FarmHouse farmHouse;

    public Farm() {
    this.field = new Field();
    this.stables = new ArrayList<>();
    this.chickenCoops = new ArrayList<>();
    this.farmHouse = new FarmHouse();
}


    public ArrayList<Stable> getStables() {
        return stables;
    }

    public FarmHouse getFarmHouse() {
        return farmHouse;
    }

    public ArrayList<ChickenCoop> getChickenCoops() {
        return chickenCoops;
    }
    public Field getField() {
        return field;
    }
}
