package xlsEngine.interfaces;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import xlsEngine.exceptions.XSLEngineException;

public interface If_XsltEngine {
	
	public void execute(InputStream isXml, InputStream isXslt, OutputStream osXml ) throws XSLEngineException;
	public void execute(String xmlPath, String xsltPath, String  xmlOutPath ) throws XSLEngineException;
	public void execute(String xmlPath, List<String> listXSLT, String xmlOutPath) throws XSLEngineException;
	public void execute(InputStream xmlPath, List<InputStream> listXSLT, OutputStream xmlOut) throws XSLEngineException;

}
