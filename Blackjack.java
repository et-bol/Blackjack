package Blackjack;

import java.util.*;

public class Blackjack {

    private static Deck deck = new Deck(8);
    private static Player player = new Player();
    private static Dealer dealer = new Dealer();

    public static void main(String[] args){
        String choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Play?\n(Y/N):  ");
        choice = input.nextLine();
        while (choice.equalsIgnoreCase("y")) {
            play_round();
            System.out.println("Play again?\n(Y/N):  ");
            choice = input.nextLine();
        }
        input.close();
    }

    private static void play_round(){
        Scanner input = new Scanner(System.in);
        System.out.println("Set Starting Amt:  ");
        int starting_chips = input.nextInt();
        player.starting_value(starting_chips);

        while (player.get_chips() > 0) {
            System.out.println("\nTotal Chips: " + player.get_chips() + "\nPlace your bet: ");
            int amt = input.nextInt();
            while (amt > player.get_chips() || amt < 0) {
                System.out.println("Place your bet: ");
                amt = input.nextInt();
            }

            player.set_bet(amt);

            dealer.add(deck.draw_card());
            dealer.add(deck.draw_card());

            player.add(deck.draw_card());
            player.add(deck.draw_card());

            show_cards(true);

            if (dealer.has_blackjack()) {
                show_cards(false);
                System.out.println("Dealer has BLACKJACK!!!");
                player.bust();

                player.clear();
                dealer.clear();
            } else if (player.has_blackjack()) {
                show_cards(false);
                System.out.println("Player has BLACKJACK!!!");
                player.win();

                player.clear();
                dealer.clear();
            } else {
                String choice;
                if (amt * 2 <= player.get_chips()) {
                    System.out.println("(HIT/DOUBLE/STAND)\n");
                    choice = input.next();
                } else {
                    System.out.println("(HIT/STAND)\n");
                    choice = input.next();
                }
                if (choice.equalsIgnoreCase("DOUBLE")) {
                    if (amt * 2 <= player.get_chips()) {
                        player._double(deck.draw_card());
                        dealer.hit(deck);
                        show_cards(false);
                        check_winner();
                    } else {
                        System.out.println("Not Enough Chips!!!!");
                        System.out.println("(HIT/STAND)\n");
                        choice = input.next();
                    }
                }
                while (choice.equalsIgnoreCase("HIT")) {
                    player.hit(deck.draw_card());
                    show_cards(true);
                    if (player.get_total() > 21) {
                        show_cards(false);
                        player.bust();
                        choice = "";
                    } else {
                        System.out.println("(HIT/STAND)\n");
                        choice = input.next();
                        if (choice.equalsIgnoreCase("Stand")) {
                            dealer.hit(deck);
                            show_cards(false);
                            check_winner();
                        }
                    }
                }
                if (choice.equalsIgnoreCase("stand")) {
                    dealer.hit(deck);
                    show_cards(false);
                    check_winner();
                }
            }
            player.clear();
            dealer.clear();
            deck.deck_index = 0;
            deck.shuffle_deck();
        }
        System.out.println("\nOut of Chips!");
    }

    private static void show_cards(boolean hide){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.print("\nDealers Hand:\n");
        if (hide) {
            System.out.println(dealer.show_first_card());
        } else {
            System.out.println(dealer.show_hand());
        }
        System.out.println("Total: " + dealer.get_total(hide));

        System.out.print("\nPlayers Hand:\n");
        System.out.println(player.show_hand());
        System.out.println("Total: " + player.get_total());
    }

    private static void check_winner(){
        if (player.get_total() > 21){
            player.bust();
        } else if (dealer.get_total(false) > 21) {
            player.win();
        } else if (player.get_total() > dealer.get_total(false)) {
            player.win();
        } else if (player.get_total() == dealer.get_total(false)){
            System.out.println("Tie");
        } else if (player.get_total() < dealer.get_total(false)){
            player.bust();
        }
    }
}
