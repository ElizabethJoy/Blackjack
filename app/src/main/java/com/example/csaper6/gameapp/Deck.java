package com.example.csaper6.gameapp;


import android.util.Log;

import java.util.ArrayList;

public class Deck {
    //array of arraylists(aka suits of cards)
    //draw method to remove a card from a suit
    //reset method to put all cards back
    //erase
    private ArrayList<Card> deck;
    private ArrayList<Card> inUse;



    public Deck() {
        makeDeck();

    }

    public void makeDeck() {
        deck = new ArrayList<Card>();
        inUse = new ArrayList<Card>();
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13 ; rank++) {
                Card c = new Card(suit, rank);
                deck.add(c);
                Log.d("", c.toString());
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> deckA = new ArrayList<Card>();
         for(int d = 1; d<=52; d++) {
             deckA.add(deck.remove((int) (Math.random() * deck.size())));
         }
         deck = deckA;
    }

    public Card drawCard() {
        Card x = deck.remove(0);
        inUse.add(x);
        return x;
    }
}

