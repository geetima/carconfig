package main;

import exceptionHandler.*;
import adapter.*;

public class Driver {

	public static void main(String[] args) {
		
		String optionsFilePath = "FordWagonZTWOptions.txt" ;
		ProxyAutomotive fordWagonZTW = new BuildAuto() ;
		fordWagonZTW.readFile(optionsFilePath) ;
		fordWagonZTW.print() ;
		System.out.println("Total price without any options = $" + fordWagonZTW.getTotalPrice());	
		
		//Validating InvalidOptionCountException by entering negative number as count
		
		try
		{
			fordWagonZTW.addOptionSet("InvalidOptionSet", -3) ;
		}
		catch(InvalidOptionCountException ioce)
		{
			System.out.println("Caught the exception so that program continue working perfectly") ;
		}
		
		//Validating NonExistingOptionException by entering non-existing value of option
		
		try
		{
			fordWagonZTW.setOptionChoice("Brakes/Traction Control", "Invalid Option");
		}
		catch(NonExistingOptionException neoe)
		{
			System.out.println("The given option is invalid.") ;
		}
		catch(NonExistingOptionSetException neose)
		{
			System.out.println("The given option set name is invalid.") ;
		}
		
		//Validating NonExistingOptionException by entering non-existing value of optionSet
		
		try
		{
			fordWagonZTW.setOptionChoice("Brakes", "ABS");
		}
		catch(NonExistingOptionException neoe)
		{
		}
		catch(NonExistingOptionSetException neose)
		{
			
		}
		
		//Entering valid values for OptionSet and Option as a choice
		
		try
		{
			fordWagonZTW.setOptionChoice("Brakes/Traction Control", "ABS");
		}
		catch(NonExistingOptionException neoe)
		{
			System.out.println("The given option is invalid.") ;
		}
		catch(NonExistingOptionSetException neose)
		{
			
		}
		
		//Demonstrating that the total price of the car changes based on the choice for option
		
		System.out.println("Total price after selecting ABS option = $" + fordWagonZTW.getTotalPrice());	
		
		// Printing object again after selecting the option ABS for Brakes/Traction control
		
		fordWagonZTW.print() ;
	}
}
