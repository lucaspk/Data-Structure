package adt;

public abstract class Adt<T> {

	protected T[] array;
	protected int tail;
	
	public Adt(int size) {
		array = (T[])new Object[size];
		tail = -1;
	}
	/**
	 * 	Add an element to Structure
	 * 
	 *  @param element
	 *   	  	An element to add in the Structure 
	 *  
	 *  @return	void
	 *  
	 *  */	
	public void add(T element){
		if (isFull() || element == null)
			return;
		array[++tail] = element;}
	
	/**
	 * 	Return and remove the peek of the Structure; null if the Structure is empty.
	 *  
	 *  @return	peek
	 *  		Return the peek of the Structure, or null if the Structure is empty.
	 *  
	 *  */		
	public abstract T rmv();
	
	/**
	 * 	Return, without remove, the peek of the Structure; null if the Structure is empty.
	 *  
	 *  @return	peek
	 *  		Return the peek of the Structure, or null if the Structure is empty.
	 *  
	 *  */	
	public abstract T peek();
	
	/**
	 * 	Test if the Queue is empty or not.
	 *  
	 *  @return	boolean
	 *  		Return true if the Queue is empty and false otherwise.
	 *  
	 *  */	
	public boolean isEmpty(){
		return tail == -1;}
	
	/**
	 * 	Test if the Queue is full or not.
	 *  
	 *  @return	boolean
	 *  		Return true if the Queue is full and false otherwise.
	 *  
	 *  */	
	public boolean isFull(){
		return tail == array.length-1;
	}
}
