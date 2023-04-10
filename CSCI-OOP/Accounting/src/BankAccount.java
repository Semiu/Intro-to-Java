//import the Scanner class from Java utility package to read input from the console
import java.util.Scanner;

//BankAccount class implementing Cloneable Interface
public class BankAccount implements Cloneable{
	
	//Bank Account class variables
	private String accountNum;
	private double accountBal;
	private String accountName;
	
	//Constructor method to create an object of the Scanner class -userIn
	Scanner userIn = new Scanner (System.in);
	
	/**
	 * set methods for the class variables
	 */
	
	//setAccountNum method
	public void setAccountNum (String num)
    {
       if(num != "")
    	   accountNum = num;
       //Assertion for the post-condition that accountNum cannot be null.
       assert accountNum != null;
    }
	
	//setAccountBal method
	//accountBal must always be zero or positive 
	public void setAccountBal (double bal)
	{
		if(bal >= 0)
			accountBal = bal;
		//Assertion for the post-condition that accountBal must be greater than or equal to zero.
	     assert accountBal >= 0;
	}

	//setAccountBal method
	public void setAccountName (String name)
	{
		if(name != "")
			accountName = name;
		//Assertion for the post-condition that accountName cannot be null.
	     assert accountName != null;
	}

	/**
	 * get methods for the class variables
	 */
	
	//getAccountNum method
	public String getAccountNum ()
    {
        return accountNum;
    }
	
	//getAccountBal method
	public double getAccountBal()
    {
        return accountBal;
    }
	
	//getAccountName method
	public String getAccountName()
    {
		
        return accountName;
    }
	
	/**
	 * depositAmt, withdrawAmt, and checkBalance methods for the BankAccount class
	 */
	
	//Pre-conditions for the depositAmt () method: 
	//(a)The amount to be deposited (passed as "double amt") must be greater than or equal to zero.
	//(b) The input must be number.
	public  void depositAmt (double amt) {
		
		boolean goodInput = false;
		
		System.out.println("How much do you want to deposit?");
		
		do {
			
			try {
				
				String amtWith = userIn.nextLine();
				
				amt = Double.parseDouble(amtWith);
				
				if (amt <= 0) {
					
					throw new CannotBeNegative("Amount must be greater than zero!");
					
				}
				
				goodInput = true;
				
			} catch (CannotBeNegative exp){
				
				System.out.println(exp.getMessage() + ". Enter the amount: ");
				
			} catch (NumberFormatException nfe) {
				
				System.out.println(nfe.getMessage() + " is not a number. Amount must be a number. Enter the amount: ");
				
			} 
			
		} while (!goodInput);
		
			accountBal += amt;
			
			System.out.println("Deposit successful");
			
	}
	
	//Pre-conditions for both the withdrawAmt () method: 
	//(a)The amount to be withdrawn (passed as "double amt") must be greater than or equal to zero.
	//(b) The amt must be greater than the account balance "accountBal". 
	//(c) The input must be number.
	public void withdrawAmt (double amt) {
		
		boolean goodInput = false;
		
		System.out.println("How much do you want to withdraw?");
		
		do {
			
			try {
				
				String amtWith = userIn.nextLine();
				
				amt = Double.parseDouble(amtWith);
				
				if (amt < 0) {
					
					throw new CannotBeNegative("Amount cannot be negative!");
					
				}else if (amt > accountBal) {
					
					throw new CannotbeGreaterThanBal("There is insufficient fund in your account.");
					
				}
				
				goodInput = true;
				
			} catch (CannotBeNegative exp){
				
				System.out.println(exp.getMessage() + " Enter the amount: ");
				
			} catch (NumberFormatException nfe) {
				
				System.out.println(nfe.getMessage() + " is not a number. Amount must be a number. Enter the amount: ");
				
			} catch (CannotbeGreaterThanBal bal) {
				
				System.out.println(bal.getMessage() + " Enter new amount: ");
	} 
			
		} while (!goodInput);
		
			accountBal -= amt;
			
			System.out.println("Withdrawal is successful");
			
	}
	
	//checkBalance method
	public double checkBalance () {
		
		return accountBal; 
		
	}
	
	//overriding the equals() method of the Cloneable Interface
	public boolean equals(Object o)
	{
		if(!(o instanceof BankAccount))
			return false;
		else
		{
			BankAccount bkacct = (BankAccount)o;
			if(this.accountNum == bkacct.accountNum)
				return true;
			else
				return false;
			}
	}
	
	//Publicly-accessible clone method for the BankAccount class
	public BankAccount clone() throws CloneNotSupportedException {
		
		return (BankAccount)super.clone();
		
	} 
	
}