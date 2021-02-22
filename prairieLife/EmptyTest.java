package prairieLife;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Kyle Riggs
 */
public class EmptyTest {

	@Test
	public void testWho() {
		
		Plain p = new Plain(3);
		Empty e = new Empty(p, 1, 1);
		
		assertEquals(e.who(), State.EMPTY);
	}

	@Test
	public void testNext() {
		
		Plain p = new Plain(3);
		Empty e = new Empty(p, 1, 1);
		
		e.next(p);
	}

}
