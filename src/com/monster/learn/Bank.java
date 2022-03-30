package com.monster.learn;

//43.24%
public class Bank {

	private final long[] mBalance;
	
	public Bank(long[] balance) {
		mBalance = balance;
	}
	
	public boolean transfer(int account1, int account2, long money) {
		account1--;
		account2--;
		if (account1 >= 0 && account2 >= 0 && account1 < mBalance.length
			&& account2 < mBalance.length && mBalance[account1] >= money) {
				mBalance[account1] -= money;
				mBalance[account2] += money;
				return true;
		} else {
			return false;
		}
	}
	
	public boolean deposit(int account, long money) {
		account--;
		if (account >= 0 && account < mBalance.length) {
			mBalance[account] += money;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean withdraw(int account, long money) {
		account--;
		if (account >= 0 && account < mBalance.length && mBalance[account] >= money) {
			mBalance[account] -= money;
			return true;
		} else {
			return false;
		}
	}	

}
