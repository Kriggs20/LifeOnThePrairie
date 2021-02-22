package prairieLife;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Kyle Riggs
 */
public class BadgerTest {

	@Test
	public void testWho() {
		Plain p = new Plain(3);
		Badger b = new Badger(p, 1, 1, 0);
		
		assertEquals(b.who(), State.BADGER);
	}

	@Test
	public void testNext() { //?
		Plain p = new Plain(3);
		Badger b = new Badger(p, 1, 1, 0);
		
		b.next(p);
	}
}
