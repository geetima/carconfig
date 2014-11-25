package clientSocket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;

import exceptionHandler.InvalidOptionCountException;

import model.Automotive;

public class CarModelOptionsIO {
	
	public static void main(String[] args) throws IOException, FileNotFoundException, InvalidOptionCountException
	{
	
		Socket clientSocket = null;
	    BufferedReader in = null;
	    ObjectOutputStream oos = null;
	    
	    PrintWriter out = null;
	
	    try {
	        clientSocket = new Socket("127.0.0.1", 7777);
	        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        oos = new ObjectOutputStream(clientSocket.getOutputStream());
	        out = new PrintWriter(clientSocket.getOutputStream());
	        
	        //out.println("CarModelOptions");
	        CarModelOptionsIO carModelOptionsIO = new CarModelOptionsIO();
	        
	        carModelOptionsIO.sendProperties(oos);
		    
	        
	    } catch (UnknownHostException e) {
	        System.err.println("Don't know about host: Rockstar.");
	        System.exit(1);
	    } catch (IOException e) {
	        System.err.println("Couldn't get I/O for the connection to: Rockstar.");
	        e.printStackTrace();
	        System.exit(1);
	    }
	    
	   
	    
	   
	   // in.close();
	    //out.close();
	    //clientSocket.close();
	}
	
	
	public void sendProperties(ObjectOutputStream oos) throws InvalidOptionCountException
	{
	
		Properties props = new Properties();
		try 
		{
			
			props.load(new FileInputStream("AutomotiveOption1.properties"));
	        //Properties props is being stored(sent) on the stream
			oos.writeObject(props);
		} 
		catch (IOException ex) 
		{
			ex.printStackTrace();
	    }
		
	}
      
}


