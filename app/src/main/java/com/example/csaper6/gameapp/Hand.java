package com.example.csaper6.gameapp;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by csaper6 on 10/11/16.
 */
public class Hand {
    //hold player and dealer hands and make sure it appears on the screen
    private ArrayList<Card> inUse;





    public Hand() {
        inUse = new ArrayList<Card>();


    }


    public int totalValue() {
        int total = 0;
        int ace = 0;
        if (inUse.size() == 0) {
            return 0;
        }
        for (int a = 0; a < inUse.size(); a++) {
            Card c = inUse.get(a);
            if(c.getValue() == 1){
                ace++;
            }
            else{
                total += c.getValue();
            }

            Log.d("LOOK HERE", "c Value: " + c.getValue());

        }
        total = checkAce(total, ace);
        return total;
    }

    public int checkAce(int total, int ace){
        if(total<=10 && ace == 1){
            total += 11;
        }
        else if (total>=10 && ace > 1){
            total += ace;
        }
        else if (total<8 && ace > 1){
            total= total + ace + 10;
        }
        return total;
    }


    public void empty() {
        inUse.clear();
    }


    public void addCard(Deck d) {
        inUse.add(d.drawCard());
    }


    public int size() {
        return inUse.size();
    }

    public Card getCard(int location){
        return inUse.get(location);
    }
}
