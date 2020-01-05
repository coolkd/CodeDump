package part1;

import java.util.Scanner;

public class Begin6 {
	
	public static void main (String [] args) {
		
		//Create scanner object
		Scanner input = new Scanner (System.in);
		
		//Output the prompt
		
		System.out.println("Enter a line of text");
		
		String line = input.nextLine();
		
		//Wait for the user to enter a line of text
		
		System.out.println("You entered: " + line);
		
		
	}

}
