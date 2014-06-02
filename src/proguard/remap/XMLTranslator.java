package proguard.remap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
public class XMLTranslator {
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

	private ReverseMapper reverseMap;

	public XMLTranslator(ReverseMapper map) {
		this.reverseMap = map;
	}

	/* http://dom4j.sourceforge.net/dom4j-1.6.1/guide.html */
	public static Document transformDocument(Document document, String stylesheet) throws Exception {

	        // load the transformer using JAXP
	        TransformerFactory factory = TransformerFactory.newInstance();
	        Transformer transformer = factory.newTransformer( 
	            new StreamSource( stylesheet ) 
	        );

	        // now lets style the given document
	        DocumentSource source = new DocumentSource( document );
	        DocumentResult result = new DocumentResult();
	        transformer.transform( source, result );

	        // return the transformed document
	        Document transformedDoc = result.getDocument();
	        return transformedDoc;
    }

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
 *    <Property classname="edu.umd.cs.findbugs.detect.DeadLocalStoreProperty" name="METHOD_RESULT" value="true"/>
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
	public void translateClassName(Element e) {
		Attribute className = e.attribute(CLASS_NAME);
		String old = className.getValue();
		className.setValue(this.reverseMap.getOriginalClass(old));

		for (Iterator i = e.elementIterator(SOURCE_LINE); i.hasNext(); ) {
			Element classElem = (Element) i.next();
			translateClassName(classElem);
		}
	}

	public void translateItem(Element item) {
		for (Iterator i = item.elementIterator(CLASS); i.hasNext(); ) {
			Element classElem = (Element) i.next();
			translateClassName(classElem);
		}

		for (Iterator i = item.elementIterator(METHOD); i.hasNext(); ) {
			Element method = (Element) i.next();

			Attribute className = method.attribute(CLASS_NAME);
			String oldClassName = reverseMap.getOriginalClass(className.getValue());
			className.setValue(oldClassName);

			Attribute signature = method.attribute("signature");
			String oldSignature = reverseMap.getOriginalSignature(signature.getValue());
			signature.setValue(oldSignature);

			Attribute methodName = method.attribute("name");
/*Changed here*/			String oldMethod = reverseMap.getOriginalMethodName(className.getValue(), methodName.getValue(), signature.getValue());
			methodName.setValue(oldMethod);

			//Changed here
			//translateClassName(method);
			for (Iterator j = method.elementIterator(SOURCE_LINE); j.hasNext(); ) {
				Element classElem = (Element) j.next();
				translateClassName(classElem);
			}
		}
		
		for (Iterator i = item.elementIterator(FIELD); i.hasNext(); ) {
			Element field = (Element) i.next();
			Attribute signature = field.attribute("signature");
			
			Attribute classAttr = field.attribute(CLASS_NAME);

			String oldSig = reverseMap.getOriginalSignature(signature.getValue());
			signature.setValue(oldSig);
			Attribute fieldName = field.attribute("name");
			String oldName = reverseMap.getOriginalField(classAttr.getValue(), fieldName.getValue());
			String oldClass = reverseMap.getOriginalClass(classAttr.getValue());
			String newName = fieldName.getValue();

			if (newName.contains("dkf")) {
	    		System.out.println("TRANSLATED " + oldClass + ":" + oldName);
	    	}
			fieldName.setValue(oldName);

			translateClassName(field);
		}
		
		for (Iterator i = item.elementIterator(SOURCE_LINE); i.hasNext(); ) {
			Element classElem = (Element) i.next();
			translateClassName(classElem);
		}
	}

	public Document translate(Document input) throws DocumentException {
		Document result = (Document) input.clone();

        Element root = result.getRootElement();

        // iterate through child elements of root
        for ( Iterator i = root.elementIterator(REPORT_ITEM); i.hasNext(); ) {
            Element item = (Element) i.next();
            translateItem(item);
        }

		return result;
	}

	public Document convertUsingXSLT(Document input, String inputXSLT, String outputXSLT) {
		// clone input document

 
		if (inputXSLT != null) {
			try {
				input = transformDocument(input, inputXSLT);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		Document result;
		try {
			result = translate(input);
		} catch (DocumentException e1) {
			e1.printStackTrace();
			return null;
		}

		if (outputXSLT != null) {
			try {
				result = transformDocument(input, outputXSLT);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String USAGE = "Usage: XMLTranslator inputFile mapFile outputFile [inputXSLTFile outputXSLTFile]";

		if (args.length < 2) {
			System.out.println(USAGE);
			return;
		}

		String inputFileName = args[0],
			   mapFileName = args[1],
			   outputFileName = args[2],
			   inputXSLTFile = null,
			   outputXSLTFile = null;

		if (args.length == 5) {
			   inputXSLTFile = args[3];
			   outputXSLTFile = args[4];
		}

		// load input XML
	    SAXReader xmlReader = new SAXReader();
	    Document inputFile;
	    try {
	    	inputFile = xmlReader.read(inputFileName);
	    	
	    } catch (Exception e) {
	    	System.err.println(e.toString());
	    	return;
	    }
	    

		// load map file into ReverseMapper
		File mapFile = new File(mapFileName);
		MappingReader mapReader = new MappingReader(mapFile);
		ReverseMapper revMap = new ReverseMapper();

		try {
			mapReader.pump(revMap);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			XMLTranslator translator = new XMLTranslator(revMap);
			Document output = translator.convertUsingXSLT(inputFile, inputXSLTFile, outputXSLTFile);
			/* code taken from http://dom4j.sourceforge.net/dom4j-1.6.1/guide.html */
	        // Pretty print the document to output file
			try {
		        OutputFormat format = OutputFormat.createPrettyPrint();
		        XMLWriter writer = new XMLWriter(
		            new FileWriter( outputFileName ),
		            format
		        );
		        writer.write(output);
		        writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
}
