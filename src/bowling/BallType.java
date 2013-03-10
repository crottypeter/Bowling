package bowling;

public enum BallType {

	NORMAL {
		@Override
		public String displayable(Ball ball) {
			return String.valueOf(ball.getPins());
		}

		@Override
		public int numberOfBonusBalls() {
			return 0;
		}
	},
	SPARE {
		@Override
		public String displayable(Ball ball) {
			return "/";
		}

		@Override
		public int numberOfBonusBalls() {
			return 1;
		}
	},
	STRIKE {
		@Override
		public String displayable(Ball ball) {
			return "X";
		}

		@Override
		public int numberOfBonusBalls() {
			return 2;
		}
	},
	FINAL_FRAME_SPARE {
		@Override
		public String displayable(Ball ball) {
			return "/";
		}

		@Override
		public int numberOfBonusBalls() {
			return 0;
		}
	},
	FINAL_FRAME_STRIKE {
		@Override
		public String displayable(Ball ball) {
			return "X";
		}

		@Override
		public int numberOfBonusBalls() {
			return 0;
		}
	};

	public abstract String displayable(Ball ball);

	public abstract int numberOfBonusBalls();
}
