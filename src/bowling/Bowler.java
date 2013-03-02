package bowling;

import java.io.PrintStream;

public class Bowler {

	private String name;

	public Bowler(String line) {
		this.name = line;
	}

	public void print(PrintStream out) {
		out.println(name);
	}

	public boolean nameMatches(String otherName) {
		return name.equals(otherName);
	}

	public int score() {
		return 0;
	}

}
