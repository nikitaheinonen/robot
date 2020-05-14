/**
 * 
 */
package integration;

/**
 * @author Nikita
 *Exception class for when the item id is not found
 */
public class FailedToFindItemIdException extends Exception {
	private String failedId;
	
	/*
	 * Creates a new instance with an error message and the item ID
	 * @param fail the item id not found in database
	 */
	public FailedToFindItemIdException(String fail){
		this.failedId = fail;
		
	}
	/*
	 * @return failedId the id that failed
	 */
	public String getFailId(){
		return failedId;
	}

}
