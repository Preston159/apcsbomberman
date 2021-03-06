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
	 * @param rows number of rows in the <code>Grid</code>
	 * @param cols number of columns in the <code>Grid</code>
	 * @throws <code>IllegalArgumentException</code> if <code>rows</code> is not in range
	 * @throws <code>IllegalArgumentException</code> if <code>cols</code> is not in range
	 */
	public Grid(int rows, int cols) throws IllegalArgumentException {
		//determine if rows is valid
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		} //end if
		
		//determine if cols is valid
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		} //end if
		
		//initialize fields
		this.rows = rows;
		this.cols = cols;
		this.tList = new ArrayList<>();
	} //Grid
	
	/**
	 * Constructs a <code>Grid</code> object with a specified number of rows and columns and predefined <code>T</code> objects added
	 * 
	 * @param rows number of rows in the <code>Grid</code>
	 * @param cols number of columns in the <code>Grid</code>
	 * @param tList an <code>ArrayList</code> of predefined <code>T</code> objects to be added to the <code>Grid</code>
	 * @throws <code>IllegalArgumentException</code> if <code>rows</code> is not in range
	 * @throws <code>IllegalArgumentException</code> if <code>cols</code> is not in range
	 */
	public Grid(int rows, int cols, ArrayList<T> tList) throws IllegalArgumentException {
		//determine if rows is valid
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		} //end if
		
		//determine if cols is valid
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		} //end if
		
		//initialize fields
		this.rows = rows;
		this.cols = cols;
		this.tList = new ArrayList<>();
		
		//add all the elements from the parameter to the field
		this.tList.addAll(tList);
	} //Grid
	
	/**
	 * Gets the number of rows in the <code>Grid</code>
	 * 
	 * @return the number of rows in the <code>Grid</code>
	 */
	public int getNumRows() {
		return this.rows;
	} //getNumRows
	
	/**
	 * Gets the number of columns in the <code>Grid</code>
	 * 
	 * @return the number of columns in the <code>Grid</code>
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
	 * Gets all objects contained in the <code>Grid</code>
	 * 
	 * @return the elements contained in the <code>Grid</code>
	 */
	public ArrayList<T> getAll() {
		return this.tList;
	} //getAll
	
	/**
	 * Gets the object at a specified index in the <code>Grid</code>
	 * 
	 * @param i contains the index of the object needing to be received
	 * @return the element at the specified position - if <code>i</code> is valid
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>i</code> is not in range
	 */
	public T get(int j) throws IndexOutOfBoundsException {
		//determine if j is in range
		if (j >= 0 && j < this.tList.size()) {
			return this.tList.get(j);
		} //end if
		
		throw new IndexOutOfBoundsException("i is not in range!");
	} //get
	
	/**
	 * Gets all objects at a specified <code>Location</code> in the <code>Grid</code>
	 * 
	 * @param l contains the <code>Location</code> of the object needing to be received
	 * @return the elements at the specified position - if <code>l</code> is valid
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	public ArrayList<T> get(Location l) throws IndexOutOfBoundsException {
		//determine if l is a valid Location
		if (isValid(l)) {
			//declare variable
			ArrayList<T> tempList = new ArrayList<>();
			
			//traverse tList
			for (int j = 0; j < this.tList.size(); j++) {
				//determine if tList element is in the same square
				if (this.tList.get(j).getLocation().inSameSquare(l)) {
					//add tList element to tempList
					tempList.add(this.tList.get(j)); 
				} //end if
			} //end for
			
			return tempList;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //get
	
	/**
	 * Sets all objects at a specified <code>Location</code> to a new value in the <code>Grid</code>
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
			
			//traverse tList
			for (int j = 0; j < this.tList.size(); j++) {
				//determine if tList element is in the same square
				if (this.tList.get(j).getLocation().inSameSquare(l)) {
					//add tList element to tempList
					tempList.add(this.tList.get(j));
					
					//set tList element to newT
					this.tList.set(j, newT);
				} //end if
			} //end for
			
			return tempList;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //set
	
	/**
	 * Removes all objects of a specified <code>Inhabitant</code> type in the <code>Grid</code>
	 * 
	 * @param i contains the <code>Inhabitant</code> type of the objects needing to be removed
	 */
	public void removeAll(Inhabitant i) {
		//traverse tList
		for (int j = 0; j < this.tList.size(); j++) {
			//determine if tList element has a matching Inhabitant type
			if (this.tList.get(j).getClass().equals(i.getClass())) {
				//remove tList element from tList
				this.tList.remove(j);
			} //end if
		} //end for
	} //removeAll
	
	/**
	 * Removes the specified <code>Inhabitant</code> from the </code>Grid</code>
	 * 
	 * @param i the <code>Inhabitant</code> to be removed
	 */
	public void remove(Inhabitant i) {
		//remove i from tList
		this.tList.remove(i);
	} //remove
	
	/**
	 * Removes all objects at a specified <code>Location</code> in the <code>Grid</code>
	 * 
	 * @param l contains the <code>Location</code> of the objects needing to be removed
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	public void remove(Location l) throws IndexOutOfBoundsException {
		//determine if l is a valid location
		if (isValid(l)) {
			//traverse tList
			for (int j = 0; j < this.tList.size(); j++) {
				//determine if tList element is in the same square
				if (this.tList.get(j).getLocation().inSameSquare(l)) {
					//remove tList element from tList
					this.tList.remove(j);
				} //end if
			} //end for
			
			return;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //remove
	
	/**
	 * Removes all objects at a specified <code>Location</code> with a specified <code>Inhabitant</code> type in the <code>Grid</code>
	 * 
	 * @param l contains the <code>Location</code> of the objects needing to be removed
	 * @param i contains the <code>Inhabitant</code> type of the objects needing to be removed
	 * @throws <code>IndexOutOfBoundsException</code> - if <code>l</code>'s coordinates are not in range
	 */
	public void remove(Location l, Inhabitant i) {
		//determine if l is a valid location
		if (isValid(l)) {
			//traverse tList
			for (int j = 0; j < this.tList.size(); j++) {
				//determine if t is in the same square and has a matching Inhabitant type
				if (this.tList.get(j).getLocation().inSameSquare(l) && this.tList.get(j).getClass().equals(i.getClass())) {
					//remove tList element from tList
					this.tList.remove(j);
				} //end if
			} //end for
					
			return;
		} //end if
		
		throw new IndexOutOfBoundsException("Location's coordinates are not in range!");
	} //remove
	
	/**
	 * Creates and returns a copy of this <code>Grid</code>
	 * 
	 * @return a clone of this <code>Grid</code>
	 */
	@Override
	public Grid<T> clone() {
		return new Grid<T>(this.getNumRows(), this.getNumCols(), this.getAll());
	} //clone
	
	/**
	 * Checks to see if the specified <code>Location</code> in the <code>Grid</code> is empty
	 * 
	 * @param l the location to check
	 * @return <code>true</code> - if the location is empty, <code>false</code> otherwise
	 */
	public boolean isEmpty(Location l) {
		//traverse tList
		for (int j = 0; j < this.tList.size(); j++) {
			//determine if tList element is in the same square as l
			if (this.tList.get(j).getLocation().inSameSquare(l)) {
				return false;
			} //end if
		} //end for
		
		return true;
	} //isEmpty
	
	/**
	 * Returns a <code>String</code> representation of the contents of a <code>Grid</code> object
	 * 
	 * @return a <code>String</code> of all the elements in the <code>Grid</code>
	 */
	@Override
	public String toString() {
		return this.tList.toString();
	} //toString
}