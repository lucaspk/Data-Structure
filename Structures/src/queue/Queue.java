package queue;

import adt.Adt;

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
	 *  @param size  
	 *  		The size of the Queue
	 *  
	 *  */	
	public Queue(int size) {
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
	 * 	Return and remove the peek of the Queue; null if the Queue is empty.
	 *  
	 *  @return	peek
	 *  		Return the peek of the Queue, or null if the Queue is empty.
	 *  
	 *  */		
	public T rmv(){
		if(isEmpty())
			return null;
		T tmp = array[0];
		shiftLeft();		
		--tail;
		return tmp;
		}
	
	
	/**
	 * 	Return, without remove, the peek of the Queue; null if the Queue is empty.
	 *  
	 *  @return	peek
	 *  		Return the peek of the Queue, or null if the Queue is empty.
	 *  
	 *  */	
	public T peek(){
		if (!isEmpty())
			return array[0];
		return null;}
	
}
