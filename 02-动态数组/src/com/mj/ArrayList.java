package com.mj;

public class ArrayList {
	// 数组大小
	private int size;
	// 存储空间
	private int[] elements;
	// 默认容量
	private static final int DEFAULT_CAPACITY = 10;
	// 不存在索引值
	private static final int ELEMENT_NOT_FOUND = -1;
	
	/**
	 * 无参构造
	 */
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * 有参构造
	 * @param capacity 容量
	 */
	public ArrayList(int capacity) {
		size = 0;
		capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
		elements = new int[capacity];
	}
	
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}
	
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}
	
	/**
	 * 清除
	 */
	public void clear() {
		size = 0;
	}
	
	/**
	 * 返回数组大小
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 是否包含element
	 * @param element
	 * @return
	 */
	public boolean contains(int element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 添加新元素
	 * @param element
	 */
	public void add(int element) {
//		if (size == elements.length) {
//			// 扩容
//			int[] newElements = new int[elements.length*2];
//			for (int i = 0; i < elements.length; i++) {
//				newElements[i] = elements[i];
//			}
//			elements = newElements;
//		}
//		elements[size] = element;
//		size++;
		
		add(size, element);
	}
	
	/**
	 * 获取下标元素
	 * @param index
	 * @return
	 */
	public int get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	/**
	 * 给下标index赋值element
	 * @param index
	 * @param element
	 * @return
	 */
	public int set(int index, int element) {
		rangeCheck(index);
		int old = elements[index];
		elements[index] = element;
		return old;
	}
	
	/**
	 * 向下标index位置插入元素element
	 * @param index
	 * @param element
	 * @return
	 */
	public void add(int index, int element) {
		rangeCheckForAdd(index);
		if (size == elements.length) {
			// 扩容
			int[] newElements = new int[elements.length*2];
			for (int i = 0; i < elements.length; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
		// index之后的元素后移一位
		for (int i = size-1; i >= index; i--) {
			elements[i+1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	/*
	 * 保证容量
	 */
	protected void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (capacity < oldCapacity) {
			// 扩容
			int[] newElements = new int[oldCapacity*2];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}
			elements = newElements;
		}
	}
	
	/**
	 * 移除下标为index的元素
	 * @param index
	 * @return
	 */
	public int remove(int index) {
		rangeCheck(index);
		int old = elements[index];
		// 后面的元素前移
		for (int i = index+1; i < size; i++) {
			elements[i-1] = elements[i];
		}
		size--;
		return old;
	}
	
	/**
	 * 查找元素的索引
	 * @param element
	 * @return
	 */
	public int indexOf(int element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) {
				return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	/**
	 * 重写打印
	 */
	@Override
	public String toString() {
		// size = 3, [99, 88, 77]
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size = ").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			stringBuilder.append(elements[i]);
			if (i != size-1) {
				stringBuilder.append(", ");
			}
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
