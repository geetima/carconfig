package exceptionHandler;

@SuppressWarnings("serial")
public class NonExistingOptionException extends Exception{
	public NonExistingOptionException(String str)
	{
		System.out.println("Invalid Option Choice: "+str);
	}
}
