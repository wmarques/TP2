package package2;

/**
 * Exception thrown if there is a problem with the file : wrong number of parameters, negative parameters... 
 * This class extends Exception class.
 * @author William Marques, Alexandre Bruneau
 *
 */
public class FileFormatException extends Exception {
	
	/**
	 * Basic exception constructor, receiving the error message.
	 * @param message Message that will be displayed when the exception is thrown.
	 */
	public FileFormatException(String message) {
		super(message);
	}

}
