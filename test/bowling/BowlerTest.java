package bowling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public final class BowlerTest {

	private static final String PLAYER_NAME = "Bob";
	private static final String PLAYER_2_NAME = "Alice";
	private Bowler player;

	@Before
	public void setUp() {
		player = new Bowler(PLAYER_NAME);
	}

	@Test
	public void givenNamedBowler_whenPrint_thenNameIncludedInOutput() {
		assertThat(player.toString(), containsString(PLAYER_NAME));
	}

	@Test
	public void givenNamedBowler_whenSameNamePassed_thenTaken() {
		assertThat(player.nameMatches(PLAYER_NAME), is(true));
	}

	@Test
	public void givenNamedBowler_whenOtherNamePassed_thenNotTaken() {
		assertThat(player.nameMatches(PLAYER_2_NAME), is(false));
	}

}
