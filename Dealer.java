package Blackjack;

import java.util.*;

public class Dealer {
    private Hand hand = new Hand();
    private int dealer_total;

    Dealer(){
    }

    public int get_total(boolean hide) {
        if (hide) {
            return dealer_total - hand.get_value_of(hand.get(1));
        } else {
            return dealer_total;
        }
    }

    public void hit(Deck deck){
        while (get_total(false) < 17) {
            Card card = deck.draw_card();
            this.hand.add_to_hand(card);
            dealer_total = hand.get_total();
        }
    }

    public void add(Card card) {
        this.hand.add_to_hand(card);
        dealer_total = hand.get_total();
    }

    public boolean has_blackjack(){
        return hand.get_total() == 21;
    }

    public void clear(){
        hand.clear_hand();
        this.dealer_total = 0;
    }

    public ArrayList<Card> show_hand(){
            return hand.get_hand();
    }

    public Card show_first_card(){
        return hand.get(0);
    }
}
