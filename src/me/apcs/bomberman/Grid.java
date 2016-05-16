/**
 * Grid.java
 * @author Logan
 * @author Rayyan
 * @author Ferris
 */

package me.apcs.bomberman;

import java.util.Arrays;
import java.util.ArrayList;

public class Grid<T> {
	//declare field
	private Object[][] tArr;
	
	/**
	 * Constructs a <code>Grid</code> object with 10 rows and columns
	 */
	public Grid() {
		//initialize field
		this.tArr = new Object[10][10];
	} //Grid
	
	/**
	 * Constructs a <code>Grid</code> object with a specified number of rows and columns
	 * 
	 * @param rows number of rows in <code>Grid</code>
	 * @param cols number of columns in <code>Grid</code>
	 * @throws <code>IllegalArgumentException</code> if <code>rows</code> is not in range
	 * @throws <code>IllegalArgumentException</code> if <code>cols</code> is not in range
	 */
	public Grid(int rows, int cols) throws IllegalArgumentException {
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
		this.tArr = new Object[rows][cols];
	} //Grid
	
	/**
	 * Determines if the coordinates of a <code>Location</code> object are in range
	 * 
	 * @param l the <code>Location</code> to be checked for validity
	 * @return <code>true</code> - if <code>l</code>'s coordinates are in range
	 */
	public boolean isValid(Location l) {
		//determine if l's x coordinate is valid
		if (l.getIntX() >= 0 && l.getIntX() < this.tArr.length) {
			//determine if l's y coordinate is valid
			if (l.getIntY() >= 0 && l.getIntY() < this.tArr[0].length) {
				return true;
			} //end if
		} //end if
		
		return false;
	} //isValid
	
	/**
	 * Adds an object at the next available position
	 * 
	 * @param t the object needing to be added
	 * @return <code>true</code> - if <code>t</code> is successfully added
	 */
	public boolean add(T t) {
		//traverse tArr rows
		for (int i = 0; i < this.tArr.length; i++) {
			//traverse tArr columns
			for (int j = 0; j < this.tArr[0].length; j++) {
				//determine if element is null
				if (this.tArr[i][j] == null) {
					//add t at element position
					this.tArr[i][j] = t;
					
					return true;
				} //end if
			} //end for
		} //end for
		
		return false;
	} //add
	
	/**
	 * Gets an object at a specified <code>Location</code>
	 * 
	 * @param l contains the <code>Location</code> of the object needing to be received
	 * @return the element at the specified position - if <code>l</code> is valid
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	@SuppressWarnings("unchecked")
	public T get(Location l) throws IndexOutOfBoundsException {
		//determine if l is a valid location
		if (isValid(l)) {
			return (T) tArr[l.getIntX()][l.getIntY()];
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //get
	
	/**
	 * Sets an object at a specified <code>Location</code>
	 * 
	 * @param l contains the <code>Location</code> of the object needing to be edited
	 * @param newT the new value to replace the existing one
	 * @return the element previously at the specified position - if <code>l</code> is valid
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	public T set(Location l, T newT) throws IndexOutOfBoundsException {
		//determine if l is a valid location
		if (isValid(l)) {
			//get old value at l
			T oldT = this.get(l);
			
			//set element at l to newT
			tArr[l.getIntX()][l.getIntY()] = newT;
			
			return oldT;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //set
	
	/**
	 * Removes an object at a specified <code>Location</code>
	 * 
	 * @param l contains the <code>Location</code> of the object needing to be removed
	 * @return the element previously at the specified position - if <code>l</code> is valid
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	public T remove(Location l) throws IndexOutOfBoundsException {
		//determine if l is a valid location
		if (isValid(l)) {
			//get old value at l
			T oldT = this.get(l);
					
			//set element at l to null
			tArr[l.getIntX()][l.getIntY()] = null;
					
			return oldT;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //remove
	
	/**
	 * Gets all of the locations that are currently occupied
	 * 
	 * @return an <code>ArrayList</code> of all the occupied locations
	 */
	public ArrayList<Location> getOccupiedLocations() {
		//declare variable
		ArrayList<Location> occupiedLocs = new ArrayList<>();
		
		//traverse tArr rows
		for (int i = 0; i < this.tArr.length; i++) {
			//traverse tArr columns
			for (int j = 0; j < this.tArr[0].length; j++) {
				//determine if location is occupied
				if (tArr[i][j] != null) {
					//add new location to occupiedLocs
					occupiedLocs.add(new Location(i, j));
				} //end if
			} //end for
		} //end for
		
		return occupiedLocs;
	} //getOccupiedLocations
	
	/**
	 * Returns a string representation of the contents of a <code>Grid</code> object
	 * 
	 * @return a string of all the elements in the <code>Grid</code>
	 */
	@Override
	public String toString() {
		return Arrays.toString(tArr);
	} //toString
}