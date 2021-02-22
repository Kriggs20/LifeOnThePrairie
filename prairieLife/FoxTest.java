package prairieLife;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Kyle Riggs
 */
public class FoxTest {

	@Test
	public void testWho() {
		
		Plain p = new Plain(3);
		Fox f = new Fox(p, 1, 1, 0);
		
		assertEquals(f.who(), State.FOX);
	}

	@Test
	public void testNext() {
		
		Plain p = new Plain(3);
		Fox f = new Fox(p, 1, 1, 0);
		
		f.next(p);
	}

}
