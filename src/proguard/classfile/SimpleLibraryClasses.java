package proguard.classfile;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleLibraryClasses {

	//Added by Soham Ghosh
    //An additional hashset of simple classnames that are either in libraryClassPool 
    //or in programClassPool.
    private static HashSet<String> simpleClassNames = new HashSet<String>();
    
    /**
     * Clears the library class pool.
     */
    public static void clear()
    {
    	simpleClassNames.clear();
    }
    
    /**
     * Adds the given simple Class name to the library class pool.
     */
    public static void addClass(String simpleClassname){
    	simpleClassNames.add(simpleClassname);
    }
    
    /**
     * Removes the specified simple Class name from the library class pool.
     */
    public static void removeClass(String simpleClassname){
    	simpleClassNames.remove(simpleClassname);
    }
    
    /*
     * Returns true if the library class pool contains the given simple class name
     * otherwise returns false
     */
    public static boolean containsClass(String simpleClassname){
    	return simpleClassNames.contains(simpleClassname);
    }
    
    /*
     * Returns an Iterator of all simple class names in the library class pool.
     */
    public static Iterator simpleClasses()
    {
        return simpleClassNames.iterator();
    }
    
    /**
     * Returns the number of simple classes in the library class pool.
     */
    public static int size()
    {
        return simpleClassNames.size();
    }
}
