package util;

import java.io.*;
import java.util.ArrayList;
import model.*;
import exceptionHandler.*;

public class FileIO {
	
	private static String opts = "Ford/Wagon/18445\n" +
"Color,Fort Knox Gold Clearcoat Metallic,0\n" +
"Color,Liquid Grey Clearcoat Metallic,0\n" +
"Color,Infra-Red Clearcoat,0\n" +
"Color,Grabber Green Clearcoat Metallic,0\n" +
"Color,Sangria Red Clearcoat Metallic,0\n" +
"Color,French Blue Clearcoat,0\n" +
"Color,Metallic,0\n" +
"Color,Twilight Blue Clearcoat Metallic,0\n" +
"Color,CD Silver Clearcoat Metallic,0\n" +
"Color,Pitch Black Clearcoat,0\n" +
"Color,Cloud 9 White Clearcoat,0\n" +

"Color,Cloud 9 White Clearcoat,IamInvalidNumber\n" +
"Color,Cloud 9 White Clearcoat\n" +

"Transmission,automatic,0\n" +
"Transmission,manual,-815\n" +


"Brakes/Traction Control,Standard,0\n" +
"Brakes/Traction Control,ABS,400\n" +
"Brakes/Traction Control,ABS with Advance Trac, 1625\n" +

"Side Impact Air Bags, Present, 350\n" +
"Side Impact Air Bags, Not Present, 0\n" +


"Power Moonroof, Present, 595\n" +
"Power Moonroof, Not Present, 0" ;
		
	public static void readAndSetOptions( Automotive auto)
	{
		try
		{	
			String str;
			int parsePrice = 0 ;
			String make ;
			String model ;
			int basePrice ;
			
			InputStream input =  new ByteArrayInputStream(opts.getBytes()) ;					
			BufferedReader br = new BufferedReader(new InputStreamReader(input));	//BufferedReader is a wrapper class that can read chunk of data from file
			
			
			str = br.readLine();						//Reading make, model and basePrice from 1st line
			String[] basicDetails = str.split("/");	    //Using / as delimiter
			if(basicDetails.length != 3)
			{
				System.out.println("Invalid entries for make, model and basePrice");
				make = "Invalid" ;
				model = "Invalid" ;
				basePrice = 0 ;
			}
			else
			{
				make = basicDetails[0] ;
				model = basicDetails[1] ;
				try
				{
					basePrice = Integer.parseInt(basicDetails[2].trim()) ;
				}
				catch(NumberFormatException e)
				{
					System.out.println( "Invalid price = " + basicDetails[2].trim()) ;
					basePrice = 0 ;
				}
			}

			auto.setMake(make);
			auto.setModel(model) ;
			auto.setBasePrice(basePrice) ;
			
			while((str = br.readLine()) != null)		//Continue reading until all the lines are read
			{	
				
				if(str.isEmpty())
				{
					continue ; // skip empty lines
				}
									
				
				String[] optionDetails = str.split(",");	//Split each line with ',' as delimiter
				
				
				//Entry should contain 3 items for OptionSet, Option and Price, else it's an invalid entry
				
				if(optionDetails.length != 3)
				{
					System.out.println( "Entry ignored. Invalid number of arguments in option details  = " + str) ;
					continue ;
				}
				
				try
				{
					parsePrice = Integer.parseInt(optionDetails[2].trim()) ;
				}
				catch(NumberFormatException e)
				{
					System.out.println( "Entry ignored. Invalid price = " + optionDetails[2].trim()) ;
					continue ;
				}
				
				OptionSet optionSet = auto.getOptionSet(optionDetails[0]);
				
				if(optionSet == null) // Doesn't already exist in the list , new optionSet
				{
					try
					{
						auto.addOptionSet(optionDetails[0], 0);
					}
					catch(InvalidOptionCountException e)
					{
						
					}
					auto.setOptions(optionDetails[0], new ArrayList<Option>());

				}

				auto.addOrUpdateOption(optionDetails[0] , optionDetails[1], parsePrice);
				
			} 
			
			input.close();
			br.close();

		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
}
