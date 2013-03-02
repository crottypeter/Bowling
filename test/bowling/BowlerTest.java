package bowling;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BowlerTest {

	private static final String PLAYER_NAME = "Bob";

	@Mock
	private PrintStream printStreamMock;

	@Test
	public void givenNamedBowler_whenPrint_thenNameIncludedInOutput() {
		Bowler player = new Bowler(PLAYER_NAME);
		player.print(printStreamMock);
		verify(printStreamMock).print(argThat(containsString(PLAYER_NAME)));
	}

}
