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
        
    /** Adds cards to Table */
    public static void addCards(){
	Scanner scan = new Scanner(System.in);
	int cardsAdded = 0;

	System.out.print("Add a card. Syntax:\n"
			   +"1\t\t2\t\t3\n"
			   +"One\t\tTwo\t\tThree\n"
			   +"Purple\t\tRed\t\tGreen\n"
			   +"Clear\t\tLined\t\tFilled\n"
			   +"Squigle\t\tOval\t\tDiamond\n"
			   +"Example: One Red Lined Diamond = 1223\n"
			   +"Type \'done\' to return to main menu\n"
			   +"Card: ");
	while(true){
	    if(scan.hasNextInt()){
		try{
		    int intCard = (Integer) scan.nextInt();
		    Integer integerCard;
		    String cardString;

		    intCard -= 1111;
		    if(intCard == 0){
			cardString = ("0000");
		    }
		    else if (intCard < 10){
			integerCard = new Integer(intCard);
			cardString = ("000" + integerCard.toString());
		    }
		    else if (intCard < 100){
			integerCard = new Integer(intCard);
			cardString = ("00" + integerCard.toString());
		    }
		    else if(intCard < 1000){
			integerCard = new Integer(intCard);
			cardString = ("0" + integerCard.toString());
		    }
		    else
			cardString = (new Integer(intCard)).toString();

		    Card newCard = strToCard(cardString);
		    
		    if(table.contains(newCard)){
			System.out.print("Error. Card exists. Card: ");
		    }
		    else{
			table.addCard(newCard);
			cardsAdded++;
			System.out.print(newCard.toString() + " Next card: ");
		    }
		}
		catch(IllegalArgumentException i){
		    System.out.print("Error. Please enter a valid card: ");
		}
	    }
	    else if(scan.next().toLowerCase().trim().equals("done")){
		System.out.print(cardsAdded);
		System.out.println(" card(s) added");
		break;
	    }
	    else
		System.out.print("Error. Please enter a valid card: ");
	}
    }

    /** Remove cards from Table */
    public static void removeCards(){
	Scanner scan = new Scanner(System.in);
	int cardsRemoved = 0;

	System.out.print("Remove a card. Syntax:\n"
			   +"1\t\t2\t\t3\n"
			   +"One\t\tTwo\t\tThree\n"
			   +"Purple\t\tRed\t\tGreen\n"
			   +"Clear\t\tLined\t\tFilled\n"
			   +"Squigle\t\tOval\t\tDiamond\n"
			   +"Example: One Red Lined Diamond = 1223\n"
			   +"Type \'done\' to return to main menu\n"
			   +"Card: ");
	while(true){
	    if(scan.hasNextInt()){
		try{
		    int intCard = (Integer) scan.nextInt();
		    Integer integerCard;
		    String cardString;

		    intCard -= 1111;
		    if(intCard == 0){
			cardString = ("0000");
		    }
		    else if (intCard < 10){
			integerCard = new Integer(intCard);
			cardString = ("000" + integerCard.toString());
		    }
		    else if (intCard < 100){
			integerCard = new Integer(intCard);
			cardString = ("00" + integerCard.toString());
		    }
		    else if(intCard < 1000){
			integerCard = new Integer(intCard);
			cardString = ("0" + integerCard.toString());
		    }
		    else
			cardString = (new Integer(intCard)).toString();

		    Card newCard = strToCard(cardString);
		    
		    if(!(table.contains(newCard))){
			System.out.print("Error. Card exists doesn't. Card: ");
		    }
		    else{
			table.removeCard(newCard);
			cardsRemoved++;
			System.out.print(newCard.toString() + " Next card: ");
		    }
		}
		catch(IllegalArgumentException i){
		    System.out.print("Error. Please enter a valid card: ");
		}
	    }
	    else if(scan.next().toLowerCase().trim().equals("done")){
		System.out.print(cardsRemoved);
		System.out.println(" card(s) removed");
		break;
	    }
	    else
		System.out.print("Error. Please enter a valid card: ");
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
	    System.out.println(((Table) i.next()).toString());
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