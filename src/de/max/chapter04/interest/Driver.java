package de.max.chapter04.interest;

public class Driver {
	public static void main(String[] args)
	{
		Account account = new Account(5_000);
		
		System.out.println(account.getBalance());
		account.applyInterest(10);
		System.out.println(account.getBalance());
	}

}
