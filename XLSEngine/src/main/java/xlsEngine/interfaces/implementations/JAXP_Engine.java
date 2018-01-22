/**
 * 
 */
package xlsEngine.interfaces.implementations;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import xlsEngine.exceptions.XSLEngineException;
import xlsEngine.interfaces.If_XsltEngine;

/**
 * @author gabriel
 *
 */
public class JAXP_Engine implements If_XsltEngine {

	private static TransformerFactory transFact = null;

	public JAXP_Engine() {
		if (transFact == null) {
			transFact = TransformerFactory.newInstance();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xlsEngine.interfaces.If_XsltEngine#execute(java.io.InputStream,
	 * java.io.InputStream, java.io.OutputStream)
	 */
	@Override
	public void execute(InputStream isXml, InputStream isXslt, OutputStream osXml) throws XSLEngineException {

		Source xmlSource = new StreamSource(isXml);
		Source xsltSource = new StreamSource(isXslt);
		Result result = new StreamResult(osXml);
		
		Transformer trans;
		try {
			trans = transFact.newTransformer(xsltSource);
			trans.transform(xmlSource, result);
		} catch (TransformerException e) {
			e.printStackTrace();
			throw new XSLEngineException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xlsEngine.interfaces.If_XsltEngine#execute(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void execute(String xmlPath, String xsltPath, String xmlOutPath) throws XSLEngineException {

		File xmlFile = new File(xmlPath);
		File xsltFile = new File(xsltPath);
		File output = new File(xmlOutPath);

		Source xmlSource = new StreamSource(xmlFile);
		Source xsltSource = new StreamSource(xsltFile);
		Result result = new StreamResult(output);

		// create an instance of TransformerFactory

		Transformer trans;
		try {
			trans = transFact.newTransformer(xsltSource);
			trans.transform(xmlSource, result);
		} catch (TransformerException e) {
			e.printStackTrace();
			throw new XSLEngineException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xlsEngine.interfaces.If_XsltEngine#execute(java.lang.String,
	 * java.util.List, java.lang.String)
	 */
	@Override
	public void execute(String xmlPath, List<String> listXSLT, String xmlOutPath) throws XSLEngineException {

		File xmlFile = new File(xmlPath);

		Source input = null;
		Source xsltSource = null;
		Transformer trans = null;
		Result result = null;

		input = new StreamSource(xmlFile);

		for (String xsltFile : listXSLT) {

			xsltSource = new StreamSource(new File(xsltFile));
			StringWriter sw = new StringWriter();
			result = new StreamResult(sw);

			try {
				trans = transFact.newTransformer(xsltSource);
				trans.transform(input, result);

			} catch (TransformerException e) {
				throw new XSLEngineException(e);
			}

			try {
				input = new StreamSource(fromStringWriter2InputStream(sw));
			} catch (UnsupportedEncodingException e) {
				throw new XSLEngineException(e);
			}
		}

	}
	
	
	private InputStream fromStringWriter2InputStream(StringWriter sw)
			throws UnsupportedEncodingException {

		return fromStringWriter2InputStream(sw, "UTF-8");
		
	}
	

	private InputStream fromStringWriter2InputStream(StringWriter sw, String encoding)
			throws UnsupportedEncodingException {

		byte[] barray;
		barray = sw.toString().getBytes(encoding);

		InputStream is = new ByteArrayInputStream(barray);
		return is;
	}
	
	public void execute(InputStream xmlIn, List<InputStream> listXSLT, OutputStream xmlOut) throws XSLEngineException{

		
		Source input = null;
		Source xsltSource = null;
		Transformer trans = null;
		Result result = null;

		input = new StreamSource(xmlIn);

		for (InputStream xsltFile : listXSLT) {

			xsltSource = new StreamSource(xsltFile);
			StringWriter sw = new StringWriter();
			result = new StreamResult(sw);

			try {
				trans = transFact.newTransformer(xsltSource);
				trans.transform(input, result);

			} catch (TransformerException e) {
				// e.printStackTrace();
				throw new XSLEngineException(e);
			}

			try {
				input = new StreamSource(fromStringWriter2InputStream(sw));
			} catch (UnsupportedEncodingException e) {
				throw new XSLEngineException(e);
			}
		}
	}

}
