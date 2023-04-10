
public class FindTestValueB {
	
	//Assigning value to item to avoid NullPointerException
	//3 is intentionally left out from the list. It will be used as the testValue
	int [] item = new int[] {0,1,9,5,4,2,6,8,7};
	
	boolean find(int testValue) {
		
		int initialValue = item[item.length-1];
		
		item[item.length-1] = testValue;
		
		int i = 0;
		
		while (item[i] != testValue) {
			i++;
		}
		
		item[item.length-1] = initialValue;
		
		return i < item.length-1 || testValue == initialValue;
	
	}

}
