package com.myapps.data;

/**
 * Created by bernatgomez on 23/4/17.
 */

public class PadelClub extends BaseModel {

    private String name;
    private int rating;
    private float distance;
    private Type type;

    public PadelClub() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    static enum Type {INDOOR, OUTDOOR};
}
