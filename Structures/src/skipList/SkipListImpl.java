package skipList;

import java.util.*;

public class SkipListImpl<V> implements SkipList<V> {

	protected SkipNode<V> root;
	protected int level;
	protected int maxLevel;

	//SET THIS VALUE TO TRUE IF YOU ARE IMPLEMENTING MAX_LEVEL = LEVEL
	//SET THIS VALUE TO FALSE IF YOU ARE IMPLEMENTING MAX_LEVEL != LEVEL
	protected boolean useMaxLevelAsLevel = false;
	protected double probability = 0.5;
	protected SkipNode<V> NIL;

	public SkipListImpl(int maxLevel) {
		if(useMaxLevelAsLevel){
			this.level = maxLevel;
		}else{
			this.level = 1;
		}
		this.maxLevel = maxLevel;
		root = new SkipNode(Integer.MIN_VALUE, maxLevel, new Integer(Integer.MIN_VALUE));
		NIL = new SkipNode(Integer.MAX_VALUE, maxLevel, new Integer(Integer.MAX_VALUE));
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL
	 * Caso esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com
	 * level=1 e o metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil(){
		root.getForward()[0] = NIL;
	}

	/**
	 * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no metodo
	 * insert(int,V)
	 */
	private int randomLevel(){
		int randomLevel = 1;
		double random = Math.random();
		while(Math.random() <= probability && randomLevel < maxLevel){
			randomLevel = randomLevel + 1;
		}
		return randomLevel;
	}

	@Override
	public void insert(int key, V newValue) {
		insert(key, newValue, randomLevel());
	}

	@Override
	public void insert(int key, V newValue, int height) {
		if (newValue != null && height > 0 && height <= maxLevel) {
			SkipNode[] update = new SkipNode[maxLevel];
			SkipNode<V> node = root;
			for (int i = level - 1; i >= 0; i--) {
				while (node.getForward(i).getKey() < key) {
					node = node.getForward(i);
				}
				update[i] = node;
			}
			node = node.getForward(0);
			if (node.getKey() == key) {
				if (node.height == height)
					node.satteliteData = newValue;
			} else {
				int newLevel = height;
				if (newLevel > level) {
					for (int i = this.level; i < newLevel; i++) {
						update[i] = root;
						// Liga a raiz ao NIL nos niveis que serao adicionados
						// Impede que a altura do root seja null e que seja chamado forward em cima desse null
						root.forward[i] = NIL;
					}
					level = newLevel;
				}
				node = new SkipNode(key, newLevel, newValue);
				for (int i = 0; i < newLevel; i++) {
					node.forward[i] = update[i].forward[i];
					update[i].getForward()[i] = node;
				}
			}
		}
	}

	@Override
	public void remove(int key) {
		if (key != root.getKey() && key != NIL.getKey()) {
			SkipNode<V>[] update = new SkipNode[maxLevel];
			SkipNode<V> x = root;
			for (int i = (level - 1); i >= 0; i--) {
				while (x.forward[i].getKey() < key) {
					x = x.forward[i];
				}

				update[i] = x;
			}
			x = x.forward[0];

			if (x.getKey() == key) {
				for (int i = 0; i < level; i++) {
					if (update[i].getForward(i) != x) {
						break;
					}

					update[i].getForward()[i] = x.getForward(i);
					while (level > 1 && root.forward[level - 1] == NIL) {
						level--;
					}
				}
			}
		}
	}

	@Override
	public int height() {
		int height;
        SkipNode<V> validNode = root.getForward(0);

        for (height = 0; height < level; height++) {
            if (root.forward[height] == NIL) {
                break;
            }
        }

        return height;
	}

	@Override
	public SkipNode<V> search(int key) {
			SkipNode<V> aux = root;
			for (int i = level - 1; i >= 0; i--) {
				while (aux.forward[i].getKey() < key) {
					aux = aux.forward[i];
				}
			}
			aux = aux.forward[0];
			if (aux.key == key)
				return aux;
			return null;
		}

	@Override
	public int size(){
		int size = 0;

        SkipNode<V> currentNode = root.getForward(0);
        while (currentNode != NIL) {
            size++;
            currentNode = currentNode.getForward(0);
        }

        return size;
	}

	@Override
	public SkipNode<V>[] toArray() {
		SkipNode<V>[] array = new SkipNode[size()];

        int i = 0;

        SkipNode<V> currentNode = root.getForward(0);
        while (currentNode != NIL) {
            array[i++] = currentNode;
            currentNode = currentNode.getForward(0);
        }

        return array;
    }

}
