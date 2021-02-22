package prairieLife;

/**
 * @author
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		plain = p;
		row = r;
		column = c;
		age = a;
	}
		
	/**
	 * Rabbit occupies the square.
	 */
	public State who()
	{  
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * 
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		int[] lifeForms = new int[5];
		census(lifeForms);
		
		if (myAge() == RABBIT_MAX_AGE) {
			pNew.grid[row][column] = new Empty(pNew, row, column);
		}
		else if(lifeForms[GRASS] == 0) {
			pNew.grid[row][column] = new Empty(pNew, row, column);
		}
		else if((lifeForms[BADGER] + lifeForms[FOX]) >= lifeForms[RABBIT] && lifeForms[FOX] > lifeForms[BADGER]) {
			pNew.grid[row][column] = new Fox(pNew, row, column, 0);
		}
		else if (lifeForms[BADGER] > lifeForms[RABBIT]) {
			pNew.grid[row][column] = new Badger(pNew, row, column, 0);
		}
		else {
			age++;
			pNew.grid[row][column] = new Rabbit(pNew, row, column, myAge());
		}
		return pNew.grid[row][column];
	}
}
