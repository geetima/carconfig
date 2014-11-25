package main;

import model.Automotive;
import editor.EditOptions;

public class Driver {

	static Automotive fordWagonZTW ;
	
	public static void main(String[] args) {
	/*	String optionsFilePath = "FordWagonZTWOptions.txt" ;
		fordWagonZTW = new Automotive();
		fordWagonZTW.readFile(optionsFilePath) ;
		
		System.out.println("fordWagonZTW object before updates : " + fordWagonZTW);	
		
		//Editing option set names in different threads for the same static Automotive object
		//As soon as one thread changes the name, the rest of the threads print that OptionSet name "Color" is not a valid optionSet
		EditOptions eo = new EditOptions(fordWagonZTW);
		eo.setOldOptionSetName("Color") ;
		eo.setNewOptionSetName("CarColor") ;		
		Thread t1 = new Thread(eo);
		
		EditOptions eo2 = new EditOptions(fordWagonZTW);
		eo2.setOldOptionSetName("Color") ;
		eo2.setNewOptionSetName("TruckColor") ;	
		Thread t2 = new Thread(eo2);
		

		EditOptions eo3 = new EditOptions(fordWagonZTW);
		eo3.setOldOptionSetName("Color") ;
		eo3.setNewOptionSetName("BikeColor") ;	
		Thread t3 = new Thread(eo3);

		EditOptions eo4 = new EditOptions(fordWagonZTW);
		eo4.setOldOptionSetName("Color") ;
		eo4.setNewOptionSetName("JeepColor") ;	
		Thread t4 = new Thread(eo4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		//Main thread waiting for all the other threads to finish
		try
		{
			Thread.sleep(4000) ;
		}
		catch(InterruptedException ie){}
			
		
		System.out.println("fordWagonZTW object after updates : " + fordWagonZTW);	
*/
	}
}
