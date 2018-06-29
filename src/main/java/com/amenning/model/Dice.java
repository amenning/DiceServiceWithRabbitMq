package com.amenning.model;

public class Dice {
    private int numberOfFaces;
    private int value;

    public Dice(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int getNumberOfFaces() {
        return numberOfFaces;
    }

    public void setNumberOfFaces(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
