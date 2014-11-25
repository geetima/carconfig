package model;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Automotive implements Serializable{
	private ArrayList<OptionSet> optionSets;
	private String name;
	private int basePrice;

	public Automotive(String name, int basePrice) {
		this.name = name;
		this.basePrice = basePrice;
		optionSets = new ArrayList<OptionSet>();
	}

	public Automotive(String name, int basePrice, ArrayList<OptionSet> optionSet) {
		this.name = name;
		this.basePrice = basePrice;
		this.optionSets = optionSet;
	}

	public ArrayList<OptionSet> getoptionSets() {
		return optionSets;
	}

	public ArrayList<OptionSet> getOptionSets() {
		return optionSets;
	}

	public void setOptionSets(ArrayList<OptionSet> optionSets) {
		this.optionSets = optionSets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return basePrice;
	}

	public void setPrice(int price) {
		this.basePrice = price;
	}

	public OptionSet getOptionSet(String name) {
		int index = findOptionSet(name);
		if (index == -1) {
			return null;
		}
		return optionSets.get(index);
	}

	public void updateOptionSet(OptionSet optionSet) {
		if (optionSet == null) {
			return;
		}
		int index = findOptionSet(optionSet.getName());
		if (index != -1) {
			optionSets.add(index, optionSet);
		}
	}

	public void addOptionSet(OptionSet optionSet) {
		int index = findOptionSet(optionSet.getName());
		if (index == -1) {
			optionSets.add(optionSet);
		}
	}

	public void deleteOptionSet(String name) {
		int index = findOptionSet(name);
		if (index != -1) {
			optionSets.remove(optionSets.get(index));
		}
	}

	public int findOptionSet(String name) {
		if (optionSets == null) {
			return -1;
		}
		for (int i = 0; i < optionSets.size(); i++) {
			if (optionSets.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	public String toString() {
		String autoData = "";
		autoData += "Automotive Name: " + name + "\n" + "BasePrice: " + basePrice + "\n";
		autoData += "Number of Option Sets :" + getOptionSets().size() + "\n";
		for (int i = 0; i < getOptionSets().size(); i++) {
			autoData += getOptionSets().get(i) + "\n";
		}
		return autoData;
	}
}
