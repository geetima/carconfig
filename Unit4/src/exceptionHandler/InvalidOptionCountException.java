package exceptionHandler;

@SuppressWarnings("serial")
public class InvalidOptionCountException extends Exception {
	
	public InvalidOptionCountException(int count) {
		System.out.println("Invalid count: " + count);		
	}
	
}


