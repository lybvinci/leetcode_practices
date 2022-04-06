package com.monster.learn;

public class AngleClock {

	private final int HOUR_RATO = 360 / 12;
	private final double HOUR_MINUTE_RATO = HOUR_RATO / 60.0f;
	private final int MINUTE_RATO = 360 / 60;

	//100.00%
	public double angleClock(int hour, int minutes) {
		if (hour == 12) {
			hour = 0;
		}
		double h1 = hour * HOUR_RATO;
		h1 += minutes * HOUR_MINUTE_RATO;
		double m1 = minutes * MINUTE_RATO;

		double ret = Math.abs(h1 - m1);
		if (ret > 180) {
			ret = 360 - ret;
		}
		return ret;
	}	

	public static void main(String[] args) {
		AngleClock ac = new AngleClock();
		ac.angleClock(12, 30);
	}

}
