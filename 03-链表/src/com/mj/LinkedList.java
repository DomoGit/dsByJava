package com.mj;

@SuppressWarnings("unused")
public class LinkedList<E> {
	private int size;
	private Node<E> first;
	private final static int ELEMENT_NOT_FOUND = -1;
	
	private static class Node<E> {
		E element; // 自己存储的元素
		Node<E> nextNode; // 下一个元素
		
		public Node(E element, Node<E> nextNode) {
			super();
			this.element = element;
			this.nextNode = nextNode;
		}

		@Override
		public String toString() {
			return element.toString();
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
		// 【重要】特殊处理第一个情况
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
		Node<E> deleteNode = first;
		// 【重要】特殊处理第一个情况
		if (index == 0) {
			first = deleteNode != null ? deleteNode.nextNode : null;
		} else {
			Node<E> prev = node(index-1);
			deleteNode = prev.nextNode;
			prev.nextNode = deleteNode.nextNode;
		}
		size--;
		return deleteNode != null ? deleteNode.element : null;
	}
	
	public int indexOf(E element) {
		Node<E> node = first;
		// 【注意】链表可以存 null 的情况
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.nextNode;
			}
		} else {
			for (int i = 0; i < size; i++) {
				// 注意判断相等
				if (node.element.equals(element)) return i;
				node = node.nextNode;
			}
		}
		return ELEMENT_NOT_FOUND;
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

	@Override
	public String toString() {
		Node<E> node = first;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("LinkedList [size=" + size);
		
//		// while 遍历的方式
//		while (node != null) {
//			// do something...
//			node = node.nextNode;
//		}
		
		for (int i = 0; i < size; i++) {
			stringBuffer.append(", index: " + i + " => " + node);
			node = node.nextNode;
		}
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
	
	
}
