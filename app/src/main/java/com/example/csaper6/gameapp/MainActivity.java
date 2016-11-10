package com.example.csaper6.gameapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button hit; //will deal another card to player
    private Button stay; //will add card values of both and announce winner
    private Button newGame;
    private int pointTotal; //how many times player has won
    private TextView playerCard1;
    private TextView playerCard2;
    private TextView playerCard3;
    private TextView playerCard4;
    private TextView playerCard5;
    private TextView playerCard6;
    private TextView playerCard7;
    private TextView playerCard8;
    private TextView playerCard9;
    private TextView playerCard10;
    private TextView playerCard11;
    private TextView playerCard12;
    private TextView dealerCard1;
    private TextView dealerCard2;
    private TextView dealerCard3;
    private TextView dealerCard4;
    private TextView point;
    private ArrayList<TextView> display;
    private ArrayList<TextView> dealerDisplay;
    private Hand playerHand;
    private Hand dealerHand;
    private Deck d;


    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pointTotal = 0;
        playerHand = new Hand();
        dealerHand = new Hand();
        display = new ArrayList<>();
        dealerDisplay = new ArrayList<>();

        hit = (Button) findViewById(R.id.button_hit);
        stay = (Button) findViewById(R.id.button_stay);
        newGame = (Button) findViewById(R.id.button_ng);
        playerCard1 = (TextView) findViewById(R.id.textView_pcard1);
        playerCard2 = (TextView) findViewById(R.id.textView_pcard2);
        playerCard3 = (TextView) findViewById(R.id.textView_pcard3);
        playerCard4 = (TextView) findViewById(R.id.textView_pcard4);
        playerCard5 = (TextView) findViewById(R.id.textView_pcard5);
        playerCard6 = (TextView) findViewById(R.id.textView_pcard6);
        playerCard7 = (TextView) findViewById(R.id.textView_pcard7);
        playerCard8 = (TextView) findViewById(R.id.textView_pcard8);
        playerCard9 = (TextView) findViewById(R.id.textView_pcard9);
        playerCard10 = (TextView) findViewById(R.id.textView_pcard10);
        playerCard11 = (TextView) findViewById(R.id.textView_pcard11);
        playerCard12 = (TextView) findViewById(R.id.textView_pcard12);
        dealerCard1 = (TextView) findViewById(R.id.textView_dcard1);
        dealerCard2 = (TextView) findViewById(R.id.textView_dcard2);
        dealerCard3 = (TextView) findViewById(R.id.textView_dcard3);
        dealerCard4 = (TextView) findViewById(R.id.textView_dcard4);
        point = (TextView) findViewById(R.id.textView_points);

        display.add(playerCard1);
        display.add(playerCard2);
        display.add(playerCard3);
        display.add(playerCard4);
        display.add(playerCard5);
        display.add(playerCard6);
        display.add(playerCard7);
        display.add(playerCard8);
        display.add(playerCard9);
        display.add(playerCard10);
        display.add(playerCard11);
        display.add(playerCard12);
        dealerDisplay.add(dealerCard1);
        dealerDisplay.add(dealerCard2);
        dealerDisplay.add(dealerCard3);
        dealerDisplay.add(dealerCard4);


        makeDeck();
        setBlank();
        setDealerBlank();
        updateDisplay();



        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerHand.addCard(d);
                updateDisplay();
                Log.d("", "onClick: " + dealerHand.totalValue() + "  " + playerHand.totalValue() );
                if (playerHand.totalValue() >= 22) {
                    Toast.makeText(MainActivity.this, "You Bust!",
                            Toast.LENGTH_SHORT).show();
                    updateFinalDisplay();
                    playerHand.empty();
                    dealerHand.empty();
                    stay.setEnabled(false);
                    hit.setEnabled(false);

                }

            }
        });
        stay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDealerHand();
                updateDisplay();
                hit.setEnabled(false);
                updateFinalDisplay();
                Log.d("", "onClick: " + dealerHand.totalValue() + "  " + playerHand.totalValue() );
                if (playerHand.totalValue() >= dealerHand.totalValue() && playerHand.totalValue() <= 21) {
                    pointTotal++;
                    point.setText("Points: " + pointTotal);
                    Toast.makeText(MainActivity.this, "You Win!",
                            Toast.LENGTH_SHORT).show();
                    playerHand.empty();
                    dealerHand.empty();
                    Log.d("", "onClick: " + dealerHand.totalValue() + "  " + playerHand.totalValue() );
                    stay.setEnabled(false);
                } else {
                    Toast.makeText(MainActivity.this, "You Lost!",
                        Toast.LENGTH_SHORT).show();
                    playerHand.empty();
                    dealerHand.empty();
                    stay.setEnabled(false);
                }

            }
        });

        newGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setBlank();
                setDealerBlank();
                makeDeck();
                updateDisplay();
                stay.setEnabled(true);
                hit.setEnabled(true);
            }

        });





    }




    private void makeDeck() {
        d = new Deck();
        d.shuffle();
        playerHand = new Hand();
        dealerHand = new Hand();
        playerHand.addCard(d);
        dealerHand.addCard(d);
        playerHand.addCard(d);
        dealerHand.addCard(d);

        //TODO: comment out and go through one card at a time to check total values and card values
    }

    public void updateDisplay() {
        for (int b = 0; b < dealerHand.size(); b++) {
            if (b == 1) {
                dealerDisplay.get(b).setText("******");
            } else {
                dealerDisplay.get(b).setText("" + dealerHand.getCard(b).getView());
            }


            for (int i = 0; i < playerHand.size(); i++) {
                display.get(i).setText("" + playerHand.getCard(i).getView());

            }

        }
    }

    public void updateFinalDisplay() {
        for (int b = 0; b < dealerHand.size(); b++) {

            dealerDisplay.get(b).setText("" + dealerHand.getCard(b).getView());}




    }

    public void setBlank() {
        for(int y = 0; y < 12; y++) {
            display.get(y).setText("");


        }

    }
    public void setDealerBlank() {
        for(int y = 0; y < 4; y++) {
            dealerDisplay.get(y).setText("");


        }

    }


    public void updateDealerHand()
    {
        while(dealerHand.totalValue() <= 16)
        {

            dealerHand.addCard(d);
        }
        if(dealerHand.totalValue() >= 22){
            pointTotal++;
            updateFinalDisplay();
            point.setText("Points: " + pointTotal);
            Toast.makeText(MainActivity.this, "Dealer Busts.",
                    Toast.LENGTH_SHORT).show();
            playerHand.empty();
            dealerHand.empty();
            Log.d("", "onClick: " + dealerHand.totalValue() + "  " + playerHand.totalValue() );
            stay.setEnabled(false);

        }
    }


}
