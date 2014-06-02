package proguard.obfuscate;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

import proguard.classfile.SimpleLibraryClasses;

/**
 * This <code>NameFactory</code> random names
 *
 * @author Soham Ghosh
 */
public class RandomNameFactory implements NameFactory
{
	private SecureRandom randomNumberGenerator = new SecureRandom();
	private static HashMap<Character, Character> charMap = new HashMap<Character, Character>();

	/**
	 * Creates a new <code>RandomNameFactory</code> that generates mixed-case names.
	 */
	public RandomNameFactory()
	{
		try {
			File file = new File("/tmp/charMap.txt");
			FileInputStream f = new FileInputStream(file);
			ObjectInputStream s = new ObjectInputStream(f);
			charMap = (HashMap<Character, Character>) s.readObject();
			s.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*List<Character> keys = new ArrayList<Character>(charMap.keySet());
		for (Character key: keys) {
		    System.out.println(key + ": " + charMap.get(key));
		}*/
	}

	// Implementations for NameFactory.
	
	public static void createMap()
	{
		Random rand=new Random();
		int min=97, max=122;
		int randomNum;
		char i;
		for(i='a';i<='z';i++){
			randomNum = rand.nextInt(max - min + 1) + min;
			charMap.put(i, (char)randomNum);
		}
		File file = new File("/tmp/charMap.txt");
		FileOutputStream f;
		try {
			file.delete();
			file = new File("/tmp/charMap.txt");
			f = new FileOutputStream(file);
			ObjectOutputStream s = new ObjectOutputStream(f);
			s.writeObject(charMap);
			s.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void reset()
	{
		System.out.println("Reset is called!");
		Exception e1=new Exception();
		e1.printStackTrace();
		randomNumberGenerator = new SecureRandom();
		charMap = new HashMap<Character, Character>();
		createMap();
		try {
			File file1 = new File("/tmp/charMap.txt");
			FileInputStream f1 = new FileInputStream(file1);
			ObjectInputStream s1 = new ObjectInputStream(f1);
			charMap = (HashMap<Character, Character>) s1.readObject();
			s1.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String nextName(String name)
	{
		System.out.println("Original Name: "+name);
		String newName="";
		if(name.charAt(name.length()-1) == '/')
			name=name.substring(0, name.length()-1);
		if(name.contains("/")){
			int indx = name.lastIndexOf('/');
			name = name.substring(indx+1);
		}
		if(name.contains("$")){
			int indx = name.lastIndexOf('$');
			char ch=name.charAt(indx+1);
			if(!Character.isDigit(ch))
				name = name.substring(indx+1);
		}
		/*else
			System.out.println(name);*/
		Character key=name.charAt(0);
		int i;
		if(SimpleLibraryClasses.containsClass(name))
			return name;
		if(name.equals("serialVersionUID"))
			return name;
		else if(name.length()>3 && (name.substring(0, 3).equalsIgnoreCase("set") || name.substring(0, 3).equalsIgnoreCase("get"))){
			i=3;
			newName+=name.substring(0, 3);
		}
		else if(name.length()>4 && (name.substring(0, 4).equals("this"))){
			i=4;
			newName+=name.substring(0, 4);
		}
		else if(name.charAt(0)=='_')
			return name;
		else{
			i=1;
			newName+=key;
		}
		for(;i<name.length();i++){
			key=name.charAt(i);
			if(name.charAt(i-1)=='$' || name.charAt(i-1)=='.'){
				newName+=key;
				continue;
			}
			if(name.charAt(i)=='E'){
				if(name.length()>=i+"Exception".length()){
					String cmp=name.substring(i, i+"Exception".length());
					if(cmp.equalsIgnoreCase("exception")){
						newName+=cmp;
						i=i+cmp.length()-1;
						continue;
					}
				}
			}
			if(name.charAt(i)>=97 && name.charAt(i)<=122)
				newName+=charMap.get(key);
			else if(name.charAt(i)>=65 && name.charAt(i)<=90) {
				key=(char) (name.charAt(i)+32);
				newName+=Character.toUpperCase(charMap.get(key));
			}
			else
				newName+=key;
		}
		System.out.println(newName);
		return newName;
	}

	public String nextName()
	{
		return "_" + new BigInteger(32, randomNumberGenerator).toString(32);
	}
}
