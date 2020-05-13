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
	/*Prints total revenue
	 * @param rev total revenue
	 * 
	 */
	@Override
	public void updateRevenue(Amount rev){
		System.out.println("**TOTALREVENUE: " + rev.getAmount());
	}

}
