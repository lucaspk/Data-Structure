package queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Casos de teste:
 * 
 * 1) Metodos iniciais
 * 
 * 		1.1) Testar isEmpty == True
 * 
 * 		1.2) Testar isFull == False
 * 
 * 		1.3) Testar peek == null
 * 
 * 2) Add um elemento
 * 
 * 3) Metodos iniciais
 * 
 * 		3.1) Testar isEmpty == False
 * 
 * 		3.2) Testar isFull == False
 * 
 * 		3.3) Testar peek == elemento
 * 
 * 4) Remover o elemento add
 * 
 * 5) Metodos iniciais
 * 
 * 		5.1) Testar isEmpty == True
 * 
 * 		5.2) Testar isFull == False
 * 
 * 		5.3) Testar peek == null
 * 
 * 6) Add alguns elementos, porem, sem preencher toda a fila
 * 
 * 7) Metodos iniciais
 * 
 * 		7.1) Testar isEmpty == False
 * 
 * 		7.2) Testar isFull == False
 * 
 * 		7.3) Testar peek == elemento + antigo add
 * 
 * 8) Add  elementos de modo a preencher a fila
 * 
 * 9) Metodos iniciais
 * 
 * 		9.1) Testar isEmpty == False
 * 
 * 		9.2) Testar isFull == True
 * 
 * 		9.3) Testar peek == elemento + antigo add
 * 
 * 10) Remover todos os elementos
 * 
 * 11) Metodos iniciais
 * 
 * 		11.1) Testar isEmpty == True
 * 
 * 		11.2) Testar isFull == false
 * 
 * 		11.3) Testar peek == null
 * 
 * 12) Tentar remover com Queue vazia e verificar peek
 * 
 * 13) Tentar add com Queue cheia e verificar peek
 *  */


public class TestQueue {
	
	private Queue<Object> f1,f2, f3;
	
	@Before
	public void criaObjetos(){
		f1 = new Queue(5);
		f2 = new Queue(8);
		f3 = new Queue(2);
	}
	
	@Test
	public void testaTd(){
		
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
		Assert.assertEquals(5, f3.peek());
		
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
		Assert.assertEquals(5, f3.peek());				
		
		
		
		
		/**
		 * Testa f2
		 * 
		 *  */
		f2.add(1);
		f2.add(2);
		f2.add(3);		
		Assert.assertEquals(1, f2.peek());
		f2.rmv();
		Assert.assertEquals(2, f2.peek());
		f2.rmv();
		Assert.assertEquals(3, f2.peek());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		/**
//		 * Test if the Queue is Empty
//		 * 
//		 *  */
//		Assert.assertTrue(f2.isEmpty());
//		Assert.assertTrue(f1.isEmpty());
//		
//		/**
//		 * Test if the Queue is Full
//		 * 
//		 *  */
//		Assert.assertFalse(f1.isFull());
//		Assert.assertFalse(f2.isFull());
//		
//		/**
//		 * Test the head of the Queue
//		 * 
//		 *  */
//		Assert.assertEquals(null, f1.peek());
//		Assert.assertEquals(null, f2.peek());
//		
//		/**
//		 * Add elements to the Queue
//		 * 
//		 *  */
//		f1.add(5);
//		f1.add(2);
//		f1.add(25);
//		f1.add(548);
//		f1.add(648);
//		f2.add(5);
//		f2.add(54);
//		
//		
//		/**
//		 * Test the head of the Queue
//		 * 
//		 *  */
//		Assert.assertEquals(5, f1.peek());
//		Assert.assertEquals(5, f2.peek());
//		
//		
//		/**
//		 * Test if the Queue is Empty
//		 * 
//		 *  */
//		Assert.assertFalse(f1.isEmpty());
//		Assert.assertFalse(f2.isEmpty());
//		
//		/**
//		 * Test if the Queue is Full
//		 * 
//		 *  */
//		Assert.assertTrue(f1.isFull());
//		Assert.assertFalse(f2.isFull());
	}
	
 	
}
