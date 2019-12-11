package Blackjack;

import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();

    Hand(){
    }

    public ArrayList<Card> get_hand(){
        return this.hand;
    }

    public void add_to_hand(Card card){
        this.hand.add(card);
    }

    public void clear_hand(){
        this.hand.clear();
    }

    public int length(){
        return hand.size();
    }

    public Card get(int i){
        return this.hand.get(i);
    }

    public void remove(int i) {
        this.hand.remove(i);
    }

    public int get_total(){
        int total = 0;
        for (int i = 0; i < hand.size(); i++) {
            String value = hand.get(i).get_value();
            if (value.equals("J") || value.equals("K") || value.equals("Q")) {
                total += 10;
            } else if (!value.equals("A")){
                total += Integer.parseInt(value);
            } else if (value.equals("A")) {
                if (total + 11 > 21) {
                    total += 1;
                } else {
                    total += 11;
                }
            }
        }
        return total;
    }

    public int get_value_of(Card card) {
        int value = 0;
        if (card.get_value().equals("Q") || card.get_value().equals("K") ||card.get_value().equals("J")) {
            value += 10;
        } else if (!card.get_value().equals("A")) {
            value += Integer.parseInt(card.get_value());
        } else if(card.get_value().equals("A")) {
            value += 11;
        }
        return value;
    }
}
