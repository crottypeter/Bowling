package bowling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Frame {

	private final List<Ball> balls;
	private final FrameType type;

	private static final String IO_ERROR_MESSAGE = "Something terrible happened when receiving a score. Unfortunately your game is lost.";

	public static Frame regularFrame() {
		return new Frame(FrameType.REGULAR);
	}

	public static Frame gameEndingFrame() {
		return new Frame(FrameType.GAME_ENDER);
	}

	private Frame(FrameType type) {
		this.type = type;
		this.balls = new ArrayList<Ball>();
	}

	public Collection<? extends Ball> bowl(PrintStream out, BufferedReader reader) {
		while (frameIncomplete()) {
			bowlBall(out, reader);
		}
		return balls;
	}

	private boolean frameIncomplete() {
		return !type.isComplete(balls);
	}

	protected void recordBall(int pins) {
		balls.add(type.makeBall(balls, pins));
	}

	protected int scoreFromPins() {
		int scoreFromPins = 0;
		for (Ball ball : balls) {
			scoreFromPins += ball.getPins();
		}
		return scoreFromPins;
	}

	public Ball getLastBall() {
		return balls.get(balls.size() - 1);
	}

	public void bowlBall(PrintStream out, BufferedReader reader) {
		Integer newBallValue;
		while (true) {
			out.println("Please provide a score.");
			String line;
			try {
				line = reader.readLine().trim();
			} catch (IOException cause) {
				throw new RuntimeException(IO_ERROR_MESSAGE, cause);
			}
			try {
				newBallValue = Integer.parseInt(line);
			}
			catch (NumberFormatException e) {
				continue;
			}
			if (!type.scoreAllowed(balls, newBallValue)) {
				out.println("That score is not allowed.");
				continue;
			}
			break;
		}
		recordBall(newBallValue);
	}

	public boolean hasBalls() {
		return !balls.isEmpty();
	}

	public String displayable() {
		if (balls.isEmpty()) {
			return "    ";
		}
		if (balls.size() == 1) {
			return String.format(" %s  ", balls.get(0).displayable());
		}
		if (balls.size() == 2) {
			return String.format(" %s%s ", balls.get(0).displayable(), balls.get(1).displayable());
		}
		return String.format(" %s%s%s", balls.get(0).displayable(), balls.get(1).displayable(), balls.get(2).displayable());
	}

}
