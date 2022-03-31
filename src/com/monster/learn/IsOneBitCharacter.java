package com.monster.learn;

public class IsOneBitCharacter {
	//100.00%
	public boolean isOneBitCharacter(int[] bits) {
		if (bits[bits.length - 1] != 0) {
			return false;
		}
		int count = 0;
		for (int i = bits.length - 2; i >= 0; i--) {
			if (bits[i] == 1) {
				count++;
			} else {
				break;
			}
		}
		return count % 2 == 0;
	}

	public static void main(String[] args) {
		IsOneBitCharacter ibc = new IsOneBitCharacter();
		ibc.isOneBitCharacter(new int[]{0});
	}
}
