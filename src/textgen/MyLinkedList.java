package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element )
	{
//		 TODO: Implement this method
		if(element == null){
			throw new NullPointerException();
		}

		LLNode<E> newNode = new LLNode<E>(element, tail.prev, tail);
		tail.prev.next = newNode;
		tail.prev = newNode;
		size++;

		return true;
	}

	/** Get the element at position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.
		return getNodeAtIndex(index).data;
	}

	private LLNode<E> getNodeAtIndex(int index) {

		if (index>=size || index<0) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> node = head.next;
		while (--index >= 0) {
			node = node.next;
		}

		return node;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element )
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException();
		}

		if(index>size || index<0){
			throw new IndexOutOfBoundsException("Out of Bounds");
		}

		if (index == size) {
			this.add(element);
			return;
		}
		LLNode<E> nthNode = getNodeAtIndex(index);
		LLNode<E> theNew = new LLNode<E>(element, nthNode.prev, nthNode);
		nthNode.prev.next = theNew;
		nthNode.prev = theNew;
		size++;
	}


	/** Return the size of the list */
	public int size()
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 *
	 */
	public E remove(int index)
	{
		// TODO: Implement this method

		LLNode<E> nthNode = getNodeAtIndex(index);
		nthNode.next.prev = nthNode.prev;
		nthNode.prev.next = nthNode.next;
		size--;
		return nthNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element)
	{
		// TODO: Implement this method
		if(element == null){
			throw new NullPointerException();
		}

		LLNode<E> nthNode = getNodeAtIndex(index);
		E previousValue = nthNode.data;
		nthNode.data = element;
		return previousValue;
	}
}

class LLNode<E>
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e)
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public LLNode()
	{
		this(null);
	}

	public LLNode(E e, LLNode<E> prev, LLNode<E> next) {
		this.data = e;
		this.prev = prev;
		this.next = next;
	}

}
