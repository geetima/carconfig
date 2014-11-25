package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Automotive;
import model.OptionSet;

public class FileIO {
	
	public static ArrayList<OptionSet> readAndSetOptions(String filename , Automotive auto){
		try {
			FileReader fr = new FileReader(new File(filename));
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line=br.readLine())!=null) {
				if(line.length()!=0) {
					String[] optionSetValues = line.trim().split(",");
					if(optionSetValues.length!=3) {
						System.out.println("Entry ignored. Invalid number of arguments in option details  = "+ line);
						continue;
					}
					int price = 0;
					try{
						price = Integer.parseInt(optionSetValues[2].trim());
					} catch(NumberFormatException e) {
						System.out.println("Illegal number "+optionSetValues[2]);
						continue;
					}
					OptionSet optionSet = auto.getOptionSet(optionSetValues[0]);
					if(optionSet==null) {
						optionSet = new OptionSet(optionSetValues[0].trim());
						auto.addOptionSet(optionSet);
					}
					optionSet.addOrUpdateOption(optionSetValues[1].trim(),price);
				}
			}
			br.close();
			return auto.getoptionSets();
		} catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void serializeAutomotive(Automotive auto, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(auto);
			oos.close();
			fos.close();
		} catch(FileNotFoundException e) {
			System.out.println("Failed to serialize object. File not found at path = "+ path);
		} catch(IOException e) {
			System.out.println("Failed to serialize object. IO Exception");
		}
	}
	
	public static Automotive deSerializeAutomotive(String path) {
		Automotive auto = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			auto = (Automotive)ois.readObject();
			ois.close();
			fis.close();
		} catch(FileNotFoundException e) {
			System.out.println("Failed to de-serialize object. File not found at path = "+ path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Failed to de-serialize object. IO Exception");
		}
		return auto;
	}
}
