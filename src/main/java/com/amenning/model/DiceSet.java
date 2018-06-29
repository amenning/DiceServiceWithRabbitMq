package com.amenning.model;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class DiceSet {
    private int numberOfDice;
    private int numberOfFaces;
    private ArrayList<Dice> diceSet;

    public DiceSet(int numberOfDice, int numberOfFaces) {
        this.numberOfDice = numberOfDice;
        this.numberOfFaces = numberOfFaces;
        createDice();
        generateDiceValues();
    }

    private void createDice() {
        diceSet = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++) {
            diceSet.add(new Dice(numberOfFaces));
        }
    }

    private void generateDiceValues() {
        for (Dice dice : diceSet) {
            dice.setValue(
                ThreadLocalRandom.current()
                    .nextInt(1, dice.getNumberOfFaces() + 1)
            );
            System.out.println(dice.getValue());
        }
    }

    public ArrayList<Dice> getDiceSet() {
        return diceSet;
    }
}
