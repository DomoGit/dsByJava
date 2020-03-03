package com.mj;

@SuppressWarnings("unused")
public class LinkedList<E> {
	private int size;
	private Node<E> first;
	
	private static class Node<E> {
		E element; // 自己存储的元素
		Node<E> nextNode; // 下一个元素
		
		public Node(E element, Node<E> nextNode) {
			super();
			this.element = element;
			this.nextNode = nextNode;
		}
	}
	
	public LinkedList() {
		size = 0;
		first = null;
	}
	
	public void clear() {
		size = 0;
		first = null;
	}
	
	public int size() {
		return size;
	}
	
	public void add(E element) {
		add(size, element);
	}
	
	public void add(int index, E element) {
		if (index == 0) {
			first = new Node<E>(element, first);
		} else {
			Node<E> prev = node(index - 1);
			prev.nextNode = new Node<E>(element, prev.nextNode);
		}
		size++;
	}
	
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}
	
	public E get(int index) {
		return node(index).element;
	}
	
	public E remove(int index) {
		// todo
		return null;
	}
	
	public int indexOf(E element) {
		// todo
		return 0;
	}
	
	// 返回index索引上的节点【关键！这个函数可以简化其他函数的编写逻辑】
	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}
		return node;
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("索引越界, index: " + index + ", size: " + size);
		}
	}
}
