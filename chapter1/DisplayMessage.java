//Chapter 1, programming exercise 1.2
//Display "I love Java!" in a number of times
public class DisplayMessage {
	// The number of times the message is to be displayed
	//Declared as static because it is used in loop and thus not meant for any change
	private static int numOfTimes = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i<=numOfTimes; i++) {
			
			System.out.println("I love Java!");
			
		}
	}

}
