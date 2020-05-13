/**
 * 
 */
package integration;

/**
 * @author Nikita
 *Exception class for database failure
 */
public class DisconnectedFromDataBaseException extends RuntimeException {
	private String message;
	
	/*
	 * @param message message to be shown on exception
	 */
	public DisconnectedFromDataBaseException(String message){
		super("\n**PUBLIC INTERFACE**\nThe store could not connect to database at this moment, try again later.");
		this.message = message;
	}
	/*
	 * @return message the error message frmo exception
	 */
	public String getMessage(){
		return message;
	}

}
