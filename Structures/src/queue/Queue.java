package queue;

import adt.Adt;
import exceptions.*;

/**
 * Class of Queue<T> type
 * @author Lucas
 * @version 1.0
 *
 * */
public class Queue<T> extends Adt<T>{
	
	/**
	 * 	Create a Queue with an specific size 
	 * 	
	 * 	Use T[] array and int tail from the supertype Adt<T>
	 * 
	 *  @param size  
	 *  		The size of the Queue. If the size is not greater than zero,
	 *  		then will be issued an InvalidSizeException.
	 *  
	 *  @throws Exception , InvalidSizeException 
	 *  
	 *  */	
	public Queue(int size) throws Exception {
		super(size);
	}
		
	/**
	 * Auxiliar method to do a swap in the reference of the head in Queue.
	 * 
	 * @return	void
	 * 
	 *  */
	private void shiftLeft(){
		for (int i = 0; i < tail; i++) {
			array[i] = array[i+1];
		}
	}
	
	/**
	 * 	Return and remove the peek of the Queue. However, if
	 * 	the Queue is empty, an UnderflowException will be issued.
	 *  
	 *  @return	peek
	 *  		Return the peek of the Queue, or UnderflowException 
	 *  		if the Queue is empty.
	 * 
	 * 	@throws UnderflowException 
	 *  
	 *  */	
	public T rmv() throws UnderflowException{
		if(isEmpty())
			throw new UnderflowException();
		T aux = array[0];
		shiftLeft();		
		--tail;
		return aux;
		}
	
	/**
	 * 	Return, without remove, the peek of the Queue. If the Queue 
	 * 	is empty, then will be issued an UnderflowException.
	 *  
	 *  @return	peek
	 *  		Return the peek of the Queue, or UnderflowException 
	 *  		if the Queue is empty.
	 * 
	 * 	@throws UnderflowException 
	 *  
	 *  */	
	public T peek() throws UnderflowException{
		if (isEmpty())
			throw new UnderflowException();
		return array[0];}
	
}
