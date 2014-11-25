package serverSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Properties;

import exceptionHandler.InvalidOptionCountException;

import model.Automotive;


public class BuildCarModelOptions implements Runnable{
	//Client Socket
	Socket clientSocket = null;
	
	//Class Constructor
	BuildCarModelOptions(Socket clientSocket)
	{
		this.clientSocket=clientSocket;
	}
	
	//LinkedHashMap for Automotive Objects with CarModel as the key
	private static LinkedHashMap<String, Automotive> automotiveMap = new  LinkedHashMap<String, Automotive>();
	
	
	public static void main(String[] args) throws IOException{
		
		//Client and Server Sockets
		ServerSocket serverSocket = null;
        Socket cSocket = null;
        
        //Creating a new serverSocket on port 6789. This is the port which the server listens to for client requests
        try {
            serverSocket = new ServerSocket(7777);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 6789");
            System.exit(1);
        }
        
        //Server creates a new port for each client it accepts the connection for
        try {
            cSocket = serverSocket.accept();
            new Thread(new BuildCarModelOptions(cSocket)).start();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        
       
	}
	
	//server run method
	public void run()
	{
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		BufferedReader  in = null;
		PrintWriter out = null;
	    try 
	    {
	    	//Creating Object Input/Output Streams to deserializing and serializing 
			//object on the input/output streams respectively
	    	ois = new ObjectInputStream(clientSocket.getInputStream());
	    	oos = new ObjectOutputStream(clientSocket.getOutputStream());
	    	
	    	//Creating input and output streams on the socket for writing to and 
	    	//reading from the client respectively
	    	in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	    	out = new PrintWriter(clientSocket.getOutputStream(), true);
	    	
	    	//Creating string object to read data from client
	    	//String clientip = in.readLine();
		
	    	//Reading serialized Properties object and de-serializing it
	    		Properties props= new Properties();
                props = (Properties)ois.readObject();
                
                BuildCarModelOptions carModelOptions = new BuildCarModelOptions(clientSocket);
                Automotive auto = new Automotive();
                
                //calling the method readPropertiesFile that returns auto object after 
                //processing the property object values
                auto = carModelOptions.readPropertiesFile(props);
                
                if(auto!=null)
                {
                	System.out.println("Automotive Details: "+auto);
                	automotiveMap.put(auto.getModel(),auto);
                	out.println("The Automotive Object is successfuly made!");
                }
                else
                {
                	System.out.println("Automotive object is null!");
                }
                String clientInput = null;

        		//Sending the model names to the client
    			 for (String key : automotiveMap.keySet())
    			 {
    				 out.println(key);
    			 }
    			 
    			 //Sending the auto object for given model choice by the client
    			 while((clientInput = in.readLine())!=null)
    			 {
    				 oos.writeObject(automotiveMap.get(clientInput));
    			 }
        	
        
    	out.close();
        in.close();
        ois.close();
        oos.close();
        clientSocket.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    } catch (ClassNotFoundException e) {
		e.printStackTrace();
	    } catch (InvalidOptionCountException e) {
		
		e.printStackTrace();
	    }
    }
	
	//Make an automotive object from the read Properties file
	public Automotive readPropertiesFile(Properties props) throws InvalidOptionCountException
	{
		
		Automotive auto = new Automotive();
		String autoName = props.getProperty("AutomotiveName");
		System.out.println(autoName);
		auto.setAutoName(autoName);
		String carMake = props.getProperty("CarMake");
		
		
		if(!carMake.equals(null))
		{	auto.setMake(carMake);
		
			String carModel = props.getProperty("CarModel");
			auto.setModel(carModel);
			
			String bp = props.getProperty("BasePrice");
			int basePrice = Integer.parseInt(bp);
			auto.setBasePrice(basePrice);
			
			String value=null;
			int price;
			ArrayList<String> optionSetName=new ArrayList<String>();
			
			for(String key : props.stringPropertyNames()) 
			{
				if(key.matches("Option\\d+$"))
				{
					value = props.getProperty(key);
					auto.addOptionSet(value, 0);
					optionSetName.add(key);
				}
			}
			for(String s:optionSetName)
			{	
				String temp = null;
				for(String key : props.stringPropertyNames())
				{	
					if(key.matches(s+"[a-z]Value"))
					{
						value = props.getProperty(key);
						temp = key.replace("Value", "Price");
						price = Integer.parseInt(props.getProperty(temp));
						auto.addOrUpdateOption(props.getProperty(s), value, price);
					}
				}
			}
			
		}
		return auto;
	}
	
}
