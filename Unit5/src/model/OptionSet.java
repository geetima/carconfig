package model;

import java.io.Serializable;
import java.util.ArrayList;

import exceptionHandler.NonExistingOptionException;

public class OptionSet implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name ;
	private ArrayList<Option> options ;
	Option choice;
	
	//Overloading OptionSet Constructors
	
	protected OptionSet() {
		name = null ;
		options = null ;
	}
	
	protected OptionSet(String name) {
		this.name = name ;
		options = null ;
	}
	
	protected OptionSet(String name,  int count) {
		this.name = name ;
		options = new ArrayList<Option>(count) ;
	}
	
	//Getter and Setter Methods
	
	protected String getName() {
		return name;
	}
	
	protected  void setName(String name) {
		this.name = name;
	}
	
	protected ArrayList<Option> getOptions() {
		return options;
	}
	
	protected ArrayList<String> getOptionNames() {
		ArrayList<String> optionNames = null ;
		int size = options.size() ;
		if(size < 1)
		{
			return null;
		}
		else
		{
			optionNames = new ArrayList<String>();
		}
		for(int i =0 ; i < size ; i++)
		{
			Option option = options.get(i) ;
			optionNames.add(option.getName());
		}
		
		return optionNames;
	}
	
	protected  void setOptions(ArrayList<Option> options) {
		this.options = options;
	}
	
	//Set values for Option at given index with the name and price
	
	protected  void setOption(int i, String name, int price) {
		
		Option option = options.get(i) ;
		if( option != null )
		{
			option.setName(name);
			option.setPrice(price);	
		}
	} 
	
	//Return Option object with the given name
	
	protected Option getOption(String name) {
		int optionIndex = findOption(name) ;		
		if(optionIndex == -1)
		{
			return null ; 
		}
		else
		{
			return options.get(optionIndex);
		}

	}
	
	//Return Option price for the given name
	
	protected int getOptionPrice(String name) {
		int optionIndex = findOption(name) ;		
		if(optionIndex == -1)
		{
			return 0 ;
		}
		else 
		{
			return this.options.get(optionIndex).getPrice();
		}
	}
	
	//Return Option index for the given name
	
	protected int findOption(String name) {
		int size = options.size() ;
		for(int i =0 ; i < size ; i++)
		{
			Option option = options.get(i) ;
			if((option.getName()).equals(name))
			{
				return i ;
			}
		}
		
		return -1 ;
	}
	
	//Add or update an Option 
	
	protected  void addOrUpdateOption(String name, int price) {
		
		int index = findOption(name) ;
		if(index == -1) // Add
		{
			Option option = new Option(name,price);
			options.add(option) ;
		}
		else // Update
		{
			options.get(index).setPrice(price);
		}
		
	}
	
	//Delete an Option 
	
	protected  void deleteOption(String name) {
		int index = findOption(name) ;
		if(index != -1)
		{
			options.remove(index) ;
		}
	}
	
	
	
	//Overriding toString() method for OptionSet
	
	public String toString() {
		
		String optionSetStr = "\nOption Set Name : " + name + "\n" ;
		for(int i =0 ; i < options.size() ; i++)
		{
			optionSetStr += options.get(i) ;
		}
		
		if(choice == null)
		{
			optionSetStr += "No option selected\n" ;
		}
		else
		{
			optionSetStr += "Selected Choice for this OptionSet is : " + choice + "\n" ;
		}
		
		return optionSetStr ;
	}
	
	//Get the choice for the option
	
	protected Option getOptionChoice()
	{
		return choice;
		
	}
	
	//Set the option choice
	protected  void setOptionChoice(String optionName) throws NonExistingOptionException
	{
		int optionIndex = findOption(optionName) ;		
		if(optionIndex == -1)
		{
			throw new NonExistingOptionException(optionName);
		}
		choice = options.get(optionIndex);
	}

}
