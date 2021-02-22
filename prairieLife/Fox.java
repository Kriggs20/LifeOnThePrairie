package prairieLife;

 /**
  * @author Kyle Riggs
  */
 
/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		plain = p;
		row = r;
		column = c;
		age = a;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		int[] lifeForms = new int[5];
		census(lifeForms);
		
		if (myAge() == FOX_MAX_AGE) {
			pNew.grid[row][column] = new Empty(pNew, row, column);
		}
		else if(lifeForms[BADGER] > lifeForms[FOX]) {
			pNew.grid[row][column] = new Badger(pNew, row, column, 0);
		}
		else if((lifeForms[BADGER] + lifeForms[FOX]) > lifeForms[RABBIT]) {
			pNew.grid[row][column] = new Empty(pNew, row, column);
		}
		else {
			age++;
			pNew.grid[row][column] = new Fox(pNew, row, column, myAge());
		}
		return pNew.grid[row][column];
	}
}
