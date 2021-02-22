package prairieLife;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Kyle Riggs
 */
public class AnimalTest {

	@Test
	public void testMyAge() {
		Plain p = new Plain(3);
		Rabbit r = new Rabbit(p, 1, 1, 0);
		Rabbit rabbit = new Rabbit(p, 1, 1, 3);
		
		assertEquals(r.myAge(), 0);
		assertEquals(rabbit.myAge(), 3); //change these numbers and it fails
	}

}
