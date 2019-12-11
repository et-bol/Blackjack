package Blackjack;

import java.util.*;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J"};
    private String[] suit = {"SPADE", "CLUB", "HEART", "DIAMOND"};
    public int deck_index = 0;

    public Deck(){
        for (String aSuit : suit) {
            for (String value : values) {
                this.deck.add(new Card(aSuit, value));
            }
        }
        shuffle_deck();
    }

    public Deck(int deck_count){
        for (int i = 0; i < deck_count; i++) {
            for (String aSuit : suit) {
                for (String value : values) {
                    this.deck.add(new Card(aSuit, value));
                }
            }
        }
        shuffle_deck();
    }

    public ArrayList<Card> get_deck(){
        return this.deck;
    }

    public Card draw_card(){
        Card card = deck.get(deck_index);
        deck_index += 1;
        return card;
    }

    public void shuffle_deck(){
        Collections.shuffle(this.deck);
    }

    public int length(){
        return deck.size();
    }
}
