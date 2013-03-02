package bowling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class TeamFactory {
	private static final String IO_ERROR_MESSAGE = "Something terrible happened when receiving player names. Unfortunately your game is lost.";

	public Team getTeam(PrintStream out, BufferedReader reader) {
		String line;
		List<Bowler> bowlers = new LinkedList<Bowler>();
		while (true) {
			out.println("Please enter a player name (Press enter to finish).");
			try {
				line = reader.readLine().trim();
			} catch (IOException cause) {
				throw new RuntimeException(IO_ERROR_MESSAGE, cause);
			}
			if (nameTaken(bowlers, line)) {
				out.println("That name is taken.");
				continue;
			}
			if (line.isEmpty()) {
				return new Team(bowlers);
			}
			bowlers.add(new Bowler(line));
		}
	}

	private boolean nameTaken(List<Bowler> bowlers, String newName) {
		for (Bowler bowler : bowlers) {
			if (bowler.nameMatches(newName)) {
				return true;
			}
		}
		return false;
	}
}
