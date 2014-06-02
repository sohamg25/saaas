package proguard.remap;

import java.io.*;

import proguard.obfuscate.*;
import edu.umd.cs.findbugs.annotations.*;
import edu.umd.cs.findbugs.ba.SignatureConverter;
import edu.umd.cs.findbugs.ba.SignatureParser;

public class RemapTest {
	public static void main(String[] args) {
		File mapFile = new File("/tmp/proguard_map.txt");
		MappingReader mapReader = new MappingReader(mapFile);
		ReverseMapper revMap = new ReverseMapper();
		
		try {
			mapReader.pump(revMap);
			
			System.out.println(revMap.getOriginalClass("_34ep2ls._o1ph0u._190osek._bon2ah._16iom4l._10sd0m6"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
