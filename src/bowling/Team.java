package bowling;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

public class Team {

	private final List<Bowler> bowlers;

	public Team(List<Bowler> bowlers) {
		this.bowlers = Collections.unmodifiableList(bowlers);
	}

	public void print(PrintStream out) {
		for (Bowler bowler : bowlers) {
			out.println(bowler.toString());
		}
		out.println(String.format("Team total            %3d | %3d | %3d | %3d | %3d | %3d | %3d | %3d | %3d | %3d",
				teamScoreAtFrame(0),
				teamScoreAtFrame(1),
				teamScoreAtFrame(2),
				teamScoreAtFrame(3),
				teamScoreAtFrame(4),
				teamScoreAtFrame(5),
				teamScoreAtFrame(6),
				teamScoreAtFrame(7),
				teamScoreAtFrame(8),
				teamScoreAtFrame(9)));
	}

	private int teamScoreAtFrame(int frameNumber) {
		int score = 0;
		for (Bowler bowler : bowlers) {
			score += bowler.scoreAtFrame(frameNumber);
		}
		return score;
	}

	public void bowl(PrintStream out, BufferedReader bufferedReader) {
		for (int i = 0; i < 10; i++) {
			bowlFrame(out, bufferedReader);
		}
	}

	private void bowlFrame(PrintStream out, BufferedReader bufferedReader) {
		for (Bowler bowler : bowlers) {
			bowler.bowlFrame(out, bufferedReader);
		}
		print(out);
	}

}
