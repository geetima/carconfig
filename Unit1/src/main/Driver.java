package main;

import model.Automotive;
import util.FileIO;

public class Driver {

	public static void main(String[] args) {
		
		String optionsFilePath = "FordWagonZTWOptions.txt" ;
		String serFilePath = "FordWagonZTW.ser" ;

		Automotive fordWagonZTW = new Automotive("FordWagonZTW" , 18445) ;
		FileIO.readAndSetOptions( optionsFilePath , fordWagonZTW); 
		
		// Print the fordWagonZTW object with options read from options text file.
		System.out.println("Printing the fordWagonZTW object with options read from file " + optionsFilePath) ;
		System.out.println(fordWagonZTW);
		
		// Serialize fordWagonZTW
		System.out.println("Serializing at path = " + serFilePath + " ...");
		FileIO.serializeAutomotive(fordWagonZTW , serFilePath) ;
		System.out.println("Serializing at path = " + serFilePath + " ...done\n");
		
		// DeSearilize fordWagonZTW to a new object		
		System.out.println("De-Serializing from path = " + serFilePath + " ...");
		Automotive newFordWagonZTW = FileIO.deSerializeAutomotive(serFilePath) ;
		System.out.println("De-Serializing from path = " + serFilePath + " ...done\n");

		// Print the newFordWagonZTW object after de-serialization
		System.out.println("Printing the newFordWagonZTW object created by de-serialization from file =  " + serFilePath) ;
		System.out.println(newFordWagonZTW);


	}

}
