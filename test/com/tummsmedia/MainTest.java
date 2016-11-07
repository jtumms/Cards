package com.tummsmedia;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import static com.tummsmedia.Card.Rank.*;
import static com.tummsmedia.Card.Suit.*;
import static org.junit.Assert.*;

/**
 * Created by john.tumminelli on 11/6/16.
 */
public class MainTest {
    @Test
    public void testIsFlush() {
        Card c1 = new Card(HEARTS, ACE);
        Card c2 = new Card(HEARTS, TEN);
        Card c3 = new Card(HEARTS, NINE);
        Card c4 = new Card(HEARTS, FOUR);
        HashSet<Card> testHand = new HashSet<>();
        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);
        testHand.add(c4);
        Main.isFlush(testHand);
        Assert.assertTrue(Main.isFlush(testHand));
    }

    @Test
    public void testIsFourKind() {
        Card c1 = new Card(HEARTS, TEN);
        Card c2 = new Card(SPADES, TEN);
        Card c3 = new Card(CLUBS, TEN);
        Card c4 = new Card(HEARTS, TEN);
        HashSet<Card> testHand = new HashSet<>();
        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);
        testHand.add(c4);
        Main.isFourKind(testHand);
        Assert.assertTrue(Main.isFourKind(testHand));
    }
    @Test
    public void testIsThreeKind() {
        Card c1 = new Card(HEARTS, TEN);
        Card c2 = new Card(SPADES, TEN);
        Card c3 = new Card(CLUBS, TEN);
        Card c4 = new Card(HEARTS, ACE);
        HashSet<Card> testHand = new HashSet<>();
        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);
        testHand.add(c4);
        Main.isThreeKind(testHand);
        Assert.assertTrue(Main.isThreeKind(testHand));
    }
    @Test
    public void testIsStraight() {
        Card c1 = new Card(HEARTS, ACE);
        Card c2 = new Card(SPADES, TWO);
        Card c3 = new Card(CLUBS, THREE);
        Card c4 = new Card(HEARTS, FOUR);
        HashSet<Card> testHand = new HashSet<>();
        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);
        testHand.add(c4);
        Main.isStraight(testHand);
        Card c5 = new Card(HEARTS, ACE);
        Card c6 = new Card(SPADES, JACK);
        Card c7 = new Card(CLUBS, QUEEN);
        Card c8 = new Card(HEARTS, KING);
        HashSet<Card> testHand2 = new HashSet<>();
        testHand2.add(c5);
        testHand2.add(c6);
        testHand2.add(c7);
        testHand2.add(c8);
        Main.isStraight(testHand2);
        Assert.assertTrue(Main.isStraight(testHand));
        Assert.assertTrue(Main.isStraight(testHand2));
    }
    @Test
    public void testIsStraightFlush() {
        Card c1 = new Card(SPADES, FOUR);
        Card c2 = new Card(SPADES, FIVE);
        Card c3 = new Card(SPADES, SIX);
        Card c4 = new Card(SPADES, SEVEN);
        HashSet<Card> testHand = new HashSet<>();
        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);
        testHand.add(c4);
        Main.isStraightFlush(testHand);
        Assert.assertTrue(Main.isStraightFlush(testHand));
    }
    @Test
    public void testTwoPair() {
        Card c1 = new Card(HEARTS, TEN);
        Card c2 = new Card(SPADES, TEN);
        Card c3 = new Card(CLUBS, KING);
        Card c4 = new Card(HEARTS, KING);
        HashSet<Card> testHand = new HashSet<>();
        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);
        testHand.add(c4);
        Main.isTwoPair(testHand);
        Assert.assertTrue(Main.isTwoPair(testHand));
    }
}