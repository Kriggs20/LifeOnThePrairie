package prairieLife;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 * @author Kyle Riggs
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with
 * squares inhabited by badgers, foxes, rabbits, grass, or none. 
 *
 */
public class Wildlife 
{
	/**
	 * Update the new plain from the old plain in one cycle. 
	 * @param pOld  old plain
	 * @param pNew  new plain 
	 */
	public static void updatePlain(Plain pOld, Plain pNew)
	{
		for (int i = 0; i < pNew.grid.length; i++) {
			for (int j = 0; j < pNew.grid[i].length; j++) {
				pNew.grid[i][j] = pOld.grid[i][j].next(pNew);
			}
		}
	}
	
	/**
	 * Repeatedly generates plains either randomly or from reading files. 
	 * Over each plain, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		Plain even;   				
		Plain odd;
		int trial = 1;
		int cycles = 0;
		int numPicked = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Simulation of Wildlife of the Plain");
		System.out.println("keys: 1 (random plain) 2 (file input) 3 (exit)");
		
		while (numPicked != 3) {
			cycles = 0;
			numPicked = sc.nextInt();
			
			if (numPicked == 1) {
				System.out.println("Trial " + trial + ":");
				System.out.println("Random plain");
				System.out.print("Enter grid width: ");
				int width = sc.nextInt();
				even = new Plain(width);
				odd = new Plain(width);
				even.randomInit();
				while (cycles == 0) {
					System.out.print("Enter the number of cycles: ");
					cycles = sc.nextInt();
				}
				trial++;
			}
			else if (numPicked == 2) {
				System.out.println("Trial " + trial + ":");
				System.out.println("Plain input from a file");
				System.out.print("File name: ");
				String name = sc.next();
				even = new Plain(name);
				odd = new Plain(name);
				while (cycles == 0) {
					System.out.print("Enter the number of cycles: ");
					cycles = sc.nextInt();
				}
				trial++;
			}
			else {
				break;
			}
			
			System.out.println();
			System.out.println("Initial plain:\n");
			System.out.println(even.toString() + "\n");
			
			for (int i = 1; i <= cycles; i++) {
				if (i % 2 != 0) {
					updatePlain(even, odd);
				}
				else {
					updatePlain(odd, even);
				}
			}
			
			if (cycles % 2 == 0) {
				System.out.println("Final Plain:\n");
				System.out.println(even.toString());
			}
			else {
				System.out.println("Final Plain:\n");
				System.out.println(odd.toString());
			}
		}
		sc.close();
	}
}
		
		
		
		
		