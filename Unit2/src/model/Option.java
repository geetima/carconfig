package model;


public class Option{

		private static final long serialVersionUID = 1L;
		private String name ;
		private int price ;
		
	//Constructor for Option
	
	Option ( String name , int price) {
		this.name = name ;
		this.price = price ;
	}
	
	//Getter and Setter Methods
	
	protected Option() {
	
	}

	protected String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected int getPrice() {
		return price;
	}
	
	protected void setPrice(int price) {
		this.price = price;
	}
	
	//Overriding toString() method for Option
	
	public String toString() {
		return "\tOption Name : " + name + " and Option Price : " + price + "\n" ;
		}
		
	}


