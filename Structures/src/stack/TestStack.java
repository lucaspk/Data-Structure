package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// testes precisam ser ajustados para as modificacoes

/**
 * Cases of tests:
 * 
 * 1) Initial methods
 * 
 * 		1.1) Test isEmpty == True
 * 
 * 		1.2) Test isFull == False
 * 
 * 		1.3) Test peek == null
 * 
 * 2) Add an element
 * 
 * 3) Initial methods
 * 
 * 		3.1) Test isEmpty == False
 * 
 * 		3.2) Test isFull == False
 * 
 * 		3.3) Test peek == element
 * 
 * 4) Remove the add element
 * 
 * 5) Initial methods
 * 
 * 		5.1) Test isEmpty == True
 * 
 * 		5.2) Test isFull == False
 * 
 * 		5.3) Test peek == null
 * 
 * 6) Add some elements, but without fill the entire Stack
 * 
 * 7) Initial methods
 * 
 * 		7.1) Test isEmpty == False
 * 
 * 		7.2) Test isFull == False
 * 
 * 		7.3) Test peek == the most recent element added
 * 
 * 8) Fill the Stack
 * 
 * 9) Initial methods
 * 
 * 		9.1) Test isEmpty == False
 * 
 * 		9.2) Test isFull == True
 * 
 * 		9.3) Test peek == the oldest element added
 * 
 * 10) Remove all the elements
 * 
 * 11) Initial methods
 * 
 * 		11.1) Test isEmpty == True
 * 
 * 		11.2) Test isFull == false
 * 
 * 		11.3) Test peek == null
 * 
 * 12) Try to remove with the Stack empty e verify the peek
 * 
 * 13) Try to add with Stack fill e verify the peek
 * 
 *  */


public class TestStack {
	
	private Stack<Object> f1,f2, f3;
	
	@Before
	public void criaObjetos() throws Exception{
		f1 = new Stack(5);
		f2 = new Stack(8);
		f3 = new Stack(2);
	}
	
	@Test
	public void testaTd() throws Exception{
		
		/**
		 * Testa f3
		 * 
		 *  */
		
		// Teste 1
		Assert.assertTrue(f3.isEmpty());		
		Assert.assertFalse(f3.isFull());
		Assert.assertEquals(null, f3.peek());
		
		// Teste 2
		f3.add(5);
		
		// Teste 3
		Assert.assertFalse(f3.isEmpty());		
		Assert.assertFalse(f3.isFull());
		Assert.assertEquals(5, f3.peek());
		
		// Teste 4
		f3.rmv();
		
		// Teste 5
		Assert.assertTrue(f3.isEmpty());		
		Assert.assertFalse(f3.isFull());
		Assert.assertEquals(null, f3.peek());
		
		// Teste 8
		f3.add(5);
		f3.add(15);
		
		// Teste 9
		Assert.assertFalse(f3.isEmpty());		
		Assert.assertTrue(f3.isFull());
		Assert.assertEquals(15, f3.peek());
		
		// Teste 10
		f3.rmv();
		f3.rmv();
		
		// Teste 11
		Assert.assertTrue(f3.isEmpty());		
		Assert.assertFalse(f3.isFull());
		Assert.assertEquals(null, f3.peek());
		
		// Teste 12
		Assert.assertEquals(null, f3.peek());
		Assert.assertEquals(null, f3.rmv());
		Assert.assertEquals(null, f3.peek());
		
		// Teste 13
		f3.add(5);
		f3.add(2);
		f3.add(25);
		f3.add(254);
		Assert.assertEquals(2, f3.peek());				
		

		/**
		 * Testa f2
		 * 
		 *  */
		f2.add(1);
		f2.add(2);
		f2.add(3);		
		Assert.assertEquals(3, f2.peek());
		f2.rmv();
		Assert.assertEquals(2, f2.peek());
		f2.rmv();
		Assert.assertEquals(1, f2.peek());
		

	}
	
 	
}
