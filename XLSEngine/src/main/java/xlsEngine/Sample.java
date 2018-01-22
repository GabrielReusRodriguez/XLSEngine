package xlsEngine;

import java.util.ArrayList;
import java.util.List;

import xlsEngine.exceptions.XSLEngineException;
import xlsEngine.interfaces.If_XsltEngine;
import xlsEngine.interfaces.implementations.JAXP_Engine;

/**
 * A simple demo of Xalan 1. This code was originally written using Xalan 1.2.2.
 * It will not work with Xalan 2.
 */
public class Sample {

	/**
	 * Accept two command line arguments: the name of an XML file, and the name of
	 * an XSLT stylesheet. The result of the transformation is written to stdout.
	 */
	public static void main(String[] args) throws javax.xml.transform.TransformerException {
		If_XsltEngine xsltEngine = new JAXP_Engine();
		
		try {
			//xsltEngine.execute("C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xml\\input.xml", "C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xslt\\input.xslt", "C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xml\\output.xml");
			/*
			List<String> xslts = new ArrayList<String>();
			xslts.add("C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xslt\\input.xslt");
			xslts.add("C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xslt\\input.xslt");
			xsltEngine.execute("C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xml\\input.xml",xslts, "C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xml\\output.xml");
			*/
			
			xsltEngine.execute("C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xml\\input2.xml", "C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xslt\\input2.xslt", "C:\\Users\\gabriel\\git\\XLSEngine\\XLSEngine\\xml\\output2.xml");
			
		} catch (XSLEngineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}