package com.zipcodewilmington.froilansfarm.Interfaces;

public interface Rideable {
    void setRider(Rider rider);
    Rider getRider();
    boolean isOccupied();
}
