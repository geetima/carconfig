package clientSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import exceptionHandler.NonExistingOptionException;
import exceptionHandler.NonExistingOptionSetException;

import model.Automotive;

public class SelectCarOption {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NonExistingOptionSetException, NonExistingOptionException
	{
	
	Socket clientSocket = null;
    BufferedReader in = null;
    ObjectInputStream ois = null;
    PrintWriter out = null;
    BufferedReader stdIn = null;

    try {
        clientSocket = new Socket("127.0.0.1", 6789);
        out = new PrintWriter(clientSocket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ois = new ObjectInputStream(clientSocket.getInputStream());
        stdIn = new BufferedReader(new InputStreamReader(System.in));
        
    } catch (UnknownHostException e) {
        System.err.println("Don't know about host: Rockstar.");
        System.exit(1);
    } catch (IOException e) {
        System.err.println("Couldn't get I/O for the connection to: Rockstar.");
        e.printStackTrace();
        System.exit(1);
    }
    out.println("SelectCarOption");
    String serverInput, userInput = null;
    Automotive auto = new Automotive();
    String[] optionChoices = new String[5];
    
    while((serverInput = in.readLine())!=null)
    {
    	System.out.println(serverInput);
    }
    
    System.out.println("Please select your model ");
    
    userInput = stdIn.readLine(); 
    
    if(userInput != null)
    {	System.out.println("dsw");
    	out.println(userInput);
    	
    }
    auto = (Automotive)ois.readObject();
    
    System.out.println("Here are your choices: ");
    System.out.println(auto);
    System.out.println("Please input the value for Transmission");
    optionChoices[0] = stdIn.readLine(); 
    auto.setOptionChoice("Transmission", optionChoices[0]);
    
    System.out.println("Please input the value for Brakes/Traction Control");
    optionChoices[1] = stdIn.readLine(); 
    auto.setOptionChoice("Brakes/Traction Control", optionChoices[1]);
    
    System.out.println("Please input the value for Color");
    optionChoices[2] = stdIn.readLine(); 
    auto.setOptionChoice("Color", optionChoices[2]);
    
    System.out.println("Please input the value for Side Impact Air Bags");
    optionChoices[3] = stdIn.readLine(); 
    auto.setOptionChoice("Side Impact Air Bags", optionChoices[3]);
    
    System.out.println("Please input the value for Power Moonroof");
    optionChoices[4] = stdIn.readLine(); 
    auto.setOptionChoice("Power Moonroof", optionChoices[4]);
    
    System.out.println("Here are the choices for your car");
    System.out.println("Automotive Name : "+auto.getAutoName());
    System.out.println("Car Make : "+auto.getMake());
    System.out.println("Car Model : "+auto.getModel());
    System.out.println("Car Base Price : "+auto.getBasePrice());
    System.out.println("Transmission : "+auto.getOptionChoice("Transmission"));
    System.out.println("Brakes/Traction Control : "+auto.getOptionChoice("Brakes/Traction Control"));
    System.out.println("Color : "+auto.getOptionChoice("Color"));
    System.out.println("Side Impact Air Bags : "+auto.getOptionChoice("Side Impact Air Bags"));
    System.out.println("Power Moonroof : "+auto.getOptionChoice("Power Moonroof"));
    System.out.println("Total Price for your choices: "+auto.getTotalPrice());
    
    out.close();
    ois.close();
    in.close();
    stdIn.close();
    clientSocket.close();
	}
	      
}


