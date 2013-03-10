package bowling;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class FrameTest {

	@Test
	public void givenStrike_thenScoreFromPinsIsTen() {
		Frame frame = Frame.regularFrame();
		frame.recordBall(10);
		assertThat(frame.scoreFromPins(), equalTo(10));
	}

	@Test
	public void givenSpare_thenScoreFromPinsIsTen() {
		Frame frame = Frame.regularFrame();
		frame.recordBall(3);
		frame.recordBall(7);
		assertThat(frame.scoreFromPins(), equalTo(10));
	}

	@Test
	public void givenSingleBall_thenScoreFromPinsMatched() {
		Frame frame = Frame.regularFrame();
		frame.recordBall(4);
		assertThat(frame.scoreFromPins(), equalTo(4));
	}

	@Test
	public void givenTwoBalls_thenScoreFromPinsMatched() {
		Frame frame = Frame.regularFrame();
		frame.recordBall(4);
		frame.recordBall(3);
		assertThat(frame.scoreFromPins(), equalTo(4 + 3));
	}

}
