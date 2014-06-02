package proguard.remap;

import java.util.HashMap;

import javax.xml.bind.ValidationException;

import edu.umd.cs.findbugs.ba.SignatureConverter;

import proguard.obfuscate.*;
public class ReverseMapper implements MappingProcessor {
	private HashMap<String, String> reverseClassMap = new HashMap<String, String>();
	private HashMap<String, String> reverseMethodMap = new HashMap<String, String>();
	private HashMap<String, String> reverseFieldMap = new HashMap<String, String>();
	// proguard setting useuniqueclassmembernames assigns the same obfuscated name
	// to the same field name. In these times the reverseFieldMap needs some help.
	private HashMap<String, String> fieldNameMap = new HashMap<String, String>();
    /**
     * Processes the given class name mapping.
     *
     * @param className    the original class name.
     * @param newClassName the new class name.
     * @return whether the processor is interested in receiving mappings of the
     *         class members of this class.
     */
    public boolean processClassMapping(String className,
                                       String newClassName) {
    	System.out.println("Map Entry: "+newClassName+" -> "+className);
    	if (reverseClassMap.get(newClassName) == null) {
    		reverseClassMap.put(newClassName, className);
    	}
    	
    	return true;
    }

    /**
     * Processes the given field name mapping.
     *
     * @param className    the original class name.
     * @param fieldType    the original external field type.
     * @param fieldName    the original field name.
     * @param newFieldName the new field name.
     */
    public void processFieldMapping(String className,
                                    String fieldType,
                                    String fieldName,
                                    String newFieldName) {
    	// map of the form className:fieldType:newFieldName -> fieldName
    	String key = className + ":" + newFieldName;
    	fieldNameMap.put(newFieldName, fieldName);
    	reverseFieldMap.put(key, fieldName);
    }

    /**
     * Processes the given method name mapping.
     *
     * @param className        the original class name.
     * @param firstLineNumber  the first line number of the method, or 0 if it
     *                         is not known.
     * @param lastLineNumber   the last line number of the method, or 0 if it
     *                         is not known.
     * @param methodReturnType the original external method return type.
     * @param methodName       the original external method name.
     * @param methodArguments  the original external method arguments.
     * @param newMethodName    the new method name.
     */
    public void processMethodMapping(String className,
                                     int    firstLineNumber,
                                     int    lastLineNumber,
                                     String methodReturnType,
                                     String methodName,
                                     String methodArguments,
                                     String newMethodName) {
    	// map of the form className:newMethodName:methodArguments:methodReturnType -> methodName
    	String key = className + ":" + newMethodName + ":" + methodArguments + ":" + methodReturnType;
    	//System.out.println(key + " -> " + methodName);
    	reverseMethodMap.put(key, methodName);
    }
    
    public String getOriginalClass(String newClass) {
    	String original;

    	if (newClass.endsWith("[]")) {
    		original = getOriginalClass(newClass.substring(0, newClass.length() - 2));
    		original =  (original == null) ? null : original + "[]";
    	} else {
    		original = reverseClassMap.get(newClass);
    	}

    	original = (original == null) ? newClass : original;

    	if (original != null && original.length() > 0 && !original.contains(".") && Character.isUpperCase(original.charAt(0))) {
			original = "java.lang." + original;
		}

		return original;
    }

    public String getOriginalField(String newClass, String fieldName) {
    	String oldClass = getOriginalClass(newClass);
    	String key = oldClass + ":" + fieldName;
    	
    	String original = reverseFieldMap.get(key);
    	original = original == null ? fieldNameMap.get(fieldName) : original;
    	return original == null ? fieldName : original;
    }

    /**
     * Give the orignal method name given a classname, method and its signature
     * 
     * @param newClass
     * @param newMethodName
     * @param signature
     * @return orignal method name
     */
    public String getOriginalMethodName(String newClass, String newMethodName, String signature) {
    	String origSig = getOriginalSignature(signature);

    	int retStart = signature.lastIndexOf(')');
    	if (retStart < 0) return null;
    	String retType = signature.substring(retStart + 1);
    	retType = SignatureConverter.convert(retType);

    	String args = SignatureConverter.convertMethodSignature("", "", origSig); /// HERE
    	int start = args.indexOf('(');
    	args = args.substring(start+1, args.indexOf(')'));
    	args = args.replace(" ", "");

    	return getOriginalMethodName(newClass, retType, newMethodName, args);
    }

    public String getOriginalMethodName(String newClass, String newMethodReturnType, String newMethodName, String newMethodArguments) {
    	System.out.println("newclass: "+newClass);
    	String oldClass = getOriginalClass(newClass);
    	System.out.println("oldclass: "+oldClass);
    	String oldMethodReturnType = getOriginalClass(newMethodReturnType);
    	String[] args = newMethodArguments.split(",");
    	String oldMethodArguments = "";

    	String newType;
    	for(int i=0; i < args.length && newMethodArguments.length() > 0; i++) {
    		if (i != 0)
    			oldMethodArguments += ",";

    		newType = getOriginalClass(args[i]);

    		oldMethodArguments += newType;
    	}

    	String key = oldClass + ":" + newMethodName + ":" + oldMethodArguments + ":" + oldMethodReturnType;
    	String original = reverseMethodMap.get(key);
    	System.out.println(key);

    	return original == null ? newMethodName : original;
    }

    public String getOriginalSignature(String signature) {
        StringBuilder result = new StringBuilder();
        String tmp = signature + "";

        while(tmp.length() > 0) {
	        if (tmp.startsWith("L")) {
	            int semi = tmp.indexOf(';');

	            if (semi < 0) {
	            	semi = tmp.indexOf(')');
	            	if (semi < 0)
	            		throw new IllegalStateException("malformed signature signature " + signature);
	            }

	            String part = tmp.substring(1, semi);
	            String className = part.replace('/', '.'),
	            	   oldClass  = getOriginalClass(className).replace('.', '/');
	            result.append("L");
	            result.append(oldClass);
	            result.append(";");
	            tmp = tmp.substring(semi + 1);
	        } else {
	        	result.append(tmp.charAt(0));
	            tmp = tmp.substring(1);
	        }
        }

        return result.toString();
    }

}