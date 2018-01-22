/**
 * 
 */
package xlsEngine.exceptions;

/**
 * @author gabriel
 *
 */
public class XSLEngineException extends Exception {

	private Exception exception;
	/**
	 * 
	 */
	public XSLEngineException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public XSLEngineException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public XSLEngineException(String message,Exception e) {
		super(message);
		this.exception= e;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public XSLEngineException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public XSLEngineException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public XSLEngineException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	
	public Exception getException(){
		return this.exception;
	}
}
