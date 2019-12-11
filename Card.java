package Blackjack;

public class Card {
    private String suit;
    private String value;

    public Card(String suit, String value){
        this.suit = suit;
        this.value = value;
    }

    private String get_suit(){
        return suit;
    }

    public void set_suit(String suit){
        this.suit = suit;
    }

    public String get_value(){
        return value;
    }

    public void set_value(String value){
        this.value = value;
    }

    public boolean equals(Object c){
        Card testobj = (Card)c;
        return (testobj.get_value().equalsIgnoreCase(value) && testobj.get_suit().equalsIgnoreCase(suit));
    }

    public String toString(){
        return value + " of " + suit;
    }
}
