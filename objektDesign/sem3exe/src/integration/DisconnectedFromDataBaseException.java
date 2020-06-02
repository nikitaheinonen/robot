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
	private String messageDev = "";
	
	/*
	 * @param message message to be shown on exception
	 */
	public DisconnectedFromDataBaseException(String message){
		this.message = message;
		System.out.println(this);
	}
	/*
	 * @return message the error message frmo exception
	 */
	public String getMessage(){
		return message;
	}

}
