package bst;

import java.util.ArrayList;
import java.util.List;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected  BSTNode<T> root;
	
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	public void setRoot(BSTNode<T> newroot){
		if (newroot == null) return;
		root = newroot;
	}
	
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return recursiveHeight(getRoot());
	}
	
	private int recursiveHeight(BTNode<T> node) {
		if (node.isEmpty())
	        return -1;
		else
	        return max(recursiveHeight(node.getLeft()), recursiveHeight(node.getRight())) + 1;
	}

	private int max(int a, int b) {
		if (a > b) return a;
		return b;
	}
	
	@Override
	public BSTNode<T> search(T element) {
		if (element == null) return new BSTNode<T>();
		
		BTNode<T> temp = getRoot();
		while (!temp.isEmpty() && !temp.getData().equals(element)) {
			if (element.compareTo(temp.getData()) < 0)
				temp = temp.getLeft();
			else
				temp = temp.getRight();
		}
		
		BSTNode<T> result = new BSTNode<T>();
		copy(result, temp);
		
		return result;
	}

	private void copy(BSTNode<T> a, BTNode<T> b) {
		a.setData(b.getData());
		a.setLeft(b.getLeft());
		a.setRight(b.getRight());
		a.setParent(b.getParent());
	}
	
	@Override
	public void insert(T element) {
		if (element == null || !search(element).isEmpty()) return;
		
		BTNode<T> p = new BSTNode<T>();
		BTNode<T> temp = getRoot();
		BSTNode<T> newNode = new BSTNode<T>();
		
		newNode.setData(element);
		newNode.setLeft(new BTNode<T>());
		newNode.setRight(new BTNode<T>());
		newNode.setParent(new BTNode<T>());
		
		while (!temp.isEmpty()) {
			p = temp;
			if (element.compareTo(temp.getData()) < 0)
				temp = temp.getLeft();
			else
				temp = temp.getRight();
		}
		
		newNode.setParent(p);
		
		if (p.isEmpty())
			setRoot(newNode);
		else {
			if (element.compareTo(p.getData()) < 0)
				p.setLeft(newNode);
			else
				p.setRight(newNode);
		}		
	}

	@Override
	public BSTNode<T> maximum() {
		if (isEmpty()) return null;
		
		BTNode<T> temp = root;
		BSTNode<T> t = new BSTNode<T>();
		
		while (!temp.getRight().isEmpty())
			temp = temp.getRight();
		
		copy(t, temp);
		
		return t;
	}

	@Override
	public BSTNode<T> minimum() {
		if (isEmpty()) return null;
		
		BTNode<T> temp = root;
		BSTNode<T> t = new BSTNode<T>();
		
		while (!temp.getLeft().isEmpty())
			temp = temp.getLeft();
		
		copy(t, temp);
		
		return t;
	}
	
	private BSTNode<T> minimum(BTNode<T> node) {
		if (node.isEmpty()) return null;
		
		BSTNode<T> t = new BSTNode<T>();
		
		while (!node.getLeft().isEmpty())
			node = node.getLeft();
		
		copy(t, node);
		
		return t;
	}
	
	private BSTNode<T> maximum(BTNode<T> node) {
		if (node.isEmpty()) return null;
		
		BSTNode<T> t = new BSTNode<T>();
		
		while (!node.getRight().isEmpty())
			node = node.getRight();
		
		copy(t, node);
		
		return t;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		if (element == null || isEmpty()) return null;
		
		BTNode<T> temp = search(element);
		BSTNode<T> t = new BSTNode<T>();
		
		if (temp.isEmpty()) return null;
		
		if (!temp.getRight().isEmpty())
			return minimum(temp.getRight());
		
		BTNode<T> p = temp.getParent();
		while (!p.isEmpty() && temp.equals(p.getRight())) {
			temp = p;
			p = p.getParent();
		}
		
		copy(t, p);
		
		if (t.isEmpty()) return null;
		return t;		
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		if (element == null || isEmpty()) return null;
		
		BTNode<T> temp = search(element);
		BSTNode<T> t = new BSTNode<T>();
		
		if (temp.isEmpty()) return null;
		
		if (!temp.getLeft().isEmpty())
			return maximum(temp.getLeft());
		
		BTNode<T> p = temp.getParent();
		while (!p.isEmpty() && temp.equals(p.getLeft())) {
			temp = p;
			p = p.getParent();
		}
		
		copy(t, p);
		
		if (t.isEmpty()) return null;
		return t;
	}

	@Override
	public void remove(T element) {
		setRoot(recursiveRemove(getRoot(), element));
	}
	
	private BSTNode<T> recursiveRemove(BTNode<T> node, T elem) {
		if (node.isEmpty()) {} 
		else if (elem.compareTo(node.getData()) < 0)
			node.setLeft(recursiveRemove(node.getLeft(), elem));
		else if (elem.compareTo(node.getData()) > 0)
			node.setRight(recursiveRemove(node.getRight(), elem));
		else {
			if (node.getRight().isEmpty()) {
				node.setData(node.getLeft().getData());
				node.setRight(node.getLeft().getRight());
				node.setLeft(node.getLeft().getLeft());
			}
			else {
				T newe = minimum(node.getRight()).getData();
				node.setData(newe);
				node.setRight(recursiveRemove(node.getRight(), newe));
			}
		}
		BSTNode<T> t = new BSTNode<T>();
		copy(t, node);
		return t;
	}

	@Override
	public T[] preOrder() {
		List<Comparable> list = new ArrayList<>();
		
		recursivePreOrder(getRoot(), list);
		
		return list.toArray((T[]) new Comparable[size()]);
	}

	private void recursivePreOrder(BTNode<T> node, List<Comparable> list) {
		if (!node.isEmpty()) {
			list.add(node.getData());
			recursivePreOrder(node.getLeft(), list);
			recursivePreOrder(node.getRight(), list);
		}
	}

	@Override
	public T[] order() {
		List<Comparable> list = new ArrayList<>();
		
		recursiveOrder(getRoot(), list);
		
		return list.toArray((T[]) new Comparable[size()]);
	}
	
	private void recursiveOrder(BTNode<T> node, List<Comparable> list) {
		if (!node.isEmpty()) {
			recursiveOrder(node.getLeft(), list);
			list.add(node.getData());
			recursiveOrder(node.getRight(), list);
		}
	}

	@Override
	public T[] postOrder() {
		List<Comparable> list = new ArrayList<>();
		
		recursivePostOrder(getRoot(), list);
		
		return list.toArray((T[]) new Comparable[size()]);
	}

	private void recursivePostOrder(BTNode<T> node, List<Comparable> list) {
		if (!node.isEmpty()) {
			recursivePostOrder(node.getLeft(), list);
			recursivePostOrder(node.getRight(), list);
			list.add(node.getData());
		}
	}
	
	@Override
	public int size() {
		return size(root);
	}
	private int size(BTNode<T> node){
		int result = 0;
		if(!node.isEmpty()){
			result = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return result;
	}
}
