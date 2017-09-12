package com.woniuxy.demo.basic;

public class Porker {
	public static void main(String[] args) {
		int i = 0;
		for(Card c: new Porker().newDeck()){
			System.out.print(c+",");
			i++;
			if(i==13){
				System.out.println();
				i=0;
			}
		}
	}
	public Card[] newDeck(){
		Card[] newDeck = new Card[52];
		for(int i = 1;i<=52;i++){
			switch(i%4){
			case 0:
				newDeck[i-1] = addCard("方片",i%13);
				break;
			case 1:
				newDeck[i-1] = addCard("黑桃",i%13);
				break;
			case 2:
				newDeck[i-1] = addCard("红桃",i%13);
				break;
			case 3:
				newDeck[i-1] = addCard("草花",i%13);
				break;
			}
		}
		return newDeck;
	}
	private Card addCard(String suit, int rank) {
		String rank2 = null;
		switch(rank){
		case 1:
			rank2 = "A";
			break;
		case 11:
			rank2 = "J";
			break;
		case 12:
			rank2 = "Q";
			break;
		case 0:
			rank2 = "K";
			break;
			default :
				rank2 = rank+"";
		}
		
		Card card = new Card(suit,rank2);
		
		return card;
	}
}
class Card{
	private String suit;
	private String rank;
	public Card(String suit2, String rank2) {
		this.suit = suit2;
		this.rank = rank2;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String toString(){
		return "["+suit+" "+rank+"]";
	}
}