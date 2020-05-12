/**
 * 
 */
package integration;

/**
 * @author Nikita
 *Create the external systems
 */
public class SystemCreator {
	private ExternalAccountingSystem eas;
	private InventorySystem invSys;
	/*
	 * Creates accounting and inventorysystems
	 */
	public SystemCreator(){
		eas = new ExternalAccountingSystem();
		invSys = new InventorySystem();
		
	}
	/*
	 * @return externalaccountingsystem
	 */
	public ExternalAccountingSystem getEAS(){
		return eas;
	}
	/*
	 * @return inventorysystem
	 */
	public InventorySystem iS(){
		return invSys;
	}

}
