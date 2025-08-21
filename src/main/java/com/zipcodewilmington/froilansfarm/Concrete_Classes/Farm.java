package com.zipcodewilmington.froilansfarm.Concrete_Classes;

import java.util.ArrayList;
import java.util.List;

import com.zipcodewilmington.froilansfarm.Base_Abstract_Classes.Shelter;

public class Farm {
    private Field field;
    private ArrayList<Stable> stables;
    private ArrayList<ChickenCoop> chickenCoops;
    FarmHouse farmHouse;

    public ArrayList<Stable> getStables() {
        return stables;
    }

    public FarmHouse getFarmHouse() {
        return farmHouse;
    }

    public ArrayList<ChickenCoop> getChickenCoops() {
        return chickenCoops;
    }

}
