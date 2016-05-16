/**
 * Grid.java
 * @author Logan
 * @author Rayyan
 * @author Ferris
 */

package me.apcs.bomberman;

import java.util.ArrayList;

public class Grid<T extends Inhabitant> {
	//declare fields
	private int rows;
	private int cols;
	private ArrayList<T> tList;
	
	/**
	 * Constructs a <code>Grid</code> object with 10 rows and columns
	 */
	public Grid() {
		//initialize fields
		this.rows = 10;
		this.cols = 10;
		this.tList = new ArrayList<>();
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
		
		//initialize fields
		this.rows = 10;
		this.cols = 10;
		this.tList = new ArrayList<>();
	} //Grid
	
	/**
	 * Gets the number of rows in <code>Grid</code>
	 * 
	 * @return the number of rows in <code>Grid</code>
	 */
	public int getNumRows() {
		return this.rows;
	} //getNumRows
	
	/**
	 * Gets the number of columns in <code>Grid</code>
	 * 
	 * @return the number of columns in <code>Grid</code>
	 */
	public int getNumCols() {
		return this.cols;
	} //getNumCols
	
	/**
	 * Determines if the coordinates of a <code>Location</code> object are in range
	 * 
	 * @param l the <code>Location</code> to be checked for validity
	 * @return <code>true</code> - if <code>l</code>'s coordinates are in range
	 */
	public boolean isValid(Location l) {
		return (l.getIntX() >= 0 && l.getIntX() < getNumRows()) && (l.getIntY() >= 0 && l.getIntY() < getNumCols());
	} //isValid
	
	/**
	 * Adds an object to the <code>Grid</code>
	 * 
	 * @param t the object needing to be added
	 * @return <code>true</code> - if the <code>Grid</code> is successfully changed
	 */
	public boolean add(T t) {
		return this.tList.add(t);
	} //add
	
	/**
	 * Gets all object at a specified <code>Location</code>
	 * 
	 * @param l contains the <code>Location</code> of the object needing to be received
	 * @return the elements at the specified position - if <code>l</code> is valid
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	public ArrayList<T> get(Location l) throws IndexOutOfBoundsException {
		//determine if l is a valid location
		if (isValid(l)) {
			//declare variable
			ArrayList<T> tempList = new ArrayList<>();
			
			//traverse tList, filter out elements, and add remaining elements to tempList
			this.tList.stream().filter(t -> t.getLocation().inSameSquare(l)).forEach(t -> tempList.add(t));
			
			return tempList;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //get
	
	/**
	 * Sets all objects at a specified <code>Location</code> new a new value
	 * 
	 * @param l contains the <code>Location</code> of the object needing to be edited
	 * @param newT the new value to replace the existing one
	 * @return the elements previously at the specified position - if <code>l</code> is valid
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	public ArrayList<T> set(Location l, T newT) throws IndexOutOfBoundsException {
		//determine if l is a valid location
		if (isValid(l)) {
			//declare variable
			ArrayList<T> tempList = new ArrayList<>();
			
			//traverse tList, filter out elements, store old elements in tempList, and set remaining elements to newT
			this.tList.stream().filter(t -> t.getLocation().inSameSquare(l)).forEach(t -> {tempList.add(t); tList.set(tList.indexOf(t), newT);});
			
			return tempList;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //set
	
	/**
	 * Removes all objects at a specific <code>Location</code>
	 * 
	 * @param l contains the <code>Location</code> of the object needing to be removed
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	public void remove(Location l) throws IndexOutOfBoundsException {
		//determine if l is a valid location
		if (isValid(l)) {
			//traverse tList and remove elements with a matching location
			this.tList.removeIf(t -> t.getLocation().inSameSquare(l));
			
			return;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //remove
	
	/**
	 * Removes all objects of a specific <code>Inhabitant</code> type
	 * 
	 * @param i contains the <code>Inhabitant</code> type needing to be removed
	 */
	public void remove(Inhabitant i) {
		//traverse tList and remove elements with a Inhabitant type
		this.tList.removeIf(t -> t.getClass().equals(i.getClass()));
	} //remove
	
	/**
	 * Removes all objects at a specific <code>Location</code> with a specific <code>Inhabitant</code> type
	 * 
	 * @param i contains the <code>Inhabitant</code> type needing to be removed
	 */
	public void remove(Location l, Inhabitant i) {
		//traverse tList and remove elements with a Inhabitant type
		this.tList.removeIf(t -> t.getLocation().inSameSquare(l) && t.getClass().equals(i.getClass()));
	} //remove
	
	/**
	 * Returns a string representation of the contents of a <code>Grid</code> object
	 * 
	 * @return a string of all the elements in the <code>Grid</code>
	 */
	@Override
	public String toString() {
		return this.tList.toString();
	} //toString
}