package adapter;


import java.util.Iterator;
import java.util.LinkedHashMap;
import model.*;
import exceptionHandler.*;

//ProxyAutomotive encapsulates the components of the system
public abstract class ProxyAutomotive {
	
	private Automotive auto;
	
	//ProxyAutomotive Constructor
	
	public ProxyAutomotive()
	{
		auto = new Automotive();
	}
	
	//Methods of Automotive called in this class to hide implementation
	//details of the components from outside world
	
	public String getMake() {
		return auto.getMake();
	}
	
	public void setMake(String make) {
		auto.setMake(make);
	}

	public String getModel() {
		return auto.getModel();
	}

	public void setModel(String model) {
		auto.setModel(model);
	}

	public int getBasePrice() {
		return auto.getBasePrice();
	}

	public void setBasePrice(int basePrice) 
	{
		auto.setBasePrice(basePrice);
	}
        
    public Iterator<String> getOptionSetNamesIterator(LinkedHashMap<String, OptionSet> optionSetMap)
    {
 	    return auto.getOptionSetNamesIterator(optionSetMap);
	}
   
    public void addOptionSet(String setName, int count) throws InvalidOptionCountException
    {
    	auto.addOptionSet(setName,count);
    }
   
    public void updateOptionSet(String setName, String newName)throws NonExistingOptionSetException
    {
    	auto.updateOptionSet(setName, newName);
    }
    public void deleteOptionSet(String setName)
    {
    	auto.deleteOptionSet(setName);
    }
   
    public OptionSet getOptionSet(String setName)
    {
	   return auto.getOptionSet(setName);
	    
    }
   
    public Option getOption(String setName, String optionName)
    {
	    return auto.getOption(setName, optionName);
    }
   
    public void setOption(String setName, int index, String optionName, int price)
    {
	    auto.setOption(setName, index, optionName, price);
    }
   
    public void setOptionChoice(String setName, String optionName) throws NonExistingOptionSetException, NonExistingOptionException
    {
	    auto.setOptionChoice(setName, optionName);
    }

    public int getOptionChoicePrice(String setName)
    {
	    return auto.getOptionChoicePrice(setName);
    }
   
    public String getOptionChoice(String setName)
    {
    	return auto.getOptionChoice(setName);
    }
   
    public int getTotalPrice()
    {
	    return auto.getTotalPrice();
    }
	
    public void readFile(String fileName)
	{
		System.out.println("Proxy Automotive Building Auto");
    	auto.readFile(fileName) ;
	}
	
	public void print()
	{
		System.out.println("Printing Automotive Properties: \n" +auto);
	}
	
	
}
