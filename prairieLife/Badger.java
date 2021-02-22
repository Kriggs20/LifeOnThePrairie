package prairieLife;

/**
 * @author Kyle Riggs
 */

/**
 * A badger eats a rabbit and competes against a fox.
 */
public class Badger extends Animal 
{
	/**
	 * Constructor
	 * 
	 * @param p: plain
	 * @param r: row position
	 * @param c: column position
	 * @param a: age
	 */
	public Badger(Plain p, int r, int c, int a)
	{
		plain = p;
		row = r;
		column = c;
		age = a; 
	}

	/**
	 * A badger occupies the square.
	 */
	public State who() 
	{
		return State.BADGER;
	}

	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a
	 * group of foxes.
	 * 
	 * @param pNew plain of the next cycle
	 * @return Living life form occupying the square in the next cycle.
	 */
	public Living next(Plain pNew) 
	{
		int[] lifeForms = new int[5];
		census(lifeForms);
		
		if (myAge() == BADGER_MAX_AGE) {
			pNew.grid[row][column] = new Empty(pNew, row, column);
		}
		else if(lifeForms[BADGER] == 1 && lifeForms[FOX] > 1) {
			pNew.grid[row][column] = new Fox(pNew, row, column, 0);
		}
		else if((lifeForms[BADGER] + lifeForms[FOX]) > lifeForms[RABBIT]) {
			pNew.grid[row][column] = new Empty(pNew, row, column);
		}
		else {
			age++;
			pNew.grid[row][column] = new Badger(pNew, row, column, myAge());
		}
		return pNew.grid[row][column];
	}
}
