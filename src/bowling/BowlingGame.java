package bowling;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BowlingGame {

	public static void main(String[] args) {
		System.out.println("Welcome to Ten-Pin Bowling.");
		new BowlingGame().play();
	}

	private void play() {
		//get players
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Team team = new TeamFactory().getTeam(System.out, bufferedReader);
		team.print(System.out);
		//play game
		team.bowl(System.out, bufferedReader);
		//print winner
	}

}
