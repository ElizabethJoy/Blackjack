package com.example.csaper6.gameapp;

/**
 * Created by csaper6 on 10/11/16.
 */
public class Card {
    //will hold cards and know their values
    private String[] displayValue = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private int[] realValue = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    private int suit;
    private int rank;

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        return realValue[rank - 1];
    }

    public String getView() {
        return displayValue[rank - 1];
    }

    public String toString(){
        return "Suit: " + suit + " Rank: " + rank;
    }




}
