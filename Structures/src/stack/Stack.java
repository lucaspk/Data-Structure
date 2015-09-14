package stack;

import exceptions.UnderflowException;
import adt.Adt;

/**
 * Class of Stack<T> type
 * @author Lucas
 * @version 1.0
 *
 * */
public class Stack<T> extends Adt<T> {
	
	/**
	 * Create a Stack with an specific size
	 * 
	 * Use T[] array and int tail from the supertype Adt<T>
	 * 
	 * @param size  
	 * 		The size of the Stack. If the size is not greater than zero, then will be issued an InvalidSizeException.
	 *  
	 * @throws Exception , InvalidSizeException 
	 *  
	 *  */	
	public Stack(int size) throws Exception {
		super(size);
	}
	
	/**
	 * Return and remove the peek of the Stack. However, if
	 * the Stack is empty, an UnderflowException will be issued.
	 *  
	 * @return	peek
	 * 		Return the peek of the Stack, or UnderflowException if the Stack is empty.
	 * 
	 * @throws UnderflowException 
	 *  
	 *  */		
	public T rmv() throws UnderflowException{
		if(isEmpty())
			throw new UnderflowException();
		T aux = array[tail];
		--tail;
		return aux;
		}
	
	/**
	 * Return, without remove, the peek of the Stack. If the Stack is empty, then will be issued an UnderflowException.
	 *  
	 * @return peek
	 * 		Return the peek of the Stack, or UnderflowException if the Stack is empty.
	 * 
	 * @throws UnderflowException 
	 *  
	 *  */	
	public T peek() throws UnderflowException{
		if (isEmpty())
			throw new UnderflowException();
		return array[tail];}
	
	
}
