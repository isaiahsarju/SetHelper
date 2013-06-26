/*************************************************************
@author Isaiah Sarju
Set Helper: This program will add Set Cards to a table and
inform user if there are any sets available. If there are then
it will be able to show possible sets upon request of the user
*************************************************************/

import java.util.*;

public class SetHelper {

    private static SetTable table = new SetTable();

    /** Parses string and returns card
     * @param cardString String of the card
     * @return Card a Card of the correct type
     */
    private static Card strToCard(String cardString){

	cardString = cardString.replace(" ","");
	int number = Integer.decode(cardString.substring(0,1)).intValue();
	int color = Integer.decode(cardString.substring(1,2)).intValue();
	int fill = Integer.decode(cardString.substring(2,3)).intValue();
	int shape = Integer.decode(cardString.substring(3)).intValue();

	return new Card(number, color, fill, shape);
    }

    private static final String cardSyntax = new String("Syntax:\n"
			   +"One\t\tTwo\t\tThree\n"
			   +"Purple\t\tRed\t\tGreen\n"
			   +"Open\t\tStriped\t\tSolid\n"
			   +"Squiggle\t\tOval\t\tDiamond\n"
			   +"Example: One Red Striped Diamond\n"
			   +"Type \'done\' to return to main menu\n"
							  +"Card: ");
        
    /** Adds cards to Table */
    public static void addCards(){
	Scanner scan = new Scanner(System.in);
	scan.useDelimiter("\\n");
	
	String pattern = "^[a-zA-Z1-3]+ ([a-zA-Z]+ ){2,2}[a-zA-Z]+$";
	int cardsAdded = 0;

	System.out.print("Add a card. " + cardSytax);
	while(true){

	    String cardString = scan.nextLine();
	    
	    
	    if(cardString.matches(pattern)){
		Card newCard;
		
		if(cardString.matches(pattern)){			
		    /* new card to be added to table */
		    try{
			newCard = Card.stringToCard(cardString);
			
			/* if contains new card print error */
			if(table.contains(newCard)){
			    System.out.print("Error. Card exists.\nPlease enter a valid Card: ");
			}
			/* else add to table and increment number of cards added count */
			else{
			    table.addCard(newCard);
			    cardsAdded++;
			    System.out.print(newCard.toString() + "\nNext card: ");
			}
		    }
		    catch (IllegalArgumentException i){
			System.out.print("Please enter a valid card: ");
		    }
		}
	    }
	    else if(cardString.toLowerCase().trim().equals("done")){
		System.out.print(cardsAdded);
		System.out.println(" card(s) added");
		break;
	    }
	    else{
		System.out.print("Invalid Entry. Please enter a valid card: ");
	    }
	}
    }
    
    /** Remove cards from Table */
    public static void removeCards(){
	Scanner scan = new Scanner(System.in);
	scan.useDelimiter("\\n");
	
	String pattern = "^[a-zA-Z1-3]+ ([a-zA-Z]+ ){2,2}[a-zA-Z]+$";
	int cardsRemoved = 0;

	System.out.print("Remove a card. " + cardSyntax);
	while(true){

	    String cardString = scan.nextLine();
	    
	    
	    if(cardString.matches(pattern)){
		Card newCard;
		
		if(cardString.matches(pattern)){			
		    /* new card to be added to table */
		    try{
			newCard = Card.stringToCard(cardString);
			
			/* if doesn't contain card print error */
			if(!table.contains(newCard)){
			    System.out.print("Error. Card doesn't exist.\nPlease enter a valid card: ");
			}
			/* else remove from table and increment number of cards removed count */
			else{
			    table.removeCard(newCard);
			    cardsRemoved++;
			    System.out.print(newCard.toString() + "\nNext card: ");
			}
		    }
		    catch (IllegalArgumentException i){
			System.out.print("Please enter a valid card: ");
		    }
		}
	    }
	    else if(cardString.toLowerCase().trim().equals("done")){
		System.out.print(cardsRemoved);
		System.out.println(" card(s) removed");
		break;
	    }
	    else{
		System.out.print("Invalid Entry. Please enter a valid card: ");
	    }
	}
    }

    /** Print the Cards in the Table */
    private static void printCards(){
	System.out.println("Table has:");
	System.out.println(table.toString());
    }

    /** Informs user if sets exist */
    private static void containsSet(){
	if(table.containsSet())
	    System.out.println("There is at least one set on the table.");
	else
	    System.out.println("No sets exist");
    }

    /** Print number of sets on Table */
    private static void setCount(){
	System.out.print(table.setCount());
	System.out.println(" set(s) on the table.");
    }

    /** Print sets on Table */
    private static void printSets(){
	int count = 0;
	setCount();
	for(Iterator i = table.getSets().iterator(); i.hasNext();){
	    System.out.print("Set ");
	    System.out.print(++count);
	    System.out.println(":");
	    System.out.println(((CardGroup) i.next()).toString());
	}
    }
    
    public static void main (String[] args){

	String menu = new String("Please Select from following options:\n"
			   +"1. Add Card\t\t"
			   +"2. Remove Card\t\t"
			   +"3. View Cards on Table\n"
			   +"4. Check for sets\t"
			   +"5. How many sets\t"
			   +"6. Print Sets");

	Scanner scan = new Scanner(System.in);

	System.out.println(menu);

	while(true){
	    if(scan.hasNextInt()){
		int i = scan.nextInt();
		switch (i) {
		case 1: addCards(); System.out.println(menu); break;
		case 2: removeCards(); System.out.println(menu); break;
		case 3: printCards(); System.out.println(menu); break;
		case 4: containsSet(); System.out.println(menu); break;
		case 5: setCount(); System.out.println(menu); break;
		case 6: printSets(); System.out.println(menu); break;
		default: System.out.println("Please select a valid option");break;
		}
	    }
	    else if(scan.next().toLowerCase().trim().equals("exit"))
		break;
	    else
		System.out.println("Please select a valid option");
	    
	   }
	
	
    }
}