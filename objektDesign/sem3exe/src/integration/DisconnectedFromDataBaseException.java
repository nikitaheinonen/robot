/**
 * 
 */
package integration;

/**
 * @author Nikita
 *Exception class for database failure
 */
public class DisconnectedFromDataBaseException extends RuntimeException {
	
	/*
	 * @param message message to be shown on exception
	 */
	public DisconnectedFromDataBaseException(String message){
		super("\n**PUBLIC INTERFACE**\nThe store could not connect to database at this moment, try again later.");
	}

}
