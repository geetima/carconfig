package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class OptionSet implements Serializable{
	
	private String name;
	private List<Option> options ;
	@SuppressWarnings("unused")
	private int count;
	
	public OptionSet() {
		name = "Default Name" ;
		options = new ArrayList<Option>();
	}
	
	public OptionSet(String name) {
		this.name = name;
		options = new ArrayList<Option>();
	}
	
	public OptionSet(String name, int count) {
		this.name = name;
		this.count = count;
		options = new ArrayList<Option>(count);
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	public Option getOption(String optionName) {
		if(options==null) {
			return null;
		}
		for(int i=0;i<options.size();i++) {
			if(options.get(i).name.equals(optionName)) {
				return options.get(i);
			}
		}
		return null;
	}
	
	public int getOptionPrice(String optionName) {
		if(options==null) {
			return -1;
		}
		for(int i=0;i<options.size();i++) {
			if(options.get(i).name.equals(optionName)) {
				return options.get(i).price;
			}
		}
		return -1;
	}

	public int findOption(String name) {
		if(options==null) {
			return -1;
		}
		for(int i=0;i<options.size();i++) {
			if(options.get(i).name.equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void addOrUpdateOption(String name, int price) {
		int index = findOption(name);
		if(index==-1) {
			addOption(name,price);
		}
		else {
			updateOption(name,price,index);
		}
	}
	
	public void addOption(String name, int price) {
		
			Option option = new Option(name, price);
			options.add(option);
	}
	
	public void updateOption(String name, int price,int index) {
		Option option = options.get(index);
			option.setPrice(price);
	}
	
	public String toString() {
		String osData = "";
		osData+="OptionSet Name: "+name+"\n";
		osData+="Number of Options: "+getOptions().size()+"\n";
		for(int i=0;i<getOptions().size();i++) {
			osData+=getOptions().get(i)+"\n";
		}
		return osData;
	}
	private class Option implements Serializable{

		private String name;
		private int price;

		public Option(String name, int price) {
			this.name = name;
			this.price = price;
		}

		@SuppressWarnings("unused")
		public String getName() {
			return name;
		}

		@SuppressWarnings("unused")
		public void setName(String name) {
			this.name = name;
		}

		@SuppressWarnings("unused")
		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
		
		public String toString() {
			return "Name: "+name+", Price :"+price;
		}

	}


}
