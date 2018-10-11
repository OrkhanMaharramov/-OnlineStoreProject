package store;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author CYBERTEK_SCHOOL
 * 
 */
public class OnlineCTStores {
	//avaliable store items
	public static String[] ITEMS = {"Cactus", "T Shirt", "air", "Terracotta Necklace", "Coffee Mug", "Wood Crate Wall Storage", "Blanket", "Knife", "Copper Coffee and Tea Kettle", "Wall Art", 
			"Marble Clock", "Natural Bench", "Llama Valley Framed Print", "Gold Metal Frame Mirror", "Fork", "Star Wars game", "Barracuda", "Anchor", "Sunlight", "planet Saturn"};	
	//corresponding prices
	public static double[] PRICES = {49.99, 13.99, 5.99, 14.99, 29.99, 11.50, 79.99, 23.80, 27.99, 39.44, 78.40, 299.30, 55.00, 176.89, 4.99, 67.00, 8.19, 50.00, 1500, 400};
	public String[] SPECIAL_ITEMS = {"Cactus", "Fork" , "T Shirt"};
	public double SHIPPING_CHARGE = 11.50;

	/**
	 * Method that will find price of the item and return it
	 * Item index in the ITEMS array is corresponding to the index in the PRICES array
	 * @param item from ITEMS least 
	 * @return price for that item
	 */
	public double findItemPrice(String item){
		//TODO
		for(int i=0;i<ITEMS.length;i++) {
			if(ITEMS[i]==item) {
				
				return PRICES[i];
			}
			
		}
		return 0.0;
	}
		
	
	/**
	 * Calculate discount 1 
	 * For members: When purchased total 10 + items -> get 10% discount 
	 * For non-members: When purchased total 10 + items -> get 5% discount
	 * 
	 * If order has less then 10 items, then there will be no discount
	 * If no discount, then return 0
	 * @param List
	 *            of items in the order
	 * @return discount percent based on the items count
	 */
	public int discountByItemCount(String[] order, boolean isMember) {
		//TODO
		
		
		if(isMember && order.length>10 ) {
			
			
			return 10;
		}
		
		if(! isMember && order.length>10) {
			
			
			return 5;
		}
		
		
		return 0;
	}
/**
 * Method to calculate number of occurrences of a certain item in the order
 * 
 * For example, if order has the following items and item name is "cactus": 
 * 			      	"dog", "cactus", "cactus", "coffee mug" -> return 2
 * if order has the following items and item name is "coffee mug": 
 * 				    "dog", "cactus", "cactus", "coffee mug" -> return 1
 * if order has the following items and item name is "pillow": 
 *                "dog", "cactus", "cactus", "coffee mug", "coffee mug", "coffee mug" -> return 0
 * @param order 
 * @param itemName
 * @return  number of occurrences of a certain item in the order
 */
	public int getNumberOfItemOccurrences(String[] order, String itemName){
		//TODO
		int count=0;
		for(int i=0;i<order.length;i++) {
			if(order[i]==itemName) {
				count++;
		
			}
			
		}
		return count;
	}
	
	/**
	 * Method to calculate how many duplicated items in the order
	 * For example, if order has the following items: 
	 * 				"dog", "cactus", "cactus", "coffee mug" -> return 1
	 *              "dog", "cactus", "cactus", "coffee mug", "coffee mug", "coffee mug" -> return 2
	 *              
	 *              if order has no repeating items, return 0
	 *              "dog", "cactus", "table", "coffee mug" -> return 0
	 * 
	 * Use getNumberOfItemOccurrences() to check how many times each item is present in the list
	 * 
	 * @param order
	 * @return number of duplicated items in the order
	 */
	 
	public int getNumberOfDuplicateItems(String[] order) {
		
		//TODO
	
		int duplicate=0;
		for(int i=0;i<ITEMS.length;i++) {
			int count=0;
			for(int j=0;j<order.length && count<2;j++) {
				
				if(ITEMS[i].equalsIgnoreCase(order[j]) ) {
					count++;
					
					if(count==2) {
						duplicate++;
					}
				}
				
			}
		
		}
	        return duplicate;
	    }

	/**
	 * Calculate discount 2 
	 * For members: When purchased 3 special items  -> get 2 extra special items for free 
	 * For non-members: When purchased 3 special items -> get 1 special extra item for free
	 * 
	 * Special items are listed in a SPECIAL_ITEMS array
	 * 
	 * For example, if order has the following items and member is true: 
     * 			      	"dog", "cactus", "cactus", "coffee mug" -> return {"dog", "cactus", "cactus", "coffee mug"}
	 * if order has the following items and member is true: 
     * 			      	"dog", "cactus", "cactus", "cactus", "coffee mug" -> return {"dog", "cactus", "cactus", "cactus", "coffee mug", "cactus", "cactus"}
	 * if order has the following items and member is false: 
     * 			      	"dog", "cactus", "cactus", "cactus", "cactus", "coffee mug" -> return {"dog", "cactus", "cactus", "cactus", "cactus", "coffee mug", "cactus"}
	 * 
	 * When no special items in the order, then order will be returned without change
	 * 					"dog", "transmission", "barracuda", "coffee mug", "Star Wars game"
	 * 				
	 * @param List of items in the order, member
	 * @return new array that will have original items in the order and free items added at the end of the order
	 */
		public String[] buyThreeDiscount(String[] order, boolean isMember) {
			//TODO
			int count=0;
	
			 ArrayList <String> newList=new ArrayList<>();
			 
			 for(String x:order) {
				 
				 newList.add(x);
			 }
			for(int i=0;i<SPECIAL_ITEMS.length;i++) {
			count=0;
				for(int j=0;j<order.length;j++) {
				if(isMember && SPECIAL_ITEMS[i].equalsIgnoreCase(order[j])) {
					count++;
					if(count==3) {
					newList.add(SPECIAL_ITEMS[i]);
					newList.add(SPECIAL_ITEMS[i]);
				
				
					}
					
					
				}
				
				if(!isMember && SPECIAL_ITEMS[i].equalsIgnoreCase(order[j])) {
					count++;
					if(count==3) {
						newList.add(SPECIAL_ITEMS[i]);
						
						
					}
					
				}
				
				}
			}
			
			String [] free= new String[newList.size()];
			for(int i=0;i<newList.size();i++) {
				
				free[i]=newList.get(i);
			}
		        return free;
		    }	
	/**
	 * Calculate total for all items in the order
	 * 
	 * Use findItemPrice() to find price of the item in the order and sum them up
	 * For example, if order has the following items and member is true: 
     * 			      	"Cactus", "T Shirt", "air" -> return 69.97
     * 
     * 
	 * @param order
	 * @return order total
	 */
	public double getOrderTotalWithoutDiscount(String[] order) {
		//TODO
		double sum=0.0;
	
		for(int i=0;i<order.length;i++) {
			
				sum+=findItemPrice(order[i]);
				
			
		}
		
        return sum;
    }

	/**
	 * Calculate discount 3 
	 * For members: When purchased 2 items that are over 50.00$ each -> get 18% 
	 * For non-members: When purchased 2 items that are over 75.00$ each -> get 7%
	 * 
	 * For example: if order has the following items and member is true: 
     * 			      	"Cactus", "T Shirt", "air" -> return 0
	 * 
	 * @param List of items in the order
	 * @return discount percent based on the individual item price
	 */
	public int discountByItemPrice(String[] order, boolean isMember) {
		//TODO
		int count =0;
		for(int i=0;i<order.length;i++) {
			if(isMember && ITEMS[i].equalsIgnoreCase(order[i])) {
				count++;
				
				if(count==2 && PRICES[i]>50) {
					
					
				}
				return 18;
			}
			
			if(!isMember && ITEMS[i].equalsIgnoreCase(order[i])) {
				count++;
				
				if(count==2 && PRICES[i]>75) {
					
					
				}
				return 7;
			}
			
			
		}
        return 0;

    }
	
	/**
	 * Check if shipping is free
	 * For members: When total order amount is over 75.00$ -> free shipping
	 * For non-members: When total order amount is over 150.00$ -> free shipping
	 * 
	 * @param List
	 *            of items in the order
	 * @return true if free shipping is applicable, false otherwise
	 */
	public boolean isShippingFree(String[] order, boolean isMember) {
		//TODO
		double sum=0.0;
		for(int i=0;i<order.length;i++) {
			
			sum+=PRICES[i];
			if(isMember && sum>75 ) {
				return true;
			}
			if(!isMember && sum>150) {
				return true;
			}
		}
		return false;
    }

	
	
	/**
	 * Calculate total order amount
	 * When the order is eligible for two different discounts (total amount discounts), only one should be applied (the highest)
	 * 
	 * First find if any of the discount can be applied to the order: DiscountByItemPrice() 
	 *                                                                DiscountByItemCount()
	 * Apply highest of the two discounts, if any of them present
	 *                                                                
	 * Find if shipping is free or if not, add shipping charge       isShippingFree()
	 *  to add shipping charge use SHIPPING_CHARGE variable
	 * 
	 * 
	 * 
	 * @param List of items in the order           
	 * @return total order amount with discount and shipping charge if applicable
	 */
	public double calculateOrderTotalWithDiscountsAndShipping(String[] order, boolean isMember){
		//TODO
		int xP=discountByItemPrice(order, isMember); 
		int xC=discountByItemCount(order, isMember);
		boolean a =isShippingFree(order,isMember);
		double total=0.0;
		double sum=0.0;
		
		for(int i=0;i<order.length;i++) {

			if(xP>xC && a==false) {
				
				sum+=PRICES[i]; 
			
			total=sum*0.18 +SHIPPING_CHARGE; 
		
			}
			if(xP<xC && a==false) {
				
				sum+=PRICES[i];
			total=sum*0.10 +SHIPPING_CHARGE; 
			
			
			}else {
				total=sum;
				
			}
			
			
		
			
		}
		
		
		return total;
	    }
		
	/**
	 * This method will print receipt with all details including discounts 
	 */
	public void printReceipt(){
		//TO DO
	}




}
