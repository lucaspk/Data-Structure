package adt;

import exceptions.InvalidSizeException;
import exceptions.NullElementException;
import exceptions.OverflowException;
import exceptions.UnderflowException;

/**
 * Class of Adt<T> type
 * @author Lucas
 * @version 1.0
 *
 * */
public abstract class Adt<T>  {

	protected T[] array;
	protected int tail, head;
	
	/**
	 * Constructor of supertype Adt  
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
	 * Add an element to structure. If the structure is already full,then
	 * will be issued an OverflowException. On the other hand, if the element 
	 * is null, then will be issued a NullElementException.
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
	 * Return and remove the peek of the Structure. However,if the
	 * Structure is empty, an UnderflowException will be issued.
	 *  
	 * @return peek
	 * 		Return the peek of the Structure, or UnderflowException 
	 * if the Structure is empty.
	 * 
	 * @throws UnderflowException 
	 *  
	 *  */		
	public abstract T rmv() throws UnderflowException;
	
	/**
	 * Return, without remove, the peek of the Structure. If the Structure 
	 * is empty, then will be issued an UnderflowException.
	 *  
	 * @return peek
	 * 		Return the peek of the Structure, or UnderflowException if the 
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
	 * 		Return true if the Structure is empty and false otherwise.
	 *  
	 *  */	
	public boolean isEmpty(){
		return tail == -1;}
	
	/**
	 * Test if the Structure is full or not.
	 *  
	 * @return boolean
	 * 		Return true if the Structure is full and false otherwise.
	 *  
	 *  */	
	public boolean isFull(){
		return tail == array.length-1;
	}
}
