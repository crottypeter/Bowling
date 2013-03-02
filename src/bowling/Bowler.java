package bowling;

import java.io.PrintStream;

public class Bowler {

	private String name;

	public Bowler(String line) {
		this.name = line;
	}

	public void print(PrintStream out) {
		out.print(name);
	}
}
