package Blackjack;

import java.util.*;

public class Player {
    private Hand hand = new Hand();
    private int bet;
    private int total_chips;
    private int player_total;

    //LOG
    //fix ace value assignment later
    //Add split method

    Player(){
    }

    public void hit(Card card){
        this.hand.add_to_hand(card);
        player_total = hand.get_total();
    }

    public void add(Card card) {
        this.hand.add_to_hand(card);
        player_total = hand.get_total();
    }

    public void _double(Card card) {
        bet *= 2;
        this.hand.add_to_hand(card);
        player_total = hand.get_total();
    }

    public void split(){

    }

    public void set_bet(int bet){
        if (bet > total_chips || bet < 0) {
            System.out.println("Not Enough Chips!");
        } else {
            this.bet = bet;
        }
    }

    public void starting_value(int i) {
        this.total_chips = i;
    }

    public int get_chips(){
        return this.total_chips;
    }

    public int get_total(){
        return player_total;
    }

    public void win(){
        System.out.println("Player Wins!");
        total_chips += bet;
    }

    public void bust(){
        System.out.println("Dealer Wins!");
        total_chips -= bet;
    }

    public boolean has_blackjack(){
        return hand.get_total() == 21;
    }

    public void clear(){
        this.hand.clear_hand();
        this.player_total = 0;
    }

    public ArrayList<Card> show_hand(){
        return hand.get_hand();
    }
}
