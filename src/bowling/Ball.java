package bowling;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

public class Ball {

	private final int pins;
	private final BallType type;

	public static Ball normalBall(int pins) {
		return new Ball(pins, BallType.NORMAL);
	}

	public static Ball spare(int pins) {
		return new Ball(pins, BallType.SPARE);
	}

	public static Ball strike() {
		return new Ball(10, BallType.STRIKE);
	}

	public static Ball finalFrameSpare(int pins) {
		return new Ball(pins, BallType.FINAL_FRAME_SPARE);
	}

	public static Ball finalFrameStrike() {
		return new Ball(10, BallType.FINAL_FRAME_STRIKE);
	}

	private Ball(int pins, BallType type) {
		this.pins = pins;
		this.type = type;
	}

	public int getPins() {
		return pins;
	}

	public boolean isSpare() {
		return EnumSet.of(BallType.SPARE, BallType.FINAL_FRAME_SPARE).contains(type);
	}

	public boolean isStrike() {
		return EnumSet.of(BallType.STRIKE, BallType.FINAL_FRAME_STRIKE).contains(type);
	}

	@Override
	public String toString() {
		return String.format("Ball %d", pins);
	}

	public String displayable() {
		return type.displayable(this);
	}

	public int getBonusAfter(List<Ball> balls) {
		int numberOfBonusBalls = type.numberOfBonusBalls();
		int indexAfterWhichToGetBalls = balls.indexOf(this);
		LinkedList<Ball> bonusBalls = new LinkedList<Ball>();
		int i = indexAfterWhichToGetBalls + 1;
		while (i < balls.size() && bonusBalls.size() < numberOfBonusBalls) {
			bonusBalls.add(balls.get(i));
			i++;
		}
		int bonus = 0;
		for (Ball bonusBall : bonusBalls) {
			bonus += bonusBall.getPins();
		}
		return bonus;
	}

}
