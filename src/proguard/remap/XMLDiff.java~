package proguard.remap;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.DocumentException;
import org.dom4j.QName;
import org.dom4j.io.SAXReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;

import proguard.obfuscate.MappingReader;

/**
 * Convert obfuscated names back to original names in XML
 * below is the required format of the XML.
 * 
 *  <ReportItems>
 *   <ReportItem>
 *    <Class classname="org.saiko.ai.genetics.tsp.Report">
 *     <SourceLine classname="org.saiko.ai.genetics.tsp.Report" start="69" end="462" sourcefile="Report.java" sourcepath="org/saiko/ai/genetics/tsp/Report.java" />
 *    </Class>
 *    <LocalVariable name="errorID" register="2" pc="37" role="LOCAL_VARIABLE_NAMED" />
 *    <Property name="edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.METHOD_RESULT" value="true"/>
 *    <Method classname="org.saiko.ai.genetics.tsp.Report" name="saveReport" signature="(Ljava/io/File;[Lorg/saiko/ai/genetics/tsp/City;Ljava/awt/image/BufferedImage;Ljava/util/Map;Ljava/util/Map;)V" isStatic="false">
 *     <SourceLine classname="org.saiko.ai.genetics.tsp.Report" start="102" end="266" startBytecode="0" endBytecode="2190" sourcefile="Report.java" sourcepath="org/saiko/ai/genetics/tsp/Report.java"/>
 *    </Method>
 *    <SourceLine classname="org.saiko.ai.genetics.tsp.Report" start="233" end="233" startBytecode="1009" endBytecode="1009" sourcefile="Report.java" sourcepath="org/saiko/ai/genetics/tsp/Report.java"/>
 *    <Payload>
 *    	<... All the data related to this item being reported ...>
 *    </Payload>
 *   </ReportItem>
 *  </ReportItems>
 *  
 * Clients and servers should write XSLT that convert this document type to
 * their own and from their own document type to this one.
 * 
 * @author Soham Ghosh
 *
 */
public class XMLDiff {
	/*
	 * Takes the input file, a ReverseMapper object, (optionally) an XSLT
	 * to transform input to our doctype an XSLT to transform our output to
	 * the required output doctype, returns transformed XSLT.  
	 */
	private static final String REPORT_ITEM = "BugInstance",
						 		CLASS = "Class",
						 		FIELD = "Field",
						 		CLASS_NAME = "classname",
						 		SOURCE_LINE = "SourceLine",
						 		LOCAL_VARIABLE = "LocalVariable",
						 		PROPERTY = "Property",
						 		METHOD = "Method",
						 		PAYLOAD = "Payload";

	public XMLDiff() {
	}

	public String getClassName(Element e) {
		Attribute className = e.attribute(CLASS_NAME);
		return className.getValue();
	}

	public String getMapKey(Element item) {

		// key will have the format:
		//		category:lineStart:lineEnd:bugType:className:method:field
		//		key format changed to category:bugtype:className:method:field
		StringBuilder key = new StringBuilder();

		Attribute category = item.attribute("category");
		key.append(category.getValue());
		key.append(':');

		Attribute type = item.attribute("type");
		key.append(type.getValue());
		key.append(':');

		for (Iterator i = item.elementIterator(CLASS); i.hasNext(); ) {
			key.append(getClassName((Element) i.next()));
			key.append(":");
		}

		/*for (Iterator i = item.elementIterator(SOURCE_LINE); i.hasNext(); ) {
			Element ln = (Element) i.next();
			Attribute start = ln.attribute("start");
			Attribute end = ln.attribute("end");

			key.append(start.getValue());
			key.append(":");
			key.append(end.getValue());
			key.append(":");
		}*/
		
		for (Iterator i = item.elementIterator(LOCAL_VARIABLE); i.hasNext(); ) {
			Element lv = (Element) i.next();
			Attribute name = lv.attribute("name");
			key.append(name.getValue());
			key.append(":");
		}

		for (Iterator i = item.elementIterator(METHOD); i.hasNext(); ) {
			Element method = (Element) i.next();

			Attribute className = method.attribute(CLASS_NAME);
			key.append(className.getValue());
			key.append('.');

			Attribute methodName = method.attribute("name");
			key.append(methodName.getValue());
			key.append(":");

			Attribute signature = method.attribute("signature");
			key.append(signature.getValue());
		}
		
		for (Iterator i = item.elementIterator(FIELD); i.hasNext(); ) {
			Element field = (Element) i.next();
			Attribute signature = field.attribute("signature");
			Attribute classAttr = field.attribute(CLASS_NAME);
			Attribute fieldName = field.attribute("name");
			
			key.append(classAttr.getValue());
			key.append(signature.getValue());
			key.append(fieldName.getValue());
		}
		
		if (key.toString().contains("NotificationInfo")) {
			//System.out.println(key.toString());
		}

		return key.toString();
	}

	public HashMap<String, Pair<Element, Boolean>> makeMap(Document input) {
		HashMap<String, Pair<Element, Boolean>> map = new HashMap<String, Pair<Element, Boolean>>();

        Element root = input.getRootElement();

        // iterate through child elements of root
        for ( Iterator i = root.elementIterator(REPORT_ITEM); i.hasNext(); ) {
            Element item = (Element) i.next();
            String key = getMapKey(item);
            if (map.get(key) != null) {
            	System.err.println(key + " already exists");
            }
            map.put(key, new Pair<Element, Boolean>(item, false));
        }

		return map;
	}

	public Pair<Document, Document> diff(Document origXML, Document newXML) {
		// clone input document

 		Document extra = (Document) newXML.clone();
 		Document missing = (Document) extra.clone();

		HashMap<String, Pair<Element, Boolean>> map = makeMap(origXML);

		// Remove common ones from extra
		Element root = extra.getRootElement();

        // iterate through child elements of root
        for ( Iterator i = root.elementIterator(REPORT_ITEM); i.hasNext(); ) {
            Element item = (Element) i.next();
            String key = getMapKey(item);
            Pair<Element, Boolean> val = map.get(key);

            if (val != null) {
            	// this item matches
            	item.detach();
            	val.setR(true);
            	map.put(key, val);
            } else {
            	//System.out.println(item.asXML());
            }
        }

        root = missing.getRootElement();

        // Remove all bug reports
        for ( Iterator i = root.elementIterator(REPORT_ITEM); i.hasNext(); ) {
        		((Element) i.next()).detach();
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry)it.next();
            Pair<Element, Boolean> val = (Pair<Element, Boolean>) pairs.getValue();

            // if this element has not been found
            if (!val.getR()) {
            	root.add((Element) val.getL().clone());
            	//System.out.println(val.getL().asXML());
            }

            it.remove();
        }

		return new Pair<Document, Document>(missing, extra);
	}

	private static void writeDocument(Document doc, String fileName) {
		try {
	        OutputFormat format = OutputFormat.createPrettyPrint();
	        XMLWriter writer = new XMLWriter(
	            new FileWriter( fileName ),
	            format
	        );

	        writer.write( doc );
	        writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String USAGE = "Usage: XMLDiff originalXML newXML outputMissing outputExtra";

		if (args.length != 4) {
			System.out.println(USAGE);
			return;
		}

		String origFileName = args[0],
			   newFileName = args[1],
			   outputMissingName = args[2],
			   outputExtraName = args[3];

		// load input XML
	    SAXReader xmlReader = new SAXReader();
	    Document origXML, newXML;
	    try {
	    	origXML= xmlReader.read(origFileName);
	    	
	    } catch (Exception e) {
	    	System.err.println(e.toString());
	    	return;
	    }

	    try {
	    	newXML = xmlReader.read(newFileName);
	    	
	    } catch (Exception e) {
	    	System.err.println(e.toString());
	    	return;
	    }

		try {
			XMLDiff xmlDiff = new XMLDiff();
			Pair<Document, Document> output = xmlDiff.diff(origXML, newXML);
			System.out.println("Writing missing bugs.");
			writeDocument(output.getL(), outputMissingName);

			System.out.println("Writing extra bugs.");
			writeDocument(output.getR(), outputExtraName);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
}
