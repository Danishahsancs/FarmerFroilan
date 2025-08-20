package com.zipcodewilmington.froilansfarm.Base_Abstract_Classes;

import java.util.ArrayList;

public abstract class Shelter<T> {
    private ArrayList<T> residents;
    private String shelterType;

    public Shelter(String shelterType) {
        this.residents = new ArrayList<>(); 
        this.shelterType = shelterType;
    }

    public ArrayList<T> getResidents() {
        return residents;
    }

    public void addResident(T res) {
        residents.add(res);
    }

    public void removeResident(T res) {
        if (!residents.contains(res)) {
            System.out.println();
        } else {
            residents.remove(res);
        }
    }

    public void setShelterType(String shelterType) {
        this.shelterType = shelterType;
    }

    public String getShelterType() {
        return shelterType;
    }
}
