package bowling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class BallTest {

	private static final int FOUR = 4;

	@Test
	public void givenBall_whenPinsSet_thenPinsValueMatches() {
		Ball ball = new Ball(FOUR);
		assertThat(ball.getPins(), is(equalTo(FOUR)));
	}

}
