package com.example.w22comp1008lhw3;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    private ArrayList<Card> deck;

    /**
     * This is the constructor for the card class.
     * We do not have any unique configurations, so we do not need any arguments
     */
    public DeckOfCards()
    {
        //initialize the ArrayList
        deck = new ArrayList<>();

        for (String suit : Card.getValidSuits())
        {
            for (String faceName : Card.getValidFaceNames()) {
                Card newCard = new Card(faceName,suit);
                deck.add(newCard);
            }
        }
    }

    /**
     * This method will deal the top card from the deck
     */
    public Card dealTopCard()
    {
        //check if any cards are left in the deck and return the top card
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * This method will shuffle the deck
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }
}
