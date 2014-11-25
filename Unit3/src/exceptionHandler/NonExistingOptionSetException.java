package exceptionHandler;

@SuppressWarnings("serial")
public class NonExistingOptionSetException extends Exception {
	public NonExistingOptionSetException(String str)
	{
		System.out.println("Invalid Option Set: "+str);
	}
}
