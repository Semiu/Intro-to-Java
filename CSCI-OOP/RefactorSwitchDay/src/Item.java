//import java.util.Enumeration;

//import java.util.Vector;

//The Item class
public class Item {
	
	//The instance variables
	//private String title;
	
	private Item item;
	
	private double UNIT_PRICE;
	
	private int quantity;
	
	//private Vector itemList = new Vector();
	 Sale sale = new Sale ();
	//setItem method
	public void setItem (Item i) {
		this.item= i; 
		
	}
			
	//getItemitem method
	public Item getItem () {
		return this.item; 
		
	}
			
	//getItemTotal method
		public double getItemTotal() {
			
			//double finalTotal = 0.0;
			double finalTotal;
			//Return the number of elements in the itemList, i.e. the finalTotal
			 finalTotal = sale.getSubTotal();
			
			/**
			 * 
			Enumeration items = itemList.elements();
			
			while (items.hasMoreElements()) {
				
				finalTotal++;
			}
			 */
			
			return finalTotal;
		}
		
	//getItemCost method
	public double getItemCost() {
		
		UNIT_PRICE = 35;
		
		quantity = 4;
		
		return UNIT_PRICE * quantity;
	}
	
	
}
