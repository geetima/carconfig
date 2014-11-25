package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import java.util.Set;

import exceptionHandler.*;

import util.FileIO;

public class Automotive{

	private LinkedHashMap<String, OptionSet> optionSetMap = new  LinkedHashMap<String, OptionSet>();
	private String make ;
	private String model ;
	private int basePrice ;
	
	//Automotive Constructor
	
	public Automotive()
	{
	}
	
	//Getter and Setter Methods

	public LinkedHashMap<String, OptionSet> getOptionSetMap() {
		return optionSetMap;
	}
	
	public void setOptionSetList(LinkedHashMap<String, OptionSet> optionSetMap) {
		this.optionSetMap = optionSetMap;
	}
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}
       	
	//Return the iterator for the optionSet linkedHashMap
	
    public Iterator<String> getOptionSetNamesIterator(LinkedHashMap<String, OptionSet> optionSetMap)
    {
 	    Set<String> keys = optionSetMap.keySet(); //keys is the collection of strings to loop through
	    Iterator<String> iterator = keys.iterator();
	    return iterator;
	}
   
    //Add an OptionSet with name as setName and #options = count
    
    public void addOptionSet(String setName, int count) throws InvalidOptionCountException
    {
	    if( setName!= null && count >=0)
	    {
	    	OptionSet optionSet = new OptionSet(setName, count);
	    	optionSetMap.put(setName, optionSet );  
	    }
	    else if(setName== null)
	    {
	    		throw new NullPointerException();
	    }
	    else if(count < 0)
	    {
	    	throw new InvalidOptionCountException(count);
	    }
    }
   
    //Delete an optionSet
    
    public void deleteOptionSet(String setName)
    {
	    optionSetMap.remove(setName);  
    }
   
    //Given the OptionSet name, return the OptionSet if found, else return null
    
    public OptionSet getOptionSet(String setName)
    {
    	//Get method returns the value to which the specified key is mapped, 
    	//or null if this map contains no mapping for the key.
    	return optionSetMap.get(setName);
	    
    }
   
    //Return the option for the given optionSet name
    
    public Option getOption(String setName, String optionName)
    {
    	OptionSet optionSet = optionSetMap.get(setName);
    	if(optionSet != null)
    	{
    		return optionSet.getOption(optionName);
    	}
    	else
    	{
    		return null ;
    	}
    }
   
    //Add the option object to the given optionSet
    public void setOption(String setName, int index, String optionName, int price)
    {
    	OptionSet optionSet = optionSetMap.get(setName);
    	if(optionSet != null)
    	{
    		optionSet.setOption(index, optionName, price);
    	}
    }
   
    //Set the option choice for the optionSet
    
    public void setOptionChoice(String setName, String optionName) throws NonExistingOptionSetException, NonExistingOptionException
    {
    	OptionSet optionSet = optionSetMap.get(setName);
    	if(optionSet == null)
    	{
    		throw new NonExistingOptionSetException(setName) ;
    	}
    	optionSet.setOptionChoice(optionName);
    }

    //Get the option choice for the optionSet
    
    public String getOptionChoice(String setName)
    {
    	OptionSet optionSet = optionSetMap.get(setName);
    	return optionSet.getOptionChoice().getName();
    }
   
    
    //Get the price for the option choice of the optionSet
    
    public int getOptionChoicePrice(String setName)
    {
    	OptionSet optionSet = optionSetMap.get(setName);
    	Option choice = optionSet.getOptionChoice();
    	//Find the price of choice
    	if(choice !=null)
    	{
    		return choice.getPrice();
    	}
    	else
    	{
    		return 0 ;
    	}
    }
   
    //Get the total price for the automotive, given the choice of options
    
    public int getTotalPrice()
    {
    	int totalPrice = basePrice;
    	optionSetMap.values();  
    	Iterator<String> iterator = getOptionSetNamesIterator(optionSetMap);
    	if(iterator != null )
    	{
    		while(iterator.hasNext()) 
    	
		    {
	    		String element = iterator.next();
	    		totalPrice+=getOptionChoicePrice(element);
			}
    	}
    	return totalPrice;
    }
    
    //Overriding toString method
    
    public String toString()
	{
		String autoStr = "" ;
		
		autoStr = "\nAuto Make : " + make + "\n" ;
		autoStr += "Auto Model : " + model + "\n" ;
		autoStr += "Auto Base Price : " + basePrice + "\n\n" ;		
		autoStr += "# of Options : " + optionSetMap.size() + "\n" ;		
		
		Iterator<String> iterator = getOptionSetNamesIterator(optionSetMap);
		while(iterator.hasNext())
		{
			autoStr += optionSetMap.get(iterator.next()).toString() ;
		}
		
		return autoStr ;
	}

    //Get the arraylist of options for the optionSet
    
    public ArrayList<Option> getOptions(String opSetName) {
    	OptionSet os = optionSetMap.get(opSetName) ;
    	if(os != null)
    	{
    		return os.getOptions();    		
    	}
    	else
    	{
    		return null ;
    	}
	}
	
    
    //Add an option to the arraylist of options
    
    public void setOptions(String opSetName , ArrayList<Option> options) {
    	OptionSet os = optionSetMap.get(opSetName) ;
    	if(os != null)
    	{
    		os.setOptions(options);
    	}
	}
	
	//Return Option price for the given name
	
    public int getOptionPrice(String opSetName ,String name) {
    	OptionSet os = optionSetMap.get(opSetName) ;
    	if(os != null)
    	{
    		
    		return os.getOptionPrice(name);
    	}
    	else
    	{
    		return 0 ;
    	}
	}
	
	//Add or update an Option 
	
    public void addOrUpdateOption(String opSetName , String name, int price) {
    	OptionSet os = optionSetMap.get(opSetName) ;
    	if(os != null)
    	{
    		os.addOrUpdateOption(name, price);
    	}
	}
	
	//Delete an Option 
	
    public void deleteOption(String opSetName , String name) {
    	OptionSet os = optionSetMap.get(opSetName) ;
    	if(os != null)
    	{
    		os.deleteOption(name);
    	}
    }
    
    public void readFile(String fileName)
    {    	
    	FileIO.readAndSetOptions( fileName , this);    	
    }

}
