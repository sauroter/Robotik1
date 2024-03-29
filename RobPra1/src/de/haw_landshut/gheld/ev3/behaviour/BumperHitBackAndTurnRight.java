package de.haw_landshut.gheld.ev3.behaviour;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.common.Reading;
import de.haw_landshut.gheld.ev3.common.Wish;
import lejos.utility.Delay;

public class BumperHitBackAndTurnRight extends Behavior {

	public BumperHitBackAndTurnRight(Arbitrator arbitrator, int priority) {
		super(arbitrator, priority, Reading.Bumper);
	}

	@Override
	public void run() {
		int rv = getReadingValue();
		while (true){
			if (rv == 1) {
				sendWish(Wish.LEDRED);
				sendWish(Wish.BACKWARD);
				Delay.msDelay(2500);
				sendWish(Wish.STOP);
				sendWish(Wish.ROTATECCW);
				Delay.msDelay(2000);
				sendWish(Wish.FORWARD);
				Delay.msDelay(1000);
			} else {
				sendWish(Wish.NOTHING);
				Delay.msDelay(200);
			}
			rv = getReadingValue();
		}
	}

}
