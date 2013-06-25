/*************************************************************
@author Isaiah Sarju
CardGroup: The CardGroup class which will hold cards.
*************************************************************/

import java.util.*;

public class CardGroup{
    
    private HashSet<Card> cards;

    /** Creates new CardGroup. Default size of HashSet*/
    public CardGroup(){
	cards = new HashSet<Card>();
    }
    
    /** Creates new CardGroup with a custom size
     * @param size of the HashSet
     */
    public CardGroup(int size){
	cards = new HashSet<Card>(size);
    }

    /** Used to add Card to cards
     * @param card Card to be added
     * @return boolean true if added false if failed
     */
    public boolean addCard (Card card){	
	return cards.add(card);
    }

    /** Used to remove card from cards
     * @param card Card to be removed
     * @return boolean true if removed false if failed
     */
    public boolean removeCard (Card card){
	return cards.remove(card);
    }

    /** toString function
     * @return String of cards
     */
    public String toString(){
	StringBuilder cardsStringBuild = new StringBuilder();
	for (Card c : cards){
	    cardsStringBuild.append(c.toString());
	}
	return cardsStringBuild.toString();
    }

    /** clears cards*/
    public void clear(){
	cards.clear();
    }

    /** Returns index of a card
     * @return int size of cards
     */
    public int size(){
	return cards.size();
    }
    
    /** Returns Object[] of cards
     * @return Obeject[] of cards
     */
    public Object[] toArray(){
	return cards.toArray();
    }

    /** Returns Iterator over cards
     * @return Iterator an Iterator over the cards
     */
    public Iterator iterator(){
	return cards.iterator();
    }
    
    /** hashCode function
     * @return int of hashCode
     */
    public int hashCode(){
	return cards.hashCode();
	
	/** Temp removal of this
	int result = 0;
	for(Iterator i = iterator(); i.hasNext();)
	    result += i.next().hashCode();
	return result;
	*/
    }

    /** equals function
     * @return boolean if equals passes
     */
    public boolean equals(Object cardGroup){

	if (this == cardGroup)
	    return true;
	else if(cards== null || getClass() != cardGroup.getClass())
	    return false;

	final CardGroup cardFinal = (CardGroup) cardGroup;

	boolean fSame = true;
	for(Iterator i = iterator(); i.hasNext();){
	    if(!(cards.contains(i.next()))){
		fSame = false;
		break;
	    }
	}
	return fSame;
    }

    /** Returns HashSet of Cards
     * @return HashSet<Card> HashSet of Cards
     */
    public HashSet<Card> getCards(){
	return cards;
    }

    /** Returns true if Card is in cards
     * @param card Card being checked
     * @return boolean true if Card exists. false if not.
     */
    public boolean contains(Card card){
	return cards.contains(card);
    }
}