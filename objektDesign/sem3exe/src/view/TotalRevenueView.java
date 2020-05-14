/**
 * 
 */
package view;

import model.RevenueObserver;
import model.Amount;

/**
 * @author Nikita
 *Totalrevenue class that never calls controller implements revenueobserver in model
 */
public class TotalRevenueView implements RevenueObserver{
	private int totalAmount;
	/*Prints total revenue
	 * @param rev total revenue
	 * 
	 */
	@Override
	public void updateRevenue(Amount rev){
		this.totalAmount = rev.getAmount();
		System.out.println("**TOTALREVENUE: " + rev.getAmount());
	}

}
