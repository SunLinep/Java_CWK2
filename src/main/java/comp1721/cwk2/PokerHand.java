package comp1721.cwk2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

// Implement PokerHand class here
public class PokerHand extends CardCollection {
    private final char[] temp = new char[]{'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
    public PokerHand(){
    }

    public PokerHand(String parameter) throws CardException {
        int i = 1;
        for(String s: parameter.split(" ")){
            if(i > 5) throw new CardException("Invalid number!");
            Card a = new Card(s);
            super.add(a);
            i++;
        }
    }

    @Override
    public String toString(){
        StringBuilder a = new StringBuilder();
        int i = 0;
        for(Card c: super.cards){
            a.append(c.toString());
            if(i < super.size() - 1) {
                a.append(" ");
            }
            i++;
        }
        return a.toString();
    }

    @Override
    public int size(){
        return super.size();
    }

    @Override
    public void discard() throws CardException {
        if(super.size() == 0) throw new CardException("Invalid discard!");
        super.discard();
    }

    @Override
    public void add(Card card) throws CardException{
        if(super.size() == 5) throw new CardException("Invalid adding!");
        if(super.contains(card)) throw new CardException("This card already exists!");
        super.add(card);
    }

    public void discardTo(Deck parameter) throws CardException {
        if(super.size() == 0) throw new CardException("Invalid discard!");
        for(Card c: super.cards){
            parameter.add(c);
        }
        super.discard();
    }

    public boolean isFourOfAKind() {
        if(super.size() != 5) return false;
        int i;
        List<Character> charlist = new ArrayList<>();
        for (Card c : super.cards) {
            charlist.add(c.getRank().getSymbol());
        }
        HashSet<Character> charset = new HashSet<>(charlist);
        List<Character> templist = new ArrayList<>(charset);
        if (templist.size() == 2) {
            i = 0;
            for (Character c : templist) {
                for (Character c2 : charlist) {
                    if (c == c2) {
                        i++;
                    }
                    if (i == 4) {
                        return true;
                    }
                }
                i = 0;
            }
        }
        return false;
    }
    public boolean isFullHouse() {
        if(super.size() != 5) return false;
        int i;
        List<Character> charlist = new ArrayList<>();
        for (Card c : super.cards) {
            charlist.add(c.getRank().getSymbol());
        }
        HashSet<Character> charset = new HashSet<>(charlist);
        List<Character> templist = new ArrayList<>(charset);
        if (templist.size() == 2) {
            i = 0;
            for (Character c : templist) {
                for (Character c2 : charlist) {
                    if (c == c2) {
                        i++;
                    }
                    if (i == 4) {
                        return false;
                    }
                }
                i = 0;
            }
        }else{
            return false;
        }
        return true;
    }

    public boolean isThreeOfAKind() {
        if(super.size() != 5) return false;
        int i;
        List<Character> charlist = new ArrayList<>();
        for (Card c : super.cards) {
            charlist.add(c.getRank().getSymbol());
        }
        HashSet<Character> charset = new HashSet<>(charlist);
        List<Character> templist = new ArrayList<>(charset);
        if (templist.size() == 3) {
            i = 0;
            for (char c : templist) {
                for (char c2 : charlist) {
                    if (c == c2) {
                        i++;
                    }
                    if (i == 3) {
                        return true;
                    }
                }
                i = 0;
            }
        }else{
            return false;
        }
        return false;
    }

    public boolean isTwoPairs() {
        if(super.size() != 5) return false;
        int i;
        List<Character> charlist = new ArrayList<>();
        for (Card c : super.cards) {
            charlist.add(c.getRank().getSymbol());
        }
        HashSet<Character> charset = new HashSet<>(charlist);
        List<Character> templist = new ArrayList<>(charset);
        if (templist.size() == 3) {
            i = 0;
            for (char c : templist) {
                for (char c2 : charlist) {
                    if (c == c2) {
                        i++;
                    }
                    if (i == 3) {
                        return false;
                    }
                }
                i = 0;
            }
        }else{
            return false;
        }
        return true;
    }

    public boolean isPair() {
        if(super.size() != 5) return false;
        List<Character> charlist = new ArrayList<>();
        for (Card c : super.cards) {
            charlist.add(c.getRank().getSymbol());
        }
        HashSet<Character> charset = new HashSet<>(charlist);
        List<Character> templist = new ArrayList<>(charset);
        return templist.size() == 4;
    }

    public boolean isFlush() {
        if(super.size() != 5) return false;
        List<Character> charlist = new ArrayList<>();
        for (Card c : super.cards) {
            charlist.add(c.getSuit().getSymbol());
        }
        HashSet<Character> charset = new HashSet<>(charlist);
        List<Character> templist = new ArrayList<>(charset);
        return templist.size() == 1;
    }

    public boolean isStraight() {
        if(super.size() != 5) return false;
        int i, j, h = 0;
        List<Character> charlist = new ArrayList<>();
        List<Integer> intlist = new ArrayList<>();
        super.sort();
        for (Card c : super.cards) {
            charlist.add(c.getRank().getSymbol());
        }
        for(char c: charlist){
            for(i = 0; i < 13; i++){
                if(temp[i] == c) break;
            }
            if(i == 0){
                intlist.add(13);
            }
            intlist.add(i);
        }
        Collections.sort(intlist);
        if(intlist.get(0) == 0) {
            if(intlist.get(4) >= 5){
                intlist.remove(0);
            }else{
                intlist.remove(5);
            }
        }
        for(j = intlist.get(0), i = 0; h < super.size() && i < 5; i++, j++, h++){
            if(j != intlist.get(i)){
                return false;
            }
        }
        return true;
    }
}