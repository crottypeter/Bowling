package bowling;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;

public class Bowler {

	private static final int FRAMES_IN_A_GAME = 10;
	private String name;
	private List<Frame> frames;
	private List<Ball> balls;
	private int currentFrame;

	public Bowler(String line) {
		this.name = line;
		this.frames = new LinkedList<Frame>();
		for (int i = 0; i<FRAMES_IN_A_GAME ; i++) {
			frames.add(new Frame());
		}
	}

	public String toString() {
		return String.format("%.20s               %d", name, scoreFromPins());
	}

	public boolean nameMatches(String otherName) {
		return name.equals(otherName);
	}

	public int scoreFromPins() {
		int cumulativeScore = 0;
		for (int i = 0; i<currentFrame ; i++) {
			cumulativeScore += frames.get(i).scoreFromPins();
		}
		return cumulativeScore;
	}

	protected int scoreFromBonuses() {
		int bonuses = 0;
		for (Ball ball : balls) {
			if (ball.isStrike()) {
				bonuses += getBonusAfter(ball, 2);
			}
			if (ball.isSpare()) {
				bonuses += getBonusAfter(ball, 1);
			}
		}
		return bonuses;
	}

	private int getBonusAfter(Ball lastBallFromStrikeFrame, int numberOfBonusBalls) {
		int indexAfterWhichToGetBalls = balls.indexOf(lastBallFromStrikeFrame);
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

	public void bowlFrame(BufferedReader reader) {
		balls.addAll(frames.get(currentFrame).bowl(reader));
		currentFrame++;
	}

}
