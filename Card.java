/*************************************************************
@author Isaiah Sarju
Card: This is a card which is a part of the game Set. Each
card has four attributes: shape, color, fill, and number. Each
attribute can be in one of three sates. There is also place on
table to designate which card it is.
*************************************************************/

import java.util.*;

public class Card {

    /** 0=1 1=2 2=3 */
    private int number;
    /** 0=purple 1=red 2=green */
    private int color;
    /** 0=clear 1=lined 2=filled */
    private int fill;
    /** 0=squig 1=oval 2=diamond */
    private int shape;
    
    private static int MAX_AT = 2;
    private static int MIN_AT = 0;

    /** Creates a card with number, color, shape, and fill set
      * @param number Number of shapes on card
      * @param color Number designating color
      *	@param fill Number designating fill
      *	@param shape Number designating shape
      * @throws IllegalArgumentException if arguments are not
      * within proper bounds
      */

    public Card(int number, int color, int fill, int shape)
	throws IllegalArgumentException {
	
	if(number < MIN_AT || number > MAX_AT || color < MIN_AT
	   || color > MAX_AT || shape < MIN_AT || shape > MAX_AT
	   || fill < MIN_AT || fill > MAX_AT)
	    throw new IllegalArgumentException("Invalid card arguments");

	this.number = number;
	this.color = color;
	this.fill = fill;
	this.shape = shape;
    }

    /** Used to get color
     * @return int which designates color
     */
    public int getColor(){
	return color;
    }

    /** Used to get number
     * @return int which designates number
     */
    public int getNumber(){
	return number;
    }

    /** Used to get fill
     * @return int which designates fill
     */
    public int getFill(){
	return fill;
    }

    /** Used to get color
     * @return int which designates shape
     */
    public int getShape(){
	return shape;
    }
    
    /** hashCode function
     * @return int of hashCode
     */
    public int hashCode(){
	int result = (this==null ? 0 : ((Integer) ((number*1000) + (color*100) + (fill*10) + shape)).hashCode());
	result = result * 29;
	return result;
    }

    /** equals function
     * @return boolean if equals passes
     */
    public boolean equals(Object card){

	if (this == card)
	    return true;
	else if(card == null || getClass() != card.getClass())
	    return false;

	final Card cardFinal = (Card) card;

        if(cardFinal.getColor() != this.color)
	    return false;
	else if(cardFinal.getNumber() != this.number)
	    return false;
	else if(cardFinal.getFill() != this.fill)
	    return false;
	else if(cardFinal.getShape() != this.shape)
	    return false;
	else
	    return true;
    }

    /** stringToCard function
     * @return Card based on String in form "number color shading symbol"
     */
    public static Card stringToCard(String cardString){
	    int cNumber = -1;
	    int cColor = -1;
	    int cShading = -1;
	    int cSymbol = -1;
	    
	    /*determine new card integers */
	    String parts[] = cardString.toLowerCase().split(" ");
	    
	    if (parts[0].equals("1") || parts[0].equals("one"))
		cNumber = 0;
	    else if (parts[0].equals("2") || parts[0].equals("two"))
		cNumber = 1;
	    else if (parts[0].equals("3") || parts[0].equals("three"))
		cNumber = 2;
	    
	    if (parts[1].equals("purple"))
		cColor = 0;
	    else if (parts[1].equals("red"))
		cColor = 1;
	    else if (parts[1].equals("green"))
		cColor = 2;
	    
	    if (parts[2].equals("clear") || parts [2].equals("open"))
		cShading = 0;
	    else if (parts[2].equals("striped") || parts[2].equals("lined"))
		cShading = 1;
	    else if (parts[2].equals("solid") || parts[2].equals("filled"))
		cShading = 2;
	    
	    if (parts[3].equals("squiggle"))
		cSymbol = 0;
	    else if (parts[3].equals("diamond"))
		cSymbol = 1;
	    else if (parts[3].equals("oval"))
		cSymbol = 2;
	    
	    return new Card(cNumber, cColor, cShading, cSymbol);
    }

    /** toString function
     * @return String of card
     */
    public String toString(){
	
	StringBuilder cardStringBuild = new StringBuilder();
	if(number == 0)
	    cardStringBuild.append("One ");
	else if(number == 1)
	    cardStringBuild.append("Two ");
	else
	    cardStringBuild.append("Three ");

	if(color == 0)
	    cardStringBuild.append("Purple ");
	else if(color == 1)
	    cardStringBuild.append("Red ");
	else
	    cardStringBuild.append("Green ");

	if(fill == 0)
	    cardStringBuild.append("Open ");
	else if(fill == 1)
	    cardStringBuild.append("Striped ");
	else
	    cardStringBuild.append("Solid ");

	if(shape == 0)
	    cardStringBuild.append("Squiggle(s)");
	else if(shape == 1)
	    cardStringBuild.append("Diamond(s)");
	else
	    cardStringBuild.append("Oval(s)");

	return cardStringBuild.toString();
    }

}