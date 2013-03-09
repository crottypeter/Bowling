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
		out.println(teamScore());
	}

	private int teamScore() {
		int score = 0;
		for (Bowler bowler : bowlers) {
			score += bowler.scoreFromPins();
		}
		return score;
	}

	public void bowl(PrintStream out, BufferedReader bufferedReader) {
		for (Bowler bowler : bowlers) {
			bowler.bowlFrame(bufferedReader);
		}
		print(out);
	}

}
