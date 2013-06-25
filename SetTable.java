/*************************************************************
@author Isaiah Sarju
SetTable: The SetTable class which will hold cards.
*************************************************************/

import java.util.*;

public class SetTable extends CardGroup{

    private HashSet<SetSet> setList = new HashSet<SetSet>();
    private boolean fChecked = false;
    private boolean fSets = false;
    private int setCount = 0;

    /** Used to add card to CardGroup
     * @param card Card to be added
     * @return boolean as per the general contract of
     * Collection.add
     */
    public boolean addCard (Card card){	
	if(super.addCard(card)){
	    fChecked = false;
	    fSets = false;
	    setCount = 0;
	    setList.clear();

	    return true;
	}

	return false;
    }

    /** Used to remove card from CardGroup
     * @param cardID int of card to be removed
     * @return Card removed from CardGroup
     */
    public boolean removeCard (Card card){
	if(super.removeCard(card)){
	    fChecked = false;
	    fSets = false;
	    setCount = 0;
	    setList.clear();

	    return true;
	}

	return false;
    }

    /** toString function
     * @return String of cards
     */
    public String toString(){
	StringBuilder tableStringBuild = new StringBuilder();
	int i = 0;
	Iterator cardsIterator = super.iterator();
	while(cardsIterator.hasNext()){
	    tableStringBuild.append(++i);
	    tableStringBuild.append(". ");		    
	    tableStringBuild.append(cardsIterator.next().toString());
	    tableStringBuild.append("\n");
	}
	
	return tableStringBuild.toString();
    }

    /** clears CardGroup */
    public void clear(){
	fChecked = false;
	fSets = false;
	setCount = 0;
	setList.clear();

	super.clear();
    }

    /** Returns the third card that would make a set from two givin cards
     * @param card0 First Card
     * @param card1 Second Card
     * @return Card which would be the third card in the set
     */
    private static Card thirdCard(Card card0, Card card1){
	int number0 = card0.getNumber();
	int number1 = card1.getNumber();
	
	int color0 = card0.getColor();
	int color1 = card1.getColor();

	int fill0 = card0.getFill();
	int fill1 = card1.getFill();
	
	int shape0 = card0.getShape();
	int shape1 = card1.getShape();

	int number2;
	int color2;
	int fill2;
	int shape2;

	if( ((number0 == 0) && (number1 == 0)) ||
	    ((number0 != number1) && (number0 != 0) && (number1 !=0)) ){
	    number2 = 0;
	}
	else if( ((number0 == 1) && (number1 == 1)) ||
		 ((number0 !=number1) && (number0 != 1) && (number1 != 1)) ){
	    number2 = 1;
	}
	else
	    number2 = 2;

	
	if( ((color0 == 0) && (color1 == 0)) ||
	    ((color0 != color1) && (color0 != 0) && (color1 !=0)) ){
	    color2 = 0;
	}
	else if( ((color0 == 1) && (color1 == 1)) ||
		 ((color0 !=number1) && (color0 != 1) && (color1 != 1)) ){
	    color2 = 1;
	}
	else
	    color2 = 2;


	if( ((fill0 == 0) && (fill1 == 0)) ||
	    ((fill0 != fill1) && (fill0 != 0) && (fill1 !=0)) ){
	    fill2 = 0;
	}
	else if( ((fill0 == 1) && (fill1 == 1)) ||
		 ((fill0 !=fill1) && (fill0 != 1) && (fill1 != 1)) ){
	    fill2 = 1;
	}
	else
	    fill2 = 2;


	if( ((shape0 == 0) && (shape1 == 0)) ||
	    ((shape0 != shape1) && (shape0 != 0) && (shape1 !=0)) ){
	    shape2 = 0;
	}
	else if( ((shape0 == 1) && (shape1 == 1)) ||
		 ((shape0 !=shape1) && (shape0 != 1) && (shape1 != 1)) ){
	    shape2 = 1;
	}
	else
	    shape2 = 2;
	
	return new Card(number2, color2, fill2, shape2);
    }

    /** Returns number of Sets
     * @return int number of sets
     */
    public int setCount(){
	if(!fChecked)
	    containsSet();
	return setCount;
    
    }

    /** Returns HashSet of Sets
     * @return HashSet<Table> HashSet of Sets represented by Tables
     */
    public HashSet<SetSet> getSets(){
	if(!fChecked)
	    containsSet();
	return setList;
    }

    /** Returns true if Set exist. Catalogues Sets.
     * Sets fChecked flag to true after first check to 
     * prevent repeated catalogings
     * @return boolean true if Set exists. false if not.
     */
    public boolean containsSet(){
	
	if(fChecked)
	    return fSets;
	
	Object tableCardsArray[] = super.toArray();
	int arraySize = super.size();
	Card card0;
	Card card1;
	Card card2;
	
	for(int i=0; i<arraySize; i++){
	    card0 = (Card) tableCardsArray[i];

	    for(int j=i+1; j<arraySize-i; j++){
		card1 = (Card) tableCardsArray[j];
		card2 = SetTable.thirdCard(card0, card1);
	
		if(super.contains(card2)){
		    
		    /** This is interesting. If I clear tempSet then the
		     * set in setList also gets cleared. I thought that
		     * Java copied an object to the Set not just referenced it
		     */
		    SetSet tempSet = new SetSet();
		    tempSet.addCard(card0);
		    tempSet.addCard(card1);
		    tempSet.addCard(card2);
		  
		    if(setList.add(tempSet))
			setCount++;

		    fSets = true;
		}
	    }
	}
	
	fChecked = true;
	return fSets;
    }
}