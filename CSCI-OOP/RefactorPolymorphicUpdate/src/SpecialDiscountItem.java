public class SpecialDiscountItem extends Item {

	private static double DISCOUNT_RATE = 0.05;
	
	enum ItemType {food, cloth, electronics, cosmetics, games};
	
	public static ItemType type;
	
	private static ItemType food, cloth;
	
	//
	private double OTHERS_50 = 1.5;
	
	Item item = new Item();
	
	//getDiscountRate method for the specialDiscount
		public double getDiscountRate() {
			
				//checking the type of item
			if (type == food || type == cloth) {
				
				//checking the SubTotal (it has to be greater than 1 for the special discount
				//to apply
				if (item.getSubTotal() > 1) {
					
					DISCOUNT_RATE = item.getSubTotal() * OTHERS_50;
				}
				
				return DISCOUNT_RATE;
			}
			
			return DISCOUNT_RATE;
		}
		
}
