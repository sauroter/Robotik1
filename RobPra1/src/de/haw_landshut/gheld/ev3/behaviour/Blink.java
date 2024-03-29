package de.haw_landshut.gheld.ev3.behaviour;

import de.haw_landshut.gheld.ev3.arbitrator.Arbitrator;
import de.haw_landshut.gheld.ev3.common.Wish;

public class Blink extends Behavior {

	public Blink(Arbitrator arbitrator, int priority) {
		// Kein Event, kein Readingtype
		super(arbitrator, priority, null);
	}

	@Override
	public void run() {
		try {
			while (true) {
				sendWish(Wish.LEDGREEN);
				Thread.sleep(500);
				sendWish(Wish.LEDOFF);
				Thread.sleep(500);
			}
		} catch (InterruptedException ex) {
			throw new RuntimeException(ex);
		}
	}

}