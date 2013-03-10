package bowling;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Bowler {

	private static final int FRAMES_IN_A_GAME = 10;
	private static final int REGULAR_FRAMES_IN_A_GAME = FRAMES_IN_A_GAME - 1;
	private String name;
	private List<Frame> frames;
	private List<Ball> balls;
	private int currentFrame;

	public Bowler(String line) {
		this.name = line;
		this.frames = new ArrayList<Frame>();
		this.balls = new ArrayList<Ball>();
		for (int i = 0; i < REGULAR_FRAMES_IN_A_GAME ; i++) {
			frames.add(Frame.regularFrame());
		}
		frames.add(Frame.gameEndingFrame());
	}

	public String toString() {
		return String.format("%20.20s  %s| %s| %s| %s| %s| %s| %s| %s| %s| %s\n                      %3d | %3d | %3d | %3d | %3d | %3d | %3d | %3d | %3d | %3d",
				name,
				frames.get(0).displayable(),
				frames.get(1).displayable(),
				frames.get(2).displayable(),
				frames.get(3).displayable(),
				frames.get(4).displayable(),
				frames.get(5).displayable(),
				frames.get(6).displayable(),
				frames.get(7).displayable(),
				frames.get(8).displayable(),
				frames.get(9).displayable(),
				scoreAtFrame(0),
				scoreAtFrame(1),
				scoreAtFrame(2),
				scoreAtFrame(3),
				scoreAtFrame(4),
				scoreAtFrame(5),
				scoreAtFrame(6),
				scoreAtFrame(7),
				scoreAtFrame(8),
				scoreAtFrame(9));
	}

	public int scoreAtFrame(int frameNumber) {
		if (balls.isEmpty()) {
			return 0;
		}

		Frame frame = frames.get(frameNumber);
		if (!frame.hasBalls()) {
			return 0;
		}
		Ball lastBallInFrame = frame.getLastBall();
		int score = 0;

		for (Ball ball : balls) {
			score += ball.getPins();
			score += ball.getBonusAfter(balls);
			if (ball == lastBallInFrame) {
				break;
			}
		}

		return score;
	}

	public boolean nameMatches(String otherName) {
		return name.equals(otherName);
	}

	public void bowlFrame(PrintStream out, BufferedReader reader) {
		out.println(String.format("It is the turn of %s", name));
		balls.addAll(frames.get(currentFrame).bowl(out, reader));
		currentFrame++;
	}

}
