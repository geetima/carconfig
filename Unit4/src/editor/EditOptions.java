package editor;
import exceptionHandler.NonExistingOptionSetException;

import model.Automotive;


public class EditOptions implements Runnable {
	static Automotive auto;
	String newOptionSetName ;
	String oldOptionSetName ;

	public EditOptions(Automotive automotive)
	{
		auto = automotive;
	}
	public String getNewOptionSetName() {
		return newOptionSetName;
	}
	public void setNewOptionSetName(String newOptionSetName) {
		this.newOptionSetName = newOptionSetName;
	}
	
	public String getOldOptionSetName() {
		return oldOptionSetName;
	}
	public void setOldOptionSetName(String oldOptionSetName) {
		this.oldOptionSetName = oldOptionSetName;
	}
	
	public void run()
	{
		try
		{
			auto.updateOptionSet(oldOptionSetName, newOptionSetName);
		}
		catch(NonExistingOptionSetException e )
		{
		}
	}



}
