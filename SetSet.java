/*************************************************************
@author Isaiah Sarju
SetSet: The CardGroup class which will hold Set Sets.
*************************************************************/

import java.util.*;

public class SetSet extends CardGroup{
    

    public SetSet(){
	super(3);
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

}