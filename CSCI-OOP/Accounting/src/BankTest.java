//BankTest class with the main method of the BankAccount class
public class BankTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		
			//Constructor method to create an instance of the BankAccount class
			BankAccount bkacc = new BankAccount();
			
			//Clone method to get a deep copy of the BackAccount object
			BankAccount bkacctO = (BankAccount)bkacc.clone();
			
			//Initiatilize the amt to zero
			double amt = 0;
			
			//The depositAmt method
			bkacctO.depositAmt(amt);
			
			//The withdrawAmt method
			bkacctO.withdrawAmt(amt);
			
			//The checkBalance method
			System.out.println("Your balance is " + bkacctO.checkBalance());
			
	}

}
