package com.tummsmedia;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static HashSet<Card> createDeck() {
        HashSet<Card> deck = new HashSet<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card c = new Card(suit, rank);
                deck.add(c);
            }
        }
        return deck;
    }

    public static HashSet<HashSet<Card>> createHand(HashSet<Card> deck) {
        HashSet<HashSet<Card>> hands = new HashSet<>();
        for (Card c1 : deck) {
            HashSet<Card> deck2 = (HashSet<Card>) deck.clone();
            deck2.remove(c1);
            for (Card c2 : deck2) {
                HashSet<Card> deck3 = (HashSet<Card>) deck2.clone();
                deck3.remove(c2);
                for (Card c3 : deck3) {
                    HashSet<Card> deck4 = (HashSet<Card>) deck3.clone();
                    deck4.remove(c3);
                    for (Card c4 : deck4) {
                        HashSet<Card> hand = new HashSet<>();
                        hand.add(c1);
                        hand.add(c2);
                        hand.add(c3);
                        hand.add(c4);
                        hands.add(hand);
                    }
                }
            }
        }
        return hands;
    }

    public static boolean isFlush(HashSet<Card> hand) {
        HashSet<Card.Suit> suits = new HashSet<>();
        for (Card c : hand) {
            suits.add(c.suit);
        }
        return suits.size() == 1;

    }
    public static boolean isFourKind(HashSet<Card> hand) {
        HashSet<Card.Rank> ranks = new HashSet<>();
        for (Card c : hand) {
            ranks.add(c.rank);

        }
        return ranks.size() == 1;
    }
    public static boolean isStraight(HashSet<Card> hand) {
        HashSet<Card.Rank> ranks = new HashSet<>();
        ArrayList<Integer> rankOrdinalArray = new ArrayList<>();
        for (Card c : hand) {
            ranks.add(c.rank);
            rankOrdinalArray.add(c.rank.ordinal());
        }
        Collections.sort(rankOrdinalArray);
        int consecutive = 0;
        ArrayList<Integer> aceHighStraightArray = new ArrayList<Integer> (Arrays.asList(10, 11, 12, 0));
        for (int i = 1; i < ranks.size(); i++) {
            boolean straight = false;
            boolean aceHighStraight = false;
            if (rankOrdinalArray.get(i) - rankOrdinalArray.get(i - 1) <= 1) {
                consecutive++;
                if (consecutive >= 3) {
                    straight = true;
                }
            }
            if (rankOrdinalArray.containsAll(aceHighStraightArray)) {
                aceHighStraight = true;
            }
            if (straight || aceHighStraight) {
                return true;
            }
        }
        return false;
    }
    public static boolean isStraightFlush(HashSet<Card> hand) {
        if (isFlush(hand) && isStraight(hand)) {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isThreeKind(HashSet<Card> hand) {
        ArrayList<Card.Rank> ranks = new ArrayList<>();
        for (Card c : hand) {
            ranks.add(c.rank);
        }
        for (Card.Rank cr : ranks) {
            int count = findDupes(ranks).get(cr);
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
    public static boolean isTwoPair(HashSet<Card> hand) {
        ArrayList<Card.Rank> ranks = new ArrayList<>();
        for (Card c : hand) {
            ranks.add(c.rank);
        }
        for (Card.Rank cr : ranks) {
            int count = findDupes(ranks).get(cr);
            if (count == 2){
                ArrayList<Card.Rank> ranks2 = (ArrayList<Card.Rank>) ranks.clone();
                ranks2.remove(cr);
                ranks = ranks2;
                for (Card.Rank cr2 : ranks) {
                    count = findDupes(ranks).get(cr2);
                    if (count == 2){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        HashSet<Card> deck = createDeck();
        HashSet<HashSet<Card>> hands = createHand(deck);
        hands = hands.stream()
//                .filter(Main::isFlush)
//                .filter(Main::isStraight)
//                .filter(Main::isFourKind)
//                .filter(Main::isStraightFlush)
//                    .filter(Main::isThreeKind)
                .filter(Main::isTwoPair)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(hands.size());
    }

    public static HashMap<Card.Rank, Integer> findDupes(ArrayList<Card.Rank> ranks) {
        HashMap<Card.Rank, Integer> m = new HashMap<>();
        for(Card.Rank cr : ranks ) {
            m.put(cr, Collections.frequency(ranks, cr));
        }
        return m;
    }

}
