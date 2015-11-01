package skipList;

import java.util.*;

import org.junit.*;

/**
 * Cenarios de testes
 * 
 * 1 - Testar insert
 * 2 - Testar remove
 * 3 - Testar search
 * 4 - Testar size
 * 5 - Testar height
 * 6 - Testar toArray
 *  
 *  */

public class TestesSkipList {
	
	private SkipListImpl<Integer> sl;
	private SkipListImpl<Integer> sl1;
	private SkipListImpl<Integer> sl2;
	private SkipNode<Integer> n1;
	private SkipNode<Integer> n2;
	private SkipList<Integer> lista;
	private SkipList<Integer> lista2;
	private SkipNode<Integer> root, NIL;
	
	@Before
	public void criaObjetos(){
		sl = new SkipListImpl<Integer>(15);
		sl1 = new SkipListImpl<Integer>(20);
		sl2 = new SkipListImpl<Integer>(10);
		n1 = new SkipNode<Integer>(96, 11, 6);
		n2 = new SkipNode<Integer>(52, 3, 9);
		lista = new SkipListImpl<Integer>(3);
		lista2 = new SkipListImpl<Integer>(6);
		root = new SkipNode(Integer.MIN_VALUE, 6, Integer.MIN_VALUE);
		NIL = new SkipNode(Integer.MAX_VALUE, 6, Integer.MAX_VALUE);
		sl1.insert(7,8);
		sl1.insert(5,4);
		sl1.insert(6,1);
		sl1.insert(91,2);
	}
	
	@Test
	public void testaInsertAndSearchAndSize(){
		
		//estrutura inicialmente vazia
		Assert.assertEquals(0, sl.size());
		//Insiro o primeiro elemento
		sl.insert(5,8);
		//Asseguro que o tamanho deve ter aumentado
		Assert.assertEquals(1, sl.size());
		//Insiro elemento
		sl.insert(7,6);
		//Asseguro que o tamanho deve ter aumentado
		Assert.assertEquals(2, sl.size());
		//Insiro elemento
		sl.insert(6,5);
		//Asseguro que o tamanho deve ter aumentado
		Assert.assertEquals(3, sl.size());
		//Insiro elemento
		sl.insert(n1.getKey(), n1.satteliteData, n1.height);
		//Asseguro que o tamanho deve ter aumentado
		Assert.assertEquals(4, sl.size());
		
		//Busca key de um elemento da estrutura
		Assert.assertEquals(7,sl.search(7).key);
		Assert.assertEquals(96,sl.search(n1.getKey()).key);
		
		//Busca key de um elemento da estrutura e capturo seu height
		Assert.assertEquals(11,sl.search(n1.getKey()).height);
		
		//Busca key de um elemento da estrutura e capturo seu satteliteData 
		Assert.assertSame(6,sl.search(n1.getKey()).satteliteData);
	}
	
	@Test
	public void testaSearchAndRemoveAndSize(){
		
		//A estrutura esta, inicialmente, com 4 elementos.
		Assert.assertEquals(4, sl1.size());
		
		//Busca key de um elemento da estrutura
		Assert.assertEquals(7,sl1.search(7).key);
		
		//Remover elemento passado como parametro
		sl1.remove(7);
		
		//Asseguro que o tamanho deve ter diminuido
		Assert.assertEquals(3, sl1.size());
		
		//Busca key do elemento removido da estrutura
		Assert.assertEquals(null,sl1.search(7));
		
		//Removo todos os outros elementos da estrutura
		sl1.remove(5);
		sl1.remove(6);
		sl1.remove(91);
		
		//Asseguro que o tamanho deve ter diminuido para 0
		Assert.assertEquals(0, sl1.size());
		
		//Pesquisar pelos elementos removidos
		Assert.assertEquals(null,sl1.search(5));
		Assert.assertEquals(null,sl1.search(6));
		Assert.assertEquals(null,sl1.search(91));
		
	}
	@Test
	public void testaHeight(){
		
		//Inserir alguns elementos na estrutura
		sl2.insert(17,8,9);
		sl2.insert(7,1,6);
		sl2.insert(5,8,3);
		//Assegurar que o size aumentou
		Assert.assertEquals(3, sl2.size());
		//Assegurar que o maior height da estrutura, dos elementos add, eh o 9
		Assert.assertEquals(9, sl2.height());
		//Removendo a key 17
		sl2.remove(17);
		//O maior height passa a ser 6
		Assert.assertEquals(6, sl2.height());
		//Removendo a key 7
		sl2.remove(7);
		//O maior height passa a ser 3
		Assert.assertEquals(3, sl2.height());
		//Removendo a key 5
		sl2.remove(5);
		//Estrutura vazia : height deve ser 0
		Assert.assertEquals(0, sl2.height());
	}

	@Test
	public void basicTest() {
		Assert.assertTrue(lista.size() == 0);
		Assert.assertTrue(lista.height() == 0);
		
		lista.insert(4, 4, 1);
		Assert.assertTrue(lista.size() == 1);
		Assert.assertTrue(lista.height() == 1);
		
		lista.insert(5, 5, 1);
		Assert.assertTrue(lista.size() == 2);
		Assert.assertTrue(lista.height() == 1);
		
		lista.insert(1, 1, 2);
		Assert.assertTrue(lista.size() == 3);
		Assert.assertTrue(lista.height() == 2);
		

		Assert.assertTrue(lista.search(1).key == 1);
		Assert.assertTrue(lista.search(5).key == 5);
		Assert.assertTrue(lista.search(9) == null);
		
		lista.insert(9, 9, 4);
		Assert.assertTrue(lista.size() == 3);
		
		lista.insert(9, 9, 3);
		Assert.assertTrue(lista.size() == 4);
		Assert.assertTrue(lista.search(9).key == 9);
		
		System.out.println(Arrays.toString(lista.toArray()));
		System.out.println("*Deve conter 1 com 2 niveis, 4 com 1 nível, 5 com um nível, 9 com 3 niveis, além de ROOT e NIL");
		
		lista.remove(10);
		Assert.assertTrue(lista.size() == 4);
		Assert.assertTrue(lista.height() == 3);
		
		
		lista.remove(9);
		Assert.assertTrue(lista.size() == 3);
		Assert.assertTrue(lista.height() == 2);
		
		lista.remove(1);
		Assert.assertTrue(lista.size() == 2);
		Assert.assertTrue(lista.height() == 1);
		
		lista.remove(4);
		Assert.assertTrue(lista.height() == 1);
		lista.remove(5);
		Assert.assertTrue(lista.size() == 0);
		Assert.assertTrue(lista.height() == 0);
		
		System.out.println(Arrays.toString(lista.toArray()));
		System.out.println("**Deve conter ROOT e NIL apenas");
	}
	
	@Test
	public void testeMoreHard(){
		lista2.insert(5, 5, 1);
		lista2.insert(3, 3, 2);
		lista2.insert(0, 0, 5);
		lista2.insert(4, 4, 3);
		lista2.insert(4, 4, 6);
		Assert.assertTrue(lista2.size() == 4);
		Assert.assertTrue(lista2.height() == 5);
		lista2.insert(4, 4, 7);
		Assert.assertTrue(lista2.size() == 4);
		Assert.assertTrue(lista2.height() == 5);
		lista2.insert(7, null, 5);
		Assert.assertTrue(lista2.size() == 4);
		Assert.assertTrue(lista2.height() == 5);
		lista2.insert(7, 7, -1);
		Assert.assertTrue(lista2.size() == 4);
		Assert.assertTrue(lista2.height() == 5);
		lista2.insert(10, 10, 6);
		Assert.assertTrue(lista2.size() == 5);
		Assert.assertTrue(lista2.height() == 6);
		lista2.remove(5);
		Assert.assertTrue(lista2.size() == 4);
		Assert.assertTrue(lista2.height() == 6);
		lista2.remove(10);
		Assert.assertTrue(lista2.size() == 3);
		Assert.assertTrue(lista2.height() == 5);
		lista2.remove(Integer.MAX_VALUE);
		lista2.remove(Integer.MIN_VALUE);
		Assert.assertTrue(lista2.size() == 3);
		Assert.assertTrue(lista2.height() == 5);
		
		lista2.remove(0);
		Assert.assertTrue(lista2.size() == 2);
		Assert.assertTrue(lista2.height() == 3);
		
		lista2.remove(-27);
		Assert.assertTrue(lista2.size() == 2);
		Assert.assertTrue(lista2.height() == 3);
		
		Assert.assertTrue(lista2.search(Integer.MAX_VALUE).equals(NIL));
		//Assert.assertTrue(lista2.search(Integer.MIN_VALUE).getKey() == root.getKey());
		
		System.out.println(Arrays.toString(lista2.toArray()));
		System.out.println("***Deve conter 3, com dois niveis, 4, com três niveis, além de ROOT e NIL");
		
	}
	
}
