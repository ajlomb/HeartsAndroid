package com.companyname.hearts.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/*
    The Player class contains blueprints for each player in the game. Each Player
    has a name, their current points, an ArrayList of cards containing their current hand,
    as well as an ArrayList of cards containing the cards that they have won during the round.
 */

public class Player implements Serializable {
	private String name;
	private int points;
	private ArrayList<Card> hand;
	private ArrayList<Card> oldCards;

	public Player(String playerName) {
		this.setName(playerName);
		setPoints(0);
		setOldCards(new ArrayList<Card>());
		setHand(new ArrayList<Card>());
	}

	public void setOldCards(ArrayList<Card> oldCards) {		
		this.oldCards = oldCards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public ArrayList<Card> getOldCards() {
		return oldCards;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

    // Method that tells the MainActivity how many cards this player has selected during passing.
	public int getNumberOfSelectedCards() {
        int selectedCards = 0;
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().get(i).isSelected()) {
                selectedCards++;
            }
        }
        return selectedCards;
    }

    // Method for organizing the hand of the Player.
	public void organizeHand() {
        int spot = 0;
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().get(i).getSuit() == Suit.Hearts) {
                Card temp = new Card(getHand().get(i).getRank(), getHand().get(i).getSuit(),getHand().get(i).getResId());
                getHand().remove(i);
                getHand().add(0, temp);
                spot++;
            }
        }
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().get(i).getSuit() == Suit.Spades) {
                Card temp = new Card(getHand().get(i).getRank(), getHand().get(i).getSuit(),getHand().get(i).getResId());
                getHand().remove(i);
                getHand().add(spot, temp);
                spot++;
            }
        }
        for (int i = 0; i < getHand().size(); i++) {
            if (getHand().get(i).getSuit() == Suit.Diamonds) {
                Card temp = new Card(getHand().get(i).getRank(), getHand().get(i).getSuit(),getHand().get(i).getResId());
                getHand().remove(i);
                getHand().add(spot, temp);
                spot++;
            }
        }
        Collections.sort(getHand());
    }

}
