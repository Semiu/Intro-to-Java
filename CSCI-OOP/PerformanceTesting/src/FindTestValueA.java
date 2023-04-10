
public class FindTestValueA {
	
	//Assigning value to item to avoid NullPointerException
	//3 is intentionally left out from the list. It will be used as the testValue
	int [] item = new int[] {0,1,9,5,4,2,6,8,7};
	
	boolean find(int testValue) {
		boolean found = false;
		int i = 0;
		
		while ((!found) && (i<item.length)) {
			if (item[i] == testValue)
				found = true;
			else
				i++;
		}
		
		
		return found;
		
	}
}
