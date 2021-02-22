package prairieLife;

/**
 * @author Kyle Riggs
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		plain = p;
		row = r;
		column = c;
	}
	
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		int[] lifeForms = new int[5];
		census(lifeForms); 
		
		if (lifeForms[RABBIT] >= (3 * lifeForms[GRASS])) {
			pNew.grid[row][column] = new Empty(pNew, row, column);
		}
		else if(lifeForms[RABBIT] >= 3) {
			pNew.grid[row][column] = new Rabbit(pNew, row, column, 0);
		}
		else {
			pNew.grid[row][column] = new Grass(pNew, row, column);
		}
		return pNew.grid[row][column];
	}
}
