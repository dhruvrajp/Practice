package ctcode;


public class CardPack{
	public enum Suit{
		CLUBS(1),SPADES(2),HEARTS(3),DIAMONDS(4);
		int value;
		private Suit(int v){
			value=v;
		}
	}
	
	private int card;
	private Suit suit;
	
	public CardPack(int n,Suit s){
		this.card=n;
		this.suit=s;
	}
	
	public int getCard() {
		return card;
	}
	public Suit getSuit() {
		return suit;
	}
}


class BlackJack extends CardPack{
	
	BlackJack(int n,Suit s){
		super(n,s);
	}
	
	public int value(){
		int r=super.getCard();
		if(r==1)return 11;
		if(r<10)return r;
		else return 10;
	}
	
	
	boolean isAce(){
		return super.getCard()==1;
	}
}