/**
 * Grid.java
 * @author Logan Kulinski
 * @author Rayyan Karim
 * @author Ferris
 */

package me.apcs.bomberman;

public class Grid<T> {
	//declare field
	private Object[][] tArr;
	
	public Grid() {
		//initialize tArr
		tArr = new Object[10][10];
	} //Grid
	
	public Grid(int rows, int cols) {
		//determine if rows is valid
		if (rows <= 0) {
			//throw IllegalArgumentException
			throw new IllegalArgumentException("rows <= 0");
		} //end if
		
		//determine if cols is valid
		if (cols <= 0) {
			//throw IllegalArgumentException
			throw new IllegalArgumentException("cols <= 0");
		} //end if
		
		//initialize field
		tArr = new Object[rows][cols];
	} //Grid
}