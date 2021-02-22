package prairieLife;

/**
 * @author Kyle Riggs
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		int[] lifeForms = new int[5];
		census(lifeForms);
		
		if (lifeForms[RABBIT] > 1) {
			pNew.grid[row][column] = new Rabbit(pNew, row, column, 0);
		}
		else if(lifeForms[FOX] > 1) {
			pNew.grid[row][column] = new Fox(pNew, row, column, 0);
		}
		else if(lifeForms[BADGER] > 1) {
			pNew.grid[row][column] = new Badger(pNew, row, column, 0);
		}
		else if(lifeForms[GRASS] >= 1) {
			pNew.grid[row][column] = new Grass(pNew, row, column);
		}
		else {
			pNew.grid[row][column] = new Empty(pNew, row, column);
		}
		return pNew.grid[row][column];
	}
}
