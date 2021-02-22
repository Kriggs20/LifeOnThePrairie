package prairieLife;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Kyle Riggs
 */
public class GrassTest {

	@Test
	public void testWho() {
		Plain p = new Plain(3);
		Grass g = new Grass(p, 1, 1);
		
		assertEquals(g.who(), State.EMPTY);
	}

	@Test
	public void testNext() {
		Plain p = new Plain(3);
		Grass g = new Grass(p, 1, 1);
		
		g.next(p);
	}

}
