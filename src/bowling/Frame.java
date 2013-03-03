package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

	private final int frameNumber;
	private final List<Ball> balls;

	public Frame(int frameNumber) {
		this.frameNumber = frameNumber;
		this.balls = new ArrayList<Ball>();
	}

//	public void bowl(BufferedReader reader) {
//		while (frameIncomplete()) {
//			bowlBall(reader);
//		}
//	}

//	private boolean frameIncomplete() {
//		//TODO handle strikes and final frame.
//		return balls.size() < 2;
//	}

	protected void recordBall(int pins) {
		balls.add(new Ball(pins));
	}

	protected int scoreFromPins() {
		int scoreFromPins = 0;
		for (Ball ball : balls) {
			scoreFromPins += ball.getPins();
		}
		return scoreFromPins;
	}

	//	public void bowlBall(BufferedReader reader) {
//		String line;
//		try {
//			line = reader.readLine().trim();
//		} catch (IOException cause) {
//			throw new RuntimeException(IO_ERROR_MESSAGE, cause);
//		}
//	}
}
