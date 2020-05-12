/**
 * 
 */
package model;

/**
 * @author Nikita
 *Amount class instead of using integers or doubles
 */
public class Amount {
	private final int amount;
	/*
	 * Creates a new Amount object 
	 * @param the value of amount to be created
	 */
	public Amount(int amount){
		this.amount = amount;
	}
	/*
	 * Adds two ammount
	 * @param add the other amount to be added to the current
	 * @return the sum
	 */
	public Amount add(Amount add){
		return new Amount(this.amount + add.amount);
	}
	
	/*
	 *Multiplies two amounts
	 *@param mult the other amount to multiply with
	 *@return the result 
	 */
	public Amount multiply(Amount mult){
		return new Amount(this.amount * mult.amount);
	}
	/*
	 * Get the value of amount
	 * @return the amount value
	 */
	public int getAmount(){
		return amount;
	}
	/*
	 * @param sub current amount to minus with
	 * @return new amount value
	 */
	public Amount sub(Amount sub){
		return new Amount(this.amount - sub.amount);
	}
	
	public String toString(){
		return Integer.toString(amount);
	}

}
