package de.max.chapter04.interest;

public class Account {

	private static double interestRate = 1.5; // static --> relevant for all
	private static double defaultInterestRate = 5; // accounts
	private double balance; // non-static --> not relevant for all accounts

	// Constructors
	public Account()
	{
		setBalance(0);
	}

	public Account(double balance)
	{
		setBalance(balance);
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		int max = 10_000;
		if (balance <= max)
		{
			this.balance = balance;
		} else
		{
			System.out.println("Balance" + balance + " exceeds " + max);
		}
	}

	public static void setInterestRate(double z)
	{ // Scope of variable "z" limited is just the next block {...},
		interestRate = z;
	}

	public static double getInterestRate()
	{
		return interestRate;
	}

	public static void setDefaultInterestRate(double z)
	{ // Scope of variable "z" limited is just the next block {...},
		defaultInterestRate = z;
	}

	public static double getDefaultInterestRate()
	{
		return defaultInterestRate;
	}

	public void applyInterest()
	{
		if (balance >= 0)
		{
			balance *= (1 + interestRate / 100);
		} else
		{
			balance *= (1 + defaultInterestRate / 100);
		}
	}

	/*
	 * @param years the given time period.
	 */
	public void applyInterest(int years)
	{
		if (balance >= 0)
		{
			balance *= (1 + interestRate / 100);
		} else
		{
			balance *= (1 + defaultInterestRate / 100);
		}
	}

	/**
	 * Calculate the expected annual interest without changing the account's
	 * balance.
	 * 
	 * @return Annual interest to be expected
	 */
	public double getYearlyInterest()
	{
		if(balance >= 0)
		{
			return balance * interestRate / 100;

		} else 
		{
			return balance * defaultInterestRate / 100;
		}
	}
}
