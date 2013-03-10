package bowling;

import java.util.List;

public enum FrameType {

	REGULAR {

		@Override
		public boolean isComplete(List<Ball> balls) {
			if (balls.isEmpty()) {
				return false;
			}
			return balls.get(0).isStrike()
					|| balls.size() == 2;
		}

		@Override
		public boolean scoreAllowed(List<Ball> balls, int newBallValue) {
			if (newBallValue < 0) {
				return false;
			}
			if (balls.isEmpty()) {
				return newBallValue <= 10;
			}
			return balls.get(0).getPins() + newBallValue <= 10;
		}

		@Override
		public Ball makeBall(List<Ball> balls, int pins) {
			if (balls.isEmpty()) {
				return pins == 10 ?
						Ball.strike()
						: Ball.normalBall(pins);
			}
			return balls.get(0).getPins() + pins == 10 ?
					Ball.spare(pins)
					: Ball.normalBall(pins);
		}

	},
	GAME_ENDER {

		@Override
		public boolean isComplete(List<Ball> balls) {
			if (balls.isEmpty() || balls.size() == 1) {
				return false;
			}
			Ball first = balls.get(0);
			Ball second = balls.get(1);
			return (first.isStrike() || second.isSpare()) ?
					balls.size() == 3
					: balls.size() == 2;
		}

		@Override
		public boolean scoreAllowed(List<Ball> balls, int newBallValue) {
			if (newBallValue < 0) {
				return false;
			}
			if (balls.isEmpty()) {
				return newBallValue <= 10;
			}
			Ball mostRecent = balls.get(balls.size() - 1);
			return (mostRecent.isStrike() || mostRecent.isSpare()) ? 
					newBallValue <= 10
					: mostRecent.getPins() + newBallValue <= 10;
		}

		@Override
		public Ball makeBall(List<Ball> balls, int pins) {
			if (balls.isEmpty()) {
				return pins == 10 ?
						Ball.finalFrameStrike()
						: Ball.normalBall(pins);
			}
			Ball mostRecent = balls.get(balls.size() - 1);
			if (mostRecent.isStrike() || mostRecent.isSpare()) {
				return pins == 10 ?
						Ball.finalFrameStrike()
						: Ball.normalBall(pins);
			}
			return mostRecent.getPins() + pins == 10 ?
					Ball.finalFrameSpare(pins)
					: Ball.normalBall(pins);
		}

	};

	public abstract boolean isComplete(List<Ball> balls);

	public abstract boolean scoreAllowed(List<Ball> balls, int newBallValue);

	public abstract Ball makeBall(List<Ball> balls, int pins);

}
