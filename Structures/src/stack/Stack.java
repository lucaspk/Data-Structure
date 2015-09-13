package stack;

import adt.Adt;

/**
 * Class of Stack<T> type
 * @author Lucas
 * @version 1.0
 *
 * */
public class Stack<T> extends Adt<T> {
	/**
	 * 	Create a Stack with an specific size
	 * 
	 * 	Use T[] array and int tail from the supertype Adt<T>
	 * 
	 *  @param size  
	 *  		The size of the Stack
	 *  
	 *  */	
	public Stack(int size) {
		super(size);
	}
	
	
	/**
	 * 	Return and remove the peek of the Stack; null if the Stack is empty.
	 *  
	 *  @return	peek
	 *  		Return the peek of the Stack, or null if the Stack is empty.
	 *  
	 *  */		
	public T rmv(){
		if(isEmpty())
			return null;
		T aux = array[tail];
		--tail;
		return aux;
		}
	
	
	/**
	 * 	Return, without remove, the peek of the Stack; null if the Stack is empty.
	 *  
	 *  @return	peek
	 *  		Return the peek of the Stack, or null if the Stack is empty.
	 *  
	 *  */	
	public T peek(){
		if (!isEmpty())
			return array[tail];
		return null;}
	
	
}
