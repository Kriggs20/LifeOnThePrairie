package prairieLife;

/**
 * @author Kyle Riggs
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner; 

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		
		File f = new File(inputFileName);
		Scanner sc = new Scanner(f);
		Scanner scan = new Scanner(f);
		String firstLine = sc.nextLine();
		
		for (int i = 0; i < firstLine.length(); i++) {
			if (Character.isAlphabetic(firstLine.charAt(i))) {
				width++;
			}
		}
		
		grid = new Living[width][width];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				String cell = scan.next();
				if (cell.charAt(0) == 'B') {
					grid[i][j] = new Badger(this, i, j, Character.getNumericValue(cell.charAt(1)));
				}
				else if (cell.charAt(0) == 'F') {
					grid[i][j] = new Fox(this, i, j, Character.getNumericValue(cell.charAt(1)));
				}
				else if (cell.charAt(0) == 'R') {
					grid[i][j] = new Rabbit(this, i, j, Character.getNumericValue(cell.charAt(1)));
				}
				else if (cell.charAt(0) == 'G') {
					grid[i][j] = new Grass(this, i, j);
				}
				else if (cell.charAt(0) == 'E') {
					grid[i][j] = new Empty(this, i, j);
				}
				else {
				}
			}
		}
		sc.close();
		scan.close();
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		grid = new Living[w][w];
	}
	
	
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random();
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int randNum = generator.nextInt(5);
				if (randNum == 0) {
					grid[i][j] = new Badger(this, i, j, 0);
				}
				else if (randNum == 1) {
					grid[i][j] = new Fox(this, i ,j, 0);
				}
				else if (randNum == 2) {
					grid[i][j] = new Rabbit(this, i ,j, 0);
				}
				else if (randNum == 3) {
					grid[i][j] = new Grass(this, i ,j);
				}
				else if (randNum == 4) {
					grid[i][j] = new Empty(this, i ,j);
				}
			}
		}		
	}
			
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String result = "";
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j].who() == State.BADGER) {
					result += "B" + ((Animal) grid[i][j]).myAge();
				}
				
				else if (grid[i][j].who() == State.FOX) {
					result += "F" + ((Animal) grid[i][j]).myAge();
				}
				
				else if (grid[i][j].who() == State.RABBIT) {
					result += "R" + ((Animal) grid[i][j]).myAge();
				}
				
				else if (grid[i][j].who() == State.GRASS) {
					result += "G ";
				}
				
				else if (grid[i][j].who() == State.EMPTY) {
					result += "E ";
				}
				
				result += " ";
			}
			
			if (i < grid.length - 1) {
				result += "\n";
			}
			else {
			}
		}
		return result;
	}
	
	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		File f = new File(outputFileName);
		PrintWriter result = new PrintWriter(f);
		
		result.println(toString());
		
		result.close();
	}			
}
