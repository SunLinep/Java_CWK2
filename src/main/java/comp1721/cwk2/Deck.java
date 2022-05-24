package comp1721.cwk2;

import java.util.Collections;

// Implement Deck class here
public class Deck extends CardCollection {
    private final String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
    private final String[] suit = {"C", "D", "H", "S"};
    public Deck(){
        for(String suit1 : suit){
            for(String rank1: rank){
                String a = rank1 + suit1;
                Card c = new Card(a);
                super.cards.add(c);
            }
        }
    }

    @Override
    public int size(){
        return super.size();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public boolean contains(Card card) {
        return super.cards.contains(card);
    }

    @Override
    public void discard() {
        super.discard();
    }

    @Override
    public void add(Card card) throws CardException{
        if(super.contains(card)) throw new CardException("This card already exists!");
        super.add(card);
    }

    public Card deal() throws CardException{
        if(super.size() == 0) throw new CardException("Invalid discard!");
        Card a = super.cards.get(0);
        super.cards.remove(0);
        return a;
    }

    public void shuffle(){
        Collections.shuffle(super.cards);
    }
}
