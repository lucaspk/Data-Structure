package adt;
import exceptions.*;

/**
 * Class of Adt<T> type
 * 
 * @author Jobson Lucas
 * 
 * @version 1.0
 *
 * */
public abstract class Adt<T>  {

	protected T[] array;
	protected int tail, head;
	
	/**
	 * Constructor of supertype Adt<T>  
	 *  
	 * @param size  
	 * 		The size of the Structure. If the size is not greater than zero, 
	 * then will be issued an InvalidSizeException.
	 *  
	 * @throws Exception , InvalidSizeException
	 *  
	 *   
	 *  */		
	public Adt(int size) throws Exception {
		if(size <= 0)
			throw new InvalidSizeException();
		array = (T[])new Object[size];
		tail = -1;
		head = -1;
		
	}
	/**
	 * Add an element to structure without violating capacity restrictions.
	 * If the structure is already full,then will be issued an OverflowException.
	 * On the other hand, if the element is null, then will be issued a 
	 * NullElementException.
	 * 
	 * @param element
	 * 		An element to add in the Structure 
	 *  
	 * @return void
	 *  
	 * @throws OverflowException , NullElementException
	 *  
	 *  */	
	public void add(T element) throws Exception{
		if (isFull())
			throw new OverflowException();
		else if(element == null)
			throw new NullElementException();
		array[++tail] = element;}
	
	/**
	 * Retrieves and remove the peek of the Structure. However,if the
	 * Structure is empty, an UnderflowException will be issued.
	 *  
	 * @return peek
	 * 		Retrieves the peek of the Structure, or UnderflowException 
	 * if the Structure is empty.
	 * 
	 * @throws UnderflowException 
	 *  
	 *  */		
	public abstract T rmv() throws UnderflowException;
	
	/**
	 * Retrieves, without remove, the peek of the Structure. If the Structure 
	 * is empty, then will be issued an UnderflowException.
	 *  
	 * @return peek
	 * 		Retrieves the peek of the Structure, or UnderflowException if the 
	 * Structure is empty.
	 * 
	 * @throws UnderflowException 
	 *  
	 *  */	
	public abstract T peek() throws UnderflowException;
	
	/**
	 * Test if the Structure is empty or not.
	 *  
	 * @return boolean
	 * 		Retrieves true if the Structure is empty, or false otherwise.
	 *  
	 *  */	
	public boolean isEmpty(){
		return tail == -1;}
	
	/**
	 * Test if the Structure is full or not.
	 *  
	 * @return boolean
	 * 		Retrieves true if the Structure is full, or false otherwise.
	 *  
	 *  */	
	public boolean isFull(){
		return tail == array.length-1;
	}
	
	/**
	 * Remove all the elements of the Structure.
	 * 
	 * @return void
	 * 
	 *  */
	public void clear(){
		for (int i = 0; i < array.length; i++) {
			--tail;
		}
	}
	
	/**
	 * An Abstract method to show the string representation of the Structure.
	 * 
	 * @return 
	 * 		String representation of the Stack.
	 * 
	 *  */
	public abstract String toString();
	
	
}
